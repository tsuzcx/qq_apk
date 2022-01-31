package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bebx;
import becq;
import behj;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bebx localbebx = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbebx != null) && ((localbebx instanceof behj))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131692397), 0).b(((behj)localbebx).b());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */