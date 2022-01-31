package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bcci;
import bcdb;
import bchu;
import bcpw;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bcci localbcci = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbcci != null) && ((localbcci instanceof bchu))) {
      bcpw.a(this.this$0.activity, this.this$0.activity.getString(2131692321), 0).b(((bchu)localbcci).b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */