package com.tencent.mobileqq.soload.config;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.qphone.base.remote.FromServiceMsg;

public class SoLoadConfProcessor
{
  public static void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    ISoConfigService localISoConfigService = (ISoConfigService)QRoute.api(ISoConfigService.class);
    if (localISoConfigService != null) {
      localISoConfigService.notifyNetFailed(paramArrayOfInt, paramFromServiceMsg);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.config.SoLoadConfProcessor
 * JD-Core Version:    0.7.0.1
 */