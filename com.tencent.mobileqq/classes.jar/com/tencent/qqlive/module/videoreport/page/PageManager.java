package com.tencent.qqlive.module.videoreport.page;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;

public class PageManager
  implements PageSwitchObserver.IPageSwitchListener, AppEventReporter.IAppEventListener
{
  private static final String TAG = "PageManager";
  private DataEntity mCurrentPageDataEntity;
  private PageInfo mCurrentPageInfo;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  private PageManager.InnerRunnable mInnerRunnable = new PageManager.InnerRunnable(this, null);
  private PageInteractiveFlagHandler mInteractiveFlagHandler;
  private boolean mLastPageIsDisappear;
  private ListenerMgr<PageManager.IPageListener> mListenerMgr = new ListenerMgr();
  private int mPgStp;
  
  private void checkPageOut(@Nullable PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "checkPageOut: targetPageInfo = " + paramPageInfo);
    }
    PageInfo localPageInfo = this.mInnerRunnable.pageInfo;
    Object localObject1 = null;
    if (localPageInfo != null)
    {
      Object localObject2 = localPageInfo.getPage();
      if (paramPageInfo != null)
      {
        localObject1 = localObject2;
        if (localPageInfo.getPage() != paramPageInfo.getPage()) {}
      }
      else
      {
        this.mHandler.removeCallbacks(this.mInnerRunnable);
        localObject1 = localObject2;
      }
    }
    if (isPageOut(paramPageInfo, localObject1))
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("PageManager", "checkPageOut: currentPageInfo = " + this.mCurrentPageInfo);
      }
      onPageOut(this.mCurrentPageInfo, paramBoolean);
      this.mLastPageIsDisappear = true;
    }
  }
  
  private void copyCurPageInfo()
  {
    this.mCurrentPageDataEntity = DataEntityOperator.copy(this.mCurrentPageDataEntity);
  }
  
  public static PageManager getInstance()
  {
    return PageManager.InstanceHolder.access$100();
  }
  
  private void init()
  {
    PageSwitchObserver.getInstance().register(this);
    AppEventReporter.getInstance().register(this);
    this.mInteractiveFlagHandler = PageInteractiveFlagHandler.create(this);
  }
  
  private boolean isPageOut(@Nullable PageInfo paramPageInfo, @Nullable Object paramObject)
  {
    boolean bool = true;
    if ((this.mCurrentPageInfo == null) || (this.mLastPageIsDisappear)) {
      bool = false;
    }
    do
    {
      do
      {
        do
        {
          return bool;
          if (paramPageInfo != null) {
            break;
          }
        } while (!VideoReportInner.getInstance().isDebugMode());
        Log.i("PageManager", "isPageOut: hit null targetPage condition");
        return true;
        paramPageInfo = paramPageInfo.getPage();
        if (paramPageInfo != this.mCurrentPageInfo.getPage()) {
          break;
        }
      } while (!VideoReportInner.getInstance().isDebugMode());
      Log.i("PageManager", "isPageOut: hit currentPage condition");
      return true;
      if (!VideoReportInner.getInstance().getConfiguration().isIndependentPageOut()) {
        break;
      }
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.i("PageManager", "isPageOut: hit pendingPage condition");
      }
    } while (paramObject == paramPageInfo);
    return false;
    return false;
  }
  
  private boolean isPotentialPageChange(@NonNull PageInfo paramPageInfo1, @Nullable PageInfo paramPageInfo2, boolean paramBoolean)
  {
    if (paramPageInfo2 == null) {
      paramBoolean = true;
    }
    while (paramPageInfo1.getPage() == paramPageInfo2.getPage()) {
      return paramBoolean;
    }
    return true;
  }
  
  private void onPageIn(PageInfo paramPageInfo)
  {
    StringBuilder localStringBuilder;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localStringBuilder = new StringBuilder().append("onPageIn: pageInfo page=").append(paramPageInfo).append(", decorView=");
      if (paramPageInfo.getPageView() == null) {
        break label111;
      }
    }
    label111:
    for (View localView = paramPageInfo.getPageView().getRootView();; localView = null)
    {
      Log.d("PageManager", localView);
      int i = this.mPgStp + 1;
      this.mPgStp = i;
      updatePageContext(paramPageInfo, i, this.mCurrentPageDataEntity);
      this.mCurrentPageDataEntity = DataBinder.getDataEntity(paramPageInfo.getPage());
      this.mListenerMgr.startNotify(new PageManager.1(this, paramPageInfo));
      return;
    }
  }
  
  private void onPageOut(PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageOut: ");
    }
    copyCurPageInfo();
    this.mListenerMgr.startNotify(new PageManager.2(this, paramPageInfo, paramBoolean));
  }
  
  private void onPageUpdate(PageInfo paramPageInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageUpdate: ");
    }
    this.mListenerMgr.startNotify(new PageManager.3(this, paramPageInfo));
  }
  
  private void updatePageContext(PageInfo paramPageInfo, int paramInt, DataEntity paramDataEntity)
  {
    paramDataEntity = new PageContext(paramInt, paramDataEntity);
    PageContextManager.getInstance().set(paramPageInfo.getPage(), paramDataEntity);
  }
  
  public void clearPageContext(Object paramObject)
  {
    if (!PageFinder.isPage(paramObject))
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageManager", "clearPageContext: object is not page, object = " + paramObject);
      }
      return;
    }
    PageContextManager.getInstance().remove(paramObject);
  }
  
  public PageInfo getCurrentPageInfo()
  {
    return this.mCurrentPageInfo;
  }
  
  boolean isLastPageIsDisappear()
  {
    return this.mLastPageIsDisappear;
  }
  
  public void onAppIn() {}
  
  public void onAppOut(boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "onAppOut: ");
    }
    checkPageOut(null, paramBoolean);
  }
  
  public void onPageAppear(@NonNull PageInfo paramPageInfo)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.i("PageManager", "onPageAppear: page = " + paramPageInfo + ", pageStep = " + this.mPgStp);
      Log.d("LazyInitSequence", "page Appear");
    }
    if (isPotentialPageChange(paramPageInfo, this.mCurrentPageInfo, this.mLastPageIsDisappear)) {
      updatePageContext(paramPageInfo, this.mPgStp, this.mCurrentPageDataEntity);
    }
    this.mHandler.removeCallbacks(this.mInnerRunnable);
    this.mInnerRunnable.pageInfo = paramPageInfo;
    this.mHandler.postDelayed(this.mInnerRunnable, VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime());
  }
  
  public void onPageDisappear(@NonNull PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "onPageDisappear: pageInfo = " + paramPageInfo + ", isMainThread = " + paramBoolean);
    }
    checkPageOut(paramPageInfo, paramBoolean);
  }
  
  public void register(PageManager.IPageListener paramIPageListener)
  {
    this.mListenerMgr.register(paramIPageListener);
  }
  
  public void resetPagePath()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "resetPagePath: ");
    }
    this.mPgStp = 0;
    this.mCurrentPageDataEntity = null;
    this.mCurrentPageInfo = null;
    this.mLastPageIsDisappear = false;
    PageContextManager.getInstance().clear();
    this.mHandler.removeCallbacks(this.mInnerRunnable);
  }
  
  public void unregister(PageManager.IPageListener paramIPageListener)
  {
    this.mListenerMgr.unregister(paramIPageListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager
 * JD-Core Version:    0.7.0.1
 */