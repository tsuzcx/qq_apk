package com.tencent.mobileqq.flashshow.helper;

import android.app.Application;
import android.os.Build.VERSION;
import com.tencent.biz.qcircleshadow.lib.QCircleHostLbsHelper;
import com.tencent.mobileqq.flashshow.application.FSApplication;
import com.tencent.mobileqq.pb.PBInt64Field;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StGPSV2;

public class FSGpsHelper
{
  private static volatile FSGpsHelper a;
  private boolean b;
  private FeedCloudMeta.StGPSV2 c;
  
  public static FSGpsHelper a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new FSGpsHelper();
        }
      }
      finally {}
    }
    return a;
  }
  
  private void c(SosoLbsInfo paramSosoLbsInfo)
  {
    this.b = true;
    this.c = new FeedCloudMeta.StGPSV2();
    this.c.lat.set(a(paramSosoLbsInfo));
    this.c.lon.set(b(paramSosoLbsInfo));
  }
  
  protected int a(SosoLbsInfo paramSosoLbsInfo)
  {
    return Double.valueOf(paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D).intValue();
  }
  
  protected int b(SosoLbsInfo paramSosoLbsInfo)
  {
    return Double.valueOf(paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D).intValue();
  }
  
  public boolean b()
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      boolean bool;
      if (FSApplication.APP.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        bool = true;
      } else {
        bool = false;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkHasGpsPermission result:");
      localStringBuilder.append(bool);
      QLog.d("FSGpsHelper", 1, localStringBuilder.toString());
      return bool;
    }
    return true;
  }
  
  public void c()
  {
    this.b = false;
    if (b())
    {
      SosoLbsInfo localSosoLbsInfo = QCircleHostLbsHelper.getCachedLbsInfo("qqcircle");
      if ((localSosoLbsInfo != null) && (localSosoLbsInfo.mLocation != null))
      {
        c(localSosoLbsInfo);
        QLog.d("FSGpsHelper", 1, "preGetLocation get GpsInfo from cache");
        return;
      }
      QLog.d("FSGpsHelper", 1, "preGetLocation get GpsInfo from request");
      QCircleHostLbsHelper.startLocation(new FSGpsHelper.1(this, "qqcircle", true));
    }
  }
  
  public FeedCloudMeta.StGPSV2 d()
  {
    if (this.b) {
      return this.c;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.helper.FSGpsHelper
 * JD-Core Version:    0.7.0.1
 */