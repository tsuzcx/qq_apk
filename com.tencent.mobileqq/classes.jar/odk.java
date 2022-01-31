import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedPresenter;
import com.tencent.biz.qqstory.storyHome.model.StoryHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class odk
  implements Runnable
{
  public odk(HomeFeedPresenter paramHomeFeedPresenter, ArrayList paramArrayList) {}
  
  public void run()
  {
    FeedVideoManager localFeedVideoManager = (FeedVideoManager)SuperManager.a(12);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (StoryHomeFeed)localIterator.next();
      if ((localObject instanceof VideoListHomeFeed))
      {
        localObject = (VideoListHomeFeed)localObject;
        FeedVideoInfo localFeedVideoInfo = ((VideoListHomeFeed)localObject).a().getVideoInfo();
        localFeedVideoInfo.mVideoItemList.addAll(((VideoListHomeFeed)localObject).a());
        localFeedVideoManager.a(0, localFeedVideoInfo.feedId, localFeedVideoInfo.mVideoSeq, localFeedVideoInfo.mVideoItemList, localFeedVideoInfo.mVideoNextCookie, localFeedVideoInfo.mIsVideoEnd, localFeedVideoInfo.mVideoPullType, true);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odk
 * JD-Core Version:    0.7.0.1
 */