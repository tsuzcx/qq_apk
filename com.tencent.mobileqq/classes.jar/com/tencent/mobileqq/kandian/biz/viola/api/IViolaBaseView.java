package com.tencent.mobileqq.kandian.biz.viola.api;

import android.view.View;
import androidx.fragment.app.Fragment;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView;", "", "getView", "Landroid/view/View;", "isCreated", "", "isPageSucceed", "loadViolaUrl", "", "url", "", "fragment", "Landroidx/fragment/app/Fragment;", "pageObject", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView$ViolaCreactPageObject;", "onActivityCreate", "onActivityDestroy", "onActivityPause", "onActivityResume", "onActivityStart", "onActivityStop", "reload", "violaViewListener", "Lcom/tencent/mobileqq/kandian/biz/viola/api/IViolaBaseView$ViolaViewListener;", "setListener", "listener", "setPageStartTime", "pageStartTime", "", "updateInstance", "data", "updateInstanceVisiable", "isVisible", "ViolaCreactPageObject", "ViolaViewListener", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IViolaBaseView
{
  public abstract void a(@Nullable IViolaBaseView.ViolaViewListener paramViolaViewListener);
  
  public abstract void a(@Nullable String paramString, @Nullable Fragment paramFragment, @Nullable IViolaBaseView.ViolaCreactPageObject paramViolaCreactPageObject);
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean b();
  
  @NotNull
  public abstract View getView();
  
  public abstract void onActivityDestroy();
  
  public abstract void onActivityPause();
  
  public abstract void onActivityResume();
  
  public abstract void onActivityStart();
  
  public abstract void onActivityStop();
  
  public abstract void setListener(@NotNull IViolaBaseView.ViolaViewListener paramViolaViewListener);
  
  public abstract void setPageStartTime(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.viola.api.IViolaBaseView
 * JD-Core Version:    0.7.0.1
 */