package com.tencent.mobileqq.nearby.gameroom;

import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$4
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$4(GameRoomInviteActivity paramGameRoomInviteActivity, boolean paramBoolean) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.b = paramRspBody.string_invite_id.get().toStringUtf8();
      GameRoomInviteActivity.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.b;
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a(false);
      return;
    }
    paramRspBody = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity;
    GameRoomInviteActivity.jdField_a_of_type_JavaLangString = null;
    paramRspBody.b = null;
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.c();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.4
 * JD-Core Version:    0.7.0.1
 */