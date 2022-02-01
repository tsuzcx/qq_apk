package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.notification.modularize.PushUtil;
import com.tencent.mobileqq.util.SharePreferenceUtils;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ThirdPushNotifyManager
{
  private static volatile ThirdPushNotifyManager a;
  private ThirdPushNotifyManager.PushNotificationData b;
  private List<IThirdPushDataHandler> c = new ArrayList();
  
  private ThirdPushNotifyManager()
  {
    this.c.add(new HwPushDataHandler());
  }
  
  public static ThirdPushNotifyManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ThirdPushNotifyManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("ThirdPushNotifyManager", 1, "getPushTokenFromArray: token is empty!");
      return "";
    }
    try
    {
      paramString = new JSONArray(paramString).optString(0);
      return paramString;
    }
    catch (JSONException paramString)
    {
      QLog.e("ThirdPushNotifyManager", 1, "getPushTokenFromArray: exception", paramString);
    }
    return "";
  }
  
  private boolean a(Context paramContext)
  {
    if ((SplashActivity.sWeakInstance != null) && (SplashActivity.sWeakInstance.get() != null)) {
      return false;
    }
    RouteUtils.a(paramContext, new Intent(), "/base/start/splash");
    return true;
  }
  
  private String b(int paramInt, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_third_push_token_");
    localStringBuilder.append(paramInt);
    localStringBuilder.append("_");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  private boolean b()
  {
    ThirdPushNotifyManager.PushNotificationData localPushNotificationData = this.b;
    if ((localPushNotificationData != null) && (!TextUtils.isEmpty(ThirdPushNotifyManager.PushNotificationData.a(localPushNotificationData))) && (!TextUtils.isEmpty(ThirdPushNotifyManager.PushNotificationData.b(this.b)))) {
      return true;
    }
    QLog.e("ThirdPushNotifyManager", 1, "token or uin is empty!");
    return false;
  }
  
  private void c()
  {
    if (TextUtils.isEmpty(ThirdPushNotifyManager.PushNotificationData.c(this.b)))
    {
      QLog.i("ThirdPushNotifyManager", 1, "report: empty data.");
      return;
    }
    for (;;)
    {
      int i;
      try
      {
        Object localObject1 = new JSONObject(ThirdPushNotifyManager.PushNotificationData.c(this.b));
        String str1 = ((JSONObject)localObject1).optString("tianshu_ext");
        String str2 = ((JSONObject)localObject1).optString("trigger_info");
        boolean bool = TextUtils.isEmpty(str2);
        Object localObject2 = "";
        localObject1 = localObject2;
        if (!bool)
        {
          String[] arrayOfString = new JSONObject(str2).optString("oac_triggle").split("&");
          int j = arrayOfString.length;
          i = 0;
          localObject1 = localObject2;
          if (i < j)
          {
            localObject1 = arrayOfString[i];
            if (!((String)localObject1).contains("ad_id=")) {
              break label231;
            }
            localObject1 = ((String)localObject1).replace("ad_id=", "");
          }
        }
        PushUtil.a(1, 1, (String)localObject1, str2);
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("reportThirdPushClick:");
        ((StringBuilder)localObject2).append(str1);
        ((StringBuilder)localObject2).append(",");
        ((StringBuilder)localObject2).append(str2);
        ((StringBuilder)localObject2).append(",pushId=");
        ((StringBuilder)localObject2).append((String)localObject1);
        QLog.i("ThirdPushNotifyManager", 1, ((StringBuilder)localObject2).toString());
        return;
      }
      catch (JSONException localJSONException)
      {
        QLog.e("ThirdPushNotifyManager", 1, "report: exception.", localJSONException);
        return;
      }
      label231:
      i += 1;
    }
  }
  
  public String a(int paramInt, String paramString)
  {
    return SharePreferenceUtils.a(BaseApplicationImpl.getApplication(), b(paramInt, paramString));
  }
  
  public void a(int paramInt, String paramString1, String paramString2)
  {
    SharePreferenceUtils.a(BaseApplicationImpl.getApplication(), b(paramInt, paramString1), paramString2);
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext)
  {
    Object localObject = this.b;
    if (localObject == null) {
      return;
    }
    localObject = a(ThirdPushNotifyManager.PushNotificationData.d((ThirdPushNotifyManager.PushNotificationData)localObject), paramAppRuntime.getCurrentUin());
    if ((paramAppRuntime.getCurrentUin().equals(ThirdPushNotifyManager.PushNotificationData.b(this.b))) && (ThirdPushNotifyManager.PushNotificationData.a(this.b).equals(localObject)))
    {
      int i = ThirdPushNotifyManager.PushNotificationData.e(this.b);
      if (i != 0)
      {
        if ((i == 1) && (!TextUtils.isEmpty(ThirdPushNotifyManager.PushNotificationData.f(this.b))) && ((paramAppRuntime instanceof BaseQQAppInterface)))
        {
          paramAppRuntime = JumpParser.a((BaseQQAppInterface)paramAppRuntime, paramContext, ThirdPushNotifyManager.PushNotificationData.f(this.b));
          if (paramAppRuntime != null) {
            paramAppRuntime.a();
          }
        }
      }
      else if (!TextUtils.isEmpty(ThirdPushNotifyManager.PushNotificationData.f(this.b)))
      {
        paramAppRuntime = new Intent();
        paramAppRuntime.putExtra("url", ThirdPushNotifyManager.PushNotificationData.f(this.b));
        RouteUtils.a(paramContext, paramAppRuntime, "/base/browser");
      }
      this.b = null;
      return;
    }
    QLog.e("ThirdPushNotifyManager", 1, "uin or token is no equal!");
  }
  
  public boolean a(Context paramContext, Intent paramIntent, AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          IThirdPushDataHandler localIThirdPushDataHandler = (IThirdPushDataHandler)localIterator.next();
          if (!localIThirdPushDataHandler.a(paramIntent)) {
            continue;
          }
          this.b = localIThirdPushDataHandler.b(paramIntent);
          ThirdPushNotifyManager.PushNotificationData.a(this.b, a(ThirdPushNotifyManager.PushNotificationData.a(this.b)));
          i = 1;
          if (i == 0)
          {
            QLog.i("ThirdPushNotifyManager", 1, "handlePushData: not from third push.");
            return false;
          }
          if (!b())
          {
            this.b = null;
            a(paramContext);
            return true;
          }
          c();
          if (!a(paramContext)) {
            a().a(paramAppRuntime, paramContext);
          }
          return true;
        }
      }
      catch (Exception paramContext)
      {
        this.b = null;
        QLog.e("ThirdPushNotifyManager", 1, "handlePushData: exception.", paramContext);
        return true;
      }
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager
 * JD-Core Version:    0.7.0.1
 */