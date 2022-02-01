package com.tencent.mobileqq.nearby.gameroom;

import android.util.SparseArray;
import android.view.View;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.mobileqq.werewolves.WerewolvesHandler.Callback;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import tencent.im.oidb.cmd0x8e4.oidb_0x8e4.RspBody;

class GameRoomInviteActivity$11
  implements WerewolvesHandler.Callback<oidb_0x8e4.RspBody>
{
  GameRoomInviteActivity$11(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(int paramInt, oidb_0x8e4.RspBody paramRspBody)
  {
    if ((paramInt == 0) || (paramInt == 1004))
    {
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomAVController.d();
      SharedPreUtils.a(this.a, this.a.app.getCurrentAccountUin(), false, System.currentTimeMillis());
      this.a.jdField_a_of_type_Boolean = true;
      this.a.jdField_b_of_type_Long = this.a.app.getLongAccountUin();
      this.a.jdField_b_of_type_JavaLangString = null;
      GameRoomInviteActivity.jdField_a_of_type_JavaLangString = null;
      this.a.jdField_a_of_type_JavaUtilList = null;
      this.a.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      if (this.a.jdField_b_of_type_JavaUtilList != null) {
        this.a.jdField_b_of_type_JavaUtilList.clear();
      }
      this.a.f = false;
      this.a.a();
      paramRspBody = this.a.a();
      if ((paramRspBody != null) && (paramRspBody.jdField_a_of_type_Boolean)) {
        QQToast.a(this.a, HardCodeUtil.a(2131705085), 0).a();
      }
      this.a.jdField_a_of_type_ComTencentMobileqqNearbyGameroomGameRoomInviteActivity$UserGridAdapter.notifyDataSetChanged();
      this.a.jdField_b_of_type_AndroidViewView.setVisibility(8);
    }
    for (;;)
    {
      this.a.jdField_b_of_type_AndroidViewView.setEnabled(true);
      return;
      this.a.a(paramInt, paramRspBody, (String)GameRoomInviteActivity.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.11
 * JD-Core Version:    0.7.0.1
 */