package com.tencent.mobileqq.statistics.provider.report;

import com.tencent.mobileqq.bridge.report.service.ITouchEventService;
import com.tencent.mobileqq.data.entitymanager.Provider;

public class TouchEventServiceProvider
  implements Provider<ITouchEventService>
{
  public ITouchEventService a()
  {
    return new TouchEventServiceProvider.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.provider.report.TouchEventServiceProvider
 * JD-Core Version:    0.7.0.1
 */