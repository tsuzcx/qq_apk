package com.tencent.xaction.helper;

import android.annotation.TargetApi;
import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/xaction/helper/ViewHelper$setViewOutline$1", "Landroid/view/ViewOutlineProvider;", "getOutline", "", "view", "Landroid/view/View;", "outline", "Landroid/graphics/Outline;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ViewHelper$setViewOutline$1
  extends ViewOutlineProvider
{
  ViewHelper$setViewOutline$1(int paramInt1, int paramInt2) {}
  
  @TargetApi(21)
  public void getOutline(@NotNull View paramView, @NotNull Outline paramOutline)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramOutline, "outline");
    int j = paramView.getWidth();
    int i = paramView.getHeight();
    if (j != 0)
    {
      if (i == 0) {
        return;
      }
      int n = this.a;
      if (n != 0)
      {
        if (n == 1)
        {
          m = j + this.b;
          k = i;
        }
        label116:
        do
        {
          j = m;
          i = k;
          for (k = 0;; k = 0 - this.b)
          {
            m = 0;
            break label140;
            if (n == 2)
            {
              k = i + this.b;
              m = j;
              break;
            }
            if (n != 3) {
              break label116;
            }
          }
          m = j;
          k = i;
        } while (n != 4);
        int m = 0 - this.b;
        k = 0;
        label140:
        paramOutline.setRoundRect(k, m, j, i, this.b);
        return;
      }
      int k = this.b;
      if (k <= 0)
      {
        paramOutline.setRect(0, 0, j, i);
        return;
      }
      paramOutline.setRoundRect(0, 0, j, i, k);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.helper.ViewHelper.setViewOutline.1
 * JD-Core Version:    0.7.0.1
 */