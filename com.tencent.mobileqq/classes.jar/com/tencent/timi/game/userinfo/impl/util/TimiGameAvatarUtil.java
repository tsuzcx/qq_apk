package com.tencent.timi.game.userinfo.impl.util;

import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Looper;
import android.view.View;
import android.widget.ImageView;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.timi.game.utils.DrawableUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/userinfo/impl/util/TimiGameAvatarUtil;", "", "()V", "acquireDrawableOptions", "Lcom/tencent/image/URLDrawable$URLDrawableOptions;", "avatarSize", "", "view", "Landroid/view/View;", "getAvatarSexDrawable", "Landroid/graphics/drawable/Drawable;", "gender", "", "getSexDrawable", "getTextColorBySex", "sex", "getViewDrawable", "resId", "setAvatarUrl", "", "avatarUrl", "imageView", "Landroid/widget/ImageView;", "setImageDrawable", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class TimiGameAvatarUtil
{
  public static final TimiGameAvatarUtil a = new TimiGameAvatarUtil();
  
  private final URLDrawable.URLDrawableOptions b(int paramInt, View paramView)
  {
    return DrawableUtil.a.a(paramInt, paramView, 2130853132);
  }
  
  private final void b(String paramString, ImageView paramImageView, int paramInt)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = b(paramInt, (View)paramImageView);
    DrawableUtil.a.a(paramString, paramImageView, localURLDrawableOptions);
  }
  
  public final int a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "sex");
    int i = paramString.hashCode();
    if (i != 22899)
    {
      if ((i == 30007) && (paramString.equals("男"))) {
        return Color.parseColor("#39b1f6");
      }
    }
    else if (paramString.equals("女")) {
      return Color.parseColor("#fc435d");
    }
    return Color.parseColor("#9c9ba6");
  }
  
  @Nullable
  public final Drawable a(int paramInt, @Nullable View paramView)
  {
    if (paramView != null)
    {
      paramView = paramView.getResources();
      if (paramView != null) {
        return paramView.getDrawable(paramInt);
      }
    }
    return null;
  }
  
  @Nullable
  public final Drawable a(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "gender");
    if (Intrinsics.areEqual(paramString, "男")) {
      return a(2130853135, paramView);
    }
    if (Intrinsics.areEqual(paramString, "女")) {
      return a(2130853136, paramView);
    }
    return null;
  }
  
  public final void a(@Nullable String paramString, @Nullable ImageView paramImageView, int paramInt)
  {
    if (paramString != null)
    {
      if (paramString.length() == 0) {
        return;
      }
      if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper()))
      {
        b(paramString, paramImageView, paramInt);
        return;
      }
      ThreadManager.getUIHandler().post((Runnable)new TimiGameAvatarUtil.setAvatarUrl.1(paramString, paramImageView, paramInt));
    }
  }
  
  @Nullable
  public final Drawable b(@NotNull View paramView, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramString, "gender");
    if (Intrinsics.areEqual(paramString, "男")) {
      return a(2130853131, paramView);
    }
    if (Intrinsics.areEqual(paramString, "女")) {
      return a(2130853130, paramView);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.userinfo.impl.util.TimiGameAvatarUtil
 * JD-Core Version:    0.7.0.1
 */