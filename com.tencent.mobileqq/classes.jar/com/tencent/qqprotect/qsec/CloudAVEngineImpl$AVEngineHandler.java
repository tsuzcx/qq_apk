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
    switch (paramMessage.what)
    {
    default: 
      return;
    case 1: 
      CloudAVEngineImpl.a(this.a, CloudAVEngineImpl.a(this.a, paramMessage.obj));
      return;
    case 2: 
      CloudAVEngineImpl.a(this.a, true);
      CloudAVEngineImpl.a(this.a);
      CloudAVEngineImpl.a(this.a, false);
      return;
    case 3: 
      CloudAVEngineImpl.a(this.a, paramMessage.obj);
      return;
    }
    CloudAVEngineImpl.b(this.a, paramMessage.obj);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqprotect.qsec.CloudAVEngineImpl.AVEngineHandler
 * JD-Core Version:    0.7.0.1
 */