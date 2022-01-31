package com.tencent.mobileqq.nearby.gift;

import com.tencent.mobileqq.app.soso.SosoInterface.OnLocationListener;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLbsInfo;
import com.tencent.mobileqq.app.soso.SosoInterface.SosoLocation;

public class NearbyGiftPanelDialog$LocationListener
  extends SosoInterface.OnLocationListener
{
  public NearbyGiftPanelDialog$LocationListener(int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void a(int paramInt, SosoInterface.SosoLbsInfo paramSosoLbsInfo)
  {
    if ((paramInt == 0) && (paramSosoLbsInfo != null) && (paramSosoLbsInfo.a != null))
    {
      NearbyGiftPanelDialog.jdField_a_of_type_ArrayOfLong[0] = ((paramSosoLbsInfo.a.b * 1000000.0D));
      NearbyGiftPanelDialog.jdField_a_of_type_ArrayOfLong[1] = ((paramSosoLbsInfo.a.a * 1000000.0D));
      NearbyGiftPanelDialog.jdField_a_of_type_Long = System.currentTimeMillis();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gift.NearbyGiftPanelDialog.LocationListener
 * JD-Core Version:    0.7.0.1
 */