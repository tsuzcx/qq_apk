package com.tencent.mobileqq.kandian.biz.common;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.kandian.biz.biu.RIJBiuAndCommentMixDataManager;
import com.tencent.mobileqq.kandian.biz.fastweb.CallCommentJs;
import eipc.EIPCResult;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyIPCModule$1
  implements CallCommentJs
{
  ReadInJoyIPCModule$1(ReadInJoyIPCModule paramReadInJoyIPCModule, int paramInt, RIJBiuAndCommentMixDataManager paramRIJBiuAndCommentMixDataManager) {}
  
  public void a(String paramString, JSONObject paramJSONObject)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramJSONObject != null))
    {
      try
      {
        paramJSONObject.put("arg_callback", paramString);
      }
      catch (JSONException paramString)
      {
        paramString.printStackTrace();
      }
      paramString = new Bundle();
      paramString.putString("action_update_biu_and_comment_request_string", paramJSONObject.toString());
      paramString = EIPCResult.createResult(0, paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizCommonReadInJoyIPCModule.callbackResult(this.jdField_a_of_type_Int, paramString);
      this.jdField_a_of_type_ComTencentMobileqqKandianBizBiuRIJBiuAndCommentMixDataManager.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyIPCModule.1
 * JD-Core Version:    0.7.0.1
 */