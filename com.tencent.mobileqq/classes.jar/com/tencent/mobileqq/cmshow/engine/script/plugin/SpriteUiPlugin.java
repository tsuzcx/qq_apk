package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.model.ApolloActionData;
import com.tencent.mobileqq.apollo.persistence.api.IApolloDaoManagerService;
import com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl;
import com.tencent.mobileqq.apollo.script.ISpriteBridge;
import com.tencent.mobileqq.apollo.script.ISpriteUIHandler;
import com.tencent.mobileqq.apollo.script.SpriteBridge;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.api.IRuntimeService;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/SpriteUiPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "mSpriteContext", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "(Lcom/tencent/mobileqq/apollo/script/SpriteContext;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleChangedCompleted", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleEvent", "handleOnApolloClick", "handlePanelStatusChange", "handleShowToast", "handleSpriteStatus", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class SpriteUiPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final SpriteUiPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.mutableListOf(new String[] { "cs.script_change_panel_status.local", "cs.script_show_toast.local", "cs.script_sprite_status_change.local", "cs.script_action_apollo_click.local", "cs.script_sprite_model_change_notify.local" });
  private final SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteUiPlugin$Companion = new SpriteUiPlugin.Companion(null);
  }
  
  public SpriteUiPlugin(@NotNull SpriteContext paramSpriteContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.UI;
  }
  
  private final String b(Argument paramArgument)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      int i = new JSONObject(paramArgument.b()).optInt("status");
      paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      ((ISpriteScriptManager)paramArgument).getUIHandler().a(i);
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteUiPlugin]", 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String c(Argument paramArgument)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramArgument = new JSONObject(paramArgument.b()).optString("text");
      IRuntimeService localIRuntimeService = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      ((ISpriteScriptManager)localIRuntimeService).getUIHandler().a(paramArgument);
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteUiPlugin]", 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String d(Argument paramArgument)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) {
        return null;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramArgument = new JSONObject(paramArgument.b());
      int i = paramArgument.optInt("status");
      int j = paramArgument.optInt("whiteHeight");
      QLog.d("[cmshow][SpriteUiPlugin]", 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
      paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      paramArgument = (ISpriteScriptManager)paramArgument;
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.c) {
        QLog.i("[cmshow][SpriteUiPlugin]", 1, "[handleSpriteStatus], isBubbleMeme no need margin");
      } else {
        paramArgument.getUIHandler().a(i, j);
      }
      paramArgument = paramArgument.getSpriteBridge();
      if (paramArgument != null)
      {
        ((SpriteBridge)paramArgument).a(i);
        return null;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.script.SpriteBridge");
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteUiPlugin]", 1, "handleSpriteStatus exception,", paramArgument);
    }
    return null;
  }
  
  private final String e(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject(paramArgument.b());
      int i = paramArgument.optInt("from");
      Object localObject;
      if (i == 0)
      {
        paramArgument = paramArgument.optString("url");
        if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null)
        {
          QLog.e("[cmshow][SpriteUiPlugin]", 1, "handleOnApolloClick mSpriteContent is nil");
          return null;
        }
        if (!TextUtils.isEmpty((CharSequence)paramArgument))
        {
          localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "mSpriteContext.pie");
          if (((BaseChatPie)localObject).a() == null)
          {
            QLog.e("[cmshow][SpriteUiPlugin]", 1, "handleOnApolloClick activity is nil");
            return null;
          }
          localObject = (IApolloUtil)QRoute.api(IApolloUtil.class);
          BaseChatPie localBaseChatPie = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          Intrinsics.checkExpressionValueIsNotNull(localBaseChatPie, "mSpriteContext.pie");
          ((IApolloUtil)localObject).openWebViewActivity((Context)localBaseChatPie.a(), paramArgument);
          return null;
        }
      }
      else
      {
        int j = paramArgument.optInt("apolloStatus");
        int k = paramArgument.optInt("clickPart");
        paramArgument = paramArgument.optString("apolloId");
        QLog.d("[cmshow][SpriteUiPlugin]", 2, new Object[] { "handleOnApolloClick,from:", Integer.valueOf(i), ",apolloStatus:", Integer.valueOf(j), ",clickPart:", Integer.valueOf(k), "apolloId:", paramArgument });
        localObject = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
        if (localObject != null)
        {
          ((ISpriteDrawerInfoCallback)localObject).a(j, k, paramArgument);
          return null;
        }
      }
    }
    catch (Exception paramArgument)
    {
      QLog.e("[cmshow][scripted]SpriteActionScript", 1, "Exception:", (Throwable)paramArgument);
    }
    return null;
  }
  
  private final String f(Argument paramArgument)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a() == null) {
      return null;
    }
    paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloManagerService.class, "all");
    if (paramArgument != null)
    {
      paramArgument = (ApolloManagerServiceImpl)paramArgument;
      Object localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localObject1 != null)
      {
        Object localObject2 = (ApolloDaoManagerServiceImpl)localObject1;
        localObject1 = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getRuntimeService(ISpriteScriptManager.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
        localObject1 = (ISpriteScriptManager)localObject1;
        if ((paramArgument.getApolloUserStatus() == 2) && (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d == 0))
        {
          paramArgument = ((ApolloDaoManagerServiceImpl)localObject2).getActionInfoById(3000059);
          if (paramArgument != null)
          {
            localObject2 = new SpriteTaskParam();
            ((SpriteTaskParam)localObject2).f = paramArgument.actionId;
            ((SpriteTaskParam)localObject2).jdField_c_of_type_Int = 0;
            ((SpriteTaskParam)localObject2).g = 3;
            ((SpriteTaskParam)localObject2).e = paramArgument.personNum;
            ((SpriteTaskParam)localObject2).jdField_a_of_type_Long = -10000L;
            ((SpriteTaskParam)localObject2).jdField_a_of_type_Boolean = true;
            ((SpriteTaskParam)localObject2).b = false;
            ((SpriteTaskParam)localObject2).jdField_c_of_type_JavaLangString = paramArgument.bubbleText;
            ((SpriteTaskParam)localObject2).jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().getCurrentAccountUin().toString();
            ((ISpriteScriptManager)localObject1).getSpriteBridge().b((SpriteTaskParam)localObject2);
          }
        }
        return null;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
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
    switch (str.hashCode())
    {
    default: 
      break;
    case 1533007896: 
      if (str.equals("cs.script_show_toast.local")) {
        return c(paramArgument);
      }
      break;
    case 545496072: 
      if (str.equals("cs.script_action_apollo_click.local")) {
        return e(paramArgument);
      }
      break;
    case 250090267: 
      if (str.equals("cs.script_sprite_model_change_notify.local")) {
        return f(paramArgument);
      }
      break;
    case -1750280106: 
      if (str.equals("cs.script_sprite_status_change.local")) {
        return d(paramArgument);
      }
      break;
    case -2011638525: 
      if (str.equals("cs.script_change_panel_status.local")) {
        return b(paramArgument);
      }
      break;
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteUiPlugin
 * JD-Core Version:    0.7.0.1
 */