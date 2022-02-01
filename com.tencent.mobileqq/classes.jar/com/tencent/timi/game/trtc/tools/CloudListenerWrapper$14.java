package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$14
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$14(CloudListenerWrapper paramCloudListenerWrapper, int paramInt) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onSendFirstLocalVideoFrame(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.14
 * JD-Core Version:    0.7.0.1
 */