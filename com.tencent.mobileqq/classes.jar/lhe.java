import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager.VideoDownloadCallback;

public class lhe
  implements ReadInJoyVideoDownloadManager.VideoDownloadCallback
{
  public lhe(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void a(int paramInt)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new lhg(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new lhf(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhe
 * JD-Core Version:    0.7.0.1
 */