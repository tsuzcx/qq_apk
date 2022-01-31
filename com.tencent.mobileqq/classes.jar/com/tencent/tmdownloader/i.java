package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.m;
import com.tencent.tmassistantbase.util.r;
import com.tencent.tmdownloader.internal.remote.a;

class i
  implements Runnable
{
  i(f paramf) {}
  
  public void run()
  {
    try
    {
      r.c("RemoteOpProxy", "<requestAllConfig> process:" + m.e() + ", getServiceInterface()");
      a locala = (a)this.a.getServiceInterface();
      if (locala != null) {
        locala.b();
      }
      return;
    }
    catch (Exception localException)
    {
      r.c("RemoteOpProxy", "<requestAllConfig> process:" + m.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tmdownloader.i
 * JD-Core Version:    0.7.0.1
 */