import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.takevideo2.StoryEffectsCameraCaptureView.CaptureRequest;
import com.tencent.biz.qqstory.takevideo2.StoryMultiFragmentPart;
import com.tencent.mobileqq.app.ThreadManager;

public class orf
  implements StoryEffectsCameraCaptureView.CaptureRequest
{
  public orf(StoryMultiFragmentPart paramStoryMultiFragmentPart, Context paramContext) {}
  
  public void a(Bitmap paramBitmap)
  {
    SLog.a("story.publish.StoryMultiFragmentPart", "requestGetCurrentFrameBitmap done %s", paramBitmap);
    if (paramBitmap != null) {
      ThreadManager.postImmediately(new org(this, paramBitmap), null, false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     orf
 * JD-Core Version:    0.7.0.1
 */