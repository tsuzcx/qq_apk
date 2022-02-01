package com.tencent.mobileqq.kandian.glue.viola.modules.bridge;

import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeDispatcher;
import com.tencent.mobileqq.kandian.biz.xtab.badge.RIJXTabBadgeStore;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.KandianMergeManager;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.mobileqq.kandian.repo.tab.RIJXTabRedDotInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function2;
import mqq.app.AppRuntime;
import org.jetbrains.annotations.NotNull;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/RIJBridgeInvokeHandler;", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/bridge/AbsBridgeInvokeHandler;", "module", "Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;", "(Lcom/tencent/mobileqq/kandian/glue/viola/modules/BridgeModule;)V", "clearChannelRedPoint", "", "param", "Lorg/json/JSONObject;", "callback", "", "directSocialShare", "getChannelRedPointInfo", "nameSpace", "register", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class RIJBridgeInvokeHandler
  extends AbsBridgeInvokeHandler
{
  public static final RIJBridgeInvokeHandler.Companion a = new RIJBridgeInvokeHandler.Companion(null);
  
  public RIJBridgeInvokeHandler(@NotNull BridgeModule paramBridgeModule)
  {
    super(paramBridgeModule);
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
        a().directSocialShare(paramJSONObject, i);
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
      paramJSONObject = ReadInJoyUtils.a().getManager(QQManagerFactory.KANDIAN_MERGE_MANAGER);
      if (paramJSONObject != null)
      {
        ((KandianMergeManager)paramJSONObject).l();
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
        paramJSONObject = RIJXTabBadgeStore.a(paramJSONObject.optInt("channelId"));
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
  
  @NotNull
  public String a()
  {
    return "readinjoy";
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
    a("feeds_refresh_message", (Function2)new RIJBridgeInvokeHandler.register.20(this));
    a("isInKanDianTab", (Function2)new RIJBridgeInvokeHandler.register.21(this));
    a("hasRedPacketSharePermission", (Function2)new RIJBridgeInvokeHandler.register.22(this));
    a("updateRedPacketShareTime", (Function2)new RIJBridgeInvokeHandler.register.23(this));
    a("requestRedPacketContentShareToast", (Function2)new RIJBridgeInvokeHandler.register.24(this));
    a("clearMessageBoxData", (Function2)new RIJBridgeInvokeHandler.register.25(this));
    a("showFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.26(this));
    a("hideFollowAlertView", (Function2)new RIJBridgeInvokeHandler.register.27(this));
    a("getALDConfigParams", (Function2)new RIJBridgeInvokeHandler.register.28(this));
    a("showLevelDialog", (Function2)new RIJBridgeInvokeHandler.register.29(this));
    RIJBridgeInvokeHandler localRIJBridgeInvokeHandler = (RIJBridgeInvokeHandler)this;
    a("directSocialShare", (Function2)new RIJBridgeInvokeHandler.register.30(localRIJBridgeInvokeHandler));
    a("clearChannelRedPoint", (Function2)new RIJBridgeInvokeHandler.register.31(localRIJBridgeInvokeHandler));
    a("getChannelRedPointInfo", (Function2)new RIJBridgeInvokeHandler.register.32(localRIJBridgeInvokeHandler));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.bridge.RIJBridgeInvokeHandler
 * JD-Core Version:    0.7.0.1
 */