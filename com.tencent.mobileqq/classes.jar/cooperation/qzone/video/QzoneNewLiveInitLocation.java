package cooperation.qzone.video;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.mobileqq.app.soso.LbsManagerService;
import com.tencent.mobileqq.app.soso.LbsManagerService.OnLocationChangeListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.report.QzoneLbsReporter;
import cooperation.qzone.util.QZLog;
import java.util.concurrent.ConcurrentHashMap;

class QzoneNewLiveInitLocation
  extends LbsManagerService.OnLocationChangeListener
  implements QzoneLiveInitLocationInterface
{
  private static final String TAG = "QzoneNewLiveInitLocation";
  private static ConcurrentHashMap<String, QzoneNewLiveInitLocation> cache = new ConcurrentHashMap();
  private static Object lock = new Object();
  private static long mLocationStartTime;
  private String mBusinessId;
  private Handler mHandler;
  
  private QzoneNewLiveInitLocation(String paramString)
  {
    super(paramString, false);
    this.mBusinessId = paramString;
  }
  
  public static LbsDataV2.GpsInfo getGpsFromSoso(SosoInterface.SosoLocation paramSosoLocation)
  {
    if (paramSosoLocation == null) {
      return null;
    }
    LbsDataV2.GpsInfo localGpsInfo = new LbsDataV2.GpsInfo();
    localGpsInfo.accuracy = ((int)paramSosoLocation.accuracy);
    localGpsInfo.alt = ((int)paramSosoLocation.altitude);
    if ((paramSosoLocation.mLon84 == 0.0D) && (paramSosoLocation.mLat84 == 0.0D))
    {
      localGpsInfo.gpsType = 1;
      localGpsInfo.lat = ((int)(paramSosoLocation.mLat02 * 1000000.0D));
      localGpsInfo.lon = ((int)(paramSosoLocation.mLon02 * 1000000.0D));
      return localGpsInfo;
    }
    localGpsInfo.gpsType = 0;
    localGpsInfo.lat = ((int)(paramSosoLocation.mLat84 * 1000000.0D));
    localGpsInfo.lon = ((int)(paramSosoLocation.mLon84 * 1000000.0D));
    return localGpsInfo;
  }
  
  public static QzoneNewLiveInitLocation getInstance(String paramString)
  {
    Object localObject1 = (QzoneNewLiveInitLocation)cache.get(paramString);
    if (localObject1 == null) {
      synchronized (lock)
      {
        QzoneNewLiveInitLocation localQzoneNewLiveInitLocation = (QzoneNewLiveInitLocation)cache.get(paramString);
        localObject1 = localQzoneNewLiveInitLocation;
        if (localQzoneNewLiveInitLocation == null)
        {
          localObject1 = new QzoneNewLiveInitLocation(paramString);
          cache.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public void locate(Handler paramHandler)
  {
    this.mHandler = paramHandler;
    try
    {
      mLocationStartTime = System.currentTimeMillis();
      LbsManagerService.startLocation(this);
      return;
    }
    catch (Exception paramHandler)
    {
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]exception ", paramHandler);
    }
  }
  
  public void onLocationFinish(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    QZLog.i("QzoneNewLiveInitLocation.NewLbsInterface", 1, "[QZLIVE_LBS_MODULE]----Info");
    long l1 = System.currentTimeMillis();
    long l2 = mLocationStartTime;
    QzoneLbsReporter.reportLocationResult(paramInt, this.mBusinessId, l1 - l2);
    if ((this.mHandler == null) || (paramSosoLbsInfo == null)) {
      return;
    }
    Message localMessage = this.mHandler.obtainMessage(1);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_initlocation_success", false);
    if (paramInt == 0)
    {
      SosoInterface.SosoLocation localSosoLocation = paramSosoLbsInfo.mLocation;
      paramSosoLbsInfo = getGpsFromSoso(paramSosoLbsInfo.mLocation);
      if ((localSosoLocation != null) && (paramSosoLbsInfo != null) && (!TextUtils.isEmpty(localSosoLocation.city)) && (!localSosoLocation.city.equalsIgnoreCase("unknown")))
      {
        localBundle.putBoolean("key_initlocation_success", true);
        localBundle.putString("key_select_poi_name", localSosoLocation.city.trim());
        localBundle.putString("key_select_poi_default_name", localSosoLocation.name);
        localBundle.putInt("key_select_latitude", paramSosoLbsInfo.lat);
        localBundle.putInt("key_select_longtitude", paramSosoLbsInfo.lon);
        localBundle.putInt("key_select_altitude", paramSosoLbsInfo.alt);
        localBundle.putInt("key_select_gpstype", paramSosoLbsInfo.gpsType);
        QLog.i("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]#onGetDeviceData succeed! just location--->" + paramSosoLbsInfo);
      }
    }
    for (;;)
    {
      localMessage.obj = localBundle;
      this.mHandler.sendMessage(localMessage);
      return;
      QLog.e("QzoneNewLiveInitLocation", 1, "[QZLIVE_LBS_MODULE]location failed: error in force gps info update..");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.video.QzoneNewLiveInitLocation
 * JD-Core Version:    0.7.0.1
 */