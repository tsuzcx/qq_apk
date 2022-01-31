import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.extendfriend.fragment.ExtendFriendEditFragment;
import com.tencent.mobileqq.statistics.ReportController;

public class spu
  implements View.OnClickListener
{
  public spu(FriendProfileCardActivity paramFriendProfileCardActivity, Card paramCard) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    case 2131363264: 
      if ((FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity) != null) && (FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity).isShowing())) {
        FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity).dismiss();
      }
      if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration))
      {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80092EC", "0X80092EC", 0, 0, "", "", "", "");
        return;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80092E9", "0X80092E9", 0, 0, "", "", "", "");
      return;
    }
    if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
      PublicFragmentActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.getActivity(), ExtendFriendEditFragment.class);
    }
    for (;;)
    {
      if ((FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity) != null) && (FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity).isShowing())) {
        FriendProfileCardActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity).dismiss();
      }
      if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCard.declaration)) {
        break;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80092EB", "0X80092EB", 0, 0, "", "", "", "");
      return;
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.e(false);
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, "dc00898", "", "", "0X80092E8", "0X80092E8", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spu
 * JD-Core Version:    0.7.0.1
 */