package com.tencent.mobileqq.pushnotice.proxy;

import android.app.NotificationManager;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.onlinestatus.api.IOnlineStatusService;
import com.tencent.mobileqq.pushnotice.ThirdPushNotifyManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ThirdPushProcessorImpl
  implements IThirdPushProcessor
{
  protected String a = "";
  protected String b = "";
  
  public void a() {}
  
  public void a(Context paramContext) {}
  
  public void a(String paramString)
  {
    this.a = paramString;
    f();
  }
  
  public int b()
  {
    return 1;
  }
  
  public void b(Context paramContext)
  {
    if (!c()) {
      return;
    }
    ((NotificationManager)paramContext.getSystemService("notification")).cancelAll();
  }
  
  public boolean c()
  {
    return false;
  }
  
  public void d() {}
  
  public String e()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getToken success:");
      localStringBuilder.append(this.a);
      QLog.d("TPUSH", 1, localStringBuilder.toString());
    }
    return this.a;
  }
  
  protected void f()
  {
    if (TextUtils.isEmpty(e())) {
      return;
    }
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    String str = BaseApplicationImpl.getApplication().getRuntime().getCurrentUin();
    ThirdPushNotifyManager.a().a(b(), str, e());
    if (localQQAppInterface.isLogin())
    {
      ((IOnlineStatusService)localQQAppInterface.getRuntimeService(IOnlineStatusService.class)).requestSetPushToken(localQQAppInterface, e(), this.b);
      if (QLog.isColorLevel()) {
        QLog.d("TPUSH", 2, "sendThirdPartyTokenToServer");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl
 * JD-Core Version:    0.7.0.1
 */