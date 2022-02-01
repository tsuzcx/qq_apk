package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$19
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$19(CloudListenerWrapper paramCloudListenerWrapper) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onTryToReconnect();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.19
 * JD-Core Version:    0.7.0.1
 */