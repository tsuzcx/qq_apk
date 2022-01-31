package com.tencent.mobileqq.troop.data;

import aipu;
import aipw;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.common.util.HttpUtil;
import com.tencent.mobileqq.activity.TroopNotificationCache;
import com.tencent.mobileqq.app.QQAppInterface;
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
  public static String a;
  public static int b;
  public static String b;
  public static int c;
  public static String c;
  public static int d;
  public static String d;
  public static String e;
  public static String f = "filterID";
  public static String g = "src";
  public int a;
  public Handler a;
  public QQAppInterface a;
  protected TroopFeedItem a;
  public HttpWebCgiAsyncTask.Callback a;
  public Long a;
  public LinkedHashMap a;
  public List a;
  public JSONObject a;
  public JSONObject b;
  
  static
  {
    jdField_a_of_type_JavaLangString = "controlType";
    jdField_b_of_type_JavaLangString = "controlInfo";
    jdField_b_of_type_Int = 1;
    jdField_c_of_type_JavaLangString = "compress";
    jdField_c_of_type_Int = 1;
    jdField_d_of_type_JavaLangString = "validTime";
    e = "needFilter";
    jdField_d_of_type_Int = 1;
  }
  
  public TroopFeedsDataManager(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
    this.jdField_a_of_type_AndroidOsHandler = new aipu(this, Looper.getMainLooper());
    this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback = new aipw(this);
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
    ((Bundle)localObject1).putString("Cookie", "uin=o" + paramQQAppInterface + ";skey=" + (String)localObject2);
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
      ((JSONObject)localObject2).put("carrier", DeviceInfoUtil.e());
      ((JSONObject)localObject2).put("conn", HttpUtil.a());
      ((JSONObject)localObject2).put("c_os", "android");
      ((JSONObject)localObject2).put("c_osver", Build.VERSION.RELEASE);
      ((JSONObject)localObject2).put("datatype", 2);
      ((JSONObject)localObject2).put("c_devicetype", 1);
      paramQQAppInterface = String.format("http://web.qun.qq.com/cgi-bin/announce/get_ad?&cnt=1&ext=%S", new Object[] { URLEncoder.encode(((JSONObject)localObject2).toString()) });
      if (paramQQAppInterface != null)
      {
        localObject2 = new HashMap();
        ((HashMap)localObject2).put("BUNDLE", localObject1);
        ((HashMap)localObject2).put("CONTEXT", paramContext);
        new HttpWebCgiAsyncTask(paramQQAppInterface, "GET", paramCallback, paramInt, null, true).execute(new HashMap[] { localObject2 });
        if (QLog.isColorLevel()) {
          QLog.d("TroopFeedsDataManager", 2, "get requstTroopNotify from server start: " + System.currentTimeMillis());
        }
        return;
      }
    }
    catch (Exception paramQQAppInterface)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("requstTroopNotifyAd", 2, "get ad exera fail, " + paramQQAppInterface);
        }
        paramQQAppInterface = null;
        continue;
        if (QLog.isColorLevel()) {
          QLog.e("requstTroopNotifyAd", 2, "get adURL ERROR empty!!!!");
        }
      }
    }
  }
  
  public TroopFeedItem a()
  {
    List localList = ((TroopManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(51)).a("" + this.jdField_a_of_type_JavaLangLong);
    if (localList == null) {
      return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
    }
    int j = localList.size() - 1;
    label279:
    label422:
    label486:
    label491:
    label496:
    label503:
    for (;;)
    {
      TroopNotificationCache localTroopNotificationCache;
      if (j >= 0)
      {
        localTroopNotificationCache = (TroopNotificationCache)localList.get(j);
        if (localTroopNotificationCache == null) {}
      }
      else
      {
        try
        {
          TroopFeedItem localTroopFeedItem = new TroopFeedItem();
          int i;
          Object localObject;
          TroopFeedsDataManager.ProclamationXmlHandler localProclamationXmlHandler;
          if (localTroopNotificationCache.serviceID == 27)
          {
            localTroopFeedItem.tag = "公告";
            localTroopFeedItem.type = 5;
            i = 0;
            localTroopFeedItem.id = localTroopNotificationCache.feedsId;
            localTroopFeedItem.orginType = localTroopNotificationCache.feedType;
            localTroopFeedItem.feedTime = ("" + localTroopNotificationCache.time);
            localTroopFeedItem.currentUin = localTroopNotificationCache.currentUin;
            localTroopFeedItem.troopUin = ("" + localTroopNotificationCache.troopUin);
            localObject = new ByteArrayInputStream(StructMsgUtils.a(localTroopNotificationCache.xmlBytes, i));
            localProclamationXmlHandler = new TroopFeedsDataManager.ProclamationXmlHandler(this);
            SAXParserFactory.newInstance().newSAXParser().parse((InputStream)localObject, localProclamationXmlHandler);
            ((InputStream)localObject).close();
            if (localTroopNotificationCache.serviceID == 20)
            {
              localTroopFeedItem.title = localProclamationXmlHandler.jdField_a_of_type_JavaLangString;
              localTroopFeedItem.content = "";
              localTroopFeedItem.picPath = localProclamationXmlHandler.jdField_b_of_type_JavaLangString;
              localTroopFeedItem.linkUrl = localProclamationXmlHandler.jdField_d_of_type_JavaLangString;
              if ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem == null) || (localTroopNotificationCache.serviceID == 27)) {
                this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = localTroopFeedItem;
              }
              i = localTroopNotificationCache.serviceID;
              if (i != 27) {
                break label503;
              }
              return this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem;
            }
          }
          else
          {
            if ((localTroopNotificationCache.serviceID != 20) || (localTroopNotificationCache.ctrlStr == null)) {
              break label486;
            }
            localObject = new JSONObject(localTroopNotificationCache.ctrlStr);
            if ((!((JSONObject)localObject).has(jdField_a_of_type_JavaLangString)) || (((JSONObject)localObject).getInt(jdField_a_of_type_JavaLangString) != jdField_b_of_type_Int)) {
              break label496;
            }
            localObject = ((JSONObject)localObject).getJSONObject(jdField_b_of_type_JavaLangString);
            if (((JSONObject)localObject).getInt(jdField_c_of_type_JavaLangString) != jdField_c_of_type_Int) {
              break label491;
            }
            i = 1;
            long l = Long.parseLong(((JSONObject)localObject).getString(jdField_d_of_type_JavaLangString));
            if (MessageCache.a() > l) {
              return null;
            }
          }
          for (;;)
          {
            localTroopFeedItem.tag = "部落精华";
            localTroopFeedItem.type = 133;
            break;
            localTroopFeedItem.title = localTroopNotificationCache.title;
            localTroopFeedItem.content = localProclamationXmlHandler.jdField_c_of_type_JavaLangString;
            break label279;
            i = 0;
            break;
            i = 0;
            break label422;
            i = 0;
          }
          j -= 1;
        }
        catch (Exception localException) {}
      }
    }
  }
  
  public String a(List paramList)
  {
    localJSONArray = new JSONArray();
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
    catch (JSONException paramList)
    {
      return "";
    }
    catch (NumberFormatException paramList)
    {
      return "";
    }
    catch (Exception paramList)
    {
      return "";
    }
  }
  
  public List a(List paramList1, List paramList2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 1;
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null)
    {
      localObject1 = paramList2.iterator();
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
    paramList1 = paramList1.iterator();
    do
    {
      if (paramList1.hasNext())
      {
        localObject1 = (String)paramList1.next();
        if (i > 0) {}
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem = null;
        return localArrayList;
      }
    } while ((this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem != null) && (((String)localObject1).equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqDataTroopFeedItem.id)));
    Object localObject2 = paramList2.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      TroopFeedItem localTroopFeedItem = (TroopFeedItem)((Iterator)localObject2).next();
      if (((String)localObject1).equalsIgnoreCase(localTroopFeedItem.id))
      {
        localArrayList.add(localTroopFeedItem);
        i -= 1;
      }
    }
    for (;;)
    {
      break;
    }
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_AndroidOsHandler != null) {
      this.jdField_a_of_type_AndroidOsHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(String paramString, Integer paramInteger)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, "setTroopNotificationCenterAutoPullDownFlag, troopUin:" + this.jdField_a_of_type_JavaLangLong + ",feedsId:" + paramString + ",status:" + paramInteger);
      }
    } while (paramInteger.intValue() != 1);
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
    ((Bundle)localObject2).putString("qid", "" + this.jdField_a_of_type_JavaLangLong);
    ((Bundle)localObject2).putString("ft", "23");
    ((Bundle)localObject2).putString("bkn", "" + TroopUtils.b(str));
    ((Bundle)localObject2).putString("ni", "1");
    if (paramInt == 1003) {
      ((Bundle)localObject2).putString("is_getinst", "1");
    }
    ((Bundle)localObject2).putString("n", "1");
    ((Bundle)localObject2).putString("i", "1");
    ((Bundle)localObject2).putString("s", "-1");
    ((Bundle)localObject2).putString("log_read", "1");
    ((Bundle)localObject2).putString("Cookie", "uin=o" + (String)localObject1 + ";skey=" + str);
    localObject1 = new HashMap();
    ((HashMap)localObject1).put("BUNDLE", localObject2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication();
    ((HashMap)localObject1).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("http://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", this.jdField_a_of_type_ComTencentMobileqqTroopUtilsHttpWebCgiAsyncTask$Callback, paramInt, null, true).execute(new HashMap[] { localObject1 });
    if (QLog.isColorLevel()) {
      QLog.d("TroopFeedsDataManager", 2, "get recentNote from server start: " + System.currentTimeMillis());
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidOsHandler.sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager
 * JD-Core Version:    0.7.0.1
 */