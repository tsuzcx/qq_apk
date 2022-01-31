import android.content.Intent;
import com.tencent.mobileqq.activity.FriendProfileCardActivity;
import com.tencent.mobileqq.app.TroopManager.callbackInMainThread;

public class sut
  implements TroopManager.callbackInMainThread
{
  public sut(FriendProfileCardActivity paramFriendProfileCardActivity, Intent paramIntent) {}
  
  public void a(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.jdField_a_of_type_AndroidContentIntent.putExtra("troop_uin", (String)paramObject);
      this.jdField_a_of_type_AndroidContentIntent.putExtra("cSpecialFlag", 0);
      this.jdField_a_of_type_ComTencentMobileqqActivityFriendProfileCardActivity.startActivity(this.jdField_a_of_type_AndroidContentIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sut
 * JD-Core Version:    0.7.0.1
 */