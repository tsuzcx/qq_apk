package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$17
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$17(CloudListenerWrapper paramCloudListenerWrapper, String paramString, int paramInt) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onUserExit(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.17
 * JD-Core Version:    0.7.0.1
 */