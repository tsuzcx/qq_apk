import android.widget.TextView;
import com.tencent.mobileqq.activity.AddFriendActivity;

public class rms
  implements Runnable
{
  public rms(AddFriendActivity paramAddFriendActivity, String paramString) {}
  
  public void run()
  {
    AddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity).setText(this.jdField_a_of_type_JavaLangString);
    AddFriendActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendActivity).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rms
 * JD-Core Version:    0.7.0.1
 */