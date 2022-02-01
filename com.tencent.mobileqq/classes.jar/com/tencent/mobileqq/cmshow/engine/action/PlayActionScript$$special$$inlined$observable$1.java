package com.tencent.mobileqq.cmshow.engine.action;

import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import java.util.List;
import java.util.concurrent.locks.Lock;
import kotlin.Metadata;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.ObservableProperty;
import kotlin.reflect.KProperty;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"kotlin/properties/Delegates$observable$1", "Lkotlin/properties/ObservableProperty;", "afterChange", "", "property", "Lkotlin/reflect/KProperty;", "oldValue", "newValue", "(Lkotlin/reflect/KProperty;Ljava/lang/Object;Ljava/lang/Object;)V", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class PlayActionScript$$special$$inlined$observable$1
  extends ObservableProperty<ActionStatus>
{
  public PlayActionScript$$special$$inlined$observable$1(Object paramObject1, Object paramObject2, PlayActionScript paramPlayActionScript)
  {
    super(paramObject2);
  }
  
  protected void afterChange(@NotNull KProperty<?> paramKProperty, ActionStatus paramActionStatus1, ActionStatus paramActionStatus2)
  {
    Intrinsics.checkParameterIsNotNull(paramKProperty, "property");
    paramKProperty = (ActionStatus)paramActionStatus2;
    paramActionStatus1 = (ActionStatus)paramActionStatus1;
    long l = System.currentTimeMillis();
    paramActionStatus2 = (Lock)PlayActionScript.a(this.b);
    paramActionStatus2.lock();
    try
    {
      PlayActionScript.b(this.b).add(new StatusRecord(paramKProperty, l));
      paramActionStatus2.unlock();
      if (paramKProperty.b()) {
        this.b.d().g().b(PlayActionScript.c(this.b));
      }
      paramActionStatus2 = this.b.a();
      if (paramActionStatus2 != null)
      {
        paramActionStatus2.invoke(paramActionStatus1, paramKProperty);
        return;
      }
      PlayActionScript.d(this.b).invoke(paramActionStatus1, paramKProperty);
      return;
    }
    finally
    {
      paramActionStatus2.unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.PlayActionScript..special..inlined.observable.1
 * JD-Core Version:    0.7.0.1
 */