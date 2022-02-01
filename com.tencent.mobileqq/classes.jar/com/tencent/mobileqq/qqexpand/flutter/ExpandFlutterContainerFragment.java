package com.tencent.mobileqq.qqexpand.flutter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.flutter.container.QFlutterContainerDelegate;
import com.tencent.mobileqq.flutter.container.QFlutterContainerFragment;
import com.tencent.mobileqq.flutter.router.SerializableMap;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.qqexpand.fragment.ExpandDTParamBuilder;
import com.tencent.mobileqq.qqexpand.ipc.ExpandFlutterIPCClient;
import com.tencent.mobileqq.qqexpand.utils.ActivityExtUtils;
import com.tencent.mobileqq.qqexpand.utils.ExpandReportUtils;
import com.tencent.mobileqq.utils.ViewUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.VideoReport;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/qqexpand/flutter/ExpandFlutterContainerFragment;", "Lcom/tencent/mobileqq/flutter/container/QFlutterContainerFragment;", "()V", "EXPAND_FRIEND_TIME_OUT", "", "LOADING_BOXING", "", "mErrorView", "Landroid/view/View;", "mFirstOpen", "", "mIsBePaused", "mIsSplashShowing", "mProgressBar", "Landroid/widget/ProgressBar;", "mSplashView", "mStartSplashTime", "", "mStartTime", "getContext", "Landroid/content/Context;", "getSplashView", "handleSplashRemove", "isWrapContent", "onAttach", "", "activity", "Landroid/app/Activity;", "onBackEvent", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onPause", "onResume", "registerDaTongReport", "view", "reportExpose", "updateLoadingProgress", "upProgress", "Companion", "qqexpand_impl_release"}, k=1, mv={1, 1, 16})
public final class ExpandFlutterContainerFragment
  extends QFlutterContainerFragment
{
  public static final ExpandFlutterContainerFragment.Companion a;
  private final int jdField_a_of_type_Int = 30000;
  private long jdField_a_of_type_Long = System.currentTimeMillis();
  private View jdField_a_of_type_AndroidViewView;
  private ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  private final String jdField_a_of_type_JavaLangString = "https://down.qq.com/innovate/qqexpend/match/boxing.png";
  private HashMap jdField_a_of_type_JavaUtilHashMap;
  private boolean jdField_a_of_type_Boolean = true;
  private long jdField_b_of_type_Long;
  private View jdField_b_of_type_AndroidViewView;
  private boolean jdField_b_of_type_Boolean;
  private boolean c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqQqexpandFlutterExpandFlutterContainerFragment$Companion = new ExpandFlutterContainerFragment.Companion(null);
  }
  
  private final void a(int paramInt)
  {
    ThreadManager.getUIHandlerV2().postDelayed((Runnable)new ExpandFlutterContainerFragment.updateLoadingProgress.1(this, paramInt), 200L);
  }
  
  private final void a(View paramView)
  {
    VideoReport.addToDetectionWhitelist((Activity)getQBaseActivity());
    VideoReport.setPageId(paramView, "match_page");
    VideoReport.setPageParams(paramView, new ExpandDTParamBuilder().a());
    QLog.i("ExpandFlutterContainerFragment", 1, "reportDaTongRegister");
  }
  
  @Nullable
  public View a()
  {
    QLog.d("ExpandFlutterContainerFragment", 1, "getSplashView");
    this.jdField_b_of_type_Long = System.currentTimeMillis();
    this.jdField_b_of_type_Boolean = true;
    ReportHelper.a();
    boolean bool = ExpandFlutterUtils.a.a();
    Object localObject2 = null;
    if (bool) {
      return null;
    }
    this.jdField_b_of_type_AndroidViewView = LayoutInflater.from(getContext()).inflate(2131561091, null);
    Object localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null) {
      localObject1 = (ImageView)((View)localObject1).findViewById(2131370371);
    } else {
      localObject1 = null;
    }
    Object localObject3 = getContext().getResources().getDrawable(2130839653);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mUseApngImage = true;
    localURLDrawableOptions.mExtraInfo = new Bundle();
    localURLDrawableOptions.mLoadingDrawable = ((Drawable)localObject3);
    localURLDrawableOptions.mFailedDrawable = ((Drawable)localObject3);
    localObject3 = URLDrawable.getDrawable(this.jdField_a_of_type_JavaLangString, localURLDrawableOptions);
    if (localObject1 != null) {
      ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
    }
    localObject1 = this.jdField_b_of_type_AndroidViewView;
    if (localObject1 != null)
    {
      localObject1 = ((View)localObject1).findViewById(2131378817);
      if (localObject1 != null) {
        ((View)localObject1).setOnClickListener((View.OnClickListener)new ExpandFlutterContainerFragment.getSplashView.1(this));
      }
    }
    localObject3 = this.jdField_b_of_type_AndroidViewView;
    localObject1 = localObject2;
    if (localObject3 != null) {
      localObject1 = (ProgressBar)((View)localObject3).findViewById(2131370387);
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)localObject1);
    int i = RangesKt.random(new IntRange(10, 15), (Random)Random.Default);
    localObject1 = this.jdField_a_of_type_AndroidWidgetProgressBar;
    if (localObject1 != null) {
      ((ProgressBar)localObject1).setProgress(i);
    }
    a(i);
    return this.jdField_b_of_type_AndroidViewView;
  }
  
  public final void a()
  {
    ReportHelper.a(this.jdField_a_of_type_Long);
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    QLog.d("ExpandFlutterContainerFragment", 1, "handleSplashRemove");
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      this.jdField_b_of_type_Boolean = false;
      ReportHelper.a(this.jdField_b_of_type_Long, 2, ExpandFlutterUtils.a.a());
      if (ExpandFlutterUtils.a.a()) {
        return false;
      }
      ExpandFlutterUtils.a.f();
      localObject = this.jdField_a_of_type_AndroidWidgetProgressBar;
      if (localObject != null) {
        ((ProgressBar)localObject).setProgress(100);
      }
      ThreadManager.getUIHandlerV2().postDelayed((Runnable)new ExpandFlutterContainerFragment.handleSplashRemove.1(this), 500L);
      return true;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("splash showing ");
    ((StringBuilder)localObject).append(this.jdField_b_of_type_Boolean);
    ((StringBuilder)localObject).append(' ');
    ((StringBuilder)localObject).append(this.c);
    QLog.d("ExpandFlutterContainerFragment", 1, ((StringBuilder)localObject).toString());
    return false;
  }
  
  public void b()
  {
    HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
    if (localHashMap != null) {
      localHashMap.clear();
    }
  }
  
  @NotNull
  public Context getContext()
  {
    Object localObject = BaseApplicationImpl.getApplication();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getApplication()");
    localObject = ((BaseApplicationImpl)localObject).getApplicationContext();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "BaseApplicationImpl.getA…tion().applicationContext");
    return localObject;
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onAttach(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    ThreadManager.getUIHandler().postDelayed((Runnable)new ExpandFlutterContainerFragment.onAttach.1(this), this.jdField_a_of_type_Int);
    super.onAttach(paramActivity);
  }
  
  public boolean onBackEvent()
  {
    if ((this.jdField_b_of_type_Boolean) && (!this.c))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onBackEvent splash showing ");
      localStringBuilder.append(this.jdField_b_of_type_Boolean);
      localStringBuilder.append(' ');
      localStringBuilder.append(this.c);
      QLog.d("ExpandFlutterContainerFragment", 1, localStringBuilder.toString());
      ReportHelper.a(this.jdField_b_of_type_Long, 1, ExpandFlutterUtils.a.a());
    }
    return this.jdField_a_of_type_ComTencentMobileqqFlutterContainerQFlutterContainerDelegate.a();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    ExpandReportUtils.a();
    ExpandFlutterUtils.a.a();
    ExpandFlutterUtils.a.b();
    ExpandFlutterIPCClient.a();
    ExpandFlutterUtils.a.c();
    ExpandFlutterUtils.a.d();
    ExpandFlutterUtils.a.e();
  }
  
  @NotNull
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    QBaseActivity localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    ActivityExtUtils.a(localQBaseActivity);
    localQBaseActivity = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
    ImmersiveUtils.setStatusTextColor(true, localQBaseActivity.getWindow());
    paramBundle = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    paramLayoutInflater = LayoutInflater.from((Context)getQBaseActivity()).inflate(2131561080, null);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "LayoutInflater.from(qBas…ter_empty_fragment, null)");
    this.jdField_a_of_type_AndroidViewView = paramLayoutInflater;
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater = paramLayoutInflater.findViewById(2131378837);
    Intrinsics.checkExpressionValueIsNotNull(paramLayoutInflater, "mErrorView.findViewById<View>(R.id.title_layout)");
    int i = ViewUtils.c(ImmersiveUtils.getStatusBarHeight((Context)getQBaseActivity()));
    paramViewGroup = paramLayoutInflater.getLayoutParams();
    paramLayoutInflater = paramViewGroup;
    if (!(paramViewGroup instanceof ViewGroup.MarginLayoutParams)) {
      paramLayoutInflater = null;
    }
    paramLayoutInflater = (ViewGroup.MarginLayoutParams)paramLayoutInflater;
    if (paramLayoutInflater != null) {
      paramLayoutInflater.topMargin = LayoutAttrsKt.getDp(i);
    }
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater.findViewById(2131369934).setOnClickListener((View.OnClickListener)new ExpandFlutterContainerFragment.onCreateView.1(this));
    paramLayoutInflater = this.jdField_a_of_type_AndroidViewView;
    if (paramLayoutInflater == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
    }
    paramLayoutInflater.setVisibility(8);
    if (paramBundle != null)
    {
      paramLayoutInflater = (FrameLayout)paramBundle;
      paramViewGroup = this.jdField_a_of_type_AndroidViewView;
      if (paramViewGroup == null) {
        Intrinsics.throwUninitializedPropertyAccessException("mErrorView");
      }
      paramLayoutInflater.addView(paramViewGroup, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramLayoutInflater = new ExpandFlutterFrameLayout(getContext());
      paramLayoutInflater.addView(paramBundle, (ViewGroup.LayoutParams)new FrameLayout.LayoutParams(-1, -1));
      paramLayoutInflater = (View)paramLayoutInflater;
      a(paramLayoutInflater);
      return paramLayoutInflater;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.FrameLayout");
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    a();
    ExpandFlutterIPCClient.b();
    Object localObject1 = getQBaseActivity();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "qBaseActivity");
    localObject1 = ((QBaseActivity)localObject1).getIntent().getSerializableExtra("params");
    if (localObject1 != null)
    {
      localObject1 = (SerializableMap)localObject1;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onDestroy ");
      ((StringBuilder)localObject2).append(((SerializableMap)localObject1).getMap().get("startTime"));
      QLog.d("ExpandFlutterContainerFragment", 2, ((StringBuilder)localObject2).toString());
      localObject2 = ((SerializableMap)localObject1).getMap();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "extra.map");
      ((Map)localObject2).put("startTime", "0");
      localObject2 = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "qBaseActivity");
      ((QBaseActivity)localObject2).getIntent().putExtra("params", (Serializable)localObject1);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.flutter.router.SerializableMap");
  }
  
  public void onPause()
  {
    super.onPause();
    this.c = true;
  }
  
  public void onResume()
  {
    super.onResume();
    if (this.jdField_a_of_type_Boolean)
    {
      if (QLog.isDebugVersion())
      {
        Object localObject = getQBaseActivity();
        Intrinsics.checkExpressionValueIsNotNull(localObject, "qBaseActivity");
        localObject = ((QBaseActivity)localObject).getIntent().getSerializableExtra("params");
        if (localObject != null)
        {
          localObject = ((SerializableMap)localObject).getMap().get("startTime");
          if (localObject != null)
          {
            localObject = (String)localObject;
            if (Long.parseLong((String)localObject) > 0L)
            {
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("time cost: ");
              localStringBuilder.append(System.currentTimeMillis() - Long.parseLong((String)localObject));
              QLog.d("ExpandFlutterContainerFragment", 4, localStringBuilder.toString());
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type kotlin.String");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.flutter.router.SerializableMap");
        }
      }
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.flutter.ExpandFlutterContainerFragment
 * JD-Core Version:    0.7.0.1
 */