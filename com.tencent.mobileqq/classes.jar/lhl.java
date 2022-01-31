import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureHelper;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraProgressView;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.qphone.base.util.QLog;

public class lhl
  implements Runnable
{
  public lhl(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void run()
  {
    try
    {
      ReadInJoyCameraCaptureActivity.a(this.a, ReadInJoyCameraCaptureActivity.a(this.a).a());
      ReadInJoyCameraCaptureActivity.b(this.a, ReadInJoyCameraCaptureActivity.a(this.a).h());
      if (ReadInJoyCameraCaptureActivity.a(this.a) == ReadInJoyCameraCaptureActivity.b(this.a))
      {
        if ((!ReadInJoyCameraCaptureActivity.a(this.a)) && (!ReadInJoyCameraCaptureActivity.b(this.a)))
        {
          ReadInJoyCameraCaptureActivity.a(this.a).l();
          this.a.b();
        }
        ReadInJoyCameraCaptureActivity.a(this.a, true);
        ReadInJoyCameraCaptureActivity.a(this.a).removeCallbacks(this);
      }
      ReadInJoyCameraCaptureActivity.a(this.a).setProgress(ReadInJoyCameraCaptureActivity.a(this.a), ReadInJoyCameraCaptureActivity.b(this.a));
      ReadInJoyCameraCaptureHelper.a(ReadInJoyCameraCaptureActivity.b(this.a), ReadInJoyCameraCaptureActivity.a(this.a));
      if ((!ReadInJoyCameraCaptureActivity.b(this.a)) && (ReadInJoyCameraCaptureActivity.a(this.a) == 1)) {
        ReadInJoyCameraCaptureActivity.a(this.a).postDelayed(this, 100L);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "progress Exception e=" + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lhl
 * JD-Core Version:    0.7.0.1
 */