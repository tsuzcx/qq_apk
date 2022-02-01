import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/decoupling/uilayer/video/RIJVideoViewInterceptor$preloadAvatarByImageManager$1", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/IBitmapCallback;", "onFail", "", "request", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/ImageRequest;", "exception", "", "onProgress", "progress", "", "onSuccess", "bitmap", "Lcom/tencent/biz/pubaccount/readinjoy/view/imageloader/CloseableBitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class pse
  implements tlu
{
  pse(String paramString) {}
  
  public void a(@NotNull tlw paramtlw, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramtlw, "request");
  }
  
  public void a(@NotNull tlw paramtlw, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramtlw, "request");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "exception");
    QLog.e("RIJVideoViewInterceptor", 1, "preloadAvatarByImageManager ImageManager onFail");
  }
  
  public void a(@NotNull tlw paramtlw, @NotNull tls paramtls)
  {
    Intrinsics.checkParameterIsNotNull(paramtlw, "request");
    Intrinsics.checkParameterIsNotNull(paramtls, "bitmap");
    if (QLog.isColorLevel()) {
      QLog.d("RIJVideoViewInterceptor", 2, "preloadAvatarByImageManager ImageManager onSuccess, url:" + this.a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pse
 * JD-Core Version:    0.7.0.1
 */