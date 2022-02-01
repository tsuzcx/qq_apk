package com.tencent.mtt.hippy;

import android.content.Context;
import com.tencent.mtt.hippy.adapter.DefaultLogAdapter;
import com.tencent.mtt.hippy.adapter.HippyLogAdapter;
import com.tencent.mtt.hippy.adapter.device.DefaultDeviceAdapter;
import com.tencent.mtt.hippy.adapter.device.HippyDeviceAdapter;
import com.tencent.mtt.hippy.adapter.exception.DefaultExceptionHandler;
import com.tencent.mtt.hippy.adapter.exception.HippyExceptionHandlerAdapter;
import com.tencent.mtt.hippy.adapter.executor.DefaultExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.executor.HippyExecutorSupplierAdapter;
import com.tencent.mtt.hippy.adapter.font.DefaultFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.font.HippyFontScaleAdapter;
import com.tencent.mtt.hippy.adapter.http.DefaultHttpAdapter;
import com.tencent.mtt.hippy.adapter.http.HippyHttpAdapter;
import com.tencent.mtt.hippy.adapter.image.HippyImageLoader;
import com.tencent.mtt.hippy.adapter.monitor.DefaultEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.DefaultSharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.sharedpreferences.HippySharedPreferencesAdapter;
import com.tencent.mtt.hippy.adapter.soloader.DefaultSoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.soloader.HippySoLoaderAdapter;
import com.tencent.mtt.hippy.adapter.storage.DefaultStorageAdapter;
import com.tencent.mtt.hippy.adapter.storage.HippyStorageAdapter;

public class HippyGlobalConfigs$Builder
{
  private Context mContext;
  private HippyDeviceAdapter mDeviceAdapter;
  private HippyEngineMonitorAdapter mEngineMonitorAdapter;
  private HippyExceptionHandlerAdapter mExceptionHandler;
  private HippyExecutorSupplierAdapter mExecutorSupplierAdapter;
  private HippyFontScaleAdapter mFontScaleAdapter;
  private HippyHttpAdapter mHttpAdapter;
  private HippyImageLoader mImageLoaderAdapter;
  private HippyLogAdapter mLogAdapter;
  private HippySharedPreferencesAdapter mSharedPreferencesAdapter;
  private HippySoLoaderAdapter mSoLoaderAdapter;
  private HippyStorageAdapter mStorageAdapter;
  
  @Deprecated
  public HippyGlobalConfigs build()
  {
    Object localObject = this.mContext;
    if (localObject != null)
    {
      if (this.mSharedPreferencesAdapter == null) {
        this.mSharedPreferencesAdapter = new DefaultSharedPreferencesAdapter((Context)localObject);
      }
      if (this.mExceptionHandler == null) {
        this.mExceptionHandler = new DefaultExceptionHandler();
      }
      if (this.mHttpAdapter == null) {
        this.mHttpAdapter = new DefaultHttpAdapter();
      }
      if (this.mExecutorSupplierAdapter == null) {
        this.mExecutorSupplierAdapter = new DefaultExecutorSupplierAdapter();
      }
      if (this.mStorageAdapter == null) {
        this.mStorageAdapter = new DefaultStorageAdapter(this.mContext, this.mExecutorSupplierAdapter.getDBExecutor());
      }
      if (this.mEngineMonitorAdapter == null) {
        this.mEngineMonitorAdapter = new DefaultEngineMonitorAdapter();
      }
      if (this.mFontScaleAdapter == null) {
        this.mFontScaleAdapter = new DefaultFontScaleAdapter();
      }
      if (this.mSoLoaderAdapter == null) {
        this.mSoLoaderAdapter = new DefaultSoLoaderAdapter();
      }
      if (this.mDeviceAdapter == null) {
        this.mDeviceAdapter = new DefaultDeviceAdapter();
      }
      if (this.mLogAdapter == null) {
        this.mLogAdapter = new DefaultLogAdapter();
      }
      localObject = this.mImageLoaderAdapter;
      if (localObject != null) {
        return new HippyGlobalConfigs(this.mContext, this.mSharedPreferencesAdapter, this.mExceptionHandler, this.mHttpAdapter, (HippyImageLoader)localObject, this.mExecutorSupplierAdapter, this.mStorageAdapter, this.mEngineMonitorAdapter, this.mFontScaleAdapter, this.mSoLoaderAdapter, this.mDeviceAdapter, this.mLogAdapter, null);
      }
      throw new IllegalArgumentException("HippyGlobalConfigs ImageLoaderAdapter must is not null!");
    }
    throw new IllegalArgumentException("HippyGlobalConfigs Context must is not null!");
  }
  
  public HippyLogAdapter getLogAdapter()
  {
    return this.mLogAdapter;
  }
  
  public Builder setContext(Context paramContext)
  {
    this.mContext = paramContext;
    return this;
  }
  
  public Builder setDeviceAdapter(HippyDeviceAdapter paramHippyDeviceAdapter)
  {
    this.mDeviceAdapter = paramHippyDeviceAdapter;
    return this;
  }
  
  public Builder setEngineMonitorAdapter(HippyEngineMonitorAdapter paramHippyEngineMonitorAdapter)
  {
    this.mEngineMonitorAdapter = paramHippyEngineMonitorAdapter;
    return this;
  }
  
  public Builder setExceptionHandler(HippyExceptionHandlerAdapter paramHippyExceptionHandlerAdapter)
  {
    this.mExceptionHandler = paramHippyExceptionHandlerAdapter;
    return this;
  }
  
  public Builder setExecutorSupplierAdapter(HippyExecutorSupplierAdapter paramHippyExecutorSupplierAdapter)
  {
    this.mExecutorSupplierAdapter = paramHippyExecutorSupplierAdapter;
    return this;
  }
  
  public Builder setFontScaleAdapter(HippyFontScaleAdapter paramHippyFontScaleAdapter)
  {
    this.mFontScaleAdapter = paramHippyFontScaleAdapter;
    return this;
  }
  
  public Builder setHttpAdapter(HippyHttpAdapter paramHippyHttpAdapter)
  {
    this.mHttpAdapter = paramHippyHttpAdapter;
    return this;
  }
  
  public Builder setImageLoaderAdapter(HippyImageLoader paramHippyImageLoader)
  {
    this.mImageLoaderAdapter = paramHippyImageLoader;
    return this;
  }
  
  public Builder setLogAdapter(HippyLogAdapter paramHippyLogAdapter)
  {
    this.mLogAdapter = paramHippyLogAdapter;
    return this;
  }
  
  public Builder setSharedPreferencesAdapter(HippySharedPreferencesAdapter paramHippySharedPreferencesAdapter)
  {
    this.mSharedPreferencesAdapter = paramHippySharedPreferencesAdapter;
    return this;
  }
  
  public Builder setSoLoaderAdapter(HippySoLoaderAdapter paramHippySoLoaderAdapter)
  {
    this.mSoLoaderAdapter = paramHippySoLoaderAdapter;
    return this;
  }
  
  public Builder setStorageAdapter(HippyStorageAdapter paramHippyStorageAdapter)
  {
    this.mStorageAdapter = paramHippyStorageAdapter;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyGlobalConfigs.Builder
 * JD-Core Version:    0.7.0.1
 */