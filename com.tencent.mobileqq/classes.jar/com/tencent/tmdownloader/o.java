package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class o
  implements Runnable
{
  o(f paramf, String paramString, long paramLong) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<setLong> process:");
      ((StringBuilder)localObject).append(s.e());
      ((StringBuilder)localObject).append(", getServiceInterface()");
      ab.c("RemoteOpProxy", ((StringBuilder)localObject).toString());
      localObject = (a)this.c.getServiceInterface();
      if (localObject != null)
      {
        ((a)localObject).a(this.a, this.b);
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<setLong> process:");
      localStringBuilder.append(s.e());
      localStringBuilder.append(", getServiceInterface() error, error msg = ");
      localStringBuilder.append(localException.getMessage());
      ab.c("RemoteOpProxy", localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.o
 * JD-Core Version:    0.7.0.1
 */