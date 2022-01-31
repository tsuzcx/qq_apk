import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.model.MemoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.model.VidToVideoInfoPuller;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class ndl
  extends SimpleJob
{
  public ndl(VidToVideoInfoPuller paramVidToVideoInfoPuller) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    paramJobContext = ((MemoryManager)SuperManager.a(19)).a(this.a.a);
    this.a.a(paramJobContext);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ndl
 * JD-Core Version:    0.7.0.1
 */