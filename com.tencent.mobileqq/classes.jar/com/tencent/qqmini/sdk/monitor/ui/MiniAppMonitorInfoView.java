package com.tencent.qqmini.sdk.monitor.ui;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.qqmini.sdk.R.id;
import com.tencent.qqmini.sdk.R.layout;
import com.tencent.qqmini.sdk.core.manager.ThreadManager;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.Action;
import com.tencent.qqmini.sdk.monitor.common.FPSCalculator;
import com.tencent.qqmini.sdk.monitor.service.TaskMonitorManager;
import com.tencent.qqmini.sdk.monitor.service.ThreadMsgInfo;

public class MiniAppMonitorInfoView
  extends FrameLayout
{
  public static final String ACTION_SHOW_MONITOR_VIEW = "action.qq.miniapp.show.monitorview";
  private static final int REFRESH_MONITOR_DURATION = 1000;
  public static long sDownloadDuration;
  private static final Action<Long> sGetDrawCallCountAction = new MiniAppMonitorInfoView.2();
  public static long sStartDuration;
  public static long sStartTime;
  private TextView mCpuRate;
  private TextView mCpuUsage;
  private TextView mDbCacheTv;
  private TextView mDownloadInfoTv;
  private TextView mDrawCallTv;
  private MiniAppMonitorInfoView.FpsListener mFpsListener;
  private TextView mFpsTv;
  private volatile boolean mHasStartMonitor = false;
  private View mInflateView;
  private Handler mMainHandler = ThreadManager.getUIHandler();
  private IMiniAppContext mMiniAppContext;
  private int mMiniAppType = 0;
  private TextView mPageSwitchTv;
  private Runnable mRefreshRunnable = new MiniAppMonitorInfoView.1(this);
  private TextView mRenderAgainTv;
  private TextView mRenderFirstTv;
  private TextView mStartDurationTv;
  
  public MiniAppMonitorInfoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MiniAppMonitorInfoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet);
    this.mInflateView = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_popup_monitor_layout, this);
    this.mPageSwitchTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_switch_page));
    this.mStartDurationTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_start_time));
    this.mDownloadInfoTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_download_package));
    this.mRenderFirstTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_render_first));
    this.mRenderAgainTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_render_again));
    this.mFpsTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_fps));
    this.mDrawCallTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_drawcall));
    this.mCpuRate = ((TextView)this.mInflateView.findViewById(R.id.monitor_cpu_rate));
    this.mCpuUsage = ((TextView)this.mInflateView.findViewById(R.id.monitor_cpu_usage));
    this.mDbCacheTv = ((TextView)this.mInflateView.findViewById(R.id.monitor_db_cache));
    setMiniAppType(paramInt);
    initData();
  }
  
  private long getDrawCallCount()
  {
    IMiniAppContext localIMiniAppContext = this.mMiniAppContext;
    if (localIMiniAppContext != null) {
      return ((Long)localIMiniAppContext.performAction(sGetDrawCallCountAction)).longValue();
    }
    return 0L;
  }
  
  protected void initData()
  {
    TextView localTextView = this.mStartDurationTv;
    StringBuilder localStringBuilder;
    if (localTextView != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("启动耗时：");
      localStringBuilder.append(sStartDuration);
      localStringBuilder.append("ms");
      localTextView.setText(localStringBuilder.toString());
      this.mStartDurationTv.setVisibility(0);
    }
    localTextView = this.mDownloadInfoTv;
    if (localTextView != null)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("包下载耗时：");
      localStringBuilder.append(sDownloadDuration);
      localStringBuilder.append("ms");
      localTextView.setText(localStringBuilder.toString());
      this.mDownloadInfoTv.setVisibility(0);
    }
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    bringToFront();
  }
  
  public void setMiniAppType(int paramInt)
  {
    this.mMiniAppType = paramInt;
  }
  
  public void startRefreshMonitorUi()
  {
    if (this.mHasStartMonitor)
    {
      localHandler = this.mMainHandler;
      if (localHandler != null) {
        localHandler.removeCallbacks(this.mRefreshRunnable);
      }
    }
    else if (this.mMiniAppType == 0)
    {
      if (this.mFpsListener == null) {
        this.mFpsListener = new MiniAppMonitorInfoView.FpsListener(this, null);
      }
      FPSCalculator.getInstance().addListener(this.mFpsListener);
    }
    Handler localHandler = this.mMainHandler;
    if (localHandler != null) {
      localHandler.postDelayed(this.mRefreshRunnable, 1000L);
    }
  }
  
  public void stopRefreshMonitorUi()
  {
    if (this.mHasStartMonitor) {}
    try
    {
      if (this.mMainHandler != null) {
        this.mMainHandler.removeCallbacks(this.mRefreshRunnable);
      }
      if (this.mFpsListener != null) {
        FPSCalculator.getInstance().removeListener(this.mFpsListener);
      }
      this.mHasStartMonitor = false;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void updateData()
  {
    Object localObject2 = TaskMonitorManager.g().getTaskPerfmSwitchPageInfo();
    Object localObject1 = "";
    if (localObject2 != null)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("");
      ((StringBuilder)localObject1).append("切换页面耗时: ");
      ((StringBuilder)localObject1).append(((ThreadMsgInfo)localObject2).realTimeCost);
      ((StringBuilder)localObject1).append("ms");
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    TextView localTextView = this.mPageSwitchTv;
    if (localTextView != null) {
      if (localObject2 != null)
      {
        localTextView.setVisibility(0);
        this.mPageSwitchTv.setText((CharSequence)localObject1);
      }
      else
      {
        localTextView.setText("切换页面耗时: 无页面切换");
        this.mPageSwitchTv.setVisibility(0);
      }
    }
    localObject1 = this.mDrawCallTv;
    if (localObject1 != null) {
      if (this.mMiniAppType == 1)
      {
        long l = getDrawCallCount();
        localObject1 = this.mDrawCallTv;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("drawCall: ");
        ((StringBuilder)localObject2).append(l);
        ((TextView)localObject1).setText(((StringBuilder)localObject2).toString());
        this.mDrawCallTv.setVisibility(0);
      }
      else
      {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    localObject1 = TaskMonitorManager.g().getCpuUsageRate();
    localObject2 = this.mCpuRate;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.mCpuRate.setVisibility(0);
    }
    localObject1 = TaskMonitorManager.g().getCpuUsageInfo();
    localObject2 = this.mCpuUsage;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.mCpuUsage.setVisibility(0);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("内存 使用率: ");
    ((StringBuilder)localObject1).append(TaskMonitorManager.g().getMemeryUsage());
    ((StringBuilder)localObject1).append("%");
    localObject1 = ((StringBuilder)localObject1).toString();
    localObject2 = this.mDbCacheTv;
    if (localObject2 != null)
    {
      ((TextView)localObject2).setText((CharSequence)localObject1);
      this.mDbCacheTv.setVisibility(0);
    }
  }
  
  public void updateFPSText(IMiniAppContext paramIMiniAppContext, double paramDouble)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    if (this.mFpsTv != null)
    {
      paramIMiniAppContext = new StringBuilder();
      paramIMiniAppContext.append("帧率: ");
      paramIMiniAppContext.append(String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }));
      paramIMiniAppContext.append("fps");
      paramIMiniAppContext = paramIMiniAppContext.toString();
      this.mFpsTv.setText(paramIMiniAppContext);
      TaskMonitorManager.g().setCurrentFps(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */