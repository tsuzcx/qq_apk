package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import android.content.Context;
import anzj;
import bjbs;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$31
  implements Runnable
{
  DataJsPlugin$31(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    bjbs localbjbs = new bjbs(this.val$context);
    localbjbs.a(anzj.a(2131701640));
    localbjbs.show();
    ThreadManager.excute(new DataJsPlugin.31.1(this, localbjbs), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.31
 * JD-Core Version:    0.7.0.1
 */