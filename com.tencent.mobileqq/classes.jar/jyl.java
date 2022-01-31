import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.av.ui.PSTNC2CActivity;
import com.tencent.mobileqq.statistics.ReportController;

public class jyl
  implements DialogInterface.OnClickListener
{
  public jyl(PSTNC2CActivity paramPSTNC2CActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    ReportController.b(this.a.app, "CliOper", "", "", "0X80063FA", "0X80063FA", 5, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     jyl
 * JD-Core Version:    0.7.0.1
 */