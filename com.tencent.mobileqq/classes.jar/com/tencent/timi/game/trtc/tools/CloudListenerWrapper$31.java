package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$31
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$31(CloudListenerWrapper paramCloudListenerWrapper, int paramInt, String paramString) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onStartPublishCDNStream(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.31
 * JD-Core Version:    0.7.0.1
 */