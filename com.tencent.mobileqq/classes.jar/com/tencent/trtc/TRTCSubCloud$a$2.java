package com.tencent.trtc;

import java.util.ArrayList;

class TRTCSubCloud$a$2
  implements Runnable
{
  TRTCSubCloud$a$2(TRTCSubCloud.a parama, TRTCCloudListener paramTRTCCloudListener, ArrayList paramArrayList) {}
  
  public void run()
  {
    TRTCCloudListener localTRTCCloudListener = this.a;
    if (localTRTCCloudListener != null) {
      localTRTCCloudListener.onUserVoiceVolume(this.b, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.a.2
 * JD-Core Version:    0.7.0.1
 */