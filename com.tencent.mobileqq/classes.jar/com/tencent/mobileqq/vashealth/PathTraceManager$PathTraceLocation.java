package com.tencent.mobileqq.vashealth;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;

public class PathTraceManager$PathTraceLocation
  extends SosoInterfaceOnLocationListener
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  
  public PathTraceManager$PathTraceLocation(PathTraceManager paramPathTraceManager, AppInterface paramAppInterface)
  {
    super(0, true, true, 0L, true, true, "pathtrace");
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2)
  {
    if (paramInt2 > 3) {
      QLog.d("PathTraceManager", 1, "Consecutive Err");
    }
    super.onConsecutiveFailure(paramInt1, paramInt2);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      Object localObject = paramSosoLbsInfo.mLocation;
      paramSosoLbsInfo = new TracePointsData();
      paramSosoLbsInfo.time = NetConnInfoCenter.getServerTime();
      paramSosoLbsInfo.latitude = ((float)((SosoLocation)localObject).mLat02);
      paramSosoLbsInfo.longitude = ((float)((SosoLocation)localObject).mLon02);
      paramSosoLbsInfo.altitude = ((SosoLocation)localObject).altitude;
      paramSosoLbsInfo.accuracy = ((int)((SosoLocation)localObject).accuracy);
      paramSosoLbsInfo.speed = ((SosoLocation)localObject).speed;
      if (this.jdField_a_of_type_ComTencentCommonAppAppInterface != null)
      {
        localObject = (PathTraceManager)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getManager(QQManagerFactory.PATH_TRACE_MANAGER);
        if (localObject != null) {
          ((PathTraceManager)localObject).a(paramSosoLbsInfo);
        }
      }
      return;
    }
    PathTraceManager.b(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager, PathTraceManager.b(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
    if (PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager) != null) {
      this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager.a(PathTraceManager.a(this.jdField_a_of_type_ComTencentMobileqqVashealthPathTraceManager));
    }
    QLog.e("PathTraceManager", 1, "Location Err: " + paramInt);
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.equals("gps")) && (paramInt == 0)) {
      QLog.d("PathTraceManager", 1, "GPS shutdown");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.PathTraceManager.PathTraceLocation
 * JD-Core Version:    0.7.0.1
 */