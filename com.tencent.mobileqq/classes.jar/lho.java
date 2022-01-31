import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager.VideoDownloadCallback;

public class lho
  implements ReadInJoyVideoDownloadManager.VideoDownloadCallback
{
  public lho(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void a(int paramInt)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new lhq(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new lhp(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lho
 * JD-Core Version:    0.7.0.1
 */