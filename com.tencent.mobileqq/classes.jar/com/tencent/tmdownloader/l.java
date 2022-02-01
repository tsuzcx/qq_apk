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
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<requestNewAppCenterConfig> process:");
      ((StringBuilder)localObject).append(s.e());
      ((StringBuilder)localObject).append(", getServiceInterface()");
      ab.c("RemoteOpProxy", ((StringBuilder)localObject).toString());
      localObject = (a)this.a.getServiceInterface();
      if (localObject != null)
      {
        ((a)localObject).d();
        return;
      }
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<requestNewAppCenterConfig> process:");
      localStringBuilder.append(s.e());
      localStringBuilder.append(", getServiceInterface() error, error msg = ");
      localStringBuilder.append(localException.getMessage());
      ab.c("RemoteOpProxy", localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmdownloader.l
 * JD-Core Version:    0.7.0.1
 */