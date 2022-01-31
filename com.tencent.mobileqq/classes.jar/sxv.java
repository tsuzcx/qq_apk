import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.LoginVerifyCodeActivity;
import com.tencent.mobileqq.util.Utils;

public class sxv
  implements Runnable
{
  public sxv(LoginVerifyCodeActivity paramLoginVerifyCodeActivity, String paramString1, String paramString2) {}
  
  public void run()
  {
    int k = 0;
    String str = Utils.b(this.jdField_a_of_type_JavaLangString, this.b);
    if ((str != null) && (str.length() == 6) && (LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity) != null) && (!str.equals(LoginVerifyCodeActivity.b(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity))))
    {
      LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity, str);
      int m = 1;
      int i = 0;
      for (;;)
      {
        int j = m;
        if (i < 6)
        {
          Editable localEditable = LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity)[i].getText();
          if ((localEditable != null) && (localEditable.toString().length() > 0)) {
            j = 0;
          }
        }
        else
        {
          if (j == 0) {
            break;
          }
          i = k;
          while (i < 6)
          {
            LoginVerifyCodeActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityLoginVerifyCodeActivity)[i].setText(str.substring(i, i + 1));
            i += 1;
          }
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sxv
 * JD-Core Version:    0.7.0.1
 */