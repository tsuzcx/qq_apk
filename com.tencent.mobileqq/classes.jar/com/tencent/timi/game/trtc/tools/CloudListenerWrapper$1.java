package com.tencent.timi.game.trtc.tools;

import android.os.Bundle;
import com.tencent.trtc.TRTCCloudListener;

class CloudListenerWrapper$1
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$1(CloudListenerWrapper paramCloudListenerWrapper, int paramInt, String paramString, Bundle paramBundle) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onError(this.a, this.b, this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.1
 * JD-Core Version:    0.7.0.1
 */