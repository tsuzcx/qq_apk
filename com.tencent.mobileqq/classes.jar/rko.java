import com.tencent.mobileqq.activity.AuthDevActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class rko
  implements Runnable
{
  public rko(AuthDevActivity paramAuthDevActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevActivity.a(this.a) != null) && (AuthDevActivity.a(this.a).isShowing()))
      {
        AuthDevActivity.a(this.a).dismiss();
        AuthDevActivity.a(this.a).cancel();
      }
      AuthDevActivity.a(this.a, null);
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
 * Qualified Name:     rko
 * JD-Core Version:    0.7.0.1
 */