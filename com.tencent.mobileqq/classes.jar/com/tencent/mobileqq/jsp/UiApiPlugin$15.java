package com.tencent.mobileqq.jsp;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentMixDataManager.BiuAndCommentListener;
import com.tencent.biz.pubaccount.readinjoy.biuAndCommentMix.RIJBiuAndCommentRespData;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.CallCommentJs;

final class UiApiPlugin$15
  implements RIJBiuAndCommentMixDataManager.BiuAndCommentListener
{
  UiApiPlugin$15(BridgeModule.CallCommentJs paramCallCommentJs, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void a(RIJBiuAndCommentRespData paramRIJBiuAndCommentRespData)
  {
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$CallCommentJs != null) && (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))) {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViolaModulesBridgeModule$CallCommentJs.a(this.jdField_a_of_type_JavaLangString, UiApiPlugin.a(paramRIJBiuAndCommentRespData, this.b, this.c, this.d));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.15
 * JD-Core Version:    0.7.0.1
 */