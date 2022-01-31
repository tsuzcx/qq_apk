package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class g
  implements Runnable
{
  g(f paramf, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      ab.c("RemoteOpProxy", "<postReport> process:" + s.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null)
      {
        ab.c("RemoteOpProxy", "<postReport> process:" + s.e());
        locala.a(this.a, this.b);
        return;
      }
      ab.c("RemoteOpProxy", "<postReport> null == serviceInterface, initTMAssistantDownloadSDK,process:" + s.e());
      this.c.initTMAssistantDownloadSDK();
      return;
    }
    catch (Exception localException)
    {
      ab.c("RemoteOpProxy", "<postReport> process:" + s.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tmdownloader.g
 * JD-Core Version:    0.7.0.1
 */