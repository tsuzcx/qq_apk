package com.tencent.qqlive.module.videoreport.report.element;

import android.app.Dialog;
import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v4.util.ArrayMap;
import android.view.View;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Configuration;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.apm.DTApmManager;
import com.tencent.qqlive.module.videoreport.exposure.ExposureDetector;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.page.DialogListUtil;
import com.tencent.qqlive.module.videoreport.page.PageInfo;
import com.tencent.qqlive.module.videoreport.page.PageManager;
import com.tencent.qqlive.module.videoreport.page.PageManager.IPageListener;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.DelayedIdleHandler;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr.INotifyCallback;
import com.tencent.qqlive.module.videoreport.utils.UIUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ElementExposureReporter
  implements PageManager.IPageListener, AppEventReporter.IAppEventListener
{
  private static final long DETECT_DELAY_FROM_IDLE = 0L;
  private static final long DETECT_DELAY_FROM_POST = 320L;
  private static final String TAG = "ElementExposureReporter";
  private DelayedIdleHandler mDelayedIdleHandler = new DelayedIdleHandler();
  private ElementExposureReporter.DetectionTask mDetectionTask = new ElementExposureReporter.DetectionTask(this);
  private final Map<Long, String> mExposedIds = new ArrayMap();
  private IExposureRecorder mExposureRecorder = IExposureRecorder.Factory.getInstance();
  private PageInfo mFrontPageInfo;
  private ListenerMgr<OnElementTraverseListener> mListenerMgr = new ListenerMgr();
  private PendingQueue mPendingQueue = new PendingQueue();
  private List<ExposureElementInfo> mPreExposedViewInfoList = new ArrayList();
  private final ListenerMgr.INotifyCallback<OnElementTraverseListener> mTraverseEndCallback = new ElementExposureReporter.1(this);
  
  private void clearPreExposedContent()
  {
    this.mPreExposedViewInfoList.clear();
    this.mExposedIds.clear();
  }
  
  private void detect(View paramView, Rect paramRect)
  {
    Log.d("LazyInitSequence", "detect view");
    Object localObject = this.mFrontPageInfo;
    if ((localObject != null) && (paramView == ((PageInfo)localObject).getPageView())) {
      localObject = null;
    } else {
      localObject = paramRect;
    }
    ExposureDetector.detect(paramView, true, (Rect)localObject, new ElementExposureReporter.ElementExposureCallBack(this, paramView, paramRect));
  }
  
  private void dispatchElementReport(PageInfo paramPageInfo, int paramInt)
  {
    this.mDelayedIdleHandler.remove(this.mDetectionTask);
    ElementExposureReporter.DetectionTask.access$002(this.mDetectionTask, paramPageInfo);
    long l;
    if (paramInt == 0) {
      l = 0L;
    } else {
      l = 320L;
    }
    this.mDelayedIdleHandler.post(this.mDetectionTask, l);
  }
  
  private void elementReport(PageInfo paramPageInfo)
  {
    SimpleTracer.begin("ElementExposureReporter.elementReport");
    View localView = paramPageInfo.getPageView();
    if (localView == null) {
      return;
    }
    Rect localRect2 = new Rect();
    Rect localRect1 = localRect2;
    if (!localView.getGlobalVisibleRect(localRect2)) {
      localRect1 = null;
    }
    this.mFrontPageInfo = paramPageInfo;
    boolean bool = run(getAllEntryViews(localView), -VideoReportInner.getInstance().getConfiguration().getPageExposureMinTime(), localRect1);
    this.mListenerMgr.startNotify(this.mTraverseEndCallback);
    long l = SimpleTracer.end("ElementExposureReporter.elementReport");
    DTApmManager.getInstance().onElementDetect(bool, l);
  }
  
  private boolean exposureNotReported(long paramLong)
  {
    return this.mExposureRecorder.isExposed(paramLong) ^ true;
  }
  
  private List<View> getAllEntryViews(View paramView)
  {
    View localView = paramView.getRootView();
    paramView = UIUtils.findAttachedActivity(paramView);
    if (paramView == null) {
      return Collections.singletonList(localView);
    }
    List localList = DialogListUtil.getDialogList(paramView);
    LinkedList localLinkedList = new LinkedList();
    if (localList != null)
    {
      int i = localList.size() - 1;
      while (i >= 0)
      {
        paramView = (WeakReference)localList.get(i);
        if (paramView == null) {
          paramView = null;
        } else {
          paramView = (Dialog)paramView.get();
        }
        if ((paramView != null) && (paramView.getWindow() != null))
        {
          paramView = paramView.getWindow().getDecorView();
          if (paramView == localView) {
            break;
          }
          localLinkedList.add(paramView);
        }
        i -= 1;
      }
    }
    localLinkedList.add(localView);
    return new ArrayList(localLinkedList);
  }
  
  public static ElementExposureReporter getInstance()
  {
    return ElementExposureReporter.InstanceHolder.access$100();
  }
  
  private void init()
  {
    PageManager.getInstance().register(this);
    AppEventReporter.getInstance().register(this);
    this.mPendingQueue.setOnQueueListener(new ElementExposureReporter.2(this));
  }
  
  private boolean makeDirty(Set<Long> paramSet)
  {
    HashSet localHashSet = new HashSet();
    Iterator localIterator = this.mExposureRecorder.getExposedRecords().keySet().iterator();
    while (localIterator.hasNext())
    {
      Long localLong = (Long)localIterator.next();
      if ((localLong != null) && (!paramSet.contains(localLong))) {
        localHashSet.add(localLong);
      }
    }
    this.mExposureRecorder.markUnexposed(localHashSet);
    return localHashSet.size() > 0;
  }
  
  private void markUnexposed(PageInfo paramPageInfo)
  {
    if (paramPageInfo != null)
    {
      if (this.mExposureRecorder.getExposedRecords().size() == 0) {
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = this.mExposureRecorder.getExposedRecords().entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        Object localObject2 = null;
        Object localObject1 = localObject2;
        if (localEntry != null)
        {
          localObject1 = localObject2;
          if (localEntry.getValue() != null) {
            localObject1 = ((IExposureRecorder.ExposureInfoWrapper)localEntry.getValue()).attachedPage.get();
          }
        }
        if ((localObject1 != null) && (localObject1.equals(paramPageInfo.getPage()))) {
          localArrayList.add(localEntry.getKey());
        }
      }
      this.mExposureRecorder.markUnexposed(localArrayList);
    }
  }
  
  private void printDebug()
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      Object localObject1 = new HashMap(this.mExposedIds);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("run: new exposed view: count = ");
      ((StringBuilder)localObject2).append(this.mPreExposedViewInfoList.size());
      Log.d("ElementExposureReporter", ((StringBuilder)localObject2).toString());
      localObject2 = this.mPreExposedViewInfoList.iterator();
      Object localObject3;
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (ExposureElementInfo)((Iterator)localObject2).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("    identifier: ");
        localStringBuilder.append(((ExposureElementInfo)localObject3).getIdentifier());
        localStringBuilder.append(", uniqueId = ");
        localStringBuilder.append(((ExposureElementInfo)localObject3).getUniqueId());
        Log.d("ElementExposureReporter", localStringBuilder.toString());
        ((HashMap)localObject1).remove(Long.valueOf(((ExposureElementInfo)localObject3).getUniqueId()));
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("run: duplicate exposed view: count = ");
      ((StringBuilder)localObject2).append(((HashMap)localObject1).size());
      Log.d("ElementExposureReporter", ((StringBuilder)localObject2).toString());
      localObject1 = ((HashMap)localObject1).entrySet().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("    identifier: ");
        ((StringBuilder)localObject3).append((String)((Map.Entry)localObject2).getValue());
        ((StringBuilder)localObject3).append(", uniqueId: ");
        ((StringBuilder)localObject3).append(((Map.Entry)localObject2).getKey());
        Log.d("ElementExposureReporter", ((StringBuilder)localObject3).toString());
      }
      Log.d("ElementExposureReporter", "run: ---------------");
    }
  }
  
  private boolean run(@NonNull List<View> paramList, long paramLong, Rect paramRect)
  {
    clearPreExposedContent();
    boolean bool1 = false;
    int i = 0;
    while (i < paramList.size())
    {
      View localView = (View)paramList.get(i);
      Rect localRect;
      if (i == paramList.size() - 1) {
        localRect = paramRect;
      } else {
        localRect = null;
      }
      detect(localView, localRect);
      i += 1;
    }
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramList = new StringBuilder();
      paramList.append("run: delayDelta = ");
      paramList.append(paramLong);
      paramList.append(", ");
      paramRect = this.mPreExposedViewInfoList;
      if (paramRect == null) {
        i = 0;
      } else {
        i = paramRect.size();
      }
      paramList.append(i);
      paramList.append(" exposed view found");
      Log.d("ElementExposureReporter", paramList.toString());
    }
    printDebug();
    boolean bool2 = makeDirty(this.mExposedIds.keySet());
    this.mPendingQueue.enqueue(this.mPreExposedViewInfoList, paramLong);
    if ((bool2) || (this.mPreExposedViewInfoList.size() > 0)) {
      bool1 = true;
    }
    clearPreExposedContent();
    return bool1;
  }
  
  public void onAppIn() {}
  
  public void onAppOut(boolean paramBoolean)
  {
    this.mExposureRecorder.clearExposure();
  }
  
  public void onPageIn(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      paramSet = new StringBuilder();
      paramSet.append("onPageIn: pageInfo = ");
      paramSet.append(paramPageInfo);
      Log.d("ElementExposureReporter", paramSet.toString());
    }
    dispatchElementReport(paramPageInfo, paramInt);
  }
  
  public void onPageOut(@NonNull PageInfo paramPageInfo, @NonNull Set<PageInfo> paramSet, boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageOut: pageInfo = ");
      localStringBuilder.append(paramPageInfo);
      Log.d("ElementExposureReporter", localStringBuilder.toString());
    }
    paramPageInfo = paramSet.iterator();
    while (paramPageInfo.hasNext()) {
      markUnexposed((PageInfo)paramPageInfo.next());
    }
  }
  
  public void onPageUpdate(PageInfo paramPageInfo, int paramInt)
  {
    if (VideoReportInner.getInstance().isDebugMode())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPageUpdate: pageInfo = ");
      localStringBuilder.append(paramPageInfo);
      Log.d("ElementExposureReporter", localStringBuilder.toString());
    }
    dispatchElementReport(paramPageInfo, paramInt);
  }
  
  public void registerTraverseListener(OnElementTraverseListener paramOnElementTraverseListener)
  {
    this.mListenerMgr.register(paramOnElementTraverseListener);
  }
  
  public void traverseExposure()
  {
    PageInfo localPageInfo = PageManager.getInstance().getCurrentPageInfo();
    if (localPageInfo != null) {
      elementReport(localPageInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.report.element.ElementExposureReporter
 * JD-Core Version:    0.7.0.1
 */