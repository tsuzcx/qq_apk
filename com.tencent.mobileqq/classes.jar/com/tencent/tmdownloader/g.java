package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class g
  implements Runnable
{
  g(f paramf, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<postReport> process:" + m.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null)
      {
        r.c("RemoteOpProxy", "<postReport> process:" + m.e());
        locala.a(this.a, this.b);
        return;
      }
      r.c("RemoteOpProxy", "<postReport> null == serviceInterface, initTMAssistantDownloadSDK,process:" + m.e());
      this.c.initTMAssistantDownloadSDK();
      return;
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<postReport> process:" + m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.g
 * JD-Core Version:    0.7.0.1
 */