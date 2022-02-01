package com.tencent.mobileqq.triton.internal.script;

import android.util.SparseArray;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.exception.ErrorCodes;
import com.tencent.mobileqq.triton.exception.TritonException;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.engine.StatisticsManagerImpl;
import com.tencent.mobileqq.triton.internal.lifecycle.ValueHolder;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.InspectorAgent;
import com.tencent.mobileqq.triton.script.ScriptContextType;
import com.tencent.mobileqq.triton.script.ScriptFile;
import com.tencent.mobileqq.triton.script.ScriptFile.Content;
import com.tencent.mobileqq.triton.script.ScriptFile.Path;
import com.tencent.mobileqq.triton.script.ScriptPlugin;
import com.tencent.mobileqq.triton.statistic.ErrorCallback;
import com.tencent.mobileqq.triton.statistic.ScriptLoadResult;
import com.tencent.mobileqq.triton.statistic.ScriptLoadStatistic;
import io.github.landerlyoung.jenny.NativeClass;
import io.github.landerlyoung.jenny.NativeMethodProxy;
import io.github.landerlyoung.jenny.NativeProxy;
import java.io.File;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/ScriptRuntime;", "", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "scriptPlugin", "Lcom/tencent/mobileqq/triton/script/ScriptPlugin;", "nativeHandle", "", "type", "Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "threadId", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;Lcom/tencent/mobileqq/triton/script/ScriptPlugin;JLcom/tencent/mobileqq/triton/script/ScriptContextType;J)V", "nativeBufferManager", "Lcom/tencent/mobileqq/triton/internal/script/NativeBufferManager;", "scriptTaskAssociation", "Landroid/util/SparseArray;", "getType", "()Lcom/tencent/mobileqq/triton/script/ScriptContextType;", "callScriptMethod", "", "scriptObjectHandle", "", "functionName", "", "data", "callback2Script", "callbackId", "result", "convertToScriptLoadStatus", "Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "scriptName", "contextType", "scriptPath", "codeLoadResult", "timeCost", "", "outException", "", "(Ljava/lang/String;Lcom/tencent/mobileqq/triton/script/ScriptContextType;Ljava/lang/String;I[J[Ljava/lang/String;)Lcom/tencent/mobileqq/triton/statistic/ScriptLoadStatistic;", "destroy", "", "evaluateJs", "js", "isScriptThread", "loadScript", "scriptFile", "Lcom/tencent/mobileqq/triton/script/ScriptFile;", "scriptContent", "codeCacheAbsolutePath", "onScriptCall", "event", "params", "postScriptThread", "task", "Ljava/lang/Runnable;", "runOnScriptThread", "setInspectorAgent", "inspectorAgent", "Lcom/tencent/mobileqq/triton/script/InspectorAgent;", "subscribe2Script", "eventName", "Companion", "ScriptArgumentImpl", "ScriptTaskImpl", "Triton_release"}, k=1, mv={1, 1, 16})
@NativeClass(namespace="triton::jni")
@NativeProxy(allFields=false, allMethods=false, namespace="triton::jni")
public final class ScriptRuntime
{
  public static final ScriptRuntime.Companion Companion = new ScriptRuntime.Companion(null);
  private static final String NATIVE_BUFFERS = "__nativeBuffers__";
  private static final String TAG = "ScriptRuntime <API>";
  private final EngineContext engineContext;
  private final NativeBufferManager nativeBufferManager;
  private long nativeHandle;
  private final ScriptPlugin scriptPlugin;
  private final SparseArray<Object> scriptTaskAssociation;
  private final long threadId;
  @NotNull
  private final ScriptContextType type;
  
  public ScriptRuntime(@NotNull EngineContext paramEngineContext, @NotNull ScriptPlugin paramScriptPlugin, long paramLong1, @NotNull ScriptContextType paramScriptContextType, long paramLong2)
  {
    this.engineContext = paramEngineContext;
    this.scriptPlugin = paramScriptPlugin;
    this.nativeHandle = paramLong1;
    this.type = paramScriptContextType;
    this.threadId = paramLong2;
    this.scriptTaskAssociation = new SparseArray();
    this.nativeBufferManager = new NativeBufferManager(this.nativeHandle);
  }
  
