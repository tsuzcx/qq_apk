import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class rob
  implements Runnable
{
  public rob(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
  public void run()
  {
    try
    {
      if ((AuthDevRenameActivity.a(this.a) == null) && (!this.a.isFinishing())) {
        AuthDevRenameActivity.a(this.a, new QQProgressDialog(this.a, this.a.getTitleBarHeight()));
      }
      if ((AuthDevRenameActivity.a(this.a) != null) && (!AuthDevRenameActivity.a(this.a).isShowing()))
      {
        AuthDevRenameActivity.a(this.a).a(this.a.getString(2131436618));
        AuthDevRenameActivity.a(this.a).show();
      }
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
 * Qualified Name:     rob
 * JD-Core Version:    0.7.0.1
 */