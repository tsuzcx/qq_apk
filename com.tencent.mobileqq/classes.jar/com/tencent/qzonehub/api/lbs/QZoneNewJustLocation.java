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
  private static Object a = new Object();
  private static ConcurrentHashMap<String, QZoneNewJustLocation> i = new ConcurrentHashMap();
  private boolean b = false;
  private QZoneNewJustLocation.OnLocationChangeListener c;
  private LbsDataV2.GpsInfo d;
  private long e;
  private long f = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
  private String g;
  private long h;
  
  private QZoneNewJustLocation(String paramString)
  {
    super(paramString, false);
    this.g = paramString;
  }
  
  public static QZoneNewJustLocation a(String paramString)
  {
    Object localObject1 = (QZoneNewJustLocation)i.get(paramString);
    if (localObject1 == null) {
      synchronized (a)
      {
        QZoneNewJustLocation localQZoneNewJustLocation = (QZoneNewJustLocation)i.get(paramString);
        localObject1 = localQZoneNewJustLocation;
        if (localQZoneNewJustLocation == null)
        {
          localObject1 = new QZoneNewJustLocation(paramString);
          i.put(paramString, localObject1);
        }
        return localObject1;
      }
    }
    return localObject1;
  }
  
  public LbsDataV2.GpsInfo a()
  {
    SosoLbsInfo localSosoLbsInfo = ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).getCachedLbsInfo(this.g);
    boolean bool;
    if (localSosoLbsInfo != null) {
      bool = true;
    } else {
      bool = false;
    }
    QzoneLbsReporter.reportLocationCacheResult(bool, this.g);
    QLog.i("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]----getCurrGps");
    if (localSosoLbsInfo != null) {
      return ((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(localSosoLbsInfo.mLocation);
    }
    return null;
  }
  
  public void b()
  {
    try
    {
      long l = System.currentTimeMillis();
      if ((!this.b) && (l - this.e >= this.f))
      {
        this.e = l;
        this.b = true;
        QLog.i("QZoneNewJustLocation", 1, "[QZ_LBS_MODULE] startLocation");
        this.h = System.currentTimeMillis();
        ((ILbsManagerServiceApi)QRoute.api(ILbsManagerServiceApi.class)).startLocation(this);
        return;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[QZ_LBS_MODULE] mIsGettingLocation = ");
      localStringBuilder.append(this.b);
      localStringBuilder.append(", (now - mLastGetLocationTime) ) = ");
      localStringBuilder.append((l - this.e) / 1000L);
      localStringBuilder.append(", so return");
      QLog.i("QZoneNewJustLocation", 1, localStringBuilder.toString());
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
      this.f = QzoneConfig.getInstance().getConfig("QZoneSetting", "QzoneLocateInterval", 60000L);
      this.d = ((ISosoUtils)QRoute.api(ISosoUtils.class)).convertFromSoso(paramSosoLbsInfo.mLocation);
      paramSosoLbsInfo = this.c;
      if (paramSosoLbsInfo != null) {
        paramSosoLbsInfo.a(this.d);
      }
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("[QZ_LBS_MODULE]#onGetDeviceData succeed! just location--->gps=");
      paramSosoLbsInfo.append(this.d);
      QLog.i("QZoneNewJustLocation.NewLbsInterface", 1, paramSosoLbsInfo.toString());
    }
    else
    {
      if (paramInt == 2) {
        this.f *= 10L;
      } else {
        this.f *= 2L;
      }
      QLog.e("QZoneNewJustLocation.NewLbsInterface", 1, "[QZ_LBS_MODULE]location failed: error in force gps info update..");
      paramSosoLbsInfo = this.c;
      if (paramSosoLbsInfo != null) {
        paramSosoLbsInfo.a();
      }
    }
    this.b = false;
    long l1 = System.currentTimeMillis();
    long l2 = this.h;
    QzoneLbsReporter.reportLocationResult(paramInt, this.g, l1 - l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qzonehub.api.lbs.QZoneNewJustLocation
 * JD-Core Version:    0.7.0.1
 */