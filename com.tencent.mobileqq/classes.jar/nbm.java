import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tencent.biz.qqstory.model.StoryConfigManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class nbm
  extends SimpleJob
{
  public nbm(QQStoryCmdHandler paramQQStoryCmdHandler) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((StoryConfigManager)SuperManager.a(10)).a();
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.a.a(paramJobContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nbm
 * JD-Core Version:    0.7.0.1
 */