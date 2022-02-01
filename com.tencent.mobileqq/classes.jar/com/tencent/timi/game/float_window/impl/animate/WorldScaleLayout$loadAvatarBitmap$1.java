package com.tencent.timi.game.float_window.impl.animate;

import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/timi/game/float_window/impl/animate/WorldScaleLayout$loadAvatarBitmap$1", "Lcom/tencent/image/URLDrawable$URLDrawableListener;", "onLoadCanceled", "", "urlDrawable", "Lcom/tencent/image/URLDrawable;", "onLoadFialed", "throwable", "", "onLoadProgressed", "i", "", "onLoadSuccessed", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class WorldScaleLayout$loadAvatarBitmap$1
  implements URLDrawable.URLDrawableListener
{
  WorldScaleLayout$loadAvatarBitmap$1(URLDrawable paramURLDrawable, WorldScaleLayout.AvatarListener paramAvatarListener) {}
  
  public void onLoadCanceled(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
  }
  
  public void onLoadFialed(@NotNull URLDrawable paramURLDrawable, @NotNull Throwable paramThrowable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    Intrinsics.checkParameterIsNotNull(paramThrowable, "throwable");
    this.b.a();
  }
  
  public void onLoadProgressed(@NotNull URLDrawable paramURLDrawable, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
  }
  
  public void onLoadSuccessed(@NotNull URLDrawable paramURLDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramURLDrawable, "urlDrawable");
    paramURLDrawable = this.a;
    Intrinsics.checkExpressionValueIsNotNull(paramURLDrawable, "drawable");
    paramURLDrawable = paramURLDrawable.getCurrDrawable();
    if ((paramURLDrawable instanceof RegionDrawable))
    {
      paramURLDrawable = ((RegionDrawable)paramURLDrawable).getBitmap();
      if (paramURLDrawable != null)
      {
        this.b.a(paramURLDrawable);
        return;
      }
    }
    this.b.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.float_window.impl.animate.WorldScaleLayout.loadAvatarBitmap.1
 * JD-Core Version:    0.7.0.1
 */