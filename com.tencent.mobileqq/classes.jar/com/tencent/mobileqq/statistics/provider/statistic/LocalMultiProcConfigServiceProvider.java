package com.tencent.mobileqq.statistics.provider.statistic;

import com.tencent.mobileqq.bridge.statistics.service.ILocalMultiProcConfigService;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class LocalMultiProcConfigServiceProvider
  implements Provider<ILocalMultiProcConfigService>
{
  public ILocalMultiProcConfigService a()
  {
    return new LocalMultiProcConfigServiceProvider.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.statistic.LocalMultiProcConfigServiceProvider
 * JD-Core Version:    0.7.0.1
 */