package com.tencent.mobileqq.cmshow.engine.action;

import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin;
import com.tencent.mobileqq.cmshow.engine.script.plugin.IEventPlugin.DefaultImpls;
import com.tencent.mobileqq.cmshow.engine.script.plugin.PluginCmdConstant.PlugPriority;
import com.tencent.mobileqq.cmshow.engine.script.task.PlayActionTask;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/cmshow/engine/action/PlayActionScript$buildInPlugin$1", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleActionStatusChange", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleEvent", "", "observedEvents", "", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class PlayActionScript$buildInPlugin$1
  implements IEventPlugin
{
  @NotNull
  private final PluginCmdConstant.PlugPriority c = PluginCmdConstant.PlugPriority.GENERAL;
  
  private final void b(Argument paramArgument)
  {
    PlayActionScript.h();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleActionStatusChange, ");
    localStringBuilder.append(paramArgument.g());
    QLog.e("[cmshow][PlayActionScript]", 1, localStringBuilder.toString());
    paramArgument = new JSONObject(paramArgument.e());
    if (paramArgument.optInt("taskId") != this.a.f().m()) {
      return;
    }
    int i = paramArgument.optInt("status");
    this.a.a(EngineHelper.a.a(i));
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.c;
  }
  
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    String str = paramArgument.f();
    if ((str.hashCode() == -439099872) && (str.equals("cs.script_action_status_notify.local"))) {
      b(paramArgument);
    }
    return null;
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    return IEventPlugin.DefaultImpls.a(this, paramString);
  }
  
  @NotNull
  public List<String> c()
  {
    return PlayActionScript.h().a();
  }
  
  public boolean d()
  {
    return IEventPlugin.DefaultImpls.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.action.PlayActionScript.buildInPlugin.1
 * JD-Core Version:    0.7.0.1
 */