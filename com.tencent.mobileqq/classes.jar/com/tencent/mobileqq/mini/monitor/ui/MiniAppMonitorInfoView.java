package com.tencent.mobileqq.mini.monitor.ui;

import ajjy;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import azvy;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.monitor.service.ThreadMsgInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.manager.GameLoadManager;
import com.tencent.mobileqq.triton.sdk.ITTEngine;
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
    this.mInflateView = LayoutInflater.from(paramContext).inflate(2131496374, this);
    this.mPageSwitchTv = ((TextView)this.mInflateView.findViewById(2131304722));
    this.mStartDurationTv = ((TextView)this.mInflateView.findViewById(2131304721));
    this.mDownloadInfoTv = ((TextView)this.mInflateView.findViewById(2131304710));
    this.mRenderFirstTv = ((TextView)this.mInflateView.findViewById(2131304719));
    this.mRenderAgainTv = ((TextView)this.mInflateView.findViewById(2131304718));
    this.mFpsTv = ((TextView)this.mInflateView.findViewById(2131304712));
    this.mDrawCallTv = ((TextView)this.mInflateView.findViewById(2131304711));
    this.mCpuRate = ((TextView)this.mInflateView.findViewById(2131304707));
    this.mCpuUsage = ((TextView)this.mInflateView.findViewById(2131304708));
    this.mDbCacheTv = ((TextView)this.mInflateView.findViewById(2131304709));
    setMiniAppType(paramInt);
    initData();
  }
  
  protected void initData()
  {
    if (this.mStartDurationTv != null)
    {
      this.mStartDurationTv.setText(ajjy.a(2131641033) + sStartDuration + "ms");
      this.mStartDurationTv.setVisibility(0);
    }
    if (this.mDownloadInfoTv != null)
    {
      long l = ApkgManager.downloadDuration;
      if (this.mMiniAppType == 1) {
        l = GpkgManager.downloadDuration;
      }
      this.mDownloadInfoTv.setText(ajjy.a(2131641026) + l + "ms");
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
        azvy.a().a(this.mFpsListener);
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
        azvy.a().b(this.mFpsListener);
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
      str = "" + ajjy.a(2131641028) + localThreadMsgInfo.realTimeCost + "ms";
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
        break label283;
      }
      long l = GameLoadManager.g().getGameEngine().getCurrentDrawCount();
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
      str = ajjy.a(2131641037) + TaskMonitorManager.g().getMemeryUsage() + "%";
      if (this.mDbCacheTv != null)
      {
        this.mDbCacheTv.setText(str);
        this.mDbCacheTv.setVisibility(0);
      }
      return;
      this.mPageSwitchTv.setText(ajjy.a(2131641034));
      this.mPageSwitchTv.setVisibility(0);
      break;
      label283:
      this.mDrawCallTv.setVisibility(8);
    }
  }
  
  public void updateFPSText(double paramDouble)
  {
    if (this.mFpsTv != null)
    {
      String str = ajjy.a(2131641035) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.mFpsTv.setText(str);
      TaskMonitorManager.g().setCurrentFps(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */