package com.tencent.mobileqq.pttlogic.api.impl;

import android.text.TextUtils;
import com.tencent.common.AccountDPCHelper;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.ptt.api.IPttOptimizeParams;
import com.tencent.mobileqq.ptt.preop.PreDownloadParams;
import com.tencent.mobileqq.pttlogic.api.IPttConfigService;
import com.tencent.mobileqq.pttlogic.api.IStreamParams;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.LightDpcConfig;
import com.tencent.mobileqq.transfile.NetworkCenter;
import com.tencent.mobileqq.utils.RecordParams;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.jetbrains.annotations.NotNull;

public class PttConfigServiceImpl
  implements IPttConfigService
{
  protected WeakReference<AppRuntime> mApp;
  
  @NotNull
  protected IDPCApi getDPCApi()
  {
    return (IDPCApi)QRoute.api(IDPCApi.class);
  }
  
  @NotNull
  protected IPttOptimizeParams getPttOptimizeParamsApi()
  {
    return (IPttOptimizeParams)QRoute.api(IPttOptimizeParams.class);
  }
  
  @NotNull
  protected IStreamParams getStreamParamsApi()
  {
    return (IStreamParams)QRoute.api(IStreamParams.class);
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.mApp = new WeakReference(paramAppRuntime);
    String str = getDPCApi().getFeatureValue(DPCNames.SilkCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      RecordParams.a(paramAppRuntime, str);
      RecordParams.a(paramAppRuntime, true);
    }
    else
    {
      RecordParams.a(paramAppRuntime, false);
    }
    str = getDPCApi().getFeatureValue(DPCNames.StreamCfg.name(), "null");
    if (!"null".equalsIgnoreCase(str))
    {
      getStreamParamsApi().saveStreamCfg(paramAppRuntime, str);
      getStreamParamsApi().initSupportCfg(paramAppRuntime, true);
    }
    else
    {
      getStreamParamsApi().initSupportCfg(paramAppRuntime, false);
    }
    paramAppRuntime = getDPCApi().getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
    if (paramAppRuntime.length > 13)
    {
      boolean bool = "1".equals(paramAppRuntime[12]);
      AccountDPCHelper.d(BaseApplication.getContext(), bool);
      if (paramAppRuntime.length > 14)
      {
        bool = "1".equals(paramAppRuntime[13]);
        LightDpcConfig.a(BaseApplication.getContext(), bool);
      }
    }
    getDPCApi().addObserver(this);
  }
  
  public void onDestroy()
  {
    this.mApp = null;
    PreDownloadParams.a();
    getDPCApi().removeObserver(this);
    RecordParams.c();
    getStreamParamsApi().release();
  }
  
  public void onDpcPullFinished(boolean paramBoolean)
  {
    Object localObject = tryGetApp();
    if ((localObject != null) && (paramBoolean))
    {
      RecordParams.a((AppRuntime)localObject, getDPCApi().getFeatureValue(DPCNames.SilkCfg.name(), ""));
      RecordParams.a((AppRuntime)localObject, true);
      String str = getDPCApi().getFeatureValue(DPCNames.StreamCfg.name(), "");
      getStreamParamsApi().saveStreamCfg((AppRuntime)localObject, str);
      getStreamParamsApi().initSupportCfg((AppRuntime)localObject, true);
      localObject = getDPCApi().getFeatureValue(DPCNames.aio_config.name(), "").split("\\|");
      if (localObject.length > 13)
      {
        paramBoolean = "1".equals(localObject[12]);
        AccountDPCHelper.d(BaseApplication.getContext(), paramBoolean);
        if (localObject.length > 14)
        {
          paramBoolean = "1".equals(localObject[13]);
          LightDpcConfig.a(BaseApplication.getContext(), paramBoolean);
        }
      }
    }
  }
  
  public void onGetPreDownloadCfg(String paramString)
  {
    TextUtils.isEmpty(paramString);
    NetworkCenter.getInstance();
    AppRuntime localAppRuntime = tryGetApp();
    if (localAppRuntime != null) {
      savePredownloadCfg(paramString, localAppRuntime);
    }
  }
  
  public void onGetPttOptimizeCfg(String paramString)
  {
    AppRuntime localAppRuntime = tryGetApp();
    if (localAppRuntime != null)
    {
      getPttOptimizeParamsApi().savePttOptimizeCfg(localAppRuntime, paramString);
      try
      {
        getPttOptimizeParamsApi().initOptimizeCfg(localAppRuntime, true);
        return;
      }
      finally {}
    }
  }
  
  public void onGetStreamSliceCfg(String paramString)
  {
    AppRuntime localAppRuntime = tryGetApp();
    NetworkCenter.getInstance();
    if (localAppRuntime != null)
    {
      getStreamParamsApi().saveStreamSliceCfg(localAppRuntime, paramString);
      getStreamParamsApi().initSliceCfg(localAppRuntime, true);
    }
  }
  
  protected void savePredownloadCfg(String paramString, AppRuntime paramAppRuntime)
  {
    PreDownloadParams.a(paramAppRuntime, paramString);
    PreDownloadParams.a(paramAppRuntime, true);
  }
  
  protected AppRuntime tryGetApp()
  {
    WeakReference localWeakReference = this.mApp;
    if ((localWeakReference != null) && (!localWeakReference.isEnqueued())) {
      return (AppRuntime)this.mApp.get();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.pttlogic.api.impl.PttConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */