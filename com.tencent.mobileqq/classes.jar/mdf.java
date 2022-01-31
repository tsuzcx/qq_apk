import android.view.OrientationEventListener;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector;

public class mdf
  implements Runnable
{
  public mdf(OrientationDetector paramOrientationDetector, boolean paramBoolean) {}
  
  public void run()
  {
    for (;;)
    {
      synchronized (OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector))
      {
        if (OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector) == null) {
          return;
        }
        if (this.jdField_a_of_type_Boolean)
        {
          if (OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector).canDetectOrientation()) {
            OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector).enable();
          }
          return;
        }
      }
      OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector).disable();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdf
 * JD-Core Version:    0.7.0.1
 */