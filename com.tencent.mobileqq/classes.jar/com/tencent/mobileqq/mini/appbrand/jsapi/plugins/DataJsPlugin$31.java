package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajed;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DataJsPlugin$31
  implements ThreadExcutor.IThreadListener
{
  DataJsPlugin$31(DataJsPlugin paramDataJsPlugin, String paramString1, String paramString2, int paramInt) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    String str = ajed.ba + this.val$fileName;
    if (new File(str).exists())
    {
      DataJsPlugin.access$900(this.this$0, this.val$title, str, this.val$shareType);
      return;
    }
    QLog.e("[mini] DataJsPlugin", 4, "shareLocalPicMessage: realPicFile is not exist:" + str);
  }
  
  public void onPreRun() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.31
 * JD-Core Version:    0.7.0.1
 */