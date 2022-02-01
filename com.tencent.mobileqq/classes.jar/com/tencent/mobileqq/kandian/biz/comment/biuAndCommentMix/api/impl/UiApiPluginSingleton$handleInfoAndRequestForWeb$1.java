package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/UiApiPluginSingleton$handleInfoAndRequestForWeb$1", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager$BiuAndCommentListener;", "onBiuAndCommentSend", "", "respData", "Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRespData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UiApiPluginSingleton$handleInfoAndRequestForWeb$1
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  UiApiPluginSingleton$handleInfoAndRequestForWeb$1(CallCommentJs paramCallCommentJs, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(@Nullable RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if ((this.a != null) && (!TextUtils.isEmpty((CharSequence)this.b)))
    {
      CallCommentJs localCallCommentJs = this.a;
      String str1 = this.b;
      UiApiPluginSingleton localUiApiPluginSingleton = UiApiPluginSingleton.INSTANCE;
      String str2 = this.c;
      Intrinsics.checkExpressionValueIsNotNull(str2, "replyFirstCommentId");
      String str3 = this.d;
      Intrinsics.checkExpressionValueIsNotNull(str3, "replySubCommentId");
      String str4 = this.e;
      Intrinsics.checkExpressionValueIsNotNull(str4, "replyNick");
      localCallCommentJs.a(str1, UiApiPluginSingleton.access$convertRespDataToJsonString(localUiApiPluginSingleton, paramRIJBiuAndCommentRespData, str2, str3, str4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.UiApiPluginSingleton.handleInfoAndRequestForWeb.1
 * JD-Core Version:    0.7.0.1
 */