package com.tencent.mobileqq.cmshow.crossengine.script.plugin;

import com.tencent.mobileqq.cmshow.crossengine.model.CEArgument;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin.DefaultImpls;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class IModuleEventPlugin$DefaultImpls
{
  @Deprecated(message="ModuleEventPlugin通过handleModuleEvent进行分发", replaceWith=@ReplaceWith(expression="null", imports={}))
  @Nullable
  public static String a(IModuleEventPlugin paramIModuleEventPlugin, @NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    return null;
  }
  
  @Deprecated(message="ModuleEventPlugin依赖moduleName进行分发", replaceWith=@ReplaceWith(expression="emptyList()", imports={}))
  @NotNull
  public static List<String> a(IModuleEventPlugin paramIModuleEventPlugin)
  {
    return CollectionsKt.emptyList();
  }
  
  @Nullable
  public static JSONObject a(IModuleEventPlugin paramIModuleEventPlugin, @NotNull CEArgument paramCEArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramCEArgument, "argument");
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[cmshow][CECMShowOffscreenEngine]_");
    localStringBuilder.append(paramIModuleEventPlugin.a());
    paramIModuleEventPlugin = localStringBuilder.toString();
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("[handleModuleEvent] error, no method to handle this cmd:");
    localStringBuilder.append(paramCEArgument.c());
    localStringBuilder.append("! ");
    QLog.e(paramIModuleEventPlugin, 1, localStringBuilder.toString());
    return null;
  }
  
  public static boolean a(IModuleEventPlugin paramIModuleEventPlugin)
  {
    return IEventPlugin.DefaultImpls.a((IEventPlugin)paramIModuleEventPlugin);
  }
  
  public static boolean a(IModuleEventPlugin paramIModuleEventPlugin, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IEventPlugin.DefaultImpls.a((IEventPlugin)paramIModuleEventPlugin, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.crossengine.script.plugin.IModuleEventPlugin.DefaultImpls
 * JD-Core Version:    0.7.0.1
 */