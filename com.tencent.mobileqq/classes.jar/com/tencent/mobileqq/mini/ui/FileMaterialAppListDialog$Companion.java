package com.tencent.mobileqq.mini.ui;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.widget.immersive.ImmersiveUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/mini/ui/FileMaterialAppListDialog$Companion;", "", "()V", "MIN_DISPLAY_ITEM_COUNT", "", "TAG", "", "calcContentHeight", "context", "Landroid/content/Context;", "itemCount", "getContentViewHeight", "", "qqmini_impl_release"}, k=1, mv={1, 1, 16})
public final class FileMaterialAppListDialog$Companion
{
  private final float calcContentHeight(Context paramContext, float paramFloat)
  {
    paramContext = paramContext.getResources();
    int i = paramContext.getDimensionPixelSize(2030174210);
    int j = paramContext.getDimensionPixelSize(2030174211);
    return paramFloat * i + j;
  }
  
  public final int getContentViewHeight(@NotNull Context paramContext, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    int i = ImmersiveUtils.getScreenHeight();
    int j = ImmersiveUtils.getStatusBarHeight(paramContext);
    int k = paramContext.getResources().getDimensionPixelSize(2030174208);
    Companion localCompanion = (Companion)this;
    float f = localCompanion.calcContentHeight(paramContext, 4.5F);
    return Math.min(i - (j + k), (int)Math.max(localCompanion.calcContentHeight(paramContext, paramInt), f));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.ui.FileMaterialAppListDialog.Companion
 * JD-Core Version:    0.7.0.1
 */