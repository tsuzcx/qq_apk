import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Condition;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;

public class oau
  implements LocalVideoPusher.Condition
{
  public oau(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public boolean a()
  {
    return StoryPublishLauncher.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oau
 * JD-Core Version:    0.7.0.1
 */