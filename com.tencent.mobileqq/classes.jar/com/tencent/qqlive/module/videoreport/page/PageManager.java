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
import java.util.Iterator;
import java.util.Set;

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
  
  private void checkPageOut()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "checkPageOut, mCurrentPageInfo = " + this.mCurrentPageInfo);
    }
    if ((this.mCurrentPageInfo == null) || (this.mLastPageIsDisappear)) {
      return;
    }
    if (this.mInnerRunnable.pageInfo != null) {
      this.mHandler.removeCallbacks(this.mInnerRunnable);
    }
    onPageOut(null, this.mCurrentPageInfo, true);
    this.mLastPageIsDisappear = true;
  }
  
  private void copyCurPageInfo()
  {
    this.mCurrentPageDataEntity = DataEntityOperator.copy(this.mCurrentPageDataEntity);
  }
  
  private PageInfo findNewPageLinkHead(@NonNull PageInfo paramPageInfo, View paramView)
  {
    Object localObject2 = paramPageInfo.getPageView();
    Object localObject3 = paramPageInfo;
    for (;;)
    {
      Object localObject1 = paramPageInfo;
      if (localObject2 != null)
      {
        localObject1 = localObject3;
        if (localObject3 != null)
        {
          localObject1 = localObject3;
          if (localObject2 == ((PageInfo)localObject3).getPageView()) {
            localObject1 = ((PageInfo)localObject3).getParentPage();
          }
        }
        if (localObject2 != paramView) {}
      }
      else
      {
        return localObject1;
      }
      localObject2 = ((View)localObject2).getParent();
      if ((localObject2 instanceof View))
      {
        localObject2 = (View)localObject2;
        localObject3 = localObject1;
      }
      else
      {
        localObject2 = null;
        localObject3 = localObject1;
      }
    }
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
  
  private void onPageIn(PageInfo paramPageInfo1, PageInfo paramPageInfo2, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localStringBuilder = new StringBuilder().append("onPageIn: pageInfo page=").append(paramPageInfo1).append(", decorView=");
      if (paramPageInfo1.getPageView() == null) {
        break label126;
      }
    }
    label126:
    for (Object localObject = paramPageInfo1.getPageView().getRootView();; localObject = null)
    {
      Log.d("PageManager", localObject);
      int i = this.mPgStp + 1;
      this.mPgStp = i;
      localObject = this.mCurrentPageDataEntity;
      this.mCurrentPageDataEntity = paramPageInfo1.constructDataEntityLink();
      updatePageContext(paramPageInfo1, paramPageInfo2, i, (DataEntity)localObject);
      paramPageInfo2 = paramPageInfo1.findNewInPage(paramPageInfo2);
      this.mListenerMgr.startNotify(new PageManager.1(this, paramPageInfo1, paramPageInfo2, paramInt));
      return;
    }
  }
  
  private void onPageOut(PageInfo paramPageInfo1, @NonNull PageInfo paramPageInfo2, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageOut: ");
    }
    copyCurPageInfo();
    if (paramPageInfo1 != null) {}
    for (paramPageInfo1 = paramPageInfo1.findNewOutPage(paramPageInfo2);; paramPageInfo1 = paramPageInfo2.findNewOutPage(paramPageInfo2))
    {
      this.mListenerMgr.startNotify(new PageManager.2(this, paramPageInfo2, paramPageInfo1, paramBoolean));
      paramPageInfo1 = paramPageInfo1.iterator();
      while (paramPageInfo1.hasNext())
      {
        paramPageInfo2 = (PageInfo)paramPageInfo1.next();
        if (paramPageInfo2.getPage() == null) {
          PageContextManager.getInstance().remove(paramPageInfo2.getPageHashCode());
        }
      }
    }
  }
  
  private void onPageUpdate(PageInfo paramPageInfo, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageUpdate: ");
    }
    this.mListenerMgr.startNotify(new PageManager.3(this, paramPageInfo, paramInt));
  }
  
  private void updatePageContext(PageInfo paramPageInfo1, PageInfo paramPageInfo2, int paramInt, DataEntity paramDataEntity)
  {
    if (paramPageInfo1 == null) {}
    for (;;)
    {
      return;
      paramPageInfo1 = paramPageInfo1.findNewInPage(paramPageInfo2).iterator();
      while (paramPageInfo1.hasNext())
      {
        paramPageInfo2 = (PageInfo)paramPageInfo1.next();
        PageContext localPageContext = new PageContext(paramInt, DataBinder.getDataEntity(paramPageInfo2.getPage()), paramDataEntity);
        PageContextManager.getInstance().set(paramPageInfo2.getPageHashCode(), localPageContext);
      }
    }
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
    PageContextManager.getInstance().remove(paramObject.hashCode());
  }
  
  @Nullable
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
    checkPageOut();
  }
  
  public void onPageAppear(@NonNull PageInfo paramPageInfo, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Log.i("PageManager", "onPageAppear: page = " + paramPageInfo + ", pageStep = " + this.mPgStp);
      Log.d("LazyInitSequence", "page Appear");
    }
    if (isPotentialPageChange(paramPageInfo, this.mCurrentPageInfo, this.mLastPageIsDisappear)) {
      updatePageContext(paramPageInfo, this.mCurrentPageInfo, this.mPgStp, this.mCurrentPageDataEntity);
    }
    this.mHandler.removeCallbacks(this.mInnerRunnable);
    this.mInnerRunnable.pageInfo = paramPageInfo;
    this.mInnerRunnable.invokeFrom = paramInt;
    this.mHandler.postDelayed(this.mInnerRunnable, VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime());
  }
  
  public boolean onPageDestroyed(@NonNull View paramView)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "onPageDestroyed, mCurrentPageInfo = " + this.mCurrentPageInfo + ", disappearingView = " + paramView);
    }
    boolean bool2;
    if ((this.mCurrentPageInfo == null) || (this.mLastPageIsDisappear))
    {
      bool2 = false;
      return bool2;
    }
    paramView = findNewPageLinkHead(this.mCurrentPageInfo, paramView);
    boolean bool1;
    if (paramView != this.mCurrentPageInfo)
    {
      bool1 = true;
      label85:
      if (bool1) {
        onPageOut(paramView, this.mCurrentPageInfo, true);
      }
      if (paramView != null) {
        break label151;
      }
    }
    for (this.mLastPageIsDisappear = true;; this.mLastPageIsDisappear = false)
    {
      bool2 = bool1;
      if (!VideoReportInner.getInstance().isDebugMode()) {
        break;
      }
      Log.i("PageManager", "onPageDestroyed, hasNewPageOut = " + bool1);
      return bool1;
      bool1 = false;
      break label85;
      label151:
      this.mCurrentPageInfo = paramView;
    }
  }
  
  public void onPageDisappear()
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageManager", "onPageDisappear");
    }
    checkPageOut();
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