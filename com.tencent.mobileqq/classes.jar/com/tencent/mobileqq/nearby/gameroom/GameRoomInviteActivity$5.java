package com.tencent.mobileqq.nearby.gameroom;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$5
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$5(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      this.a.b = paramRspBody.string_invite_id.get().toStringUtf8();
      GameRoomInviteActivity.a = this.a.b;
    }
    for (;;)
    {
      this.a.a(true);
      return;
      paramRspBody = this.a;
      GameRoomInviteActivity.a = null;
      paramRspBody.b = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.5
 * JD-Core Version:    0.7.0.1
 */