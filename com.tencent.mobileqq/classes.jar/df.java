import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.dataline.activities.LiteActivity;

public class df
  implements DialogInterface.OnDismissListener
{
  public df(LiteActivity paramLiteActivity) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    if (LiteActivity.b(this.a))
    {
      LiteActivity.a(this.a, false);
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     df
 * JD-Core Version:    0.7.0.1
 */