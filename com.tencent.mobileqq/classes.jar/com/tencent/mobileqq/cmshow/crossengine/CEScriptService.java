package com.tencent.mobileqq.cmshow.crossengine;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.AudioModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.FileModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.FrameRecorderPlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.IModuleEventPlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.LogModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.task.CEScriptTaskBuilder;
import com.tencent.mobileqq.cmshow.engine.EngineContext;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
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
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KProperty0;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/CEScriptService;", "Lcom/tencent/mobileqq/cmshow/engine/script/IScriptService;", "engineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V", "TAG", "", "cmdPluginMap", "", "", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "modulePluginMap", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "plugInThreadHandler", "Landroid/os/Handler;", "pluginList", "scriptBuilder", "Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CEScriptTaskBuilder;", "getScriptBuilder", "()Lcom/tencent/mobileqq/cmshow/crossengine/script/task/CEScriptTaskBuilder;", "scriptWaitList", "Lcom/tencent/mobileqq/cmshow/engine/script/Script;", "variablePluginList", "addCmdEventPlugin", "", "eventPlugin", "addModuleEventPlugin", "addScriptToWaitList", "script", "destroy", "destroy$cmshow_impl_release", "evaluateScript", "evaluateWaitList", "evaluateWaitList$cmshow_impl_release", "onCmdScriptEvent", "argument", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "onModuleScriptEvent", "Lorg/json/JSONObject;", "onNativeEvent", "cmd", "respData", "onScriptEvent", "reqParams", "onSpecialScriptEvent", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "registerPlugin", "plugin", "removeCmdModulePlugin", "removeModulePlugin", "unRegisterPlugin", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class CEScriptService
  implements IScriptService
{
  public static final CEScriptService.Companion a = new CEScriptService.Companion(null);
  private final String b;
  @NotNull
  private final CEScriptTaskBuilder c;
  private final ReentrantLock d;
  private final List<IEventPlugin> e;
  private final List<IEventPlugin> f;
  private final Map<String, List<IEventPlugin>> g;
  private final Map<String, List<IModuleEventPlugin>> h;
  private final Handler i;
  private final List<Script> j;
  private final CEEngineContext k;
  
  public CEScriptService(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.k = paramCEEngineContext;
    paramCEEngineContext = new StringBuilder();
    paramCEEngineContext.append("[cmshow][CECMShowOffscreenEngine][CEScriptService][");
    paramCEEngineContext.append(this.k.k());
    paramCEEngineContext.append(']');
    this.b = paramCEEngineContext.toString();
    this.c = new CEScriptTaskBuilder((EngineContext)this.k);
    this.d = new ReentrantLock();
    this.e = ((List)new ArrayList());
    this.f = ((List)new ArrayList());
    this.g = ((Map)new LinkedHashMap());
    this.h = ((Map)new LinkedHashMap());
    this.i = new Handler(ThreadManager.getSubThreadLooper());
    this.j = ((List)new ArrayList());
    paramCEEngineContext = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.k.k());
    QLog.i(paramCEEngineContext, 1, localStringBuilder.toString());
    a((IEventPlugin)new GeneralEventPlugin());
    a((IEventPlugin)new LogModulePlugin());
    a((IEventPlugin)new FileModulePlugin());
    a((IEventPlugin)new FrameRecorderPlugin(this.k));
    a((IEventPlugin)new AudioModulePlugin());
    this.k.a((IScriptService)this);
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
  
  private final JSONObject a(CEArgument paramCEArgument)
  {
    JSONObject localJSONObject = (JSONObject)null;
    Object localObject2 = (List)this.h.get(paramCEArgument.a());
    int m;
    if (localObject2 != null) {
      m = ((List)localObject2).size();
    } else {
      m = 0;
    }
    int n = 1;
    Object localObject1;
    if ((localObject2 != null) && (m != 0))
    {
      if (paramCEArgument.c())
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          localObject1 = localJSONObject;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (IModuleEventPlugin)((Iterator)localObject2).next();
          this.i.post((Runnable)new CEScriptService.onModuleScriptEvent..inlined.forEach.lambda.1((IModuleEventPlugin)localObject1, this, paramCEArgument));
        }
      }
      localJSONObject = ((IModuleEventPlugin)((List)localObject2).get(0)).a(paramCEArgument);
      localObject1 = localJSONObject;
      if (m > 1) {
        for (;;)
        {
          localObject1 = localJSONObject;
          if (n >= m) {
            break;
          }
          ((IModuleEventPlugin)((List)localObject2).get(n)).a(paramCEArgument);
          n += 1;
        }
      }
      return localObject1;
    }
    if (Intrinsics.areEqual("error", paramCEArgument.f()))
    {
      localObject1 = this.b;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onScriptEvent error, ");
      ((StringBuilder)localObject2).append(paramCEArgument.g());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return localJSONObject;
  }
  
  private final void a(IModuleEventPlugin paramIModuleEventPlugin)
  {
    Object localObject = paramIModuleEventPlugin.b();
    if (this.h.containsKey(localObject))
    {
      localObject = (List)this.h.get(localObject);
      if (localObject != null) {
        ((List)localObject).add(paramIModuleEventPlugin);
      }
    }
    else
    {
      this.h.put(localObject, new CEScriptService.addModuleEventPlugin.1(paramIModuleEventPlugin));
    }
  }
  
  private final String b(CEArgument paramCEArgument)
  {
    Object localObject1 = null;
    Object localObject2 = (List)null;
    localObject2 = (Lock)this.d;
    ((Lock)localObject2).lock();
    try
    {
      Object localObject3 = (List)this.g.get(paramCEArgument.f());
      if (localObject3 != null) {
        localObject1 = CollectionsKt.toMutableList((Collection)localObject3);
      }
      localObject3 = Unit.INSTANCE;
      ((Lock)localObject2).unlock();
      int m;
      if (localObject1 != null) {
        m = ((List)localObject1).size();
      } else {
        m = 0;
      }
      int n = 1;
      if ((localObject1 != null) && (m != 0))
      {
        if (paramCEArgument.c())
        {
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (IEventPlugin)((Iterator)localObject1).next();
            this.i.post((Runnable)new CEScriptService.onCmdScriptEvent..inlined.forEach.lambda.1((IEventPlugin)localObject2, this, paramCEArgument));
          }
          paramCEArgument = "{}";
        }
        else
        {
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject2 = (IEventPlugin)((List)localObject1).get(0);
          localObject3 = (Argument)paramCEArgument;
          localObject2 = ((IEventPlugin)localObject2).a((Argument)localObject3);
          paramCEArgument = (CEArgument)localObject2;
          if (m > 1) {
            for (;;)
            {
              paramCEArgument = (CEArgument)localObject2;
              if (n >= m) {
                break;
              }
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              ((IEventPlugin)((List)localObject1).get(n)).a((Argument)localObject3);
              n += 1;
            }
          }
        }
        if (paramCEArgument != null) {
          return paramCEArgument;
        }
        return "{}";
      }
      if (Intrinsics.areEqual("error", paramCEArgument.f()))
      {
        localObject1 = this.b;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onScriptEvent error, ");
        ((StringBuilder)localObject2).append(paramCEArgument.g());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      if (EngineHelper.a.a(paramCEArgument.f())) {
        return a((Argument)paramCEArgument);
      }
      return "{}";
    }
    finally
    {
      ((Lock)localObject2).unlock();
    }
    for (;;)
    {
      throw paramCEArgument;
    }
  }
  
  private final void b(IModuleEventPlugin paramIModuleEventPlugin)
  {
    Object localObject = paramIModuleEventPlugin.b();
    if (this.h.containsKey(localObject))
    {
      localObject = (List)this.h.get(localObject);
      if (localObject != null) {
        ((List)localObject).remove(paramIModuleEventPlugin);
      }
    }
  }
  
  private final void b(Script paramScript)
  {
    ??? = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addScriptToWaitList: ");
    localStringBuilder.append(paramScript);
    QLog.d((String)???, 1, localStringBuilder.toString());
    synchronized (this.j)
    {
      this.j.add(paramScript);
      return;
    }
  }
  
  private final void c(IEventPlugin paramIEventPlugin)
  {
    Iterator localIterator = ((Iterable)paramIEventPlugin.c()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (this.g.containsKey(localObject))
      {
        localObject = (List)this.g.get(localObject);
        if (localObject != null) {
          ((List)localObject).add(paramIEventPlugin);
        }
      }
      else
      {
        this.g.put(localObject, new CEScriptService.addCmdEventPlugin..inlined.forEach.lambda.1(this, paramIEventPlugin));
      }
    }
  }
  
  private final void d(IEventPlugin paramIEventPlugin)
  {
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
  
  @NotNull
  public CEScriptTaskBuilder a()
  {
    return this.c;
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reqParams");
    if (QLog.isColorLevel())
    {
      String str = this.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScriptEvent: ");
      localStringBuilder.append(this.k.k());
      localStringBuilder.append(", ");
      localStringBuilder.append(paramString);
      QLog.d(str, 4, localStringBuilder.toString());
    }
    paramString = new CEArgument((IScriptService)this, paramString);
    if ((!TextUtils.isEmpty((CharSequence)paramString.a())) && (!Intrinsics.areEqual("Script", paramString.a())))
    {
      paramString = a(paramString);
      if (paramString != null) {
        return paramString.toString();
      }
      return null;
    }
    return b(paramString);
  }
  
  public void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    paramScript.a(this.k.i());
    if (!this.k.a())
    {
      b(paramScript);
      return;
    }
    CharSequence localCharSequence;
    if (paramScript.e().length() > 100) {
      localCharSequence = paramScript.e().subSequence(0, 100);
    } else {
      localCharSequence = (CharSequence)paramScript.e();
    }
    String str = this.b;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateScript id:");
    localStringBuilder.append(paramScript.i());
    localStringBuilder.append(", content:");
    localStringBuilder.append(localCharSequence);
    QLog.d(str, 4, localStringBuilder.toString());
    paramScript.b();
    this.k.c().evaluateWorldJs((String)new CEScriptService.evaluateScript.1(this.k.k()).get(), paramScript.e());
    paramScript.j();
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
      Collections.sort(this.e, (Comparator)CEScriptService.registerPlugin.1.1.a);
      this.h.clear();
      this.g.clear();
      paramIEventPlugin = this.e.iterator();
      while (paramIEventPlugin.hasNext())
      {
        IEventPlugin localIEventPlugin = (IEventPlugin)paramIEventPlugin.next();
        if ((localIEventPlugin instanceof IModuleEventPlugin)) {
          a((IModuleEventPlugin)localIEventPlugin);
        } else {
          c(localIEventPlugin);
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
    ThreadManager.excute((Runnable)new CEScriptService.onNativeEvent.1(this, paramString1, paramString2), 16, null, true);
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
        if ((paramIEventPlugin instanceof IModuleEventPlugin)) {
          b((IModuleEventPlugin)paramIEventPlugin);
        } else {
          d(paramIEventPlugin);
        }
      }
      if (this.f.contains(paramIEventPlugin)) {
        this.f.remove(paramIEventPlugin);
      }
      paramIEventPlugin = Unit.INSTANCE;
      return;
    }
    finally
    {
      localLock.unlock();
    }
  }
  
  public final void c()
  {
    Object localObject2 = (List)new ArrayList();
    synchronized (this.j)
    {
      ((List)localObject2).addAll((Collection)this.j);
      this.j.clear();
      Object localObject4 = Unit.INSTANCE;
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (Script)((Iterator)???).next();
        localObject4 = this.b;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evaluateScript evaluateWaitList: ");
        localStringBuilder.append(localObject2);
        QLog.d((String)localObject4, 1, localStringBuilder.toString());
        ((Script)localObject2).b();
        this.k.c().evaluateWorldJs((String)new CEScriptService.evaluateWaitList.2(this.k.k()).get(), ((Script)localObject2).e());
        ((Script)localObject2).j();
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public final void d()
  {
    Object localObject1 = this.b;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("destroy ");
    ((StringBuilder)localObject2).append(this);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(this.k.k());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = (Lock)this.d;
    ((Lock)localObject1).lock();
    try
    {
      this.e.clear();
      this.f.clear();
      this.g.clear();
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEScriptService
 * JD-Core Version:    0.7.0.1
 */