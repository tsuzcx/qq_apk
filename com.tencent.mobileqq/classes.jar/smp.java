import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.activity.ProfileActivity.CardContactInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.profile.DataTag;
import com.tencent.mobileqq.profile.ProfileCardInfo;

class smp
  implements View.OnClickListener
{
  smp(smn paramsmn) {}
  
  public void onClick(View paramView)
  {
    if (this.a.jdField_a_of_type_ComTencentMobileqqProfileDataTag == null) {}
    for (;;)
    {
      return;
      if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileDataTag.a instanceof String)) {
        paramView = (String)this.a.jdField_a_of_type_ComTencentMobileqqProfileDataTag.a;
      }
      while (paramView != null)
      {
        this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.b(paramView);
        ThreadManager.post(new smq(this), 5, null, true);
        return;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqProfileDataTag.a instanceof ProfileActivity.CardContactInfo))
        {
          paramView = (ProfileActivity.CardContactInfo)this.a.jdField_a_of_type_ComTencentMobileqqProfileDataTag.a;
          if ((this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a != null) && (this.a.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.a.a == 33)) {
            paramView = paramView.c;
          } else {
            paramView = paramView.a + " " + paramView.c;
          }
        }
        else
        {
          paramView = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     smp
 * JD-Core Version:    0.7.0.1
 */