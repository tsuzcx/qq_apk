import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public final class suq
  implements DialogInterface.OnClickListener
{
  public suq(QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, ProfileCardInfo paramProfileCardInfo) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FriendProfileCardActivity.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqProfileProfileCardInfo);
    if (paramDialogInterface != null) {
      paramDialogInterface.dismiss();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     suq
 * JD-Core Version:    0.7.0.1
 */