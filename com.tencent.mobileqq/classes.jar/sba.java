import android.graphics.Bitmap;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "copyResult", "", "onPixelCopyFinished", "com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureViewApiO$1$1"}, k=3, mv={1, 1, 16})
final class sba
  implements PixelCopy.OnPixelCopyFinishedListener
{
  sba(Bitmap paramBitmap, saw paramsaw, View paramView, float paramFloat, sax paramsax) {}
  
  public final void onPixelCopyFinished(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_Saw;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
      saw.a((saw)localObject, localBitmap, this.jdField_a_of_type_Sax);
    }
    do
    {
      return;
      QLog.e("ScreenCaptureHelper", 1, "captureViewApiO failed, copyResult:" + paramInt);
      localObject = this.jdField_a_of_type_Sax;
    } while (localObject == null);
    ((sax)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sba
 * JD-Core Version:    0.7.0.1
 */