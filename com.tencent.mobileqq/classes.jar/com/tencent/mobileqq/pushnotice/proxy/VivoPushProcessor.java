package com.tencent.mobileqq.pushnotice.proxy;

import android.content.Context;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.vivo.push.PushClient;

public class VivoPushProcessor
  extends ThirdPushProcessorImpl
{
  private Context c = BaseApplicationImpl.getContext();
  
  public void a()
  {
    try
    {
      if (!c()) {
        return;
      }
      PushClient.getInstance(this.c).initialize();
      PushClient.getInstance(this.c).turnOnPush(new -..Lambda.VivoPushProcessor.ZxCyHJLB0Fjtc-Or2l-3KHnc_-Q(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("VPUSH", 1, "registerPush error! ", localException);
    }
  }
  
  public int b()
  {
    return 5;
  }
  
  public boolean c()
  {
    try
    {
      boolean bool = PushClient.getInstance(this.c).isSupport();
      return bool;
    }
    catch (Exception localException)
    {
      QLog.e("VPUSH", 1, "isSupport error! ", localException);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pushnotice.proxy.VivoPushProcessor
 * JD-Core Version:    0.7.0.1
 */