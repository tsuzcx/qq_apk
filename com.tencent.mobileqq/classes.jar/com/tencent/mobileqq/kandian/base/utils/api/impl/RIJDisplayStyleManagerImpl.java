package com.tencent.mobileqq.kandian.base.utils.api.impl;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.mobileqq.kandian.base.utils.api.IRIJDisplayStyleManager;
import com.tencent.mobileqq.mini.entry.layout.LayoutAttrsKt;
import com.tencent.mobileqq.util.DisplayUtil;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/base/utils/api/impl/RIJDisplayStyleManagerImpl;", "Lcom/tencent/mobileqq/kandian/base/utils/api/IRIJDisplayStyleManager;", "()V", "recentListReportVisibleItemCount", "", "getRecentListReportVisibleItemCount", "()I", "setRecentListReportVisibleItemCount", "(I)V", "calcVisibleItemCount", "", "recentListHeight", "", "res", "Landroid/content/res/Resources;", "getItemMiddleStyle", "context", "Landroid/content/Context;", "enableKanDianFeedsCardStyle", "", "getItemPaddingNewStyle", "getPhysicalDisplaySize", "", "activity", "Landroid/app/Activity;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJDisplayStyleManagerImpl
  implements IRIJDisplayStyleManager
{
  private int recentListReportVisibleItemCount = 7;
  
  public void calcVisibleItemCount(float paramFloat, @Nullable Resources paramResources)
  {
    if (paramFloat != 0.0F)
    {
      if (paramResources == null) {
        return;
      }
      setRecentListReportVisibleItemCount((int)(paramFloat / LayoutAttrsKt.getDp((Number)Float.valueOf(72.0F)) + 0.5F));
    }
  }
  
  public int getItemMiddleStyle(@Nullable Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return DisplayUtil.a(paramContext, 8.0F);
    }
    return DisplayUtil.a(paramContext, 3.0F);
  }
  
  public int getItemPaddingNewStyle(@Nullable Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean) {
      return DisplayUtil.a(paramContext, 14.0F);
    }
    return DisplayUtil.a(paramContext, 6.0F);
  }
  
  @NotNull
  public int[] getPhysicalDisplaySize(@NotNull Activity paramActivity)
  {
    Intrinsics.checkParameterIsNotNull(paramActivity, "activity");
    Object localObject = paramActivity.getSystemService("window");
    if (localObject != null)
    {
      localObject = ((WindowManager)localObject).getDefaultDisplay();
      Point localPoint = new Point();
      int j;
      int i;
      if (Build.VERSION.SDK_INT >= 17)
      {
        ((Display)localObject).getRealSize(localPoint);
        j = localPoint.x;
        i = localPoint.y;
      }
      else if (Build.VERSION.SDK_INT >= 15)
      {
        ((Display)localObject).getSize(localPoint);
        j = localPoint.x;
        i = localPoint.y;
      }
      else
      {
        localObject = new DisplayMetrics();
        paramActivity = paramActivity.getWindowManager();
        Intrinsics.checkExpressionValueIsNotNull(paramActivity, "activity.windowManager");
        paramActivity.getDefaultDisplay().getMetrics((DisplayMetrics)localObject);
        j = ((DisplayMetrics)localObject).widthPixels;
        i = ((DisplayMetrics)localObject).heightPixels;
      }
      return new int[] { j, i };
    }
    throw new TypeCastException("null cannot be cast to non-null type android.view.WindowManager");
  }
  
  public int getRecentListReportVisibleItemCount()
  {
    return this.recentListReportVisibleItemCount;
  }
  
  public void setRecentListReportVisibleItemCount(int paramInt)
  {
    this.recentListReportVisibleItemCount = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.utils.api.impl.RIJDisplayStyleManagerImpl
 * JD-Core Version:    0.7.0.1
 */