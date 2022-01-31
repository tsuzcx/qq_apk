import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyVideoDownloadManager.VideoDownloadCallback;

public class ljs
  implements ReadInJoyVideoDownloadManager.VideoDownloadCallback
{
  public ljs(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void a(int paramInt)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new lju(this, paramInt));
  }
  
  public void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    ReadInJoyCameraCaptureActivity.a(this.a).post(new ljt(this, paramBoolean, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ljs
 * JD-Core Version:    0.7.0.1
 */