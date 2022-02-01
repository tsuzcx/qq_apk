package com.tencent.mobileqq.pushnotice.proxy;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build.VERSION;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hms.push.HmsProfile;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.ReflectionUtil;
import mqq.app.AppRuntime;

public class HuaWeiPushProcessor
  extends ThirdPushProcessorImpl
{
  private void g()
  {
    try
    {
      if (HmsProfile.getInstance(BaseApplicationImpl.getContext()).isSupportProfile())
      {
        d();
        return;
      }
      h();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("registerHuaweiPushTokenToServer : ");
      localStringBuilder.append(localException);
      QLog.e("HPUSH", 1, localStringBuilder.toString());
    }
  }
  
  private void h()
  {
    if (TextUtils.isEmpty(e()))
    {
      ThreadManager.newFreeThread(new HuaWeiPushProcessor.2(this), "huawei_push_token_get", 5).start();
      return;
    }
    f();
    if (QLog.isColorLevel()) {
      QLog.d("HPush", 2, "HPush_Huawei Push Token-By not HmsInstanceId : ");
    }
  }
  
  public void a()
  {
    g();
  }
  
  public void a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26)
    {
      paramContext = (NotificationManager)BaseApplication.getContext().getSystemService("notification");
      StatusBarNotification[] arrayOfStatusBarNotification = paramContext.getActiveNotifications();
      int j = arrayOfStatusBarNotification.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = arrayOfStatusBarNotification[i];
        String str1 = ((StatusBarNotification)localObject).getNotification().getChannelId();
        Integer localInteger = Integer.valueOf(((StatusBarNotification)localObject).getId());
        String str2 = ((StatusBarNotification)localObject).getPackageName();
        String str3 = ReflectionUtil.a(localObject, localObject.getClass().getName(), "getOpPkg", null, new Object[0]).toString();
        localObject = ((StatusBarNotification)localObject).getKey();
        if ((str3.equals("com.huawei.android.pushagent")) && (str1.equals("CHANNEL_ID_SHOW_BADGE")))
        {
          paramContext.cancel(localInteger.intValue());
          if (QLog.isColorLevel()) {
            QLog.d("HPUSH", 2, new Object[] { "HPush_mChannelId = ", str1, ", nId = ", localInteger, ",pkg = ", str2, ",key = ", localObject, ",opPkg = ", str3 });
          }
        }
        i += 1;
      }
    }
  }
  
  public void a(String paramString)
  {
    this.a = paramString;
  }
  
  public int b()
  {
    return 3;
  }
  
  public boolean c()
  {
    return true;
  }
  
  public void d()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject != null) && ((localObject instanceof QQAppInterface)))
    {
      String str = MD5.toMD5(((AppRuntime)localObject).getCurrentUin());
      if (!TextUtils.isEmpty(str))
      {
        localObject = str;
        if (str.length() > 8) {
          localObject = str.substring(0, 8);
        }
        HmsProfile.getInstance(BaseApplicationImpl.getApplication()).addProfile(2, (String)localObject).addOnCompleteListener(new HuaWeiPushProcessor.1(this, (String)localObject));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor
 * JD-Core Version:    0.7.0.1
 */