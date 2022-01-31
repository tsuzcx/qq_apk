package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajjy;
import android.content.Context;
import bbms;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$29
  implements Runnable
{
  DataJsPlugin$29(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    bbms localbbms = new bbms(this.val$context);
    localbbms.a(ajjy.a(2131636947));
    localbbms.show();
    ThreadManager.excute(new DataJsPlugin.29.1(this, localbbms), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.29
 * JD-Core Version:    0.7.0.1
 */