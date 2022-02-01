package com.tencent.vas.update.factory.impl;

import com.tencent.vas.update.factory.api.ICmdManager;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IHttpDownloader;
import com.tencent.vas.update.factory.api.IReportManager;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;

public class DefaultVasUpdateFactoryImpl
  implements IVasUpdateFactory
{
  private static DefaultVasUpdateFactoryImpl a;
  
  public static DefaultVasUpdateFactoryImpl g()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new DefaultVasUpdateFactoryImpl();
        }
      }
      finally {}
    }
    return a;
  }
  
  public IVasLog a()
  {
    return new DefaultVasLogImpl();
  }
  
  public IHttpDownloader b()
  {
    return new DefaultHttpDownloaderImpl();
  }
  
  public IReportManager c()
  {
    return new DefaultReportManagerImpl();
  }
  
  public IDbManager d()
  {
    return new DefaultDbManagerImpl();
  }
  
  public ICommonManager e()
  {
    return new DefaultCommonManagerImpl();
  }
  
  public ICmdManager f()
  {
    return new DefaultCmdManagerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.factory.impl.DefaultVasUpdateFactoryImpl
 * JD-Core Version:    0.7.0.1
 */