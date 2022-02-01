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
  public static final BKScriptService.Companion a;
  private final BKScriptService.buildInRequestHandler.1 jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService$buildInRequestHandler$1;
  @NotNull
  private final BKScriptTaskBuilder jdField_a_of_type_ComTencentMobileqqCmshowBrickengineScriptTaskBKScriptTaskBuilder;
  private final EngineContext jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext;
  private final String jdField_a_of_type_JavaLangString;
  private final List<IEventPlugin> jdField_a_of_type_JavaUtilList;
  private final Map<String, List<IEventPlugin>> jdField_a_of_type_JavaUtilMap;
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private final List<IEventPlugin> b;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService$Companion = new BKScriptService.Companion(null);
  }
  
  public BKScriptService(@NotNull EngineContext paramEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext = paramEngineContext;
    paramEngineContext = new StringBuilder();
    paramEngineContext.append("[cmshow][BKCMShowEngine][BKScriptService][");
    paramEngineContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    paramEngineContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramEngineContext.toString();
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineScriptTaskBKScriptTaskBuilder = new BKScriptTaskBuilder();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.b = ((List)new ArrayList());
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService$buildInRequestHandler$1 = new BKScriptService.buildInRequestHandler.1(this);
    paramEngineContext = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i(paramEngineContext, 1, localStringBuilder.toString());
    ApolloCmdChannel.getInstance().addCmdHandler((IRequestHandler)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService$buildInRequestHandler$1);
    a((IEventPlugin)new GeneralEventPlugin());
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a((IScriptService)this);
  }
  
  private final String a(Argument paramArgument)
  {
    Object localObject1 = (String)null;
    Iterator localIterator = ((Iterable)this.b).iterator();
    while (localIterator.hasNext())
    {
      Object localObject2 = (IEventPlugin)localIterator.next();
      if (((IEventPlugin)localObject2).a(paramArgument.c()))
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
    return this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineScriptTaskBKScriptTaskBuilder;
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reqParams");
    Argument localArgument = new Argument((IScriptService)this, paramString);
    String str = null;
    paramString = (List)null;
    localObject = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject).lock();
    try
    {
      paramString = (List)this.jdField_a_of_type_JavaUtilMap.get(localArgument.c());
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
        int i;
        int j;
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
      i = paramString.size();
    } else {
      i = 0;
    }
    j = 1;
    if ((paramString != null) && (i != 0))
    {
      if (paramString == null) {
        Intrinsics.throwNpe();
      }
      str = ((IEventPlugin)paramString.get(0)).a(localArgument);
      if (i > 1) {
        while (j < i)
        {
          if (paramString == null) {
            Intrinsics.throwNpe();
          }
          ((IEventPlugin)paramString.get(j)).a(localArgument);
          j += 1;
        }
      }
      return str;
    }
    if (Intrinsics.areEqual("error", localArgument.c()))
    {
      paramString = this.jdField_a_of_type_JavaLangString;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onScriptEvent error, ");
      ((StringBuilder)localObject).append(localArgument.d());
      QLog.e(paramString, 1, ((StringBuilder)localObject).toString());
    }
    paramString = str;
    if (EngineHelper.a.a(localArgument.c())) {
      paramString = a(localArgument);
    }
    return paramString;
  }
  
  public final void a()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("destroy ");
    ((StringBuilder)localObject2).append(this);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    ApolloCmdChannel.getInstance().removeCmdHandler((IRequestHandler)this.jdField_a_of_type_ComTencentMobileqqCmshowBrickengineBKScriptService$buildInRequestHandler$1);
    localObject1 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject1).lock();
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      this.b.clear();
      localObject2 = Unit.INSTANCE;
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
  }
  
  public void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    IRenderService localIRenderService = this.jdField_a_of_type_ComTencentMobileqqCmshowEngineEngineContext.a();
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
    Lock localLock = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramIEventPlugin);
      if (paramIEventPlugin.a()) {
        this.b.add(paramIEventPlugin);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, (Comparator)BKScriptService.registerPlugin.1.1.a);
      this.jdField_a_of_type_JavaUtilMap.clear();
      Iterator localIterator1 = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator1.hasNext())
      {
        IEventPlugin localIEventPlugin = (IEventPlugin)localIterator1.next();
        Iterator localIterator2 = ((Iterable)localIEventPlugin.a()).iterator();
        while (localIterator2.hasNext())
        {
          Object localObject = (String)localIterator2.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
          {
            localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
            if (localObject != null) {
              ((List)localObject).add(localIEventPlugin);
            }
          }
          else
          {
            this.jdField_a_of_type_JavaUtilMap.put(localObject, new BKScriptService.registerPlugin..inlined.withLock.lambda.1(localIEventPlugin, this, paramIEventPlugin));
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
    Lock localLock = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    localLock.lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramIEventPlugin))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramIEventPlugin);
        Iterator localIterator = ((Iterable)paramIEventPlugin.a()).iterator();
        while (localIterator.hasNext())
        {
          Object localObject = (String)localIterator.next();
          if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
          {
            localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
            if (localObject != null) {
              ((List)localObject).remove(paramIEventPlugin);
            }
          }
        }
      }
      if (this.b.contains(paramIEventPlugin)) {
        this.b.remove(paramIEventPlugin);
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.brickengine.BKScriptService
 * JD-Core Version:    0.7.0.1
 */