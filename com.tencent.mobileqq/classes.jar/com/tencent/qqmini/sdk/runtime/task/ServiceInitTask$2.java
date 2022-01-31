package com.tencent.qqmini.sdk.runtime.task;

import bdnw;
import bdsu;
import bduj;
import bdwf;
import bdwg;
import bdxc;
import bdxe;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;

public class ServiceInitTask$2
  implements Runnable
{
  public ServiceInitTask$2(bdxc parambdxc) {}
  
  public void run()
  {
    MiniAppInfo localMiniAppInfo = null;
    try
    {
      long l1 = System.currentTimeMillis();
      bdxc.a(this.this$0, new bdwg(this.this$0.a, null));
      if (this.this$0.a != null) {
        localMiniAppInfo = this.this$0.a.a();
      }
      bdsu.a(localMiniAppInfo, 101, "0");
      long l2 = System.currentTimeMillis();
      if (this.this$0.a != null) {
        bdxc.b(this.this$0).a(this.this$0.a.a());
      }
      bdxc.b(this.this$0).a(new bdxe(this, l2 - l1));
      bdxc.b(this.this$0).b();
      i = 1;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        bdnw.d("minisdk-start", "ServiceInitTask execute exception!", localThrowable);
        int i = 0;
      }
    }
    if (i == 0) {
      this.this$0.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.task.ServiceInitTask.2
 * JD-Core Version:    0.7.0.1
 */