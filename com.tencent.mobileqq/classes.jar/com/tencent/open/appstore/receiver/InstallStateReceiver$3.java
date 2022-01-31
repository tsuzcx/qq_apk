package com.tencent.open.appstore.receiver;

import android.content.Intent;
import bfgx;
import bfhg;

class InstallStateReceiver$3
  implements Runnable
{
  InstallStateReceiver$3(InstallStateReceiver paramInstallStateReceiver, Intent paramIntent, String paramString1, String paramString2) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_AndroidContentIntent.hasExtra("android.intent.extra.REPLACING")) {}
    for (boolean bool = this.jdField_a_of_type_AndroidContentIntent.getBooleanExtra("android.intent.extra.REPLACING", false);; bool = false)
    {
      bfhg.c("InstallStateReceiver", "[onReceive] ACTION_PACKAGE_ADDED >> " + this.jdField_a_of_type_JavaLangString + ",isReplacing:" + bool);
      if (bool) {
        return;
      }
      bfgx.a(this.b, false);
      InstallStateReceiver.a(this.this$0, this.b, 1);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.open.appstore.receiver.InstallStateReceiver.3
 * JD-Core Version:    0.7.0.1
 */