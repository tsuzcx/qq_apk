import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Condition;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.biz.qqstory.takevideo2.StoryPublishLauncher;

public class nzc
  implements LocalVideoPusher.Condition
{
  public nzc(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public boolean a()
  {
    return StoryPublishLauncher.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzc
 * JD-Core Version:    0.7.0.1
 */