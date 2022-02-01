package com.tencent.vas.update.module.impl;

import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;

public class DefaultVasUpdateFactory
  implements IVasUpdateFactory
{
  private static DefaultVasUpdateFactory mInstance;
  
  public static DefaultVasUpdateFactory getInstance()
  {
    if (mInstance == null) {
      try
      {
        if (mInstance == null) {
          mInstance = new DefaultVasUpdateFactory();
        }
      }
      finally {}
    }
    return mInstance;
  }
  
  public ICmdManager getCmdManager()
  {
    return new DefaultCmdManagerImpl();
  }
  
  public ICommonManager getCommonManager()
  {
    return new DefaultCommonManagerImpl();
  }
  
  public IDbManager getDbManager()
  {
    return new DefaultDbManagerImpl();
  }
  
  public IHttpDownloader getHttpDownloader()
  {
    return new DefaultHttpDownloaderImpl();
  }
  
  public IVasLog getLog()
  {
    return new DefaultVasLogImpl();
  }
  
  public IReportManager getReportManager()
  {
    return new DefaultReportManagerImpl();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.vas.update.module.impl.DefaultVasUpdateFactory
 * JD-Core Version:    0.7.0.1
 */