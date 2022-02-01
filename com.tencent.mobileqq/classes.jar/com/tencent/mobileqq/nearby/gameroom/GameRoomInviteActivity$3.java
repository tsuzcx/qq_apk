package com.tencent.mobileqq.nearby.gameroom;

import android.view.View;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;

class GameRoomInviteActivity$3
  implements RecentUserInvitePanel.OnClickListener
{
  GameRoomInviteActivity$3(GameRoomInviteActivity paramGameRoomInviteActivity) {}
  
  public void a(View paramView)
  {
    this.a.shareToMobileQQ();
    ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_more", 0, 0, "", "", "", "");
  }
  
  public void a(View paramView, InviteUser paramInviteUser)
  {
    if (paramInviteUser.jdField_a_of_type_Boolean)
    {
      QQToast.a(this.a, 1, HardCodeUtil.a(2131705211), 1).a();
      return;
    }
    GameRoomInviteActivity.access$000(this.a, paramInviteUser.jdField_a_of_type_JavaLangString, paramInviteUser.jdField_a_of_type_Int);
    paramInviteUser.jdField_a_of_type_Boolean = true;
    this.a.mRecentInvitePanel.a(paramView, paramInviteUser.jdField_a_of_type_Boolean);
    if (paramInviteUser.jdField_a_of_type_Int == 1)
    {
      ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
      return;
    }
    if (paramInviteUser.jdField_a_of_type_Int == 0) {
      ReportController.b(this.a.app, "dc00899", "Grp_wolf", "", "invite_page", "clk_invite", 0, 0, "1", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.GameRoomInviteActivity.3
 * JD-Core Version:    0.7.0.1
 */