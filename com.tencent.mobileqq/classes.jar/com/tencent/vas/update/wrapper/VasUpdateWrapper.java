package com.tencent.vas.update.wrapper;

import com.tencent.vas.update.factory.api.ICmdManager;
import com.tencent.vas.update.factory.api.ICommonManager;
import com.tencent.vas.update.factory.api.IDbManager;
import com.tencent.vas.update.factory.api.IHttpDownloader;
import com.tencent.vas.update.factory.api.IReportManager;
import com.tencent.vas.update.factory.api.IVasLog;
import com.tencent.vas.update.factory.api.IVasUpdateFactory;
import com.tencent.vas.update.factory.impl.DefaultVasUpdateFactoryImpl;
import com.tencent.vas.update.module.api.IVasUpdateSystem;
import com.tencent.vas.update.module.impl.VasUpdateSystemImpl;

public class VasUpdateWrapper
{
  private static ICmdManager mCmdManager;
  private static ICommonManager mCommonManager;
  private static IDbManager mDbManager;
  private static IHttpDownloader mHttpDownloader;
  private static IReportManager mReporter;
  private static IVasLog mVasLog;
  private static IVasUpdateSystem mVasUpdateSystem;
  private static IVasUpdateFactory mWrapper;
  
  public static ICmdManager getCmdManager()
  {
    ICmdManager localICmdManager = mCmdManager;
    if (localICmdManager != null) {
      return localICmdManager;
    }
    mCmdManager = mWrapper.f();
    if (mCmdManager == null) {
      mCmdManager = DefaultVasUpdateFactoryImpl.g().f();
    }
    return mCmdManager;
  }
  
  public static ICommonManager getCommonManager()
  {
    ICommonManager localICommonManager = mCommonManager;
    if (localICommonManager != null) {
      return localICommonManager;
    }
    mCommonManager = mWrapper.e();
    if (mCommonManager == null) {
      mCommonManager = DefaultVasUpdateFactoryImpl.g().e();
    }
    return mCommonManager;
  }
  
  public static IDbManager getDbManager()
  {
    IDbManager localIDbManager = mDbManager;
    if (localIDbManager != null) {
      return localIDbManager;
    }
    mDbManager = mWrapper.d();
    if (mDbManager == null) {
      mDbManager = DefaultVasUpdateFactoryImpl.g().d();
    }
    return mDbManager;
  }
  
  public static IHttpDownloader getHttpDownloader()
  {
    IHttpDownloader localIHttpDownloader = mHttpDownloader;
    if (localIHttpDownloader != null) {
      return localIHttpDownloader;
    }
    mHttpDownloader = mWrapper.b();
    if (mHttpDownloader == null) {
      mHttpDownloader = DefaultVasUpdateFactoryImpl.g().b();
    }
    return mHttpDownloader;
  }
  
  public static IVasLog getLog()
  {
    IVasLog localIVasLog = mVasLog;
    if (localIVasLog != null) {
      return localIVasLog;
    }
    mVasLog = mWrapper.a();
    if (mVasLog == null) {
      mVasLog = DefaultVasUpdateFactoryImpl.g().a();
    }
    return mVasLog;
  }
  
  public static IReportManager getReportManager()
  {
    IReportManager localIReportManager = mReporter;
    if (localIReportManager != null) {
      return localIReportManager;
    }
    mReporter = mWrapper.c();
    if (mReporter == null) {
      mReporter = DefaultVasUpdateFactoryImpl.g().c();
    }
    return mReporter;
  }
  
  public static IVasUpdateSystem getVasUpdateSystem()
  {
    if (mVasUpdateSystem == null) {
      mVasUpdateSystem = new VasUpdateSystemImpl();
    }
    return mVasUpdateSystem;
  }
  
  public static void setVasUpdateWrapper(IVasUpdateFactory paramIVasUpdateFactory)
  {
    Object localObject = paramIVasUpdateFactory;
    if (paramIVasUpdateFactory == null) {
      localObject = DefaultVasUpdateFactoryImpl.g();
    }
    mWrapper = (IVasUpdateFactory)localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.vas.update.wrapper.VasUpdateWrapper
 * JD-Core Version:    0.7.0.1
 */