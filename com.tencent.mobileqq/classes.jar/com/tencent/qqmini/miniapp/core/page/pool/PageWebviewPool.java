package com.tencent.qqmini.miniapp.core.page.pool;

import com.tencent.qqmini.miniapp.core.model.EmbeddedState;
import com.tencent.qqmini.miniapp.core.page.AppBrandPageContainer;
import com.tencent.qqmini.miniapp.core.page.BrandPageWebview;
import com.tencent.qqmini.miniapp.core.page.PageWebview;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class PageWebviewPool
{
  private static final String TAG = "PageWebviewPool";
  private ConcurrentHashMap<AppBrandPageContainer, BrandPageWebview> mAppBrandPageMap = new ConcurrentHashMap();
  private BaselibLoader.BaselibContent mBaselibContent;
  private IMiniAppContext mContext;
  
  public PageWebviewPool(IMiniAppContext paramIMiniAppContext)
  {
    this.mContext = paramIMiniAppContext;
  }
  
  public void destroyCachePage()
  {
    try
    {
      Iterator localIterator = this.mAppBrandPageMap.entrySet().iterator();
      while (localIterator.hasNext())
      {
        BrandPageWebview localBrandPageWebview = (BrandPageWebview)((Map.Entry)localIterator.next()).getValue();
        if (localBrandPageWebview != null) {
          localBrandPageWebview.cleanUp();
        }
        localIterator.remove();
      }
      return;
    }
    catch (Exception localException)
    {
      QMLog.e("PageWebviewPool", "destroyCachePage error:", localException);
    }
  }
  
  public BrandPageWebview getAppBrandPage(AppBrandPageContainer paramAppBrandPageContainer)
  {
    BrandPageWebview localBrandPageWebview = (BrandPageWebview)this.mAppBrandPageMap.remove(paramAppBrandPageContainer);
    if (localBrandPageWebview == null)
    {
      QMLog.i("PageWebviewPool", "get page form new BrandPageWebview.");
      paramAppBrandPageContainer = new BrandPageWebview(this.mContext, paramAppBrandPageContainer);
      if (this.mBaselibContent != null) {
        paramAppBrandPageContainer.initBaseJs(this.mBaselibContent);
      }
      return paramAppBrandPageContainer;
    }
    QMLog.i("PageWebviewPool", "get page from cache.");
    return localBrandPageWebview;
  }
  
  public EmbeddedState getEmbeddedState(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if ((this.mAppBrandPageMap != null) && (this.mAppBrandPageMap.size() > 0))
    {
      paramAppBrandPageContainer = (BrandPageWebview)this.mAppBrandPageMap.get(paramAppBrandPageContainer);
      if (paramAppBrandPageContainer != null) {
        return paramAppBrandPageContainer.getRealView().getEmbeddedState();
      }
    }
    return null;
  }
  
  public void initBaseJs(AppBrandPageContainer paramAppBrandPageContainer, BaselibLoader.BaselibContent paramBaselibContent)
  {
    this.mBaselibContent = paramBaselibContent;
    paramAppBrandPageContainer = (BrandPageWebview)this.mAppBrandPageMap.get(paramAppBrandPageContainer);
    if ((paramAppBrandPageContainer != null) && (this.mBaselibContent != null)) {
      paramAppBrandPageContainer.initBaseJs(paramBaselibContent);
    }
  }
  
  public void preLoadAppBrandPage(AppBrandPageContainer paramAppBrandPageContainer)
  {
    if (this.mAppBrandPageMap.containsKey(paramAppBrandPageContainer)) {
      return;
    }
    QMLog.i("PageWebviewPool", "preLoad page");
    BrandPageWebview localBrandPageWebview = new BrandPageWebview(this.mContext, paramAppBrandPageContainer);
    if (this.mBaselibContent != null) {
      localBrandPageWebview.initBaseJs(this.mBaselibContent);
    }
    this.mAppBrandPageMap.put(paramAppBrandPageContainer, localBrandPageWebview);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.page.pool.PageWebviewPool
 * JD-Core Version:    0.7.0.1
 */