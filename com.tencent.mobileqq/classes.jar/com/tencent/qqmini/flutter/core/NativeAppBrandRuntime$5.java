package com.tencent.qqmini.flutter.core;

import com.qflutter.log.qflutter_log.QflutterLogPlugin.Log;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class NativeAppBrandRuntime$5
  implements QflutterLogPlugin.Log
{
  NativeAppBrandRuntime$5(NativeAppBrandRuntime paramNativeAppBrandRuntime) {}
  
  public void d(String paramString)
  {
    QMLog.d("miniapp-TISSUE", paramString);
  }
  
  public void e(String paramString)
  {
    QMLog.e("miniapp-TISSUE", paramString);
  }
  
  public int getLogLevel()
  {
    return 5;
  }
  
  public void i(String paramString)
  {
    QMLog.i("miniapp-TISSUE", paramString);
  }
  
  public void v(String paramString)
  {
    QMLog.d("miniapp-TISSUE", paramString);
  }
  
  public void w(String paramString)
  {
    QMLog.w("miniapp-TISSUE", paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.flutter.core.NativeAppBrandRuntime.5
 * JD-Core Version:    0.7.0.1
 */