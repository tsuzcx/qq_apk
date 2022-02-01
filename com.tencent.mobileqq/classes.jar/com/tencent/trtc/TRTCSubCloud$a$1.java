package com.tencent.trtc;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;
import java.util.ArrayList;

class TRTCSubCloud$a$1
  implements TRTCRoomInfo.UserAction
{
  TRTCSubCloud$a$1(TRTCSubCloud.a parama, ArrayList paramArrayList) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    int i = TXCAudioEngine.getInstance().getRemotePlayoutVolumeLevel(String.valueOf(paramUserInfo.tinyID));
    if (i > 0)
    {
      paramString = new TRTCCloudDef.TRTCVolumeInfo();
      paramString.userId = paramUserInfo.userID;
      paramString.volume = i;
      this.a.add(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.a.1
 * JD-Core Version:    0.7.0.1
 */