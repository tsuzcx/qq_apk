package com.tencent.mobileqq.kandian.glue.viola.modules;

import com.tencent.mobileqq.kandian.biz.comment.entity.BaseCommentData;
import com.tencent.mobileqq.kandian.biz.comment.entity.CreateCommentResult;
import com.tencent.mobileqq.kandian.biz.comment.rptdata.RIJCommentRptDataUtil;
import com.tencent.mobileqq.kandian.biz.comment.util.api.IRIJCommentNetworkHelper.RIJCreateCommentObserver;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class BridgeModule$11
  implements IRIJCommentNetworkHelper.RIJCreateCommentObserver
{
  BridgeModule$11(BridgeModule paramBridgeModule, JSONObject paramJSONObject, BaseCommentData paramBaseCommentData, JSONArray paramJSONArray, String paramString) {}
  
  public void a(CreateCommentResult paramCreateCommentResult)
  {
    try
    {
      boolean bool = paramCreateCommentResult.jdField_a_of_type_Boolean;
      j = 0;
      if (!bool) {
        break label171;
      }
      i = 0;
    }
    catch (JSONException paramCreateCommentResult)
    {
      for (;;)
      {
        int j;
        label151:
        continue;
        label171:
        int i = -2;
      }
    }
    this.jdField_a_of_type_OrgJsonJSONObject.put("retCode", i);
    this.jdField_a_of_type_OrgJsonJSONObject.put("commentId", paramCreateCommentResult.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_OrgJsonJSONObject.put("comment", this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentContent);
    if (this.jdField_a_of_type_OrgJsonJSONArray != null) {
      this.jdField_a_of_type_OrgJsonJSONObject.put("linkDataList", this.jdField_a_of_type_OrgJsonJSONArray);
    }
    i = j;
    if (paramCreateCommentResult.jdField_a_of_type_Int == -4096) {
      i = 1;
    }
    this.jdField_a_of_type_OrgJsonJSONObject.put("errorType", i);
    this.jdField_a_of_type_OrgJsonJSONObject.put("errorCode", paramCreateCommentResult.jdField_a_of_type_Int);
    this.jdField_a_of_type_OrgJsonJSONObject.put("rptDataList", RIJCommentRptDataUtil.a(this.jdField_a_of_type_ComTencentMobileqqKandianBizCommentEntityBaseCommentData.commentRptDataList));
    break label151;
    QLog.e("BridgeModule", 1, "handleCommentEditorNativeResult put create comment result error.");
    this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeCallJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule.11
 * JD-Core Version:    0.7.0.1
 */