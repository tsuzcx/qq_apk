import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.qphone.base.util.QLog;

public class szr
  implements Runnable
{
  public szr(LoginActivity paramLoginActivity, String paramString) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LoginActivity", 2, "-->login success(finish after ls), go to AgentActivity, account:" + this.jdField_a_of_type_JavaLangString);
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityLoginActivity.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szr
 * JD-Core Version:    0.7.0.1
 */