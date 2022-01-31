import com.tencent.biz.qqstory.msgTabNode.model.MsgTabNodeInfo;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.ActionSheet.OnDismissListener;

public class ndw
  implements ActionSheet.OnDismissListener
{
  public ndw(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, MsgTabNodeInfo paramMsgTabNodeInfo) {}
  
  public void onDismiss()
  {
    StoryReportor.a("msg_tab", "clk_press", 0, 0, new String[] { this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_Int + "", "8", "", this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabNodeInfo.jdField_a_of_type_JavaLangString });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndw
 * JD-Core Version:    0.7.0.1
 */