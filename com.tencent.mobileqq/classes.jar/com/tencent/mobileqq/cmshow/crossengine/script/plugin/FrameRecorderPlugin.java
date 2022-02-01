package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import android.os.Handler;
import com.tencent.mobileqq.cmshow.crossengine.CEEngineContext;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/FrameRecorderPlugin;", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "engineContext", "Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "(Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;)V", "getEngineContext", "()Lcom/tencent/mobileqq/cmshow/crossengine/CEEngineContext;", "setEngineContext", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleModuleEvent", "Lorg/json/JSONObject;", "argument", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "startRecord", "stopRecord", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class FrameRecorderPlugin
  implements IModuleEventPlugin
{
  public static final FrameRecorderPlugin.Companion a = new FrameRecorderPlugin.Companion(null);
  @NotNull
  private final PluginCmdConstant.PlugPriority c;
  @NotNull
  private CEEngineContext d;
  
  public FrameRecorderPlugin(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.d = paramCEEngineContext;
    this.c = PluginCmdConstant.PlugPriority.GENERAL;
  }
  
  private final JSONObject b(CEArgument paramCEArgument)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord : ");
    localStringBuilder.append(paramCEArgument.e());
    QLog.d("[cmshow][CECMShowOffscreenEngine]_FrameRecorderPlugin", 1, localStringBuilder.toString());
    this.d.f().a(true);
    this.d.b().post((Runnable)new FrameRecorderPlugin.startRecord.1(this));
    return null;
  }
  
  private final JSONObject c(CEArgument paramCEArgument)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopRecord : ");
    localStringBuilder.append(paramCEArgument.e());
    QLog.d("[cmshow][CECMShowOffscreenEngine]_FrameRecorderPlugin", 1, localStringBuilder.toString());
    this.d.f().a(false);
    this.d.b().post((Runnable)new FrameRecorderPlugin.stopRecord.1(this));
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.c;
  }
  
  @Deprecated(message="ModuleEventPlugin通过handleModuleEvent进行分发", replaceWith=@ReplaceWith(expression="null", imports={}))
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    return IModuleEventPlugin.DefaultImpls.a(this, paramArgument);
  }
  
  @Nullable
  public JSONObject a(@NotNull CEArgument paramCEArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramCEArgument, "argument");
    String str = paramCEArgument.f();
    int i = str.hashCode();
    if (i != -241208525)
    {
      if ((i == 601469715) && (str.equals("StopRecord"))) {
        return c(paramCEArgument);
      }
    }
    else if (str.equals("StartRecord")) {
      return b(paramCEArgument);
    }
    return IModuleEventPlugin.DefaultImpls.a(this, paramCEArgument);
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IModuleEventPlugin.DefaultImpls.a(this, paramString);
  }
  
  @NotNull
  public String b()
  {
    return "FrameRecorder";
  }
  
  @Deprecated(message="ModuleEventPlugin依赖moduleName进行分发", replaceWith=@ReplaceWith(expression="emptyList()", imports={}))
  @NotNull
  public List<String> c()
  {
    return IModuleEventPlugin.DefaultImpls.a(this);
  }
  
  public boolean d()
  {
    return IModuleEventPlugin.DefaultImpls.b(this);
  }
  
  @NotNull
  public final CEEngineContext e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FrameRecorderPlugin
 * JD-Core Version:    0.7.0.1
 */