import android.app.Activity;
import android.view.View;
import com.tencent.biz.qqstory.base.StoryHaloManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.mobileqq.activity.recent.data.RecentItemChatMsgData;

public class ndm
  implements Runnable
{
  public ndm(StoryHaloManager paramStoryHaloManager, RecentItemChatMsgData paramRecentItemChatMsgData, View paramView) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryBaseStoryHaloManager.a(this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.a()) == null) {}
    Activity localActivity;
    do
    {
      return;
      localActivity = (Activity)this.jdField_a_of_type_AndroidViewView.getContext();
    } while (localActivity == null);
    localActivity.runOnUiThread(new ndn(this, localActivity));
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.q == -1) {}
    for (int i = 1;; i = 0)
    {
      StoryReportor.a("msg_tab", "circle_clk", 0, i, new String[] { this.jdField_a_of_type_ComTencentMobileqqActivityRecentDataRecentItemChatMsgData.a() });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndm
 * JD-Core Version:    0.7.0.1
 */