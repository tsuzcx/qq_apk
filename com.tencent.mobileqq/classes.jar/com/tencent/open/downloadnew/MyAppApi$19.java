package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.open.base.APNUtil;
import com.tencent.open.base.LogUtility;
import mqq.os.MqqHandler;

class MyAppApi$19
  implements Runnable
{
  MyAppApi$19(MyAppApi paramMyAppApi, Activity paramActivity, String paramString) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("---isAutoInstall:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.d());
    ((StringBuilder)localObject).append(" url:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.c());
    ((StringBuilder)localObject).append(" interval:");
    ((StringBuilder)localObject).append(ControlPolicyUtil.e());
    LogUtility.c("MyAppApi", ((StringBuilder)localObject).toString());
    if ((APNUtil.i(this.a)) && (APNUtil.j(this.a)))
    {
      boolean bool1 = ControlPolicyUtil.b();
      boolean bool2 = ControlPolicyUtil.w();
      localObject = SharedPreUtils.az(this.a, "wifiAutoPreDown");
      if ((!MyAppApi.m()) && (bool1) && (bool2) && ("true".equals(localObject)))
      {
        ThreadManager.getUIHandler().post(new MyAppApi.19.1(this));
        LogUtility.c("MyAppApi", "---startDownloadYYB---");
        localObject = this.this$0;
        ((MyAppApi)localObject).j = new MyAppApi.InstallParams((MyAppApi)localObject);
        this.this$0.j.b = true;
        this.this$0.j.c = false;
        this.this$0.j.d = null;
        this.this$0.j.a = null;
        this.this$0.j.e = -1;
        this.this$0.a(this.a, this.b, 1, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.19
 * JD-Core Version:    0.7.0.1
 */