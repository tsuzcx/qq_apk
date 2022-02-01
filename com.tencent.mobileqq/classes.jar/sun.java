import android.graphics.Bitmap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureAndUpload$1", "Lcom/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$CaptureViewCallback;", "onCaptureFailed", "", "onCaptureSuccess", "bitmap", "Landroid/graphics/Bitmap;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sun
  implements sul
{
  sun(sdm paramsdm) {}
  
  public void a()
  {
    sdm localsdm = this.jdField_a_of_type_Sdm;
    if (localsdm != null) {
      localsdm.a(1, "");
    }
  }
  
  public void a(@NotNull Bitmap paramBitmap)
  {
    Intrinsics.checkParameterIsNotNull(paramBitmap, "bitmap");
    suk.a(this.jdField_a_of_type_Suk, paramBitmap, this.jdField_a_of_type_Sdm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sun
 * JD-Core Version:    0.7.0.1
 */