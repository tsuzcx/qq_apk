import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public final class nan
  extends SimpleJob
{
  public nan(String paramString) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = StoryVideoUploadManager.a();
    SLog.d("Q.qqstory.publish.upload:StoryVideoUploadManager", this.a + " : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nan
 * JD-Core Version:    0.7.0.1
 */