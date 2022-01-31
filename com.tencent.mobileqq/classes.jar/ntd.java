import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.playvideo.TVKPreloader;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public final class ntd
  extends SimpleJob
{
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    TVKPreloader.b(TVKPreloader.a());
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ntd
 * JD-Core Version:    0.7.0.1
 */