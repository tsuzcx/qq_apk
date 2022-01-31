import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class ohr
  implements View.OnClickListener
{
  public ohr(EditTextDialog paramEditTextDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    if ((this.a.a != null) && (this.a.a.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 3, 4);
    }
    VideoEditReport.a("0X80076C6");
    VideoEditReport.b("0X80075DA");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohr
 * JD-Core Version:    0.7.0.1
 */