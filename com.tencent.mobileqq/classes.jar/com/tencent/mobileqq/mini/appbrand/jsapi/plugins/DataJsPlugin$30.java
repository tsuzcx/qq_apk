package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajya;
import android.content.Context;
import bcqf;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$30
  implements Runnable
{
  DataJsPlugin$30(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    bcqf localbcqf = new bcqf(this.val$context);
    localbcqf.a(ajya.a(2131702742));
    localbcqf.show();
    ThreadManager.excute(new DataJsPlugin.30.1(this, localbcqf), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */