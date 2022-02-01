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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<requestAllConfig> process:");
      ((StringBuilder)localObject).append(s.e());
      ((StringBuilder)localObject).append(", getServiceInterface()");
      ab.c("RemoteOpProxy", ((StringBuilder)localObject).toString());
      localObject = (a)this.a.getServiceInterface();
      if (localObject != null)
      {
        ((a)localObject).b();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<requestAllConfig> process:");
      localStringBuilder.append(s.e());
      localStringBuilder.append(", getServiceInterface() error, error msg = ");
      localStringBuilder.append(localException.getMessage());
      ab.c("RemoteOpProxy", localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.j
 * JD-Core Version:    0.7.0.1
 */