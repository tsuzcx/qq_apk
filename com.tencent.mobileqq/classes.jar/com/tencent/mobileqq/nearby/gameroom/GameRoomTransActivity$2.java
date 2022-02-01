package com.tencent.mobileqq.nearby.gameroom;

import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.data.HotChatInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

class GameRoomTransActivity$2
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomTransActivity$2(GameRoomTransActivity paramGameRoomTransActivity, int paramInt) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    Object localObject3 = null;
    if (QLog.isColorLevel()) {
      QLog.i("qqBaseActivity", 2, "quickStartGame onCallback errorCode = " + paramInt);
    }
    Object localObject2;
    if (paramRspBody.string_err_title.has())
    {
      localObject2 = paramRspBody.string_err_title.get().toStringUtf8();
      localObject1 = localObject2;
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
    }
    for (Object localObject1 = null;; localObject1 = null)
    {
      localObject2 = localObject3;
      if (paramRspBody.string_err_msg.has())
      {
        localObject2 = paramRspBody.string_err_msg.get().toStringUtf8();
        if (!TextUtils.isEmpty((CharSequence)localObject2)) {
          break label450;
        }
        localObject2 = localObject3;
      }
      label450:
      for (;;)
      {
        if ((paramInt == 1000) || (paramInt == 1001) || (paramInt == 1002) || (paramInt == 1003) || (paramInt == 1007)) {
          this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, (String)localObject1, (String)localObject2);
        }
        for (;;)
        {
          if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog != null) {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog.setOnDismissListener(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_AndroidContentDialogInterface$OnDismissListener);
          }
          return;
          if ((paramInt == 1004) || (paramInt == 1006) || (paramInt == 1010) || (paramInt == 1013))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, (String)localObject1, (String)localObject2);
          }
          else
          {
            if ((paramInt == 0) || (paramInt == 1009))
            {
              paramRspBody = paramRspBody.poi_info;
              localObject1 = paramRspBody.bytes_uid.get().toStringUtf8();
              GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, HotChatInfo.createHotChat(paramRspBody, false, 0), paramRspBody.uint32_group_code.get(), (String)localObject1, paramRspBody.bytes_name.get().toStringUtf8());
              this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.finish();
              return;
            }
            if (paramInt == 1008)
            {
              localObject1 = paramRspBody.string_invite_id.get().toStringUtf8();
              GameRoomInviteActivity.a = (String)localObject1;
              paramInt = this.jdField_a_of_type_Int;
              if (paramRspBody.uint32_max_member_num.has()) {
                paramInt = paramRspBody.uint32_max_member_num.get();
              }
              this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, (String)localObject1, paramInt);
            }
            else
            {
              if (TextUtils.isEmpty((CharSequence)localObject2)) {
                break;
              }
              this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.jdField_a_of_type_ComTencentMobileqqUtilsQQCustomDialog = GameRoomUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, (String)localObject1, (String)localObject2);
            }
          }
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, 1, HardCodeUtil.a(2131705140), 1).a();
        if (QLog.isColorLevel()) {
          QLog.d("qqBaseActivity", 2, "start game failed! code = " + paramInt);
        }
        GameRoomTransActivity.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity.2
 * JD-Core Version:    0.7.0.1
 */