import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.app.QQStoryContext.StoryBroadcastReceiver;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class sfn
  extends SimpleJob<Void>
{
  public sfn(QQStoryContext.StoryBroadcastReceiver paramStoryBroadcastReceiver, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    int i = sis.a();
    urk.d(QQStoryContext.StoryBroadcastReceiver.a(), "onReceive : fireCreateStoryVideo count = %d", new Object[] { Integer.valueOf(i) });
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfn
 * JD-Core Version:    0.7.0.1
 */