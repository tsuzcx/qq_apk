package com.tencent.mobileqq.search.searchengine;

import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;
import com.tencent.mobileqq.soso.location.data.SosoLocation;

class NetSearchEngine$1
  extends SosoInterfaceOnLocationListener
{
  NetSearchEngine$1(NetSearchEngine paramNetSearchEngine, int paramInt, boolean paramBoolean1, boolean paramBoolean2, long paramLong, boolean paramBoolean3, boolean paramBoolean4, String paramString)
  {
    super(paramInt, paramBoolean1, paramBoolean2, paramLong, paramBoolean3, paramBoolean4, paramString);
  }
  
  public void onLocationFinish(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    if (paramInt == 0)
    {
      NetSearchEngine.a = paramSosoLbsInfo.mLocation.mLat02;
      NetSearchEngine.b = paramSosoLbsInfo.mLocation.mLon02;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine.1
 * JD-Core Version:    0.7.0.1
 */