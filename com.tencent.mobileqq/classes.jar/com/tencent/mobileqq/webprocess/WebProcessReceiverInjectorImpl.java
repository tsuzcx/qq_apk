package com.tencent.mobileqq.webprocess;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.hippy.qq.api.IHippyAccessHelper;
import com.tencent.hippy.qq.api.IPatchBundleDataHandler;
import com.tencent.hippy.qq.api.OpenHippyInfo;
import com.tencent.mobileqq.activity.springfestival.entry.helper.SpringHbHelper;
import com.tencent.mobileqq.apollo.handler.api.IApolloWebDataHandler;
import com.tencent.mobileqq.apollo.res.api.IApolloSoLoader;
import com.tencent.mobileqq.apollo.res.api.ICmShowRscCacheManager;
import com.tencent.mobileqq.emosm.api.IWebIPCOperatorApi;
import com.tencent.mobileqq.intervideo.yiqikan.TogetherWatchFloatingUtil;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherClientIPCModule;
import com.tencent.mobileqq.intervideo.yiqikan.WatchTogetherFloatingData;
import com.tencent.mobileqq.kandian.biz.detail.web.api.IRIJWebArticlePreloadUtil;
import com.tencent.mobileqq.kandian.biz.video.api.IVideoPluginInstallFactory;
import com.tencent.mobileqq.kandian.repo.webarticle.api.IDataPreloadModule;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.webview.util.IWebProcessReceiverInjector;
import com.tencent.mobileqq.webview.webso.WebSoService;
import com.tencent.mobileqq.webview.webso.WebSoUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import mqq.app.AppRuntime;

public class WebProcessReceiverInjectorImpl
  implements IWebProcessReceiverInjector
{
  private void a(Context paramContext)
  {
    try
    {
      long l1 = System.currentTimeMillis();
      if (!SpringHbHelper.a) {
        SpringHbHelper.a = true;
      }
      long l2 = System.currentTimeMillis();
      paramContext = new StringBuilder();
      paramContext.append("tool进程 fromOfPreload=");
      paramContext.append(WebProcessReceiver.a);
      paramContext.append(",time cost=");
      paramContext.append(l2 - l1);
      QLog.i("springHb_WebProcessReceiverInjectorImpl", 1, paramContext.toString());
      return;
    }
    catch (Exception paramContext)
    {
      QLog.e("springHb_WebProcessReceiverInjectorImpl", 1, "preloadSpringHbVideoSDK fail", paramContext);
    }
  }
  
  private void b(int paramInt)
  {
    try
    {
      PreloadService.a(paramInt);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  protected void a(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("WebProcessReceiverInjectorImpl", 2, "preloadData");
    }
    b(paramInt);
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent)
  {
    WebSoService.a().b();
    WebSoUtils.a();
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, int paramInt)
  {
    if (!((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).isServiceClientBinded()) {
      ((IWebIPCOperatorApi)QRoute.api(IWebIPCOperatorApi.class)).doBindService(paramContext.getApplicationContext());
    }
    ((IPatchBundleDataHandler)QRoute.api(IPatchBundleDataHandler.class)).checkDownloadConfigAsync(true, true);
    if (201 != paramInt)
    {
      if (QLog.isColorLevel())
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("onReceive preloadData standard, fromType=");
        paramAppRuntime.append(paramInt);
        QLog.d("WebProcessReceiverInjectorImpl", 2, paramAppRuntime.toString());
      }
      a(paramInt);
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiverInjectorImpl", 2, "onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY_HALF!");
      }
      WebCoreService.a();
      com.tencent.mobileqq.webview.swift.component.SwiftBrowserStatistics.aC = true;
    }
    if (100 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiverInjectorImpl", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_APOLLO == fromOfPreload");
      }
      ((IApolloWebDataHandler)QRoute.api(IApolloWebDataHandler.class)).initInAsyncThreadIfNeed();
      paramAppRuntime = (IApolloSoLoader)QRoute.api(IApolloSoLoader.class);
      if (!paramAppRuntime.apiIsLibReady()) {
        paramAppRuntime.apiLoadSo("WebProcessReceiverInjectorImpl");
      }
      ((ICmShowRscCacheManager)QRoute.api(ICmShowRscCacheManager.class)).onRoomZipUpdated();
    }
    if (200 == paramInt)
    {
      if (QLog.isColorLevel()) {
        QLog.d("WebProcessReceiverInjectorImpl", 2, "apollo_client onReceive AIOOpenWebMonitor.PRELOAD_FROM_READINJOY == fromOfPreload");
      }
      ((IVideoPluginInstallFactory)QRoute.api(IVideoPluginInstallFactory.class)).create();
      new ListView(paramContext);
    }
    if (301 == paramInt) {
      a(paramContext);
    }
    if (306 == paramInt)
    {
      paramAppRuntime = paramIntent.getStringExtra("show_tab_name");
      paramContext = paramIntent.getBundleExtra("hippy_info");
      if (!TextUtils.isEmpty(paramAppRuntime))
      {
        ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).onMainTabShowForTool(paramAppRuntime);
        return;
      }
      if (paramContext != null) {
        ((IHippyAccessHelper)QRoute.api(IHippyAccessHelper.class)).checkAndPreloadHippyPage(new OpenHippyInfo(paramContext));
      }
    }
  }
  
  public void a(AppRuntime paramAppRuntime, Context paramContext, Intent paramIntent, String paramString)
  {
    if ("action_show_together_floating_windows".equals(paramString))
    {
      try
      {
        QIPCClientHelper.getInstance().register(WatchTogetherClientIPCModule.a());
      }
      catch (Exception paramAppRuntime)
      {
        if (QLog.isColorLevel()) {
          QLog.e("WebProcessReceiverInjectorImpl", 1, "register WatchTogetherClientIPCModule ipc module error.", paramAppRuntime);
        }
      }
      paramAppRuntime = (WatchTogetherFloatingData)paramIntent.getSerializableExtra("com.tencent.mobileqq.webprocess.together.floating.data");
      if ((paramAppRuntime != null) && (TogetherWatchFloatingUtil.b()))
      {
        TogetherWatchFloatingUtil.a(BaseApplicationImpl.context, paramAppRuntime);
        if (QLog.isColorLevel()) {
          QLog.d("WebProcessReceiverInjectorImpl", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("WebProcessReceiverInjectorImpl", 1, "handle ACTION_SHOW_TOGETHER_CONTROL_FLOATING_WINDOWS, data!=null");
      }
    }
    else
    {
      if ("action_preload_rij_article".equals(paramString))
      {
        paramAppRuntime = paramIntent.getStringExtra("BUNDLE_KEY_ARTICLE_URL");
        ((IRIJWebArticlePreloadUtil)QRoute.api(IRIJWebArticlePreloadUtil.class)).preloadImpInWebProcess(paramAppRuntime);
        return;
      }
      if ("action_preload_rij_article_data".equals(paramString))
      {
        paramAppRuntime = paramIntent.getStringExtra("attribute_key_rowKey");
        ((IDataPreloadModule)QRoute.api(IDataPreloadModule.class)).requestArticleDetailInWebProcess(paramAppRuntime);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webprocess.WebProcessReceiverInjectorImpl
 * JD-Core Version:    0.7.0.1
 */