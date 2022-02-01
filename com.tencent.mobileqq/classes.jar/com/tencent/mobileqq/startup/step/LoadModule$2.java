package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.imcore.proxy.db.OGEntityDaoManagerProxy.Proxy;
import com.tencent.mobileqq.persistence.OGAbstractDao;
import com.tencent.mobileqq.persistence.OGEntityDaoManager;

final class LoadModule$2
  implements OGEntityDaoManagerProxy.Proxy
{
  public OGAbstractDao getEntityDao(Class paramClass)
  {
    return OGEntityDaoManager.a().a(paramClass);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.LoadModule.2
 * JD-Core Version:    0.7.0.1
 */