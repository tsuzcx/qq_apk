package com.tencent.mobileqq.qqexpand.plugin.entrance;

import android.content.BroadcastReceiver;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.guard.GuardManager;
import com.tencent.mobileqq.app.guard.guardinterface.IGuardInterface;
import com.tencent.mobileqq.fragment.QPublicBaseFragment;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.qqexpand.utils.LoadingLifecycle;
import com.tencent.mobileqq.qqexpand.utils.OnApplicationBackgroundListener;
import com.tencent.mobileqq.qqexpand.utils.ProcessUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.module.IQRoutePlugin;
import com.tencent.mobileqq.qroute.module.QRoutePluginInfo;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.tools.DeviceInfoUtils;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLoadingFragment;", "Lcom/tencent/mobileqq/fragment/QPublicBaseFragment;", "()V", "mBoxingView", "Lcom/tencent/image/URLImageView;", "mCloseButton", "Landroid/view/View;", "mCountDownDuration", "", "mCountDownLoading", "Landroid/widget/TextView;", "mCurrentLoadingStatus", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/LoadingStatus;", "mDismissFrom", "", "mDownloadDuration", "", "mDownloadStartTime", "mErrorCode", "mHasDownload", "", "mIsDownloading", "mIsHotStart", "mIsPluginProcessExists", "mLifecycleCallbacks", "Lcom/tencent/mobileqq/qqexpand/utils/LoadingLifecycle;", "mLoadingEndTime", "mLoadingError", "Landroid/widget/ImageView;", "mLoadingStartTime", "mLoadingSubWording", "mLoadingWording", "mPerProgress", "mPerProgressWhenDownload", "mProgressBar", "Landroid/widget/ProgressBar;", "mReceiver", "Landroid/content/BroadcastReceiver;", "mRetryLoading", "mRootView", "mServiceLoadingState", "Lcom/tencent/mobileqq/qqexpand/plugin/entrance/ExpandPluginLauncher$PluginServiceState;", "mStartPluginState", "finish", "", "from", "getLoadCountDownWhenDownload", "getLoadPerProgress", "getPluginState", "initStatusBar", "loadImageView", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "registerLifecycleAndReceiver", "reportLoadingEvent", "resetReportStartTime", "resumeRootViewVisibility", "setDownloadEnd", "setDownloadStart", "setLoadEndReportData", "isHotStart", "serviceLoadingState", "setLoadEndTime", "endTime", "setRetryClickListener", "listener", "Landroid/view/View$OnClickListener;", "unRegisterLifecycleAndReceiver", "updateDismissFrom", "updateDownloadProgress", "progress", "updateLoadCountDown", "downloadSecond", "loadSecond", "updateLoadProgress", "updateLoadingStatus", "status", "loadError", "errorReason", "updateProgress", "process", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandPluginLoadingFragment
  extends QPublicBaseFragment
{
  public static final ExpandPluginLoadingFragment.Companion a = new ExpandPluginLoadingFragment.Companion(null);
  private final double A;
  private final BroadcastReceiver B;
  private HashMap C;
  private View b;
  private URLImageView c;
  private ImageView d;
  private ProgressBar e;
  private TextView f;
  private TextView g;
  private View h;
  private TextView i;
  private TextView j;
  private long k;
  private long l;
  private int m;
  private long n;
  private boolean o;
  private boolean p;
  private long q;
  private boolean r;
  private boolean s;
  private LoadingStatus t = LoadingStatus.LOADING;
  private ExpandPluginLauncher.PluginServiceState u = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
  private LoadingLifecycle v;
  private int w;
  private int x;
  private final int y = k();
  private final int z;
  
  public ExpandPluginLoadingFragment()
  {
    double d1 = this.y;
    Double.isNaN(d1);
    this.z = ((int)(d1 * 0.4D));
    this.A = l();
    this.B = ((BroadcastReceiver)new ExpandPluginLoadingFragment.mReceiver.1(this));
  }
  
  private final void a(long paramLong)
  {
    if (this.l != 0L)
    {
      QLog.e("ExpandPluginLoadingFragment", 2, "endTime has value!!!");
      return;
    }
    this.l = paramLong;
  }
  
  private final void e(int paramInt)
  {
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateProgress.1(this, paramInt));
  }
  
  private final void f()
  {
    this.v = new LoadingLifecycle((OnApplicationBackgroundListener)new ExpandPluginLoadingFragment.registerLifecycleAndReceiver.1(this));
    GuardManager.sInstance.registerCallBack((IGuardInterface)this.v);
    QLog.d("ExpandPluginLoadingFragment", 2, "add background callbacks");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
    BaseApplicationImpl.getContext().registerReceiver(this.B, localIntentFilter);
  }
  
  private final void g()
  {
    LoadingLifecycle localLoadingLifecycle = this.v;
    if (localLoadingLifecycle != null)
    {
      localLoadingLifecycle.a();
      GuardManager.sInstance.unregisterCallback((IGuardInterface)localLoadingLifecycle);
      QLog.d("ExpandPluginLoadingFragment", 2, "remove background callbacks");
    }
    this.v = ((LoadingLifecycle)null);
    BaseApplicationImpl.getContext().unregisterReceiver(this.B);
  }
  
  private final int h()
  {
    QRoutePluginInfo localQRoutePluginInfo = QRoute.plugin("expand").queryPluginInfo();
    if (localQRoutePluginInfo != null) {
      return localQRoutePluginInfo.getState();
    }
    return -5;
  }
  
  private final void i()
  {
    Object localObject1 = BaseApplicationImpl.context;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.context");
    localObject1 = ((BaseApplication)localObject1).getResources().getDrawable(2130840125);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = new Bundle();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    localObject1 = URLDrawable.getDrawable("https://down.qq.com/innovate/qqexpend/match/boxing.png", (URLDrawable.URLDrawableOptions)localObject2);
    localObject2 = this.c;
    if (localObject2 != null) {
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
    }
  }
  
  private final void j()
  {
    long l2 = this.l;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    this.l = l1;
    Pair localPair1 = TuplesKt.to("duration", String.valueOf(this.l - this.k));
    Pair localPair2 = TuplesKt.to("ext_int1", String.valueOf(this.m));
    Pair localPair3 = TuplesKt.to("download_duration", String.valueOf(this.n));
    boolean bool = this.o;
    Object localObject2 = "2";
    if (bool) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    Pair localPair4 = TuplesKt.to("launch_type", localObject1);
    if (this.s) {
      localObject1 = localObject2;
    } else {
      localObject1 = "1";
    }
    Object localObject1 = MapsKt.hashMapOf(new Pair[] { localPair1, localPair2, localPair3, localPair4, TuplesKt.to("process_status", localObject1), TuplesKt.to("service_loading_state", String.valueOf(this.u.getValue())), TuplesKt.to("start_plugin_state", String.valueOf(this.w)), TuplesKt.to("dismiss_plugin_state", String.valueOf(h())), TuplesKt.to("error_code", String.valueOf(this.x)) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dismiss duration ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("ExpandPluginLoadingFragment", 1, ((StringBuilder)localObject2).toString());
    ExpandReportUtils.a("loading#launch_loading#view", true, -1L, -1L, (Map)localObject1, true, true);
  }
  
  private final int k()
  {
    if (DeviceInfoUtils.isHighPerfDevice()) {
      return 15;
    }
    if (DeviceInfoUtils.isLowPerfDevice()) {
      return 5;
    }
    return 10;
  }
  
  private final double l()
  {
    if (DeviceInfoUtils.isHighPerfDevice()) {
      return 2.0D;
    }
    if (DeviceInfoUtils.isLowPerfDevice()) {
      return 4.0D;
    }
    return 3.0D;
  }
  
  private final void m()
  {
    if (getQBaseActivity().mSystemBarComp == null)
    {
      getQBaseActivity().setImmersiveStatus(0);
    }
    else
    {
      getQBaseActivity().mSystemBarComp.setStatusBarDrawable(null);
      getQBaseActivity().mSystemBarComp.setStatusBarColor(0);
      getQBaseActivity().mSystemBarComp.setStatusColor(0);
    }
    QBaseActivity localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    ImmersiveUtils.setStatusTextColor(true, localQBaseActivity.getWindow());
  }
  
  public final void a()
  {
    QLog.i("ExpandPluginLoadingFragment", 2, "rootView visibility set VISIBLE");
    View localView = this.b;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    localView.setVisibility(0);
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    if (this.t == LoadingStatus.LOADING)
    {
      if (getActivity() == null) {
        return;
      }
      int i1 = (int)Math.ceil(paramDouble1 + paramDouble2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadTime ");
      localStringBuilder.append(paramDouble1);
      localStringBuilder.append(" loadTime ");
      localStringBuilder.append(paramDouble2);
      localStringBuilder.append(" isDownloading ");
      localStringBuilder.append(this.p);
      localStringBuilder.append(" remainTime ");
      localStringBuilder.append(i1);
      QLog.d("ExpandPluginLoadingFragment", 2, localStringBuilder.toString());
      ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateLoadCountDown.1(this, i1));
      ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandPluginLoadingFragment.updateLoadCountDown.2(this, paramDouble1, paramDouble2), 2000L);
    }
  }
  
  public final void a(int paramInt)
  {
    if (paramInt <= 100)
    {
      double d1 = paramInt;
      Double.isNaN(d1);
      e((int)(d1 * 0.6D));
    }
  }
  
  public final void a(@NotNull View.OnClickListener paramOnClickListener)
  {
    Intrinsics.checkParameterIsNotNull(paramOnClickListener, "listener");
    TextView localTextView = this.i;
    if (localTextView != null) {
      localTextView.setOnClickListener(paramOnClickListener);
    }
  }
  
  public final void a(@NotNull LoadingStatus paramLoadingStatus, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramLoadingStatus, "status");
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateLoadingStatus.1(this, paramLoadingStatus, paramInt2, paramInt1));
  }
  
  public final void a(boolean paramBoolean, @NotNull ExpandPluginLauncher.PluginServiceState paramPluginServiceState)
  {
    Intrinsics.checkParameterIsNotNull(paramPluginServiceState, "serviceLoadingState");
    this.o = paramBoolean;
    this.u = paramPluginServiceState;
    a(System.currentTimeMillis());
  }
  
  public final void b()
  {
    this.r = true;
    if (!this.p)
    {
      this.p = true;
      this.q = System.currentTimeMillis();
      c(3);
    }
  }
  
  public final void b(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandPluginLoadingFragment.updateLoadProgress.1(this, paramInt), 500L);
  }
  
  public final void c()
  {
    if (this.p)
    {
      this.p = false;
      this.n = (System.currentTimeMillis() - this.q);
      this.q = 0L;
      c(1);
    }
  }
  
  public final void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDismissFrom ");
    localStringBuilder.append(paramInt);
    QLog.d("ExpandPluginLoadingFragment", 2, localStringBuilder.toString());
    if (this.m != 4) {
      this.m = paramInt;
    }
  }
  
  public final void d()
  {
    this.k = System.currentTimeMillis();
    ExpandReportUtils.a("click#launch_download_error_page#retry_btn", true, -1L, -1L, null, true, true);
  }
  
  public final void d(int paramInt)
  {
    c(paramInt);
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.finish.1(this));
  }
  
  public void e()
  {
    HashMap localHashMap = this.C;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131627440, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…dialog, container, false)");
    this.b = paramLayoutInflater;
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.c = ((URLImageView)paramLayoutInflater.findViewById(2131437633));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.d = ((ImageView)paramLayoutInflater.findViewById(2131437642));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.e = ((ProgressBar)paramLayoutInflater.findViewById(2131437654));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.f = ((TextView)paramLayoutInflater.findViewById(2131437665));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.g = ((TextView)paramLayoutInflater.findViewById(2131446543));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.h = paramLayoutInflater.findViewById(2131447500);
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.i = ((TextView)paramLayoutInflater.findViewById(2131437655));
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.j = ((TextView)paramLayoutInflater.findViewById(2131431443));
    paramLayoutInflater = this.j;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setVisibility(8);
    }
    paramLayoutInflater = this.h;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener((View.OnClickListener)new ExpandPluginLoadingFragment.onCreateView.1(this));
    }
    m();
    i();
    paramLayoutInflater = getArguments();
    int i1;
    if (paramLayoutInflater != null) {
      i1 = paramLayoutInflater.getInt("plugin_process_id", 0);
    } else {
      i1 = 0;
    }
    this.o = ProcessUtils.a(i1);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("isHotStart ");
    paramLayoutInflater.append(this.o);
    paramLayoutInflater.append(' ');
    QLog.i("ExpandPluginLoadingFragment", 2, paramLayoutInflater.toString());
    if (this.o)
    {
      paramLayoutInflater = this.b;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
      }
      paramLayoutInflater.setVisibility(8);
    }
    this.w = h();
    this.s = ProcessUtils.a("com.tencent.mobileqq:plugins");
    c(0);
    a(this, LoadingStatus.LOADING, 0, 0, 6, null);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("plugin state ");
    paramLayoutInflater.append(this.w);
    QLog.i("ExpandPluginLoadingFragment", 1, paramLayoutInflater.toString());
    if (this.w == 3) {
      a(0.0D, this.A);
    }
    f();
    this.k = System.currentTimeMillis();
    ExpandPluginLauncher.a.a().a(this);
    ExpandReportUtils.a("expose#launch_loading#view", true, -1L, -1L, null, true, true);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("expose loadingFragment ");
    paramLayoutInflater.append(System.identityHashCode(this));
    QLog.i("ExpandPluginLoadingFragment", 1, paramLayoutInflater.toString());
    paramLayoutInflater = this.b;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onDestroy ");
    localStringBuilder.append(System.identityHashCode(this));
    QLog.i("ExpandPluginLoadingFragment", 4, localStringBuilder.toString());
    g();
    ExpandPluginLauncher.a.a().b();
    if ((this.t == LoadingStatus.LOADING) || (this.t == LoadingStatus.LOADING_SUCCESS)) {
      j();
    }
    super.onDestroy();
  }
  
  public void onPause()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onPause ");
    localStringBuilder.append(System.identityHashCode(this));
    QLog.i("ExpandPluginLoadingFragment", 4, localStringBuilder.toString());
    super.onPause();
  }
  
  public void onResume()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onResume ");
    localStringBuilder.append(System.identityHashCode(this));
    QLog.i("ExpandPluginLoadingFragment", 4, localStringBuilder.toString());
    super.onResume();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */