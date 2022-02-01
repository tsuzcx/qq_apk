package com.tencent.mobileqq.soso.location.api.impl;

import com.tencent.mobileqq.soso.location.SosoInterface;
import com.tencent.mobileqq.soso.location.SosoInterfaceOnLocationListener;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.soso.location.data.SosoLbsInfo;

public class SosoInterfaceApiImpl
  implements ISosoInterfaceApi
{
  public SosoLbsInfo getCanUsedLbsInfoCache(long paramLong, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
  {
    return SosoInterface.getCanUsedLbsInfoCache(paramLong, paramBoolean1, paramInt, paramBoolean2);
  }
  
  public String getCityCode()
  {
    return SosoInterface.getCityCode();
  }
  
  public SosoLbsInfo getRawSosoInfo()
  {
    return SosoInterface.getRawSosoInfo();
  }
  
  public SosoLbsInfo getSosoInfo()
  {
    return SosoInterface.getSosoInfo();
  }
  
  public String getSosoInterfaceBlackClassName()
  {
    return SosoInterface.class.getPackage().getName();
  }
  
  public ClassLoader getSosoInterfaceClassLoader()
  {
    return SosoInterface.class.getClassLoader();
  }
  
  public void onDestroy() {}
  
  public void removeOnLocationListener(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    SosoInterface.removeOnLocationListener(paramSosoInterfaceOnLocationListener);
  }
  
  public void reqRawLbsData(long paramLong, String paramString)
  {
    SosoInterface.reqRawLbsData(paramLong, paramString);
  }
  
  public void saveNormalEnterConversationTime(long paramLong)
  {
    SosoInterface.saveNormalEnterConversationTime(paramLong);
  }
  
  public boolean saveSosoInterfaceConfig(String paramString)
  {
    return SosoInterface.saveSosoInterfaceConfig(paramString);
  }
  
  public void setResumeFlagFromConversation(long paramLong)
  {
    SosoInterface.sResumeFlagFromConversation = paramLong;
  }
  
  public void startLocation(SosoInterfaceOnLocationListener paramSosoInterfaceOnLocationListener)
  {
    SosoInterface.startLocation(paramSosoInterfaceOnLocationListener);
  }
  
  public void startOfficialLocation() {}
  
  public void updateMainProcessCachedLocation(int paramInt, SosoLbsInfo paramSosoLbsInfo)
  {
    SosoInterface.updateMainProcessCachedLocation(paramInt, paramSosoLbsInfo);
  }
  
  public void updateRawData(String paramString, byte[] paramArrayOfByte)
  {
    SosoInterface.updateRawData(paramString, paramArrayOfByte);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soso.location.api.impl.SosoInterfaceApiImpl
 * JD-Core Version:    0.7.0.1
 */