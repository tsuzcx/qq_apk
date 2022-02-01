package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$27
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$27(CloudListenerWrapper paramCloudListenerWrapper, String paramString, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onMissCustomCmdMsg(this.a, this.b, this.c, this.d);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.27
 * JD-Core Version:    0.7.0.1
 */