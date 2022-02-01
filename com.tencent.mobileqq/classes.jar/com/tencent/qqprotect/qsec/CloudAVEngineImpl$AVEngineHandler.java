package com.tencent.qqprotect.qsec;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

class CloudAVEngineImpl$AVEngineHandler
  extends Handler
{
  public CloudAVEngineImpl$AVEngineHandler(CloudAVEngineImpl paramCloudAVEngineImpl, Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message paramMessage)
  {
    int i = paramMessage.what;
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return;
          }
          CloudAVEngineImpl.c(this.a, paramMessage.obj);
          return;
        }
        CloudAVEngineImpl.b(this.a, paramMessage.obj);
        return;
      }
      CloudAVEngineImpl.a(this.a, true);
      CloudAVEngineImpl.a(this.a);
      CloudAVEngineImpl.a(this.a, false);
      return;
    }
    CloudAVEngineImpl localCloudAVEngineImpl = this.a;
    CloudAVEngineImpl.a(localCloudAVEngineImpl, CloudAVEngineImpl.a(localCloudAVEngineImpl, paramMessage.obj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineHandler
 * JD-Core Version:    0.7.0.1
 */