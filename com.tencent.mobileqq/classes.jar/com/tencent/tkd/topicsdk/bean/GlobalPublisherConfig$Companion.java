package com.tencent.tkd.topicsdk.bean;

import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig$Companion;", "", "()V", "TAG", "", "THEME_DEFAULT", "", "THEME_FIREWORKS", "parseFromJson", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "eventInfoJson", "Lorg/json/JSONObject;", "eventInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GlobalPublisherConfig$Companion
{
  @NotNull
  public final GlobalPublisherConfig a(@NotNull JSONObject paramJSONObject, @Nullable HashMap<?, ?> paramHashMap)
  {
    boolean bool2 = true;
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "eventInfoJson");
    GlobalPublisherConfig localGlobalPublisherConfig = new GlobalPublisherConfig();
    GlobalPublisherConfig.access$putReportInfo(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putPermissionInfo(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putPublishScene(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putPublishOwner(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putCircleID(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putInputPanelConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putRecentTopicConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putBottomPanelConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putOriginVideoInfo(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putReprintAuthorityConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putPrivacyConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putColumnConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putBusinessToastConfig(localGlobalPublisherConfig, paramJSONObject);
    GlobalPublisherConfig.access$putCommodityConfig(localGlobalPublisherConfig, paramJSONObject);
    localGlobalPublisherConfig.setPublisherTheme(paramJSONObject.optInt("theme", 0));
    Object localObject = paramJSONObject.optString("scene");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(J_KEY_SCENE)");
    localGlobalPublisherConfig.setScene((String)localObject);
    localGlobalPublisherConfig.setCountLimit(paramJSONObject.optInt("textCountLimit", 500));
    if (paramJSONObject.optInt("textTruncation") == 1)
    {
      bool1 = true;
      localGlobalPublisherConfig.setNeedTextTruncation(bool1);
      localObject = paramJSONObject.optString("placeholder", "写点什么吧，万一火了呢");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…DER\n                    )");
      localGlobalPublisherConfig.setPlaceHolder((String)localObject);
      localObject = paramJSONObject.optJSONObject("originTextInfo");
      if (localObject == null) {
        break label419;
      }
      localObject = ((JSONObject)localObject).toString();
      if (localObject == null) {
        break label419;
      }
      label217:
      localGlobalPublisherConfig.setOriginText((String)localObject);
      localObject = paramJSONObject.optString("navigationBarTitle");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…KEY_NAVIGATION_BAR_TITLE)");
      localGlobalPublisherConfig.setNavigationBarText((String)localObject);
      if (paramJSONObject.optInt("allowCommentAfterPublish") == 0) {
        break label426;
      }
      bool1 = true;
      label257:
      localGlobalPublisherConfig.setShowCommentAfterPublish(bool1);
      localObject = paramJSONObject.optString("defaultPublishText");
      Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…KEY_DEFAULT_PUBLISH_TEXT)");
      localGlobalPublisherConfig.setDefaultPublishText((String)localObject);
      localGlobalPublisherConfig.setTweetTopicChoiceType(paramJSONObject.optInt("tweetTopicChoiceType"));
      if (paramJSONObject.optInt("allowDeleteTweetTopic") != 1) {
        break label431;
      }
      bool1 = true;
      label308:
      localGlobalPublisherConfig.setAllowDeleteTweetTopic(bool1);
      localGlobalPublisherConfig.setOriginContentInfo(OriginContentInfo.Companion.a(paramJSONObject));
      if (paramJSONObject.optInt("enableDraft") != 1) {
        break label436;
      }
      bool1 = true;
      label338:
      localGlobalPublisherConfig.setEnableSaveDraft(bool1);
      localGlobalPublisherConfig.setMaxImageSize(paramJSONObject.optInt("maxImageSize", 15360));
      if (paramJSONObject.optInt("allowSaveToAlbum") != 1) {
        break label441;
      }
    }
    label419:
    label426:
    label431:
    label436:
    label441:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localGlobalPublisherConfig.setShowSaveAlbums(bool1);
      localGlobalPublisherConfig.setTopicConfig(ManageTopicConfig.Companion.a(paramJSONObject));
      localGlobalPublisherConfig.setShowAddLocation(paramJSONObject.optBoolean("showToolBarLBS"));
      localGlobalPublisherConfig.setEventInfo(paramHashMap);
      localGlobalPublisherConfig.applyValidProtect();
      return localGlobalPublisherConfig;
      bool1 = false;
      break;
      localObject = "";
      break label217;
      bool1 = false;
      break label257;
      bool1 = false;
      break label308;
      bool1 = false;
      break label338;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig.Companion
 * JD-Core Version:    0.7.0.1
 */