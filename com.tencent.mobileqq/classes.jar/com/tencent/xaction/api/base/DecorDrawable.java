package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IDecorDrawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawable;", "Lcom/tencent/xaction/api/IDecorDrawable;", "Lcom/tencent/xaction/api/IAnim;", "()V", "baseAnim", "Lcom/tencent/xaction/api/base/BaseAnim;", "getBaseAnim", "()Lcom/tencent/xaction/api/base/BaseAnim;", "setBaseAnim", "(Lcom/tencent/xaction/api/base/BaseAnim;)V", "decorState", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "getDecorState", "()Lcom/tencent/xaction/api/base/DecorDrawableState;", "setDecorState", "(Lcom/tencent/xaction/api/base/DecorDrawableState;)V", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "getDrawable", "()Lcom/tencent/xaction/api/IDrawable;", "setDrawable", "(Lcom/tencent/xaction/api/IDrawable;)V", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "id", "", "getId", "()I", "setId", "(I)V", "mData", "Lcom/tencent/xaction/api/data/ViewData;", "mirror", "", "getMirror", "()Z", "setMirror", "(Z)V", "tl", "Lcom/tencent/xaction/impl/XATimeline;", "getTl", "()Lcom/tencent/xaction/impl/XATimeline;", "setTl", "(Lcom/tencent/xaction/impl/XATimeline;)V", "clone", "doFrame", "", "frameTimeNanos", "", "doFrameUpdate", "animTime", "", "getStyle", "init", "view", "Landroid/view/View;", "play", "set", "setStyle", "viewData", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class DecorDrawable
  implements IAnim, IDecorDrawable
{
  public static final DecorDrawable.Companion Companion = new DecorDrawable.Companion(null);
  private static int drawableCount = 65536;
  @NotNull
  private transient BaseAnim baseAnim = (BaseAnim)new DecorDrawable.baseAnim.1(this);
  @Nullable
  private transient DecorDrawableState decorState;
  @Nullable
  private transient IDrawable drawable;
  @Nullable
  private IXAEngine engine;
  private int id;
  private transient ViewData mData;
  private boolean mirror;
  @Nullable
  private transient XATimeline tl;
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public static final IDrawable setDrawable(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull View paramView, boolean paramBoolean1, boolean paramBoolean2)
  {
    return Companion.a(paramXAEngine, paramInt1, paramInt2, paramView, paramBoolean1, paramBoolean2);
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public static final IDrawable setDrawable(@NotNull XAEngine paramXAEngine, int paramInt, @NotNull IView paramIView, boolean paramBoolean)
  {
    return Companion.a(paramXAEngine, paramInt, paramIView, paramBoolean);
  }
  
  @JvmStatic
  @RequiresApi(16)
  public static final void setViewDrawable(int paramInt, @NotNull View paramView, @Nullable Drawable paramDrawable, boolean paramBoolean)
  {
    Companion.a(paramInt, paramView, paramDrawable, paramBoolean);
  }
  
  @Nullable
  public IDrawable clone()
  {
    if (getDrawable() != null)
    {
      Object localObject1 = this.decorState;
      if (localObject1 != null)
      {
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        localObject1 = ((DecorDrawableState)localObject1).buildDrawable();
        if ((((IDrawable)localObject1).getDecor() instanceof DecorDrawable))
        {
          Object localObject2 = ((IDrawable)localObject1).getDecor();
          if (localObject2 != null)
          {
            localObject2 = (DecorDrawable)localObject2;
            drawableCount += 1;
            ((DecorDrawable)localObject2).id = drawableCount;
            ((DecorDrawable)localObject2).setDrawable((IDrawable)localObject1);
            Object localObject3 = this.engine;
            if (localObject3 != null)
            {
              ((DecorDrawable)localObject2).tl = ((XAEngine)localObject3).createTimeLine();
              localObject3 = ((DecorDrawable)localObject2).tl;
              if (localObject3 == null) {
                Intrinsics.throwNpe();
              }
              localObject3 = ((XATimeline)localObject3).a();
              Object localObject4 = getDrawable();
              if (localObject4 == null) {
                Intrinsics.throwNpe();
              }
              localObject4 = ((IDrawable)localObject4).getDecor();
              if (localObject4 != null)
              {
                localObject4 = ((DecorDrawable)localObject4).tl;
                if (localObject4 == null) {
                  Intrinsics.throwNpe();
                }
                ((TimeProp)localObject3).set(((XATimeline)localObject4).a());
                localObject3 = ((DecorDrawable)localObject2).tl;
                if (localObject3 == null) {
                  Intrinsics.throwNpe();
                }
                ((XATimeline)localObject3).a((ITimeline)localObject2);
                localObject3 = getDrawable();
                if (localObject3 == null) {
                  Intrinsics.throwNpe();
                }
                localObject3 = ((IDrawable)localObject3).getDecor();
                if (localObject3 != null)
                {
                  localObject3 = ((DecorDrawable)localObject3).mData;
                  if (localObject3 == null) {
                    Intrinsics.throwNpe();
                  }
                  ((DecorDrawable)localObject2).mData = ((ViewData)localObject3);
                  return localObject1;
                }
                throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
              }
              throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
            }
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.impl.XAEngine");
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
        }
        return localObject1;
      }
    }
    return null;
  }
  
  public void doFrame(long paramLong)
  {
    this.baseAnim.doFrame(paramLong);
  }
  
  public abstract void doFrameUpdate(float paramFloat);
  
  @NotNull
  public final BaseAnim getBaseAnim()
  {
    return this.baseAnim;
  }
  
  @Nullable
  public final DecorDrawableState getDecorState()
  {
    return this.decorState;
  }
  
  @Nullable
  public IDrawable getDrawable()
  {
    return this.drawable;
  }
  
  @Nullable
  public final IXAEngine getEngine()
  {
    return this.engine;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public boolean getMirror()
  {
    return this.mirror;
  }
  
  @Nullable
  public ViewData getStyle()
  {
    return this.mData;
  }
  
  @Nullable
  public final XATimeline getTl()
  {
    return this.tl;
  }
  
  public void init(@NotNull View paramView, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    this.engine = paramIXAEngine;
    Object localObject1 = this.mData;
    if (localObject1 != null)
    {
      Object localObject2 = this.baseAnim;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((BaseAnim)localObject2).setDelay(((ViewData)localObject1).getTp().getDelay());
      localObject1 = this.baseAnim;
      localObject2 = this.mData;
      if (localObject2 == null) {
        Intrinsics.throwNpe();
      }
      ((BaseAnim)localObject1).setDuration(((ViewData)localObject2).getTp().getDuration());
    }
    this.baseAnim.init(paramView, paramIXAEngine);
  }
  
  public void play()
  {
    XATimeline localXATimeline = this.tl;
    if ((localXATimeline != null) && (localXATimeline != null)) {
      localXATimeline.a();
    }
  }
  
  public void set(@NotNull IDrawable paramIDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIDrawable, "drawable");
    if (getDrawable() != null)
    {
      Object localObject = getDrawable();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((IDrawable)localObject).getDecor() == null) {
        return;
      }
      localObject = getDrawable();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if ((((IDrawable)localObject).getDecor() instanceof DecorDrawable))
      {
        localObject = getDrawable();
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        localObject = ((IDrawable)localObject).getDecor();
        if (localObject != null)
        {
          localObject = (DecorDrawable)localObject;
          IPublicDecorDrawable localIPublicDecorDrawable = paramIDrawable.getDecor();
          if (localIPublicDecorDrawable != null) {
            ((DecorDrawable)localObject).decorState = ((DecorDrawable)localIPublicDecorDrawable).decorState;
          } else {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
          }
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorDrawable");
        }
      }
      localObject = getDrawable();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((IDrawable)localObject).getDecor();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      paramIDrawable = paramIDrawable.getDecor();
      if (paramIDrawable == null) {
        Intrinsics.throwNpe();
      }
      ((IPublicDecorDrawable)localObject).setMirror(paramIDrawable.getMirror());
    }
  }
  
  public final void setBaseAnim(@NotNull BaseAnim paramBaseAnim)
  {
    Intrinsics.checkParameterIsNotNull(paramBaseAnim, "<set-?>");
    this.baseAnim = paramBaseAnim;
  }
  
  public final void setDecorState(@Nullable DecorDrawableState paramDecorDrawableState)
  {
    this.decorState = paramDecorDrawableState;
  }
  
  public void setDrawable(@Nullable IDrawable paramIDrawable)
  {
    this.drawable = paramIDrawable;
  }
  
  public final void setEngine(@Nullable IXAEngine paramIXAEngine)
  {
    this.engine = paramIXAEngine;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public void setMirror(boolean paramBoolean)
  {
    this.mirror = paramBoolean;
  }
  
  public void setStyle(@NotNull ViewData paramViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramViewData, "viewData");
    this.mData = paramViewData;
    this.tl = paramViewData.getTl();
  }
  
  public final void setTl(@Nullable XATimeline paramXATimeline)
  {
    this.tl = paramXATimeline;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable
 * JD-Core Version:    0.7.0.1
 */