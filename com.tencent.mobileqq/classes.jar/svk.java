import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.profile.view.ProfileHeaderView;

public class svk
  implements Runnable
{
  public svk(FriendProfileCardActivity paramFriendProfileCardActivity) {}
  
  public void run()
  {
    if ((this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView == null) || (this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView == null)) {
      return;
    }
    int i = (int)this.a.jdField_a_of_type_ComTencentMobileqqApolloApolloTextureView.getManRectMaxHeight();
    this.a.jdField_a_of_type_ComTencentMobileqqProfileViewProfileHeaderView.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     svk
 * JD-Core Version:    0.7.0.1
 */