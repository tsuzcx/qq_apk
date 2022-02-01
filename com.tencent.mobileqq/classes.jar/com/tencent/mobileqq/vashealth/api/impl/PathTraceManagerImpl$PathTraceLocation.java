package com.tencent.mobileqq.vashealth.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.mobileqq.vashealth.TracePointsData;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class PathTraceManagerImpl$PathTraceLocation
  extends SosoInterfaceOnLocationListener
{
  private AppRuntime b;
  
  public PathTraceManagerImpl$PathTraceLocation(PathTraceManagerImpl paramPathTraceManagerImpl, AppInterface paramAppInterface)
  {
    super(0, true, true, 0L, true, true, "pathtrace");
    this.b = paramAppInterface;
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
      paramSosoLbsInfo = paramSosoLbsInfo.mLocation;
      TracePointsData localTracePointsData = new TracePointsData();
      localTracePointsData.time = NetConnInfoCenter.getServerTime();
      localTracePointsData.latitude = ((float)paramSosoLbsInfo.mLat02);
      localTracePointsData.longitude = ((float)paramSosoLbsInfo.mLon02);
      localTracePointsData.altitude = paramSosoLbsInfo.altitude;
      localTracePointsData.accuracy = ((int)paramSosoLbsInfo.accuracy);
      localTracePointsData.speed = paramSosoLbsInfo.speed;
      if (this.b != null) {
        PathTraceManagerImpl.access$800(this.a, localTracePointsData);
      }
    }
    else
    {
      paramSosoLbsInfo = this.a;
      PathTraceManagerImpl.access$402(paramSosoLbsInfo, PathTraceManagerImpl.access$200(paramSosoLbsInfo));
      if (PathTraceManagerImpl.access$300(this.a) != null)
      {
        paramSosoLbsInfo = this.a;
        paramSosoLbsInfo.updateEntity(PathTraceManagerImpl.access$300(paramSosoLbsInfo));
      }
      paramSosoLbsInfo = new StringBuilder();
      paramSosoLbsInfo.append("Location Err: ");
      paramSosoLbsInfo.append(paramInt);
      QLog.e("PathTraceManager", 1, paramSosoLbsInfo.toString());
    }
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if ((paramString1.equals("gps")) && (paramInt == 0)) {
      QLog.d("PathTraceManager", 1, "GPS shutdown");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.PathTraceLocation
 * JD-Core Version:    0.7.0.1
 */