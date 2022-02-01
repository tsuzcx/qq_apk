package com.tencent.mobileqq.hotchat.app;

import android.text.TextUtils;
import com.tencent.mobileqq.nearby.gameroom.IGameRoomAVControllerDelegate;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class HotChatHandler$1
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  HotChatHandler$1(HotChatHandler paramHotChatHandler) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      paramRspBody = paramRspBody.string_invite_id.get().toStringUtf8();
      if (!TextUtils.isEmpty(paramRspBody))
      {
        com.tencent.mobileqq.nearby.gameroom.GameRoomConstants.a = paramRspBody;
        ((IGameRoomAVControllerDelegate)QRoute.api(IGameRoomAVControllerDelegate.class)).showFloatView(0, paramRspBody, 0L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.app.HotChatHandler.1
 * JD-Core Version:    0.7.0.1
 */