import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeDelegate;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nix
  implements Runnable
{
  public nix(MsgTabStoryNodeDelegate paramMsgTabStoryNodeDelegate, boolean paramBoolean1, boolean paramBoolean2) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a()))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a("exp_story", true, this.b);
      return;
    }
    SLog.a("Q.qqstory.msgTab.MsgTabStoryNodeDelegate", "exp_story not report because isFirstPage = %b, visible = %b", Boolean.valueOf(this.jdField_a_of_type_Boolean), Boolean.valueOf(this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeDelegate.a.a()));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nix
 * JD-Core Version:    0.7.0.1
 */