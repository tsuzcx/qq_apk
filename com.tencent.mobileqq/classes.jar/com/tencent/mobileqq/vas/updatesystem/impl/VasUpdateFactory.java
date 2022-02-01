package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.vas.update.factory.api.ICmdManager;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IHttpDownloader;
import com.tencent.vas.update.factory.api.IReportManager;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;

public class VasUpdateFactory
  implements IVasUpdateFactory
{
  public IVasLog a()
  {
    return new VasLogImpl();
  }
  
  public IHttpDownloader b()
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getHttpDownloader();
  }
  
  public IReportManager c()
  {
    return new VasReportManagerImpl();
  }
  
  public IDbManager d()
  {
    return new VasDbManagerImpl();
  }
  
  public ICommonManager e()
  {
    return new VasCommonManagerImpl();
  }
  
  public ICmdManager f()
  {
    return new VasCmdManagerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasUpdateFactory
 * JD-Core Version:    0.7.0.1
 */