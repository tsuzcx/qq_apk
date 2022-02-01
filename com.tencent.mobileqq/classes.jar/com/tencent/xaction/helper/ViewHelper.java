package com.tencent.xaction.helper;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import androidx.annotation.RequiresApi;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/helper/ViewHelper;", "", "()V", "RADIUS_ALL", "", "RADIUS_BOTTOM", "RADIUS_LEFT", "RADIUS_RIGHT", "RADIUS_TOP", "removeView", "", "view", "Landroid/view/View;", "setViewOutline", "", "owner", "radius", "radiusSide", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class ViewHelper
{
  public static final ViewHelper a = new ViewHelper();
  
  @RequiresApi(api=21)
  public final void a(@NotNull View paramView, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "owner");
    paramView.setOutlineProvider((ViewOutlineProvider)new ViewHelper.setViewOutline.1(paramInt2, paramInt1));
    boolean bool;
    if (paramInt1 > 0) {
      bool = true;
    } else {
      bool = false;
    }
    paramView.setClipToOutline(bool);
    paramView.invalidate();
  }
  
  public final boolean a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if ((paramView.getParent() instanceof ViewGroup))
    {
      ViewParent localViewParent = paramView.getParent();
      if (localViewParent != null)
      {
        ((ViewGroup)localViewParent).removeView(paramView);
        return true;
      }
      throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.helper.ViewHelper
 * JD-Core Version:    0.7.0.1
 */