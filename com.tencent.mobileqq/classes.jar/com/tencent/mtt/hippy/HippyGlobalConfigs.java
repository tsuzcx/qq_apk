package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.soloader.HippySoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;
import com.tencent.mtt.hippy.utils.LogUtils;

public class HippyGlobalConfigs
{
  private final Context mContext;
  private final HippyDeviceAdapter mDeviceAdapter;
  private final HippyEngineMonitorAdapter mEngineMonitorAdapter;
  private final HippyExceptionHandlerAdapter mExceptionHandler;
  private final HippyExecutorSupplierAdapter mExecutorSupplierAdapter;
  private final HippyFontScaleAdapter mFontScaleAdapter;
  private final HippyHttpAdapter mHttpAdapter;
  private final HippyImageLoader mImageLoaderAdapter;
  private final HippyLogAdapter mLogAdapter;
  private final HippySharedPreferencesAdapter mSharedPreferencesAdapter;
  private final HippySoLoaderAdapter mSoLoaderAdapter;
  private final HippyStorageAdapter mStorageAdapter;
  
  private HippyGlobalConfigs(Context paramContext, HippySharedPreferencesAdapter paramHippySharedPreferencesAdapter, HippyExceptionHandlerAdapter paramHippyExceptionHandlerAdapter, HippyHttpAdapter paramHippyHttpAdapter, HippyImageLoader paramHippyImageLoader, HippyExecutorSupplierAdapter paramHippyExecutorSupplierAdapter, HippyStorageAdapter paramHippyStorageAdapter, HippyEngineMonitorAdapter paramHippyEngineMonitorAdapter, HippyFontScaleAdapter paramHippyFontScaleAdapter, HippySoLoaderAdapter paramHippySoLoaderAdapter, HippyDeviceAdapter paramHippyDeviceAdapter, HippyLogAdapter paramHippyLogAdapter)
  {
    this.mContext = paramContext;
    this.mSharedPreferencesAdapter = paramHippySharedPreferencesAdapter;
    this.mExceptionHandler = paramHippyExceptionHandlerAdapter;
    this.mHttpAdapter = paramHippyHttpAdapter;
    this.mImageLoaderAdapter = paramHippyImageLoader;
    this.mStorageAdapter = paramHippyStorageAdapter;
    this.mExecutorSupplierAdapter = paramHippyExecutorSupplierAdapter;
    this.mEngineMonitorAdapter = paramHippyEngineMonitorAdapter;
    this.mFontScaleAdapter = paramHippyFontScaleAdapter;
    this.mSoLoaderAdapter = paramHippySoLoaderAdapter;
    this.mDeviceAdapter = paramHippyDeviceAdapter;
    this.mLogAdapter = paramHippyLogAdapter;
  }
  
  public HippyGlobalConfigs(HippyEngine.EngineInitParams paramEngineInitParams)
  {
    this.mContext = paramEngineInitParams.context;
    this.mSharedPreferencesAdapter = paramEngineInitParams.sharedPreferencesAdapter;
    this.mExceptionHandler = paramEngineInitParams.exceptionHandler;
    this.mHttpAdapter = paramEngineInitParams.httpAdapter;
    this.mImageLoaderAdapter = paramEngineInitParams.imageLoader;
    this.mStorageAdapter = paramEngineInitParams.storageAdapter;
    this.mExecutorSupplierAdapter = paramEngineInitParams.executorSupplier;
    this.mEngineMonitorAdapter = paramEngineInitParams.engineMonitor;
    this.mFontScaleAdapter = paramEngineInitParams.fontScaleAdapter;
    this.mSoLoaderAdapter = paramEngineInitParams.soLoader;
    this.mDeviceAdapter = paramEngineInitParams.deviceAdapter;
    this.mLogAdapter = paramEngineInitParams.logAdapter;
  }
  
  public void destroyIfNeed()
  {
    try
    {
      if (this.mHttpAdapter != null) {
        this.mHttpAdapter.destroyIfNeed();
      }
      if (this.mStorageAdapter != null) {
        this.mStorageAdapter.destroyIfNeed();
      }
      if (this.mExecutorSupplierAdapter != null) {
        this.mExecutorSupplierAdapter.destroyIfNeed();
      }
      if (this.mImageLoaderAdapter != null)
      {
        this.mImageLoaderAdapter.destroyIfNeed();
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("destroyIfNeed: ");
      localStringBuilder.append(localThrowable.getMessage());
      LogUtils.d("HippyGlobalConfigs", localStringBuilder.toString());
    }
  }
  
  public Context getContext()
  {
    return this.mContext;
  }
  
  public HippyDeviceAdapter getDeviceAdapter()
  {
    return this.mDeviceAdapter;
  }
  
  public HippyEngineMonitorAdapter getEngineMonitorAdapter()
  {
    return this.mEngineMonitorAdapter;
  }
  
  public HippyExceptionHandlerAdapter getExceptionHandler()
  {
    return this.mExceptionHandler;
  }
  
  public HippyExecutorSupplierAdapter getExecutorSupplierAdapter()
  {
    return this.mExecutorSupplierAdapter;
  }
  
  public HippyFontScaleAdapter getFontScaleAdapter()
  {
    return this.mFontScaleAdapter;
  }
  
  public HippyHttpAdapter getHttpAdapter()
  {
    return this.mHttpAdapter;
  }
  
  public HippyImageLoader getImageLoaderAdapter()
  {
    return this.mImageLoaderAdapter;
  }
  
  public HippyLogAdapter getLogAdapter()
  {
    return this.mLogAdapter;
  }
  
  public HippySharedPreferencesAdapter getSharedPreferencesAdapter()
  {
    return this.mSharedPreferencesAdapter;
  }
  
  public HippySoLoaderAdapter getSoLoaderAdapter()
  {
    return this.mSoLoaderAdapter;
  }
  
  public HippyStorageAdapter getStorageAdapter()
  {
    return this.mStorageAdapter;
  }
  
  @Deprecated
  public void to(HippyEngine.EngineInitParams paramEngineInitParams)
  {
    paramEngineInitParams.context = this.mContext;
    paramEngineInitParams.sharedPreferencesAdapter = this.mSharedPreferencesAdapter;
    paramEngineInitParams.exceptionHandler = this.mExceptionHandler;
    paramEngineInitParams.httpAdapter = this.mHttpAdapter;
    paramEngineInitParams.imageLoader = this.mImageLoaderAdapter;
    paramEngineInitParams.storageAdapter = this.mStorageAdapter;
    paramEngineInitParams.executorSupplier = this.mExecutorSupplierAdapter;
    paramEngineInitParams.engineMonitor = this.mEngineMonitorAdapter;
    paramEngineInitParams.fontScaleAdapter = this.mFontScaleAdapter;
    paramEngineInitParams.soLoader = this.mSoLoaderAdapter;
    paramEngineInitParams.deviceAdapter = this.mDeviceAdapter;
    paramEngineInitParams.logAdapter = this.mLogAdapter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyGlobalConfigs
 * JD-Core Version:    0.7.0.1
 */