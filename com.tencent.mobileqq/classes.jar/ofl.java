import com.tencent.biz.qqstory.storyHome.qqstorylist.LocalVideoPusher.Filter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.LocalVideoPushSegment;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.AppConstants;

public class ofl
  implements LocalVideoPusher.Filter
{
  public ofl(LocalVideoPushSegment paramLocalVideoPushSegment) {}
  
  public boolean a(LocalMediaInfo paramLocalMediaInfo)
  {
    paramLocalMediaInfo = paramLocalMediaInfo.path;
    return (paramLocalMediaInfo.startsWith(AppConstants.aW)) && (paramLocalMediaInfo.contains("QQStoryMoment"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofl
 * JD-Core Version:    0.7.0.1
 */