import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendFeedItem;
import com.tencent.biz.qqstory.storyHome.model.HotRecommendHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import java.util.Comparator;

public class nzb
  implements Comparator
{
  public int a(StoryHomeFeed paramStoryHomeFeed1, StoryHomeFeed paramStoryHomeFeed2)
  {
    int k = 1;
    int i;
    int j;
    if (((paramStoryHomeFeed1 instanceof HotRecommendHomeFeed)) && (((HotRecommendFeedItem)((HotRecommendHomeFeed)paramStoryHomeFeed1).a()).mIsTopLocation))
    {
      i = 1;
      if ((!(paramStoryHomeFeed2 instanceof HotRecommendHomeFeed)) || (!((HotRecommendFeedItem)((HotRecommendHomeFeed)paramStoryHomeFeed2).a()).mIsTopLocation)) {
        break label80;
      }
      j = 1;
      label54:
      if ((j ^ i) == 0) {
        break label86;
      }
      j = k;
      if (i != 0) {
        j = -1;
      }
    }
    label80:
    label86:
    do
    {
      do
      {
        return j;
        i = 0;
        break;
        j = 0;
        break label54;
        if (paramStoryHomeFeed1.a.dateTimeMillis != paramStoryHomeFeed2.a.dateTimeMillis) {
          break label146;
        }
        if (((paramStoryHomeFeed1 instanceof VideoListHomeFeed)) && (VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed1))) {
          return -1;
        }
        if (!(paramStoryHomeFeed2 instanceof VideoListHomeFeed)) {
          break label144;
        }
        j = k;
      } while (VideoListHomeFeed.a((VideoListHomeFeed)paramStoryHomeFeed2));
      return 0;
      j = k;
    } while (paramStoryHomeFeed1.a.dateTimeMillis <= paramStoryHomeFeed2.a.dateTimeMillis);
    label144:
    label146:
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzb
 * JD-Core Version:    0.7.0.1
 */