package com.tencent.mobileqq.weiyun.api.impl;

import android.content.Context;
import com.tencent.mobileqq.weiyun.utils.PreferenceUtils;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

class WeiyunApiImpl$1
  implements Runnable
{
  WeiyunApiImpl$1(WeiyunApiImpl paramWeiyunApiImpl, Context paramContext) {}
  
  public void run()
  {
    long l = MobileQQ.sMobileQQ.waitAppRuntime(null).getLongAccountUin();
    boolean bool1 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_queried", false);
    boolean bool2 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_has", false);
    boolean bool3 = PreferenceUtils.a(this.a, String.valueOf(l), "key_pwd_verified", false);
    WeiyunApiImpl.access$000()[0].set(bool1);
    WeiyunApiImpl.access$000()[1].set(bool2);
    WeiyunApiImpl.access$000()[2].set(bool3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.weiyun.api.impl.WeiyunApiImpl.1
 * JD-Core Version:    0.7.0.1
 */