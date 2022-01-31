package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import alud;
import android.content.Context;
import bety;
import com.tencent.mobileqq.app.ThreadManager;

class DataJsPlugin$30
  implements Runnable
{
  DataJsPlugin$30(DataJsPlugin paramDataJsPlugin, Context paramContext, String paramString1, String paramString2, int paramInt) {}
  
  public void run()
  {
    bety localbety = new bety(this.val$context);
    localbety.a(alud.a(2131703126));
    localbety.show();
    ThreadManager.excute(new DataJsPlugin.30.1(this, localbety), 128, null, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */