package com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.IRIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.mobileqq.kandian.repo.comment.entity.RIJBiuAndCommentRespData;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"com/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/impl/UiApiPluginImpl$handleInfoAndRequestForWeb$1", "Lcom/tencent/mobileqq/kandian/biz/comment/biuAndCommentMix/api/IRIJBiuAndCommentMixDataManager$BiuAndCommentListener;", "onBiuAndCommentSend", "", "respData", "Lcom/tencent/mobileqq/kandian/repo/comment/entity/RIJBiuAndCommentRespData;", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class UiApiPluginImpl$handleInfoAndRequestForWeb$1
  implements IRIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  UiApiPluginImpl$handleInfoAndRequestForWeb$1(CallCommentJs paramCallCommentJs, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(@Nullable RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebCallCommentJs != null) && (!TextUtils.isEmpty((CharSequence)this.jdField_a_of_type_JavaLangString)))
    {
      CallCommentJs localCallCommentJs = this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebCallCommentJs;
      String str1 = this.jdField_a_of_type_JavaLangString;
      UiApiPluginImpl localUiApiPluginImpl = this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentBiuAndCommentMixApiImplUiApiPluginImpl;
      String str2 = this.b;
      Intrinsics.checkExpressionValueIsNotNull(str2, "replyFirstCommentId");
      String str3 = this.c;
      Intrinsics.checkExpressionValueIsNotNull(str3, "replySubCommentId");
      String str4 = this.d;
      Intrinsics.checkExpressionValueIsNotNull(str4, "replyNick");
      localCallCommentJs.a(str1, UiApiPluginImpl.access$convertRespDataToJsonString(localUiApiPluginImpl, paramRIJBiuAndCommentRespData, str2, str3, str4));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.comment.biuAndCommentMix.api.impl.UiApiPluginImpl.handleInfoAndRequestForWeb.1
 * JD-Core Version:    0.7.0.1
 */