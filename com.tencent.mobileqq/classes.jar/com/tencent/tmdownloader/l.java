package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class l
  implements Runnable
{
  l(f paramf) {}
  
  public void run()
  {
    try
    {
      ab.c("RemoteOpProxy", "<requestNewAppCenterConfig> process:" + s.e() + ", getServiceInterface()");
      a locala = (a)this.a.getServiceInterface();
      if (locala != null) {
        locala.d();
      }
      return;
    }
    catch (Exception localException)
    {
      ab.c("RemoteOpProxy", "<requestNewAppCenterConfig> process:" + s.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.l
 * JD-Core Version:    0.7.0.1
 */