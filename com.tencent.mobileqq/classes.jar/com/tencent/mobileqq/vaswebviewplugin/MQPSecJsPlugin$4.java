package com.tencent.mobileqq.vaswebviewplugin;

import android.app.Activity;
import bguj;
import bgve;
import bgzt;
import com.tencent.mobileqq.widget.QQToast;

class MQPSecJsPlugin$4
  implements Runnable
{
  MQPSecJsPlugin$4(MQPSecJsPlugin paramMQPSecJsPlugin) {}
  
  public void run()
  {
    bguj localbguj = this.this$0.mRuntime.a(this.this$0.mRuntime.a());
    if ((localbguj != null) && ((localbguj instanceof bgzt))) {
      QQToast.a(this.this$0.activity, this.this$0.activity.getString(2131692035), 0).b(((bgzt)localbguj).getTitleBarHeight());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.MQPSecJsPlugin.4
 * JD-Core Version:    0.7.0.1
 */