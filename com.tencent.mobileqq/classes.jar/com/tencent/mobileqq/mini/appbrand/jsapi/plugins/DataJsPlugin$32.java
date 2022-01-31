package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajsd;
import com.tencent.mobileqq.app.ThreadExcutor.IThreadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class DataJsPlugin$32
  implements ThreadExcutor.IThreadListener
{
  DataJsPlugin$32(DataJsPlugin paramDataJsPlugin, String paramString1, String paramString2, int paramInt) {}
  
  public void onAdded() {}
  
  public void onPostRun()
  {
    String str = ajsd.bc + this.val$fileName;
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
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.32
 * JD-Core Version:    0.7.0.1
 */