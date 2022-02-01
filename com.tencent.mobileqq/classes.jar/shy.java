import android.graphics.Bitmap;
import android.view.PixelCopy.OnPixelCopyFinishedListener;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "copyResult", "", "onPixelCopyFinished", "com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$captureViewApiO$1$1"}, k=3, mv={1, 1, 16})
final class shy
  implements PixelCopy.OnPixelCopyFinishedListener
{
  shy(Bitmap paramBitmap, shu paramshu, View paramView, float paramFloat, shv paramshv) {}
  
  public final void onPixelCopyFinished(int paramInt)
  {
    Object localObject;
    if (paramInt == 0)
    {
      localObject = this.jdField_a_of_type_Shu;
      Bitmap localBitmap = this.jdField_a_of_type_AndroidGraphicsBitmap;
      Intrinsics.checkExpressionValueIsNotNull(localBitmap, "bitmap");
      shu.a((shu)localObject, localBitmap, this.jdField_a_of_type_Shv);
    }
    do
    {
      return;
      QLog.e("ScreenCaptureHelper", 1, "captureViewApiO failed, copyResult:" + paramInt);
      localObject = this.jdField_a_of_type_Shv;
    } while (localObject == null);
    ((shv)localObject).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     shy
 * JD-Core Version:    0.7.0.1
 */