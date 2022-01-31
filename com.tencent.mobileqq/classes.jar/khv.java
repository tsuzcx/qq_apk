import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;
import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;

public class khv
  implements DialogInterface.OnShowListener
{
  public khv(TraeHelper paramTraeHelper) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Trae_DRP 0X8008D1E at: " + System.currentTimeMillis());
    }
    ReportController.b(null, "CliOper", "", "", "0X8008D1E", "0X8008D1E", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     khv
 * JD-Core Version:    0.7.0.1
 */