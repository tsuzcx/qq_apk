import android.graphics.Bitmap;
import com.tencent.image.URLDrawable.DownloadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$saveBitmapAndUpload$1", "Lcom/tencent/image/URLDrawable$DownloadListener;", "onFileDownloadFailed", "", "p0", "", "onFileDownloadStarted", "onFileDownloadSucceed", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sbb
  implements URLDrawable.DownloadListener
{
  sbb(String paramString, rjx paramrjx, Bitmap paramBitmap) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    rjx localrjx = this.jdField_a_of_type_Rjx;
    if (localrjx != null) {
      localrjx.a(2, "");
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    saw.a(this.jdField_a_of_type_Saw, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Rjx);
    if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sbb
 * JD-Core Version:    0.7.0.1
 */