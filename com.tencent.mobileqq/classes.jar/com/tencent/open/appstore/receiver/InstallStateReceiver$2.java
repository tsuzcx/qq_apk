package com.tencent.open.appstore.receiver;

import com.tencent.open.base.LogUtility;

class InstallStateReceiver$2
  implements Runnable
{
  InstallStateReceiver$2(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[onReceive] ACTION_PACKAGE_REPLACED >> ");
    localStringBuilder.append(this.a);
    LogUtility.c("InstallStateReceiver", localStringBuilder.toString());
    InstallStateReceiver.a(this.this$0, this.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.2
 * JD-Core Version:    0.7.0.1
 */