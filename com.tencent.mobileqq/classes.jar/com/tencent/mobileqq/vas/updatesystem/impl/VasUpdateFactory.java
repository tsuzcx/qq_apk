package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.vas.updatesystem.api.IVasQuickUpdateAdapter;
import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class VasUpdateFactory
  implements IVasUpdateFactory
{
  public ICmdManager getCmdManager()
  {
    return new VasCmdManagerImpl();
  }
  
  public ICommonManager getCommonManager()
  {
    return new VasCommonManagerImpl();
  }
  
  public IDbManager getDbManager()
  {
    return new VasDbManagerImpl();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return ((IVasQuickUpdateAdapter)QRoute.api(IVasQuickUpdateAdapter.class)).getHttpDownloader();
  }
  
  public IVasLog getLog()
  {
    return new VasLogImpl();
  }
  
  public IReportManager getReportManager()
  {
    return new VasReportManagerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasUpdateFactory
 * JD-Core Version:    0.7.0.1
 */