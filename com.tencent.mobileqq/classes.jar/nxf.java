import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.request.GetStoryFeedIdListRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

public class nxf
  extends JobSegment
{
  private int jdField_a_of_type_Int;
  private BasicLocation jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
  private FeedListPageLoaderBase.FeedIdListCache jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
  
  public nxf(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache, BasicLocation paramBasicLocation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = paramFeedIdListCache;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = paramBasicLocation;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() > 0) || (((FeedListPageLoaderBase.GetFeedIdListResult)localObject).b))
    {
      SLog.b("Q.qqstory.home.data.HomeFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new AtomicBoolean(false);
    GetStoryFeedIdListRequest localGetStoryFeedIdListRequest = new GetStoryFeedIdListRequest();
    localGetStoryFeedIdListRequest.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
    localGetStoryFeedIdListRequest.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    CmdTaskManger.a().a(localGetStoryFeedIdListRequest, new nxg(this, paramJobContext, (AtomicBoolean)localObject, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxf
 * JD-Core Version:    0.7.0.1
 */