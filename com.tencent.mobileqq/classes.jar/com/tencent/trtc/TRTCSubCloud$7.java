package com.tencent.trtc;

import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import java.lang.ref.WeakReference;

class TRTCSubCloud$7
  implements Runnable
{
  TRTCSubCloud$7(TRTCSubCloud paramTRTCSubCloud, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalAudio ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(TRTCSubCloud.access$6100(this.b).getRoomId());
    TRTCSubCloud.access$6200((TRTCSubCloud)localObject, localStringBuilder.toString());
    localObject = (TRTCCloudImpl)this.b.mMainCloud.get();
    if (localObject != null) {
      ((TRTCCloudImpl)localObject).muteLocalAudio(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.7
 * JD-Core Version:    0.7.0.1
 */