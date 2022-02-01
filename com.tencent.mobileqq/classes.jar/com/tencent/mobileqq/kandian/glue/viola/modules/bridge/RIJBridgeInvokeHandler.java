package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.base.utils.RIJSPUtils;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl;
import com.tencent.mobileqq.kandian.biz.privatechat.api.impl.RIJPrivateChatServiceImpl.Companion;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.router.ReadInJoyDailyJumpToKDTabUtils;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.reddot.KandianMsgBoxRedPntInfo;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.mobileqq.kandian.repo.xtab.api.impl.RIJXTabConfigHandler;
import com.tencent.mobileqq.kandian.repo.xtab.badge.RIJXTabBadgeStore;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/RIJBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "clearChannelInsertCardInfo", "", "param", "Lorg/json/JSONObject;", "callback", "", "clearChannelRedPoint", "clearKdTabRedPoint", "clearMessageBarInfo", "clearPrivateChatRedCount", "directSocialShare", "getChannelInsertCardInfo", "getChannelRedPointInfo", "getKanDianMergeManager", "Lcom/tencent/mobileqq/kandian/glue/businesshandler/engine/KandianMergeManager;", "getMessageBarInfo", "getPrivateChatRedCount", "getResultJsonObject", "retCode", "", "nameSpace", "openPrivateChatAio", "openPrivateChatList", "register", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final RIJBridgeInvokeHandler.Companion a = new RIJBridgeInvokeHandler.Companion(null);
  
  public RIJBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
  }
  
  private final JSONObject a(int paramInt)
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("retCode", paramInt);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[getResultJsonObject] error, e = ");
      localStringBuilder.append(localJSONException);
      QLog.e("RIJBridgeInvokeHandler", 1, localStringBuilder.toString());
    }
    return localJSONObject;
  }
  
  private final void a(JSONObject paramJSONObject, String paramString)
  {
    if (paramJSONObject != null)
    {
      paramString = paramJSONObject.optString("shareType", "");
      int i;
      if (paramString.equals("friend")) {
        i = 2;
      } else if (paramString.equals("qzone")) {
        i = 3;
      } else if (paramString.equals("wechat")) {
        i = 9;
      } else if (paramString.equals("wechatcircle")) {
        i = 10;
      } else if (paramString.equals("weibo")) {
        i = 12;
      } else {
        i = -1;
      }
      if (i == -1) {
        return;
      }
      paramJSONObject = paramJSONObject.optJSONObject("shareInfo");
      if (paramJSONObject != null) {
        d().directSocialShare(paramJSONObject, i);
      }
    }
  }
  
  private final void b(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("clearXTabRedPoint, param=");
      paramString.append(paramJSONObject);
      QLog.i("BridgeModule", 2, paramString.toString());
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("channelId")))
    {
      RIJXTabBadgeStore.a(paramJSONObject.optInt("channelId"), true);
      paramJSONObject = ReadInJoyUtils.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramJSONObject != null)
      {
        ((KandianMergeManager)paramJSONObject).I();
        RIJXTabBadgeDispatcher.a();
        return;
      }
      throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
    }
    paramString = new StringBuilder();
    paramString.append("illegal param, param=");
    paramString.append(paramJSONObject);
    QLog.i("BridgeModule", 2, paramString.toString());
  }
  
  private final void c(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getChannelRedPointInfo, param=");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("BridgeModule", 2, ((StringBuilder)localObject).toString());
    }
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = localJSONObject1;
    if (paramJSONObject != null)
    {
      localObject = localJSONObject1;
      if (paramJSONObject.has("channelId") == true)
      {
        paramJSONObject = RIJXTabBadgeStore.b(paramJSONObject.optInt("channelId"));
        localObject = localJSONObject1;
        if (paramJSONObject != null)
        {
          paramJSONObject = paramJSONObject.getRedDotPassThroughInfo();
          localObject = localJSONObject1;
          if (paramJSONObject != null) {
            try
            {
              localObject = new JSONObject(paramJSONObject);
            }
            catch (JSONException paramJSONObject)
            {
              QLog.e("BridgeModule", 1, (Throwable)paramJSONObject, new Object[] { "getChannelRedPointInfo" });
              localObject = localJSONObject1;
            }
          }
        }
      }
    }
    localJSONObject2.put("redPointInfo", localObject);
    a(paramString, localJSONObject2);
  }
  
  private final void d(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getChannelInsertCardInfo], param = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("BridgeModule", 2, ((StringBuilder)localObject).toString());
    }
    JSONObject localJSONObject2 = new JSONObject();
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = localJSONObject1;
    if (paramJSONObject != null)
    {
      localObject = localJSONObject1;
      if (paramJSONObject.has("channelId") == true)
      {
        paramJSONObject = (String)RIJSPUtils.b(ReadInJoyDailyJumpToKDTabUtils.a(paramJSONObject.optInt("channelId")), "");
        localObject = localJSONObject1;
        if (paramJSONObject != null) {
          try
          {
            localObject = new JSONObject(paramJSONObject);
          }
          catch (JSONException paramJSONObject)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("[getChannelInsertCardInfo], e = ");
            ((StringBuilder)localObject).append(paramJSONObject);
            QLog.e("BridgeModule", 1, ((StringBuilder)localObject).toString());
            localObject = localJSONObject1;
          }
        }
      }
    }
    localJSONObject2.put("insertCardInfo", localObject);
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("[getChannelInsertCardInfo] result = ");
      paramJSONObject.append(localJSONObject2);
      QLog.i("BridgeModule", 2, paramJSONObject.toString());
    }
    a(paramString, localJSONObject2);
  }
  
  private final KandianMergeManager e()
  {
    Manager localManager = RIJQQAppInterfaceUtil.b().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
    if (localManager != null) {
      return (KandianMergeManager)localManager;
    }
    throw new TypeCastException("null cannot be cast to non-null type com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager");
  }
  
  private final void e(JSONObject paramJSONObject, String paramString)
  {
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("[clearChannelInsertCardInfo], param = ");
      paramString.append(paramJSONObject);
      QLog.i("BridgeModule", 2, paramString.toString());
    }
    if ((paramJSONObject != null) && (paramJSONObject.has("channelId") == true))
    {
      RIJSPUtils.a(ReadInJoyDailyJumpToKDTabUtils.a(paramJSONObject.optInt("channelId")), "");
      QLog.i("BridgeModule", 2, "[clearChannelInsertCardInfo] succeed.");
    }
  }
  
  private final void f(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = new JSONObject();
    try
    {
      paramJSONObject.put("redCount", RIJPrivateChatServiceImpl.Companion.a().getPrivateChatRedCount());
    }
    catch (JSONException localJSONException)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("[getPrivateChatRedCount] error, e = ");
      localStringBuilder2.append(localJSONException);
      QLog.e("RIJBridgeInvokeHandler", 1, localStringBuilder2.toString());
    }
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("[getPrivateChatRedCount] result = ");
    localStringBuilder1.append(paramJSONObject);
    QLog.i("RIJBridgeInvokeHandler", 1, localStringBuilder1.toString());
    a(paramString, paramJSONObject);
  }
  
  private final void g(JSONObject paramJSONObject, String paramString)
  {
    paramJSONObject = a(0);
    RIJPrivateChatServiceImpl.Companion.a().clearPrivateChatRedCount();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[clearPrivateChatRedCount] result = ");
    localStringBuilder.append(paramJSONObject);
    QLog.i("RIJBridgeInvokeHandler", 1, localStringBuilder.toString());
    a(paramString, paramJSONObject);
  }
  
  private final void h(JSONObject paramJSONObject, String paramString)
  {
    RIJPrivateChatServiceImpl.Companion.a().openPrivateChatList();
    paramJSONObject = a(0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("[openPrivateChatList] result = ");
    localStringBuilder.append(paramJSONObject);
    QLog.i("RIJBridgeInvokeHandler", 1, localStringBuilder.toString());
    a(paramString, paramJSONObject);
  }
  
  private final void i(JSONObject paramJSONObject, String paramString)
  {
    long l;
    if (paramJSONObject != null) {
      l = paramJSONObject.optLong("uin", 0L);
    } else {
      l = 0L;
    }
    Object localObject2 = "";
    Object localObject1 = localObject2;
    if (paramJSONObject != null)
    {
      String str = paramJSONObject.optString("accountName", "");
      localObject1 = localObject2;
      if (str != null) {
        localObject1 = str;
      }
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[openPrivateChatAio], param = ");
    ((StringBuilder)localObject2).append(paramJSONObject);
    QLog.i("RIJBridgeInvokeHandler", 1, ((StringBuilder)localObject2).toString());
    paramJSONObject = a(0);
    if ((l != 0L) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
      RIJPrivateChatServiceImpl.Companion.a().openAIOIntent((Context)d().getActivity(), String.valueOf(l), (String)localObject1);
    } else {
      paramJSONObject = a(1);
    }
    localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("[openPrivateChatAio] result = ");
    ((StringBuilder)localObject1).append(paramJSONObject);
    QLog.i("RIJBridgeInvokeHandler", 1, ((StringBuilder)localObject1).toString());
    a(paramString, paramJSONObject);
  }
  
  private final void j(JSONObject paramJSONObject, String paramString)
  {
    Object localObject = e().Q();
    paramJSONObject = new JSONObject();
    if (localObject != null) {
      paramJSONObject.put("messageBarInfo", e().b((KandianMsgBoxRedPntInfo)localObject));
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getMessageBarInfo] result = ");
      ((StringBuilder)localObject).append(paramJSONObject);
      QLog.i("RIJBridgeInvokeHandler", 1, ((StringBuilder)localObject).toString());
    }
    a(paramString, paramJSONObject);
  }
  
  private final void k(JSONObject paramJSONObject, String paramString)
  {
    e().T();
    if (QLog.isColorLevel()) {
      QLog.i("RIJBridgeInvokeHandler", 1, "[clearMessageBarInfo]");
    }
    a(paramString, new JSONObject());
  }
  
  private final void l(JSONObject paramJSONObject, String paramString)
  {
    int i = RIJXTabConfigHandler.INSTANCE.getDefaultEnterTabId();
    paramJSONObject = a(1);
    if (i == 41726)
    {
      e().W();
      paramJSONObject.put("retCode", 0);
    }
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[clearKdTabRedPoint] result = ");
      localStringBuilder.append(paramJSONObject);
      localStringBuilder.append(", defaultEnterTabId = ");
      localStringBuilder.append(i);
      QLog.i("RIJBridgeInvokeHandler", 1, localStringBuilder.toString());
    }
    a(paramString, paramJSONObject);
  }
  
  public void a()
  {
    a("openPrivateLetter", (Function2)new RIJBridgeInvokeHandler.register.1(this));
    a("openVideo", (Function2)new RIJBridgeInvokeHandler.register.2(this));
    a("QReport", (Function2)new RIJBridgeInvokeHandler.register.3(this));
    a("showUGCEditPage", (Function2)new RIJBridgeInvokeHandler.register.4(this));
    a("showMultiBiuEditPage", (Function2)new RIJBridgeInvokeHandler.register.5(this));
    a("selectAndInviteFriend", (Function2)new RIJBridgeInvokeHandler.register.6(this));
    a("selectAndUploadAvatar", (Function2)new RIJBridgeInvokeHandler.register.7(this));
    a("uploadTopicPic", (Function2)new RIJBridgeInvokeHandler.register.8(this));
    a("showPicture", (Function2)new RIJBridgeInvokeHandler.register.9(this));
    a("openAccountPageMore", (Function2)new RIJBridgeInvokeHandler.register.10(this));
    a("socialize_feeds_update", (Function2)new RIJBridgeInvokeHandler.register.11(this));
    a("updateAccountCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.12(this));
    a("updateTopicCardFollowInfo", (Function2)new RIJBridgeInvokeHandler.register.13(this));
    a("showVisibleUserList", (Function2)new RIJBridgeInvokeHandler.register.14(this));
    a("getBiuTriggerType", (Function2)new RIJBridgeInvokeHandler.register.15(this));
    a("showShareReadInJoyMenu", (Function2)new RIJBridgeInvokeHandler.register.16(this));
    a("showUGCVideoRecordPage", (Function2)new RIJBridgeInvokeHandler.register.17(this));
    a("showCommentEditor", (Function2)new RIJBridgeInvokeHandler.register.18(this));
    a("showCommentEditorNative", (Function2)new RIJBridgeInvokeHandler.register.19(this));
    a("showMessageBoardEditorNative", (Function2)new RIJBridgeInvokeHandler.register.20(this));
    a("feeds_refresh_message", (Function2)new RIJBridgeInvokeHandler.register.21(this));
    a("isInKanDianTab", (Function2)new RIJBridgeInvokeHandler.register.22(this));
    a("hasRedPacketSharePermission", (Function2)new RIJBridgeInvokeHandler.register.23(this));
    a("updateRedPacketShareTime", (Function2)new RIJBridgeInvokeHandler.register.24(this));
    a("requestRedPacketContentShareToast", (Function2)new RIJBridgeInvokeHandler.register.25(this));
    a("clearMessageBoxData", (Function2)new RIJBridgeInvokeHandler.register.26(this));
    a("showFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.27(this));
    a("hideFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.28(this));
    a("getALDConfigParams", (Function2)new RIJBridgeInvokeHandler.register.29(this));
    a("showLevelDialog", (Function2)new RIJBridgeInvokeHandler.register.30(this));
    RIJBridgeInvokeHandler localRIJBridgeInvokeHandler = (RIJBridgeInvokeHandler)this;
    a("directSocialShare", (Function2)new RIJBridgeInvokeHandler.register.31(localRIJBridgeInvokeHandler));
    a("clearChannelRedPoint", (Function2)new RIJBridgeInvokeHandler.register.32(localRIJBridgeInvokeHandler));
    a("getChannelRedPointInfo", (Function2)new RIJBridgeInvokeHandler.register.33(localRIJBridgeInvokeHandler));
    a("getChannelInsertCardInfo", (Function2)new RIJBridgeInvokeHandler.register.34(localRIJBridgeInvokeHandler));
    a("clearChannelInsertCardInfo", (Function2)new RIJBridgeInvokeHandler.register.35(localRIJBridgeInvokeHandler));
    a("getPrivateChatRedCount", (Function2)new RIJBridgeInvokeHandler.register.36(localRIJBridgeInvokeHandler));
    a("clearPrivateChatRedCount", (Function2)new RIJBridgeInvokeHandler.register.37(localRIJBridgeInvokeHandler));
    a("openPrivateChatList", (Function2)new RIJBridgeInvokeHandler.register.38(localRIJBridgeInvokeHandler));
    a("openPrivateChatAio", (Function2)new RIJBridgeInvokeHandler.register.39(localRIJBridgeInvokeHandler));
    a("getMessageBarInfo", (Function2)new RIJBridgeInvokeHandler.register.40(localRIJBridgeInvokeHandler));
    a("clearMessageBarInfo", (Function2)new RIJBridgeInvokeHandler.register.41(localRIJBridgeInvokeHandler));
    a("clearKdTabRedPoint", (Function2)new RIJBridgeInvokeHandler.register.42(localRIJBridgeInvokeHandler));
    a("getYouthMode", (Function2)new RIJBridgeInvokeHandler.register.43(this));
    a("getFeedsStyleType", (Function2)new RIJBridgeInvokeHandler.register.44(this));
  }
  
  @NotNull
  public String b()
  {
    return "readinjoy";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.RIJBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */