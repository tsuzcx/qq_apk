package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$11
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$11(CloudListenerWrapper paramCloudListenerWrapper, String paramString, boolean paramBoolean) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onUserAudioAvailable(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.11
 * JD-Core Version:    0.7.0.1
 */