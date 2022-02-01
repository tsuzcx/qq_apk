package com.tencent.mobileqq.nearby.gameroom;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.utils.RouteUtils;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomTransActivity$3
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomTransActivity$3(GameRoomTransActivity paramGameRoomTransActivity, String paramString, int paramInt) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if (paramRspBody.string_err_title.has())
    {
      str1 = paramRspBody.string_err_title.get().toStringUtf8();
      if (!TextUtils.isEmpty(str1)) {
        break label36;
      }
    }
    String str1 = null;
    label36:
    if (paramRspBody.string_err_msg.has())
    {
      str2 = paramRspBody.string_err_msg.get().toStringUtf8();
      if (!TextUtils.isEmpty(str2)) {
        break label75;
      }
    }
    String str2 = null;
    label75:
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onAcceptInvite invitedId = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
      ((StringBuilder)localObject).append(" errorCode = ");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append(" ,errTitle = ");
      ((StringBuilder)localObject).append(str1);
      ((StringBuilder)localObject).append(" ,errMsgFromServer = ");
      ((StringBuilder)localObject).append(str2);
      QLog.d("qqBaseActivity", 2, ((StringBuilder)localObject).toString());
    }
    if ((paramInt != 1000) && (paramInt != 1001) && (paramInt != 1002) && (paramInt != 1003) && (paramInt != 1007))
    {
      if ((paramInt != 1004) && (paramInt != 1006) && (paramInt != 1010) && (paramInt != 1013))
      {
        if ((paramInt != 0) && (paramInt != 1005))
        {
          if (paramInt == 1008)
          {
            localObject = paramRspBody.string_invite_id.get().toStringUtf8();
            GameRoomConstants.jdField_a_of_type_JavaLangString = (String)localObject;
            paramInt = this.jdField_a_of_type_Int;
            if (paramRspBody.uint32_max_member_num.has()) {
              paramInt = paramRspBody.uint32_max_member_num.get();
            }
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showTeamExistDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, str1, str2, (String)localObject, paramInt);
          }
          else if (paramInt == 1009)
          {
            localObject = this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity;
            ((GameRoomTransActivity)localObject).dialog = DialogUtil.a((Context)localObject, 230);
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.setTitle(str1);
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.setMessage(str2);
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.setPositiveButton(HardCodeUtil.a(2131705237), new GameRoomTransActivity.3.1(this, paramRspBody));
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.setNegativeButton(2131690529, new GameRoomTransActivity.3.2(this));
            if (!this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.isFinishing()) {
              this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.show();
            }
          }
          else if (!TextUtils.isEmpty(str2))
          {
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, str1, str2);
          }
          else
          {
            QQToast.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, 1, HardCodeUtil.a(2131705213), 1).a();
            this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.finish();
          }
        }
        else
        {
          paramRspBody = new Intent();
          paramRspBody.putExtra("inviteId", this.jdField_a_of_type_JavaLangString);
          paramRspBody.putExtra("roomNum", this.jdField_a_of_type_Int);
          GameRoomConstants.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
          this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.startActivity(paramRspBody);
          RouteUtils.a(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, paramRspBody, "/nearby/gameroom/invite");
          this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.finish();
        }
      }
      else {
        this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showCreateNewGameDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, str1, str2);
      }
    }
    else {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog = ((IGameRoomUtilsDelegate)QRoute.api(IGameRoomUtilsDelegate.class)).showConfirmDialog(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity, str1, str2);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog != null) {
      this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.dialog.setOnDismissListener(this.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomTransActivity.disMissListener);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomTransActivity.3
 * JD-Core Version:    0.7.0.1
 */