  private final boolean callScriptMethod(int paramInt, String paramString1, String paramString2)
  {
    return false;
  }
  
  @VisibleForTesting
  private final ScriptLoadStatistic convertToScriptLoadStatus(String paramString1, ScriptContextType paramScriptContextType, String paramString2, int paramInt, long[] paramArrayOfLong, String[] paramArrayOfString)
  {
    ScriptLoadResult localScriptLoadResult;
    label53:
    long l1;
    long l2;
    long l3;
    long l4;
    switch (paramInt)
    {
    default: 
      localScriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
      if (paramString2 != null)
      {
        l1 = paramArrayOfLong[0];
        l2 = paramArrayOfLong[1];
        l3 = paramArrayOfLong[2];
        l4 = paramArrayOfLong[3];
        paramArrayOfLong = paramArrayOfString[0];
        if (paramArrayOfLong == null) {
          break label173;
        }
      }
      break;
    }
    for (;;)
    {
      return new ScriptLoadStatistic(localScriptLoadResult, paramScriptContextType, paramString1, paramString2, l1, l2, l3, l4, paramArrayOfLong);
      localScriptLoadResult = ScriptLoadResult.FAIL_INVALID_STATE;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_EXECUTE;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_COMPILE;
      break;
      localScriptLoadResult = ScriptLoadResult.FAIL_READ_SCRIPT;
      break;
      localScriptLoadResult = ScriptLoadResult.SUCCESS_WITH_CACHE;
      break;
      localScriptLoadResult = ScriptLoadResult.SUCCESS_WITHOUT_CACHE;
      break;
      localScriptLoadResult = ScriptLoadResult.SUCCESS_BUT_CACHE_REJECTED;
      break;
      paramString2 = "";
      break label53;
      label173:
      paramArrayOfLong = "";
    }
  }
  
  private final boolean isScriptThread()
  {
    Thread localThread = Thread.currentThread();
    Intrinsics.checkExpressionValueIsNotNull(localThread, "Thread.currentThread()");
    return localThread.getId() == this.threadId;
  }
  
