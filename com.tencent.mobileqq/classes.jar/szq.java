import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class szq
  implements Runnable
{
  public szq(LoginActivity paramLoginActivity) {}
  
  public void run()
  {
    LoginActivity.a(this.a.app, this.a.app.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szq
 * JD-Core Version:    0.7.0.1
 */