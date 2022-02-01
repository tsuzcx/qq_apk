package com.tencent.mobileqq.pushnotice;

import android.content.Context;
import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.mobileqq.pushnotice.proxy.HuaWeiPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.IThirdPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.OppoPushProcessor;
import com.tencent.mobileqq.pushnotice.proxy.ThirdPushProcessorImpl;
import com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor;
import com.tencent.qphone.base.util.QLog;

public class ThirdPushManager
{
  private static volatile ThirdPushManager a;
  private final IThirdPushProcessor b;
  
  private ThirdPushManager()
  {
    String str = Build.MANUFACTURER;
    if (("oppo".equalsIgnoreCase(str)) && (Build.VERSION.SDK_INT >= 19))
    {
      this.b = new OppoPushProcessor();
      return;
    }
    if (("HUAWEI".equalsIgnoreCase(Build.MANUFACTURER)) && (Build.VERSION.SDK_INT >= 21))
    {
      this.b = new HuaWeiPushProcessor();
      return;
    }
    if (("vivo".equalsIgnoreCase(str)) && (Build.VERSION.SDK_INT >= 23))
    {
      this.b = new VivoPushProcessor();
      return;
    }
    this.b = new ThirdPushProcessorImpl();
  }
  
  public static ThirdPushManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new ThirdPushManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  public void a(Context paramContext)
  {
    this.b.b(paramContext);
  }
  
  public void a(String paramString)
  {
    this.b.a(paramString);
  }
  
  public int b()
  {
    int i = this.b.b();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Push pushType : ");
      localStringBuilder.append(i);
      QLog.d("", 2, localStringBuilder.toString());
    }
    return i;
  }
  
  public void b(Context paramContext)
  {
    this.b.a(paramContext);
  }
  
  public void c()
  {
    QLog.d("ThirdPushManager", 1, "registerThirdPartyPush");
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.ThirdPushManager
 * JD-Core Version:    0.7.0.1
 */