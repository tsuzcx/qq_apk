package com.tencent.mobileqq.transfile.api.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.transfile.api.IQuicSoLoadApi;
import com.tencent.qphone.base.util.QLog;

public class QuicSoLoadApiImpl
  implements IQuicSoLoadApi
{
  public boolean loadQuicSo()
  {
    LoadExtResult localLoadExtResult = ((ISoLoaderService)QRoute.api(ISoLoaderService.class)).loadSequentiallySync(new String[] { "andromeda", "quic_engine" }, null);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("quic load code: ");
      localStringBuilder.append(localLoadExtResult.getResultCode());
      QLog.d("QuicSoLoad", 2, localStringBuilder.toString());
    }
    return localLoadExtResult.isSucc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.api.impl.QuicSoLoadApiImpl
 * JD-Core Version:    0.7.0.1
 */