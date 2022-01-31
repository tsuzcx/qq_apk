import android.widget.EditText;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;
import com.tencent.mobileqq.activity.ProfileActivity;
import com.tencent.mobileqq.util.Utils;

public class rji
  implements Runnable
{
  public rji(AddFriendVerifyActivity paramAddFriendVerifyActivity, String paramString) {}
  
  public void run()
  {
    if ((ProfileActivity.e(AddFriendVerifyActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity))) && (this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a != null))
    {
      String str = this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.getText().toString();
      if (Utils.a(this.jdField_a_of_type_JavaLangString, str)) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.a.setText(this.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity.e);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rji
 * JD-Core Version:    0.7.0.1
 */