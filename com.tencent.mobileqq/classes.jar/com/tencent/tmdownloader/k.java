package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.internal.remote.a;

class k
  implements Runnable
{
  k(f paramf) {}
  
  public void run()
  {
    try
    {
      ac.c("RemoteOpProxy", "<requestShareUrl> process:" + t.e() + ", getServiceInterface()");
      a locala = (a)this.a.getServiceInterface();
      if (locala != null) {
        locala.c();
      }
      return;
    }
    catch (Exception localException)
    {
      ac.c("RemoteOpProxy", "<requestShareUrl> process:" + t.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.k
 * JD-Core Version:    0.7.0.1
 */