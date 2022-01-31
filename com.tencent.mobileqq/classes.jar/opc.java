import android.view.View;
import android.view.View.OnLongClickListener;
import com.tencent.biz.qqstory.view.widget.InnerListView;
import com.tencent.biz.qqstory.view.widget.InnerListView.OnItemLongClickListener;

public class opc
  implements View.OnLongClickListener
{
  public opc(InnerListView paramInnerListView, int paramInt) {}
  
  public boolean onLongClick(View paramView)
  {
    if ((InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView) != null) && (InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView) != null)) {
      return InnerListView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView).a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetInnerListView, paramView, this.jdField_a_of_type_Int);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     opc
 * JD-Core Version:    0.7.0.1
 */