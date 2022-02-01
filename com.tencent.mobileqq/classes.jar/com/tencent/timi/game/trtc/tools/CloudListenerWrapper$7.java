package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$7
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$7(CloudListenerWrapper paramCloudListenerWrapper, String paramString) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onRemoteUserEnterRoom(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.7
 * JD-Core Version:    0.7.0.1
 */