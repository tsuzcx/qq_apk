import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.TagManager;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.List;

public class nuq
  implements Runnable
{
  public nuq(DetailFeedAllInfoPuller paramDetailFeedAllInfoPuller) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject1 = (CommentLikeFeedItem)((FeedManager)SuperManager.a(11)).a(DetailFeedAllInfoPuller.a(this.a));
    if (localObject1 == null)
    {
      DetailFeedAllInfoPuller.a(this.a, DetailFeedAllInfoPuller.a(this.a), true, new ErrorMessage(-1, "no cache data found."));
      return;
    }
    Object localObject2;
    Object localObject3;
    if ((localObject1 instanceof VideoListFeedItem))
    {
      localObject2 = (VideoListFeedItem)localObject1;
      localObject3 = ((FeedVideoManager)SuperManager.a(12)).a(DetailFeedAllInfoPuller.a(this.a), ((VideoListFeedItem)localObject2).mVideoPullType);
      if (localObject3 == null)
      {
        DetailFeedAllInfoPuller.a(this.a, DetailFeedAllInfoPuller.a(this.a), true, new ErrorMessage(-1, "no cache data found."));
        return;
      }
      ((VideoListFeedItem)localObject2).mVideoNextCookie = ((FeedVideoInfo)localObject3).mVideoNextCookie;
      ((VideoListFeedItem)localObject2).mIsVideoEnd = ((FeedVideoInfo)localObject3).mIsVideoEnd;
      ((VideoListFeedItem)localObject2).mVideoPullType = ((FeedVideoInfo)localObject3).mVideoPullType;
      ((VideoListFeedItem)localObject2).mVideoSeq = ((FeedVideoInfo)localObject3).mVideoSeq;
      DetailFeedAllInfoPuller.a(this.a).a(((FeedVideoInfo)localObject3).mVideoItemList, true);
      localObject2 = ((TagManager)SuperManager.a(27)).a(DetailFeedAllInfoPuller.a(this.a), ((FeedVideoInfo)localObject3).mVideoItemList);
      DetailFeedAllInfoPuller.a(this.a).b((List)localObject2, true);
    }
    DetailFeedAllInfoPuller.a(this.a).a = ((CommentLikeFeedItem)localObject1);
    if (this.a.a)
    {
      localObject2 = (LikeManager)SuperManager.a(15);
      localObject1 = ((LikeManager)localObject2).a(DetailFeedAllInfoPuller.a(this.a), DetailFeedAllInfoPuller.a(this.a));
      DetailFeedAllInfoPuller.a(this.a).b((List)localObject1, true, DetailFeedAllInfoPuller.a(this.a));
      localObject1 = (CommentManager)SuperManager.a(17);
      localObject3 = ((CommentManager)localObject1).a(DetailFeedAllInfoPuller.a(this.a), DetailFeedAllInfoPuller.a(this.a));
      DetailFeedAllInfoPuller.a(this.a).a((List)localObject3, true, DetailFeedAllInfoPuller.a(this.a));
      if (DetailFeedAllInfoPuller.a(this.a).a())
      {
        localObject3 = DetailFeedAllInfoPuller.a(this.a);
        if (DetailFeedAllInfoPuller.a(this.a)) {
          break label510;
        }
        bool1 = true;
        localObject2 = ((LikeManager)localObject2).a((String)localObject3, bool1);
        localObject3 = DetailFeedAllInfoPuller.a(this.a);
        if (DetailFeedAllInfoPuller.a(this.a)) {
          break label515;
        }
        bool1 = true;
        label401:
        ((DetailFeedItem)localObject3).b((List)localObject2, true, bool1);
        localObject2 = DetailFeedAllInfoPuller.a(this.a);
        if (DetailFeedAllInfoPuller.a(this.a)) {
          break label520;
        }
      }
    }
    label515:
    label520:
    for (boolean bool1 = true;; bool1 = false)
    {
      localObject1 = ((CommentManager)localObject1).a((String)localObject2, bool1);
      localObject2 = DetailFeedAllInfoPuller.a(this.a);
      bool1 = bool2;
      if (!DetailFeedAllInfoPuller.a(this.a)) {
        bool1 = true;
      }
      ((DetailFeedItem)localObject2).a((List)localObject1, true, bool1);
      SLog.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "load feed data from cache: %s.", DetailFeedAllInfoPuller.a(this.a).toString());
      DetailFeedAllInfoPuller.a(this.a, DetailFeedAllInfoPuller.a(this.a), true, new ErrorMessage());
      return;
      label510:
      bool1 = false;
      break;
      bool1 = false;
      break label401;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuq
 * JD-Core Version:    0.7.0.1
 */