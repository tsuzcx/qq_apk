package com.tencent.mobileqq.mini.monitor.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import anzj;
import bhgt;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.monitor.service.ThreadMsgInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.EngineState;
import com.tencent.mobileqq.triton.statistic.StatisticsManager;
import mqq.os.MqqHandler;

public class MiniAppMonitorInfoView
  extends FrameLayout
{
  public static final String ACTION_SHOW_MONITOR_VIEW = "action.qq.miniapp.show.monitorview";
  private static final int REFRESH_MONITOR_DURATION = 1000;
  public static long sStartDuration;
  public static long sStartTime;
  private TextView mCpuRate;
  private TextView mCpuUsage;
  private TextView mDbCacheTv;
  private TextView mDownloadInfoTv;
  private TextView mDrawCallTv;
  private MiniAppMonitorInfoView.FpsListener mFpsListener;
  private TextView mFpsTv;
  private volatile boolean mHasStartMonitor;
  private View mInflateView;
  private MqqHandler mMainHandler = ThreadManager.getUIHandler();
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
    this.mInflateView = LayoutInflater.from(paramContext).inflate(2131562458, this);
    this.mPageSwitchTv = ((TextView)this.mInflateView.findViewById(2131371365));
    this.mStartDurationTv = ((TextView)this.mInflateView.findViewById(2131371364));
    this.mDownloadInfoTv = ((TextView)this.mInflateView.findViewById(2131371353));
    this.mRenderFirstTv = ((TextView)this.mInflateView.findViewById(2131371362));
    this.mRenderAgainTv = ((TextView)this.mInflateView.findViewById(2131371361));
    this.mFpsTv = ((TextView)this.mInflateView.findViewById(2131371355));
    this.mDrawCallTv = ((TextView)this.mInflateView.findViewById(2131371354));
    this.mCpuRate = ((TextView)this.mInflateView.findViewById(2131371350));
    this.mCpuUsage = ((TextView)this.mInflateView.findViewById(2131371351));
    this.mDbCacheTv = ((TextView)this.mInflateView.findViewById(2131371352));
    setMiniAppType(paramInt);
    initData();
  }
  
  protected void initData()
  {
    if (this.mStartDurationTv != null)
    {
      this.mStartDurationTv.setText(anzj.a(2131705711) + sStartDuration + "ms");
      this.mStartDurationTv.setVisibility(0);
    }
    if (this.mDownloadInfoTv != null)
    {
      long l = ApkgManager.downloadDuration;
      if (this.mMiniAppType == 1) {
        l = GpkgManager.downloadDuration;
      }
      this.mDownloadInfoTv.setText(anzj.a(2131705704) + l + "ms");
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
        bhgt.a().a(this.mFpsListener);
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
        bhgt.a().b(this.mFpsListener);
      }
      this.mHasStartMonitor = false;
      return;
    }
    catch (Throwable localThrowable) {}
  }
  
  protected void updateData()
  {
    Object localObject = "";
    ThreadMsgInfo localThreadMsgInfo = TaskMonitorManager.g().getTaskPerfmSwitchPageInfo();
    if (localThreadMsgInfo != null) {
      localObject = "" + anzj.a(2131705706) + localThreadMsgInfo.realTimeCost + "ms";
    }
    if (this.mPageSwitchTv != null)
    {
      if (localThreadMsgInfo != null)
      {
        this.mPageSwitchTv.setVisibility(0);
        this.mPageSwitchTv.setText((CharSequence)localObject);
      }
    }
    else if (this.mDrawCallTv != null)
    {
      if (this.mMiniAppType != 1) {
        break label350;
      }
      localObject = GameRuntimeLoaderManager.g().getBindRuntimeLoader(getContext());
      if (localObject == null) {
        break label344;
      }
      localObject = ((GameRuntimeLoader)localObject).getGameEngine();
      label123:
      long l2 = 0L;
      long l1 = l2;
      if (localObject != null)
      {
        l1 = l2;
        if (((TritonEngine)localObject).getState() != EngineState.DESTROYED) {
          l1 = ((TritonEngine)localObject).getStatisticsManager().getCurrentDrawCalls();
        }
      }
      this.mDrawCallTv.setText("drawCall: " + l1);
      this.mDrawCallTv.setVisibility(0);
    }
    for (;;)
    {
      localObject = TaskMonitorManager.g().getCpuUsageRate();
      if (this.mCpuRate != null)
      {
        this.mCpuRate.setText((CharSequence)localObject);
        this.mCpuRate.setVisibility(0);
      }
      localObject = TaskMonitorManager.g().getCpuUsageInfo();
      if (this.mCpuUsage != null)
      {
        this.mCpuUsage.setText((CharSequence)localObject);
        this.mCpuUsage.setVisibility(0);
      }
      localObject = anzj.a(2131705715) + TaskMonitorManager.g().getMemeryUsage() + "%";
      if (this.mDbCacheTv != null)
      {
        this.mDbCacheTv.setText((CharSequence)localObject);
        this.mDbCacheTv.setVisibility(0);
      }
      return;
      this.mPageSwitchTv.setText(anzj.a(2131705712));
      this.mPageSwitchTv.setVisibility(0);
      break;
      label344:
      localObject = null;
      break label123;
      label350:
      this.mDrawCallTv.setVisibility(8);
    }
  }
  
  public void updateFPSText(double paramDouble)
  {
    if (this.mFpsTv != null)
    {
      String str = anzj.a(2131705713) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.mFpsTv.setText(str);
      TaskMonitorManager.g().setCurrentFps(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */