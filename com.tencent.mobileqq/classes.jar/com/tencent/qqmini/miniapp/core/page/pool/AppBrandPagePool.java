package com.tencent.qqmini.miniapp.core.page.pool;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPage;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import java.util.concurrent.ConcurrentLinkedQueue;

public class AppBrandPagePool
{
  public static final String TAG = "AppBrandPagePool";
  private final ConcurrentLinkedQueue<AppBrandPage> mBrandPageList = new ConcurrentLinkedQueue();
  private PageWebviewPool mPageWebviewPool;
  
  public AppBrandPagePool(IMiniAppContext paramIMiniAppContext)
  {
    this.mPageWebviewPool = new PageWebviewPool(paramIMiniAppContext);
  }
  
  public void destroyCachePage()
  {
    this.mBrandPageList.clear();
    PageWebviewPool localPageWebviewPool = this.mPageWebviewPool;
    if (localPageWebviewPool != null) {
      localPageWebviewPool.destroyCachePage();
    }
  }
  
  public void destroyPageWebviewCache()
  {
    PageWebviewPool localPageWebviewPool = this.mPageWebviewPool;
    if (localPageWebviewPool != null) {
      localPageWebviewPool.destroyCachePage();
    }
  }
  
  public AppBrandPage getAppBrandPage(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("mBrandPageList size : ");
    ((StringBuilder)localObject).append(this.mBrandPageList.size());
    QMLog.d("AppBrandPagePool", ((StringBuilder)localObject).toString());
    localObject = (AppBrandPage)this.mBrandPageList.poll();
    if (localObject == null)
    {
      QMLog.i("AppBrandPagePool", "getAppBrandPage form new BrandPageWebview.");
      return new AppBrandPage(paramIMiniAppContext, paramAppBrandPageContainer);
    }
    QMLog.i("AppBrandPagePool", "getAppBrandPage from cache.");
    return localObject;
  }
  
  public EmbeddedState getEmbeddedState(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.mBrandPageList.size() > 0)
    {
      PageWebviewPool localPageWebviewPool = this.mPageWebviewPool;
      if (localPageWebviewPool != null) {
        return localPageWebviewPool.getEmbeddedState(paramAppBrandPageContainer);
      }
    }
    return null;
  }
  
  public PageWebviewPool getPageWebviewPool()
  {
    return this.mPageWebviewPool;
  }
  
  public void initBaseJs(AppBrandPageContainer paramAppBrandPageContainer, BaselibLoader.BaselibContent paramBaselibContent)
  {
    PageWebviewPool localPageWebviewPool = this.mPageWebviewPool;
    if (localPageWebviewPool != null) {
      localPageWebviewPool.initBaseJs(paramAppBrandPageContainer, paramBaselibContent);
    }
  }
  
  public void preLoadAppBrandPage(IMiniAppContext paramIMiniAppContext, AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (paramIMiniAppContext == null) {
      return;
    }
    if (this.mBrandPageList.size() <= 0)
    {
      QMLog.d("AppBrandPagePool", "preLoadAppBrandPage");
      paramIMiniAppContext = new AppBrandPage(paramIMiniAppContext, paramAppBrandPageContainer);
      this.mBrandPageList.add(paramIMiniAppContext);
    }
    paramIMiniAppContext = this.mPageWebviewPool;
    if (paramIMiniAppContext != null) {
      paramIMiniAppContext.preLoadAppBrandPage(paramAppBrandPageContainer);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.pool.AppBrandPagePool
 * JD-Core Version:    0.7.0.1
 */