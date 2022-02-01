package com.tencent.mobileqq.cmshow.engine.script.plugin;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.apollo.aio.api.impl.CmShowAioMatcherImpl;
import com.tencent.mobileqq.apollo.api.IApolloManagerService;
import com.tencent.mobileqq.apollo.api.ISpriteScriptManager;
import com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl;
import com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl;
import com.tencent.mobileqq.apollo.model.ApolloMessage;
import com.tencent.mobileqq.apollo.model.ApolloSkeletonBounding;
import com.tencent.mobileqq.apollo.model.MessageForApollo;
import com.tencent.mobileqq.apollo.script.ISpriteContext;
import com.tencent.mobileqq.apollo.script.ISpriteTaskHandler;
import com.tencent.mobileqq.apollo.script.SpriteActionMessage;
import com.tencent.mobileqq.apollo.script.SpriteActionScript;
import com.tencent.mobileqq.apollo.script.SpriteAioScript;
import com.tencent.mobileqq.apollo.script.SpriteContext;
import com.tencent.mobileqq.apollo.script.SpriteRscBuilder;
import com.tencent.mobileqq.apollo.script.SpriteUtil;
import com.tencent.mobileqq.apollo.script.callback.ISpriteActionCallback;
import com.tencent.mobileqq.apollo.script.callback.ISpriteDrawerInfoCallback;
import com.tencent.mobileqq.apollo.touch.ICMTouchManager;
import com.tencent.mobileqq.apollo.utils.ApolloPanelUtil;
import com.tencent.mobileqq.apollo.utils.api.impl.ApolloUtilImpl;
import com.tencent.mobileqq.app.CheckPttListener;
import com.tencent.mobileqq.app.CheckPtvListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.cmshow.engine.ICMShowEngine;
import com.tencent.mobileqq.cmshow.engine.model.Argument;
import com.tencent.mobileqq.cmshow.engine.render.ICMShowView;
import com.tencent.mobileqq.cmshow.engine.render.IRenderService;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.utils.api.ITroopUtilsApi;
import com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import mqq.app.AppRuntime;
import mqq.os.MqqHandler;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/cmshow/engine/script/plugin/SpriteAioPlugin;", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/IEventPlugin;", "mSpriteContext", "Lcom/tencent/mobileqq/apollo/script/SpriteContext;", "mSpriteAioScript", "Lcom/tencent/mobileqq/apollo/script/SpriteAioScript;", "mActionCallback", "Lcom/tencent/mobileqq/apollo/script/callback/ISpriteActionCallback;", "(Lcom/tencent/mobileqq/apollo/script/SpriteContext;Lcom/tencent/mobileqq/apollo/script/SpriteAioScript;Lcom/tencent/mobileqq/apollo/script/callback/ISpriteActionCallback;)V", "priority", "Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "getPriority", "()Lcom/tencent/mobileqq/cmshow/engine/script/plugin/PluginCmdConstant$PlugPriority;", "allowAudio", "", "handleActionStatus", "", "argument", "Lcom/tencent/mobileqq/cmshow/engine/model/Argument;", "handleBoundingListUpdate", "handleEvent", "handleGet3DState", "handleGetAudioSwitch", "handleGetDress", "handleGetLocalData", "handleGetShowAction", "handlePlayAction", "handleSendMsg", "notifyPanelTabStatusChange", "", "taskId", "", "status", "observedEvents", "", "showAudioTips", "Companion", "cmshow_impl_release"}, k=1, mv={1, 1, 16})
public final class SpriteAioPlugin
  implements IEventPlugin
{
  @Deprecated
  public static final SpriteAioPlugin.Companion a;
  @NotNull
  private static final List<String> jdField_a_of_type_JavaUtilList = CollectionsKt.listOf(new String[] { "cs.script_get_dress_data.local", "cs.script_action_status_notify.local", "cs.script_get_show_action.local", "cs.script_is_allow_play_audio.local", "cs.script_send_action_msg.local", "cs.script_get_config.local", "cs.script_update_boundinglist.local", "cs.get_cm3D_state.local", "cs.script_play_action.local" });
  private final SpriteAioScript jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteAioScript;
  private final SpriteContext jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext;
  private final ISpriteActionCallback jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback;
  @NotNull
  private final PluginCmdConstant.PlugPriority jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginSpriteAioPlugin$Companion = new SpriteAioPlugin.Companion(null);
  }
  
  public SpriteAioPlugin(@NotNull SpriteContext paramSpriteContext, @NotNull SpriteAioScript paramSpriteAioScript, @Nullable ISpriteActionCallback paramISpriteActionCallback)
  {
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext = paramSpriteContext;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteAioScript = paramSpriteAioScript;
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback = paramISpriteActionCallback;
    this.jdField_a_of_type_ComTencentMobileqqCmshowEngineScriptPluginPluginCmdConstant$PlugPriority = PluginCmdConstant.PlugPriority.DATA;
  }
  
  private final void a()
  {
    Object localObject1 = ApolloUtilImpl.getQQApp();
    if (localObject1 != null)
    {
      ISpriteContext localISpriteContext = SpriteUtil.a((AppRuntime)localObject1);
      if (localISpriteContext != null)
      {
        Object localObject2 = SharedPreferencesProxyManager.getInstance().getProxy("apollo_sp", 0);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("audio_tips_times");
        localStringBuilder.append(localISpriteContext.a());
        int i = ((SharedPreferences)localObject2).getInt(localStringBuilder.toString(), 0);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("totalTimes:");
        localStringBuilder.append(i);
        QLog.d("[cmshow][SpriteAioPlugin]", 2, localStringBuilder.toString());
        if (3 != i)
        {
          localObject2 = ((SharedPreferences)localObject2).edit();
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("audio_tips_times");
          localStringBuilder.append(localISpriteContext.a());
          ((SharedPreferences.Editor)localObject2).putInt(localStringBuilder.toString(), i + 1).commit();
          localObject1 = ((QQAppInterface)localObject1).getHandler(ChatActivity.class);
          if (localObject1 != null) {
            ((MqqHandler)localObject1).post((Runnable)SpriteAioPlugin.showAudioTips.1.a);
          }
        }
      }
    }
  }
  
  private final void a(int paramInt1, int paramInt2)
  {
    Object localObject1 = BaseApplicationImpl.sApplication;
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "BaseApplicationImpl.sApplication");
    localObject1 = ((BaseApplicationImpl)localObject1).getRuntime();
    if (localObject1 != null)
    {
      localObject1 = (QQAppInterface)localObject1;
      if (localObject1 == null) {
        Intrinsics.throwNpe();
      }
      Object localObject2 = ((QQAppInterface)localObject1).getRuntimeService(ISpriteScriptManager.class, "all");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.getRuntimeService(IS…ava, ProcessConstant.ALL)");
      localObject2 = ((ISpriteScriptManager)localObject2).getTaskHandler();
      boolean bool;
      if ((!((ISpriteTaskHandler)localObject2).a()) && (((ISpriteTaskHandler)localObject2).a() <= 0)) {
        bool = false;
      } else {
        bool = true;
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("notifyPanelTabStatusChange, isAnyTaskRunning:");
      ((StringBuilder)localObject2).append(bool);
      ((StringBuilder)localObject2).append(", taskId: ");
      ((StringBuilder)localObject2).append(paramInt1);
      ((StringBuilder)localObject2).append(", status:");
      ((StringBuilder)localObject2).append(paramInt2);
      QLog.i("[cmshow][SpriteAioPlugin]", 1, ((StringBuilder)localObject2).toString());
      if ((paramInt1 > 0) && (!bool) && ((2 == paramInt2) || (3 == paramInt2)))
      {
        localObject1 = SpriteUtil.a((AppRuntime)localObject1);
        if (localObject1 != null) {
          ((SpriteActionScript)localObject1).a(ApolloPanelUtil.a(), "actionStatusChange");
        }
      }
      return;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.app.QQAppInterface");
  }
  
  private final String b(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject(paramArgument.b()).optString("uinList");
      if (TextUtils.isEmpty((CharSequence)paramArgument)) {
        return null;
      }
      paramArgument = new JSONArray(paramArgument);
      int j = paramArgument.length();
      int i = 0;
      while (i < j)
      {
        String str = paramArgument.optString(i);
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteAioScript.a(str, true);
        i += 1;
      }
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, paramArgument, new Object[0]);
    }
  }
  
  private final boolean b()
  {
    Object localObject1 = ApolloUtilImpl.getQQApp();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localObject1 != null)
    {
      int i = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a;
      Object localObject2 = (MediaPlayerManager)((QQAppInterface)localObject1).getManager(QQManagerFactory.MGR_MEDIA_PLAYER);
      bool1 = bool2;
      if (((QQAppInterface)localObject1).getALLGeneralSettingRing() == 1) {
        if (((!CmShowAioMatcherImpl.judgeSupported(i, 2)) || (((ITroopUtilsApi)QRoute.api(ITroopUtilsApi.class)).getTroopGeneralSettingRing((AppRuntime)localObject1) != 1)) && (!CmShowAioMatcherImpl.judgeSupported(i, 1)))
        {
          bool1 = bool2;
          if (i != -2) {}
        }
        else
        {
          bool1 = bool2;
          if (!((QQAppInterface)localObject1).isRingerVibrate())
          {
            bool1 = bool2;
            if (!((QQAppInterface)localObject1).isRingEqualsZero())
            {
              bool1 = bool2;
              if (((QQAppInterface)localObject1).isCallIdle()) {
                if (localObject2 != null)
                {
                  bool1 = bool2;
                  if (((MediaPlayerManager)localObject2).a()) {}
                }
                else if (((QQAppInterface)localObject1).getCheckPttListener() != null)
                {
                  localObject2 = ((QQAppInterface)localObject1).getCheckPttListener();
                  Intrinsics.checkExpressionValueIsNotNull(localObject2, "app.checkPttListener");
                  bool1 = bool2;
                  if (((CheckPttListener)localObject2).f()) {}
                }
                else
                {
                  bool1 = bool2;
                  if (!((QQAppInterface)localObject1).isVideoChatting()) {
                    if (((QQAppInterface)localObject1).getCheckPtvListener() != null)
                    {
                      localObject1 = ((QQAppInterface)localObject1).getCheckPtvListener();
                      Intrinsics.checkExpressionValueIsNotNull(localObject1, "app.checkPtvListener");
                      bool1 = bool2;
                      if (((CheckPtvListener)localObject1).a()) {}
                    }
                    else
                    {
                      bool1 = true;
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    return bool1;
  }
  
  private final String c(Argument paramArgument)
  {
    int j;
    try
    {
      localObject = new JSONObject(paramArgument.b());
      i = ((JSONObject)localObject).optInt("taskId");
      j = ((JSONObject)localObject).optInt("status");
      localObject = ((JSONObject)localObject).optString("uin");
      if (!QLog.isColorLevel()) {
        break label152;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("handleActionStatus, ");
      localStringBuilder.append(paramArgument.b());
      QLog.d("[cmshow][SpriteAioPlugin]", 2, localStringBuilder.toString());
    }
    catch (Throwable paramArgument)
    {
      Object localObject;
      int i;
      QLog.e("[cmshow][SpriteAioPlugin]", 1, paramArgument, new Object[0]);
    }
    paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback;
    if (paramArgument != null)
    {
      paramArgument.a((String)localObject, i, j);
      break label129;
      label111:
      paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptCallbackISpriteActionCallback;
      if (paramArgument != null) {
        paramArgument.a((String)localObject, i);
      }
    }
    for (;;)
    {
      label129:
      a(i, j);
      return null;
      label152:
      if (j == 1) {
        break label111;
      }
      if ((j == 2) || (j == 3)) {
        break;
      }
    }
  }
  
  private final String d(Argument paramArgument)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      JSONObject localJSONObject1 = new JSONObject(paramArgument.b());
      paramArgument = localJSONObject1.optString("uinList");
      if (TextUtils.isEmpty((CharSequence)paramArgument)) {
        paramArgument = new JSONArray();
      } else {
        paramArgument = new JSONArray(paramArgument);
      }
      JSONArray localJSONArray = new JSONArray();
      JSONObject localJSONObject2 = new JSONObject();
      int j = localJSONObject1.optInt("type", 0);
      if (QLog.isColorLevel()) {
        QLog.d("[cmshow][SpriteAioPlugin]", 2, new Object[] { "[handleGetShowAction] type:", Integer.valueOf(j) });
      }
      SpriteRscBuilder localSpriteRscBuilder = SpriteUtil.a((AppRuntime)ApolloUtilImpl.getQQApp());
      if (localSpriteRscBuilder != null)
      {
        int k = paramArgument.length();
        int i = 0;
        while (i < k)
        {
          JSONObject localJSONObject3 = new JSONObject();
          Object localObject = paramArgument.optString(i);
          localJSONObject3.put("uin", localObject);
          if (j == 1)
          {
            localJSONObject3.put("petPath", localSpriteRscBuilder.a(new JSONArray(localJSONObject1.optString("actionList"))));
          }
          else
          {
            localObject = localSpriteRscBuilder.a((String)localObject);
            localJSONObject3.put("path", ((Pair)localObject).first);
            localObject = ((Pair)localObject).second;
            Intrinsics.checkExpressionValueIsNotNull(localObject, "pathAction.second");
            localJSONObject3.put("actionType", ((Number)localObject).intValue());
          }
          localJSONArray.put(localJSONObject3);
          i += 1;
        }
      }
      localJSONObject2.put("path", localJSONArray);
      paramArgument = localJSONObject2.toString();
      return paramArgument;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String e(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject();
      int i;
      if (b())
      {
        i = 1;
      }
      else
      {
        a();
        i = 0;
      }
      paramArgument.put("isAllowed", i);
      QLog.d("[cmshow][SpriteAioPlugin]", 2, new Object[] { "isAllowPlayAudio:", Integer.valueOf(i) });
      paramArgument = paramArgument.toString();
      return paramArgument;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String f(Argument paramArgument)
  {
    try
    {
      if (this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.d != 0) {
        return null;
      }
      paramArgument = SpriteUtil.a(paramArgument.b(), this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext);
      Object localObject1 = ApolloUtilImpl.getQQApp();
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "ApolloUtilImpl.getQQApp()");
      if (paramArgument != null)
      {
        if (localObject1 == null) {
          return null;
        }
        Object localObject2 = ((QQAppInterface)localObject1).getRuntimeService(ISpriteScriptManager.class, "all");
        if (localObject2 != null)
        {
          localObject2 = ((SpriteScriptManagerImpl)localObject2).getSpriteActionMessage();
          if ((localObject2 != null) && (!((SpriteActionMessage)localObject2).a(paramArgument)))
          {
            QLog.d("[cmshow][SpriteAioPlugin]", 2, "Message can't be sent out without any slave.");
            return null;
          }
          ((QQAppInterface)localObject1).getMessageFacade().a((MessageRecord)paramArgument, null);
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(this);
          ((StringBuilder)localObject1).append(" send an action msg, actionId:");
          QLog.d("[cmshow][SpriteAioPlugin]", 2, new Object[] { ((StringBuilder)localObject1).toString(), Integer.valueOf(paramArgument.mApolloMessage.id) });
          return null;
        }
        throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.SpriteScriptManagerImpl");
      }
      return null;
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, paramArgument, new Object[0]);
    }
    return null;
  }
  
  private final String g(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject(paramArgument.b());
      JSONObject localJSONObject = new JSONObject();
      if (Intrinsics.areEqual("pet", paramArgument.getString("config_name")))
      {
        paramArgument = new JSONArray();
        Object localObject = ApolloUtilImpl.getQQApp();
        if (localObject != null)
        {
          localObject = ((AppInterface)localObject).getRuntimeService(IApolloManagerService.class, "all");
          if (localObject != null)
          {
            localObject = (ApolloManagerServiceImpl)localObject;
            if (((ApolloManagerServiceImpl)localObject).mPetConfig != null) {
              paramArgument = new JSONArray(((ApolloManagerServiceImpl)localObject).mPetConfig);
            }
            localJSONObject.put("petConfig", paramArgument);
            return localJSONObject.toString();
          }
          throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.apollo.api.impl.ApolloManagerServiceImpl");
        }
        return null;
      }
    }
    catch (Throwable paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, "handleGetLocalData error:", paramArgument);
    }
    return null;
  }
  
  private final String h(Argument paramArgument)
  {
    for (;;)
    {
      int i;
      try
      {
        Object localObject = new JSONObject(paramArgument.b());
        int j = ((JSONObject)localObject).optInt("from");
        i = 0;
        QLog.d("[cmshow][SpriteAioPlugin]", 1, new Object[] { "handlePlayAction params:", paramArgument.b() });
        if ((j != 1) && (j != 2))
        {
          if (j == 0)
          {
            paramArgument = ((JSONObject)localObject).optString("uinList");
            if (TextUtils.isEmpty((CharSequence)paramArgument)) {
              return null;
            }
            localObject = new JSONArray(paramArgument);
            paramArgument = (List)new ArrayList();
            j = ((JSONArray)localObject).length();
            if (i < j)
            {
              String str = ((JSONArray)localObject).optString(i);
              if (TextUtils.isEmpty((CharSequence)str)) {
                break label227;
              }
              Intrinsics.checkExpressionValueIsNotNull(str, "uin");
              paramArgument.add(str);
              break label227;
            }
            if (paramArgument.size() == 0) {
              return null;
            }
            localObject = SpriteUtil.a((AppRuntime)ApolloUtilImpl.getQQApp());
            if (localObject != null)
            {
              ((SpriteRscBuilder)localObject).a(paramArgument);
              return null;
            }
          }
        }
        else
        {
          paramArgument = this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a();
          if (paramArgument != null)
          {
            paramArgument.a();
            return null;
          }
        }
      }
      catch (JSONException paramArgument)
      {
        QLog.e("[cmshow][SpriteAioPlugin]", 1, "handlePlayAction error:", (Throwable)paramArgument);
      }
      return null;
      label227:
      i += 1;
    }
  }
  
  private final String i(Argument paramArgument)
  {
    Object localObject;
    try
    {
      paramArgument = new JSONObject(paramArgument.b());
      float f1 = (float)paramArgument.optDouble("x");
      float f2 = (float)paramArgument.optDouble("y");
      float f3 = (float)paramArgument.optDouble("w");
      float f4 = (float)paramArgument.optDouble("h");
      float f5 = (float)paramArgument.optDouble("bX");
      float f6 = (float)paramArgument.optDouble("bY");
      float f7 = (float)paramArgument.optDouble("bW");
      float f8 = (float)paramArgument.optDouble("bH");
      float f9 = (float)paramArgument.optDouble("gX");
      float f10 = (float)paramArgument.optDouble("gY");
      float f11 = (float)paramArgument.optDouble("gW");
      float f12 = (float)paramArgument.optDouble("gH");
      localObject = paramArgument.optString("name");
      String str = paramArgument.optString("extendString");
      int i = paramArgument.optInt("dispose");
      paramArgument = new ApolloSkeletonBounding((String)localObject, str, f1, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cs.script_update_boundinglist.local : ");
      ((StringBuilder)localObject).append(paramArgument.toString());
      QLog.d("[cmshow][SpriteAioPlugin]", 1, ((StringBuilder)localObject).toString());
      try
      {
        this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a().a().a().getTouchManager().a(paramArgument, i);
      }
      catch (Exception paramArgument) {}
      localObject = new StringBuilder();
    }
    catch (Exception paramArgument) {}
    ((StringBuilder)localObject).append("handleBoundingListUpdate exception = ");
    ((StringBuilder)localObject).append(paramArgument);
    QLog.e("[cmshow][SpriteAioPlugin]", 1, ((StringBuilder)localObject).toString());
    return null;
  }
  
  private final String j(Argument paramArgument)
  {
    try
    {
      paramArgument = new JSONObject();
      paramArgument.put("is3DBetaTester", SpriteUtil.a((AppRuntime)this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteContext.a()));
      paramArgument = paramArgument.toString();
      return paramArgument;
    }
    catch (Exception paramArgument)
    {
      QLog.e("[cmshow][SpriteAioPlugin]", 1, (Throwable)paramArgument, new Object[0]);
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
    switch (str.hashCode())
    {
    default: 
      break;
    case 1953058417: 
      if (str.equals("cs.get_cm3D_state.local")) {
        return j(paramArgument);
      }
      break;
    case 1871884607: 
      if (str.equals("cs.script_update_boundinglist.local")) {
        return i(paramArgument);
      }
      break;
    case 1865851645: 
      if (str.equals("cs.script_is_allow_play_audio.local")) {
        return e(paramArgument);
      }
      break;
    case 1520250734: 
      if (str.equals("cs.script_get_dress_data.local")) {
        return b(paramArgument);
      }
      break;
    case 820155774: 
      if (str.equals("cs.script_get_config.local")) {
        return g(paramArgument);
      }
      break;
    case 280486440: 
      if (str.equals("cs.script_play_action.local")) {
        return h(paramArgument);
      }
      break;
    case 101063510: 
      if (str.equals("cs.script_get_show_action.local")) {
        return d(paramArgument);
      }
      break;
    case -439099872: 
      if (str.equals("cs.script_action_status_notify.local")) {
        return c(paramArgument);
      }
      break;
    case -455770090: 
      if (str.equals("cs.script_send_action_msg.local")) {
        return f(paramArgument);
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
 * Qualified Name:     com.tencent.mobileqq.cmshow.engine.script.plugin.SpriteAioPlugin
 * JD-Core Version:    0.7.0.1
 */