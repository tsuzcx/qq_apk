import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity.StoryMessageListAdapter;

public class ocs
  implements Runnable
{
  public ocs(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void run()
  {
    this.a.a.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ocs
 * JD-Core Version:    0.7.0.1
 */