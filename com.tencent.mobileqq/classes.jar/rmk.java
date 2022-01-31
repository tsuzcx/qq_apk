import com.tencent.mobileqq.activity.AddAccountActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class rmk
  implements Runnable
{
  public rmk(AddAccountActivity paramAddAccountActivity) {}
  
  public void run()
  {
    AddAccountActivity.a(this.a.app, this.a.app.getAccount());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rmk
 * JD-Core Version:    0.7.0.1
 */