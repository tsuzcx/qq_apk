package com.tencent.mobileqq.nearby.gameroom;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$16
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$16(GameRoomInviteActivity paramGameRoomInviteActivity, String paramString1, String paramString2) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      GameRoomInviteActivity localGameRoomInviteActivity = this.c;
      boolean bool;
      if ((paramRspBody.uint64_leader_uin.has()) && (paramRspBody.uint64_leader_uin.get() != this.c.app.getLongAccountUin())) {
        bool = false;
      } else {
        bool = true;
      }
      localGameRoomInviteActivity.showMyInviteDialog(bool, paramRspBody.string_invite_id.get().toStringUtf8(), this.a, this.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.16
 * JD-Core Version:    0.7.0.1
 */