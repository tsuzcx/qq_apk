package com.tencent.mobileqq.cmshow.engine.script.plugin;

import com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/ServerSSOPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "()V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "supportVariableCmd", "", "getSupportVariableCmd", "()Z", "handleEvent", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "match", "cmd", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class ServerSSOPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final ServerSSOPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.emptyList();
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.SSO;
  private final boolean jdField_a_of_type_Boolean = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginServerSSOPlugin$Companion = new ServerSSOPlugin.Companion(null);
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
    if (a(str))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ssoCmdRule, [aio], cmd:");
        ((StringBuilder)localObject).append(str);
        QLog.d("[cmshow][ServerSSOPlugin]", 2, ((StringBuilder)localObject).toString());
      }
      Object localObject = ApolloUtilImpl.getQQApp();
      if (localObject != null)
      {
        localObject = ((QQAppInterface)localObject).getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER);
        if (localObject != null)
        {
          ((ApolloExtensionHandler)localObject).b(str, paramArgument.b(), 4);
          return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.handler.ApolloExtensionHandler");
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
    return this.jdField_a_of_type_Boolean;
  }
  
  public boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "cmd");
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (StringsKt.startsWith$default(paramString, "apollo_", false, 2, null))
    {
      bool1 = bool2;
      if (!StringsKt.endsWith$default(paramString, ".local", false, 2, null)) {
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.ServerSSOPlugin
 * JD-Core Version:    0.7.0.1
 */