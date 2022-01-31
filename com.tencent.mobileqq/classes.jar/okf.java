import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.biz.qqstory.support.report.VideoEditReport;
import com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePackage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FacePanel;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.FacePanelBaseAdapter;
import com.tencent.biz.qqstory.takevideo.doodle.ui.widget.FaceViewPager;

public class okf
  implements AdapterView.OnItemClickListener
{
  public okf(FacePanel paramFacePanel) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiWidgetFaceViewPager.setCurrentItem(paramInt);
    if (DoodleLayout.a) {}
    for (paramAdapterView = "2";; paramAdapterView = "1")
    {
      DoodleLayout.a("change_face", 0, 0, new String[] { paramAdapterView });
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter != null)
      {
        paramAdapterView = this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoDoodleUiFaceAdapterFacePanelBaseAdapter.a(paramInt);
        if ((paramAdapterView != null) && ((paramAdapterView instanceof FacePackage)))
        {
          VideoEditReport.a("0X80076C7", "", "", ((FacePackage)paramAdapterView).a, "");
          VideoEditReport.a("0X80075DC", ((FacePackage)paramAdapterView).a);
        }
      }
      if (paramInt == 1)
      {
        VideoEditReport.a("0X80076CC");
        VideoEditReport.b("0X80075E1");
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     okf
 * JD-Core Version:    0.7.0.1
 */