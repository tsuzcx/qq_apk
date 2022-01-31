package com.tencent.mobileqq.mini.appbrand.jsapi.plugins;

import ajsf;
import bbdj;
import java.io.File;

class DataJsPlugin$31
  implements Runnable
{
  DataJsPlugin$31(DataJsPlugin paramDataJsPlugin, File paramFile, String paramString) {}
  
  public void run()
  {
    File localFile = new File(ajsf.bc);
    localFile.mkdirs();
    if (this.val$localPic.exists())
    {
      localFile = new File(localFile, this.val$fileName);
      bbdj.a(this.val$localPic, localFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.jsapi.plugins.DataJsPlugin.31
 * JD-Core Version:    0.7.0.1
 */