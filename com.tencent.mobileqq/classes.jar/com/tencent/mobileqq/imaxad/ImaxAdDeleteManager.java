package com.tencent.mobileqq.imaxad;

import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.Advertisement.data.AdvertisementItem;
import com.tencent.biz.pubaccount.Advertisement.data.VideoCoverItem;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.RecentDataListManager;
import com.tencent.mobileqq.activity.recent.RecentUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ImaxAdDeleteManager
{
  private static ImaxAdDeleteManager a;
  private ConcurrentLinkedQueue<String> b = new ConcurrentLinkedQueue();
  
  public static ImaxAdDeleteManager a()
  {
    try
    {
      if (a == null) {
        a = new ImaxAdDeleteManager();
      }
      ImaxAdDeleteManager localImaxAdDeleteManager = a;
      return localImaxAdDeleteManager;
    }
    finally {}
  }
  
  public static void a(String paramString1, AdvertisementItem paramAdvertisementItem, String paramString2)
  {
    ImaxAdUtil.c(paramString1, paramString2);
    if (paramAdvertisementItem != null)
    {
      if (QLog.isColorLevel())
      {
        paramString1 = new StringBuilder();
        paramString1.append("doDeleteItem bingo clearDistInfo  uin:");
        paramString1.append(paramString2);
        QLog.d("ImaxAdvertisement", 2, paramString1.toString());
      }
      paramString1 = paramAdvertisementItem.c.iterator();
      while (paramString1.hasNext()) {
        ImaxAdVideoPreloadManager.c(((VideoCoverItem)paramString1.next()).c);
      }
    }
  }
  
  private boolean e(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return this.b.contains(paramString);
    }
    return false;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("doDeleteItem  uin:");
      ((StringBuilder)localObject1).append(paramString);
      QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = (ProxyManager)paramQQAppInterface.getManager(QQManagerFactory.PROXY_MANAGER);
    if (localObject1 == null) {
      localObject1 = null;
    } else {
      localObject1 = ((ProxyManager)localObject1).g();
    }
    if (localObject1 != null)
    {
      RecentUser localRecentUser = ((RecentUserProxy)localObject1).b(paramString, 10005);
      if (localRecentUser != null)
      {
        if (QLog.isColorLevel())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("doDeleteItem bingo Recent  uin:");
          ((StringBuilder)localObject2).append(paramString);
          QLog.d("ImaxAdvertisement", 2, ((StringBuilder)localObject2).toString());
        }
        Object localObject2 = RecentDataListManager.a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(localRecentUser.uin);
        localStringBuilder.append("-");
        localStringBuilder.append(localRecentUser.getType());
        ((RecentDataListManager)localObject2).b(localStringBuilder.toString());
        ((RecentUserProxy)localObject1).a(localRecentUser);
        RecentUtil.b(paramQQAppInterface, paramString, 10005);
        paramQQAppInterface.getMessageFacade().a(paramString, 10005);
      }
    }
    localObject1 = ImaxAdRecentUserManager.a().a(paramString);
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      ThreadManager.executeOnFileThread(new ImaxAdDeleteManager.1(this, (AdvertisementItem)localObject1, paramQQAppInterface, paramString));
      return;
    }
    a(paramQQAppInterface.getCurrentUin(), (AdvertisementItem)localObject1, paramString);
  }
  
  public void a(String paramString)
  {
    if (!e(paramString)) {
      this.b.add(paramString);
    }
  }
  
  public boolean a(String paramString1, String paramString2)
  {
    if (e(paramString2)) {
      return true;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("delete_st_");
    localStringBuilder.append(paramString2);
    return true ^ TextUtils.isEmpty(ImaxAdUtil.b(paramString1, localStringBuilder.toString()));
  }
  
  public String b()
  {
    localJSONArray = new JSONArray();
    try
    {
      Iterator localIterator = this.b.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("senderUin", str);
        localJSONArray.put(localJSONObject);
      }
      return localJSONArray.toString();
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return this.b.remove(paramString);
  }
  
  public void c(String paramString)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("convertStringToList  str:");
      localStringBuilder.append(paramString);
      QLog.d("ImaxAdvertisement", 2, localStringBuilder.toString());
    }
    this.b.clear();
    try
    {
      paramString = new JSONArray(paramString);
      int i = 0;
      while (i < paramString.length())
      {
        a(paramString.getJSONObject(i).getString("senderUin"));
        i += 1;
      }
      return;
    }
    catch (JSONException paramString)
    {
      paramString.printStackTrace();
    }
  }
  
  public void d(String paramString)
  {
    Iterator localIterator = this.b.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("delete_st_");
      localStringBuilder.append(str);
      long l = Long.valueOf(ImaxAdUtil.b(paramString, localStringBuilder.toString())).longValue();
      if (NetConnInfoCenter.getServerTimeMillis() - l > 86400000L)
      {
        b(str);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("delete_st_");
        localStringBuilder.append(str);
        ImaxAdUtil.a(paramString, localStringBuilder.toString());
      }
    }
    ImaxAdUtil.a(paramString, "delete_uin_list", b());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imaxad.ImaxAdDeleteManager
 * JD-Core Version:    0.7.0.1
 */