import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.CmdTaskManger.CommandCallback;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest.GetStoryFeedIdListResponse;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.storyHome.model.HomeFeedListPageLoader.FeedIdPullSegment;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import java.util.concurrent.atomic.AtomicBoolean;

public class nys
  implements CmdTaskManger.CommandCallback
{
  public nys(HomeFeedListPageLoader.FeedIdPullSegment paramFeedIdPullSegment, JobContext paramJobContext, AtomicBoolean paramAtomicBoolean, Integer paramInteger) {}
  
  public void a(@NonNull GetStoryFeedIdListRequest paramGetStoryFeedIdListRequest, @Nullable GetStoryFeedIdListRequest.GetStoryFeedIdListResponse paramGetStoryFeedIdListResponse, @NonNull ErrorMessage paramErrorMessage)
  {
    if (this.jdField_a_of_type_ComTribeAsyncAsyncJobContext.isJobCancelled())
    {
      SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId pull segment cancel on net respond");
      return;
    }
    if ((paramErrorMessage.isFail()) || (paramGetStoryFeedIdListResponse == null))
    {
      SLog.a("Q.qqstory.home.data.HomeFeedListPageLoader", "pull feedId list fail %s", paramErrorMessage.toString());
      HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment, paramErrorMessage);
      return;
    }
    HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment);
    HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment).a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList, paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaLangString, paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean);
    ((FeedManager)SuperManager.a(11)).a(paramGetStoryFeedIdListResponse.jdField_a_of_type_JavaUtilList);
    boolean bool = HomeFeedListPageLoader.FeedIdPullSegment.a(paramGetStoryFeedIdListResponse, this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean);
    SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "today is end:%b, loop count:%d, last date has fail:%b", new Object[] { Boolean.valueOf(paramGetStoryFeedIdListResponse.b), Integer.valueOf(HomeFeedListPageLoader.FeedIdPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment)), Boolean.valueOf(bool) });
    if ((!paramGetStoryFeedIdListResponse.jdField_a_of_type_Boolean) && (HomeFeedListPageLoader.FeedIdPullSegment.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment) < 10) && ((!paramGetStoryFeedIdListResponse.b) || (bool)))
    {
      SLog.d("Q.qqstory.home.data.HomeFeedListPageLoader", "feedId list not end, pull more");
      paramGetStoryFeedIdListRequest.b = HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment).a();
      CmdTaskManger.a().a(paramGetStoryFeedIdListRequest, this);
      return;
    }
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.getAndSet(false)) {
      HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment).c();
    }
    paramGetStoryFeedIdListRequest = HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment).a(this.jdField_a_of_type_JavaLangInteger.intValue(), 5);
    HomeFeedListPageLoader.FeedIdPullSegment.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelHomeFeedListPageLoader$FeedIdPullSegment, paramGetStoryFeedIdListRequest);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nys
 * JD-Core Version:    0.7.0.1
 */