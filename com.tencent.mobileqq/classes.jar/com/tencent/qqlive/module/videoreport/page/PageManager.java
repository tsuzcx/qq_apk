package com.tencent.qqlive.module.videoreport.page;

import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.data.DataBinder;
import com.tencent.qqlive.module.videoreport.data.DataEntity;
import com.tencent.qqlive.module.videoreport.data.DataEntityOperator;
import com.tencent.qqlive.module.videoreport.data.DataRWProxy;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget;
import com.tencent.qqlive.module.videoreport.report.FinalDataTarget.IFinalDataHandleListener;
import com.tencent.qqlive.module.videoreport.reportdata.FinalData;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class PageManager
  implements PageSwitchObserver.IPageSwitchListener, AppEventReporter.IAppEventListener, FinalDataTarget.IFinalDataHandleListener
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
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("checkPageOut, mCurrentPageInfo = ");
      localStringBuilder.append(this.mCurrentPageInfo);
      Log.i("PageManager", localStringBuilder.toString());
    }
    if (this.mCurrentPageInfo != null)
    {
      if (this.mLastPageIsDisappear) {
        return;
      }
      if (this.mInnerRunnable.pageInfo != null) {
        this.mHandler.removeCallbacks(this.mInnerRunnable);
      }
      onPageOut(null, this.mCurrentPageInfo, true);
      this.mLastPageIsDisappear = true;
    }
  }
  
  private void copyCurPageInfo()
  {
    this.mCurrentPageDataEntity = DataEntityOperator.copy(this.mCurrentPageDataEntity);
  }
  
  private PageInfo findNewPageLinkHead(@NonNull PageInfo paramPageInfo, View paramView)
  {
    Object localObject1 = paramPageInfo.getPageView();
    Object localObject3 = paramPageInfo;
    while (localObject1 != null)
    {
      Object localObject2 = localObject3;
      if (localObject3 != null)
      {
        localObject2 = localObject3;
        if (localObject1 == ((PageInfo)localObject3).getPageView()) {
          localObject2 = ((PageInfo)localObject3).getParentPage();
        }
      }
      if (localObject1 == paramView) {
        return localObject2;
      }
      localObject1 = ((View)localObject1).getParent();
      if ((localObject1 instanceof View))
      {
        localObject1 = (View)localObject1;
        localObject3 = localObject2;
      }
      else
      {
        localObject1 = null;
        localObject3 = localObject2;
      }
    }
    return paramPageInfo;
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
    FinalDataTarget.registerListener(this);
  }
  
  private boolean isPotentialPageChange(@NonNull PageInfo paramPageInfo1, @Nullable PageInfo paramPageInfo2, boolean paramBoolean)
  {
    if (paramPageInfo2 == null) {
      return true;
    }
    if (paramPageInfo1.getPage() != paramPageInfo2.getPage()) {
      return true;
    }
    return paramBoolean;
  }
  
  private void onPageIn(PageInfo paramPageInfo1, PageInfo paramPageInfo2, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageIn: pageInfo page=");
      localStringBuilder.append(paramPageInfo1);
      localStringBuilder.append(", decorView=");
      if (paramPageInfo1.getPageView() != null) {
        localObject = paramPageInfo1.getPageView().getRootView();
      } else {
        localObject = null;
      }
      localStringBuilder.append(localObject);
      Log.d("PageManager", localStringBuilder.toString());
    }
    int i = this.mPgStp + 1;
    this.mPgStp = i;
    Object localObject = this.mCurrentPageDataEntity;
    this.mCurrentPageDataEntity = paramPageInfo1.constructDataEntityLink();
    updatePageContext(paramPageInfo1, paramPageInfo2, i, (DataEntity)localObject);
    paramPageInfo2 = paramPageInfo1.findNewInPage(paramPageInfo2);
    DataEntityOperator.removeInnerParam(this.mCurrentPageDataEntity, "last_click_element");
    this.mListenerMgr.startNotify(new PageManager.1(this, paramPageInfo1, paramPageInfo2, paramInt));
  }
  
  private void onPageOut(PageInfo paramPageInfo1, @NonNull PageInfo paramPageInfo2, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageOut: ");
    }
    copyCurPageInfo();
    if (paramPageInfo1 != null) {
      paramPageInfo1 = paramPageInfo1.findNewOutPage(paramPageInfo2);
    } else {
      paramPageInfo1 = paramPageInfo2.findNewOutPage(paramPageInfo2);
    }
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
  
  private void onPageUpdate(PageInfo paramPageInfo, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageManager", "onPageUpdate: ");
    }
    this.mListenerMgr.startNotify(new PageManager.3(this, paramPageInfo, paramInt));
  }
  
  private void updatePageContext(PageInfo paramPageInfo1, PageInfo paramPageInfo2, int paramInt, DataEntity paramDataEntity)
  {
    if (paramPageInfo1 == null) {
      return;
    }
    paramPageInfo1 = paramPageInfo1.findNewInPage(paramPageInfo2).iterator();
    while (paramPageInfo1.hasNext())
    {
      paramPageInfo2 = (PageInfo)paramPageInfo1.next();
      PageContext localPageContext = new PageContext(paramInt, DataBinder.getDataEntity(paramPageInfo2.getPage()), paramDataEntity);
      PageContextManager.getInstance().set(paramPageInfo2.getPageHashCode(), localPageContext);
    }
  }
  
  public void clearPageContext(Object paramObject)
  {
    if (!PageFinder.isPage(paramObject))
    {
      if (VideoReportInner.getInstance().isDebugMode())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("clearPageContext: object is not page, object = ");
        localStringBuilder.append(paramObject);
        Log.d("PageManager", localStringBuilder.toString());
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
  
  public void onHandleFinalData(Object paramObject, @NonNull FinalData paramFinalData, @NonNull Map<String, Object> paramMap)
  {
    if ("clck".equals(paramFinalData.eventKey))
    {
      if (!(paramObject instanceof View)) {
        return;
      }
      paramObject = (View)paramObject;
      if (TextUtils.isEmpty(DataRWProxy.getElementId(paramObject))) {
        return;
      }
      paramObject = VideoReportInner.getInstance().viewTreeParamsForView("clck", paramObject);
      if (BaseUtils.isEmpty(paramObject)) {
        return;
      }
      paramObject.remove("element_params");
      DataEntityOperator.putInnerParam(this.mCurrentPageDataEntity, "last_click_element", new PageLastClickEleInfo(paramObject));
    }
  }
  
  public void onPageAppear(@NonNull PageInfo paramPageInfo, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageAppear: page = ");
      ((StringBuilder)localObject).append(paramPageInfo);
      ((StringBuilder)localObject).append(", pageStep = ");
      ((StringBuilder)localObject).append(this.mPgStp);
      Log.i("PageManager", ((StringBuilder)localObject).toString());
      Log.d("LazyInitSequence", "page Appear");
    }
    if (isPotentialPageChange(paramPageInfo, this.mCurrentPageInfo, this.mLastPageIsDisappear)) {
      updatePageContext(paramPageInfo, this.mCurrentPageInfo, this.mPgStp, this.mCurrentPageDataEntity);
    }
    this.mHandler.removeCallbacks(this.mInnerRunnable);
    Object localObject = this.mInnerRunnable;
    ((PageManager.InnerRunnable)localObject).pageInfo = paramPageInfo;
    ((PageManager.InnerRunnable)localObject).invokeFrom = paramInt;
    this.mHandler.postDelayed((Runnable)localObject, VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime());
  }
  
  public boolean onPageDestroyed(@NonNull View paramView)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onPageDestroyed, mCurrentPageInfo = ");
      ((StringBuilder)localObject).append(this.mCurrentPageInfo);
      ((StringBuilder)localObject).append(", disappearingView = ");
      ((StringBuilder)localObject).append(paramView);
      Log.i("PageManager", ((StringBuilder)localObject).toString());
    }
    Object localObject = this.mCurrentPageInfo;
    if (localObject != null)
    {
      if (this.mLastPageIsDisappear) {
        return false;
      }
      paramView = findNewPageLinkHead((PageInfo)localObject, paramView);
      boolean bool;
      if (paramView != this.mCurrentPageInfo) {
        bool = true;
      } else {
        bool = false;
      }
      if (bool) {
        onPageOut(paramView, this.mCurrentPageInfo, true);
      }
      if (paramView == null)
      {
        this.mLastPageIsDisappear = true;
      }
      else
      {
        this.mCurrentPageInfo = paramView;
        this.mLastPageIsDisappear = false;
      }
      if (VideoReportInner.getInstance().isDebugMode())
      {
        paramView = new StringBuilder();
        paramView.append("onPageDestroyed, hasNewPageOut = ");
        paramView.append(bool);
        Log.i("PageManager", paramView.toString());
      }
      return bool;
    }
    return false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageManager
 * JD-Core Version:    0.7.0.1
 */