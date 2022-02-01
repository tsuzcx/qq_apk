package com.tencent.trtc;

import com.tencent.liteav.basic.module.Monitor;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo;

class TRTCSubCloud$3
  implements Runnable
{
  TRTCSubCloud$3(TRTCSubCloud paramTRTCSubCloud) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("exitRoom ");
    ((StringBuilder)localObject).append(TRTCSubCloud.access$5000(this.a).getRoomId());
    ((StringBuilder)localObject).append(", ");
    ((StringBuilder)localObject).append(this.a.hashCode());
    localObject = ((StringBuilder)localObject).toString();
    TRTCSubCloud.access$5100(this.a, (String)localObject);
    Monitor.a(1, (String)localObject, "", 0);
    this.a.exitRoomInternal(true, "call from api");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.3
 * JD-Core Version:    0.7.0.1
 */