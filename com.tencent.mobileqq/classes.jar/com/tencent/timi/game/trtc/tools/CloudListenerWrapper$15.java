package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$15
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$15(CloudListenerWrapper paramCloudListenerWrapper) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onSendFirstLocalAudioFrame();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.15
 * JD-Core Version:    0.7.0.1
 */