import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.utils.DataReport;
import com.tencent.mobileqq.activity.ChatActivityUtils.StartVideoListener;

public final class rwy
  implements DialogInterface.OnClickListener
{
  public rwy(ChatActivityUtils.StartVideoListener paramStartVideoListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a != null) {
      this.a.a();
    }
    paramDialogInterface.dismiss();
    DataReport.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rwy
 * JD-Core Version:    0.7.0.1
 */