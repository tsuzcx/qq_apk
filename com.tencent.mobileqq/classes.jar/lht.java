import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.mobileqq.richmedia.capture.view.SplitEffectsCameraCaptureView;
import com.tencent.mobileqq.utils.FileUtils;

public class lht
  implements Runnable
{
  public lht(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void run()
  {
    FileUtils.a(ReadInJoyCameraCaptureActivity.a(this.a).c());
    FileUtils.a(ReadInJoyCameraCaptureActivity.a(this.a).d());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lht
 * JD-Core Version:    0.7.0.1
 */