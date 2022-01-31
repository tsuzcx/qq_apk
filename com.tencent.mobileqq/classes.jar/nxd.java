import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.BatchGetFeedLikeResp;
import com.tencent.biz.qqstory.network.request.BatchGetFeedLikeRequest.FeedLikeInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedAllInfoPullSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class nxd
  implements CmdTaskManger.CommandCallback
{
  public nxd(HomeFeedAllInfoPullSegment paramHomeFeedAllInfoPullSegment, JobContext paramJobContext, FeedListPageLoaderBase.GetFeedIdListResult paramGetFeedIdListResult) {}
  
  public void a(@NonNull BatchGetFeedLikeRequest paramBatchGetFeedLikeRequest, @Nullable BatchGetFeedLikeRequest.BatchGetFeedLikeResp arg2, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "feed like info pull segment cancel on net respond");
      return;
    }
    if (??? == null)
    {
      paramErrorMessage = new BatchGetFeedLikeRequest.BatchGetFeedLikeResp(paramErrorMessage);
      synchronized (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedAllInfoPullSegment)
      {
        HomeFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedAllInfoPullSegment, paramErrorMessage);
        HomeFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedAllInfoPullSegment).remove(paramBatchGetFeedLikeRequest);
        HomeFeedAllInfoPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedAllInfoPullSegment, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$GetFeedIdListResult);
        return;
      }
    }
    if (paramErrorMessage.isFail()) {
      SLog.d("Q.qqstory.home.data:HomeFeedAllInfoPullSegment", "request fail for like request");
    }
    LikeManager localLikeManager = (LikeManager)SuperManager.a(15);
    Iterator localIterator = ???.jdField_a_of_type_JavaUtilList.iterator();
    for (;;)
    {
      paramErrorMessage = ???;
      if (!localIterator.hasNext()) {
        break;
      }
      paramErrorMessage = (BatchGetFeedLikeRequest.FeedLikeInfo)localIterator.next();
      localLikeManager.a(paramErrorMessage.jdField_a_of_type_JavaUtilList, paramErrorMessage.jdField_a_of_type_JavaLangString, false, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxd
 * JD-Core Version:    0.7.0.1
 */