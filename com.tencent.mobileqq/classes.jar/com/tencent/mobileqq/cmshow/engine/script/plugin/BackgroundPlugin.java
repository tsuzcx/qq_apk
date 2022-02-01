package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.cmshow.brickengine.apollo.IRenderCallback;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BackgroundPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "renderCallback", "Ljava/lang/ref/WeakReference;", "Lcom/tencent/mobileqq/cmshow/brickengine/apollo/IRenderCallback;", "(Ljava/lang/ref/WeakReference;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleBackgroundActionStatusChange", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleEvent", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BackgroundPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final BackgroundPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf("cs.script_action_status_notify.local");
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  private final WeakReference<IRenderCallback> jdField_a_of_type_JavaLangRefWeakReference;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBackgroundPlugin$Companion = new BackgroundPlugin.Companion(null);
  }
  
  public BackgroundPlugin(@NotNull WeakReference<IRenderCallback> paramWeakReference)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = paramWeakReference;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.UI;
  }
  
  private final String b(Argument paramArgument)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleBackgroundActionStatusChange, argument:");
    localStringBuilder.append(paramArgument.d());
    QLog.i("[cmshow][BackgroundPlugin]", 1, localStringBuilder.toString());
    try
    {
      paramArgument = new JSONObject(paramArgument.b());
      int i = paramArgument.optInt("taskId", -1);
      int j = paramArgument.optInt("status", -1);
      if (j != 1)
      {
        if (j != 2) {
          return null;
        }
        paramArgument = (IRenderCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramArgument != null)
        {
          paramArgument.a(i, 0, null);
          return null;
        }
      }
      else
      {
        paramArgument = (IRenderCallback)this.jdField_a_of_type_JavaLangRefWeakReference.get();
        if (paramArgument != null)
        {
          paramArgument.a(i, null);
          return null;
        }
      }
    }
    catch (JSONException paramArgument)
    {
      QLog.e("[cmshow][BackgroundPlugin]", 1, "handleBackgroundActionStatusChange exception", (Throwable)paramArgument);
    }
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  }
  
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    String str = paramArgument.c();
    if ((str.hashCode() == -439099872) && (str.equals("cs.script_action_status_notify.local"))) {
      return b(paramArgument);
    }
    return null;
  }
  
  @NotNull
  public List<String> a()
  {
    return jdField_a_of_type_JavaUtilList;
  }
  
  public boolean a()
  {
    return IEventPlugin.DefaultImpls.a(this);
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IEventPlugin.DefaultImpls.a(this, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.BackgroundPlugin
 * JD-Core Version:    0.7.0.1
 */