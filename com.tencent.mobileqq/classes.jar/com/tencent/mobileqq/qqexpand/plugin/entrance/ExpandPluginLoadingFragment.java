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
  public static final ExpandPluginLoadingFragment.Companion a;
  private final double jdField_a_of_type_Double;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private final BroadcastReceiver jdField_a_of_type_AndroidContentBroadcastReceiver;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  private ExpandPluginLauncher.PluginServiceState jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = ExpandPluginLauncher.PluginServiceState.NOT_STARTED;
  private LoadingStatus jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceLoadingStatus = LoadingStatus.LOADING;
  private LoadingLifecycle jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLoadingLifecycle;
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private TextView jdField_b_of_type_AndroidWidgetTextView;
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean;
  private final int jdField_d_of_type_Int = b();
  private long jdField_d_of_type_Long;
  private TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean;
  private final int e;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLoadingFragment$Companion = new ExpandPluginLoadingFragment.Companion(null);
  }
  
  public ExpandPluginLoadingFragment()
  {
    double d1 = this.jdField_d_of_type_Int;
    Double.isNaN(d1);
    this.e = ((int)(d1 * 0.4D));
    this.jdField_a_of_type_Double = a();
    this.jdField_a_of_type_AndroidContentBroadcastReceiver = ((BroadcastReceiver)new ExpandPluginLoadingFragment.mReceiver.1(this));
  }
  
  private final double a()
  {
    if (DeviceInfoUtils.a()) {
      return 2.0D;
    }
    if (DeviceInfoUtils.b()) {
      return 4.0D;
    }
    return 3.0D;
  }
  
  private final int a()
  {
    QRoutePluginInfo localQRoutePluginInfo = QRoute.plugin("expand").queryPluginInfo();
    if (localQRoutePluginInfo != null) {
      return localQRoutePluginInfo.getState();
    }
    return -5;
  }
  
  private final void a(long paramLong)
  {
    if (this.jdField_b_of_type_Long != 0L)
    {
      QLog.e("ExpandPluginLoadingFragment", 2, "endTime has value!!!");
      return;
    }
    this.jdField_b_of_type_Long = paramLong;
  }
  
  private final int b()
  {
    if (DeviceInfoUtils.a()) {
      return 15;
    }
    if (DeviceInfoUtils.b()) {
      return 5;
    }
    return 10;
  }
  
  private final void e(int paramInt)
  {
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateProgress.1(this, paramInt));
  }
  
  private final void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLoadingLifecycle = new LoadingLifecycle((OnApplicationBackgroundListener)new ExpandPluginLoadingFragment.registerLifecycleAndReceiver.1(this));
    GuardManager.a.a((IGuardInterface)this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLoadingLifecycle);
    QLog.d("ExpandPluginLoadingFragment", 2, "add background callbacks");
    IntentFilter localIntentFilter = new IntentFilter();
    localIntentFilter.addAction("com.tencent.mobileqq.qshadow.ACTION_PLUGIN_CRASH");
    BaseApplicationImpl.getContext().registerReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver, localIntentFilter);
  }
  
  private final void g()
  {
    LoadingLifecycle localLoadingLifecycle = this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLoadingLifecycle;
    if (localLoadingLifecycle != null)
    {
      localLoadingLifecycle.c();
      GuardManager.a.b((IGuardInterface)localLoadingLifecycle);
      QLog.d("ExpandPluginLoadingFragment", 2, "remove background callbacks");
    }
    this.jdField_a_of_type_ComTencentMobileqqQqexpandUtilsLoadingLifecycle = ((LoadingLifecycle)null);
    BaseApplicationImpl.getContext().unregisterReceiver(this.jdField_a_of_type_AndroidContentBroadcastReceiver);
  }
  
  private final void h()
  {
    Object localObject1 = BaseApplicationImpl.context;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.context");
    localObject1 = ((BaseApplication)localObject1).getResources().getDrawable(2130839653);
    Object localObject2 = URLDrawable.URLDrawableOptions.obtain();
    ((URLDrawable.URLDrawableOptions)localObject2).mUseApngImage = true;
    ((URLDrawable.URLDrawableOptions)localObject2).mExtraInfo = new Bundle();
    ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = ((Drawable)localObject1);
    ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = ((Drawable)localObject1);
    localObject1 = URLDrawable.getDrawable("https://down.qq.com/innovate/qqexpend/match/boxing.png", (URLDrawable.URLDrawableOptions)localObject2);
    localObject2 = this.jdField_a_of_type_ComTencentImageURLImageView;
    if (localObject2 != null) {
      ((URLImageView)localObject2).setImageDrawable((Drawable)localObject1);
    }
  }
  
  private final void i()
  {
    long l2 = this.jdField_b_of_type_Long;
    long l1 = l2;
    if (l2 == 0L) {
      l1 = System.currentTimeMillis();
    }
    this.jdField_b_of_type_Long = l1;
    Pair localPair1 = TuplesKt.to("duration", String.valueOf(this.jdField_b_of_type_Long - this.jdField_a_of_type_Long));
    Pair localPair2 = TuplesKt.to("ext_int1", String.valueOf(this.jdField_a_of_type_Int));
    Pair localPair3 = TuplesKt.to("download_duration", String.valueOf(this.jdField_c_of_type_Long));
    boolean bool = this.jdField_a_of_type_Boolean;
    Object localObject2 = "2";
    if (bool) {
      localObject1 = "2";
    } else {
      localObject1 = "1";
    }
    Pair localPair4 = TuplesKt.to("launch_type", localObject1);
    if (this.jdField_d_of_type_Boolean) {
      localObject1 = localObject2;
    } else {
      localObject1 = "1";
    }
    Object localObject1 = MapsKt.hashMapOf(new Pair[] { localPair1, localPair2, localPair3, localPair4, TuplesKt.to("process_status", localObject1), TuplesKt.to("service_loading_state", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState.getValue())), TuplesKt.to("start_plugin_state", String.valueOf(this.jdField_b_of_type_Int)), TuplesKt.to("dismiss_plugin_state", String.valueOf(a())), TuplesKt.to("error_code", String.valueOf(this.jdField_c_of_type_Int)) });
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("dismiss duration ");
    ((StringBuilder)localObject2).append(localObject1);
    QLog.i("ExpandPluginLoadingFragment", 1, ((StringBuilder)localObject2).toString());
    ExpandReportUtils.a("loading#launch_loading#view", true, -1L, -1L, (Map)localObject1, true, true);
  }
  
  private final void j()
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if (localView == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    localView.setVisibility(0);
  }
  
  public final void a(double paramDouble1, double paramDouble2)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceLoadingStatus == LoadingStatus.LOADING)
    {
      if (getActivity() == null) {
        return;
      }
      int i = (int)Math.ceil(paramDouble1 + paramDouble2);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("downloadTime ");
      localStringBuilder.append(paramDouble1);
      localStringBuilder.append(" loadTime ");
      localStringBuilder.append(paramDouble2);
      localStringBuilder.append(" isDownloading ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(" remainTime ");
      localStringBuilder.append(i);
      QLog.d("ExpandPluginLoadingFragment", 2, localStringBuilder.toString());
      ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.updateLoadCountDown.1(this, i));
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
    TextView localTextView = this.jdField_c_of_type_AndroidWidgetTextView;
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
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceExpandPluginLauncher$PluginServiceState = paramPluginServiceState;
    a(System.currentTimeMillis());
  }
  
  public final void b()
  {
    this.jdField_c_of_type_Boolean = true;
    if (!this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = true;
      this.jdField_d_of_type_Long = System.currentTimeMillis();
      c(3);
    }
  }
  
  public final void b(int paramInt)
  {
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandPluginLoadingFragment.updateLoadProgress.1(this, paramInt), 500L);
  }
  
  public final void c()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_b_of_type_Boolean = false;
      this.jdField_c_of_type_Long = (System.currentTimeMillis() - this.jdField_d_of_type_Long);
      this.jdField_d_of_type_Long = 0L;
      c(1);
    }
  }
  
  public final void c(int paramInt)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("updateDismissFrom ");
    localStringBuilder.append(paramInt);
    QLog.d("ExpandPluginLoadingFragment", 2, localStringBuilder.toString());
    if (this.jdField_a_of_type_Int != 4) {
      this.jdField_a_of_type_Int = paramInt;
    }
  }
  
  public final void d()
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ExpandReportUtils.a("click#launch_download_error_page#retry_btn", true, -1L, -1L, null, true, true);
  }
  
  public final void d(int paramInt)
  {
    c(paramInt);
    ThreadManager.getUIHandler().post((Runnable)new ExpandPluginLoadingFragment.finish.1(this));
  }
  
  public void e()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    paramLayoutInflater = paramLayoutInflater.inflate(2131561090, paramViewGroup, false);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "inflater.inflate(R.layou…dialog, container, false)");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)paramLayoutInflater.findViewById(2131370371));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramLayoutInflater.findViewById(2131370376));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramLayoutInflater.findViewById(2131370387));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131370397));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131378043));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_b_of_type_AndroidViewView = paramLayoutInflater.findViewById(2131378817);
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131370388));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mRootView");
    }
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramLayoutInflater.findViewById(2131365270));
    paramLayoutInflater = this.jdField_d_of_type_AndroidWidgetTextView;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setVisibility(8);
    }
    paramLayoutInflater = this.jdField_b_of_type_AndroidViewView;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.setOnClickListener((View.OnClickListener)new ExpandPluginLoadingFragment.onCreateView.1(this));
    }
    j();
    h();
    paramLayoutInflater = getArguments();
    int i;
    if (paramLayoutInflater != null) {
      i = paramLayoutInflater.getInt("plugin_process_id", 0);
    } else {
      i = 0;
    }
    this.jdField_a_of_type_Boolean = ProcessUtils.a(i);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("isHotStart ");
    paramLayoutInflater.append(this.jdField_a_of_type_Boolean);
    paramLayoutInflater.append(' ');
    QLog.i("ExpandPluginLoadingFragment", 2, paramLayoutInflater.toString());
    if (this.jdField_a_of_type_Boolean)
    {
      paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
      if (paramLayoutInflater == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
      }
      paramLayoutInflater.setVisibility(8);
    }
    this.jdField_b_of_type_Int = a();
    this.jdField_d_of_type_Boolean = ProcessUtils.a("com.tencent.mobileqq:plugins");
    c(0);
    a(this, LoadingStatus.LOADING, 0, 0, 6, null);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("plugin state ");
    paramLayoutInflater.append(this.jdField_b_of_type_Int);
    QLog.i("ExpandPluginLoadingFragment", 1, paramLayoutInflater.toString());
    if (this.jdField_b_of_type_Int == 3) {
      a(0.0D, this.jdField_a_of_type_Double);
    }
    f();
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    ExpandPluginLauncher.a.a().a(this);
    ExpandReportUtils.a("expose#launch_loading#view", true, -1L, -1L, null, true, true);
    paramLayoutInflater = new StringBuilder();
    paramLayoutInflater.append("expose loadingFragment ");
    paramLayoutInflater.append(System.identityHashCode(this));
    QLog.i("ExpandPluginLoadingFragment", 1, paramLayoutInflater.toString());
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
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
    if ((this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceLoadingStatus == LoadingStatus.LOADING) || (this.jdField_a_of_type_ComTencentMobileqqQqexpandPluginEntranceLoadingStatus == LoadingStatus.LOADING_SUCCESS)) {
      i();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.plugin.entrance.ExpandPluginLoadingFragment
 * JD-Core Version:    0.7.0.1
 */