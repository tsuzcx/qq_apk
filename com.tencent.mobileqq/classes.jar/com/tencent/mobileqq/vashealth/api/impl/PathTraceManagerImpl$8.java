package com.tencent.mobileqq.vashealth.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.qphone.base.util.QLog;

class PathTraceManagerImpl$8
  implements Runnable
{
  PathTraceManagerImpl$8(PathTraceManagerImpl paramPathTraceManagerImpl) {}
  
  public void run()
  {
    try
    {
      ((IQQHealthApi)QRoute.apiIPCSync(IQQHealthApi.class)).hideBanner();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PathTraceManager", 1, localException, new Object[] { "fail to hide banner" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.8
 * JD-Core Version:    0.7.0.1
 */