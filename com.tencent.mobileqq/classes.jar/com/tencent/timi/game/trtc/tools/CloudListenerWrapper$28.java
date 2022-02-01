package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$28
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$28(CloudListenerWrapper paramCloudListenerWrapper, String paramString, byte[] paramArrayOfByte) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onRecvSEIMsg(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.28
 * JD-Core Version:    0.7.0.1
 */