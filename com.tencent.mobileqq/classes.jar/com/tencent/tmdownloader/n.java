package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class n
  implements Runnable
{
  n(f paramf, String paramString, int paramInt) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<setInt> process:" + m.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null) {
        locala.a(this.a, this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<setInt> process:" + m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.n
 * JD-Core Version:    0.7.0.1
 */