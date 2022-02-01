package com.tencent.tkd.topicsdk.bean.globalconfig;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/bean/globalconfig/ManageTopicConfig$Companion;", "", "()V", "BRIEF_COUNT_LIMIT", "", "BRIEF_HINT", "", "DEFAULT_ALLOW_SUBMIT_DESC", "DEFAULT_ALLOW_SUBMIT_TITLE", "DEFAULT_FORBID_SUBMIT_DESC", "DEFAULT_FORBID_SUBMIT_TITLE", "TITLE_COUNT_LIMIT", "TITLE_HINT", "parseFromJson", "Lcom/tencent/tkd/topicsdk/bean/globalconfig/ManageTopicConfig;", "eventInfoJson", "Lorg/json/JSONObject;", "topicsdk_release"}, k=1, mv={1, 1, 16})
public final class ManageTopicConfig$Companion
{
  @NotNull
  public final ManageTopicConfig a(@NotNull JSONObject paramJSONObject)
  {
    Intrinsics.checkParameterIsNotNull(paramJSONObject, "eventInfoJson");
    boolean bool3 = true;
    boolean bool1;
    if (paramJSONObject.optInt("hasTopicPermission", 1) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    boolean bool2;
    if (paramJSONObject.optInt("hasVideoPermission", 1) == 1) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    Object localObject2 = paramJSONObject.optJSONObject("topicPageConfig");
    Object localObject1 = paramJSONObject.optJSONObject("topicSubmitConfig");
    paramJSONObject = new ManageTopicConfig();
    paramJSONObject.setTopicPermissionFlag(bool1);
    paramJSONObject.setVideoPermissionFlag(bool2);
    if (localObject2 != null)
    {
      paramJSONObject.setTitleCountLimit(((JSONObject)localObject2).optInt("titleCountLimit"));
      String str = ((JSONObject)localObject2).optString("titleHint");
      Intrinsics.checkExpressionValueIsNotNull(str, "optString(J_KEY_TITLE_HINT)");
      paramJSONObject.setTitleHint(str);
      paramJSONObject.setBriefCountLimit(((JSONObject)localObject2).optInt("briefCountLimit"));
      localObject2 = ((JSONObject)localObject2).optString("briefHint");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "optString(J_KEY_BRIEF_HINT)");
      paramJSONObject.setBriefHint((String)localObject2);
    }
    if (localObject1 != null)
    {
      if (((JSONObject)localObject1).optInt("showSubmit") == 1) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      paramJSONObject.setShowSubmit(bool1);
      if (((JSONObject)localObject1).optInt("allowSubmit") == 1) {
        bool1 = bool3;
      } else {
        bool1 = false;
      }
      paramJSONObject.setCurrentAllowSubmit(bool1);
      localObject2 = ((JSONObject)localObject1).optString("allowSubmitTitle", "允许他人参加创作");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "optString(J_KEY_ALLOW_SU…                        )");
      paramJSONObject.setAllowSubmitTitle((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("allowSubmitDesc", "允许他人投稿至栏目");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "optString(J_KEY_ALLOW_SU…                        )");
      paramJSONObject.setAllowSubmitDesc((String)localObject2);
      localObject2 = ((JSONObject)localObject1).optString("forbidSubmitTitle", "仅自己创作");
      Intrinsics.checkExpressionValueIsNotNull(localObject2, "optString(J_KEY_FORBID_S…                        )");
      paramJSONObject.setForbidSubmitTitle((String)localObject2);
      localObject1 = ((JSONObject)localObject1).optString("forbidSubmitDesc", "仅栏目创建者可往栏目添加视频");
      Intrinsics.checkExpressionValueIsNotNull(localObject1, "optString(J_KEY_FORBID_S…                        )");
      paramJSONObject.setForbidSubmitDesc((String)localObject1);
    }
    return paramJSONObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.bean.globalconfig.ManageTopicConfig.Companion
 * JD-Core Version:    0.7.0.1
 */