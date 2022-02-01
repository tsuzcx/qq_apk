package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.kandian.base.utils.RIJDisplayStyleManager;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJDisplayStyleManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJDisplayStyleManager;", "()V", "recentListReportVisibleItemCount", "", "getRecentListReportVisibleItemCount", "()I", "setRecentListReportVisibleItemCount", "(I)V", "calcVisibleItemCount", "", "recentListHeight", "", "res", "Landroid/content/res/Resources;", "getItemMiddleStyle", "context", "Landroid/content/Context;", "enableKanDianFeedsCardStyle", "", "getItemPaddingNewStyle", "getPhysicalDisplaySize", "", "activity", "Landroid/app/Activity;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDisplayStyleManagerImpl
  implements IRIJDisplayStyleManager
{
  public void calcVisibleItemCount(float paramFloat, @Nullable Resources paramResources)
  {
    this.$$delegate_0.calcVisibleItemCount(paramFloat, paramResources);
  }
  
  public int getItemMiddleStyle(@Nullable Context paramContext, boolean paramBoolean)
  {
    return this.$$delegate_0.getItemMiddleStyle(paramContext, paramBoolean);
  }
  
  public int getItemPaddingNewStyle(@Nullable Context paramContext, boolean paramBoolean)
  {
    return this.$$delegate_0.getItemPaddingNewStyle(paramContext, paramBoolean);
  }
  
  @NotNull
  public int[] getPhysicalDisplaySize(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    return this.$$delegate_0.getPhysicalDisplaySize(paramActivity);
  }
  
  public int getRecentListReportVisibleItemCount()
  {
    return this.$$delegate_0.getRecentListReportVisibleItemCount();
  }
  
  public void setRecentListReportVisibleItemCount(int paramInt)
  {
    this.$$delegate_0.setRecentListReportVisibleItemCount(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.RIJDisplayStyleManagerImpl
 * JD-Core Version:    0.7.0.1
 */