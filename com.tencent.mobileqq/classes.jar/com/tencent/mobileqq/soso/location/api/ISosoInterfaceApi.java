package com.tencent.mobileqq.soso.location.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import com.tencent.mobileqq.soso.location.ISosoInterfaceConstant;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

@QAPI(process={"all"})
@Deprecated
public abstract interface ISosoInterfaceApi
  extends QRouteApi, ISosoInterfaceConstant
{
  public abstract SosoLbsInfo getCanUsedLbsInfoCache(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2);
  
  public abstract String getCityCode();
  
  @Deprecated
  public abstract SosoLbsInfo getRawSosoInfo();
  
  @Deprecated
  public abstract SosoLbsInfo getSosoInfo();
  
  public abstract String getSosoInterfaceBlackClassName();
  
  public abstract ClassLoader getSosoInterfaceClassLoader();
  
  public abstract void onDestroy();
  
  public abstract void removeOnLocationListener(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener);
  
  @Deprecated
  public abstract void reqRawLbsData(long paramLong, String paramString);
  
  public abstract void saveNormalEnterConversationTime(long paramLong);
  
  public abstract boolean saveSosoInterfaceConfig(String paramString);
  
  public abstract void setResumeFlagFromConversation(long paramLong);
  
  public abstract void startLocation(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener);
  
  public abstract void startOfficialLocation();
  
  public abstract void updateMainProcessCachedLocation(int paramInt, SosoLbsInfo paramSosoLbsInfo);
  
  public abstract void updateRawData(String paramString, byte[] paramArrayOfByte);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi
 * JD-Core Version:    0.7.0.1
 */