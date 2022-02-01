package com.tencent.mobileqq.cmshow.engine.action;

import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.List<Lcom.tencent.mobileqq.cmshow.engine.action.StatusRecord;>;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.properties.Delegates;
import kotlin.properties.ReadWriteProperty;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/action/PlayActionScript;", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "scriptContent", "", "task", "Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;Ljava/lang/String;Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;)V", "<set-?>", "Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "actionStatus", "getActionStatus", "()Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;", "setActionStatus", "(Lcom/tencent/mobileqq/cmshow/engine/action/ActionStatus;)V", "actionStatus$delegate", "Lkotlin/properties/ReadWriteProperty;", "actionStatusRecords", "", "Lcom/tencent/mobileqq/cmshow/engine/action/StatusRecord;", "buildInPlugin", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "customStatusChangeListener", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "old", "new", "", "getCustomStatusChangeListener", "()Lkotlin/jvm/functions/Function2;", "setCustomStatusChangeListener", "(Lkotlin/jvm/functions/Function2;)V", "defaultStatusChangeListener", "getEngineContext", "()Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getScriptContent", "()Ljava/lang/String;", "getTask", "()Lcom/tencent/mobileqq/cmshow/engine/script/task/PlayActionTask;", "evaluateStart", "getStatusRecords", "", "getStatusRecords$cmshow_impl_release", "getStatusRecordsDesc", "records", "getStatusRecordsDesc$cmshow_impl_release", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayActionScript
  extends Script
{
  @Deprecated
  public static final PlayActionScript.Companion b = new PlayActionScript.Companion(null);
  @NotNull
  private static final List<String> l = CollectionsKt.listOf("cs.script_action_status_notify.local");
  private final ReentrantLock c;
  private final List<StatusRecord> d;
  @Nullable
  private Function2<? super ActionStatus, ? super ActionStatus, Unit> e;
  private final Function2<ActionStatus, ActionStatus, Unit> f;
  @NotNull
  private final ReadWriteProperty g;
  private final IEventPlugin h;
  @NotNull
  private final EngineContext i;
  @NotNull
  private final String j;
  @NotNull
  private final PlayActionTask k;
  
  public PlayActionScript(@NotNull EngineContext paramEngineContext, @NotNull String paramString, @NotNull PlayActionTask paramPlayActionTask)
  {
    super(paramString);
    this.i = paramEngineContext;
    this.j = paramString;
    this.k = paramPlayActionTask;
    this.c = new ReentrantLock();
    this.d = ((List)new ArrayList());
    this.f = ((Function2)new PlayActionScript.defaultStatusChangeListener.1(this));
    paramEngineContext = Delegates.INSTANCE;
    paramEngineContext = UNKNOWN.a;
    this.g = ((ReadWriteProperty)new PlayActionScript..special..inlined.observable.1(paramEngineContext, paramEngineContext, this));
    this.h = ((IEventPlugin)new PlayActionScript.buildInPlugin.1(this));
  }
  
  @NotNull
  public final String a(@NotNull List<StatusRecord> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "records");
    StringBuilder localStringBuilder1 = new StringBuilder();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("taskId:");
    ((StringBuilder)localObject).append(this.k.m());
    ((StringBuilder)localObject).append(", actionId:");
    ((StringBuilder)localObject).append(this.k.c());
    ((StringBuilder)localObject).append(", ");
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("evaluateCostTime:");
    ((StringBuilder)localObject).append(k());
    ((StringBuilder)localObject).append(", evaluateDelayTime:");
    ((StringBuilder)localObject).append(l());
    localStringBuilder1.append(((StringBuilder)localObject).toString());
    localStringBuilder1.append(" \nStatus Graphic:[");
    localObject = (StatusRecord)null;
    Iterator localIterator = ((Iterable)paramList).iterator();
    for (paramList = (List<StatusRecord>)localObject; localIterator.hasNext(); paramList = (List<StatusRecord>)localObject)
    {
      localObject = (StatusRecord)localIterator.next();
      if (paramList != null)
      {
        StringBuilder localStringBuilder2 = new StringBuilder();
        localStringBuilder2.append("-->");
        long l1 = ((StatusRecord)localObject).b();
        if (paramList == null) {
          Intrinsics.throwNpe();
        }
        localStringBuilder2.append(l1 - paramList.b());
        localStringBuilder2.append("ms-->");
        localStringBuilder2.append(((StatusRecord)localObject).a());
        localStringBuilder1.append(localStringBuilder2.toString());
      }
      else
      {
        localStringBuilder1.append(String.valueOf(((StatusRecord)localObject).a()));
      }
    }
    localStringBuilder1.append("]");
    paramList = localStringBuilder1.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramList, "StringBuilder().apply(builderAction).toString()");
    return paramList;
  }
  
  @Nullable
  public final Function2<ActionStatus, ActionStatus, Unit> a()
  {
    return this.e;
  }
  
  public final void a(@NotNull ActionStatus paramActionStatus)
  {
    Intrinsics.checkParameterIsNotNull(paramActionStatus, "<set-?>");
    this.g.setValue(this, a[0], paramActionStatus);
  }
  
  public final void a(@Nullable Function2<? super ActionStatus, ? super ActionStatus, Unit> paramFunction2)
  {
    this.e = paramFunction2;
  }
  
  public void b()
  {
    super.b();
    this.i.g().a(this.h);
    a((ActionStatus)INIT.a);
  }
  
  @NotNull
  public final List<StatusRecord> c()
  {
    Lock localLock = (Lock)this.c;
    localLock.lock();
    try
    {
      List localList = CollectionsKt.toList((Iterable)this.d);
      return localList;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  @NotNull
  public final EngineContext d()
  {
    return this.i;
  }
  
  @NotNull
  public String e()
  {
    return this.j;
  }
  
  @NotNull
  public final PlayActionTask f()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.PlayActionScript
 * JD-Core Version:    0.7.0.1
 */