import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.network.request.GetFeedCommentRequest;
import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.storyHome.model.FeedCommentSync;
import com.tribe.async.async.JobContext;
import com.tribe.async.parallel.ParallelJobSegment;

public class nsw
  extends ParallelJobSegment
{
  public nsw(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment) {}
  
  protected void a(JobContext paramJobContext, FeedCommentSync paramFeedCommentSync)
  {
    GetFeedCommentRequest localGetFeedCommentRequest = new GetFeedCommentRequest();
    localGetFeedCommentRequest.a = paramFeedCommentSync;
    CmdTaskManger.a().a(localGetFeedCommentRequest, new nsx(this, paramJobContext, paramFeedCommentSync));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsw
 * JD-Core Version:    0.7.0.1
 */