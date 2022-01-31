import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.AddFriendVerifyActivity;

class rjp
  implements Runnable
{
  rjp(rjo paramrjo, String paramString) {}
  
  public void run()
  {
    TextView localTextView;
    if (AddFriendVerifyActivity.b(this.jdField_a_of_type_Rjo.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity).isShown())
    {
      localTextView = AddFriendVerifyActivity.b(this.jdField_a_of_type_Rjo.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
      if (!TextUtils.isEmpty(this.jdField_a_of_type_Rjo.jdField_a_of_type_JavaLangString)) {
        break label91;
      }
      str = this.jdField_a_of_type_JavaLangString;
      localTextView.setText(str);
      if (AppSetting.b)
      {
        localTextView = AddFriendVerifyActivity.b(this.jdField_a_of_type_Rjo.jdField_a_of_type_ComTencentMobileqqActivityAddFriendVerifyActivity);
        if (!TextUtils.isEmpty(this.jdField_a_of_type_Rjo.jdField_a_of_type_JavaLangString)) {
          break label102;
        }
      }
    }
    label91:
    label102:
    for (String str = this.jdField_a_of_type_JavaLangString;; str = this.jdField_a_of_type_Rjo.jdField_a_of_type_JavaLangString)
    {
      localTextView.setContentDescription(str);
      return;
      str = this.jdField_a_of_type_Rjo.jdField_a_of_type_JavaLangString;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rjp
 * JD-Core Version:    0.7.0.1
 */