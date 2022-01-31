package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class m
  implements Runnable
{
  m(f paramf, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<setLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null) {
        locala.a(this.a, this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<setLong> process:" + com.tencent.tmassistantbase.util.m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.m
 * JD-Core Version:    0.7.0.1
 */