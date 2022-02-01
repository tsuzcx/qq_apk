package com.tencent.mobileqq.kandian.biz.viola.api;

import android.view.ViewGroup;
import com.tencent.mobileqq.app.QBaseFragment;
import com.tencent.mobileqq.kandian.biz.viola.view.ViolaFragment.ViolaGestureLayoutListener;
import com.tencent.mtt.hippy.common.HippyMap;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaFragmentView;", "", "dealFlingEnableWhenSwitcher", "", "position", "", "disableFPSBall", "", "getContentView", "Landroid/view/ViewGroup;", "getPropsMap", "Lcom/tencent/mtt/hippy/common/HippyMap;", "getQBaseFragment", "Lcom/tencent/mobileqq/app/QBaseFragment;", "getSusConfigMap", "Ljava/util/HashMap;", "getViolaGestureLayoutListener", "Lcom/tencent/mobileqq/kandian/biz/viola/view/ViolaFragment$ViolaGestureLayoutListener;", "onHippyPageLoad", "isSuccess", "errMsg", "", "setStatusBarFontColor", "isWhite", "(Ljava/lang/Boolean;)V", "shouldFinishActivity", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaFragmentView
{
  @Nullable
  public abstract ViewGroup getContentView();
  
  @Nullable
  public abstract HippyMap getPropsMap();
  
  @NotNull
  public abstract QBaseFragment getQBaseFragment();
  
  @Nullable
  public abstract ViolaFragment.ViolaGestureLayoutListener getViolaGestureLayoutListener();
  
  public abstract boolean onHippyPageLoad(boolean paramBoolean, @Nullable String paramString);
  
  public abstract void setStatusBarFontColor(@Nullable Boolean paramBoolean);
  
  public abstract boolean shouldFinishActivity();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaFragmentView
 * JD-Core Version:    0.7.0.1
 */