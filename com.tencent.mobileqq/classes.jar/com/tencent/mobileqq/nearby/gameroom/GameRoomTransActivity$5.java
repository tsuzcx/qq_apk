package com.tencent.mobileqq.nearby.gameroom;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomTransActivity$5
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomTransActivity$5(GameRoomTransActivity paramGameRoomTransActivity, long paramLong, int paramInt1, int paramInt2) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) && (paramRspBody.string_invite_id.has()) && (!TextUtils.isEmpty(paramRspBody.string_invite_id.get().toStringUtf8())))
    {
      String str = paramRspBody.string_invite_id.get().toStringUtf8();
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, str, paramRspBody.uint32_max_member_num.get(), this.jdField_a_of_type_Long);
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("qqBaseActivity", 2, "invitedId empty");
    }
    paramRspBody = new Intent(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, GameRoomInviteActivity.class);
    paramRspBody.putExtra("roomNum", this.jdField_a_of_type_Int);
    paramRspBody.putExtra("zoneId", this.b);
    paramRspBody.putExtra("gc", this.jdField_a_of_type_Long);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.startActivity(paramRspBody);
    this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity.5
 * JD-Core Version:    0.7.0.1
 */