package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import com.tencent.mobileqq.mini.appbrand.BaseAppBrandRuntime;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import zrt;
import zrw;

class DataJsPlugin$25
  implements Runnable
{
  DataJsPlugin$25(DataJsPlugin paramDataJsPlugin, zrt paramzrt) {}
  
  public void run()
  {
    synchronized (DataJsPlugin.access$200(this.this$0))
    {
      if (Math.abs(System.currentTimeMillis() - DataJsPlugin.access$300(this.this$0).longValue()) <= 5000L)
      {
        DataJsPlugin.access$200(this.this$0).add(this.val$callback);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("[mini] DataJsPlugin", 2, "really call login");
      }
      String str = this.this$0.jsPluginEngine.appBrandRuntime.appId;
      if (DataJsPlugin.access$400(this.this$0) == null) {
        DataJsPlugin.access$500(this.this$0, 6, str);
      }
      DataJsPlugin.access$302(this.this$0, Long.valueOf(System.currentTimeMillis()));
      DataJsPlugin.access$200(this.this$0).add(this.val$callback);
      DataJsPlugin.access$400(this.this$0).a("login", null, new DataJsPlugin.25.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.25
 * JD-Core Version:    0.7.0.1
 */