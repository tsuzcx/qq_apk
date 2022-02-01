package com.tencent.mtt.hippy;

import android.content.Context;
import android.text.TextUtils;
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
import com.tencent.mtt.hippy.adapter.thirdparty.HippyThirdPartyAdapter;
import com.tencent.mtt.hippy.bridge.bundleloader.HippyBundleLoader;
import com.tencent.mtt.hippy.bridge.d;
import java.util.ArrayList;
import java.util.List;

public class HippyEngine$EngineInitParams
{
  public Context appContext;
  public String codeCacheTag = "";
  public Context context;
  public String coreJSAssetsPath;
  public String coreJSFilePath;
  public String debugBundleName = "index.bundle";
  public boolean debugMode = false;
  public String debugServerHost = "localhost:38989";
  public HippyDeviceAdapter deviceAdapter;
  public boolean enableBuffer = true;
  public boolean enableLog = false;
  public HippyEngine.EngineMode engineMode = HippyEngine.EngineMode.NORMAL;
  public HippyEngineMonitorAdapter engineMonitor;
  public HippyExceptionHandlerAdapter exceptionHandler;
  public HippyExecutorSupplierAdapter executorSupplier;
  public HippyFontScaleAdapter fontScaleAdapter;
  public int groupId = -1;
  public HippyHttpAdapter httpAdapter;
  public HippyEngine.EngineType iEngineType = HippyEngine.EngineType.RN;
  public HippyImageLoader imageLoader;
  public HippyBundleLoader jsPreloadAssetsPath;
  public HippyBundleLoader jsPreloadFilePath;
  @Deprecated
  public HippyLogAdapter logAdapter;
  public List<HippyAPIProvider> providers;
  public HippySharedPreferencesAdapter sharedPreferencesAdapter;
  public HippySoLoaderAdapter soLoader;
  public HippyStorageAdapter storageAdapter;
  public HippyThirdPartyAdapter thirdPartyAdapter;
  
  protected void check()
  {
    if (this.context == null) {
      throw new IllegalArgumentException(EngineInitParams.class.getName() + " context must not be null!");
    }
    if (this.imageLoader == null) {
      throw new IllegalArgumentException(EngineInitParams.class.getName() + " imageLoader must not be null!");
    }
    if (this.sharedPreferencesAdapter == null) {
      this.sharedPreferencesAdapter = new DefaultSharedPreferencesAdapter(this.context);
    }
    if (this.exceptionHandler == null) {
      this.exceptionHandler = new DefaultExceptionHandler();
    }
    if (this.httpAdapter == null) {
      this.httpAdapter = new DefaultHttpAdapter();
    }
    if (this.executorSupplier == null) {
      this.executorSupplier = new DefaultExecutorSupplierAdapter();
    }
    if (this.storageAdapter == null) {
      this.storageAdapter = new DefaultStorageAdapter(this.context, this.executorSupplier.getDBExecutor());
    }
    if (this.engineMonitor == null) {
      this.engineMonitor = new DefaultEngineMonitorAdapter();
    }
    if (this.fontScaleAdapter == null) {
      this.fontScaleAdapter = new DefaultFontScaleAdapter();
    }
    if (this.soLoader == null) {
      this.soLoader = new DefaultSoLoaderAdapter();
    }
    if (this.deviceAdapter == null) {
      this.deviceAdapter = new DefaultDeviceAdapter();
    }
    if (this.logAdapter == null) {
      this.logAdapter = new DefaultLogAdapter();
    }
    if (this.providers == null) {
      this.providers = new ArrayList();
    }
    this.providers.add(0, new d());
    if ((!this.debugMode) && (TextUtils.isEmpty(this.coreJSAssetsPath)) && (TextUtils.isEmpty(this.coreJSFilePath))) {
      throw new RuntimeException("Hippy: debugMode=true, initParams.coreJSAssetsPath and coreJSFilePath both null!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyEngine.EngineInitParams
 * JD-Core Version:    0.7.0.1
 */