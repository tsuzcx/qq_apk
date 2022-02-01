package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudDef.TRTCSpeedTestResult;
import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$21
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$21(CloudListenerWrapper paramCloudListenerWrapper, TRTCCloudDef.TRTCSpeedTestResult paramTRTCSpeedTestResult, int paramInt1, int paramInt2) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onSpeedTest(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.21
 * JD-Core Version:    0.7.0.1
 */