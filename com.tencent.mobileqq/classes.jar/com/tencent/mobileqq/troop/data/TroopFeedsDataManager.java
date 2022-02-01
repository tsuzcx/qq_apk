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
  public JSONObject a = null;
  public JSONObject b = null;
  public int c = 0;
  public List<TroopFeedItem> d = Collections.synchronizedList(new ArrayList());
  protected TroopFeedItem e = null;
  protected QQAppInterface f;
  protected Long g;
  protected boolean h = false;
  Handler i = new TroopFeedsDataManager.1(this, Looper.getMainLooper());
  protected HttpWebCgiAsyncTask.Callback j = new TroopFeedsDataManager.3(this);
  protected LinkedHashMap<String, Integer> k = new LinkedHashMap();
  
  public TroopFeedsDataManager(QQAppInterface paramQQAppInterface, Long paramLong)
  {
    this.f = paramQQAppInterface;
    this.g = paramLong;
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
      ((JSONObject)localObject2).put("muid", MD5.toMD5(DeviceInfoUtil.b()));
      ((JSONObject)localObject2).put("carrier", DeviceInfoUtil.X());
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
  
  private void a(Bundle paramBundle)
  {
    String str1 = this.f.getCurrentAccountUin();
    Object localObject = (TicketManager)this.f.getManager(2);
    String str2 = ((TicketManager)localObject).getSkey(this.f.getCurrentAccountUin());
    localObject = ((TicketManager)localObject).getPskey(this.f.getCurrentAccountUin(), "qun.qq.com");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str2));
    paramBundle.putString("bkn", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append(str1);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str2);
    localStringBuilder.append(";p_uin=o");
    localStringBuilder.append(str1);
    localStringBuilder.append(";p_skey=");
    localStringBuilder.append((String)localObject);
    paramBundle.putString("Cookie", localStringBuilder.toString());
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
    int m;
    if (this.e != null)
    {
      localObject1 = paramList1.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopFeedItem)((Iterator)localObject1).next();
        if ((this.e != null) && (((TroopFeedItem)localObject2).id.equalsIgnoreCase(this.e.id))) {
          this.e = ((TroopFeedItem)localObject2);
        }
      }
      localArrayList.add(this.e);
      m = 0;
    }
    else
    {
      m = 1;
    }
    paramList = paramList.iterator();
    for (;;)
    {
      if (!paramList.hasNext()) {
        break label217;
      }
      localObject1 = (String)paramList.next();
      if (m <= 0) {
        break label217;
      }
      localObject2 = this.e;
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
          m -= 1;
        }
      }
    }
    label217:
    this.e = null;
    return localArrayList;
  }
  
  public void a()
  {
    Handler localHandler = this.i;
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
    Object localObject1 = new Bundle();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.g);
    ((Bundle)localObject1).putString("qid", ((StringBuilder)localObject2).toString());
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(paramString);
    ((Bundle)localObject1).putString("fid", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("ver", "8.8.17");
    ((Bundle)localObject1).putString("platform", "1");
    a((Bundle)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("BUNDLE", localObject1);
    this.f.getApplication();
    ((HashMap)localObject2).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/announce/get_feed", "GET", this.j, paramInt, null, true).execute(new HashMap[] { localObject2 });
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
      localStringBuilder.append(this.g);
      localStringBuilder.append(",feedsId:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",status:");
      localStringBuilder.append(paramInteger);
      QLog.d("TroopFeedsDataManager.troop.notification_center.auto_pull_down", 2, localStringBuilder.toString());
    }
    if (paramInteger.intValue() != 1) {
      return;
    }
    this.k.put(paramString, paramInteger);
  }
  
  public TroopFeedItem b()
  {
    Object localObject1 = (TroopManager)this.f.getManager(QQManagerFactory.TROOP_MANAGER);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.g);
    localObject1 = ((TroopManager)localObject1).l(((StringBuilder)localObject2).toString());
    if (localObject1 == null) {
      return this.e;
    }
    int n = ((List)localObject1).size() - 1;
    while (n >= 0)
    {
      localObject2 = (TroopNotificationCache)((List)localObject1).get(n);
      if (localObject2 != null) {}
      try
      {
        TroopFeedItem localTroopFeedItem = new TroopFeedItem();
        int m = ((TroopNotificationCache)localObject2).serviceID;
        int i2 = 0;
        int i3 = 0;
        int i1 = 0;
        if (m == 27)
        {
          localTroopFeedItem.tag = HardCodeUtil.a(2131912581);
          localTroopFeedItem.type = 5;
          m = i3;
        }
        else
        {
          m = i3;
          if (((TroopNotificationCache)localObject2).serviceID == 20)
          {
            m = i3;
            if (((TroopNotificationCache)localObject2).ctrlStr != null)
            {
              localObject3 = new JSONObject(((TroopNotificationCache)localObject2).ctrlStr);
              m = i2;
              if (((JSONObject)localObject3).has("controlType"))
              {
                m = i2;
                if (((JSONObject)localObject3).getInt("controlType") == 1)
                {
                  localObject3 = ((JSONObject)localObject3).getJSONObject("controlInfo");
                  m = i1;
                  if (((JSONObject)localObject3).getInt("compress") == 1) {
                    m = 1;
                  }
                  long l = Long.parseLong(((JSONObject)localObject3).getString("validTime"));
                  if (MessageCache.c() > l) {
                    return null;
                  }
                }
              }
              localTroopFeedItem.tag = HardCodeUtil.a(2131912582);
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
        localObject3 = new ByteArrayInputStream(StructMsgUtils.a(((TroopNotificationCache)localObject2).xmlBytes, m));
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
        if ((this.e == null) || (((TroopNotificationCache)localObject2).serviceID == 27)) {
          this.e = localTroopFeedItem;
        }
        m = ((TroopNotificationCache)localObject2).serviceID;
        if (m != 27) {}
      }
      catch (Exception localException)
      {
        label548:
        break label548;
      }
      n -= 1;
    }
    return this.e;
  }
  
  public void b(int paramInt)
  {
    Object localObject1 = (TicketManager)this.f.getManager(2);
    localObject1 = new Bundle();
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(this.g);
    ((Bundle)localObject1).putString("qid", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("ft", "23");
    ((Bundle)localObject1).putString("ni", "1");
    if (paramInt == 1003) {
      ((Bundle)localObject1).putString("is_getinst", "1");
    }
    ((Bundle)localObject1).putString("n", "1");
    ((Bundle)localObject1).putString("i", "1");
    ((Bundle)localObject1).putString("s", "-1");
    ((Bundle)localObject1).putString("log_read", "1");
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("");
    ((StringBuilder)localObject2).append(AppSetting.b());
    ((Bundle)localObject1).putString("ver", ((StringBuilder)localObject2).toString());
    ((Bundle)localObject1).putString("platform", "1");
    a((Bundle)localObject1);
    localObject2 = new HashMap();
    ((HashMap)localObject2).put("BUNDLE", localObject1);
    this.f.getApplication();
    ((HashMap)localObject2).put("CONTEXT", MobileQQ.getContext());
    new HttpWebCgiAsyncTask("https://web.qun.qq.com/cgi-bin/announce/get_t_list", "GET", this.j, paramInt, null, true).execute(new HashMap[] { localObject2 });
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
    this.i.sendEmptyMessage(5);
  }
  
  public void d()
  {
    this.i.sendEmptyMessage(6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopFeedsDataManager
 * JD-Core Version:    0.7.0.1
 */