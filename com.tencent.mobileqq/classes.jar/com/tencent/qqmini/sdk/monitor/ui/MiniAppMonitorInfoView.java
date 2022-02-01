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
  public static long sDownloadDuration = 0L;
  private static final Action<Long> sGetDrawCallCountAction = new MiniAppMonitorInfoView.2();
  public static long sStartDuration;
  public static long sStartTime = 0L;
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
  
  static
  {
    sStartDuration = 0L;
  }
  
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
    if (this.mMiniAppContext != null) {
      return ((Long)this.mMiniAppContext.performAction(sGetDrawCallCountAction)).longValue();
    }
    return 0L;
  }
  
  protected void initData()
  {
    if (this.mStartDurationTv != null)
    {
      this.mStartDurationTv.setText("启动耗时：" + sStartDuration + "ms");
      this.mStartDurationTv.setVisibility(0);
    }
    if (this.mDownloadInfoTv != null)
    {
      this.mDownloadInfoTv.setText("包下载耗时：" + sDownloadDuration + "ms");
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
    if (this.mHasStartMonitor) {
      if (this.mMainHandler != null) {
        this.mMainHandler.removeCallbacks(this.mRefreshRunnable);
      }
    }
    for (;;)
    {
      if (this.mMainHandler != null) {
        this.mMainHandler.postDelayed(this.mRefreshRunnable, 1000L);
      }
      return;
      if (this.mMiniAppType == 0)
      {
        if (this.mFpsListener == null) {
          this.mFpsListener = new MiniAppMonitorInfoView.FpsListener(this, null);
        }
        FPSCalculator.getInstance().addListener(this.mFpsListener);
      }
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
    String str = "";
    ThreadMsgInfo localThreadMsgInfo = TaskMonitorManager.g().getTaskPerfmSwitchPageInfo();
    if (localThreadMsgInfo != null) {
      str = "" + "切换页面耗时: " + localThreadMsgInfo.realTimeCost + "ms";
    }
    if (this.mPageSwitchTv != null)
    {
      if (localThreadMsgInfo != null)
      {
        this.mPageSwitchTv.setVisibility(0);
        this.mPageSwitchTv.setText(str);
      }
    }
    else if (this.mDrawCallTv != null)
    {
      if (this.mMiniAppType != 1) {
        break label273;
      }
      long l = getDrawCallCount();
      this.mDrawCallTv.setText("drawCall: " + l);
      this.mDrawCallTv.setVisibility(0);
    }
    for (;;)
    {
      str = TaskMonitorManager.g().getCpuUsageRate();
      if (this.mCpuRate != null)
      {
        this.mCpuRate.setText(str);
        this.mCpuRate.setVisibility(0);
      }
      str = TaskMonitorManager.g().getCpuUsageInfo();
      if (this.mCpuUsage != null)
      {
        this.mCpuUsage.setText(str);
        this.mCpuUsage.setVisibility(0);
      }
      str = "内存 使用率: " + TaskMonitorManager.g().getMemeryUsage() + "%";
      if (this.mDbCacheTv != null)
      {
        this.mDbCacheTv.setText(str);
        this.mDbCacheTv.setVisibility(0);
      }
      return;
      this.mPageSwitchTv.setText("切换页面耗时: 无页面切换");
      this.mPageSwitchTv.setVisibility(0);
      break;
      label273:
      this.mDrawCallTv.setVisibility(8);
    }
  }
  
  public void updateFPSText(IMiniAppContext paramIMiniAppContext, double paramDouble)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    if (this.mFpsTv != null)
    {
      paramIMiniAppContext = "帧率: " + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.mFpsTv.setText(paramIMiniAppContext);
      TaskMonitorManager.g().setCurrentFps(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */