package com.tencent.mobileqq.cmshow.crossengine;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.crossengine.CEApplication;
import com.tencent.mobileqq.apollo.config.CmShowWnsUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.AudioModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.FileModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.FrameRecorderPlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.IModuleEventPlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.plugin.LogModulePlugin;
import com.tencent.mobileqq.cmshow.crossengine.script.task.CEScriptTaskBuilder;
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
  public static final CEScriptService.Companion a;
  private final Handler jdField_a_of_type_AndroidOsHandler;
  private final CEEngineContext jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
  @NotNull
  private final CEScriptTaskBuilder jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptTaskCEScriptTaskBuilder;
  private final String jdField_a_of_type_JavaLangString;
  private final List<IEventPlugin> jdField_a_of_type_JavaUtilList;
  private final Map<String, List<IEventPlugin>> jdField_a_of_type_JavaUtilMap;
  private final ReentrantLock jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
  private final List<IEventPlugin> jdField_b_of_type_JavaUtilList;
  private final Map<String, List<IModuleEventPlugin>> jdField_b_of_type_JavaUtilMap;
  private final List<Script> c;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEScriptService$Companion = new CEScriptService.Companion(null);
  }
  
  public CEScriptService(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext = paramCEEngineContext;
    paramCEEngineContext = new StringBuilder();
    paramCEEngineContext.append("[cmshow][CECMShowOffscreenEngine][CEScriptService][");
    paramCEEngineContext.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    paramCEEngineContext.append(']');
    this.jdField_a_of_type_JavaLangString = paramCEEngineContext.toString();
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptTaskCEScriptTaskBuilder = new CEScriptTaskBuilder();
    this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock = new ReentrantLock();
    this.jdField_a_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_b_of_type_JavaUtilList = ((List)new ArrayList());
    this.jdField_a_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_b_of_type_JavaUtilMap = ((Map)new LinkedHashMap());
    this.jdField_a_of_type_AndroidOsHandler = new Handler(ThreadManager.getSubThreadLooper());
    this.c = ((List)new ArrayList());
    paramCEEngineContext = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("create ");
    localStringBuilder.append(this);
    localStringBuilder.append(" for ");
    localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.i(paramCEEngineContext, 1, localStringBuilder.toString());
    a((IEventPlugin)new GeneralEventPlugin());
    a((IEventPlugin)new LogModulePlugin());
    a((IEventPlugin)new FileModulePlugin());
    a((IEventPlugin)new FrameRecorderPlugin(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext));
    a((IEventPlugin)new AudioModulePlugin());
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a((IScriptService)this);
  }
  
  private final String a(CEArgument paramCEArgument)
  {
    Object localObject1 = null;
    Object localObject2 = (List)null;
    localObject2 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject2).lock();
    try
    {
      Object localObject3 = (List)this.jdField_a_of_type_JavaUtilMap.get(paramCEArgument.c());
      if (localObject3 != null) {
        localObject1 = CollectionsKt.toMutableList((Collection)localObject3);
      }
      localObject3 = Unit.INSTANCE;
      ((Lock)localObject2).unlock();
      int i;
      if (localObject1 != null) {
        i = ((List)localObject1).size();
      } else {
        i = 0;
      }
      int j = 1;
      if ((localObject1 != null) && (i != 0))
      {
        if (paramCEArgument.a())
        {
          if (localObject1 == null) {
            Intrinsics.throwNpe();
          }
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (IEventPlugin)((Iterator)localObject1).next();
            this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new CEScriptService.onCmdScriptEvent..inlined.forEach.lambda.1((IEventPlugin)localObject2, this, paramCEArgument));
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
          if (i > 1) {
            for (;;)
            {
              paramCEArgument = (CEArgument)localObject2;
              if (j >= i) {
                break;
              }
              if (localObject1 == null) {
                Intrinsics.throwNpe();
              }
              ((IEventPlugin)((List)localObject1).get(j)).a((Argument)localObject3);
              j += 1;
            }
          }
        }
        if (paramCEArgument != null) {
          return paramCEArgument;
        }
        return "{}";
      }
      if (Intrinsics.areEqual("error", paramCEArgument.c()))
      {
        localObject1 = this.jdField_a_of_type_JavaLangString;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("onScriptEvent error, ");
        ((StringBuilder)localObject2).append(paramCEArgument.d());
        QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
      }
      if (EngineHelper.a.a(paramCEArgument.c())) {
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
  
  private final String a(Argument paramArgument)
  {
    Object localObject1 = (String)null;
    Iterator localIterator = ((Iterable)this.jdField_b_of_type_JavaUtilList).iterator();
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
  
  private final JSONObject a(CEArgument paramCEArgument)
  {
    JSONObject localJSONObject = (JSONObject)null;
    Object localObject2 = (List)this.jdField_b_of_type_JavaUtilMap.get(paramCEArgument.a());
    int i;
    if (localObject2 != null) {
      i = ((List)localObject2).size();
    } else {
      i = 0;
    }
    int j = 1;
    Object localObject1;
    if ((localObject2 != null) && (i != 0))
    {
      if (paramCEArgument.a())
      {
        localObject2 = ((Iterable)localObject2).iterator();
        for (;;)
        {
          localObject1 = localJSONObject;
          if (!((Iterator)localObject2).hasNext()) {
            break;
          }
          localObject1 = (IModuleEventPlugin)((Iterator)localObject2).next();
          this.jdField_a_of_type_AndroidOsHandler.post((Runnable)new CEScriptService.onModuleScriptEvent..inlined.forEach.lambda.1((IModuleEventPlugin)localObject1, this, paramCEArgument));
        }
      }
      localJSONObject = ((IModuleEventPlugin)((List)localObject2).get(0)).a(paramCEArgument);
      localObject1 = localJSONObject;
      if (i > 1) {
        for (;;)
        {
          localObject1 = localJSONObject;
          if (j >= i) {
            break;
          }
          ((IModuleEventPlugin)((List)localObject2).get(j)).a(paramCEArgument);
          j += 1;
        }
      }
      return localObject1;
    }
    if (Intrinsics.areEqual("error", paramCEArgument.c()))
    {
      localObject1 = this.jdField_a_of_type_JavaLangString;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("onScriptEvent error, ");
      ((StringBuilder)localObject2).append(paramCEArgument.d());
      QLog.e((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    }
    return localJSONObject;
  }
  
  private final void a(IModuleEventPlugin paramIModuleEventPlugin)
  {
    Object localObject = paramIModuleEventPlugin.a();
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(localObject))
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      if (localObject != null) {
        ((List)localObject).add(paramIModuleEventPlugin);
      }
    }
    else
    {
      this.jdField_b_of_type_JavaUtilMap.put(localObject, new CEScriptService.addModuleEventPlugin.1(paramIModuleEventPlugin));
    }
  }
  
  private final void b(IModuleEventPlugin paramIModuleEventPlugin)
  {
    Object localObject = paramIModuleEventPlugin.a();
    if (this.jdField_b_of_type_JavaUtilMap.containsKey(localObject))
    {
      localObject = (List)this.jdField_b_of_type_JavaUtilMap.get(localObject);
      if (localObject != null) {
        ((List)localObject).remove(paramIModuleEventPlugin);
      }
    }
  }
  
  private final void b(Script paramScript)
  {
    ??? = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("addScriptToWaitList: ");
    localStringBuilder.append(paramScript);
    QLog.d((String)???, 1, localStringBuilder.toString());
    synchronized (this.c)
    {
      this.c.add(paramScript);
      return;
    }
  }
  
  private final void c(IEventPlugin paramIEventPlugin)
  {
    Iterator localIterator = ((Iterable)paramIEventPlugin.a()).iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      if (this.jdField_a_of_type_JavaUtilMap.containsKey(localObject))
      {
        localObject = (List)this.jdField_a_of_type_JavaUtilMap.get(localObject);
        if (localObject != null) {
          ((List)localObject).add(paramIEventPlugin);
        }
      }
      else
      {
        this.jdField_a_of_type_JavaUtilMap.put(localObject, new CEScriptService.addCmdEventPlugin..inlined.forEach.lambda.1(this, paramIEventPlugin));
      }
    }
  }
  
  private final void d(IEventPlugin paramIEventPlugin)
  {
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
  
  @NotNull
  public CEScriptTaskBuilder a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptTaskCEScriptTaskBuilder;
  }
  
  @Nullable
  public String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "reqParams");
    if (QLog.isColorLevel())
    {
      String str = this.jdField_a_of_type_JavaLangString;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onScriptEvent: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
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
    return a(paramString);
  }
  
  public final void a()
  {
    Object localObject2 = (List)new ArrayList();
    synchronized (this.c)
    {
      ((List)localObject2).addAll((Collection)this.c);
      this.c.clear();
      Object localObject4 = Unit.INSTANCE;
      ??? = ((List)localObject2).iterator();
      while (((Iterator)???).hasNext())
      {
        localObject2 = (Script)((Iterator)???).next();
        localObject4 = this.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("evaluateScript evaluateWaitList: ");
        localStringBuilder.append(localObject2);
        QLog.d((String)localObject4, 1, localStringBuilder.toString());
        if (CmShowWnsUtils.x()) {
          this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CEScriptService.evaluateWaitList.2(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), ((Script)localObject2).a());
        } else {
          this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateJs(((Script)localObject2).a());
        }
      }
      return;
    }
    for (;;)
    {
      throw localObject3;
    }
  }
  
  public void a(@NotNull Script paramScript)
  {
    Intrinsics.checkParameterIsNotNull(paramScript, "script");
    if (!this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a())
    {
      b(paramScript);
      return;
    }
    CharSequence localCharSequence;
    if (paramScript.a().length() > 100) {
      localCharSequence = paramScript.a().subSequence(0, 100);
    } else {
      localCharSequence = (CharSequence)paramScript.a();
    }
    String str = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("evaluateScript id:");
    localStringBuilder.append(paramScript.a());
    localStringBuilder.append(", content:");
    localStringBuilder.append(localCharSequence);
    QLog.d(str, 4, localStringBuilder.toString());
    if (CmShowWnsUtils.x())
    {
      this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateWorldJs((String)new CEScriptService.evaluateScript.1(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a()).get(), paramScript.a());
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().evaluateJs(paramScript.a());
  }
  
  public void a(@NotNull IEventPlugin paramIEventPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramIEventPlugin, "plugin");
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("registerPlugin:");
    ((StringBuilder)localObject2).append(paramIEventPlugin);
    QLog.d((String)localObject1, 4, ((StringBuilder)localObject2).toString());
    localObject1 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject1).lock();
    try
    {
      this.jdField_a_of_type_JavaUtilList.add(paramIEventPlugin);
      if (paramIEventPlugin.a()) {
        this.jdField_b_of_type_JavaUtilList.add(paramIEventPlugin);
      }
      Collections.sort(this.jdField_a_of_type_JavaUtilList, (Comparator)CEScriptService.registerPlugin.1.1.a);
      this.jdField_b_of_type_JavaUtilMap.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      paramIEventPlugin = this.jdField_a_of_type_JavaUtilList.iterator();
      while (paramIEventPlugin.hasNext())
      {
        localObject2 = (IEventPlugin)paramIEventPlugin.next();
        if ((localObject2 instanceof IModuleEventPlugin)) {
          a((IModuleEventPlugin)localObject2);
        } else {
          c((IEventPlugin)localObject2);
        }
      }
      paramIEventPlugin = Unit.INSTANCE;
      ((Lock)localObject1).unlock();
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
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
  
  public final void b()
  {
    Object localObject1 = this.jdField_a_of_type_JavaLangString;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("destroy ");
    ((StringBuilder)localObject2).append(this);
    ((StringBuilder)localObject2).append(" for ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a());
    QLog.i((String)localObject1, 1, ((StringBuilder)localObject2).toString());
    localObject1 = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject1).lock();
    try
    {
      this.jdField_a_of_type_JavaUtilList.clear();
      this.jdField_b_of_type_JavaUtilList.clear();
      this.jdField_a_of_type_JavaUtilMap.clear();
      localObject2 = Unit.INSTANCE;
      return;
    }
    finally
    {
      ((Lock)localObject1).unlock();
    }
  }
  
  public void b(@NotNull IEventPlugin paramIEventPlugin)
  {
    Intrinsics.checkParameterIsNotNull(paramIEventPlugin, "plugin");
    Object localObject = this.jdField_a_of_type_JavaLangString;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("unRegisterPlugin:");
    localStringBuilder.append(paramIEventPlugin);
    QLog.d((String)localObject, 4, localStringBuilder.toString());
    localObject = (Lock)this.jdField_a_of_type_JavaUtilConcurrentLocksReentrantLock;
    ((Lock)localObject).lock();
    try
    {
      if (this.jdField_a_of_type_JavaUtilList.contains(paramIEventPlugin))
      {
        this.jdField_a_of_type_JavaUtilList.remove(paramIEventPlugin);
        if ((paramIEventPlugin instanceof IModuleEventPlugin)) {
          b((IModuleEventPlugin)paramIEventPlugin);
        } else {
          d(paramIEventPlugin);
        }
      }
      if (this.jdField_b_of_type_JavaUtilList.contains(paramIEventPlugin)) {
        this.jdField_b_of_type_JavaUtilList.remove(paramIEventPlugin);
      }
      paramIEventPlugin = Unit.INSTANCE;
      return;
    }
    finally
    {
      ((Lock)localObject).unlock();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.CEScriptService
 * JD-Core Version:    0.7.0.1
 */