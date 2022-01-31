import com.tencent.mobileqq.activity.AuthDevRenameActivity;
import com.tencent.mobileqq.widget.QQProgressDialog;

public class rsu
  implements Runnable
{
  public rsu(AuthDevRenameActivity paramAuthDevRenameActivity) {}
  
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
 * Qualified Name:     rsu
 * JD-Core Version:    0.7.0.1
 */