import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureAndUpload$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class shx
  implements shv
{
  shx(rqx paramrqx) {}
  
  public void a()
  {
    rqx localrqx = this.jdField_a_of_type_Rqx;
    if (localrqx != null) {
      localrqx.a(1, "");
    }
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    shu.a(this.jdField_a_of_type_Shu, paramBitmap, this.jdField_a_of_type_Rqx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shx
 * JD-Core Version:    0.7.0.1
 */