import com.tencent.biz.qqstory.storyHome.detail.model.DetailFeedAllInfoPullSegment;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.parallel.SimpleParallelObserver;
import mqq.os.MqqHandler;

public class nsu
  extends SimpleParallelObserver
{
  public nsu(DetailFeedAllInfoPullSegment paramDetailFeedAllInfoPullSegment) {}
  
  public void onAllFunctionComplete(boolean paramBoolean)
  {
    super.onAllFunctionComplete(paramBoolean);
    ThreadManager.getUIHandler().post(new nsv(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsu
 * JD-Core Version:    0.7.0.1
 */