import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.CallbackWaitingActivityExt;
import com.tencent.mobileqq.statistics.ReportController;

public class jtq
  implements DialogInterface.OnClickListener
{
  public jtq(CallbackWaitingActivityExt paramCallbackWaitingActivityExt) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a.app, "CliOper", "", "", "0X80063FA", "0X80063FA", 5, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jtq
 * JD-Core Version:    0.7.0.1
 */