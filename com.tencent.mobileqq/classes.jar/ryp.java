import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$fetchGuideBgImg$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class ryp
  implements sum
{
  public void a(@Nullable suo paramsuo, int paramInt) {}
  
  public void a(@Nullable suo paramsuo, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fetch guide bg img fail: ");
    if (paramThrowable != null) {}
    for (paramsuo = paramThrowable.getMessage();; paramsuo = null)
    {
      QLog.e("VideoColumnGuideManager", 1, paramsuo);
      return;
    }
  }
  
  public void a(@Nullable suo paramsuo, @Nullable suk paramsuk)
  {
    rym localrym = this.a.this$0;
    if (paramsuk != null) {}
    for (paramsuo = paramsuk.a();; paramsuo = null)
    {
      rym.a(localrym, paramsuo);
      rym.a(this.a.this$0, true);
      paramsuo = rym.a(this.a.this$0);
      if (paramsuo != null) {
        paramsuo.setImageBitmap(rym.a(this.a.this$0));
      }
      rym.b(this.a.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     ryp
 * JD-Core Version:    0.7.0.1
 */