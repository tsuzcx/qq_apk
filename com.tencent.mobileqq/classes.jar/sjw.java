import android.graphics.Bitmap;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "copyResult", "", "onPixelCopyFinished", "com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureViewApiO$1$1"}, k=3, mv={1, 1, 16})
final class sjw
  implements PixelCopy.OnPixelCopyFinishedListener
{
  sjw(Bitmap paramBitmap, sjs paramsjs, View paramView, float paramFloat, sjt paramsjt) {}
  
  public final void onPixelCopyFinished(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_Sjs;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
      sjs.a((sjs)localObject, localBitmap, this.jdField_a_of_type_Sjt);
    }
    do
    {
      return;
      QLog.e("ScreenCaptureHelper", 1, "captureViewApiO failed, copyResult:" + paramInt);
      localObject = this.jdField_a_of_type_Sjt;
    } while (localObject == null);
    ((sjt)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sjw
 * JD-Core Version:    0.7.0.1
 */