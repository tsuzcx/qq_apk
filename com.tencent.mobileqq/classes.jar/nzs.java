import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.CompletedHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nzs
  implements SimpleStepExector.CompletedHandler
{
  public nzs(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a()
  {
    SLog.d("NewMyStorySegment", "finish get all data from server steps");
    new Handler(Looper.getMainLooper()).post(new nzt(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzs
 * JD-Core Version:    0.7.0.1
 */