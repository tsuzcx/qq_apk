import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.channel.CmdTaskManger;
import com.tencent.biz.qqstory.channel.NetworkRequest;
import com.tencent.biz.qqstory.network.request.GetProfileFeedIdListRequest;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.GetFeedIdListResult;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import java.util.List;

public class obh
  extends JobSegment
{
  private FeedListPageLoaderBase.FeedIdListCache a;
  
  public obh(@NonNull FeedListPageLoaderBase.FeedIdListCache paramFeedIdListCache)
  {
    this.a = paramFeedIdListCache;
  }
  
  protected void a(JobContext paramJobContext, Integer paramInteger)
  {
    Object localObject = this.a.a(paramInteger.intValue(), 5);
    if ((((FeedListPageLoaderBase.GetFeedIdListResult)localObject).a.size() > 0) || (((FeedListPageLoaderBase.GetFeedIdListResult)localObject).b))
    {
      SLog.b("Q.qqstory.home.data.FeedListPageLoaderBase", "hit feed id cache");
      notifyResult(localObject);
      return;
    }
    localObject = new GetProfileFeedIdListRequest();
    ((GetProfileFeedIdListRequest)localObject).a = this.a.a();
    ((GetProfileFeedIdListRequest)localObject).b = QQStoryContext.a().b();
    CmdTaskManger.a().a((NetworkRequest)localObject, new obi(this, paramJobContext, paramInteger));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     obh
 * JD-Core Version:    0.7.0.1
 */