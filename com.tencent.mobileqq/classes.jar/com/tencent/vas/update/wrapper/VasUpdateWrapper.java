package com.tencent.vas.update.wrapper;

import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.ICommonManager;
import com.tencent.vas.update.callback.IDbManager;
import com.tencent.vas.update.callback.IHttpDownloader;
import com.tencent.vas.update.callback.IReportManager;
import com.tencent.vas.update.callback.IVasLog;
import com.tencent.vas.update.callback.IVasUpdateFactory;
import com.tencent.vas.update.module.impl.DefaultVasUpdateFactory;

public class VasUpdateWrapper
{
  private static ICmdManager mCmdManager;
  private static ICommonManager mCommonManager;
  private static IDbManager mDbManager;
  private static IHttpDownloader mHttpDownloader;
  private static IReportManager mReporter;
  private static IVasLog mVasLog;
  private static IVasUpdateFactory mWrapper;
  
  public static ICmdManager getCmdManager()
  {
    if (mCmdManager != null) {
      return mCmdManager;
    }
    mCmdManager = mWrapper.getCmdManager();
    if (mCmdManager == null) {
      mCmdManager = DefaultVasUpdateFactory.getInstance().getCmdManager();
    }
    return mCmdManager;
  }
  
  public static ICommonManager getCommonManager()
  {
    if (mCommonManager != null) {
      return mCommonManager;
    }
    mCommonManager = mWrapper.getCommonManager();
    if (mCommonManager == null) {
      mCommonManager = DefaultVasUpdateFactory.getInstance().getCommonManager();
    }
    return mCommonManager;
  }
  
  public static IDbManager getDbManager()
  {
    if (mDbManager != null) {
      return mDbManager;
    }
    mDbManager = mWrapper.getDbManager();
    if (mDbManager == null) {
      mDbManager = DefaultVasUpdateFactory.getInstance().getDbManager();
    }
    return mDbManager;
  }
  
  public static IHttpDownloader getHttpDownloader()
  {
    if (mHttpDownloader != null) {
      return mHttpDownloader;
    }
    mHttpDownloader = mWrapper.getHttpDownloader();
    if (mHttpDownloader == null) {
      mHttpDownloader = DefaultVasUpdateFactory.getInstance().getHttpDownloader();
    }
    return mHttpDownloader;
  }
  
  public static IVasLog getLog()
  {
    if (mVasLog != null) {
      return mVasLog;
    }
    mVasLog = mWrapper.getLog();
    if (mVasLog == null) {
      mVasLog = DefaultVasUpdateFactory.getInstance().getLog();
    }
    return mVasLog;
  }
  
  public static IReportManager getReportManager()
  {
    if (mReporter != null) {
      return mReporter;
    }
    mReporter = mWrapper.getReportManager();
    if (mReporter == null) {
      mReporter = DefaultVasUpdateFactory.getInstance().getReportManager();
    }
    return mReporter;
  }
  
  public static void setVasUpdateWrapper(IVasUpdateFactory paramIVasUpdateFactory)
  {
    Object localObject = paramIVasUpdateFactory;
    if (paramIVasUpdateFactory == null) {
      localObject = DefaultVasUpdateFactory.getInstance();
    }
    mWrapper = (IVasUpdateFactory)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.wrapper.VasUpdateWrapper
 * JD-Core Version:    0.7.0.1
 */