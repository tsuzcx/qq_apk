package com.tencent.tmdownloader;

import android.content.Context;
import com.tencent.tmassistantbase.util.ab;

class d
  implements Runnable
{
  d(a parama) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("unInitTMAssistantDownloadSDK,clientKey:");
    ((StringBuilder)localObject).append(this.a.mClientKey);
    ((StringBuilder)localObject).append(",mServiceInterface:");
    ((StringBuilder)localObject).append(this.a.mServiceInterface);
    ((StringBuilder)localObject).append(",threadId:");
    ((StringBuilder)localObject).append(Thread.currentThread().getId());
    ab.c("BaseIPCClient", ((StringBuilder)localObject).toString());
    if ((this.a.mServiceInterface != null) && (this.a.mServiceCallback != null)) {}
    try
    {
      this.a.unRegisterServiceCallback();
    }
    catch (Exception localException)
    {
      label103:
      break label103;
    }
    if (this.a.mContext != null)
    {
      localObject = this.a;
      if ((localObject != null) && (((a)localObject).mServiceInterface != null)) {
        this.a.mContext.unbindService(this.a);
      }
    }
    localObject = this.a;
    ((a)localObject).mServiceInterface = null;
    ((a)localObject).mServiceCallback = null;
    ((a)localObject).connectState = "INIT";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tmdownloader.d
 * JD-Core Version:    0.7.0.1
 */