import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout;
import com.tencent.biz.qqstory.takevideo.view.widget.colorbar.HorizontalSelectColorLayout.OnUndoViewClickListener;

public class ome
  implements View.OnClickListener
{
  public ome(HorizontalSelectColorLayout paramHorizontalSelectColorLayout) {}
  
  public void onClick(View paramView)
  {
    SLog.b("SelectColorLayout", "onUndoClick: undoTypeEnable=" + this.a.jdField_a_of_type_Boolean);
    if (HorizontalSelectColorLayout.a(this.a) > System.currentTimeMillis()) {}
    while ((!this.a.jdField_a_of_type_Boolean) || (this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener == null)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryTakevideoViewWidgetColorbarHorizontalSelectColorLayout$OnUndoViewClickListener.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ome
 * JD-Core Version:    0.7.0.1
 */