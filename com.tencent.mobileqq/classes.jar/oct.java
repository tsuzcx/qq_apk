import android.view.MotionEvent;
import android.view.View;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo.EditDoodleExport;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter;
import com.tencent.biz.qqstory.takevideo.EditVideoFilter.ItemViewGestureListener;

public class oct
  implements EditVideoFilter.ItemViewGestureListener
{
  private long jdField_a_of_type_Long;
  
  public oct(EditVideoFilter paramEditVideoFilter) {}
  
  public void a(MotionEvent paramMotionEvent)
  {
    EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(EditDoodleExport.class);
    if (localEditDoodleExport != null) {
      localEditDoodleExport.a(paramMotionEvent);
    }
  }
  
  public void a(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - this.jdField_a_of_type_Long > 300L)
    {
      this.jdField_a_of_type_Long = l;
      paramView = (EditDoodleExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(EditDoodleExport.class);
      if (paramView != null) {
        paramView.c_();
      }
      return;
    }
    SLog.b("Q.qqstory.publish.edit.EditVideoFilter", "repeat viewpager click.");
  }
  
  public boolean a(MotionEvent paramMotionEvent1, MotionEvent paramMotionEvent2)
  {
    if (paramMotionEvent2 != null)
    {
      EditDoodleExport localEditDoodleExport = (EditDoodleExport)this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoFilter.a(EditDoodleExport.class);
      if (localEditDoodleExport != null) {}
      for (boolean bool = localEditDoodleExport.a(paramMotionEvent2);; bool = false)
      {
        if (bool)
        {
          a(paramMotionEvent1);
          a(paramMotionEvent2);
        }
        return bool;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oct
 * JD-Core Version:    0.7.0.1
 */