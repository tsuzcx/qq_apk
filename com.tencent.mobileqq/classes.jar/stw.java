import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;

public class stw
  implements ActionSheet.OnButtonClickListener
{
  public stw(FriendProfileCardActivity paramFriendProfileCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin(), "inside.myCardButton", 1, 3, 1, "", true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "card_mall", "0X8004DBF", 0, 0, "", "", "", "");
      continue;
      paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, PhotoListActivity.class);
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getClass().getName());
      paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
      paramView.putExtra("PhotoConst.IS_SINGLE_MODE", true);
      paramView.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
      paramView.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
      paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
      paramInt = ProfileCardUtil.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      int i = ProfileCardUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
      paramView.putExtra("PhotoConst.CLIP_WIDTH", paramInt);
      paramView.putExtra("PhotoConst.CLIP_HEIGHT", i);
      paramView.putExtra("PhotoConst.32_Bit_Config", true);
      paramView.putExtra("PhotoConst.TARGET_WIDTH", paramInt);
      paramView.putExtra("PhotoConst.TARGET_HEIGHT", i);
      paramView.putExtra("PhotoConst.TARGET_PATH", ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app));
      paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
      paramView.putExtra("action_cover_pick_gallery", true);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
      AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, false, true);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A87", "0X8006A87", 0, 0, "", "", "", "");
      continue;
      paramView = new Bundle();
      paramView.putInt("key_personal_album_enter_model", 2);
      paramView.putInt("_input_max", 1);
      paramView.putBoolean("key_multiple_model_need_download_img", true);
      QZoneHelper.UserInfo localUserInfo = QZoneHelper.UserInfo.a();
      localUserInfo.a = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
      paramView.putString("keyAction", "actionSelectPicture");
      paramView.putBoolean("key_need_change_to_jpg", true);
      QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, localUserInfo, paramView, 1020);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A88", "0X8006A88", 0, 0, "", "", "", "");
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1021);
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A89", "0X8006A89", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     stw
 * JD-Core Version:    0.7.0.1
 */