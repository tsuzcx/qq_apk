package com.tencent.mobileqq.cmshow.brickengine;

import com.tencent.mobileqq.apollo.channel.IRequestHandler;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.brickengine.apollo.ApolloCmdChannel;
import com.tencent.mobileqq.cmshow.brickengine.script.task.BKScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.script.IScriptService;
import com.tencent.mobileqq.cmshow.engine.script.Script;
import com.tencent.mobileqq.cmshow.engine.script.plugin.GeneralEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService;", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/engine/EngineContext;", "(Lcom/tencent/mobileqq/cmshow/engine/EngineContext;)V", "TAG", "", "buildInRequestHandler", "com/tencent/mobileqq/cmshow/brickengine/BKScriptService$buildInRequestHandler$1", "Lcom/tencent/mobileqq/cmshow/brickengine/BKScriptService$buildInRequestHandler$1;", "cmdPluginMap", "", "", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "pluginList", "scriptBuilder", "Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKScriptTaskBuilder;", "getScriptBuilder", "()Lcom/tencent/mobileqq/cmshow/brickengine/script/task/BKScriptTaskBuilder;", "variablePluginList", "destroy", "", "destroy$cmshow_impl_release", "evaluateScript", "script", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "onNativeEvent", "cmd", "respData", "onScriptEvent", "reqParams", "onSpecialScriptEvent", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "registerPlugin", "plugin", "unRegisterPlugin", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BKScriptService
  implements IScriptService
{
  @Deprecated
  public static final BKScriptService.Companion a = new BKScriptService.Companion(null);
  private final String b;
  @NotNull
  private final BKScriptTaskBuilder c;
  private final ReentrantLock d;
  private final List<IEventPlugin> e;
  private final List<IEventPlugin> f;
  private final Map<String, List<IEventPlugin>> g;
  private final BKScriptService.buildInRequestHandler.1 h;
  private final EngineContext i;
  
  public BKScriptService(@NotNull EngineContext paramEngineContext)
  {
    this.i = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKScriptService][");
    paramEngineContext.append(this.i.k());
    paramEngineContext.append(']');
    this.b = paramEngineContext.toString();
    this.c = new BKScriptTaskBuilder(this.i);
    this.d = new ReentrantLock();
    this.e = ((List)new ArrayList());
    this.f = ((List)new ArrayList());
    this.g = ((Map)new LinkedHashMap());
    this.h = new BKScriptService.buildInRequestHandler.1(this);
    paramEngineContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.i.k());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    ApolloCmdChannel.getInstance().addCmdHandler((IRequestHandler)this.h);
    a((IEventPlugin)new GeneralEventPlugin());
    this.i.a((IScriptService)this);
  }
  
  private final String a(Argument paramArgument)
  {
    Object localObject1 = (String)null;
    Iterator localIterator = ((Iterable)this.f).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (IEventPlugin)localIterator.next();
      if (((IEventPlugin)localObject2).a(paramArgument.f()))
      {
        localObject2 = ((IEventPlugin)localObject2).a(paramArgument);
        if (localObject1 == null) {
          localObject1 = localObject2;
        }
      }
    }
    return localObject1;
  }
  
  @NotNull
  public BKScriptTaskBuilder a()
  {
    return this.c;
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reqParams");
    Argument localArgument = new Argument((IScriptService)this, paramString);
    String str = null;
    paramString = (List)null;
    localObject = (Lock)this.d;
    ((Lock)localObject).lock();
    try
    {
      paramString = (List)this.g.get(localArgument.f());
      if (paramString == null) {
        break label289;
      }
      paramString = CollectionsKt.toMutableList((Collection)paramString);
    }
    finally
    {
      for (;;)
      {
        Unit localUnit;
        int j;
        int k;
        ((Lock)localObject).unlock();
        for (;;)
        {
          throw paramString;
        }
        paramString = null;
      }
    }
    localUnit = Unit.INSTANCE;
    ((Lock)localObject).unlock();
    if (paramString != null) {
      j = paramString.size();
    } else {
      j = 0;
    }
    k = 1;
    if ((paramString != null) && (j != 0))
    {
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      str = ((IEventPlugin)paramString.get(0)).a(localArgument);
      if (j > 1) {
        while (k < j)
        {
          if (paramString == null) {
            Intrinsics.throwNpe();
          }
          ((IEventPlugin)paramString.get(k)).a(localArgument);
          k += 1;
        }
      }
      return str;
    }
    if (Intrinsics.areEqual("error", localArgument.f()))
    {
      paramString = this.b;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScriptEvent error, ");
      ((StringBuilder)localObject).append(localArgument.g());
      QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
    }
    paramString = str;
    if (EngineHelper.a.a(localArgument.f())) {
      paramString = a(localArgument);
    }
    return paramString;
  }
  
  public void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    paramScript.a(this.i.i());
    IRenderService localIRenderService = this.i.f();
    if (localIRenderService != null)
    {
      ((BKRenderService)localIRenderService).a(paramScript);
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.cmshow.brickengine.BKRenderService");
  }
  
  public void a(@NotNull IEventPlugin paramIEventPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramIEventPlugin, "plugin");
    Lock localLock = (Lock)this.d;
    localLock.lock();
    try
    {
      this.e.add(paramIEventPlugin);
      if (paramIEventPlugin.d()) {
        this.f.add(paramIEventPlugin);
      }
      Collections.sort(this.e, (Comparator)BKScriptService.registerPlugin.1.1.a);
      this.g.clear();
      Iterator localIterator1 = this.e.iterator();
      while (localIterator1.hasNext())
      {
        IEventPlugin localIEventPlugin = (IEventPlugin)localIterator1.next();
        Iterator localIterator2 = ((Iterable)localIEventPlugin.c()).iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = (String)localIterator2.next();
          if (this.g.containsKey(localObject))
          {
            localObject = (List)this.g.get(localObject);
            if (localObject != null) {
              ((List)localObject).add(localIEventPlugin);
            }
          }
          else
          {
            this.g.put(localObject, new BKScriptService.registerPlugin..inlined.withLock.lambda.1(localIEventPlugin, this, paramIEventPlugin));
          }
        }
      }
      paramIEventPlugin = Unit.INSTANCE;
      localLock.unlock();
      return;
    }
    finally
    {
      localLock.unlock();
    }
    for (;;)
    {
      throw paramIEventPlugin;
    }
  }
  
  public void a(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "cmd");
    ThreadManager.excute((Runnable)new BKScriptService.onNativeEvent.1(this, paramString1, paramString2), 16, null, true);
  }
  
  public void b(@NotNull IEventPlugin paramIEventPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramIEventPlugin, "plugin");
    Lock localLock = (Lock)this.d;
    localLock.lock();
    try
    {
      if (this.e.contains(paramIEventPlugin))
      {
        this.e.remove(paramIEventPlugin);
        Iterator localIterator = ((Iterable)paramIEventPlugin.c()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if (this.g.containsKey(localObject))
          {
            localObject = (List)this.g.get(localObject);
            if (localObject != null) {
              ((List)localObject).remove(paramIEventPlugin);
            }
          }
        }
      }
      if (this.f.contains(paramIEventPlugin)) {
        this.f.remove(paramIEventPlugin);
      }
      paramIEventPlugin = Unit.INSTANCE;
      localLock.unlock();
      return;
    }
    finally
    {
      localLock.unlock();
    }
    for (;;)
    {
      throw paramIEventPlugin;
    }
  }
  
  public final void c()
  {
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("destroy ");
    ((StringBuilder)localObject2).append(this);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(this.i.k());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    ApolloCmdChannel.getInstance().removeCmdHandler((IRequestHandler)this.h);
    localObject1 = (Lock)this.d;
    ((Lock)localObject1).lock();
    try
    {
      this.e.clear();
      this.g.clear();
      this.f.clear();
      localObject2 = Unit.INSTANCE;
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptService
 * JD-Core Version:    0.7.0.1
 */