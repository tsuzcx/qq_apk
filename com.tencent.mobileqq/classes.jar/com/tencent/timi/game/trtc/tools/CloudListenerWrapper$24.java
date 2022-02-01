package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$24
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$24(CloudListenerWrapper paramCloudListenerWrapper, int paramInt1, int paramInt2) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onAudioRouteChanged(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.24
 * JD-Core Version:    0.7.0.1
 */