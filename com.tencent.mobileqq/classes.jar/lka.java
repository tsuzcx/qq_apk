import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraCaptureActivity;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraProgressView;
import com.tencent.biz.pubaccount.readinjoy.capture.ReadInJoyCameraStatusLayout;

public class lka
  implements Runnable
{
  public lka(ReadInJoyCameraCaptureActivity paramReadInJoyCameraCaptureActivity) {}
  
  public void run()
  {
    ReadInJoyCameraCaptureActivity.b(this.a, 3);
    ReadInJoyCameraCaptureActivity.a(this.a).a(ReadInJoyCameraCaptureActivity.a(this.a), ReadInJoyCameraCaptureActivity.b(this.a));
    ReadInJoyCameraCaptureActivity.a(this.a).setStatus(3);
    ReadInJoyCameraCaptureActivity.a(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lka
 * JD-Core Version:    0.7.0.1
 */