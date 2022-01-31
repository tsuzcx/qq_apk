import android.view.View;
import android.view.View.OnLayoutChangeListener;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.now.enter.widget.HongBao2018ListView;

public class njn
  implements View.OnLayoutChangeListener
{
  public njn(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager, StoryConfigManager paramStoryConfigManager) {}
  
  public void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    SLog.b(MsgTabStoryNodeListManager.a(), "onLayoutChange");
    if ((paramInt4 - paramInt2 > 0) && (paramInt3 - paramInt1 > 0) && (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.d) && (!this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.a.mForStory))
    {
      SLog.b(MsgTabStoryNodeListManager.a(), "first show node, showStoryNode");
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.d = false;
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryConfigManager.b("first_show_node", Boolean.valueOf(false));
      this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeListManager.i();
      StoryReportor.a("msg_tab", "exp_new", 0, 0, new String[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njn
 * JD-Core Version:    0.7.0.1
 */