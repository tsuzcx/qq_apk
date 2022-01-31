import android.app.Activity;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector;

public class lyq
  implements Runnable
{
  public lyq(OrientationDetector paramOrientationDetector, Activity paramActivity) {}
  
  public void run()
  {
    OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, this.jdField_a_of_type_AndroidAppActivity.getRequestedOrientation());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lyq
 * JD-Core Version:    0.7.0.1
 */