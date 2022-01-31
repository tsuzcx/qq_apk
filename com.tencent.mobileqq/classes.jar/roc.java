import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class roc
  implements Runnable
{
  public roc(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.a) != null) && (AuthDevRenameActivity.a(this.a).isShowing()))
      {
        AuthDevRenameActivity.a(this.a).dismiss();
        AuthDevRenameActivity.a(this.a).cancel();
      }
      AuthDevRenameActivity.a(this.a, null);
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
 * Qualified Name:     roc
 * JD-Core Version:    0.7.0.1
 */