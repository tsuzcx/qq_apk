package com.tencent.timi.game.web.business.impl.plugin;

import android.os.Handler;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.webview.swift.JsBridgeListener;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.timi.game.base.TimiGameActivityManager;
import com.tencent.timi.game.router.ServiceCenter;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService;
import com.tencent.timi.game.smoba.api.IUserSmobaInfoService.Callback;
import com.tencent.timi.game.utils.Logger;
import com.tencent.timi.game.web.business.impl.common.TimiBrowserActivity;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/timi/game/web/business/impl/plugin/LivingInscriptionWebPlugin;", "Lcom/tencent/mobileqq/webview/swift/WebViewPlugin;", "()V", "CLOSE_METHOD", "", "GET_LIVE_ANCHOR_INFO", "MY_SMOBA_ROLE_LIST_METHOD", "PLUGIN_NAME", "SMOBA_ROLE_BIND_METHOD", "SMOBA_ROLE_BIND_STATUS_METHOD", "TAG", "callBackIdMap", "", "bindUserRole", "", "callJsWrap", "method", "content", "closeWebActivity", "convertStringToJson", "Lorg/json/JSONObject;", "errorJson", "code", "", "getMySmobaRoleList", "getSmobaRoleBindStatus", "handleJsRequest", "", "listener", "Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;", "url", "pkgName", "args", "", "(Lcom/tencent/mobileqq/webview/swift/JsBridgeListener;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)Z", "isCallBackSurrpotMethod", "processAnchorInfoCallBack", "timi-game-impl_release"}, k=1, mv={1, 1, 16})
public final class LivingInscriptionWebPlugin
  extends WebViewPlugin
{
  private final String a = "LivingInscriptionWebPlugin";
  private final String b = "timiEsports";
  private final String c = "close";
  private final String d = "getSmobaRoleBindStatus";
  private final String e = "doSmobaRoleBind";
  private final String f = "getMySmobaRoleList";
  private final String g = "getLiveRoomInfo";
  private final Map<String, String> h = (Map)new LinkedHashMap();
  
  public LivingInscriptionWebPlugin()
  {
    this.mPluginNameSpace = this.b;
  }
  
  private final JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("code", paramInt);
    return localJSONObject;
  }
  
  private final void a()
  {
    Object localObject1 = this.mRuntime;
    if (localObject1 != null) {
      localObject1 = ((WebViewPlugin.PluginRuntime)localObject1).d();
    } else {
      localObject1 = null;
    }
    Object localObject2 = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("processAnchorInfoCallBack ");
    localStringBuilder.append(localObject1);
    Logger.b((String)localObject2, localStringBuilder.toString());
    if ((localObject1 instanceof TimiBrowserActivity))
    {
      localObject2 = new JSONObject();
      localObject1 = (TimiBrowserActivity)localObject1;
      ((JSONObject)localObject2).put("anchorId", ((TimiBrowserActivity)localObject1).a);
      ((JSONObject)localObject2).put("gameId", ((TimiBrowserActivity)localObject1).b);
      ((JSONObject)localObject2).put("isAnchor", ((TimiBrowserActivity)localObject1).c);
      ((JSONObject)localObject2).put("code", 0);
      localObject1 = this.g;
      localObject2 = ((JSONObject)localObject2).toString();
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "json.toString()");
      a((String)localObject1, (String)localObject2);
    }
  }
  
  private final void a(String paramString1, String paramString2)
  {
    paramString1 = (String)this.h.get(paramString1);
    if (paramString1 != null) {
      callJs(paramString1, new String[] { paramString2 });
    }
  }
  
  private final boolean a(String paramString)
  {
    return (Intrinsics.areEqual(paramString, this.d)) || (Intrinsics.areEqual(paramString, this.e)) || (Intrinsics.areEqual(paramString, this.f)) || (Intrinsics.areEqual(paramString, this.g));
  }
  
  private final void b()
  {
    Object localObject = this.mRuntime;
    if (localObject != null) {
      localObject = ((WebViewPlugin.PluginRuntime)localObject).d();
    } else {
      localObject = null;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("closeWebActivity ");
    localStringBuilder.append(localObject);
    Logger.b(str, localStringBuilder.toString());
    if ((localObject instanceof TimiBrowserActivity)) {
      ((TimiBrowserActivity)localObject).e();
    }
  }
  
  private final void c()
  {
    LivingInscriptionWebPlugin.bindUserRole.bindListener.1 local1 = new LivingInscriptionWebPlugin.bindUserRole.bindListener.1(this);
    QBaseActivity localQBaseActivity = TimiGameActivityManager.a();
    if (localQBaseActivity == null)
    {
      String str = this.a;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("bindUserRole activity error ");
      localStringBuilder.append(localQBaseActivity);
      localStringBuilder.append(' ');
      Logger.c(str, localStringBuilder.toString());
    }
    ThreadManagerV2.getUIHandlerV2().post((Runnable)new LivingInscriptionWebPlugin.bindUserRole.1(localQBaseActivity, local1));
  }
  
  private final void d()
  {
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).b((IUserSmobaInfoService.Callback)new LivingInscriptionWebPlugin.getSmobaRoleBindStatus.1(this));
  }
  
  private final void e()
  {
    LivingInscriptionWebPlugin.getMySmobaRoleList.callback.1 local1 = new LivingInscriptionWebPlugin.getMySmobaRoleList.callback.1(this);
    ((IUserSmobaInfoService)ServiceCenter.a(IUserSmobaInfoService.class)).a((IUserSmobaInfoService.Callback)local1);
  }
  
  protected boolean handleJsRequest(@Nullable JsBridgeListener paramJsBridgeListener, @Nullable String paramString1, @Nullable String paramString2, @Nullable String paramString3, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "args");
    if ((Intrinsics.areEqual(this.b, paramString2) ^ true)) {
      return false;
    }
    String str = this.a;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("handleJsRequest ");
    localStringBuilder.append(paramString1);
    localStringBuilder.append(',');
    localStringBuilder.append(paramString2);
    localStringBuilder.append(',');
    localStringBuilder.append(paramString3);
    localStringBuilder.append(',');
    localStringBuilder.append(paramVarArgs);
    Logger.a(str, localStringBuilder.toString());
    if ((paramVarArgs.length > 0) && (paramString3 != null) && (a(paramString3))) {
      this.h.put(paramString3, paramVarArgs[0]);
    }
    if (Intrinsics.areEqual(paramString3, this.c))
    {
      b();
      return true;
    }
    if (Intrinsics.areEqual(paramString3, this.d))
    {
      d();
      return true;
    }
    if (Intrinsics.areEqual(paramString3, this.e))
    {
      c();
      return true;
    }
    if (Intrinsics.areEqual(paramString3, this.f))
    {
      e();
      return true;
    }
    if (Intrinsics.areEqual(paramString3, this.g))
    {
      a();
      return true;
    }
    return super.handleJsRequest(paramJsBridgeListener, paramString1, paramString2, paramString3, (String[])Arrays.copyOf(paramVarArgs, paramVarArgs.length));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.timi.game.web.business.impl.plugin.LivingInscriptionWebPlugin
 * JD-Core Version:    0.7.0.1
 */