package com.tencent.mobileqq.mini.fake;

import android.os.Process;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;

class FakeSdkBrandUI$2
  implements Runnable
{
  FakeSdkBrandUI$2(FakeSdkBrandUI paramFakeSdkBrandUI, BaseActivity paramBaseActivity) {}
  
  public void run()
  {
    FakeSdkBrandUI.access$000(this.this$0, this.val$activity);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("killProcess ");
    localStringBuilder.append(Process.myPid());
    QLog.e("minisdk-start_FakeSdkBrandUI", 1, localStringBuilder.toString());
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.fake.FakeSdkBrandUI.2
 * JD-Core Version:    0.7.0.1
 */