import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.mobileqq.activity.DialogActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.teamwork.TeamWorkUtils;

public class sop
  implements DialogInterface.OnClickListener
{
  public sop(DialogActivity paramDialogActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    TeamWorkUtils.a(this.a.app, this.a);
    this.a.finish();
    ReportController.b(this.a.app, "dc00898", "", "", "0X800906A", "0X800906A", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     sop
 * JD-Core Version:    0.7.0.1
 */