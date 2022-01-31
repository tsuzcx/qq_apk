import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class szy
  implements Runnable
{
  public szy(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void run()
  {
    try
    {
      if ((LoginInfoActivity.a(this.a) != null) && (LoginInfoActivity.a(this.a).isShowing()))
      {
        LoginInfoActivity.a(this.a).dismiss();
        LoginInfoActivity.a(this.a).cancel();
      }
      LoginInfoActivity.a(this.a, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        localThrowable.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     szy
 * JD-Core Version:    0.7.0.1
 */