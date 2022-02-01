package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$5
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$5(CloudListenerWrapper paramCloudListenerWrapper, String paramString1, int paramInt, String paramString2) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onConnectOtherRoom(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.5
 * JD-Core Version:    0.7.0.1
 */