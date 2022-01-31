import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.PersonalityLabel.PersonalityLabelHandler;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class spa
  implements Runnable
{
  public spa(FriendProfileCardActivity paramFriendProfileCardActivity, PersonalityLabelHandler paramPersonalityLabelHandler) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a == null) || (this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard == null)) {
      return;
    }
    PersonalityLabelHandler localPersonalityLabelHandler = this.jdField_a_of_type_ComTencentMobileqqProfilePersonalityLabelPersonalityLabelHandler;
    PersonalityLabelHandler.a(this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.app, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a.jdField_a_of_type_ComTencentMobileqqDataCard.personalityLabel, this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     spa
 * JD-Core Version:    0.7.0.1
 */