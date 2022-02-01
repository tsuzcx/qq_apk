package com.tencent.qqmini.miniapp.core;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebviewContainer;
import com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool;
import com.tencent.qqmini.miniapp.core.service.IAppBrandService;
import com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager;
import com.tencent.qqmini.miniapp.plugin.EmbeddedWidgetClientFactory;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.launcher.AppLoaderFactory;
import com.tencent.qqmini.sdk.launcher.core.action.GetScreenshot.Callback;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.MapProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ShareState;
import com.tencent.qqmini.sdk.utils.SaveCaptureImageUitl;
import com.tencent.qqmini.sdk.widget.media.IVideoPlayerUIImpl;
import com.tencent.qqmini.sdk.widget.media.MiniAppVideoController;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class AppBrandRuntime
  extends BaseAppBrandRuntime
{
  public static final String MAP_TAG = "MiniAppMapTag";
  private static final String TAG = "minisdk-start_AppBrandRuntime";
  public static final String VIEW_TAG = "MiniAppVideoPlayer";
  public static volatile boolean webviewDataDirectoryInited = false;
  public boolean isGettingScreenShot = false;
  private List<String> loadedAppServiceJsList = new ArrayList();
  public MiniAppWorkerManager mMiniAppWorkerManager;
  
  public AppBrandRuntime(Context paramContext)
  {
    super(paramContext);
    try
    {
      if ((!webviewDataDirectoryInited) && (Build.VERSION.SDK_INT >= 28))
      {
        webviewDataDirectoryInited = true;
        WebView.setDataDirectorySuffix(AppLoaderFactory.g().getProcessName());
      }
      return;
    }
    catch (Throwable paramContext)
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "setDataDirectorySuffix error. " + paramContext.getMessage());
    }
  }
  
  private void getScreenshotFromView(GetScreenshot.Callback paramCallback, View paramView)
  {
    paramView = SaveCaptureImageUitl.buildBitmapFromView(paramView);
    if ((paramView == null) || (paramView.isRecycled()))
    {
      if (paramCallback != null) {
        paramCallback.onGetScreenshot(null);
      }
      return;
    }
    ThreadManager.executeOnDiskIOThreadPool(new AppBrandRuntime.5(this, paramCallback, paramView));
  }
  
  private void initEmbeddedState()
  {
    if (this.appBrandService != null) {
      this.appBrandService.initEmbeddedState(getEmbeddedState());
    }
  }
  
  public EmbeddedState getEmbeddedState()
  {
    if (((this.pageContainer instanceof AppBrandPageContainer)) && (((AppBrandPageContainer)this.pageContainer).getAppBrandPagePool() != null)) {
      return ((AppBrandPageContainer)this.pageContainer).getAppBrandPagePool().getEmbeddedState((AppBrandPageContainer)this.pageContainer);
    }
    QMLog.e("minisdk-start_AppBrandRuntime", "Failed to get embedded state, pageContainer is null");
    return null;
  }
  
  public MiniAppWorkerManager getMiniAppWorkerManager()
  {
    return this.mMiniAppWorkerManager;
  }
  
  public void getScreenshot(GetScreenshot.Callback paramCallback)
  {
    this.isGettingScreenShot = true;
    AppBrandPage localAppBrandPage = ((AppBrandPageContainer)this.pageContainer).getShowingPage();
    if (localAppBrandPage != null)
    {
      localFrameLayout = localAppBrandPage.getCenterLayout();
      localObject = localAppBrandPage.getPageWebviewContainer();
      localView = ((PageWebviewContainer)localObject).findViewWithTag("MiniAppVideoPlayer");
      localObject = ((PageWebviewContainer)localObject).findViewWithTag("MiniAppMapTag");
      localEmbeddedWidgetClientFactory = localAppBrandPage.getRootContainer().getCurrentX5EmbeddedWidgetClientFactory();
      if ((localView instanceof IVideoPlayerUIImpl)) {
        ((IVideoPlayerUIImpl)localView).getController().captureImage(new AppBrandRuntime.2(this, localFrameLayout, paramCallback, localView));
      }
    }
    while (paramCallback == null)
    {
      FrameLayout localFrameLayout;
      Object localObject;
      View localView;
      EmbeddedWidgetClientFactory localEmbeddedWidgetClientFactory;
      return;
      if (localObject != null)
      {
        ((MapProxy)ProxyManager.get(MapProxy.class)).captureImage(this, (View)localObject, localFrameLayout, new AppBrandRuntime.3(this, paramCallback));
        return;
      }
      if ((localEmbeddedWidgetClientFactory != null) && (localEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap() != null) && (localEmbeddedWidgetClientFactory.getEmbeddedWidgetClientHolderMap().size() > 0))
      {
        localAppBrandPage.getCurrentPageWebview().shotWebview(new AppBrandRuntime.4(this, paramCallback, localFrameLayout));
        return;
      }
      getScreenshotFromView(paramCallback, localFrameLayout);
      this.isGettingScreenShot = false;
      return;
    }
    QMLog.e("minisdk-start_AppBrandRuntime", "getScreenshot, current page is null, callback null.");
    paramCallback.onGetScreenshot(null);
    this.isGettingScreenShot = false;
  }
  
  public ShareState getShareState()
  {
    Object localObject = ((AppBrandPageContainer)this.pageContainer).getShowingPage();
    if (localObject == null)
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "Failed to get share state, AppBrandPage is null");
      return null;
    }
    localObject = ((AppBrandPage)localObject).getCurrentPageWebview();
    if (localObject == null)
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "Failed to get share state, PageWebview is null");
      return null;
    }
    return ((PageWebview)localObject).getShareState();
  }
  
  public void init(IAppBrandService paramIAppBrandService)
  {
    super.init(paramIAppBrandService);
    initEmbeddedState();
  }
  
  public void loadSubPkgAppService(String paramString)
  {
    if (TextUtils.isEmpty(paramString))
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "loadSubPkgAppService url is null.");
      return;
    }
    if (this.mApkgInfo == null)
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "loadSubPkgAppService ApkgInfo is null.");
      return;
    }
    String str = this.mApkgInfo.getRootPath(paramString);
    if (TextUtils.isEmpty(str))
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "loadSubPkgAppService subPkgRoot is null.");
      return;
    }
    if (this.loadedAppServiceJsList.contains(paramString))
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "loadSubPkgAppService has loaded.");
      return;
    }
    str = this.mApkgInfo.getAppServiceJsContent(str);
    if (TextUtils.isEmpty(str))
    {
      QMLog.e("minisdk-start_AppBrandRuntime", "loadSubPkgAppService appServiceJsStr is null.");
      return;
    }
    this.appBrandService.evaluateJs(str, new AppBrandRuntime.1(this, paramString));
  }
  
  public void onRuntimeCreate()
  {
    super.onRuntimeCreate();
    this.pageContainer = new AppBrandPageContainer(this, this.mEventListener);
    this.mMiniAppWorkerManager = new MiniAppWorkerManager(this);
  }
  
  public void onRuntimeDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.AppBrandRuntime
 * JD-Core Version:    0.7.0.1
 */