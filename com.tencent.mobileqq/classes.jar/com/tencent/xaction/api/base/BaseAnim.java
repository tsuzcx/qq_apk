package com.tencent.xaction.api.base;

import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.api.data.InterpolatorData;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.Expression;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.manager.InterpolatorManager;
import com.tencent.xaction.manager.InterpolatorManager.Companion;
import com.tencent.xaction.openapi.api.IPublicView;
import com.tencent.xaction.openapi.api.IXAEngine;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/BaseAnim;", "Lcom/tencent/xaction/api/IAnim;", "", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "engine", "Lcom/tencent/xaction/openapi/api/IXAEngine;", "getEngine", "()Lcom/tencent/xaction/openapi/api/IXAEngine;", "setEngine", "(Lcom/tencent/xaction/openapi/api/IXAEngine;)V", "expressionList", "Ljava/util/HashMap;", "", "Lcom/tencent/xaction/impl/Expression;", "Lkotlin/collections/HashMap;", "getExpressionList", "()Ljava/util/HashMap;", "setExpressionList", "(Ljava/util/HashMap;)V", "exps", "getExps", "setExps", "float", "getFloat", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "floatData", "Lcom/tencent/xaction/api/data/FloatViewData;", "getFloatData", "()Lcom/tencent/xaction/api/data/FloatViewData;", "setFloatData", "(Lcom/tencent/xaction/api/data/FloatViewData;)V", "forward", "", "getForward", "()Z", "setForward", "(Z)V", "inpt", "Lcom/tencent/xaction/api/data/InterpolatorData;", "getInpt", "()Lcom/tencent/xaction/api/data/InterpolatorData;", "setInpt", "(Lcom/tencent/xaction/api/data/InterpolatorData;)V", "interpolator", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "isFirst", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setFirst", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "isLink", "setLink", "last", "getLast", "setLast", "removeIds", "", "getRemoveIds", "()[Ljava/lang/Integer;", "setRemoveIds", "([Ljava/lang/Integer;)V", "[Ljava/lang/Integer;", "rules", "getRules", "setRules", "status", "getStatus", "setStatus", "type", "getType", "setType", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "animStateListener", "", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "it", "clone", "doFrame", "frameTime", "doFrameUpdate", "animTime", "", "end", "init", "play", "preStart", "removeViewWhenEnd", "XActionCore_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class BaseAnim
  implements IAnim, Cloneable
{
  private long delay;
  private int duration;
  @Nullable
  private transient IXAEngine engine;
  @NotNull
  private transient HashMap<String, Expression> expressionList = new HashMap();
  @NotNull
  private HashMap<String, String> exps = new HashMap();
  @Nullable
  private String jdField_float;
  @NotNull
  private transient FloatViewData floatData = new FloatViewData();
  private boolean forward = true;
  @Nullable
  private InterpolatorData inpt;
  @Nullable
  private transient Interpolator interpolator;
  @NotNull
  private transient AtomicBoolean isFirst = new AtomicBoolean(true);
  private boolean isLink = true;
  private boolean last;
  @Nullable
  private Integer[] removeIds;
  @NotNull
  private HashMap<String, String> rules = new HashMap();
  @NotNull
  private String status = "";
  @NotNull
  private String type = "";
  @Nullable
  private transient View view;
  
  private final void removeViewWhenEnd()
  {
    Integer[] arrayOfInteger = this.removeIds;
    if (arrayOfInteger != null)
    {
      int j = arrayOfInteger.length;
      int i = 0;
      while (i < j)
      {
        int k = ((Number)arrayOfInteger[i]).intValue();
        Object localObject1 = this.engine;
        if (localObject1 != null) {
          localObject1 = ((IXAEngine)localObject1).findById(k);
        } else {
          localObject1 = null;
        }
        Object localObject2;
        if (localObject1 != null) {
          localObject2 = ((IPublicView)localObject1).getDecor();
        } else {
          localObject2 = null;
        }
        if ((localObject2 instanceof DecorView))
        {
          localObject1 = ((IPublicView)localObject1).getDecor();
          if (localObject1 != null)
          {
            localObject2 = ((DecorView)localObject1).getProxy();
            if (localObject2 != null) {
              localObject1 = ((View)localObject2).getParent();
            } else {
              localObject1 = null;
            }
            if ((localObject1 instanceof ViewGroup))
            {
              localObject1 = ((View)localObject2).getParent();
              if (localObject1 != null) {
                ((ViewGroup)localObject1).removeView((View)localObject2);
              } else {
                throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
              }
            }
          }
          else
          {
            throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.DecorView");
          }
        }
        i += 1;
      }
    }
    this.removeIds = ((Integer[])null);
  }
  
  public final void animStateListener(@NotNull XATimeline paramXATimeline, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramXATimeline, "timeline");
    paramXATimeline.a((AnimStateListener)new BaseAnim.animStateListener.1(this, paramView));
  }
  
  @NotNull
  public BaseAnim clone()
  {
    Object localObject1 = super.clone();
    if (localObject1 != null)
    {
      localObject1 = (BaseAnim)localObject1;
      Object localObject2 = this.rules.clone();
      if (localObject2 != null)
      {
        ((BaseAnim)localObject1).rules = ((HashMap)localObject2);
        ((BaseAnim)localObject1).isFirst = new AtomicBoolean(true);
        ((BaseAnim)localObject1).floatData = new FloatViewData();
        return localObject1;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.BaseAnim");
  }
  
  public void doFrame(long paramLong)
  {
    paramLong -= this.delay;
    if ((this.duration >= paramLong) && (paramLong >= 0L))
    {
      if ((this.isFirst.get()) && (this.last))
      {
        localObject = this.view;
        if (localObject != null)
        {
          if (localObject == null) {
            Intrinsics.throwNpe();
          }
          preStart((View)localObject);
        }
      }
      float f2 = (float)paramLong * 1.0F / this.duration;
      Object localObject = this.interpolator;
      float f1 = f2;
      if (localObject != null)
      {
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        f1 = ((Interpolator)localObject).getInterpolation(f2);
      }
      this.isFirst.set(false);
      doFrameUpdate(f1);
      return;
    }
    if ((!this.isFirst.get()) && (this.duration < paramLong))
    {
      doFrameUpdate(1.0F);
      this.isFirst.set(true);
      end();
      removeViewWhenEnd();
    }
  }
  
  public abstract void doFrameUpdate(float paramFloat);
  
  public void end() {}
  
  public final long getDelay()
  {
    return this.delay;
  }
  
  public final int getDuration()
  {
    return this.duration;
  }
  
  @Nullable
  public final IXAEngine getEngine()
  {
    return this.engine;
  }
  
  @NotNull
  public final HashMap<String, Expression> getExpressionList()
  {
    return this.expressionList;
  }
  
  @NotNull
  public final HashMap<String, String> getExps()
  {
    return this.exps;
  }
  
  @Nullable
  public final String getFloat()
  {
    return this.jdField_float;
  }
  
  @NotNull
  public final FloatViewData getFloatData()
  {
    return this.floatData;
  }
  
  public final boolean getForward()
  {
    return this.forward;
  }
  
  @Nullable
  public final InterpolatorData getInpt()
  {
    return this.inpt;
  }
  
  @Nullable
  public final Interpolator getInterpolator()
  {
    return this.interpolator;
  }
  
  public final boolean getLast()
  {
    return this.last;
  }
  
  @Nullable
  public final Integer[] getRemoveIds()
  {
    return this.removeIds;
  }
  
  @NotNull
  public final HashMap<String, String> getRules()
  {
    return this.rules;
  }
  
  @NotNull
  public final String getStatus()
  {
    return this.status;
  }
  
  @NotNull
  public final String getType()
  {
    return this.type;
  }
  
  @Nullable
  public final View getView()
  {
    return this.view;
  }
  
  public final void init(@NotNull View paramView, @NotNull IXAEngine paramIXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramIXAEngine, "engine");
    this.engine = paramIXAEngine;
    preStart(paramView);
    this.expressionList.clear();
    paramView = ((Map)this.exps).entrySet().iterator();
    while (paramView.hasNext())
    {
      paramIXAEngine = (Map.Entry)paramView.next();
      Expression localExpression = new Expression(null);
      localExpression.a((String)paramIXAEngine.getValue());
      ((Map)this.expressionList).put(paramIXAEngine.getKey(), localExpression);
    }
  }
  
  @NotNull
  public final AtomicBoolean isFirst()
  {
    return this.isFirst;
  }
  
  public final boolean isLink()
  {
    return this.isLink;
  }
  
  public void play() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.view = paramView;
    this.isFirst.set(true);
    Object localObject1;
    if (this.inpt != null)
    {
      paramView = InterpolatorManager.a;
      localObject1 = this.inpt;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      this.interpolator = paramView.a((InterpolatorData)localObject1);
    }
    if (this.engine != null)
    {
      paramView = ((Map)this.rules).entrySet().iterator();
      while (paramView.hasNext())
      {
        localObject1 = (Map.Entry)paramView.next();
        Object localObject2 = this.engine;
        if (localObject2 == null) {
          Intrinsics.throwNpe();
        }
        localObject2 = ((IXAEngine)localObject2).getRuleManager();
        if (localObject2 != null) {
          ((IRuleManager)localObject2).refreshAnimRuleValue(this, (String)((Map.Entry)localObject1).getKey(), (String)((Map.Entry)localObject1).getValue());
        } else {
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.IRuleManager");
        }
      }
    }
  }
  
  public final void setDelay(long paramLong)
  {
    this.delay = paramLong;
  }
  
  public final void setDuration(int paramInt)
  {
    this.duration = paramInt;
  }
  
  public final void setEngine(@Nullable IXAEngine paramIXAEngine)
  {
    this.engine = paramIXAEngine;
  }
  
  public final void setExpressionList(@NotNull HashMap<String, Expression> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.expressionList = paramHashMap;
  }
  
  public final void setExps(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.exps = paramHashMap;
  }
  
  public final void setFirst(@NotNull AtomicBoolean paramAtomicBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramAtomicBoolean, "<set-?>");
    this.isFirst = paramAtomicBoolean;
  }
  
  public final void setFloat(@Nullable String paramString)
  {
    this.jdField_float = paramString;
  }
  
  public final void setFloatData(@NotNull FloatViewData paramFloatViewData)
  {
    Intrinsics.checkParameterIsNotNull(paramFloatViewData, "<set-?>");
    this.floatData = paramFloatViewData;
  }
  
  public final void setForward(boolean paramBoolean)
  {
    this.forward = paramBoolean;
  }
  
  public final void setInpt(@Nullable InterpolatorData paramInterpolatorData)
  {
    this.inpt = paramInterpolatorData;
  }
  
  public final void setInterpolator(@Nullable Interpolator paramInterpolator)
  {
    this.interpolator = paramInterpolator;
  }
  
  public final void setLast(boolean paramBoolean)
  {
    this.last = paramBoolean;
  }
  
  public final void setLink(boolean paramBoolean)
  {
    this.isLink = paramBoolean;
  }
  
  public final void setRemoveIds(@Nullable Integer[] paramArrayOfInteger)
  {
    this.removeIds = paramArrayOfInteger;
  }
  
  public final void setRules(@NotNull HashMap<String, String> paramHashMap)
  {
    Intrinsics.checkParameterIsNotNull(paramHashMap, "<set-?>");
    this.rules = paramHashMap;
  }
  
  public final void setStatus(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.status = paramString;
  }
  
  public final void setType(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "<set-?>");
    this.type = paramString;
  }
  
  public final void setView(@Nullable View paramView)
  {
    this.view = paramView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.xaction.api.base.BaseAnim
 * JD-Core Version:    0.7.0.1
 */