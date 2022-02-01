package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCResult;
import eipc.EIPCResultCallback;
import org.json.JSONException;
import org.json.JSONObject;

final class UiApiPlugin$14
  implements EIPCResultCallback
{
  UiApiPlugin$14(JSONObject paramJSONObject, CallCommentJs paramCallCommentJs, String paramString) {}
  
  public void onCallback(EIPCResult paramEIPCResult)
  {
    boolean bool;
    if ((paramEIPCResult != null) && (paramEIPCResult.data != null)) {
      bool = paramEIPCResult.data.getBoolean("action_update_biu_and_comment_switch");
    } else {
      bool = false;
    }
    try
    {
      this.jdField_a_of_type_OrgJsonJSONObject.put("isGrayscaleUser", bool);
    }
    catch (JSONException paramEIPCResult)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("webGetCommentAladdinConfig error ");
      localStringBuilder.append(paramEIPCResult.getMessage());
      QLog.e("UiApiPlugin", 1, localStringBuilder.toString());
    }
    paramEIPCResult = new StringBuilder();
    paramEIPCResult.append("webGetCommentAladdinConfig is ");
    paramEIPCResult.append(bool);
    QLog.e("UiApiPlugin", 1, paramEIPCResult.toString());
    this.jdField_a_of_type_ComTencentMobileqqKandianBizFastwebCallCommentJs.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.UiApiPlugin.14
 * JD-Core Version:    0.7.0.1
 */