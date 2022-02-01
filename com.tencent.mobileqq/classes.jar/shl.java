import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$fetchGuideBgImg$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shl
  implements tdu
{
  public void a(@Nullable tdw paramtdw, int paramInt) {}
  
  public void a(@Nullable tdw paramtdw, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fetch guide bg img fail: ");
    if (paramThrowable != null) {}
    for (paramtdw = paramThrowable.getMessage();; paramtdw = null)
    {
      QLog.e("VideoColumnGuideManager", 1, paramtdw);
      return;
    }
  }
  
  public void a(@Nullable tdw paramtdw, @Nullable tds paramtds)
  {
    shi localshi = this.a.this$0;
    if (paramtds != null) {}
    for (paramtdw = paramtds.a();; paramtdw = null)
    {
      shi.a(localshi, paramtdw);
      shi.a(this.a.this$0, true);
      paramtdw = shi.a(this.a.this$0);
      if (paramtdw != null) {
        paramtdw.setImageBitmap(shi.a(this.a.this$0));
      }
      shi.b(this.a.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shl
 * JD-Core Version:    0.7.0.1
 */