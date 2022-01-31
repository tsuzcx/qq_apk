package cooperation.qzone.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;

public class QzoneLiveInitLocation
  extends SosoInterface.OnLocationListener
{
  private static QzoneLiveInitLocation jdField_a_of_type_CooperationQzoneVideoQzoneLiveInitLocation;
  private Handler jdField_a_of_type_AndroidOsHandler;
  
  private QzoneLiveInitLocation()
  {
    super(3, true, true, 60000L, false, false, "QzReqInfo");
  }
  
  public static LbsDataV2.GpsInfo a(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.jdField_a_of_type_Float);
    localGpsInfo.alt = ((int)paramSosoLocation.jdField_e_of_type_Double);
    if ((paramSosoLocation.d == 0.0D) && (paramSosoLocation.c == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.jdField_a_of_type_Double * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.b * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.c * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.d * 1000000.0D));
    return localGpsInfo;
  }
  
  public static QzoneLiveInitLocation a()
  {
    if (jdField_a_of_type_CooperationQzoneVideoQzoneLiveInitLocation == null) {}
    try
    {
      if (jdField_a_of_type_CooperationQzoneVideoQzoneLiveInitLocation == null) {
        jdField_a_of_type_CooperationQzoneVideoQzoneLiveInitLocation = new QzoneLiveInitLocation();
      }
      return jdField_a_of_type_CooperationQzoneVideoQzoneLiveInitLocation;
    }
    finally {}
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      return;
    }
    Message localMessage = this.jdField_a_of_type_AndroidOsHandler.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_initlocation_success", false);
    if (paramInt == 0)
    {
      SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.a;
      paramSosoLbsInfo = a(paramSosoLbsInfo.a);
      if ((localSosoLocation != null) && (paramSosoLbsInfo != null) && (!TextUtils.isEmpty(localSosoLocation.jdField_e_of_type_JavaLangString)) && (!localSosoLocation.jdField_e_of_type_JavaLangString.equalsIgnoreCase("unknown")))
      {
        localBundle.putBoolean("key_initlocation_success", true);
        localBundle.putString("key_select_poi_name", localSosoLocation.jdField_e_of_type_JavaLangString.trim());
        localBundle.putString("key_select_poi_default_name", localSosoLocation.jdField_a_of_type_JavaLangString);
        localBundle.putInt("key_select_latitude", paramSosoLbsInfo.lat);
        localBundle.putInt("key_select_longtitude", paramSosoLbsInfo.lon);
        localBundle.putInt("key_select_altitude", paramSosoLbsInfo.alt);
        localBundle.putInt("key_select_gpstype", paramSosoLbsInfo.gpsType);
        QLog.i("QzoneLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]#onGetDeviceData succeed! just location--->" + paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localMessage.obj = localBundle;
      this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
      return;
      QLog.e("QzoneLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]location failed: error in force gps info update..");
    }
  }
  
  public void a(Handler paramHandler)
  {
    this.jdField_a_of_type_AndroidOsHandler = paramHandler;
    try
    {
      SosoInterface.a(this);
      return;
    }
    catch (Exception paramHandler)
    {
      QLog.e("QzoneLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]exception " + paramHandler);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.video.QzoneLiveInitLocation
 * JD-Core Version:    0.7.0.1
 */