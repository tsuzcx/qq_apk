import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;

public class niy
  implements Runnable
{
  public niy(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, boolean paramBoolean, int paramInt) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && ((this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 2)) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", true, true);
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "exp_story not report because changeType = %b, visible = %b", Integer.valueOf(this.jdField_a_of_type_Int), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */