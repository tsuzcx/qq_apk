import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;
import com.tencent.av.utils.PstnUtils;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.PhotoUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.hitrate.PreloadProcHitSession;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.AvatarPendantUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import cooperation.qzone.QZoneHelper;
import cooperation.qzone.QZoneHelper.UserInfo;
import java.util.HashMap;

public class spe
  implements ActionSheet.OnButtonClickListener
{
  public spe(FriendProfileCardActivity paramFriendProfileCardActivity, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt == null) || (paramInt >= this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt.length)) {
      return;
    }
    switch (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ArrayOfInt[paramInt])
    {
    }
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
        return;
      }
      catch (Exception paramView)
      {
        paramView.printStackTrace();
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.c(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$CardContactInfo);
      continue;
      if (ProfileActivity.AllInOne.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a))
      {
        this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString))
        {
          ThreadManager.post(new spf(this), 5, null, true);
          continue;
          Object localObject;
          if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView != null)
          {
            paramView = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_face");
            localObject = (View)this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_JavaUtilHashMap.get("map_key_avatar_pendant");
            long l = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.jdField_a_of_type_Long;
            if ((!ProfileActivity.AllInOne.f(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)) || (localObject == null) || (paramView == null) || (((View)localObject).getVisibility() != 0) || (l == 0L)) {
              break label415;
            }
            ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString, l, 0);
          }
          for (;;)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004175", "0X8004175", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.h), 0, "", "", "", "");
            break;
            label415:
            if (paramView != null) {
              ProfileCardUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString);
            }
          }
          this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_AndroidNetUri = ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 5);
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004176", "0X8004176", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.h), 0, "", "", "", "");
          continue;
          paramView = new Intent();
          paramInt = ProfileCardUtil.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity);
          paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
          paramView.putExtra("Business_Origin", 100);
          PhotoUtils.a(paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, FriendProfileCardActivity.class.getName(), paramInt, paramInt, 640, 640, ProfileCardUtil.a());
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8004177", "0X8004177", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.h), 0, "", "", "", "");
          continue;
          try
          {
            paramView = QZoneHelper.UserInfo.a();
            paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
            paramView.b = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentNickname();
            QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, paramView, Long.valueOf(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_JavaLangString).longValue(), -1);
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "P_prof", "Pp_more_qzone", ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.h), 0, Integer.toString(ProfileActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a)), "", "", "");
          }
          catch (Exception paramView) {}
          if (QLog.isColorLevel())
          {
            QLog.i("Q.profilecard.FrdProfileCard", 2, paramView.toString());
            continue;
            if (!Utils.a())
            {
              Toast.makeText(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getApplicationContext(), this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getString(2131434770), 0).show();
            }
            else
            {
              boolean bool2 = true;
              boolean bool1 = bool2;
              if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo != null)
              {
                bool1 = bool2;
                if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a != null)
                {
                  bool1 = bool2;
                  if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo.a.jdField_a_of_type_Int != 0) {
                    bool1 = false;
                  }
                }
              }
              this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentMobileqqHitratePreloadProcHitSession.b();
              AvatarPendantUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, bool1, null);
              ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "AvatarClick", "ZhurenInfoButtonClick", 0, 0, "", "", "", "");
              continue;
              if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k == 1) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k == 2))
              {
                ChatActivityUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.jdField_a_of_type_ComTencentAvAppPstnSessionInfo, 1);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006406", "0X8006406", 7, 0, "", "", "", "");
              }
              else if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.k == 5)
              {
                PstnUtils.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, 6);
                continue;
                paramView = new Intent(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, PhotoListActivity.class);
                paramView.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getClass().getName());
                paramView.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
                paramView.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", false);
                paramView.putExtra("PhotoConst.IS_SINGLE_MODE", false);
                paramView.putExtra("PhotoConst.IS_FINISH_RESTART_INIT_ACTIVITY", true);
                paramView.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
                paramView.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 9);
                this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(paramView);
                AlbumUtil.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, false, true);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A85", "0X8006A85", 0, 0, "", "", "", "");
                continue;
                paramView = new Bundle();
                paramView.putInt("key_personal_album_enter_model", 1);
                paramView.putInt("_input_max", 9);
                paramView.putBoolean("key_multiple_model_need_download_img", true);
                localObject = QZoneHelper.UserInfo.a();
                ((QZoneHelper.UserInfo)localObject).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getCurrentAccountUin();
                paramView.putString("keyAction", "actionSelectPicture");
                paramView.putBoolean("key_need_change_to_jpg", true);
                QZoneHelper.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (QZoneHelper.UserInfo)localObject, paramView, 1019);
                ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8006A86", "0X8006A86", 0, 0, "", "", "", "");
              }
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spe
 * JD-Core Version:    0.7.0.1
 */