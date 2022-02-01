package com.tencent.tkd.topicsdk.bean;

import android.os.Bundle;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig$Companion;", "", "()V", "TAG", "", "parseFromJson", "Lcom/tencent/tkd/topicsdk/bean/GlobalPublisherConfig;", "eventInfoJson", "Lorg/json/JSONObject;", "eventInfo", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "getGlobalConfig", "Landroid/os/Bundle;", "putGlobalConfig", "", "config", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class GlobalPublisherConfig$Companion
{
  @Nullable
  public final GlobalPublisherConfig a(@NotNull Bundle paramBundle)
  {
    Intrinsics.checkParameterIsNotNull(paramBundle, "$this$getGlobalConfig");
    return (GlobalPublisherConfig)paramBundle.getSerializable("global_publisher_config");
  }
  
  @NotNull
  public final GlobalPublisherConfig a(@NotNull JSONObject paramJSONObject, @Nullable HashMap<?, ?> paramHashMap)
  {
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
    GlobalPublisherConfig.access$putNeedShowPublishToast(localGlobalPublisherConfig, paramJSONObject);
    boolean bool2 = false;
    localGlobalPublisherConfig.setPublisherTheme(paramJSONObject.optInt("theme", 0));
    Object localObject = paramJSONObject.optString("scene");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(J_KEY_SCENE)");
    localGlobalPublisherConfig.setScene((String)localObject);
    localGlobalPublisherConfig.setContentUpperLimit(paramJSONObject.optInt("textCountLimit", 500));
    localGlobalPublisherConfig.setContentLowerLimit(paramJSONObject.optInt("textCountLowerLimit"));
    if (paramJSONObject.optInt("textTruncation") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setNeedTextTruncation(bool1);
    localObject = paramJSONObject.optString("placeholder", "写点什么吧，万一火了呢");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…DER\n                    )");
    localGlobalPublisherConfig.setPlaceHolder((String)localObject);
    localObject = paramJSONObject.optJSONObject("originTextInfo");
    if (localObject != null)
    {
      localObject = ((JSONObject)localObject).toString();
      if (localObject != null) {}
    }
    else
    {
      localObject = "";
    }
    localGlobalPublisherConfig.setOriginText((String)localObject);
    localObject = paramJSONObject.optString("navigationBarTitle");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…KEY_NAVIGATION_BAR_TITLE)");
    localGlobalPublisherConfig.setNavigationBarText((String)localObject);
    if (paramJSONObject.optInt("allowCommentAfterPublish") != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setShowCommentAfterPublish(bool1);
    localObject = paramJSONObject.optString("defaultPublishText");
    Intrinsics.checkExpressionValueIsNotNull(localObject, "eventInfoJson.optString(…KEY_DEFAULT_PUBLISH_TEXT)");
    localGlobalPublisherConfig.setDefaultPublishText((String)localObject);
    localGlobalPublisherConfig.setTweetTopicChoiceType(paramJSONObject.optInt("tweetTopicChoiceType"));
    if (paramJSONObject.optInt("allowDeleteTweetTopic", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setAllowDeleteTweetTopic(bool1);
    if (paramJSONObject.optInt("allowCreateTweetTopic", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setAllowCreateTweetTopic(bool1);
    localGlobalPublisherConfig.setOriginContentInfo(OriginContentInfo.Companion.a(paramJSONObject));
    if (paramJSONObject.optInt("enableDraft") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setEnableSaveDraft(bool1);
    localGlobalPublisherConfig.setMaxImageSize(paramJSONObject.optInt("maxImageSize", 15360));
    if (paramJSONObject.optInt("allowSaveToAlbum") == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localGlobalPublisherConfig.setShowSaveAlbums(bool1);
    localGlobalPublisherConfig.setShowAddLocation(paramJSONObject.optBoolean("showToolBarLBS"));
    boolean bool1 = bool2;
    if (paramJSONObject.optInt("showOriginalTag") == 1) {
      bool1 = true;
    }
    localGlobalPublisherConfig.setShowOriginalTag(bool1);
    localGlobalPublisherConfig.setAllowEmoji(paramJSONObject.optBoolean("allowPublishEmoji"));
    localGlobalPublisherConfig.setEventInfo(paramHashMap);
    localGlobalPublisherConfig.applyValidProtect();
    return localGlobalPublisherConfig;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.GlobalPublisherConfig.Companion
 * JD-Core Version:    0.7.0.1
 */