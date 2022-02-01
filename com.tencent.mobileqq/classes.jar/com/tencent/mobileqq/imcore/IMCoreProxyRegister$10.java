package com.tencent.mobileqq.imcore;

import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.imcore.proxy.db.SQLiteFTSUtilsProxy.Proxy;
import com.tencent.mobileqq.utils.fts.SQLiteFTSUtils;

final class IMCoreProxyRegister$10
  implements SQLiteFTSUtilsProxy.Proxy
{
  public int getFTSNotifyFlag()
  {
    return SQLiteFTSUtils.a(BaseApplicationImpl.getApplication());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.imcore.IMCoreProxyRegister.10
 * JD-Core Version:    0.7.0.1
 */