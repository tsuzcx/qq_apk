import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.model.item.HotTopicInfoItem;
import com.tencent.biz.qqstory.storyHome.discover.view.QQStoryDiscoverFragment;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nwg
  implements View.OnClickListener
{
  public nwg(StoryDiscoverActivity paramStoryDiscoverActivity) {}
  
  public void onClick(View paramView)
  {
    if (StoryDiscoverActivity.a(this.a) > 0L)
    {
      if (StoryDiscoverActivity.a(this.a).a() == null) {
        break label96;
      }
      paramView = String.valueOf(StoryDiscoverActivity.a(this.a).a().mTopicId);
      if (StoryDiscoverActivity.a(this.a).a() == null) {
        break label102;
      }
    }
    label96:
    label102:
    for (String str = StoryDiscoverActivity.a(this.a).a().mSubjectName;; str = "")
    {
      StoryReportor.a("content_flow", "clk_share", 0, 0, new String[] { paramView, "", str });
      return;
      paramView = "";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwg
 * JD-Core Version:    0.7.0.1
 */