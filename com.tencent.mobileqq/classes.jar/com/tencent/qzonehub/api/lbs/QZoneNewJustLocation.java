package com.tencent.qzonehub.api.lbs;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener;
import com.tencent.mobileqq.soso.location.api.ILbsManagerServiceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qzonehub.api.ISosoUtils;
import common.config.service.QzoneConfig;
import cooperation.qzone.LbsDataV2.GpsInfo;
import cooperation.qzone.report.QzoneLbsReporter;
import java.util.concurrent.ConcurrentHashMap;

public class QZoneNewJustLocation
  extends LbsManagerServiceOnLocationChangeListener
  implements QZoneJustLocationInterface
{
  private static Object jdField_a_of_type_JavaLangObject = new Object();
  private static ConcurrentHashMap<String, QZoneNewJustLocation> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private long jdField_a_of_type_Long;
  private QZoneNewJustLocation.OnLocationChangeListener jdField_a_of_type_ComTencentQzonehubApiLbsQZoneNewJustLocation$OnLocationChangeListener;
  private LbsDataV2.GpsInfo jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = false;
  private long b = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  private long c;
  
  private QZoneNewJustLocation(String paramString)
  {
    super(paramString, false);
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static QZoneNewJustLocation a(String paramString)
  {
    Object localObject1 = (QZoneNewJustLocation)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
    if (localObject1 == null) {
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        QZoneNewJustLocation localQZoneNewJustLocation = (QZoneNewJustLocation)jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramString);
        localObject1 = localQZoneNewJustLocation;
        if (localQZoneNewJustLocation == null)
        {
          localObject1 = new QZoneNewJustLocation(paramString);
          jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public LbsDataV2.GpsInfo a()
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.jdField_a_of_type_JavaLangString);
    if (localSosoLbsInfo != null) {}
    for (boolean bool = true;; bool = false)
    {
      QzoneLbsReporter.reportLocationCacheResult(bool, this.jdField_a_of_type_JavaLangString);
      QLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getCurrGps");
      if (localSosoLbsInfo == null) {
        break;
      }
      return ((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(localSosoLbsInfo.mLocation);
    }
    return null;
  }
  
  public void a()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((this.jdField_a_of_type_Boolean) || (l - this.jdField_a_of_type_Long < this.b))
      {
        QLog.i("QZoneNewJustLocation", 1, "[QZ_LBS_MODULE] mIsGettingLocation = " + this.jdField_a_of_type_Boolean + ", (now - mLastGetLocationTime) ) = " + (l - this.jdField_a_of_type_Long) / 1000L + ", so return");
        return;
      }
      this.jdField_a_of_type_Long = l;
      this.jdField_a_of_type_Boolean = true;
      QLog.i("QZoneNewJustLocation", 1, "[QZ_LBS_MODULE] startLocation");
      this.c = System.currentTimeMillis();
      ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneNewJustLocation", 1, "[QZ_LBS_MODULE]exception ", localException);
    }
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      this.b = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo = ((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(paramSosoLbsInfo.mLocation);
      if (this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneNewJustLocation$OnLocationChangeListener != null) {
        this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneNewJustLocation$OnLocationChangeListener.a(this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo);
      }
      QLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]#onGetDeviceData succeed! just location--->gps=" + this.jdField_a_of_type_CooperationQzoneLbsDataV2$GpsInfo);
      this.jdField_a_of_type_Boolean = false;
      long l1 = System.currentTimeMillis();
      long l2 = this.c;
      QzoneLbsReporter.reportLocationResult(paramInt, this.jdField_a_of_type_JavaLangString, l1 - l2);
      return;
    }
    if (paramInt == 2) {}
    for (this.b *= 10L;; this.b *= 2L)
    {
      QLog.e("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]location failed: error in force gps info update..");
      if (this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneNewJustLocation$OnLocationChangeListener == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentQzonehubApiLbsQZoneNewJustLocation$OnLocationChangeListener.a();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qzonehub.api.lbs.QZoneNewJustLocation
 * JD-Core Version:    0.7.0.1
 */