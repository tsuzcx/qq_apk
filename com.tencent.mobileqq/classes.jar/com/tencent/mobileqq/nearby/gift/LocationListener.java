package com.tencent.mobileqq.nearby.gift;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public class LocationListener
  extends SosoInterfaceOnLocationListener
{
  public LocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      NearbyGiftPanelDialog.a[0] = ((paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      NearbyGiftPanelDialog.a[1] = ((paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      NearbyGiftPanelDialog.b[0] = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.LocationListener
 * JD-Core Version:    0.7.0.1
 */