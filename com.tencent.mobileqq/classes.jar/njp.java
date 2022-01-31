import android.os.Handler;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;

public class njp
  implements Runnable
{
  int jdField_a_of_type_Int = 0;
  
  public njp(MsgTabStoryNodeView paramMsgTabStoryNodeView) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a(this.jdField_a_of_type_Int);
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.invalidate(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_a_of_type_AndroidGraphicsRect);
    if (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.b) {
      if (this.jdField_a_of_type_Int >= 110) {
        break label70;
      }
    }
    label70:
    for (this.jdField_a_of_type_Int += 1;; this.jdField_a_of_type_Int = -10)
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.jdField_a_of_type_AndroidOsHandler.postDelayed(this, 1000L);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njp
 * JD-Core Version:    0.7.0.1
 */