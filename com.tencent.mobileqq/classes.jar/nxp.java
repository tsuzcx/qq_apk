import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import java.util.Comparator;

public class nxp
  implements Comparator
{
  public int a(StoryHomeFeed paramStoryHomeFeed1, StoryHomeFeed paramStoryHomeFeed2)
  {
    if (paramStoryHomeFeed1.a.dateTimeMillis == paramStoryHomeFeed2.a.dateTimeMillis) {
      if ((!(paramStoryHomeFeed1 instanceof VideoListHomeFeed)) || (!VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed1))) {}
    }
    while (paramStoryHomeFeed1.a.dateTimeMillis > paramStoryHomeFeed2.a.dateTimeMillis)
    {
      return -1;
      if (((paramStoryHomeFeed2 instanceof VideoListHomeFeed)) && (VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed2))) {
        return 1;
      }
      return 0;
    }
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxp
 * JD-Core Version:    0.7.0.1
 */