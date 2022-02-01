import android.graphics.Bitmap;
import com.tencent.image.URLDrawable.DownloadListener;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/biz/pubaccount/readinjoy/video/playfeedback/ScreenCaptureHelper$saveBitmapAndUpload$1", "Lcom/tencent/image/URLDrawable$DownloadListener;", "onFileDownloadFailed", "", "p0", "", "onFileDownloadStarted", "onFileDownloadSucceed", "", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class sup
  implements URLDrawable.DownloadListener
{
  sup(String paramString, sdm paramsdm, Bitmap paramBitmap) {}
  
  public void onFileDownloadFailed(int paramInt)
  {
    sdm localsdm = this.jdField_a_of_type_Sdm;
    if (localsdm != null) {
      localsdm.a(2, "");
    }
  }
  
  public void onFileDownloadStarted() {}
  
  public void onFileDownloadSucceed(long paramLong)
  {
    suk.a(this.jdField_a_of_type_Suk, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Sdm);
    if (!this.jdField_a_of_type_AndroidGraphicsBitmap.isRecycled()) {
      this.jdField_a_of_type_AndroidGraphicsBitmap.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sup
 * JD-Core Version:    0.7.0.1
 */