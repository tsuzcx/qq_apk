package com.tencent.tmdownloader;

import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmdownloader.internal.remote.a;

class g
  implements Runnable
{
  g(f paramf, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<postReport> process:");
      ((StringBuilder)localObject).append(s.e());
      ((StringBuilder)localObject).append(", getServiceInterface()");
      ab.c("RemoteOpProxy", ((StringBuilder)localObject).toString());
      localObject = (a)this.c.getServiceInterface();
      if (localObject != null)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("<postReport> process:");
        localStringBuilder.append(s.e());
        ab.c("RemoteOpProxy", localStringBuilder.toString());
        ((a)localObject).a(this.a, this.b);
        return;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<postReport> null == serviceInterface, initTMAssistantDownloadSDK,process:");
      ((StringBuilder)localObject).append(s.e());
      ab.c("RemoteOpProxy", ((StringBuilder)localObject).toString());
      this.c.initTMAssistantDownloadSDK();
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<postReport> process:");
      localStringBuilder.append(s.e());
      localStringBuilder.append(", getServiceInterface() error, error msg = ");
      localStringBuilder.append(localException.getMessage());
      ab.c("RemoteOpProxy", localStringBuilder.toString());
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.g
 * JD-Core Version:    0.7.0.1
 */