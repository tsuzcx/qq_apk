package com.tencent.open.downloadnew;

import android.app.Activity;
import com.tencent.open.base.LogUtility;

class MyAppApi$21
  implements Runnable
{
  MyAppApi$21(MyAppApi paramMyAppApi, boolean paramBoolean, Activity paramActivity, String paramString) {}
  
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
    boolean bool = ControlPolicyUtil.b();
    if ((!MyAppApi.m()) && (bool))
    {
      LogUtility.c("MyAppApi", "---startDownloadYYB---");
      localObject = this.this$0;
      ((MyAppApi)localObject).j = new MyAppApi.InstallParams((MyAppApi)localObject);
      this.this$0.j.b = true;
      this.this$0.j.c = false;
      this.this$0.j.d = null;
      this.this$0.j.a = null;
      this.this$0.j.e = -1;
      if (this.a)
      {
        this.this$0.a(this.b, this.c, 0, "", "");
        return;
      }
      this.this$0.a(this.b, this.c, 1, "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.downloadnew.MyAppApi.21
 * JD-Core Version:    0.7.0.1
 */