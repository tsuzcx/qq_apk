package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class j
  implements Runnable
{
  j(f paramf) {}
  
  public void run()
  {
    try
    {
      ab.c("RemoteOpProxy", "<requestAllConfig> process:" + s.e() + ", getServiceInterface()");
      a locala = (a)this.a.getServiceInterface();
      if (locala != null) {
        locala.b();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.c("RemoteOpProxy", "<requestAllConfig> process:" + s.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.j
 * JD-Core Version:    0.7.0.1
 */