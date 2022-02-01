package com.tencent.mobileqq.soso.location;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationListener;
import com.tencent.map.geolocation.internal.TencentExtraKeys;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

final class SosoInterface$3
  implements TencentLocationListener
{
  public void onLocationChanged(TencentLocation paramTencentLocation, int paramInt, String paramString)
  {
    if (paramTencentLocation == null) {
      return;
    }
    int j = paramTencentLocation.getExtra().getInt("qq_level");
    if (SosoInterface.access$600(paramTencentLocation, paramInt, j)) {
      return;
    }
    SosoInterface.access$200().removeMessages(1001);
    boolean bool1 = false;
    int i;
    if (paramInt == 0) {
      i = 1;
    } else {
      i = 0;
    }
    SosoInterface.access$702(paramInt);
    long l = SystemClock.elapsedRealtime() - SosoInterface.access$800() - SosoInterface.access$900();
    SosoInterface.access$802(SystemClock.elapsedRealtime());
    SosoInterface.access$902(SosoInterface.sContinuousLocationInterval);
    Object localObject2 = paramTencentLocation.getExtra().getString("qq_caller");
    String str = paramTencentLocation.getExtra().getString("qq_caller_route");
    boolean bool2 = paramTencentLocation.getExtra().getBoolean("qq_goonListener");
    boolean bool3 = paramTencentLocation.getExtra().getBoolean("qq_reqLocation");
    Object localObject3 = TencentExtraKeys.getRawData(paramTencentLocation);
    SosoInterface.access$1000(paramInt);
    if (bool3) {
      if (i != 0) {
        SosoInterface.access$1102(0);
      } else {
        SosoInterface.access$1108();
      }
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onLocationChanged() err=");
      localStringBuilder.append(paramInt);
      if ((paramString != null) && (paramString.length() != 0))
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(" reason=");
        ((StringBuilder)localObject1).append(paramString);
        localObject1 = ((StringBuilder)localObject1).toString();
      }
      else
      {
        localObject1 = "";
      }
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append(" caller=");
      localStringBuilder.append((String)localObject2);
      localStringBuilder.append(" level=");
      localStringBuilder.append(j);
      localStringBuilder.append(" reqLocation=");
      localStringBuilder.append(bool3);
      localStringBuilder.append(" consume=");
      localStringBuilder.append(l);
      localStringBuilder.append(" rawData=");
      if (localObject3 == null) {
        i = 0;
      } else {
        i = localObject3.length;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(" isGoonCallback=");
      localStringBuilder.append(bool2);
      localStringBuilder.append(" failInt=");
      localStringBuilder.append(SosoInterface.access$1100());
      localStringBuilder.append(" caller rote: ");
      localStringBuilder.append(str);
      localStringBuilder.append(" verify key length:");
      if (paramTencentLocation.getVerifyKey() == null) {
        i = 0;
      } else {
        i = paramTencentLocation.getVerifyKey().length();
      }
      localStringBuilder.append(i);
      localStringBuilder.append(" source:");
      localStringBuilder.append(paramTencentLocation.getSourceProvider());
      localStringBuilder.append(" adcode :");
      localStringBuilder.append(paramTencentLocation.getCityCode());
      localStringBuilder.append(" lon*lat :");
      localStringBuilder.append((int)(paramTencentLocation.getLongitude() * paramTencentLocation.getLatitude()));
      QLog.d("SOSO.LBS", 2, localStringBuilder.toString());
    }
    Object localObject1 = SosoInterface.access$400();
    if ((paramInt != 0) || (bool3)) {}
    try
    {
      SosoInterface.access$1200(j, paramTencentLocation, (String)localObject2);
      if ((localObject3 != null) && (localObject3.length > 0)) {
        SosoInterface.updateRawData(paramTencentLocation.getProvider(), (byte[])localObject3);
      }
      SosoInterface.access$1300(paramTencentLocation, paramInt, paramString, l);
      paramTencentLocation = SosoInterface.access$1400();
      paramString = SosoInterface.access$1500();
      localObject2 = SosoInterface.access$1600();
      localObject3 = SosoInterface.access$1700();
      if (paramTencentLocation != null) {
        bool1 = true;
      }
      if (SosoInterface.access$500().size() == 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("SOSO.LBS", 4, "listener is empty.");
        }
        SosoInterface.access$100();
        return;
      }
      SosoInterface.access$1800(bool1, paramTencentLocation, paramString, (SosoInterfaceOnLocationListener)localObject2, (SosoInterfaceOnLocationListener)localObject3);
      return;
    }
    finally {}
  }
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2)
  {
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ((StringBuilder)???).append("onStatusUpdate name: ");
      ((StringBuilder)???).append(paramString1);
      ((StringBuilder)???).append(" status: ");
      ((StringBuilder)???).append(paramInt);
      ((StringBuilder)???).append(" desc: ");
      ((StringBuilder)???).append(paramString2);
      QLog.d("SOSO.LBS", 2, ((StringBuilder)???).toString());
    }
    int i;
    synchronized (SosoInterface.access$400())
    {
      if (SosoInterface.access$500().isEmpty()) {
        return;
      }
      i = SosoInterface.access$500().size() - 1;
      if (i >= 0)
      {
        SosoInterfaceOnLocationListener localSosoInterfaceOnLocationListener = (SosoInterfaceOnLocationListener)SosoInterface.access$500().get(i);
        if (localSosoInterfaceOnLocationListener != null) {
          if (localSosoInterfaceOnLocationListener.uiThread) {
            ThreadManager.getUIHandler().post(new SosoInterface.3.1(this, localSosoInterfaceOnLocationListener, paramString1, paramInt, paramString2));
          } else {
            localSosoInterfaceOnLocationListener.onStatusUpdate(paramString1, paramInt, paramString2);
          }
        }
      }
      else
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.SosoInterface.3
 * JD-Core Version:    0.7.0.1
 */