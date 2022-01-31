import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.channel.QQStoryCmdHandler;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class syu
  extends SimpleJob<Void>
{
  public syu(QQStoryCmdHandler paramQQStoryCmdHandler, String paramString)
  {
    super(paramString);
  }
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((tcs)tcz.a(10)).a();
    if (!TextUtils.isEmpty(paramJobContext)) {
      this.a.a(paramJobContext);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     syu
 * JD-Core Version:    0.7.0.1
 */