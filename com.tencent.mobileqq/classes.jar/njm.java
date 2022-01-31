import android.view.View;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;

class njm
  implements Runnable
{
  njm(njl paramnjl) {}
  
  public void run()
  {
    int i = this.a.a.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getFirstVisiblePosition();
    if (i < this.a.a.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getHeaderViewsCount())
    {
      View localView = this.a.a.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.getChildAt(0);
      if (localView == this.a.a.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView)
      {
        int j = localView.getTop();
        if ((j < 0) && (j > -localView.getHeight())) {
          this.a.a.jdField_a_of_type_ComTencentMobileqqNowEnterWidgetHongBao2018ListView.setSelection(i + 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njm
 * JD-Core Version:    0.7.0.1
 */