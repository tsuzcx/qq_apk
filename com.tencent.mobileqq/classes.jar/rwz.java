import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;

public final class rwz
  implements DialogInterface.OnClickListener
{
  public rwz(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwz
 * JD-Core Version:    0.7.0.1
 */