  private final ScriptLoadStatistic loadScript(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    long[] arrayOfLong = new long[4];
    String[] arrayOfString = new String[1];
    try
    {
      i = ScriptRuntime.Companion.access$nativeLoadScriptWithCodeCache(Companion, this.nativeHandle, paramString1, paramString2, paramString3, paramString4, arrayOfLong, arrayOfString);
      return convertToScriptLoadStatus(paramString3, this.type, paramString1, i, arrayOfLong, arrayOfString);
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        int i = ScriptRuntime.Companion.access$nativeLoadScriptWithCodeCache(Companion, this.nativeHandle, paramString1, paramString2, paramString3, paramString4, arrayOfLong, arrayOfString);
      }
    }
  }
  
  @JvmStatic
  private static final native void nativeCallback2Script(long paramLong, int paramInt, String paramString1, String paramString2);
  
  @JvmStatic
  private static final native void nativeEvaluateScript(long paramLong, String paramString);
  
  @JvmStatic
  private static final native int nativeLoadScriptWithCodeCache(long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, long[] paramArrayOfLong, String[] paramArrayOfString);
  
  @JvmStatic
  private static final native void nativeSubscribe2Script(long paramLong, String paramString1, String paramString2, String paramString3);
  
  private final boolean postScriptThread(Runnable paramRunnable)
  {
    return this.engineContext.getTtEngine().postRunnable(paramRunnable);
  }
  
  public final boolean callback2Script(int paramInt, @Nullable String paramString)
  {
    return postScriptThread((Runnable)new ScriptRuntime.callback2Script.1(this, paramInt, paramString));
  }
  
  public final void destroy()
  {
    try
    {
      this.nativeHandle = 0L;
      Unit localUnit = Unit.INSTANCE;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void evaluateJs(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "js");
    runOnScriptThread((Runnable)new ScriptRuntime.evaluateJs.1(this, paramString));
  }
  
  @NotNull
  public final ScriptContextType getType()
  {
    return this.type;
  }
  
  @NotNull
  public final ScriptLoadStatistic loadScript(@NotNull ScriptFile paramScriptFile)
  {
    String str1 = null;
    Intrinsics.checkParameterIsNotNull(paramScriptFile, "scriptFile");
    if (!isScriptThread()) {
      throw ((Throwable)new IllegalStateException(("loadScript " + paramScriptFile + " not on script thread").toString()));
    }
    if ((paramScriptFile instanceof ScriptFile.Path))
    {
      str1 = ((ScriptFile.Path)paramScriptFile).getPath().getAbsolutePath();
      Intrinsics.checkExpressionValueIsNotNull(str1, "scriptFile.path.absolutePath");
      str2 = ((ScriptFile.Path)paramScriptFile).getName();
      paramScriptFile = ((ScriptFile.Path)paramScriptFile).getCodeCache();
      if (paramScriptFile != null) {}
      for (paramScriptFile = paramScriptFile.getAbsolutePath();; paramScriptFile = null) {
        return loadScript(str1, "", str2, paramScriptFile);
      }
    }
    paramScriptFile = (ScriptFile.Content)paramScriptFile;
    String str2 = paramScriptFile.getContent();
    String str3 = paramScriptFile.getName();
    File localFile = paramScriptFile.getCodeCache();
    paramScriptFile = str1;
    if (localFile != null) {
      paramScriptFile = localFile.getAbsolutePath();
    }
    return loadScript("", str2, str3, paramScriptFile);
  }
  
  @NativeMethodProxy
  @NotNull
  public final String onScriptCall(@NotNull String paramString1, @NotNull String paramString2, int paramInt1, int paramInt2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "event");
    Intrinsics.checkParameterIsNotNull(paramString2, "params");
    String str;
    ErrorCallback localErrorCallback;
    try
    {
      paramString2 = this.scriptPlugin.onCall(paramString1, (Argument)new ScriptRuntime.ScriptArgumentImpl(this, paramString2, paramInt1, paramInt2));
      if (paramString2 != null) {
        return paramString2;
      }
      return "{}";
    }
    catch (IllegalArgumentException paramString2)
    {
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, paramString2.getMessage()).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "ApiUtil.wrapCallbackFail…ll, e.message).toString()");
      return paramString1;
    }
    catch (Throwable localThrowable)
    {
      str = "ScriptPlugin handle event " + paramString1 + " failed";
      localErrorCallback = (ErrorCallback)this.engineContext.getStatisticsManager().getErrorCallback().getValue();
      if (localErrorCallback == null) {
        break label157;
      }
    }
    ErrorCodes localErrorCodes = ErrorCodes.SCRIPT_PLUGIN_CALL_FAIL;
    if ((localThrowable instanceof TritonException))
    {
      paramString2 = (TritonException)localThrowable;
      localErrorCallback.onError(str, paramString2);
      label157:
      paramString1 = ApiUtil.wrapCallbackFail(paramString1, null, localThrowable.getMessage()).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramString1, "ApiUtil.wrapCallbackFail…ll, e.message).toString()");
      return paramString1;
    }
    paramString2 = localThrowable.getMessage();
    if (paramString2 != null) {}
    for (;;)
    {
      paramString2 = new TritonException(paramString2, localErrorCodes, localThrowable);
      break;
      paramString2 = "";
    }
  }
  
  public final void runOnScriptThread(@NotNull Runnable paramRunnable)
  {
    Intrinsics.checkParameterIsNotNull(paramRunnable, "task");
    if (isScriptThread())
    {
      paramRunnable.run();
      return;
    }
    postScriptThread(paramRunnable);
  }
  
  public final void setInspectorAgent(@Nullable InspectorAgent paramInspectorAgent)
  {
    if (paramInspectorAgent != null) {}
  }
  
  public final boolean subscribe2Script(@NotNull String paramString1, @Nullable String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "eventName");
    return postScriptThread((Runnable)new ScriptRuntime.subscribe2Script.1(this, paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.ScriptRuntime
 * JD-Core Version:    0.7.0.1
 */