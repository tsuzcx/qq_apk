package com.tencent.mobileqq.vashealth.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vashealth.api.IQQHealthApi;
import com.tencent.qphone.base.util.QLog;

class PathTraceManagerImpl$7
  implements Runnable
{
  PathTraceManagerImpl$7(PathTraceManagerImpl paramPathTraceManagerImpl, int paramInt, String paramString) {}
  
  public void run()
  {
    try
    {
      ((IQQHealthApi)QRoute.apiIPCSync(IQQHealthApi.class)).showBanner(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaLangString);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PathTraceManager", 1, localException, new Object[] { "fail to show banner" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.api.impl.PathTraceManagerImpl.7
 * JD-Core Version:    0.7.0.1
 */