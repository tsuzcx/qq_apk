package com.tencent.mobileqq.kandian.base.utils.api;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJDisplayStyleManager;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "recentListReportVisibleItemCount", "", "getRecentListReportVisibleItemCount", "()I", "setRecentListReportVisibleItemCount", "(I)V", "calcVisibleItemCount", "", "recentListHeight", "", "res", "Landroid/content/res/Resources;", "getItemMiddleStyle", "context", "Landroid/content/Context;", "enableKanDianFeedsCardStyle", "", "getItemPaddingNewStyle", "getPhysicalDisplaySize", "", "activity", "Landroid/app/Activity;", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IRIJDisplayStyleManager
  extends QRouteApi
{
  public abstract void calcVisibleItemCount(float paramFloat, @Nullable Resources paramResources);
  
  public abstract int getItemMiddleStyle(@Nullable Context paramContext, boolean paramBoolean);
  
  public abstract int getItemPaddingNewStyle(@Nullable Context paramContext, boolean paramBoolean);
  
  @NotNull
  public abstract int[] getPhysicalDisplaySize(@NotNull Activity paramActivity);
  
  public abstract int getRecentListReportVisibleItemCount();
  
  public abstract void setRecentListReportVisibleItemCount(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager
 * JD-Core Version:    0.7.0.1
 */