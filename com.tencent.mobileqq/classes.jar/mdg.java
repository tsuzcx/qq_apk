import android.app.Activity;
import android.content.ContentResolver;
import android.database.ContentObserver;
import android.os.Handler;
import android.provider.Settings.System;
import com.tencent.biz.pubaccount.readinjoy.video.OrientationDetector;
import com.tencent.qphone.base.util.QLog;

public class mdg
  extends ContentObserver
{
  private ContentResolver jdField_a_of_type_AndroidContentContentResolver;
  
  public mdg(OrientationDetector paramOrientationDetector, Handler paramHandler)
  {
    super(paramHandler);
    this.jdField_a_of_type_AndroidContentContentResolver = OrientationDetector.a(paramOrientationDetector).getContentResolver();
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.registerContentObserver(Settings.System.getUriFor("accelerometer_rotation"), false, this);
  }
  
  public void b()
  {
    this.jdField_a_of_type_AndroidContentContentResolver.unregisterContentObserver(this);
  }
  
  public void onChange(boolean paramBoolean)
  {
    super.onChange(paramBoolean);
    int i = Settings.System.getInt(OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector).getContentResolver(), "accelerometer_rotation", -1);
    if (i == 1)
    {
      OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, true);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(true);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(OrientationDetector.a, 2, "RotationObserver.onChange() : rotateState=" + i);
      }
      return;
      OrientationDetector.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector, false);
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoOrientationDetector.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mdg
 * JD-Core Version:    0.7.0.1
 */