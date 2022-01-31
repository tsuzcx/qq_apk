import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.biz.qqstory.base.QQStoryHandler;
import com.tencent.biz.qqstory.msgTabNode.model.MsgTabStoryNodeConfigManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class rqm
  implements CompoundButton.OnCheckedChangeListener
{
  public rqm(AssistantSettingActivity paramAssistantSettingActivity, MsgTabStoryNodeConfigManager paramMsgTabStoryNodeConfigManager) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeModelMsgTabStoryNodeConfigManager.a(paramBoolean);
    paramCompoundButton = (QQStoryHandler)this.jdField_a_of_type_ComTencentMobileqqActivityAssistantSettingActivity.app.a(98);
    int i;
    if (paramBoolean)
    {
      i = 2;
      paramCompoundButton.b(i);
      if (!paramBoolean) {
        break label70;
      }
    }
    label70:
    for (paramCompoundButton = "1";; paramCompoundButton = "2")
    {
      StoryReportor.a("msg_tab", "turn_story", 0, 0, new String[] { "2", paramCompoundButton });
      return;
      i = 1;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     rqm
 * JD-Core Version:    0.7.0.1
 */