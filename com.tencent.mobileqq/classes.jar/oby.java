import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.model.lbs.BasicLocation;
import com.tencent.biz.qqstory.network.request.square.GetSquareFeedIdListRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class oby
  extends JobSegment
{
  private BasicLocation jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
  private FeedListPageLoaderBase.FeedIdListCache jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache;
  
  public oby(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache, BasicLocation paramBasicLocation)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache = paramFeedIdListCache;
    this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = paramBasicLocation;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() > 0) || (((FeedListPageLoaderBase.GetFeedIdListResult)localObject).b))
    {
      SLog.b("Q.qqstory.discover.SquareFeedListPageLoader", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new GetSquareFeedIdListRequest();
    ((GetSquareFeedIdListRequest)localObject).b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelFeedListPageLoaderBase$FeedIdListCache.a();
    ((GetSquareFeedIdListRequest)localObject).jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation = this.jdField_a_of_type_ComTencentBizQqstoryModelLbsBasicLocation;
    CmdTaskManger.a().a((NetworkRequest)localObject, new obz(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oby
 * JD-Core Version:    0.7.0.1
 */