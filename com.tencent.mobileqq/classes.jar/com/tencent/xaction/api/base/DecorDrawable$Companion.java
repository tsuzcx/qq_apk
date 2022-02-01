package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.impl.XAEngine;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawable$Companion;", "", "()V", "drawableCount", "", "getDrawableCount", "()I", "setDrawableCount", "(I)V", "getCloneDrawable", "Lcom/tencent/xaction/api/IDrawable;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "drawableId", "isClone", "", "view", "Landroid/view/View;", "setDrawable", "hierarchy", "iView", "Lcom/tencent/xaction/api/IView;", "setViewDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "XActionEngine_release"}, k=1, mv={1, 1, 16})
public final class DecorDrawable$Companion
{
  private final IDrawable a(XAEngine paramXAEngine, int paramInt, boolean paramBoolean, View paramView)
  {
    IDrawable localIDrawable = paramXAEngine.findDrawableById(paramInt);
    if (((localIDrawable instanceof IDrawable)) && (paramBoolean))
    {
      Object localObject = localIDrawable.a();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((DecorDrawable)localObject).clone();
      if (localObject != null)
      {
        DecorDrawable localDecorDrawable = ((IDrawable)localObject).a();
        if (localDecorDrawable != null) {
          localDecorDrawable.init(paramView, paramXAEngine);
        }
      }
      if (localObject != null)
      {
        paramXAEngine = ((IDrawable)localObject).a();
        if (paramXAEngine != null)
        {
          paramView = paramXAEngine.getBaseAnim();
          if (paramView != null)
          {
            paramXAEngine = localIDrawable.a();
            if (paramXAEngine == null) {
              break label146;
            }
            paramXAEngine = paramXAEngine.getBaseAnim();
            if (paramXAEngine == null) {
              break label146;
            }
          }
        }
      }
      label146:
      for (paramXAEngine = Integer.valueOf(paramXAEngine.getDuration());; paramXAEngine = null)
      {
        if (paramXAEngine == null) {
          Intrinsics.throwNpe();
        }
        paramView.setDuration(paramXAEngine.intValue());
        return localObject;
      }
    }
    return localIDrawable;
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public final IDrawable a(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull View paramView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    paramXAEngine = ((Companion)this).a(paramXAEngine, paramInt1, paramBoolean, paramView);
    if ((paramXAEngine instanceof Drawable)) {
      ((Companion)this).a(paramInt2, paramView, (Drawable)paramXAEngine);
    }
    return paramXAEngine;
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public final IDrawable a(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull IView paramIView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iView");
    View localView = paramIView.a().a();
    if (localView == null) {
      Intrinsics.throwNpe();
    }
    paramXAEngine = ((Companion)this).a(paramXAEngine, paramInt1, paramBoolean, localView);
    if ((paramXAEngine instanceof Drawable))
    {
      ((Companion)this).a(paramInt2, localView, (Drawable)paramXAEngine);
      paramIView.a().a((Drawable)paramXAEngine);
    }
    return paramXAEngine;
  }
  
  @JvmStatic
  @RequiresApi(16)
  public final void a(int paramInt, @NotNull View paramView, @Nullable Drawable paramDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (paramInt == 0) {
      paramView.setBackground(paramDrawable);
    }
    do
    {
      return;
      if (paramInt == 1)
      {
        if (Build.VERSION.SDK_INT >= 23)
        {
          paramView.setForeground(paramDrawable);
          return;
        }
        paramView.setBackground(paramDrawable);
        return;
      }
    } while (paramInt != 2);
    paramView.setBackground(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable.Companion
 * JD-Core Version:    0.7.0.1
 */