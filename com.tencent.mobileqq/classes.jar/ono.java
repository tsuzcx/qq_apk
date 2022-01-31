import android.support.annotation.NonNull;
import android.widget.EditText;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.EditVideoParams;
import com.tencent.biz.qqstory.takevideo.doodle.ui.EditTextDialog;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.OnStrokeSelectedListener;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.stroke.HorizontalStroke;
import cooperation.qzone.report.lp.LpReportInfo_pf00064;

public class ono
  implements HorizontalSelectColorLayout.OnStrokeSelectedListener
{
  public ono(EditTextDialog paramEditTextDialog) {}
  
  public void a(@NonNull HorizontalStroke paramHorizontalStroke)
  {
    switch (paramHorizontalStroke.a)
    {
    }
    do
    {
      return;
      int i = paramHorizontalStroke.b;
      this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleLayerModelTextInfo.a = i;
      this.a.jdField_a_of_type_AndroidWidgetEditText.setTextColor(i);
      VideoEditReport.b("0X80075D8");
    } while ((this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams == null) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoParams.a != 3));
    LpReportInfo_pf00064.allReport(615, 3, 2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ono
 * JD-Core Version:    0.7.0.1
 */