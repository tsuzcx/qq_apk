package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.apollo.meme.action.MemeAction;
import com.tencent.mobileqq.apollo.meme.manager.InnerMemePlayerListener;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.cmshow.engine.EngineHelper;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "action", "Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "listener", "Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "(Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/meme/action/MemeAction;)V", "getListener", "()Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/meme/manager/InnerMemePlayerListener;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BornPlayerPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final BornPlayerPlugin.Companion a = new BornPlayerPlugin.Companion(null);
  @NotNull
  private static final List<String> f = CollectionsKt.listOf("cs.script_action_status_notify.local");
  @NotNull
  private final PluginCmdConstant.PlugPriority c;
  @NotNull
  private MemeAction d;
  @NotNull
  private InnerMemePlayerListener e;
  
  public BornPlayerPlugin(@NotNull MemeAction paramMemeAction, @NotNull InnerMemePlayerListener paramInnerMemePlayerListener)
  {
    this.d = paramMemeAction;
    this.e = paramInnerMemePlayerListener;
    this.c = PluginCmdConstant.PlugPriority.GENERAL;
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
    Object localObject = paramArgument.f();
    if ((((String)localObject).hashCode() == -439099872) && (((String)localObject).equals("cs.script_action_status_notify.local")))
    {
      paramArgument = new JSONObject(paramArgument.e());
      int i = paramArgument.optInt("taskId");
      int j = paramArgument.optInt("status");
      paramArgument = EngineHelper.a.a(j);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("action status notify, ");
        ((StringBuilder)localObject).append(this.d.h());
        ((StringBuilder)localObject).append(" taskId:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", status:");
        ((StringBuilder)localObject).append(paramArgument);
        QLog.w("[cmshow][BornPlayerPlugin]", 2, ((StringBuilder)localObject).toString());
      }
      if (i == this.d.c().a) {
        this.e.a(this.d, paramArgument);
      }
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
    return f;
  }
  
  public boolean d()
  {
    return IEventPlugin.DefaultImpls.a(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.BornPlayerPlugin
 * JD-Core Version:    0.7.0.1
 */