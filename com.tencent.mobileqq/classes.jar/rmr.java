import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendActivity;

public class rmr
  implements Runnable
{
  public rmr(AddFriendActivity paramAddFriendActivity, int paramInt) {}
  
  public void run()
  {
    AddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity).setText(this.jdField_a_of_type_Int);
    AddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmr
 * JD-Core Version:    0.7.0.1
 */