import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.av.ui.MultiIncomingCallsActivity;
import com.tencent.mobileqq.utils.QAVGroupConfig.Report;

public class jxp
  implements DialogInterface.OnCancelListener
{
  public jxp(MultiIncomingCallsActivity paramMultiIncomingCallsActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.a("onClickCancel", true, null, -1);
    this.a.b("onClickCancel");
    QAVGroupConfig.Report.a(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     jxp
 * JD-Core Version:    0.7.0.1
 */