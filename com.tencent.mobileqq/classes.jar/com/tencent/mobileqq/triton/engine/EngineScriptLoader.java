package com.tencent.mobileqq.triton.engine;

import android.os.SystemClock;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.filesystem.EnginePackage;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.init.ScriptLoader;
import com.tencent.mobileqq.triton.internal.script.ScriptRuntime;
import com.tencent.mobileqq.triton.internal.script.ScriptSystem;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/engine/EngineScriptLoader;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "<set-?>", "Lcom/tencent/mobileqq/triton/exception/TritonException;", "engineScriptInitException", "getEngineScriptInitException", "()Lcom/tencent/mobileqq/triton/exception/TritonException;", "engineScriptLoadStatics", "Ljava/util/ArrayList;", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "Lkotlin/collections/ArrayList;", "getEngineScriptLoadStatics", "()Ljava/util/ArrayList;", "", "loadEngineScriptEndTime", "getLoadEngineScriptEndTime", "()J", "loadScriptScriptTimeMs", "getLoadScriptScriptTimeMs", "initJsRuntime", "", "injectGlobalConfig", "contextType", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class EngineScriptLoader
{
  public static final EngineScriptLoader.Companion Companion = new EngineScriptLoader.Companion(null);
  private static final String DEFAULT_GLOBAL_CONFIG = "self = GameGlobal = __TT__GLOBAL__ = global = window = this;\nself.__ttObjdec__ = {};\nself.wx = self.wx || {};\nself.WeixinNativeBuffer = Triton.WeixinNativeBuffer;\nvar __wxConfig = __wxConfig || {};\n__wxConfig.env = {};\n__wxConfig.env.USER_DATA_PATH = 'wxfile://usr';\n__wxConfig.platform = 'android';\nwx.env = __wxConfig.env;\nvar __qqConfig = __wxConfig || {};";
  private final EngineContext engineContext;
  @Nullable
  private TritonException engineScriptInitException;
  @NotNull
  private final ArrayList<ScriptLoadStatistic> engineScriptLoadStatics;
  private long loadEngineScriptEndTime;
  private long loadScriptScriptTimeMs;
  
  public EngineScriptLoader(@NotNull EngineContext paramEngineContext)
  {
    this.engineContext = paramEngineContext;
    this.engineScriptLoadStatics = new ArrayList();
  }
  
  private final void injectGlobalConfig(ScriptContextType paramScriptContextType)
  {
    ScriptRuntime localScriptRuntime = this.engineContext.getScriptSystem().getScriptEngine(paramScriptContextType);
    paramScriptContextType = this.engineContext.getEnginePackage().getGlobalConfig();
    if (paramScriptContextType != null) {}
    for (;;)
    {
      localScriptRuntime.evaluateJs(paramScriptContextType);
      return;
      paramScriptContextType = DEFAULT_GLOBAL_CONFIG;
    }
  }
  
  @Nullable
  public final TritonException getEngineScriptInitException()
  {
    return this.engineScriptInitException;
  }
  
  @NotNull
  public final ArrayList<ScriptLoadStatistic> getEngineScriptLoadStatics()
  {
    return this.engineScriptLoadStatics;
  }
  
  public final long getLoadEngineScriptEndTime()
  {
    return this.loadEngineScriptEndTime;
  }
  
  public final long getLoadScriptScriptTimeMs()
  {
    return this.loadScriptScriptTimeMs;
  }
  
  public final void initJsRuntime()
  {
    ErrorCodes localErrorCodes;
    try
    {
      long l = SystemClock.uptimeMillis();
      localObject = ScriptLoader.INSTANCE.getEngineScripts(this.engineContext.getEnginePackage());
      injectGlobalConfig(ScriptContextType.MAIN);
      ScriptRuntime localScriptRuntime = this.engineContext.getScriptSystem().getScriptEngine(ScriptContextType.MAIN);
      this.engineScriptLoadStatics.add(localScriptRuntime.loadScript((ScriptFile)MapsKt.getValue((Map)localObject, ScriptContextType.MAIN)));
      injectGlobalConfig(ScriptContextType.OPEN_DATA);
      localScriptRuntime = this.engineContext.getScriptSystem().getScriptEngine(ScriptContextType.OPEN_DATA);
      this.engineScriptLoadStatics.add(localScriptRuntime.loadScript((ScriptFile)MapsKt.getValue((Map)localObject, ScriptContextType.OPEN_DATA)));
      this.loadEngineScriptEndTime = SystemClock.uptimeMillis();
      this.loadScriptScriptTimeMs = (SystemClock.uptimeMillis() - l);
      return;
    }
    catch (Throwable localThrowable)
    {
      localErrorCodes = ErrorCodes.SCRIPT_LOAD_FAIL;
      if (!(localThrowable instanceof TritonException)) {
        break label158;
      }
    }
    Object localObject = (TritonException)localThrowable;
    this.engineScriptInitException = ((TritonException)localObject);
    return;
    label158:
    localObject = localThrowable.getMessage();
    if (localObject != null) {}
    for (;;)
    {
      localObject = new TritonException((String)localObject, localErrorCodes, localThrowable);
      break;
      localObject = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.engine.EngineScriptLoader
 * JD-Core Version:    0.7.0.1
 */