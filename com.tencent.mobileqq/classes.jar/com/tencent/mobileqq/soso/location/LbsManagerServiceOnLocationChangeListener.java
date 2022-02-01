package com.tencent.mobileqq.soso.location;

import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public abstract class LbsManagerServiceOnLocationChangeListener
{
  public String businessId;
  public boolean observerOnUiThread;
  
  public LbsManagerServiceOnLocationChangeListener(String paramString)
  {
    this.businessId = paramString;
  }
  
  public LbsManagerServiceOnLocationChangeListener(String paramString, boolean paramBoolean)
  {
    this.businessId = paramString;
    this.observerOnUiThread = paramBoolean;
  }
  
  public void onConsecutiveFailure(int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public abstract void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo);
  
  public void onStatusUpdate(String paramString1, int paramInt, String paramString2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.LbsManagerServiceOnLocationChangeListener
 * JD-Core Version:    0.7.0.1
 */