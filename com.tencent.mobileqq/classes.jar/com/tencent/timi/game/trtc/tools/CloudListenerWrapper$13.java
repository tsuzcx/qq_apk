package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$13
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$13(CloudListenerWrapper paramCloudListenerWrapper, String paramString) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onFirstAudioFrame(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.13
 * JD-Core Version:    0.7.0.1
 */