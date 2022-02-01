package com.tencent.mobileqq.nearby.gameroom;

import android.util.SparseArray;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$10
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$10(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramInt == 0)
    {
      Object localObject = this.a;
      String str = paramRspBody.string_invite_id.get().toStringUtf8();
      ((GameRoomInviteActivity)localObject).mInviteId = str;
      GameRoomConstants.a = str;
      this.a.mOwnerUin = paramRspBody.uint64_leader_uin.get();
      this.a.reqUserList();
      paramRspBody = this.a;
      SharedPreUtils.a(paramRspBody, paramRspBody.app.getCurrentAccountUin(), true, System.currentTimeMillis());
      if ((this.a.mGc > 0L) && (this.a.isInviteTroop))
      {
        paramRspBody = this.a;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("");
        ((StringBuilder)localObject).append(this.a.mGc);
        GameRoomInviteActivity.access$000(paramRspBody, ((StringBuilder)localObject).toString(), 1);
      }
    }
    else
    {
      this.a.handle8e4Error(paramInt, paramRspBody, (String)GameRoomInviteActivity.errorCodeMsgs.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.10
 * JD-Core Version:    0.7.0.1
 */