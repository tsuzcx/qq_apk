import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext.StoryBroadcastReceiver;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ssg
  extends SimpleJob<Void>
{
  public ssg(QQStoryContext.StoryBroadcastReceiver paramStoryBroadcastReceiver, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = svl.a();
    ved.d(QQStoryContext.StoryBroadcastReceiver.a(), "onReceive : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ssg
 * JD-Core Version:    0.7.0.1
 */