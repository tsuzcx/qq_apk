package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bccw;
import bcdp;
import bcii;
import bcql;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bccw localbccw = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbccw != null) && ((localbccw instanceof bcii))) {
      bcql.a(this.this$0.activity, this.this$0.activity.getString(2131692321), 0).b(((bcii)localbccw).b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */