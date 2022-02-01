package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$2
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$2(CloudListenerWrapper paramCloudListenerWrapper, long paramLong) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onEnterRoom(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.2
 * JD-Core Version:    0.7.0.1
 */