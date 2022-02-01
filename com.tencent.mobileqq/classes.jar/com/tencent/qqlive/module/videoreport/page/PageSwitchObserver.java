package com.tencent.qqlive.module.videoreport.page;

import android.app.Activity;
import android.app.Dialog;
import android.os.Looper;
import android.os.MessageQueue;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.collect.DefaultEventListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.detection.DetectionPolicy;
import com.tencent.qqlive.module.videoreport.inject.fragment.FragmentCompat;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter;
import com.tencent.qqlive.module.videoreport.report.AppEventReporter.IAppEventListener;
import com.tencent.qqlive.module.videoreport.trace.SimpleTracer;
import com.tencent.qqlive.module.videoreport.utils.BaseUtils;
import com.tencent.qqlive.module.videoreport.utils.ListenerMgr;
import com.tencent.qqlive.module.videoreport.utils.ReflectUtils;
import com.tencent.qqlive.module.videoreport.utils.ViewCompatUtils;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.WeakHashMap;

public class PageSwitchObserver
  extends DefaultEventListener
  implements AppEventReporter.IAppEventListener
{
  private static final String TAG = "PageSwitchObserver";
  private PageInfo mCurrentPageInfo;
  private PageSwitchObserver.DetectionIdleHandler mDetectionIdleHandler = new PageSwitchObserver.DetectionIdleHandler(this, null);
  private boolean mIsAppForeground = true;
  private final ListenerMgr<PageSwitchObserver.IPageSwitchListener> mListenerMgr = new ListenerMgr();
  private Set<Activity> mResumedActivities = Collections.newSetFromMap(new WeakHashMap());
  private ViewActivityMap mViewActivityMap = new ViewActivityMap();
  
  private void checkActivity(Activity paramActivity)
  {
    View localView = paramActivity.getWindow().getDecorView();
    if (localView == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "onActivityResume: activity = " + paramActivity + ", null getView()");
      }
      return;
    }
    laidOutAppear(paramActivity, localView);
  }
  
  private boolean checkPageDisappear(View paramView)
  {
    if (this.mCurrentPageInfo == null) {}
    while (!needNotifyPageDisappear(this.mCurrentPageInfo.getPageView(), paramView)) {
      return false;
    }
    onPageDisappear();
    return true;
  }
  
  private boolean checkPageDisappear(Window paramWindow)
  {
    return (paramWindow != null) && (checkPageDisappear(paramWindow.getDecorView()));
  }
  
  private void detectActivePage(Activity paramActivity)
  {
    Log.d("LazyInitSequence", "detect page");
    String str = "PageSwitchObserver.detectActivity(" + paramActivity.getClass().getSimpleName() + ")";
    SimpleTracer.begin(str);
    List localList = DialogListUtil.getDialogList(paramActivity);
    int i = BaseUtils.size(localList) - 1;
    while (i >= 0)
    {
      Object localObject = (WeakReference)localList.get(i);
      if (localObject == null) {}
      for (localObject = null; (localObject != null) && (detectActivePage(((Dialog)localObject).getWindow())); localObject = (Dialog)((WeakReference)localObject).get()) {
        return;
      }
      i -= 1;
    }
    detectActivePage(paramActivity.getWindow());
    SimpleTracer.end(str);
  }
  
  private boolean detectActivePage(Window paramWindow)
  {
    return (paramWindow != null) && (detectActivePage(paramWindow.getDecorView()));
  }
  
  private Activity findAttachedActivity(View paramView)
  {
    if (!ViewCompatUtils.isAttachedToWindow(paramView))
    {
      localObject2 = null;
      return localObject2;
    }
    Object localObject1 = paramView.getRootView();
    Object localObject2 = ViewContainerBinder.getInstance().getBoundContainer((View)localObject1);
    if ((localObject2 instanceof Activity)) {
      return (Activity)localObject2;
    }
    if ((localObject2 instanceof Dialog)) {
      return DialogListUtil.getDialogActivity((Dialog)localObject2);
    }
    if ((localObject1 instanceof ViewGroup)) {
      localObject1 = ((ViewGroup)localObject1).getChildAt(0);
    }
    for (localObject1 = this.mViewActivityMap.getActivity((View)localObject1);; localObject1 = null)
    {
      localObject2 = localObject1;
      if (localObject1 != null) {
        break;
      }
      return this.mViewActivityMap.getActivity(paramView);
    }
  }
  
  public static PageSwitchObserver getInstance()
  {
    return PageSwitchObserver.InstanceHolder.access$100();
  }
  
  private void init()
  {
    EventCollector.getInstance().registerEventListener(this);
    AppEventReporter.getInstance().register(this);
  }
  
  private void laidOutAppear(Activity paramActivity, View paramView)
  {
    boolean bool = ViewCompat.isLaidOut(paramView);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "laidOutAppear: activity = " + paramActivity + ", isLaidOut = " + bool);
    }
    if (bool)
    {
      postAppearDetectionTask(paramActivity);
      return;
    }
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new PageSwitchObserver.1(this, paramActivity, paramView));
  }
  
  private boolean needNotifyPageDisappear(View paramView1, View paramView2)
  {
    if (paramView1 != null)
    {
      if (paramView1 == paramView2) {
        return true;
      }
      paramView1 = paramView1.getParent();
      if ((paramView1 instanceof View)) {}
      for (paramView1 = (View)paramView1;; paramView1 = null) {
        break;
      }
    }
    return false;
  }
  
  private void notifyPageAppear(PageInfo paramPageInfo)
  {
    if (paramPageInfo != null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "notifyPageAppear: page = " + paramPageInfo + ", view = " + paramPageInfo.getPageView());
      }
      this.mListenerMgr.startNotify(new PageSwitchObserver.2(this, paramPageInfo));
    }
  }
  
  private void notifyPageDisappear(PageInfo paramPageInfo, boolean paramBoolean)
  {
    if (paramPageInfo != null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "notifyPageDisappear: page = " + paramPageInfo + ", view = " + paramPageInfo.getPageView());
      }
      this.mListenerMgr.startNotify(new PageSwitchObserver.3(this, paramPageInfo, paramBoolean));
    }
  }
  
  private void onActivePageFound(PageInfo paramPageInfo)
  {
    this.mCurrentPageInfo = paramPageInfo;
    notifyPageAppear(paramPageInfo);
  }
  
  private void onPageDisappear()
  {
    onPageDisappear(false);
  }
  
  private void onPageDisappear(boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "notifyPageDisappear: mCurrentPageInfo = " + this.mCurrentPageInfo);
    }
    PageInfo localPageInfo = this.mCurrentPageInfo;
    this.mCurrentPageInfo = null;
    notifyPageDisappear(localPageInfo, paramBoolean);
  }
  
  public boolean detectActivePage(View paramView)
  {
    PageInfo localPageInfo = PageFinder.findExposurePage(paramView);
    if (localPageInfo == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "detectActivePage: no active page found");
      }
      if ((this.mCurrentPageInfo != null) && (VideoReportInner.getInstance().getConfiguration().isIndependentPageOut())) {
        onPageDisappear();
      }
      return false;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "detectActivePage: active page found, view = " + paramView + ", page = " + localPageInfo);
    }
    onActivePageFound(localPageInfo);
    return true;
  }
  
  public void onActivityConfigurationChanged(Activity paramActivity, android.content.res.Configuration paramConfiguration)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onActivityConfigurationChanged: activity = " + paramActivity);
    }
    checkActivity(paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onActivityDestroyed: activity = " + paramActivity);
    }
    checkPageDisappear(paramActivity.getWindow());
  }
  
  public void onActivityPause(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onActivityPause: activity = " + paramActivity);
    }
    if (this.mDetectionIdleHandler.getActivity() == paramActivity)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "onActivityPause: activity matched, remove idle handler");
      }
      Looper.myQueue().removeIdleHandler(this.mDetectionIdleHandler);
    }
    this.mResumedActivities.remove(paramActivity);
    if (VideoReportInner.getInstance().getConfiguration().isIndependentPageOut()) {
      checkPageDisappear(paramActivity.getWindow());
    }
  }
  
  public void onActivityResume(Activity paramActivity)
  {
    this.mResumedActivities.add(paramActivity);
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onActivityResume: activity = " + paramActivity);
    }
    checkActivity(paramActivity);
  }
  
  public void onAppIn()
  {
    this.mIsAppForeground = true;
  }
  
  public void onAppOut(boolean paramBoolean)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.i("PageSwitchObserver", "onAppOut: ");
    }
    this.mIsAppForeground = false;
    onPageDisappear(paramBoolean);
  }
  
  public void onDialogHide(Activity paramActivity, Dialog paramDialog)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onDialogHide: activity = " + paramActivity + "dialog =" + paramDialog);
    }
    if ((ReflectUtils.getField(Dialog.class, "mDecor", paramDialog) == null) && (checkPageDisappear(paramDialog.getWindow()))) {
      postAppearDetectionTask(paramActivity);
    }
  }
  
  public void onDialogShow(Activity paramActivity, Dialog paramDialog)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onDialogShow: activity = " + paramActivity + ", dialog = " + paramDialog);
    }
    postAppearDetectionTask(DialogListUtil.getDialogActivity(paramDialog));
  }
  
  public void onFragmentDestroyView(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onFragmentDestroyView: fragment = " + paramFragmentCompat);
    }
    if (paramFragmentCompat.getView() == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "onFragmentDestroyView: Fragment = " + paramFragmentCompat + ", null getView()");
      }
      return;
    }
    checkPageDisappear(paramFragmentCompat.getView());
  }
  
  public void onFragmentPause(FragmentCompat paramFragmentCompat)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onFragmentPause: fragment=" + paramFragmentCompat);
    }
    postAppearDetectionTask(paramFragmentCompat.getActivity());
  }
  
  public void onFragmentResume(FragmentCompat paramFragmentCompat)
  {
    View localView = paramFragmentCompat.getView();
    if (localView == null)
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "onFragmentResume: fragment = " + paramFragmentCompat + ", null getView()");
      }
      return;
    }
    laidOutAppear(paramFragmentCompat.getActivity(), localView);
  }
  
  public void onPageReport(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return;
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "onPageReport: object=" + paramObject);
      }
      if ((paramObject instanceof Activity))
      {
        postAppearDetectionTask((Activity)paramObject);
        return;
      }
      if ((paramObject instanceof Dialog))
      {
        postAppearDetectionTask(DialogListUtil.getDialogActivity((Dialog)paramObject));
        return;
      }
    } while (!(paramObject instanceof View));
    onPageViewVisible((View)paramObject);
  }
  
  public void onPageViewInvisible(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onPageViewInvisible: view = " + paramView);
    }
    checkPageDisappear(paramView);
  }
  
  public void onPageViewVisible(View paramView)
  {
    if (paramView == null) {
      return;
    }
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "onPageViewVisible: view = " + paramView);
    }
    postAppearDetectionTask(findAttachedActivity(paramView));
  }
  
  public void postAppearDetectionTask(Activity paramActivity)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      Log.d("PageSwitchObserver", "postAppearDetectionTask: activity = " + paramActivity);
    }
    if ((paramActivity == null) || (!DetectionPolicy.isAbleToDetect(paramActivity)))
    {
      if (VideoReportInner.getInstance().isDebugMode()) {
        Log.d("PageSwitchObserver", "postAppearDetectionTask: unable to detect activity");
      }
      return;
    }
    Looper.myQueue().removeIdleHandler(this.mDetectionIdleHandler);
    this.mDetectionIdleHandler.setActivity(paramActivity);
    Looper.myQueue().addIdleHandler(this.mDetectionIdleHandler);
  }
  
  public void register(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    this.mListenerMgr.register(paramIPageSwitchListener);
  }
  
  public void unregister(PageSwitchObserver.IPageSwitchListener paramIPageSwitchListener)
  {
    this.mListenerMgr.unregister(paramIPageSwitchListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.page.PageSwitchObserver
 * JD-Core Version:    0.7.0.1
 */