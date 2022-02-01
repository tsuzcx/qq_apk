package com.tencent.mobileqq.statistics.provider.statistic;

import com.tencent.mobileqq.bridge.statistics.service.ILocalMultiProcConfigService;
import cooperation.qzone.LocalMultiProcConfig;

class LocalMultiProcConfigServiceProvider$1
  implements ILocalMultiProcConfigService
{
  LocalMultiProcConfigServiceProvider$1(LocalMultiProcConfigServiceProvider paramLocalMultiProcConfigServiceProvider) {}
  
  public int a(String paramString, int paramInt)
  {
    return LocalMultiProcConfig.getInt(paramString, paramInt);
  }
  
  public void a(String paramString, int paramInt)
  {
    LocalMultiProcConfig.putInt(paramString, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.statistic.LocalMultiProcConfigServiceProvider.1
 * JD-Core Version:    0.7.0.1
 */