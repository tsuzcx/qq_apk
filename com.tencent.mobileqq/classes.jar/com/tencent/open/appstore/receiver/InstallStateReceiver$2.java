package com.tencent.open.appstore.receiver;

import bflp;

class InstallStateReceiver$2
  implements Runnable
{
  InstallStateReceiver$2(InstallStateReceiver paramInstallStateReceiver, String paramString1, String paramString2) {}
  
  public void run()
  {
    bflp.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_REPLACED >> " + this.a);
    InstallStateReceiver.a(this.this$0, this.b, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.2
 * JD-Core Version:    0.7.0.1
 */