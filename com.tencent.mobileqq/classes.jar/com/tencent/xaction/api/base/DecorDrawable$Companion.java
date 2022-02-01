package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.View;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.IDecorView;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.api.style.Style;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawable$Companion;", "", "()V", "drawableCount", "", "getDrawableCount", "()I", "setDrawableCount", "(I)V", "getCloneDrawable", "Lcom/tencent/xaction/api/IDrawable;", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "drawableId", "isClone", "", "view", "Landroid/view/View;", "setDrawable", "iView", "Lcom/tencent/xaction/api/IView;", "hierarchy", "isLayer", "setViewDrawable", "", "drawable", "Landroid/graphics/drawable/Drawable;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class DecorDrawable$Companion
{
  private final IDrawable a(XAEngine paramXAEngine, int paramInt, boolean paramBoolean, View paramView)
  {
    Object localObject = paramXAEngine.findDrawableById(paramInt);
    if (((localObject instanceof IDrawable)) && (paramBoolean))
    {
      localObject = ((IDrawable)localObject).getDecor();
      if (localObject != null)
      {
        DecorDrawable localDecorDrawable = (DecorDrawable)localObject;
        IDrawable localIDrawable = localDecorDrawable.cloneDrawable();
        if (localIDrawable != null) {
          localObject = localIDrawable.getDecor();
        } else {
          localObject = null;
        }
        if ((localObject instanceof DecorDrawable))
        {
          localObject = localIDrawable.getDecor();
          if (localObject != null)
          {
            localObject = (DecorDrawable)localObject;
            ((DecorDrawable)localObject).init(paramView, (IXAEngine)paramXAEngine);
            ((DecorDrawable)localObject).setDuration(localDecorDrawable.getDuration());
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
          }
        }
        return localIDrawable;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
    }
    return localObject;
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public final IDrawable a(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Companion localCompanion = (Companion)this;
    paramXAEngine = localCompanion.a(paramXAEngine, paramInt1, paramBoolean1, paramView);
    if ((paramXAEngine instanceof Drawable)) {
      localCompanion.a(paramInt2, paramView, (Drawable)paramXAEngine, paramBoolean2);
    }
    return paramXAEngine;
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public final IDrawable a(@NotNull XAEngine paramXAEngine, int paramInt, @NotNull IView paramIView, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    Intrinsics.checkParameterIsNotNull(paramIView, "iView");
    View localView = paramIView.getDecor().b();
    if (localView == null) {
      Intrinsics.throwNpe();
    }
    Companion localCompanion = (Companion)this;
    paramXAEngine = localCompanion.a(paramXAEngine, paramInt, paramBoolean, localView);
    if ((paramXAEngine instanceof Drawable))
    {
      Object localObject = paramIView.getDecor().getStyle();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramInt = ((ViewData)localObject).getSt().getHierarchy();
      localObject = (Drawable)paramXAEngine;
      localCompanion.a(paramInt, localView, (Drawable)localObject, false);
      paramIView.getDecor().setDrawable((Drawable)localObject);
    }
    return paramXAEngine;
  }
  
  @JvmStatic
  @RequiresApi(16)
  public final void a(int paramInt, @NotNull View paramView, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    if (paramInt == 0)
    {
      if (paramBoolean)
      {
        if (paramDrawable != null)
        {
          Drawable localDrawable = paramView.getBackground();
          Intrinsics.checkExpressionValueIsNotNull(localDrawable, "view.background");
          paramView.setBackground((Drawable)new LayerDrawable(new Drawable[] { localDrawable, paramDrawable }));
        }
      }
      else {
        paramView.setBackground(paramDrawable);
      }
    }
    else if (paramInt == 1)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        paramView.setForeground(paramDrawable);
        return;
      }
      paramView.setBackground(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable.Companion
 * JD-Core Version:    0.7.0.1
 */