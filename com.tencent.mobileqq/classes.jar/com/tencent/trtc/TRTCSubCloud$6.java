package com.tencent.trtc;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.trtc.impl.TRTCCloudImpl;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;
import java.lang.ref.WeakReference;

class TRTCSubCloud$6
  implements Runnable
{
  TRTCSubCloud$6(TRTCSubCloud paramTRTCSubCloud, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("muteLocalVideo ");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", roomId=");
    localStringBuilder.append(TRTCSubCloud.access$5800(this.b).getRoomId());
    TRTCSubCloud.access$5900((TRTCSubCloud)localObject, localStringBuilder.toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(String.format("muteLocalVideo mute:%b", new Object[] { Boolean.valueOf(this.a) }));
    ((StringBuilder)localObject).append(" self:");
    ((StringBuilder)localObject).append(this.b.hashCode());
    Monitor.a(1, ((StringBuilder)localObject).toString(), "", 0);
    localObject = (TRTCCloudImpl)this.b.mMainCloud.get();
    if (localObject != null) {
      ((TRTCCloudImpl)localObject).muteLocalVideo(this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.6
 * JD-Core Version:    0.7.0.1
 */