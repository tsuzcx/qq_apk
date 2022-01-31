import android.os.Bundle;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.campuscircle.CampusCircleObserver;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.profile.ProfileCardInfo;

public class soi
  extends CampusCircleObserver
{
  public soi(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void a(boolean paramBoolean, Bundle paramBundle, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (paramCard.uin != null) && (paramCard.uin.equals(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      this.a.runOnUiThread(new soj(this));
    }
  }
  
  public void a(boolean paramBoolean, Card paramCard)
  {
    if ((paramBoolean) && (paramCard != null) && (paramCard.uin != null) && (paramCard.uin.equals(this.a.a.jdField_a_of_type_ComTencentMobileqqActivityProfileActivity$AllInOne.a)))
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqDataCard = paramCard;
      this.a.runOnUiThread(new sok(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     soi
 * JD-Core Version:    0.7.0.1
 */