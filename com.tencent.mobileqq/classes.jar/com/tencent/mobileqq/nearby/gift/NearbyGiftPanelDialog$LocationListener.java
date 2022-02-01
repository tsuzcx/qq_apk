package com.tencent.mobileqq.nearby.gift;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

public class NearbyGiftPanelDialog$LocationListener
  extends SosoInterfaceOnLocationListener
{
  public NearbyGiftPanelDialog$LocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.mLocation != null))
    {
      NearbyGiftPanelDialog.jdField_a_of_type_ArrayOfLong[0] = ((paramSosoLbsInfo.mLocation.mLon02 * 1000000.0D));
      NearbyGiftPanelDialog.jdField_a_of_type_ArrayOfLong[1] = ((paramSosoLbsInfo.mLocation.mLat02 * 1000000.0D));
      NearbyGiftPanelDialog.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog.LocationListener
 * JD-Core Version:    0.7.0.1
 */