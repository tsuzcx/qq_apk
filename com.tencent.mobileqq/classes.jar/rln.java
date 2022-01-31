import android.widget.Button;
import com.tencent.mobileqq.activity.AuthDevVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.ClearableEditText;

public class rln
  implements Runnable
{
  public rln(AuthDevVerifyCodeActivity paramAuthDevVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    String str = Utils.c(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() > 0) && (AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity) != null))
    {
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setText(str);
      AuthDevVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityAuthDevVerifyCodeActivity).setEnabled(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rln
 * JD-Core Version:    0.7.0.1
 */