package com.tencent.mobileqq.troop.data;

import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.TroopFeedItem;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.structmsg.StructMsgUtils;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask.Callback;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Observable;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import mqq.app.MobileQQ;
import mqq.manager.TicketManager;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopFeedsDataManager
  extends Observable
{
  public int a;
  Handler a;
  protected QQAppInterface a;
  protected TroopFeedItem a;
  protected HttpWebCgiAsyncTask.Callback a;
  protected Long a;
  protected LinkedHashMap<String, Integer> a;
  public List<TroopFeedItem> a;
  public JSONObject a;
  protected boolean a;
  public JSONObject b = null;
  
  public TroopFeedsDataManager(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.jdField_a_of_type_OrgJsonJSONObject = null;
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_AndroidOsHandler = new TroopFeedsDataManager.1(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new TroopFeedsDataManager.3(this);
    this.jdField_a_of_type_JavaUtilLinkedHashMap = new LinkedHashMap();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangLong = paramLong;
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, int paramInt, HttpWebCgiAsyncTask.Callback paramCallback)
  {
    Object localObject1 = (TicketManager)paramQQAppInterface.getManager(2);
    paramQQAppInterface = paramQQAppInterface.getCurrentAccountUin();
    Object localObject2 = ((TicketManager)localObject1).getSkey(paramQQAppInterface);
    localObject1 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append(paramQQAppInterface);
    localStringBuilder.append(";skey=");
    localStringBuilder.append((String)localObject2);
    ((Bundle)localObject1).putString("Cookie", localStringBuilder.toString());
    try
    {
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("posid", "8020205751015455");
      ((JSONObject)localObject2).put("adposcount", 1);
      ((JSONObject)localObject2).put("count", 1);
      ((JSONObject)localObject2).put("posw", 100);
      ((JSONObject)localObject2).put("posh", 200);
      ((JSONObject)localObject2).put("uin", paramQQAppInterface);
      ((JSONObject)localObject2).put("muidtype", 1);
      ((JSONObject)localObject2).put("muid", MD5.toMD5(DeviceInfoUtil.a()));
      ((JSONObject)localObject2).put("carrier", DeviceInfoUtil.g());
      ((JSONObject)localObject2).put("conn", HttpUtil.getNetWorkType());
      ((JSONObject)localObject2).put("c_os", "android");
      ((JSONObject)localObject2).put("c_osver", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("datatype", 2);
      ((JSONObject)localObject2).put("c_devicetype", 1);
      paramQQAppInterface = String.format("https://web.qun.qq.com/cgi-bin/announce/get_ad?&cnt=1&ext=%S", new Object[] { URLEncoder.encode(((JSONObject)localObject2).toString()) });
    }
    catch (Exception paramQQAppInterface)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("get ad exera fail, ");
        ((StringBuilder)localObject2).append(paramQQAppInterface);
        QLog.d("requstTroopNotifyAd", 2, ((StringBuilder)localObject2).toString());
      }
      paramQQAppInterface = null;
    }
    if (paramQQAppInterface != null)
    {
      localObject2 = new HashMap();
      ((HashMap)localObject2).put("BUNDLE", localObject1);
      ((HashMap)localObject2).put("CONTEXT", paramContext);
      new HttpWebCgiAsyncTask(paramQQAppInterface, "GET", paramCallback, paramInt, null, true).execute(new HashMap[] { localObject2 });
    }
    else if (QLog.isColorLevel())
    {
      QLog.e("requstTroopNotifyAd", 2, "get adURL ERROR empty!!!!");
    }
    if (QLog.isColorLevel())
    {
      paramContext = new StringBuilder();
      paramContext.append("get requstTroopNotify from server start: ");
      paramContext.append(System.currentTimeMillis());
      QLog.d("TroopFeedsDataManager", 2, paramContext.toString());
    }
  }
  
  public TroopFeedItem a()
  {
    Object localObject1 = (TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangLong);
    localObject1 = ((TroopManager)localObject1).a(((StringBuilder)localObject2).toString());
    if (localObject1 == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    }
    int j = ((List)localObject1).size() - 1;
    while (j >= 0)
    {
      localObject2 = (TroopNotificationCache)((List)localObject1).get(j);
      if (localObject2 != null) {}
      try
      {
        TroopFeedItem localTroopFeedItem = new TroopFeedItem();
        int i = ((TroopNotificationCache)localObject2).serviceID;
        int m = 0;
        int n = 0;
        int k = 0;
        if (i == 27)
        {
          localTroopFeedItem.tag = HardCodeUtil.a(2131715093);
          localTroopFeedItem.type = 5;
          i = n;
        }
        else
        {
          i = n;
          if (((TroopNotificationCache)localObject2).serviceID == 20)
          {
            i = n;
            if (((TroopNotificationCache)localObject2).ctrlStr != null)
            {
              localObject3 = new JSONObject(((TroopNotificationCache)localObject2).ctrlStr);
              i = m;
              if (((JSONObject)localObject3).has("controlType"))
              {
                i = m;
                if (((JSONObject)localObject3).getInt("controlType") == 1)
                {
                  localObject3 = ((JSONObject)localObject3).getJSONObject("controlInfo");
                  i = k;
                  if (((JSONObject)localObject3).getInt("compress") == 1) {
                    i = 1;
                  }
                  long l = Long.parseLong(((JSONObject)localObject3).getString("validTime"));
                  if (MessageCache.a() > l) {
                    return null;
                  }
                }
              }
              localTroopFeedItem.tag = HardCodeUtil.a(2131715094);
              localTroopFeedItem.type = 133;
            }
          }
        }
        localTroopFeedItem.id = ((TroopNotificationCache)localObject2).feedsId;
        localTroopFeedItem.orginType = ((TroopNotificationCache)localObject2).feedType;
        Object localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(((TroopNotificationCache)localObject2).time);
        localTroopFeedItem.feedTime = ((StringBuilder)localObject3).toString();
        localTroopFeedItem.currentUin = ((TroopNotificationCache)localObject2).currentUin;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("");
        ((StringBuilder)localObject3).append(((TroopNotificationCache)localObject2).troopUin);
        localTroopFeedItem.troopUin = ((StringBuilder)localObject3).toString();
        localObject3 = new ByteArrayInputStream(StructMsgUtils.a(((TroopNotificationCache)localObject2).xmlBytes, i));
        TroopFeedsDataManager.ProclamationXmlHandler localProclamationXmlHandler = new TroopFeedsDataManager.ProclamationXmlHandler(this);
        SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject3, localProclamationXmlHandler);
        ((InputStream)localObject3).close();
        if (((TroopNotificationCache)localObject2).serviceID == 20)
        {
          localTroopFeedItem.title = localProclamationXmlHandler.a;
          localTroopFeedItem.content = "";
        }
        else
        {
          localTroopFeedItem.title = ((TroopNotificationCache)localObject2).title;
          localTroopFeedItem.content = localProclamationXmlHandler.c;
        }
        localTroopFeedItem.picPath = localProclamationXmlHandler.b;
        localTroopFeedItem.linkUrl = localProclamationXmlHandler.d;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem == null) || (((TroopNotificationCache)localObject2).serviceID == 27)) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
        }
        i = ((TroopNotificationCache)localObject2).serviceID;
        if (i != 27) {}
      }
      catch (Exception localException)
      {
        label548:
        break label548;
      }
      j -= 1;
    }
    return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
  }
  
  protected String a(List<TroopFeedItem> paramList)
  {
    JSONArray localJSONArray = new JSONArray();
    try
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        TroopFeedItem localTroopFeedItem = (TroopFeedItem)paramList.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("fid", localTroopFeedItem.id);
        localJSONObject.put("mod_time", Long.parseLong(localTroopFeedItem.feedTime));
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (JSONException|NumberFormatException|Exception paramList) {}
    return "";
  }
  
  public List<TroopFeedItem> a(List<String> paramList, List<TroopFeedItem> paramList1)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1;
    Object localObject2;
    int i;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null)
    {
      localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopFeedItem)((Iterator)localObject1).next();
        if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((TroopFeedItem)localObject2).id.equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id))) {
          this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = ((TroopFeedItem)localObject2);
        }
      }
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem);
      i = 0;
    }
    else
    {
      i = 1;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label217;
      }
      localObject1 = (String)paramList.next();
      if (i <= 0) {
        break label217;
      }
      localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
      if ((localObject2 == null) || (!((String)localObject1).equalsIgnoreCase(((TroopFeedItem)localObject2).id)))
      {
        localObject2 = paramList1.iterator();
        if (((Iterator)localObject2).hasNext())
        {
          TroopFeedItem localTroopFeedItem = (TroopFeedItem)((Iterator)localObject2).next();
          if (!((String)localObject1).equalsIgnoreCase(localTroopFeedItem.id)) {
            break;
          }
          localArrayList.add(localTroopFeedItem);
          i -= 1;
        }
      }
    }
    label217:
    this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
    return localArrayList;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_AndroidOsHandler;
    if (localHandler != null) {
      localHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString)
  {
    if (paramString == null) {
      return;
    }
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("qid", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(paramString);
    ((Bundle)localObject2).putString("fid", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str));
    ((Bundle)localObject2).putString("bkn", localStringBuilder.toString());
    ((Bundle)localObject2).putString("ver", "8.7.0");
    ((Bundle)localObject2).putString("platform", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    ((Bundle)localObject2).putString("Cookie", localStringBuilder.toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/announce/get_feed", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getNoticeFromServer start: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      ((StringBuilder)localObject1).append(", feedId: ");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("TroopFeedsDataManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void a(String paramString, Integer paramInteger)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("setTroopNotificationCenterAutoPullDownFlag, troopUin:");
      localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
      localStringBuilder.append(",feedsId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",status:");
      localStringBuilder.append(paramInteger);
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, localStringBuilder.toString());
    }
    if (paramInteger.intValue() != 1) {
      return;
    }
    this.jdField_a_of_type_JavaUtilLinkedHashMap.put(paramString, paramInteger);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(5);
  }
  
  public void b(int paramInt)
  {
    Object localObject2 = (TicketManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(2);
    Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    String str = ((TicketManager)localObject2).getSkey(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    localObject2 = new Bundle();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("qid", localStringBuilder.toString());
    ((Bundle)localObject2).putString("ft", "23");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str));
    ((Bundle)localObject2).putString("bkn", localStringBuilder.toString());
    ((Bundle)localObject2).putString("ni", "1");
    if (paramInt == 1003) {
      ((Bundle)localObject2).putString("is_getinst", "1");
    }
    ((Bundle)localObject2).putString("n", "1");
    ((Bundle)localObject2).putString("i", "1");
    ((Bundle)localObject2).putString("s", "-1");
    ((Bundle)localObject2).putString("log_read", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(AppSetting.a());
    ((Bundle)localObject2).putString("ver", localStringBuilder.toString());
    ((Bundle)localObject2).putString("platform", "1");
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str);
    ((Bundle)localObject2).putString("Cookie", localStringBuilder.toString());
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("getRecentNoticeFromServer start: ");
      ((StringBuilder)localObject1).append(System.currentTimeMillis());
      QLog.d("TroopFeedsDataManager", 2, ((StringBuilder)localObject1).toString());
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager
 * JD-Core Version:    0.7.0.1
 */