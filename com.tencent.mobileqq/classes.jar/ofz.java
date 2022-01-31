import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.CompletedHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.support.logging.SLog;

public class ofz
  implements SimpleStepExector.CompletedHandler
{
  public ofz(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a()
  {
    SLog.d("NewMyStorySegment", "finish get all data from server steps");
    new Handler(Looper.getMainLooper()).post(new oga(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ofz
 * JD-Core Version:    0.7.0.1
 */