package com.tencent.tkd.topicsdk.bean;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/TopicInfo$Companion;", "", "()V", "SOURCE_UGC", "", "TAG", "", "parseFromJson", "Lcom/tencent/tkd/topicsdk/bean/TopicInfo;", "jsonObject", "Lorg/json/JSONObject;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class TopicInfo$Companion
{
  @NotNull
  public final TopicInfo a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "jsonObject");
    TopicInfo localTopicInfo = new TopicInfo(0L, null, null, null, false, 0L, 0, 127, null);
    String str = paramJSONObject.optString("title");
    Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(J_KEY_TOPIC_TITLE)");
    localTopicInfo.setTitle(str);
    str = paramJSONObject.optString("iconUrl");
    Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(J_KEY_TOPIC_ICON_URL)");
    localTopicInfo.setCoverUrl(str);
    str = paramJSONObject.optString("intro");
    Intrinsics.checkExpressionValueIsNotNull(str, "jsonObject.optString(J_KEY_TOPIC_INTRO)");
    localTopicInfo.setIntro(str);
    localTopicInfo.setTopicId(paramJSONObject.optLong("topicID"));
    return localTopicInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.TopicInfo.Companion
 * JD-Core Version:    0.7.0.1
 */