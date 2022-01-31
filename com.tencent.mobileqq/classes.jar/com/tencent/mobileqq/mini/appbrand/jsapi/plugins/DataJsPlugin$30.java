package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajed;
import bace;
import java.io.File;

class DataJsPlugin$30
  implements Runnable
{
  DataJsPlugin$30(DataJsPlugin paramDataJsPlugin, File paramFile, String paramString) {}
  
  public void run()
  {
    File localFile = new File(ajed.ba);
    localFile.mkdirs();
    if (this.val$localPic.exists())
    {
      localFile = new File(localFile, this.val$fileName);
      bace.a(this.val$localPic, localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */