package com.tencent.mobileqq.mini.monitor.ui;

import alud;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import bdat;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.mini.apkg.ApkgManager;
import com.tencent.mobileqq.mini.monitor.service.TaskMonitorManager;
import com.tencent.mobileqq.mini.monitor.service.ThreadMsgInfo;
import com.tencent.mobileqq.minigame.gpkg.GpkgManager;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoader;
import com.tencent.mobileqq.minigame.manager.GameRuntimeLoaderManager;
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
    this.mInflateView = LayoutInflater.from(paramContext).inflate(2131562182, this);
    this.mPageSwitchTv = ((TextView)this.mInflateView.findViewById(2131370702));
    this.mStartDurationTv = ((TextView)this.mInflateView.findViewById(2131370701));
    this.mDownloadInfoTv = ((TextView)this.mInflateView.findViewById(2131370690));
    this.mRenderFirstTv = ((TextView)this.mInflateView.findViewById(2131370699));
    this.mRenderAgainTv = ((TextView)this.mInflateView.findViewById(2131370698));
    this.mFpsTv = ((TextView)this.mInflateView.findViewById(2131370692));
    this.mDrawCallTv = ((TextView)this.mInflateView.findViewById(2131370691));
    this.mCpuRate = ((TextView)this.mInflateView.findViewById(2131370687));
    this.mCpuUsage = ((TextView)this.mInflateView.findViewById(2131370688));
    this.mDbCacheTv = ((TextView)this.mInflateView.findViewById(2131370689));
    setMiniAppType(paramInt);
    initData();
  }
  
  protected void initData()
  {
    if (this.mStartDurationTv != null)
    {
      this.mStartDurationTv.setText(alud.a(2131707213) + sStartDuration + "ms");
      this.mStartDurationTv.setVisibility(0);
    }
    if (this.mDownloadInfoTv != null)
    {
      long l = ApkgManager.downloadDuration;
      if (this.mMiniAppType == 1) {
        l = GpkgManager.downloadDuration;
      }
      this.mDownloadInfoTv.setText(alud.a(2131707206) + l + "ms");
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
        bdat.a().a(this.mFpsListener);
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
        bdat.a().b(this.mFpsListener);
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
      localObject = "" + alud.a(2131707208) + localThreadMsgInfo.realTimeCost + "ms";
    }
    label116:
    long l;
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
        break label316;
      }
      localObject = GameRuntimeLoaderManager.g().getBindRuntimeLoader(getContext());
      if (localObject == null) {
        break label304;
      }
      localObject = ((GameRuntimeLoader)localObject).getGameEngine();
      if (localObject == null) {
        break label309;
      }
      l = ((ITTEngine)localObject).getCurrentDrawCount();
      label127:
      this.mDrawCallTv.setText("drawCall: " + l);
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
      localObject = alud.a(2131707217) + TaskMonitorManager.g().getMemeryUsage() + "%";
      if (this.mDbCacheTv != null)
      {
        this.mDbCacheTv.setText((CharSequence)localObject);
        this.mDbCacheTv.setVisibility(0);
      }
      return;
      this.mPageSwitchTv.setText(alud.a(2131707214));
      this.mPageSwitchTv.setVisibility(0);
      break;
      label304:
      localObject = null;
      break label116;
      label309:
      l = -1L;
      break label127;
      label316:
      this.mDrawCallTv.setVisibility(8);
    }
  }
  
  public void updateFPSText(double paramDouble)
  {
    if (this.mFpsTv != null)
    {
      String str = alud.a(2131707215) + String.format("%.0f", new Object[] { Double.valueOf(paramDouble) }) + "fps";
      this.mFpsTv.setText(str);
      TaskMonitorManager.g().setCurrentFps(paramDouble);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.monitor.ui.MiniAppMonitorInfoView
 * JD-Core Version:    0.7.0.1
 */