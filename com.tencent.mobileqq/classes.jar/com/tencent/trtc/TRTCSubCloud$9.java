package com.tencent.trtc;

import com.tencent.liteav.trtc.impl.TRTCRoomInfo;

class TRTCSubCloud$9
  implements Runnable
{
  TRTCSubCloud$9(TRTCSubCloud paramTRTCSubCloud, TRTCCloudListener.TRTCAudioFrameListener paramTRTCAudioFrameListener) {}
  
  public void run()
  {
    TRTCSubCloud localTRTCSubCloud = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("SubCloud setAudioFrameListener ");
    localStringBuilder.append(this.a);
    TRTCSubCloud.access$7900(localTRTCSubCloud, localStringBuilder.toString());
    TRTCSubCloud.access$8002(this.b, this.a);
    if (TRTCSubCloud.access$8100(this.b) == null)
    {
      TRTCSubCloud.access$8200(this.b).forEachUser(new TRTCSubCloud.9.1(this));
      return;
    }
    TRTCSubCloud.access$8300(this.b).forEachUser(new TRTCSubCloud.9.2(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.9
 * JD-Core Version:    0.7.0.1
 */