package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.apollo.player.CMSHelper;
import com.tencent.mobileqq.apollo.player.ICMSPlayerListener;
import com.tencent.mobileqq.apollo.player.action.CMSAction;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/BornPlayerPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "action", "Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "listener", "Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "getAction", "()Lcom/tencent/mobileqq/apollo/player/action/CMSAction;", "setAction", "(Lcom/tencent/mobileqq/apollo/player/action/CMSAction;)V", "getListener", "()Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;", "setListener", "(Lcom/tencent/mobileqq/apollo/player/ICMSPlayerListener;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class BornPlayerPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final BornPlayerPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(new String[] { "cs.first_frame_drawn.local", "cs.script_action_status_notify.local" });
  @NotNull
  private ICMSPlayerListener jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener;
  @NotNull
  private CMSAction jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction;
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginBornPlayerPlugin$Companion = new BornPlayerPlugin.Companion(null);
  }
  
  public BornPlayerPlugin(@NotNull CMSAction paramCMSAction, @NotNull ICMSPlayerListener paramICMSPlayerListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction = paramCMSAction;
    this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener = paramICMSPlayerListener;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.GENERAL;
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
    Object localObject = paramArgument.c();
    int i = ((String)localObject).hashCode();
    if (i != -439099872)
    {
      if ((i == 651396360) && (((String)localObject).equals("cs.first_frame_drawn.local"))) {
        this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction);
      }
    }
    else if (((String)localObject).equals("cs.script_action_status_notify.local"))
    {
      paramArgument = new JSONObject(paramArgument.b());
      i = paramArgument.optInt("taskId");
      int j = paramArgument.optInt("status");
      paramArgument = CMSHelper.a.a(j);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("action status notify, ");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.d());
        ((StringBuilder)localObject).append(" taskId:");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(", status:");
        ((StringBuilder)localObject).append(paramArgument);
        QLog.w("[cmshow][BornPlayerPlugin]", 2, ((StringBuilder)localObject).toString());
      }
      if (i == this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction.a().a) {
        this.jdField_a_of_type_ComTencentMobileqqApolloPlayerICMSPlayerListener.a(this.jdField_a_of_type_ComTencentMobileqqApolloPlayerActionCMSAction, paramArgument);
      }
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.BornPlayerPlugin
 * JD-Core Version:    0.7.0.1
 */