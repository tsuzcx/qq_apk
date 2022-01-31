package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alpo;
import android.content.Context;
import bepp;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$30
  implements Runnable
{
  DataJsPlugin$30(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    bepp localbepp = new bepp(this.val$context);
    localbepp.a(alpo.a(2131703114));
    localbepp.show();
    ThreadManager.excute(new DataJsPlugin.30.1(this, localbepp), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */