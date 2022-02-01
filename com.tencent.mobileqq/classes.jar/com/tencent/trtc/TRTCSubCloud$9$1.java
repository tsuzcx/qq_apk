package com.tencent.trtc;

import com.tencent.liteav.audio.TXCAudioEngine;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserAction;
import com.tencent.liteav.trtc.impl.TRTCRoomInfo.UserInfo;

class TRTCSubCloud$9$1
  implements TRTCRoomInfo.UserAction
{
  TRTCSubCloud$9$1(TRTCSubCloud.9 param9) {}
  
  public void accept(String paramString, TRTCRoomInfo.UserInfo paramUserInfo)
  {
    TXCAudioEngine.getInstance().setSetAudioEngineRemoteStreamDataListener(String.valueOf(paramUserInfo.tinyID), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.trtc.TRTCSubCloud.9.1
 * JD-Core Version:    0.7.0.1
 */