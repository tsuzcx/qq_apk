import android.os.Handler;
import android.os.Looper;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.qqstorylist.model.request.SimpleStepExector.ErrorHandler;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.NewMyStorySegment;
import com.tencent.biz.qqstory.support.logging.SLog;

public class nzu
  implements SimpleStepExector.ErrorHandler
{
  public nzu(NewMyStorySegment paramNewMyStorySegment) {}
  
  public void a(ErrorMessage paramErrorMessage)
  {
    SLog.e("NewMyStorySegment", "error occur when get friends data from server steps=%s,error=%s", new Object[] { paramErrorMessage.extraMsg, paramErrorMessage.getErrorMessage() });
    new Handler(Looper.getMainLooper()).post(new nzv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzu
 * JD-Core Version:    0.7.0.1
 */