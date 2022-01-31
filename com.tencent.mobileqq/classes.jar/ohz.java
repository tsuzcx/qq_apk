import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.OnStrokeSelectedListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class ohz
  implements HorizontalSelectColorLayout.OnStrokeSelectedListener
{
  public ohz(DoodleLayout paramDoodleLayout) {}
  
  public void a(@NonNull HorizontalStroke paramHorizontalStroke)
  {
    VideoEditReport.b("0X80075CD");
    if ((this.a.a != null) && (this.a.a.a == 3)) {
      LpReportInfo_pf00064.allReport(615, 1, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ohz
 * JD-Core Version:    0.7.0.1
 */