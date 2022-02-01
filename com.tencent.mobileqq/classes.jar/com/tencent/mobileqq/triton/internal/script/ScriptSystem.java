package com.tencent.mobileqq.triton.internal.script;

import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.Logger;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptSystem;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Lcom/tencent/mobileqq/triton/script/ScriptPlugin;)V", "engineMap", "Ljava/util/HashMap;", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;", "Lkotlin/collections/HashMap;", "getScriptEngine", "type", "onScriptEngineChange", "createOrDestroy", "", "engineType", "", "ptr", "", "runOnScriptThread", "", "task", "Ljava/lang/Runnable;", "saveCodeCache", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeProxy(allFields=false, allMethods=false, namespace="triton::jni")
public final class ScriptSystem
{
  public static final ScriptSystem.Companion Companion = new ScriptSystem.Companion(null);
  private static final String TAG = "ScriptSystem";
  private final EngineContext engineContext;
  private final HashMap<ScriptContextType, ScriptRuntime> engineMap;
  private final ScriptPlugin scriptPlugin;
  
  public ScriptSystem(@NotNull EngineContext paramEngineContext, @NotNull ScriptPlugin paramScriptPlugin)
  {
    this.engineContext = paramEngineContext;
    this.scriptPlugin = paramScriptPlugin;
    this.engineMap = new HashMap();
  }
  
  @NativeMethodProxy
  private final ScriptRuntime onScriptEngineChange(boolean paramBoolean, int paramInt, long paramLong)
  {
    Object localObject = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localObject, "Thread.currentThread()");
    long l = ((Thread)localObject).getId();
    localObject = ScriptSystem.Companion.access$toScriptContextType(Companion, paramInt);
    Logger.i$default("ScriptSystem", "onScriptEngineChange, createOrDestroy:" + paramBoolean + ", contextType:" + localObject + ", ptr:" + paramLong + ", threadId:" + l, null, 4, null);
    if (paramBoolean)
    {
      ((Map)this.engineMap).put(localObject, new ScriptRuntime(this.engineContext, this.scriptPlugin, paramLong, (ScriptContextType)localObject, l));
      return (ScriptRuntime)this.engineMap.get(localObject);
    }
    localObject = this.engineMap.remove(localObject);
    if (localObject == null) {
      Intrinsics.throwNpe();
    }
    ((ScriptRuntime)localObject).destroy();
    return null;
  }
  
  @NotNull
  public final ScriptRuntime getScriptEngine(@NotNull ScriptContextType paramScriptContextType)
  {
    Intrinsics.checkParameterIsNotNull(paramScriptContextType, "type");
    return (ScriptRuntime)MapsKt.getValue((Map)this.engineMap, paramScriptContextType);
  }
  
  public final void runOnScriptThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "task");
    this.engineContext.getTtEngine().postRunnable(paramRunnable);
  }
  
  public final void saveCodeCache()
  {
    this.engineContext.getTtEngine().saveScriptCodeCache();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptSystem
 * JD-Core Version:    0.7.0.1
 */