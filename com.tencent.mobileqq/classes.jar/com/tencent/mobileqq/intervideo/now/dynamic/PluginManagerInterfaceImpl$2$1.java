package com.tencent.mobileqq.intervideo.now.dynamic;

import android.os.Bundle;
import arjj;
import com.tencent.intervideo.nowproxy.customized_interface.DownloadCallback;
import com.tencent.qphone.base.util.QLog;

public class PluginManagerInterfaceImpl$2$1
  implements Runnable
{
  public PluginManagerInterfaceImpl$2$1(arjj paramarjj) {}
  
  public void run()
  {
    QLog.i("PluginManagerInterfaceImpl", 4, "onDownloadComplete------sub thread run");
    if (this.a.a != null)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("errCode", 0);
      localBundle.putString("errMsg", "Helly Download Success");
      this.a.a.onDownloadSuccess("");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.now.dynamic.PluginManagerInterfaceImpl.2.1
 * JD-Core Version:    0.7.0.1
 */