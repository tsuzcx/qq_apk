import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nwo
  implements View.OnClickListener
{
  public nwo(StoryMessageListActivity paramStoryMessageListActivity, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeMessagenotifyStoryMessageListActivity.a(this.jdField_a_of_type_Int);
    StoryReportor.a("play_video", "del_notice", 0, 0, new String[] { "", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwo
 * JD-Core Version:    0.7.0.1
 */