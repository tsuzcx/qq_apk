package com.tencent.xaction.api.base;

import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.Keep;
import androidx.annotation.RequiresApi;
import com.tencent.xaction.api.IDecorDrawable;
import com.tencent.xaction.api.IDrawable;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.ITimeline;
import com.tencent.xaction.api.IView;
import com.tencent.xaction.api.data.TimeProp;
import com.tencent.xaction.api.data.ViewData;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.openapi.api.IPublicDecorDrawable;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/DecorDrawable;", "Lcom/tencent/xaction/api/base/BaseAnim;", "Lcom/tencent/xaction/api/IDecorDrawable;", "()V", "decorState", "Lcom/tencent/xaction/api/base/DecorDrawableState;", "getDecorState", "()Lcom/tencent/xaction/api/base/DecorDrawableState;", "setDecorState", "(Lcom/tencent/xaction/api/base/DecorDrawableState;)V", "drawable", "Lcom/tencent/xaction/api/IDrawable;", "getDrawable", "()Lcom/tencent/xaction/api/IDrawable;", "setDrawable", "(Lcom/tencent/xaction/api/IDrawable;)V", "id", "", "getId", "()I", "setId", "(I)V", "mData", "Lcom/tencent/xaction/api/data/ViewData;", "mirror", "", "getMirror", "()Z", "setMirror", "(Z)V", "tl", "Lcom/tencent/xaction/impl/XATimeline;", "getTl", "()Lcom/tencent/xaction/impl/XATimeline;", "setTl", "(Lcom/tencent/xaction/impl/XATimeline;)V", "cloneDrawable", "getStyle", "init", "", "view", "Landroid/view/View;", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "play", "preStart", "set", "setStyle", "viewData", "stop", "Companion", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class DecorDrawable
  extends BaseAnim
  implements IDecorDrawable
{
  public static final DecorDrawable.Companion Companion = new DecorDrawable.Companion(null);
  private static int drawableCount = 65536;
  @Nullable
  private transient DecorDrawableState decorState;
  @Nullable
  private transient IDrawable drawable;
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
  public final IDrawable cloneDrawable()
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
            Object localObject3 = getEngine();
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
    setEngine(paramIXAEngine);
    Object localObject = this.mData;
    if (localObject != null)
    {
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      setDelay(((ViewData)localObject).getTp().getDelay());
      localObject = this.mData;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      setDuration(((ViewData)localObject).getTp().getDuration());
      localObject = this.mData;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      localObject = ((ViewData)localObject).getRules();
      if (localObject != null) {
        setRules((HashMap)localObject);
      }
    }
    super.init(paramView, paramIXAEngine);
  }
  
  public void play()
  {
    XATimeline localXATimeline = this.tl;
    if ((localXATimeline != null) && (localXATimeline != null)) {
      localXATimeline.c();
    }
  }
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Iterator localIterator = ((Map)getRules()).entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      paramView = getEngine();
      if (paramView != null) {
        paramView = paramView.getRuleManager();
      } else {
        paramView = null;
      }
      if (paramView != null)
      {
        paramView = (IRuleManager)paramView;
        ViewData localViewData = this.mData;
        if (localViewData == null) {
          Intrinsics.throwNpe();
        }
        paramView.refreshAnimRuleValue(localViewData, (String)localEntry.getKey(), (String)localEntry.getValue());
      }
      else
      {
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IRuleManager");
      }
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
  
  public final void setDecorState(@Nullable DecorDrawableState paramDecorDrawableState)
  {
    this.decorState = paramDecorDrawableState;
  }
  
  public void setDrawable(@Nullable IDrawable paramIDrawable)
  {
    this.drawable = paramIDrawable;
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
  
  public void stop() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xaction.api.base.DecorDrawable
 * JD-Core Version:    0.7.0.1
 */