import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.widget.ListView;

public class nff
  implements Runnable
{
  public nff(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, int paramInt) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.c == 0) {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.smoothScrollToPositionFromTop(this.jdField_a_of_type_Int, 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nff
 * JD-Core Version:    0.7.0.1
 */