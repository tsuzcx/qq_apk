import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;

public final class rwe
  implements DialogInterface.OnClickListener
{
  public rwe(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwe
 * JD-Core Version:    0.7.0.1
 */