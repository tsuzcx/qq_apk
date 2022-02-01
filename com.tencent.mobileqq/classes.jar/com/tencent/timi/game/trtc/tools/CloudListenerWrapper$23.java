package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$23
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$23(CloudListenerWrapper paramCloudListenerWrapper) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onMicDidReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.23
 * JD-Core Version:    0.7.0.1
 */