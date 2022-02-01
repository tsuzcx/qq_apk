package com.tencent.timi.game.trtc.tools;

import com.tencent.trtc.TRTCCloudListener;
import java.util.ArrayList;

class CloudListenerWrapper$25
  implements CloudListenerInformer.IInformCallback
{
  CloudListenerWrapper$25(CloudListenerWrapper paramCloudListenerWrapper, ArrayList paramArrayList, int paramInt) {}
  
  public void a(TRTCCloudListener paramTRTCCloudListener)
  {
    paramTRTCCloudListener.onUserVoiceVolume(this.a, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.trtc.tools.CloudListenerWrapper.25
 * JD-Core Version:    0.7.0.1
 */