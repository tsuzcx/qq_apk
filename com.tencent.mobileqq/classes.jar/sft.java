import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.video.column.VideoColumnGuideManager.fetchGuideBgImg.1;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/column/VideoColumnGuideManager$fetchGuideBgImg$1$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sft
  implements sym
{
  public void a(@Nullable syo paramsyo, int paramInt) {}
  
  public void a(@Nullable syo paramsyo, @Nullable Throwable paramThrowable)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("fetch guide bg img fail: ");
    if (paramThrowable != null) {}
    for (paramsyo = paramThrowable.getMessage();; paramsyo = null)
    {
      QLog.e("VideoColumnGuideManager", 1, paramsyo);
      return;
    }
  }
  
  public void a(@Nullable syo paramsyo, @Nullable syk paramsyk)
  {
    sfq localsfq = this.a.this$0;
    if (paramsyk != null) {}
    for (paramsyo = paramsyk.a();; paramsyo = null)
    {
      sfq.a(localsfq, paramsyo);
      sfq.a(this.a.this$0, true);
      paramsyo = sfq.a(this.a.this$0);
      if (paramsyo != null) {
        paramsyo.setImageBitmap(sfq.a(this.a.this$0));
      }
      sfq.b(this.a.this$0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sft
 * JD-Core Version:    0.7.0.1
 */