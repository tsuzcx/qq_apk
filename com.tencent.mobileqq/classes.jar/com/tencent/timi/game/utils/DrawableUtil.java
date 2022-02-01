package com.tencent.timi.game.utils;

import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.timi.game.image.api.IDrawableService;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.ui.utils.ResUtils;
import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/utils/DrawableUtil;", "", "()V", "acquireDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "avatarSize", "", "view", "Landroid/view/View;", "defaultId", "setImageDrawable", "", "avatarUrl", "", "imageView", "Landroid/widget/ImageView;", "option", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class DrawableUtil
{
  public static final DrawableUtil a = new DrawableUtil();
  
  @Nullable
  public final URLDrawable.URLDrawableOptions a(int paramInt1, int paramInt2)
  {
    Drawable localDrawable = ResUtils.a(paramInt2);
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = localDrawable;
    localURLDrawableOptions.mFailedDrawable = localDrawable;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt1;
    return localURLDrawableOptions;
  }
  
  @Nullable
  public final URLDrawable.URLDrawableOptions a(int paramInt1, @Nullable View paramView, int paramInt2)
  {
    if (paramInt2 != 0)
    {
      if (paramView != null)
      {
        paramView = paramView.getResources();
        if (paramView != null)
        {
          paramView = paramView.getDrawable(paramInt2);
          break label43;
        }
      }
      paramView = null;
    }
    else
    {
      paramView = (Drawable)new ColorDrawable(0);
    }
    label43:
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramView;
    localURLDrawableOptions.mFailedDrawable = paramView;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt1;
    return localURLDrawableOptions;
  }
  
  public final void a(@Nullable String paramString, @Nullable ImageView paramImageView, @Nullable URLDrawable.URLDrawableOptions paramURLDrawableOptions)
  {
    if (paramImageView != null) {
      try
      {
        paramImageView.setImageDrawable((Drawable)((IDrawableService)ServiceCenter.a(IDrawableService.class)).a(paramString, paramURLDrawableOptions));
        return;
      }
      catch (Exception paramString)
      {
        paramImageView = new StringBuilder();
        paramImageView.append("setImageDrawable error ");
        paramImageView.append(paramString);
        Logger.c("DrawableUtil", paramImageView.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.utils.DrawableUtil
 * JD-Core Version:    0.7.0.1
 */