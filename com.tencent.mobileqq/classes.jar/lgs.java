import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.qphone.base.util.QLog;

public class lgs
  implements Runnable
{
  public lgs(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void run()
  {
    ShortVideoUtils.a(ReadInJoyCameraCaptureActivity.a(this.a));
    if (QLog.isColorLevel()) {
      QLog.i("Q.pubaccount.video.cameracapture.ReadInJoyCameraCaptureActivity", 2, "ShortVideoUtils.isVideoSoLibLoaded() = " + ShortVideoUtils.a());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lgs
 * JD-Core Version:    0.7.0.1
 */