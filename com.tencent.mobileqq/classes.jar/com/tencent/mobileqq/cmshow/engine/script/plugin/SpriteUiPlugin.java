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
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
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
import mqq.util.LogUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/SpriteUiPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "mSpriteContext", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "(Lcom/tencent/mobileqq/apollo/script/SpriteContext;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "TAG$1", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "handleChangedCompleted", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleEvent", "handleOnApolloClick", "handlePanelStatusChange", "handleShowToast", "handleSpriteChangedCompleted", "handleSpriteStatus", "observedEvents", "", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class SpriteUiPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final SpriteUiPlugin.Companion a = new SpriteUiPlugin.Companion(null);
  @NotNull
  private static final List<String> f = CollectionsKt.mutableListOf(new String[] { "cs.script_change_panel_status.local", "cs.script_show_toast.local", "cs.script_sprite_status_change.local", "cs.script_action_apollo_click.local", "cs.script_sprite_model_change_notify.local", "cs.script_sprite_model_ready.local" });
  @NotNull
  private final String c;
  @NotNull
  private final PluginCmdConstant.PlugPriority d;
  private final SpriteContext e;
  
  public SpriteUiPlugin(@NotNull SpriteContext paramSpriteContext)
  {
    this.e = paramSpriteContext;
    this.c = "[cmshow][SpriteUiPlugin]";
    this.d = PluginCmdConstant.PlugPriority.UI;
  }
  
  private final String b(Argument paramArgument)
  {
    try
    {
      if (this.e.l() == null) {
        return null;
      }
      if (this.e.i != 0) {
        return null;
      }
      int i = new JSONObject(paramArgument.e()).optInt("status");
      paramArgument = this.e.l().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      ((ISpriteScriptManager)paramArgument).getUIHandler().a(i);
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e(this.c, 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String c(Argument paramArgument)
  {
    try
    {
      if (this.e.l() == null) {
        return null;
      }
      if (this.e.i != 0) {
        return null;
      }
      paramArgument = new JSONObject(paramArgument.e()).optString("text");
      IRuntimeService localIRuntimeService = this.e.l().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localIRuntimeService, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      ((ISpriteScriptManager)localIRuntimeService).getUIHandler().a(paramArgument);
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e(this.c, 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String d(Argument paramArgument)
  {
    try
    {
      if (this.e.l() == null) {
        return null;
      }
      if (this.e.i != 0) {
        return null;
      }
      paramArgument = new JSONObject(paramArgument.e());
      int i = paramArgument.optInt("status");
      int j = paramArgument.optInt("whiteHeight");
      QLog.d(this.c, 2, new Object[] { "[handleSpriteStatus], status:", Integer.valueOf(i), ",whiteHeight:", Integer.valueOf(j) });
      paramArgument = this.e.l().getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(paramArgument, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
      paramArgument = (ISpriteScriptManager)paramArgument;
      if (this.e.l) {
        QLog.i(this.c, 1, "[handleSpriteStatus], isBubbleMeme no need margin");
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
      QLog.e(this.c, 1, "handleSpriteStatus exception,", paramArgument);
    }
    return null;
  }
  
  private final String e(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject(paramArgument.e());
      int i = paramArgument.optInt("from");
      Object localObject;
      if (i == 0)
      {
        paramArgument = paramArgument.optString("url");
        if (this.e.m() == null)
        {
          QLog.e(this.c, 1, "handleOnApolloClick mSpriteContent is nil");
          return null;
        }
        if (!TextUtils.isEmpty((CharSequence)paramArgument))
        {
          localObject = this.e.m();
          Intrinsics.checkExpressionValueIsNotNull(localObject, "mSpriteContext.pie");
          if (((BaseChatPie)localObject).aX() == null)
          {
            QLog.e(this.c, 1, "handleOnApolloClick activity is nil");
            return null;
          }
          localObject = (IApolloUtil)QRoute.api(IApolloUtil.class);
          BaseChatPie localBaseChatPie = this.e.m();
          Intrinsics.checkExpressionValueIsNotNull(localBaseChatPie, "mSpriteContext.pie");
          ((IApolloUtil)localObject).openWebViewActivity((Context)localBaseChatPie.aX(), paramArgument);
          return null;
        }
      }
      else
      {
        int j = paramArgument.optInt("apolloStatus");
        int k = paramArgument.optInt("clickPart");
        paramArgument = paramArgument.optString("apolloId");
        QLog.d(this.c, 2, new Object[] { "handleOnApolloClick,from:", Integer.valueOf(i), ",apolloStatus:", Integer.valueOf(j), ",clickPart:", Integer.valueOf(k), "apolloId:", paramArgument });
        localObject = this.e.u();
        if (localObject != null)
        {
          ((ISpriteDrawerInfoCallback)localObject).a(j, k, paramArgument);
          return null;
        }
      }
    }
    catch (Exception paramArgument)
    {
      QLog.e(this.c, 1, "Exception:", (Throwable)paramArgument);
    }
    return null;
  }
  
  private final String f(Argument paramArgument)
  {
    if (this.e.l() == null) {
      return null;
    }
    paramArgument = this.e.l().getRuntimeService(IApolloManagerService.class, "all");
    if (paramArgument != null)
    {
      paramArgument = (ApolloManagerServiceImpl)paramArgument;
      Object localObject1 = this.e.l().getRuntimeService(IApolloDaoManagerService.class, "all");
      if (localObject1 != null)
      {
        Object localObject2 = (ApolloDaoManagerServiceImpl)localObject1;
        localObject1 = this.e.l().getRuntimeService(ISpriteScriptManager.class, "all");
        Intrinsics.checkExpressionValueIsNotNull(localObject1, "mSpriteContext.app.getRu…ava, ProcessConstant.ALL)");
        localObject1 = (ISpriteScriptManager)localObject1;
        if ((paramArgument.getApolloUserStatus() == 2) && (this.e.i == 0) && (!String.valueOf(303).equals(ApolloPanelUtil.a())))
        {
          paramArgument = ((ApolloDaoManagerServiceImpl)localObject2).getActionInfoById(3000059);
          if (paramArgument != null)
          {
            localObject2 = new SpriteTaskParam();
            ((SpriteTaskParam)localObject2).f = paramArgument.actionId;
            ((SpriteTaskParam)localObject2).c = 0;
            ((SpriteTaskParam)localObject2).g = 3;
            ((SpriteTaskParam)localObject2).e = paramArgument.personNum;
            ((SpriteTaskParam)localObject2).h = -10000L;
            ((SpriteTaskParam)localObject2).l = true;
            ((SpriteTaskParam)localObject2).q = false;
            ((SpriteTaskParam)localObject2).o = paramArgument.bubbleText;
            ((SpriteTaskParam)localObject2).j = this.e.l().getCurrentAccountUin().toString();
            ((ISpriteScriptManager)localObject1).getSpriteBridge().b((SpriteTaskParam)localObject2);
          }
        }
        return null;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.persistence.api.impl.ApolloDaoManagerServiceImpl");
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
  }
  
  private final String g(Argument paramArgument)
  {
    if (this.e.l() == null) {
      return null;
    }
    paramArgument = new JSONObject(paramArgument.e()).optString("uin");
    QLog.e(this.c, 1, new Object[] { "handleSpriteChangedCompleted: uin:", LogUtil.wrapLogUin(paramArgument) });
    paramArgument = this.e.u();
    if (paramArgument != null) {
      paramArgument.d();
    }
    return null;
  }
  
  @NotNull
  public PluginCmdConstant.PlugPriority a()
  {
    return this.d;
  }
  
  @Nullable
  public String a(@NotNull Argument paramArgument)
  {
    Intrinsics.checkParameterIsNotNull(paramArgument, "argument");
    String str = paramArgument.f();
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
    case -739533882: 
      if (str.equals("cs.script_sprite_model_ready.local")) {
        return g(paramArgument);
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteUiPlugin
 * JD-Core Version:    0.7.0.1
 */