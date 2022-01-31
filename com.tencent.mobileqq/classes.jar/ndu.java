import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.widget.ListView;

class ndu
  implements Runnable
{
  ndu(ndt paramndt) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_ComTencentWidgetListView.getFirstVisiblePosition();
    if (i < this.a.a.jdField_a_of_type_ComTencentWidgetListView.getHeaderViewsCount())
    {
      View localView = this.a.a.jdField_a_of_type_ComTencentWidgetListView.getChildAt(0);
      if (localView == this.a.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView)
      {
        int j = localView.getTop();
        if ((j < 0) && (j > -localView.getHeight())) {
          this.a.a.jdField_a_of_type_ComTencentWidgetListView.setSelection(i + 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndu
 * JD-Core Version:    0.7.0.1
 */