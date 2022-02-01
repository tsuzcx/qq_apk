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
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawable;", "Lcom/tencent/xaction/api/IDecorDrawable;", "Lcom/tencent/xaction/api/IAnim;", "()V", "baseAnim", "Lcom/tencent/xaction/api/base/BaseAnim;", "getBaseAnim", "()Lcom/tencent/xaction/api/base/BaseAnim;", "setBaseAnim", "(Lcom/tencent/xaction/api/base/BaseAnim;)V", "decorState", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "getDecorState", "()Lcom/tencent/xaction/api/base/DecorDrawableState;", "setDecorState", "(Lcom/tencent/xaction/api/base/DecorDrawableState;)V", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "getDrawable", "()Lcom/tencent/xaction/api/IDrawable;", "setDrawable", "(Lcom/tencent/xaction/api/IDrawable;)V", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "id", "", "getId", "()I", "setId", "(I)V", "mData", "Lcom/tencent/xaction/api/data/ViewData;", "mirror", "", "getMirror", "()Z", "setMirror", "(Z)V", "tl", "Lcom/tencent/xaction/impl/XATimeline;", "getTl", "()Lcom/tencent/xaction/impl/XATimeline;", "setTl", "(Lcom/tencent/xaction/impl/XATimeline;)V", "clone", "doFrame", "", "frameTimeNanos", "", "doFrameUpdate", "animTime", "", "getStyle", "init", "view", "Landroid/view/View;", "play", "set", "setStyle", "viewData", "Companion", "XActionEngine_release"}, k=1, mv={1, 1, 16})
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
  private XAEngine engine;
  private int id;
  private transient ViewData mData;
  private boolean mirror;
  @Nullable
  private transient XATimeline tl;
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public static final IDrawable setDrawable(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull View paramView, boolean paramBoolean)
  {
    return Companion.a(paramXAEngine, paramInt1, paramInt2, paramView, paramBoolean);
  }
  
  @JvmStatic
  @RequiresApi(16)
  @Nullable
  public static final IDrawable setDrawable(@NotNull XAEngine paramXAEngine, int paramInt1, int paramInt2, @NotNull IView paramIView, boolean paramBoolean)
  {
    return Companion.a(paramXAEngine, paramInt1, paramInt2, paramIView, paramBoolean);
  }
  
  @JvmStatic
  @RequiresApi(16)
  public static final void setViewDrawable(int paramInt, @NotNull View paramView, @Nullable Drawable paramDrawable)
  {
    Companion.a(paramInt, paramView, paramDrawable);
  }
  
  @Nullable
  public IDrawable clone()
  {
    Object localObject2 = null;
    if ((getDrawable() == null) || (this.decorState == null)) {
      return null;
    }
    Object localObject1 = this.decorState;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    IDrawable localIDrawable = ((DecorDrawableState)localObject1).buildDrawable();
    localObject1 = localIDrawable.a();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    drawableCount += 1;
    ((DecorDrawable)localObject1).id = drawableCount;
    localObject1 = localIDrawable.a();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    ((DecorDrawable)localObject1).setDrawable(localIDrawable);
    localObject1 = localIDrawable.a();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    Object localObject3 = this.engine;
    if (localObject3 == null) {
      Intrinsics.throwNpe();
    }
    ((DecorDrawable)localObject1).tl = ((XAEngine)localObject3).createTimeLine();
    localObject1 = localIDrawable.a();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((DecorDrawable)localObject1).tl;
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject3 = ((XATimeline)localObject1).a();
    localObject1 = getDrawable();
    if (localObject1 == null) {
      Intrinsics.throwNpe();
    }
    localObject1 = ((IDrawable)localObject1).a();
    if (localObject1 != null) {}
    for (localObject1 = ((DecorDrawable)localObject1).tl;; localObject1 = null)
    {
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      ((TimeProp)localObject3).set(((XATimeline)localObject1).a());
      localObject1 = localIDrawable.a();
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject1 = ((DecorDrawable)localObject1).tl;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      localObject3 = localIDrawable.a();
      if (localObject3 == null) {
        Intrinsics.throwNpe();
      }
      ((XATimeline)localObject1).a((ITimeline)localObject3);
      localObject3 = localIDrawable.a();
      if (localObject3 != null)
      {
        localObject1 = getDrawable();
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        DecorDrawable localDecorDrawable = ((IDrawable)localObject1).a();
        localObject1 = localObject2;
        if (localDecorDrawable != null) {
          localObject1 = localDecorDrawable.mData;
        }
        if (localObject1 == null) {
          Intrinsics.throwNpe();
        }
        ((DecorDrawable)localObject3).mData = ((ViewData)localObject1);
      }
      return localIDrawable;
    }
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
  public final XAEngine getEngine()
  {
    return this.engine;
  }
  
  public final int getId()
  {
    return this.id;
  }
  
  public final boolean getMirror()
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
  
  public void init(@NotNull View paramView, @NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    this.engine = paramXAEngine;
    if (this.mData != null)
    {
      BaseAnim localBaseAnim = this.baseAnim;
      ViewData localViewData = this.mData;
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      localBaseAnim.setDelay(localViewData.getTp().getDelay());
      localBaseAnim = this.baseAnim;
      localViewData = this.mData;
      if (localViewData == null) {
        Intrinsics.throwNpe();
      }
      localBaseAnim.setDuration(localViewData.getTp().getDuration());
    }
    this.baseAnim.init(paramView, paramXAEngine);
  }
  
  public void play()
  {
    if (this.tl != null)
    {
      XATimeline localXATimeline = this.tl;
      if (localXATimeline != null) {
        localXATimeline.a();
      }
    }
  }
  
  public void set(@NotNull IDrawable paramIDrawable)
  {
    Intrinsics.checkParameterIsNotNull(paramIDrawable, "drawable");
    if (getDrawable() != null)
    {
      localObject = getDrawable();
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      if (((IDrawable)localObject).a() != null) {}
    }
    else
    {
      return;
    }
    Object localObject = getDrawable();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((IDrawable)localObject).a();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    DecorDrawable localDecorDrawable = paramIDrawable.a();
    if (localDecorDrawable == null) {
      Intrinsics.throwNpe();
    }
    ((DecorDrawable)localObject).decorState = localDecorDrawable.decorState;
    localObject = getDrawable();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    localObject = ((IDrawable)localObject).a();
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    paramIDrawable = paramIDrawable.a();
    if (paramIDrawable == null) {
      Intrinsics.throwNpe();
    }
    ((DecorDrawable)localObject).mirror = paramIDrawable.mirror;
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
  
  public final void setEngine(@Nullable XAEngine paramXAEngine)
  {
    this.engine = paramXAEngine;
  }
  
  public final void setId(int paramInt)
  {
    this.id = paramInt;
  }
  
  public final void setMirror(boolean paramBoolean)
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable
 * JD-Core Version:    0.7.0.1
 */