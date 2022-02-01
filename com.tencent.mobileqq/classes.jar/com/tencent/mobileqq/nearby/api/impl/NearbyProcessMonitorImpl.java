package com.tencent.mobileqq.nearby.api.impl;

import com.tencent.mobileqq.nearby.api.INearbyProcessMonitor;
import com.tencent.mobileqq.nearby.api.NearbyProcessMonitor;

public class NearbyProcessMonitorImpl
  implements INearbyProcessMonitor
{
  public void checkSchoolName(String paramString)
  {
    NearbyProcessMonitor.b(paramString);
  }
  
  public void reportCheckNearbyUnreadFlag(String paramString, int paramInt)
  {
    NearbyProcessMonitor.b(paramString, paramInt);
  }
  
  public void reportSessionBegin(int paramInt)
  {
    NearbyProcessMonitor.a(paramInt);
  }
  
  public void reportSessionEnd(int paramInt)
  {
    NearbyProcessMonitor.c(paramInt);
  }
  
  public void reportSessionHit(int paramInt)
  {
    NearbyProcessMonitor.b(paramInt);
  }
  
  public void startNearbyProcess(String paramString, int paramInt)
  {
    NearbyProcessMonitor.a(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.impl.NearbyProcessMonitorImpl
 * JD-Core Version:    0.7.0.1
 */