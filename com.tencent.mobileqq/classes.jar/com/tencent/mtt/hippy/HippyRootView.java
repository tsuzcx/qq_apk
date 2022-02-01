package com.tencent.mtt.hippy;

import android.content.Context;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.tencent.mtt.hippy.a.e;
import com.tencent.mtt.hippy.adapter.monitor.HippyEngineMonitorAdapter;
import com.tencent.mtt.hippy.common.HippyMap;
import com.tencent.mtt.hippy.common.HippyTag;
import com.tencent.mtt.hippy.modules.HippyModuleManager;
import com.tencent.mtt.hippy.modules.javascriptmodules.EventDispatcher;
import com.tencent.mtt.hippy.utils.PixelUtil;
import com.tencent.mtt.hippy.utils.TimeMonitor;
import java.util.concurrent.atomic.AtomicInteger;

public class HippyRootView
  extends FrameLayout
{
  private static final AtomicInteger ID_COUNTER = new AtomicInteger(0);
  private static final int ROOT_VIEW_TAG_INCREMENT = 10;
  private HippyEngineContext mEngineContext;
  private HippyRootView.GlobalLayoutListener mGlobalLayoutListener;
  private final int mInstanceId;
  protected boolean mLoadCompleted = false;
  private final HippyEngine.ModuleLoadParams mLoadParams;
  private HippyRootView.OnLoadCompleteListener mOnLoadCompleteListener;
  private HippyRootView.OnResumeAndPauseListener mOnResumeAndPauseListener;
  HippyRootView.OnSizeChangedListener mSizeChangListener;
  private TimeMonitor mTimeMonitor;
  
  public HippyRootView(HippyEngine.ModuleLoadParams paramModuleLoadParams)
  {
    super(localHippyInstanceContext);
    this.mLoadParams = paramModuleLoadParams;
    this.mInstanceId = ID_COUNTER.addAndGet(10);
    setId(this.mInstanceId);
    setTag(HippyTag.createTagMap("RootNode", null));
    getViewTreeObserver().addOnGlobalLayoutListener(getGlobalLayoutListener());
    setOnSystemUiVisibilityChangeListener(getGlobalLayoutListener());
  }
  
  private HippyRootView.GlobalLayoutListener getGlobalLayoutListener()
  {
    if (this.mGlobalLayoutListener == null) {
      this.mGlobalLayoutListener = new HippyRootView.GlobalLayoutListener(this, null);
    }
    return this.mGlobalLayoutListener;
  }
  
  public void attachEngineManager(HippyEngine paramHippyEngine)
  {
    ((HippyInstanceContext)getContext()).attachEngineManager(paramHippyEngine);
  }
  
  public void attachToEngine(HippyEngineContext paramHippyEngineContext)
  {
    this.mEngineContext = paramHippyEngineContext;
    ((HippyInstanceContext)getContext()).setEngineContext(paramHippyEngineContext);
    HippyRootView.GlobalLayoutListener.access$100(getGlobalLayoutListener(), false, false);
  }
  
  void destroy()
  {
    if ((getContext() instanceof HippyInstanceContext)) {
      ((HippyInstanceContext)getContext()).notifyInstanceDestroy();
    }
  }
  
  public HippyEngineContext getEngineContext()
  {
    return this.mEngineContext;
  }
  
  public Context getHost()
  {
    return this.mLoadParams.context;
  }
  
  public int getId()
  {
    return this.mInstanceId;
  }
  
  public HippyMap getLaunchParams()
  {
    return this.mLoadParams.jsParams;
  }
  
  public String getName()
  {
    return this.mLoadParams.componentName;
  }
  
  public TimeMonitor getTimeMonitor()
  {
    return this.mTimeMonitor;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    try
    {
      getViewTreeObserver().removeGlobalOnLayoutListener(getGlobalLayoutListener());
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    getViewTreeObserver().addOnGlobalLayoutListener(getGlobalLayoutListener());
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    try
    {
      getViewTreeObserver().removeGlobalOnLayoutListener(getGlobalLayoutListener());
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(View.MeasureSpec.getSize(paramInt1), View.MeasureSpec.getSize(paramInt2));
  }
  
  public void onPause()
  {
    HippyRootView.OnResumeAndPauseListener localOnResumeAndPauseListener = this.mOnResumeAndPauseListener;
    if (localOnResumeAndPauseListener != null) {
      localOnResumeAndPauseListener.onInstancePause(getId());
    }
  }
  
  public void onResume()
  {
    HippyRootView.OnResumeAndPauseListener localOnResumeAndPauseListener = this.mOnResumeAndPauseListener;
    if (localOnResumeAndPauseListener != null) {
      localOnResumeAndPauseListener.onInstanceResume(getId());
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if ((paramInt1 != paramInt3) || (paramInt2 != paramInt4))
    {
      HippyRootView.GlobalLayoutListener.access$000(getGlobalLayoutListener(), paramInt1, paramInt2, false, false);
      Object localObject = this.mEngineContext;
      if (localObject != null)
      {
        localObject = ((HippyEngineContext)localObject).getModuleManager();
        if (localObject != null)
        {
          HippyMap localHippyMap = new HippyMap();
          localHippyMap.pushDouble("width", PixelUtil.px2dp(paramInt1));
          localHippyMap.pushDouble("height", PixelUtil.px2dp(paramInt2));
          localHippyMap.pushDouble("oldWidth", PixelUtil.px2dp(paramInt3));
          localHippyMap.pushDouble("oldHeight", PixelUtil.px2dp(paramInt4));
          ((EventDispatcher)((HippyModuleManager)localObject).getJavaScriptModule(EventDispatcher.class)).receiveNativeEvent("onSizeChanged", localHippyMap);
        }
      }
      localObject = this.mSizeChangListener;
      if (localObject != null) {
        ((HippyRootView.OnSizeChangedListener)localObject).onSizeChanged(this, paramInt1, paramInt2, paramInt3, paramInt4);
      }
    }
  }
  
  public void onViewAdded(View paramView)
  {
    if ((!this.mLoadCompleted) && (!(paramView instanceof e)))
    {
      this.mLoadCompleted = true;
      paramView = this.mTimeMonitor;
      if (paramView != null)
      {
        paramView.end();
        paramView = this.mOnLoadCompleteListener;
        if (paramView != null) {
          paramView.onLoadComplete(this.mTimeMonitor.getTotalTime(), this.mTimeMonitor.getEvents());
        }
        this.mEngineContext.getGlobalConfigs().getEngineMonitorAdapter().reportModuleLoadComplete(this, this.mTimeMonitor.getTotalTime(), this.mTimeMonitor.getEvents());
      }
    }
  }
  
  public void setOnLoadCompleteListener(HippyRootView.OnLoadCompleteListener paramOnLoadCompleteListener)
  {
    this.mOnLoadCompleteListener = paramOnLoadCompleteListener;
  }
  
  public void setOnResumeAndPauseListener(HippyRootView.OnResumeAndPauseListener paramOnResumeAndPauseListener)
  {
    this.mOnResumeAndPauseListener = paramOnResumeAndPauseListener;
  }
  
  public void setOnSizeChangedListener(HippyRootView.OnSizeChangedListener paramOnSizeChangedListener)
  {
    this.mSizeChangListener = paramOnSizeChangedListener;
  }
  
  public void setTimeMonitor(TimeMonitor paramTimeMonitor)
  {
    this.mTimeMonitor = paramTimeMonitor;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.HippyRootView
 * JD-Core Version:    0.7.0.1
 */