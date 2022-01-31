import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.album.view.AlbumGalleryCapturePart.7.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;
import mqq.os.MqqHandler;

public class sfg
  extends SimpleJob<Void>
{
  sfg(sez paramsez) {}
  
  protected Void a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = (scu)sqg.a(30);
    paramVarArgs = paramJobContext.b();
    ThreadManager.getUIHandler().post(new AlbumGalleryCapturePart.7.1(this, paramVarArgs, paramJobContext));
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sfg
 * JD-Core Version:    0.7.0.1
 */