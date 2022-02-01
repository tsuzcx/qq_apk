package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IUiApiPlugin;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRequestData;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import com.tencent.mobileqq.kandian.repo.db.struct.BaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.qphone.base.util.QLog;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/UiApiPluginSingleton;", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IUiApiPlugin;", "()V", "TAG", "", "convertRespDataToJsonString", "Lorg/json/JSONObject;", "respData", "Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRespData;", "replyFirstCommentId", "replySubCommentId", "replyNick", "handleInfoAndRequestForWeb", "", "intent", "Landroid/content/Intent;", "dataManager", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager;", "callBackId", "callCommentJs", "Lcom/tencent/mobileqq/kandian/biz/fastweb/CallCommentJs;", "requestBiuAndCommentForWeb", "contentSrc", "", "articleInfo", "Lcom/tencent/mobileqq/kandian/repo/feeds/entity/AbsBaseArticleInfo;", "commentType", "replyCommentId", "replyParentCommentId", "replyString", "isToFriend", "", "isSecondReply", "replyUin", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UiApiPluginSingleton
  implements IUiApiPlugin
{
  public static final UiApiPluginSingleton INSTANCE = new UiApiPluginSingleton();
  private static final String TAG = "UiApiPluginImpl";
  
  private final JSONObject convertRespDataToJsonString(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData, String paramString1, String paramString2, String paramString3)
  {
    JSONObject localJSONObject = new JSONObject();
    if (paramRIJBiuAndCommentRespData == null) {
      return localJSONObject;
    }
    try
    {
      localJSONObject.put("retCode", paramRIJBiuAndCommentRespData.a());
      localJSONObject.put("rspCommentId", paramRIJBiuAndCommentRespData.b());
      localJSONObject.put("replyFirstCommentId", paramString1);
      localJSONObject.put("replySubCommentId", paramString2);
      localJSONObject.put("comment", paramRIJBiuAndCommentRespData.g());
      localJSONObject.put("replyUin", paramRIJBiuAndCommentRespData.k());
      localJSONObject.put("replyNick", paramString3);
      return localJSONObject;
    }
    catch (JSONException paramRIJBiuAndCommentRespData)
    {
      paramString1 = new StringBuilder();
      paramString1.append("convertRespDataToJsonString error :");
      paramString1.append(paramRIJBiuAndCommentRespData.getMessage());
      QLog.e("UiApiPluginImpl", 1, paramString1.toString());
    }
    return localJSONObject;
  }
  
  private final void requestBiuAndCommentForWeb(IRIJBiuAndCommentMixDataManager paramIRIJBiuAndCommentMixDataManager, int paramInt1, AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt2, String paramString1, String paramString2, String paramString3, boolean paramBoolean1, boolean paramBoolean2, String paramString4)
  {
    RIJBiuAndCommentRequestData localRIJBiuAndCommentRequestData = new RIJBiuAndCommentRequestData();
    localRIJBiuAndCommentRequestData.setBiu(true);
    localRIJBiuAndCommentRequestData.setContentSrc(paramInt1);
    localRIJBiuAndCommentRequestData.setContentString(paramString3);
    localRIJBiuAndCommentRequestData.setDiffuseToFriends(paramBoolean1);
    if (paramAbsBaseArticleInfo == null) {
      paramString3 = "";
    } else {
      paramString3 = paramAbsBaseArticleInfo.innerUniqueID;
    }
    localRIJBiuAndCommentRequestData.setRowKey(paramString3);
    localRIJBiuAndCommentRequestData.setListShowType(2);
    localRIJBiuAndCommentRequestData.setCommentType(paramInt2);
    localRIJBiuAndCommentRequestData.setReplyCommentId(paramString1);
    localRIJBiuAndCommentRequestData.setReplyParentCommentId(paramString2);
    localRIJBiuAndCommentRequestData.setIsSecondReply(paramBoolean2);
    localRIJBiuAndCommentRequestData.setReplyUin(paramString4);
    paramIRIJBiuAndCommentMixDataManager.a(paramAbsBaseArticleInfo, localRIJBiuAndCommentRequestData);
  }
  
  public void handleInfoAndRequestForWeb(@Nullable Intent paramIntent, @Nullable IRIJBiuAndCommentMixDataManager paramIRIJBiuAndCommentMixDataManager, @Nullable String paramString, @Nullable CallCommentJs paramCallCommentJs)
  {
    if ((paramIntent != null) && (paramIRIJBiuAndCommentMixDataManager != null)) {}
    for (;;)
    {
      try
      {
        String str1 = paramIntent.getStringExtra("comment_json_string");
        if (TextUtils.isEmpty((CharSequence)str1))
        {
          QLog.e("UiApiPluginImpl", 1, "handleInfoAndRequestForWeb webJsonString is null");
          return;
        }
        Object localObject1 = new JSONObject(str1);
        str1 = ((JSONObject)localObject1).optString("uniqueKey", "");
        int i = ((JSONObject)localObject1).optInt("src", 1);
        int j = ((JSONObject)localObject1).optInt("commentType", 1);
        String str2 = ((JSONObject)localObject1).optString("replyFirstCommentId", "");
        String str3 = ((JSONObject)localObject1).optString("replySubCommentId", "");
        String str4 = ((JSONObject)localObject1).optString("replyUin", "");
        localObject1 = ((JSONObject)localObject1).optString("replyNick", "");
        Object localObject2 = new JSONObject(paramIntent.getStringExtra("arg_result_json"));
        paramIntent = ((JSONObject)localObject2).optString("comment");
        boolean bool2 = ((JSONObject)localObject2).optBoolean("select_to_friend");
        localObject2 = (AbsBaseArticleInfo)new BaseArticleInfo();
        ((AbsBaseArticleInfo)localObject2).innerUniqueID = str1;
        paramIRIJBiuAndCommentMixDataManager.a((IRIJBiuAndCommentMixDataManager.BiuAndCommentListener)new UiApiPluginSingleton.handleInfoAndRequestForWeb.1(paramCallCommentJs, paramString, str2, str3, (String)localObject1));
        Intrinsics.checkExpressionValueIsNotNull(str3, "replySubCommentId");
        Intrinsics.checkExpressionValueIsNotNull(str2, "replyFirstCommentId");
        Intrinsics.checkExpressionValueIsNotNull(paramIntent, "replyString");
        if (TextUtils.isEmpty((CharSequence)str3)) {
          break label313;
        }
        bool1 = true;
        Intrinsics.checkExpressionValueIsNotNull(str4, "replyUin");
        requestBiuAndCommentForWeb(paramIRIJBiuAndCommentMixDataManager, i, (AbsBaseArticleInfo)localObject2, j, str3, str2, paramIntent, bool2, bool1, str4);
        return;
      }
      catch (JSONException paramIntent)
      {
        paramIRIJBiuAndCommentMixDataManager = new StringBuilder();
        paramIRIJBiuAndCommentMixDataManager.append("handleInfoAndRequestForWeb error :");
        paramIRIJBiuAndCommentMixDataManager.append(paramIntent.getMessage());
        QLog.e("UiApiPluginImpl", 1, paramIRIJBiuAndCommentMixDataManager.toString());
        return;
      }
      QLog.d("UiApiPluginImpl", 1, "requestCommentCreateForWeb object is null");
      return;
      label313:
      boolean bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.UiApiPluginSingleton
 * JD-Core Version:    0.7.0.1
 */