import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader;
import com.tencent.biz.qqstory.shareGroup.infocard.model.ShareGroupDateListPageLoader.CacheContext;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.SimpleJob;

public class nxa
  extends SimpleJob
{
  public nxa(ShareGroupDateListPageLoader paramShareGroupDateListPageLoader) {}
  
  protected Object a(@NonNull JobContext paramJobContext, @Nullable Void... paramVarArgs)
  {
    if (this.a.a == null) {
      this.a.a = new ShareGroupDateListPageLoader.CacheContext(this.a, this.a.c);
    }
    this.a.d = this.a.a.a;
    ShareGroupDateListPageLoader.a(this.a);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nxa
 * JD-Core Version:    0.7.0.1
 */