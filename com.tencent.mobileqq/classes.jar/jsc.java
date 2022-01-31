import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.DoubleVideoCtrlUI;
import com.tencent.mobileqq.statistics.ReportController;

public class jsc
  implements DialogInterface.OnClickListener
{
  public jsc(DoubleVideoCtrlUI paramDoubleVideoCtrlUI) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(null, "CliOper", "", "", "0x80060EF", "0x80060EF", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jsc
 * JD-Core Version:    0.7.0.1
 */