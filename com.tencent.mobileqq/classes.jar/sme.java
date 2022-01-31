import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.PhoneContactManagerImp;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ContactCard;
import com.tencent.mobileqq.forward.ForwardBaseOption;
import com.tencent.mobileqq.forward.ForwardShareCardOption;
import com.tencent.mobileqq.profile.ProfileCardInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.ActionSheet.OnButtonClickListener;
import mqq.app.MobileQQ;

public class sme
  implements ActionSheet.OnButtonClickListener
{
  public sme(FriendProfileCardActivity paramFriendProfileCardActivity, PhoneContactManagerImp paramPhoneContactManagerImp, boolean paramBoolean, ActionSheet paramActionSheet) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    boolean bool = true;
    switch (paramInt)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.d();
      return;
      Object localObject;
      if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApplication().getApplicationContext()))
      {
        localObject = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.k;
        paramView = (View)localObject;
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          paramView = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.nickName;
        }
        localObject = ForwardShareCardOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_JavaLangString, paramView, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.bindQQ);
        paramView = new Bundle();
        paramView.putString("uin", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataContactCard.mobileNo);
        paramView.putInt("uintype", 1006);
        paramView.putInt("forward_type", 20);
        paramView.putInt("structmsg_service_id", ((AbsShareMsg)localObject).mMsgServiceID);
        paramView.putByteArray("stuctmsg_bytes", ((AbsShareMsg)localObject).getBytes());
        paramView.putBoolean("k_dataline", false);
        paramView.putInt("pa_type", this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int);
        localObject = new Intent();
        ((Intent)localObject).putExtras(paramView);
        ForwardBaseOption.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, (Intent)localObject, 21);
        if (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.jdField_a_of_type_Int == 53) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007016", "0X8007016", 0, 0, "", "", "", "");
        } else {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "CliOper", "", "", "0X8007168", "0X8007168", 0, 0, "", "", "", "");
        }
      }
      else
      {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, "当前网络不可用", 1000).a();
        continue;
        if (NetworkUtil.d(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app.getApplication().getApplicationContext()))
        {
          paramView = this.jdField_a_of_type_ComTencentMobileqqAppPhoneContactManagerImp;
          localObject = FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne);
          label403:
          QQAppInterface localQQAppInterface;
          if (!this.jdField_a_of_type_Boolean)
          {
            paramView.a((String)localObject, bool);
            this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.G();
            localQQAppInterface = this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app;
            if (!this.jdField_a_of_type_Boolean) {
              break label479;
            }
            paramView = "0X800603E";
            label436:
            if (!this.jdField_a_of_type_Boolean) {
              break label485;
            }
          }
          label479:
          label485:
          for (localObject = "0X800603E";; localObject = "0X800603D")
          {
            ReportController.b(localQQAppInterface, "CliOper", "", "", paramView, (String)localObject, 0, 0, "", "", "", "");
            break;
            bool = false;
            break label403;
            paramView = "0X800603D";
            break label436;
          }
        }
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, 1, "当前网络不可用", 1000).a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sme
 * JD-Core Version:    0.7.0.1
 */