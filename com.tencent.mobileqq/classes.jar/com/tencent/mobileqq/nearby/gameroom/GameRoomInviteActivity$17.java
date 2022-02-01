package com.tencent.mobileqq.nearby.gameroom;

import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$17
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$17(GameRoomInviteActivity paramGameRoomInviteActivity, GameRoomInviteActivity.GameRoomUser paramGameRoomUser) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody != null))
    {
      paramRspBody = this.a;
      paramRspBody.b ^= true;
      this.b.refreshUI();
      this.b.mAdapter.notifyDataSetChanged();
      return;
    }
    if (paramRspBody != null) {
      this.b.handle8e4Error(paramInt, paramRspBody, HardCodeUtil.a(2131903123));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.17
 * JD-Core Version:    0.7.0.1
 */