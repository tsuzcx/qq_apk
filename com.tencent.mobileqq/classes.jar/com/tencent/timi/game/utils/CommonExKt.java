package com.tencent.timi.game.utils;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.tencent.av.utils.UITools;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.router.ServiceCenter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"dp", "", "", "getDp", "(F)I", "(I)I", "dpf", "getDpf", "(F)F", "(I)F", "hostActivity", "Landroid/app/Activity;", "Landroid/view/View;", "getHostActivity", "(Landroid/view/View;)Landroid/app/Activity;", "setUrlSafety", "", "Lcom/tencent/image/URLImageView;", "url", "", "options", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "timi-game-impl_release"}, k=2, mv={1, 1, 16})
public final class CommonExKt
{
  public static final int a(int paramInt)
  {
    return (int)UITools.a((Context)BaseApplication.getContext(), paramInt);
  }
  
  @Nullable
  public static final Activity a(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "$this$hostActivity");
    View localView = paramView.getRootView();
    paramView = localView;
    if (!(localView instanceof ViewGroup)) {
      paramView = null;
    }
    paramView = (ViewGroup)paramView;
    if (paramView != null)
    {
      paramView = (FrameLayout)paramView.findViewById(16908290);
      if (paramView != null)
      {
        paramView = paramView.getChildAt(0);
        if (paramView != null)
        {
          paramView = paramView.getContext();
          break label65;
        }
      }
    }
    paramView = null;
    label65:
    localView = paramView;
    if (!(paramView instanceof Activity)) {
      localView = null;
    }
    return (Activity)localView;
  }
  
  public static final boolean a(@NotNull URLImageView paramURLImageView, @NotNull String paramString, @NotNull URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    Intrinsics.checkParameterIsNotNull(paramURLImageView, "$this$setUrlSafety");
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    Intrinsics.checkParameterIsNotNull(paramURLDrawableOptions, "options");
    int i;
    if (((CharSequence)paramString).length() > 0) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      try
      {
        paramURLImageView.setImageDrawable((Drawable)((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(paramString, paramURLDrawableOptions));
        return true;
      }
      catch (Exception paramURLImageView)
      {
        paramURLDrawableOptions = new StringBuilder();
        paramURLDrawableOptions.append("setUrlSafety failed, url:");
        paramURLDrawableOptions.append(paramString);
        Logger.a("URLImageView", paramURLDrawableOptions.toString(), (Throwable)paramURLImageView);
      }
    }
    return false;
  }
  
  public static final float b(int paramInt)
  {
    return UITools.a((Context)BaseApplication.getContext(), paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.CommonExKt
 * JD-Core Version:    0.7.0.1
 */