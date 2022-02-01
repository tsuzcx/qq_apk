package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.CEEngineContext;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.render.IRecordFrameListener;
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
  public static final FrameRecorderPlugin.Companion a;
  @NotNull
  private CEEngineContext jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext;
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowCrossengineScriptPluginFrameRecorderPlugin$Companion = new FrameRecorderPlugin.Companion(null);
  }
  
  public FrameRecorderPlugin(@NotNull CEEngineContext paramCEEngineContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext = paramCEEngineContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.GENERAL;
  }
  
  private final JSONObject b(CEArgument paramCEArgument)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("startRecord : ");
    localStringBuilder.append(paramCEArgument.b());
    QLog.d("[cmshow][CECMShowOffscreenEngine]_FrameRecorderPlugin", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().a(true);
    paramCEArgument = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().a();
    if (paramCEArgument != null) {
      paramCEArgument.a(0.0666667F);
    }
    return null;
  }
  
  private final JSONObject c(CEArgument paramCEArgument)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("stopRecord : ");
    localStringBuilder.append(paramCEArgument.b());
    QLog.d("[cmshow][CECMShowOffscreenEngine]_FrameRecorderPlugin", 1, localStringBuilder.toString());
    this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().a(false);
    paramCEArgument = this.jdField_a_of_type_ComTencentMobileqqCmshowCrossengineCEEngineContext.a().a();
    if (paramCEArgument != null) {
      paramCEArgument.a(true);
    }
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  }
  
  @NotNull
  public String a()
  {
    return "FrameRecorder";
  }
  
  @Deprecated(message="ModuleEventPlugin通过handleModuleEvent进行分发", replaceWith=@ReplaceWith(expression="null", imports={}))
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    return IModuleEventPlugin.DefaultImpls.a(this, paramArgument);
  }
  
  @Deprecated(message="ModuleEventPlugin依赖moduleName进行分发", replaceWith=@ReplaceWith(expression="emptyList()", imports={}))
  @NotNull
  public List<String> a()
  {
    return IModuleEventPlugin.DefaultImpls.a(this);
  }
  
  @Nullable
  public JSONObject a(@NotNull CEArgument paramCEArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramCEArgument, "argument");
    String str = paramCEArgument.c();
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
  
  public boolean a()
  {
    return IModuleEventPlugin.DefaultImpls.a(this);
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IModuleEventPlugin.DefaultImpls.a(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.FrameRecorderPlugin
 * JD-Core Version:    0.7.0.1
 */