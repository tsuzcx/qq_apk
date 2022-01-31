package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class o
  implements Runnable
{
  o(f paramf, String paramString, boolean paramBoolean) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<setBoolean> process:" + m.e() + ", getServiceInterface()");
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
 * Qualified Name:     com.tencent.tmdownloader.o
 * JD-Core Version:    0.7.0.1
 */