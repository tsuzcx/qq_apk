package com.tencent.open.appstore.receiver;

import android.content.Intent;
import com.tencent.open.appstore.report.AppCenterReporter;
import com.tencent.open.base.LogUtility;

class InstallStateReceiver$3
  implements Runnable
{
  InstallStateReceiver$3(InstallStateReceiver paramInstallStateReceiver, Intent paramIntent, String paramString1, String paramString2) {}
  
  public void run()
  {
    boolean bool;
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("android.intent.extra.REPLACING")) {
      bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);
    } else {
      bool = false;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceive] ACTION_PACKAGE_ADDED >> ");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(",isReplacing:");
    localStringBuilder.append(bool);
    LogUtility.c("InstallStateReceiver", localStringBuilder.toString());
    if (bool) {
      return;
    }
    AppCenterReporter.a(this.b, false);
    InstallStateReceiver.a(this.this$0, this.b, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.3
 * JD-Core Version:    0.7.0.1
 */