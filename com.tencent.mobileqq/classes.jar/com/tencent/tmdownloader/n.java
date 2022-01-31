package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ac;
import com.tencent.tmassistantbase.util.t;
import com.tencent.tmdownloader.internal.remote.a;

class n
  implements Runnable
{
  n(f paramf, String paramString1, String paramString2) {}
  
  public void run()
  {
    try
    {
      ac.c("RemoteOpProxy", "<setString> process:" + t.e() + ", getServiceInterface()");
      a locala = (a)this.c.getServiceInterface();
      if (locala != null) {
        locala.a(this.a, this.b);
      }
      return;
    }
    catch (Exception localException)
    {
      ac.c("RemoteOpProxy", "<setString> process:" + t.e() + ", getServiceInterface() error, error msg = " + localException.getMessage());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tmdownloader.n
 * JD-Core Version:    0.7.0.1
 */