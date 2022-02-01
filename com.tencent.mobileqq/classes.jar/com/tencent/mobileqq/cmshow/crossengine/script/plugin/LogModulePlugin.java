package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import android.text.TextUtils;
import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
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

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/LogModulePlugin;", "Lcom/tencent/mobileqq/cmshow/crossengine/script/plugin/IModuleEventPlugin;", "()V", "moduleName", "", "getModuleName", "()Ljava/lang/String;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleModuleEvent", "Lorg/json/JSONObject;", "argument", "Lcom/tencent/mobileqq/cmshow/crossengine/model/CEArgument;", "print", "reqData", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class LogModulePlugin
  implements IModuleEventPlugin
{
  public static final LogModulePlugin.Companion a = new LogModulePlugin.Companion(null);
  @NotNull
  private final PluginCmdConstant.PlugPriority c = PluginCmdConstant.PlugPriority.GENERAL;
  
  private final JSONObject b(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    try
    {
      localObject = new JSONObject(paramString);
      paramString = ((JSONObject)localObject).optString("tag");
      int i = ((JSONObject)localObject).optInt("level");
      localObject = ((JSONObject)localObject).optString("msg");
      if (TextUtils.isEmpty((CharSequence)paramString))
      {
        paramString = "[cmshow][CECMShowOffscreenEngine]_LogModulePlugin";
      }
      else
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[cmshow][CECMShowOffscreenEngine]_LogModulePlugin.");
        localStringBuilder.append(paramString);
        paramString = localStringBuilder.toString();
      }
      if (i > 0)
      {
        QLog.e(paramString, 1, (String)localObject);
        return null;
      }
      QLog.d(paramString, 1, (String)localObject);
      return null;
    }
    catch (Exception paramString)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[print] error, ");
      ((StringBuilder)localObject).append(paramString);
      QLog.e("[cmshow][CECMShowOffscreenEngine]_LogModulePlugin", 1, ((StringBuilder)localObject).toString());
    }
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
    if ((str.hashCode() == 106934957) && (str.equals("print"))) {
      return b(paramCEArgument.e());
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
    return "Log";
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.LogModulePlugin
 * JD-Core Version:    0.7.0.1
 */