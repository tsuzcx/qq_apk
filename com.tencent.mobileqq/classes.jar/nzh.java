import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPuller.FeedItemPullSegment;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeHomeFeed;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoManager;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListHomeFeed;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.List;

public class nzh
  implements CmdTaskManger.CommandCallback
{
  public nzh(DetailFeedAllInfoPuller.FeedItemPullSegment paramFeedItemPullSegment, JobContext paramJobContext) {}
  
  public void a(@NonNull BatchGetFriendStoryFeedInfoRequest paramBatchGetFriendStoryFeedInfoRequest, @Nullable BatchGetFriendStoryFeedInfoRequest.GetFriendStoryFeedInfoResp paramGetFriendStoryFeedInfoResp, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetFriendStoryFeedInfoResp == null))
    {
      SLog.a("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull commentLikeFeedItem fail %s", paramErrorMessage.toString());
      DetailFeedAllInfoPuller.FeedItemPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment, paramErrorMessage);
      return;
    }
    paramBatchGetFriendStoryFeedInfoRequest = (FeedManager)SuperManager.a(11);
    if (paramGetFriendStoryFeedInfoResp.a.size() < 1)
    {
      SLog.e("Q.qqstory.detail.DetailFeedAllInfoPuller", "pull feedItem return null. maybe it's a share group feed and it has been dissolved.");
      paramBatchGetFriendStoryFeedInfoRequest.a(DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a));
      paramBatchGetFriendStoryFeedInfoRequest = new ErrorMessage(2222, "no feed data back.");
      DetailFeedAllInfoPuller.FeedItemPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment, paramBatchGetFriendStoryFeedInfoRequest);
      return;
    }
    paramGetFriendStoryFeedInfoResp = (CommentLikeHomeFeed)paramGetFriendStoryFeedInfoResp.a.get(0);
    if ((paramGetFriendStoryFeedInfoResp instanceof VideoListHomeFeed))
    {
      paramErrorMessage = (VideoListHomeFeed)paramGetFriendStoryFeedInfoResp;
      if ((DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a == null) || (DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a().mVideoSeq != paramErrorMessage.a().mVideoSeq))
      {
        DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a = paramGetFriendStoryFeedInfoResp.a();
        DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a(paramBatchGetFriendStoryFeedInfoRequest.a(DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a), paramGetFriendStoryFeedInfoResp.a(), true), true);
        ((FeedVideoManager)SuperManager.a(12)).a(2, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a.feedId, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a().mVideoSeq, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a(), DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a().mVideoNextCookie, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a().mIsVideoEnd, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a().mVideoPullType, true);
      }
    }
    for (;;)
    {
      DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a = ((CommentLikeFeedItem)paramBatchGetFriendStoryFeedInfoRequest.a(DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a));
      DetailFeedAllInfoPuller.FeedItemPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment, DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a));
      return;
      DetailFeedAllInfoPuller.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeDetailModelDetailFeedAllInfoPuller$FeedItemPullSegment.a).a = paramGetFriendStoryFeedInfoResp.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzh
 * JD-Core Version:    0.7.0.1
 */