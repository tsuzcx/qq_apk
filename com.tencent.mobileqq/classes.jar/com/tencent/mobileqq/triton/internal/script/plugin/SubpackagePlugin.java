package com.tencent.mobileqq.triton.internal.script.plugin;

import com.tencent.mobileqq.triton.TritonEngine;
import com.tencent.mobileqq.triton.engine.TTEngine;
import com.tencent.mobileqq.triton.game.GameLauncher;
import com.tencent.mobileqq.triton.internal.engine.EngineContext;
import com.tencent.mobileqq.triton.internal.utils.ApiUtil;
import com.tencent.mobileqq.triton.script.Argument;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin;
import com.tencent.mobileqq.triton.script.ComposableScriptPlugin.DefaultImpls;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/triton/internal/script/plugin/SubpackagePlugin;", "Lcom/tencent/mobileqq/triton/script/ComposableScriptPlugin;", "engineContext", "Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;", "(Lcom/tencent/mobileqq/triton/internal/engine/EngineContext;)V", "subpackageTaskId", "Ljava/util/concurrent/atomic/AtomicInteger;", "supportedEvents", "", "", "getSupportedEvents", "()Ljava/util/Set;", "createSubPackageTask", "arguments", "Lcom/tencent/mobileqq/triton/script/Argument;", "onCall", "eventName", "Companion", "Triton_release"}, k=1, mv={1, 1, 16})
public final class SubpackagePlugin
  implements ComposableScriptPlugin
{
  private static final String API_CREATE_LOAD_SUBPACKAGE_TASK = "createLoadSubPackageTask";
  public static final SubpackagePlugin.Companion Companion = new SubpackagePlugin.Companion(null);
  private static final String EVENT_ON_LOAD_SUBPACKAGE_TASK_STATE_CHANGE = "onLoadSubPackageTaskStateChange";
  private static final String TAG = "SubpackagePlugin";
  private static final Set<String> supportedEvents = SetsKt.setOf("createLoadSubPackageTask");
  private final EngineContext engineContext;
  private final AtomicInteger subpackageTaskId;
  
  public SubpackagePlugin(@NotNull EngineContext paramEngineContext)
  {
    this.engineContext = paramEngineContext;
    this.subpackageTaskId = new AtomicInteger(0);
  }
  
  private final String createSubPackageTask(Argument paramArgument)
  {
    int j = this.subpackageTaskId.getAndIncrement();
    String str = paramArgument.getParams().optString("name");
    CharSequence localCharSequence = (CharSequence)str;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      paramArgument = new JSONObject();
      paramArgument.put("loadTaskId", j);
      paramArgument.put("state", "fail");
      paramArgument = ApiUtil.wrapCallbackFail("createLoadSubPackageTask", paramArgument).toString();
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackFail…TASK, failObj).toString()");
      return paramArgument;
    }
    this.engineContext.getTtEngine().getGameLauncher().loadSubpackage(str, (Function2)new SubpackagePlugin.createSubPackageTask.1(j, paramArgument), (Function1)new SubpackagePlugin.createSubPackageTask.2(str, j, paramArgument));
    paramArgument = new JSONObject();
    paramArgument.put("loadTaskId", j);
    paramArgument = ApiUtil.wrapCallbackOk("createLoadSubPackageTask", paramArgument).toString();
    Intrinsics.checkExpressionValueIsNotNull(paramArgument, "ApiUtil.wrapCallbackOk(A…SK, resultObj).toString()");
    return paramArgument;
  }
  
  @NotNull
  public Set<String> getSupportedEvents()
  {
    return supportedEvents;
  }
  
  @Nullable
  public String onCall(@NotNull String paramString, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "eventName");
    Intrinsics.checkParameterIsNotNull(paramArgument, "arguments");
    switch (paramString.hashCode())
    {
    }
    do
    {
      return null;
    } while (!paramString.equals("createLoadSubPackageTask"));
    return createSubPackageTask(paramArgument);
  }
  
  public void onCreate(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ComposableScriptPlugin.DefaultImpls.onCreate(this, paramTritonEngine);
  }
  
  public void onDestroy()
  {
    ComposableScriptPlugin.DefaultImpls.onDestroy(this);
  }
  
  public void onFirstFrame()
  {
    ComposableScriptPlugin.DefaultImpls.onFirstFrame(this);
  }
  
  public void onGameLaunched(@NotNull TritonEngine paramTritonEngine)
  {
    Intrinsics.checkParameterIsNotNull(paramTritonEngine, "engine");
    ComposableScriptPlugin.DefaultImpls.onGameLaunched(this, paramTritonEngine);
  }
  
  public void onStart()
  {
    ComposableScriptPlugin.DefaultImpls.onStart(this);
  }
  
  public void onStop()
  {
    ComposableScriptPlugin.DefaultImpls.onStop(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.triton.internal.script.plugin.SubpackagePlugin
 * JD-Core Version:    0.7.0.1
 */