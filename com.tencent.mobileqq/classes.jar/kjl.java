import com.tencent.av.utils.TraeHelper;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class kjl
  implements ActionSheet.OnDismissListener
{
  public kjl(TraeHelper paramTraeHelper) {}
  
  public void onDismiss()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.a.a, 2, "Trae_DRP 0X8008D22 at: " + System.currentTimeMillis());
    }
    ReportController.b(null, "CliOper", "", "", "0X8008D22", "0X8008D22", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     kjl
 * JD-Core Version:    0.7.0.1
 */