package com.tencent.mobileqq.minigame.publicaccount.hippy;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.now.utils.StatusBarUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qroute.route.ActivityURIRequest;
import com.tencent.mobileqq.qroute.route.URIRequest;
import com.tencent.mobileqq.simpleui.SimpleUIUtil;
import com.tencent.mobileqq.widget.navbar.NavBarCommon;
import com.tencent.mobileqq.widget.navbar.OnItemSelectListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;
import com.tencent.widget.immersive.SystemBarCompact;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyFragment;", "Lcom/tencent/mobileqq/minigame/publicaccount/hippy/MiniGamePAHippyBaseFragment;", "()V", "navBar", "Lcom/tencent/mobileqq/widget/navbar/NavBarCommon;", "getLayoutResId", "", "gotoAccountDetail", "", "initNavBar", "initViews", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onPostThemeChanged", "setNavBar", "setStatusBarImmersive", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class MiniGamePAHippyFragment
  extends MiniGamePAHippyBaseFragment
{
  private NavBarCommon navBar;
  
  private final void gotoAccountDetail()
  {
    ActivityURIRequest localActivityURIRequest = new ActivityURIRequest((Context)getActivity(), "/pubaccount/detail");
    localActivityURIRequest.extra().putString("uin", AppConstants.MINI_GAME_PUBLIC_ACCOUNT_UIN);
    localActivityURIRequest.extra().putBoolean("fromMiniGamePub", true);
    QRoute.startUri((URIRequest)localActivityURIRequest, null);
  }
  
  private final void initNavBar()
  {
    View localView = getRootView().findViewById(2131371258);
    Intrinsics.checkExpressionValueIsNotNull(localView, "rootView.findViewById(R.…ni_game_pa_hippy_nav_bar)");
    this.navBar = ((NavBarCommon)localView);
    setNavBar();
  }
  
  private final void setNavBar()
  {
    NavBarCommon localNavBarCommon = this.navBar;
    if (localNavBarCommon == null) {
      Intrinsics.throwUninitializedPropertyAccessException("navBar");
    }
    localNavBarCommon.setTitle(localNavBarCommon.getContext().getText(2131694179));
    if (isNightTheme())
    {
      localNavBarCommon.getRootView().setBackgroundColor(-16777216);
      localNavBarCommon.changeBg(false);
      localNavBarCommon.setBackgroundColor(-16777216);
      localNavBarCommon.setTitleColor(-1);
      localObject = localNavBarCommon.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localNavBarCommon.setRightImage(((Context)localObject).getResources().getDrawable(2130850474));
    }
    else
    {
      localNavBarCommon.getRootView().setBackgroundColor(-1);
      localNavBarCommon.changeBg(true);
      localNavBarCommon.setBackgroundColor(-1);
      localNavBarCommon.setTitleColor(-16777216);
      localObject = localNavBarCommon.getContext();
      Intrinsics.checkExpressionValueIsNotNull(localObject, "context");
      localNavBarCommon.setRightImage(((Context)localObject).getResources().getDrawable(2130848560));
    }
    localNavBarCommon.setOnItemSelectListener((OnItemSelectListener)new MiniGamePAHippyFragment.setNavBar..inlined.run.lambda.1(this));
    Object localObject = localNavBarCommon.getLayoutParams();
    if (localObject != null)
    {
      localObject = (LinearLayout.LayoutParams)localObject;
      ((LinearLayout.LayoutParams)localObject).setMargins(0, StatusBarUtil.a((Activity)getActivity()) - 1, 0, 0);
      localNavBarCommon.setLayoutParams((ViewGroup.LayoutParams)localObject);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
  }
  
  public int getLayoutResId()
  {
    return 2131559403;
  }
  
  public void initViews()
  {
    super.initViews();
    initNavBar();
  }
  
  @Nullable
  public View onCreateView(@NotNull LayoutInflater paramLayoutInflater, @Nullable ViewGroup paramViewGroup, @Nullable Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramLayoutInflater, "inflater");
    getParameters().putBoolean("isStatusBarDarkFont", isNightTheme() ^ true);
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    boolean bool = isNightTheme();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onPostThemeChanged isNightTheme=");
      localStringBuilder.append(bool);
      QLog.d("MiniGamePAHippyBaseFragment", 2, localStringBuilder.toString());
    }
    getParameters().putBoolean("isStatusBarDarkFont", bool ^ true);
    setNavBar();
    setStatusBarImmersive();
    notifyHippyThemeChange(bool);
  }
  
  public void setStatusBarImmersive()
  {
    boolean bool = isNightTheme();
    int i;
    if (bool) {
      i = -16777216;
    } else {
      i = -1;
    }
    if (!SimpleUIUtil.a())
    {
      getQBaseActivity().mSystemBarComp = ((SystemBarCompact)null);
      getQBaseActivity().setImmersiveStatus(i);
    }
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      QBaseActivity localQBaseActivity = getQBaseActivity();
      Intrinsics.checkExpressionValueIsNotNull(localQBaseActivity, "qBaseActivity");
      ImmersiveUtils.setStatusTextColor(bool ^ true, localQBaseActivity.getWindow());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.publicaccount.hippy.MiniGamePAHippyFragment
 * JD-Core Version:    0.7.0.1
 */