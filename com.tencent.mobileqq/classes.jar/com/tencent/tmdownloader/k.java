package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class k
  implements Runnable
{
  k(f paramf, String paramString, byte[] paramArrayOfByte) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<setBlob> process:" + m.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null) {
        locala.a(this.a, this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<setBlob> process:" + m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.k
 * JD-Core Version:    0.7.0.1
 */