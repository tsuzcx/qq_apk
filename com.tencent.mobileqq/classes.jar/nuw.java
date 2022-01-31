import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class nuw
  extends SimpleJob
{
  public nuw(StoryDiscoverActivity paramStoryDiscoverActivity) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    SLog.d("Q.qqstory.discover.StoryDiscoverActivity", "doOnActivityResult : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(StoryVideoUploadManager.a()) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nuw
 * JD-Core Version:    0.7.0.1
 */