package com.tencent.xaction.anim;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.xaction.api.IDecorDrawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.base.BaseAnim;
import com.tencent.xaction.api.base.DecorDrawable;
import com.tencent.xaction.api.base.DecorDrawable.Companion;
import com.tencent.xaction.api.util.ScreenUnit;
import com.tencent.xaction.api.util.ScreenUnit.Companion;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/anim/Layer;", "Lcom/tencent/xaction/api/base/BaseAnim;", "()V", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "getDrawable", "()Lcom/tencent/xaction/api/IDrawable;", "setDrawable", "(Lcom/tencent/xaction/api/IDrawable;)V", "drawableId", "", "getDrawableId", "()I", "setDrawableId", "(I)V", "hierarchy", "getHierarchy", "setHierarchy", "playCtrl", "getPlayCtrl", "setPlayCtrl", "decorDrawable", "Lcom/tencent/xaction/api/IDecorDrawable;", "doFrameUpdate", "", "animTime", "", "end", "play", "preStart", "view", "Landroid/view/View;", "XActionCore_release"}, k=1, mv={1, 1, 16})
public final class Layer
  extends BaseAnim
{
  private int a = ScreenUnit.a.a();
  private int b;
  private int c;
  @Nullable
  private transient IDrawable d;
  
  private final IDecorDrawable a()
  {
    Object localObject = this.d;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if ((((IDrawable)localObject).getDecor() instanceof IDecorDrawable))
      {
        localObject = this.d;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((IDrawable)localObject).getDecor();
        if (localObject != null) {
          return (IDecorDrawable)localObject;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IDecorDrawable");
      }
    }
    return null;
  }
  
  public void doFrameUpdate(float paramFloat)
  {
    IDecorDrawable localIDecorDrawable = a();
    if (localIDecorDrawable != null) {
      localIDecorDrawable.doFrame(paramFloat);
    }
  }
  
  public void end()
  {
    if (this.c == 0)
    {
      IDecorDrawable localIDecorDrawable = a();
      if (localIDecorDrawable != null) {
        localIDecorDrawable.end();
      }
    }
  }
  
  public void play()
  {
    int i = this.c;
    Object localObject1;
    if ((i != 1) && (i != 0))
    {
      if (i == 2)
      {
        localObject1 = a();
        if (localObject1 != null) {
          ((IDecorDrawable)localObject1).stop();
        }
      }
    }
    else
    {
      localObject1 = getEngine();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((IXAEngine)localObject1).findDrawableById(this.a);
      if ((Build.VERSION.SDK_INT >= 16) && (getView() != null))
      {
        localObject1 = DecorDrawable.Companion;
        Object localObject2 = getEngine();
        if (localObject2 != null)
        {
          localObject2 = (XAEngine)localObject2;
          i = this.a;
          int j = this.b;
          View localView = getView();
          if (localView == null) {
            Intrinsics.throwNpe();
          }
          this.d = DecorDrawable.Companion.a((DecorDrawable.Companion)localObject1, (XAEngine)localObject2, i, j, localView, true, false, 32, null);
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
        }
      }
      localObject1 = a();
      if (localObject1 != null) {
        ((IDecorDrawable)localObject1).play();
      }
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    super.preStart(paramView);
    if (this.a == ScreenUnit.a.a()) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.anim.Layer
 * JD-Core Version:    0.7.0.1
 */