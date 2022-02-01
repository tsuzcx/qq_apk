package com.tencent.xaction.api.base;

import android.view.View;
import android.view.animation.Interpolator;
import androidx.annotation.Keep;
import com.tencent.xaction.api.IAnim;
import com.tencent.xaction.api.IRuleManager;
import com.tencent.xaction.api.data.FloatViewData;
import com.tencent.xaction.api.data.InterpolatorData;
import com.tencent.xaction.impl.AnimStateListener;
import com.tencent.xaction.impl.XAEngine;
import com.tencent.xaction.impl.XATimeline;
import com.tencent.xaction.manager.InterpolatorManager;
import com.tencent.xaction.manager.InterpolatorManager.Companion;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/xaction/api/base/BaseAnim;", "Lcom/tencent/xaction/api/IAnim;", "", "()V", "delay", "", "getDelay", "()J", "setDelay", "(J)V", "duration", "", "getDuration", "()I", "setDuration", "(I)V", "engine", "Lcom/tencent/xaction/impl/XAEngine;", "getEngine", "()Lcom/tencent/xaction/impl/XAEngine;", "setEngine", "(Lcom/tencent/xaction/impl/XAEngine;)V", "float", "", "getFloat", "()Ljava/lang/String;", "setFloat", "(Ljava/lang/String;)V", "floatData", "Lcom/tencent/xaction/api/data/FloatViewData;", "getFloatData", "()Lcom/tencent/xaction/api/data/FloatViewData;", "setFloatData", "(Lcom/tencent/xaction/api/data/FloatViewData;)V", "inpt", "Lcom/tencent/xaction/api/data/InterpolatorData;", "getInpt", "()Lcom/tencent/xaction/api/data/InterpolatorData;", "setInpt", "(Lcom/tencent/xaction/api/data/InterpolatorData;)V", "interpolator", "Landroid/view/animation/Interpolator;", "getInterpolator", "()Landroid/view/animation/Interpolator;", "setInterpolator", "(Landroid/view/animation/Interpolator;)V", "isFirst", "Ljava/util/concurrent/atomic/AtomicBoolean;", "()Ljava/util/concurrent/atomic/AtomicBoolean;", "setFirst", "(Ljava/util/concurrent/atomic/AtomicBoolean;)V", "last", "", "getLast", "()Z", "setLast", "(Z)V", "realtime", "getRealtime", "setRealtime", "rules", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getRules", "()Ljava/util/HashMap;", "setRules", "(Ljava/util/HashMap;)V", "status", "getStatus", "setStatus", "type", "getType", "setType", "view", "Landroid/view/View;", "getView", "()Landroid/view/View;", "setView", "(Landroid/view/View;)V", "animStateListener", "", "timeline", "Lcom/tencent/xaction/impl/XATimeline;", "it", "clone", "doFrame", "frameTime", "doFrameUpdate", "animTime", "", "end", "init", "play", "preStart", "XActionEngine_release"}, k=1, mv={1, 1, 16})
@Keep
public abstract class BaseAnim
  implements IAnim, Cloneable
{
  private long delay;
  private int duration;
  @Nullable
  private transient XAEngine engine;
  @Nullable
  private String jdField_float;
  @NotNull
  private transient FloatViewData floatData = new FloatViewData();
  @Nullable
  private InterpolatorData inpt;
  @Nullable
  private transient Interpolator interpolator;
  @NotNull
  private transient AtomicBoolean isFirst = new AtomicBoolean(true);
  private boolean last;
  private boolean realtime;
  @NotNull
  private HashMap<String, String> rules = new HashMap();
  @NotNull
  private String status = "";
  @NotNull
  private String type = "";
  @Nullable
  private transient View view;
  
  public final void animStateListener(@NotNull XATimeline paramXATimeline, @Nullable View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramXATimeline, "timeline");
    paramXATimeline.a((AnimStateListener)new BaseAnim.animStateListener.1(this, paramView));
  }
  
  @NotNull
  public BaseAnim clone()
  {
    Object localObject1 = super.clone();
    if (localObject1 == null) {
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.xaction.api.base.BaseAnim");
    }
    localObject1 = (BaseAnim)localObject1;
    Object localObject2 = this.rules.clone();
    if (localObject2 == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.HashMap<kotlin.String, kotlin.String> /* = java.util.HashMap<kotlin.String, kotlin.String> */");
    }
    ((BaseAnim)localObject1).rules = ((HashMap)localObject2);
    return localObject1;
  }
  
  public void doFrame(long paramLong)
  {
    paramLong -= this.delay;
    if ((this.duration >= paramLong) && (paramLong >= 0L))
    {
      if ((this.isFirst.get()) && (this.last) && (this.view != null))
      {
        localObject = this.view;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        preStart((View)localObject);
      }
      f2 = (float)paramLong * 1.0F / this.duration;
      f1 = f2;
      if (this.interpolator != null)
      {
        localObject = this.interpolator;
        if (localObject == null) {
          Intrinsics.throwNpe();
        }
        f1 = ((Interpolator)localObject).getInterpolation(f2);
      }
      this.isFirst.set(false);
      doFrameUpdate(f1);
    }
    while ((this.isFirst.get()) || (this.duration >= paramLong))
    {
      Object localObject;
      float f2;
      float f1;
      return;
    }
    doFrameUpdate(1.0F);
    this.isFirst.set(true);
    end();
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
  public final XAEngine getEngine()
  {
    return this.engine;
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
  
  public final boolean getRealtime()
  {
    return this.realtime;
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
  
  public final void init(@NotNull View paramView, @NotNull XAEngine paramXAEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    Intrinsics.checkParameterIsNotNull(paramXAEngine, "engine");
    this.engine = paramXAEngine;
    preStart(paramView);
  }
  
  @NotNull
  public final AtomicBoolean isFirst()
  {
    return this.isFirst;
  }
  
  public void play() {}
  
  public void preStart(@NotNull View paramView)
  {
    Intrinsics.checkParameterIsNotNull(paramView, "view");
    this.view = paramView;
    this.isFirst.set(true);
    Object localObject;
    if (this.inpt != null)
    {
      paramView = InterpolatorManager.a;
      localObject = this.inpt;
      if (localObject == null) {
        Intrinsics.throwNpe();
      }
      this.interpolator = paramView.a((InterpolatorData)localObject);
    }
    if (this.engine != null)
    {
      paramView = ((Map)this.rules).entrySet().iterator();
      while (paramView.hasNext())
      {
        localObject = (Map.Entry)paramView.next();
        XAEngine localXAEngine = this.engine;
        if (localXAEngine == null) {
          Intrinsics.throwNpe();
        }
        localXAEngine.getRuleManager().a(this, (String)((Map.Entry)localObject).getKey(), (String)((Map.Entry)localObject).getValue());
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
  
  public final void setEngine(@Nullable XAEngine paramXAEngine)
  {
    this.engine = paramXAEngine;
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
  
  public final void setRealtime(boolean paramBoolean)
  {
    this.realtime = paramBoolean;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.xaction.api.base.BaseAnim
 * JD-Core Version:    0.7.0.1
 */