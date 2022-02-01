package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.content.Context;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.channel.HandleResult;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil;
import com.tencent.mobileqq.apollo.game.utils.ApolloGameBasicEventUtil.NotifyDressReady;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.utils.api.IApolloUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.WeakReferenceHandler;
import java.nio.charset.Charset;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Charsets;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/GeneralEventPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "Landroid/os/Handler$Callback;", "()V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "uiHandler", "Lcom/tencent/util/WeakReferenceHandler;", "handleDecryptData", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleEncryptData", "handleEngine2H5", "handleEvent", "handleGetActionData", "app", "Lcom/tencent/mobileqq/app/QQAppInterface;", "handleGetDressPath", "handleGetNickName", "handleGetServerIpPort", "handleMessage", "", "msg", "Landroid/os/Message;", "handleOpenFloatTransWebview", "handleOpenWebview", "handleReportData2BackStage", "handleReportData2Compass", "handleSaveRecommendIp", "observedEvents", "", "showToast", "reqData", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class GeneralEventPlugin
  implements Handler.Callback, IEventPlugin
{
  @Deprecated
  public static final GeneralEventPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(new String[] { "general_cmd_ui_show_toast", "cs.get_dress_path.local", "cs.report_data_2_compass.local", "cs.report_data_2_backstage.local", "cs.report_flow_data.local", "cs.encrypt_data.local", "cs.decrypt_data.local", "cs.get_server_ip_port.local", "cs.save_recommend_ip.local", "cs.apolloGameWebMessage.local", "cs.openFloatTransparentView.local", "cs.openWebView.local", "cs.script_get_nickname.local", "cs.script_get_action_data.local" });
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.GENERAL;
  private final WeakReferenceHandler jdField_a_of_type_ComTencentUtilWeakReferenceHandler = new WeakReferenceHandler(Looper.getMainLooper(), (Handler.Callback)this);
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginGeneralEventPlugin$Companion = new GeneralEventPlugin.Companion(null);
  }
  
  private final String a(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    if (TextUtils.isEmpty((CharSequence)paramArgument.b())) {
      return null;
    }
    try
    {
      String str = new JSONObject(paramArgument.b()).optString("uin");
      if (!TextUtils.isEmpty((CharSequence)str))
      {
        QLog.i("[cmshow][GeneralEventPlugin]", 1, "[handleGetDressPath] pass uin.");
      }
      else
      {
        QLog.w("[cmshow][GeneralEventPlugin]", 1, "[handleGetDressPath] This branch cann't be reached. If so, something illegal must have been happening.");
        str = "";
      }
      ApolloGameBasicEventUtil.a(paramQQAppInterface, str, "", 1, paramArgument.c(), (ApolloGameBasicEventUtil.NotifyDressReady)new GeneralEventPlugin.handleGetDressPath.1(paramArgument));
      return null;
    }
    catch (JSONException paramQQAppInterface)
    {
      QLog.e("[cmshow][GeneralEventPlugin]", 1, "[handleGetDressPath], errInfo->", (Throwable)paramQQAppInterface);
    }
    return null;
  }
  
  private final String a(String paramString)
  {
    String str = ApolloUtilImpl.getJsonStrValue(paramString, "tips");
    int i = ((IApolloUtil)QRoute.api(IApolloUtil.class)).getJsonIntValue(paramString, "length");
    if (TextUtils.isEmpty((CharSequence)str)) {
      return null;
    }
    paramString = this.jdField_a_of_type_ComTencentUtilWeakReferenceHandler.obtainMessage(255);
    Intrinsics.checkExpressionValueIsNotNull(paramString, "uiHandler.obtainMessage(MSG_CODE_SHOW_TOAST)");
    paramString.obj = str;
    paramString.arg1 = i;
    paramString.sendToTarget();
    return null;
  }
  
  private final String b(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    ApolloGameBasicEventUtil.a((AppInterface)paramQQAppInterface, paramArgument.b());
    return null;
  }
  
  private final String b(Argument paramArgument)
  {
    Object localObject1 = ApolloManagerServiceImpl.sApolloGameStkey;
    String str = ApolloManagerServiceImpl.sApolloGameSt;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "key");
    Object localObject2 = Charsets.UTF_8;
    if (localObject1 != null)
    {
      localObject2 = ((String)localObject1).getBytes((Charset)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject1 = paramArgument.b();
      if (localObject1 != null)
      {
        Charset localCharset = Charsets.UTF_8;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        localObject1 = null;
      }
      localObject1 = ApolloGameBasicEventUtil.a((byte[])localObject2, (byte[])localObject1);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("errCode", 0);
      if (localObject1 != null) {
        localObject1 = ((byte[])localObject1).toString();
      } else {
        localObject1 = null;
      }
      ((JSONObject)localObject2).put("data", localObject1);
      ((JSONObject)localObject2).put("st", str);
      Argument.a(paramArgument, null, ((JSONObject)localObject2).toString(), 1, null);
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final String c(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    ApolloGameBasicEventUtil.b(paramQQAppInterface, paramArgument.b());
    return null;
  }
  
  private final String c(Argument paramArgument)
  {
    Object localObject1 = ApolloManagerServiceImpl.sApolloGameStkey;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "key");
    Object localObject2 = Charsets.UTF_8;
    if (localObject1 != null)
    {
      localObject2 = ((String)localObject1).getBytes((Charset)localObject2);
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "(this as java.lang.String).getBytes(charset)");
      localObject1 = paramArgument.b();
      if (localObject1 != null)
      {
        Charset localCharset = Charsets.UTF_8;
        if (localObject1 != null)
        {
          localObject1 = ((String)localObject1).getBytes(localCharset);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "(this as java.lang.String).getBytes(charset)");
        }
        else
        {
          throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
        }
      }
      else
      {
        localObject1 = null;
      }
      localObject1 = ApolloGameBasicEventUtil.b((byte[])localObject2, (byte[])localObject1);
      localObject2 = new JSONObject();
      ((JSONObject)localObject2).put("errCode", 0);
      if (localObject1 != null) {
        localObject1 = ((byte[])localObject1).toString();
      } else {
        localObject1 = null;
      }
      ((JSONObject)localObject2).put("data", localObject1);
      Argument.a(paramArgument, null, ((JSONObject)localObject2).toString(), 1, null);
      return null;
    }
    throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
  }
  
  private final String d(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    ApolloGameBasicEventUtil.a(paramQQAppInterface, paramArgument.b());
    return null;
  }
  
  private final String d(Argument paramArgument)
  {
    if (TextUtils.isEmpty((CharSequence)paramArgument.b())) {
      return null;
    }
    String str = ApolloGameBasicEventUtil.b();
    JSONObject localJSONObject = new JSONObject();
    localJSONObject.put("errCode", 0);
    localJSONObject.put("ip", str);
    localJSONObject.put("port", 10060);
    Argument.a(paramArgument, null, localJSONObject.toString(), 1, null);
    return null;
  }
  
  private final String e(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    QQMessageFacade localQQMessageFacade = paramQQAppInterface.getMessageFacade();
    String str;
    int i;
    if ((localQQMessageFacade != null) && (localQQMessageFacade.a()) && (!TextUtils.isEmpty((CharSequence)localQQMessageFacade.a())))
    {
      str = localQQMessageFacade.a();
      i = localQQMessageFacade.a();
    }
    else
    {
      i = -1;
      str = "";
    }
    return SpriteUtil.a(paramArgument.b(), paramQQAppInterface, i, str).a;
  }
  
  private final String e(Argument paramArgument)
  {
    ApolloGameBasicEventUtil.a(paramArgument.b());
    return null;
  }
  
  private final String f(QQAppInterface paramQQAppInterface, Argument paramArgument)
  {
    ThreadManager.post((Runnable)new GeneralEventPlugin.handleGetActionData.job.1(paramArgument, paramQQAppInterface), 5, null, true);
    return null;
  }
  
  private final String f(Argument paramArgument)
  {
    ApolloGameBasicEventUtil.a((Context)BaseApplicationImpl.getContext(), paramArgument.b());
    return null;
  }
  
  private final String g(Argument paramArgument)
  {
    ApolloGameBasicEventUtil.b((Context)BaseApplicationImpl.getContext(), paramArgument.b());
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
    QQAppInterface localQQAppInterface = ApolloUtilImpl.getQQApp();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localQQAppInterface != null)
    {
      String str = paramArgument.c();
      switch (str.hashCode())
      {
      default: 
        return null;
      case 2082812692: 
        localObject1 = localObject2;
        if (str.equals("general_cmd_ui_show_toast")) {
          return a(paramArgument.b());
        }
        break;
      case 1393871150: 
        localObject1 = localObject2;
        if (str.equals("cs.openWebView.local")) {
          return g(paramArgument);
        }
        break;
      case 1009632383: 
        localObject1 = localObject2;
        if (str.equals("cs.encrypt_data.local")) {
          return b(paramArgument);
        }
        break;
      case 795555306: 
        localObject1 = localObject2;
        if (str.equals("cs.script_get_nickname.local")) {
          return e(localQQAppInterface, paramArgument);
        }
        break;
      case 408480768: 
        localObject1 = localObject2;
        if (str.equals("cs.openFloatTransparentView.local")) {
          return f(paramArgument);
        }
        break;
      case 70507866: 
        localObject1 = localObject2;
        if (str.equals("cs.report_data_2_compass.local")) {
          return b(localQQAppInterface, paramArgument);
        }
        break;
      case 41438859: 
        localObject1 = localObject2;
        if (str.equals("cs.save_recommend_ip.local")) {
          return d(localQQAppInterface, paramArgument);
        }
        break;
      case -212635935: 
        localObject1 = localObject2;
        if (str.equals("cs.get_server_ip_port.local")) {
          return d(paramArgument);
        }
        break;
      case -618745793: 
        localObject1 = localObject2;
        if (str.equals("cs.report_data_2_backstage.local")) {
          return c(localQQAppInterface, paramArgument);
        }
        break;
      case -1003244559: 
        localObject1 = localObject2;
        if (str.equals("cs.get_dress_path.local")) {
          return a(localQQAppInterface, paramArgument);
        }
        break;
      case -1023373967: 
        localObject1 = localObject2;
        if (str.equals("cs.script_get_action_data.local")) {
          return f(localQQAppInterface, paramArgument);
        }
        break;
      case -1583147945: 
        localObject1 = localObject2;
        if (str.equals("cs.decrypt_data.local")) {
          return c(paramArgument);
        }
        break;
      case -1677320305: 
        localObject1 = localObject2;
        if (str.equals("cs.apolloGameWebMessage.local")) {
          localObject1 = e(paramArgument);
        }
        break;
      }
    }
    return localObject1;
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
  
  public boolean handleMessage(@NotNull Message paramMessage)
  {
    Intrinsics.checkParameterIsNotNull(paramMessage, "msg");
    if (paramMessage.what != 255) {
      return false;
    }
    if ((paramMessage.obj instanceof String))
    {
      Context localContext = (Context)BaseApplicationImpl.getContext();
      Object localObject = paramMessage.obj;
      if (localObject != null)
      {
        localObject = (CharSequence)localObject;
        int j = paramMessage.arg1;
        int i = 1;
        if (j != 1) {
          i = 0;
        }
        QQToast.a(localContext, (CharSequence)localObject, i).a();
        return false;
      }
      throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.GeneralEventPlugin
 * JD-Core Version:    0.7.0.1
 */