package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$10
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$10(CloudListenerWrapper paramCloudListenerWrapper, String paramString, boolean paramBoolean) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onUserSubStreamAvailable(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.10
 * JD-Core Version:    0.7.0.1
 */