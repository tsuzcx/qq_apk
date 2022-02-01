package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.base.utils.RIJQQAppInterfaceUtil;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ViolaBizUtils$3$1
  implements Runnable
{
  ViolaBizUtils$3$1(ViolaBizUtils.3 param3, JSONObject paramJSONObject, JSONArray paramJSONArray) {}
  
  public void run()
  {
    for (;;)
    {
      Object localObject;
      try
      {
        this.jdField_a_of_type_OrgJsonJSONObject.put("uploadVideoList", this.jdField_a_of_type_OrgJsonJSONArray);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errCode", this.this$0.jdField_a_of_type_Int);
        this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", this.this$0.jdField_a_of_type_JavaLangString);
        JSONObject localJSONObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (!this.this$0.jdField_a_of_type_Boolean) {
          break label300;
        }
        i = 1;
        localJSONObject.put("hasVideoPublished", i);
        RIJQQAppInterfaceUtil.a();
      }
      catch (JSONException localJSONException)
      {
        localObject = ViolaBizUtils.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getUploadingVideoInfo onResult, put uploadVideoList error =");
        localStringBuilder.append(QLog.getStackTraceString(localJSONException));
        QLog.e((String)localObject, 1, localStringBuilder.toString());
      }
      String str;
      if (QLog.isColorLevel())
      {
        str = ViolaBizUtils.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getUploadingVideoInfo, onResult=");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_OrgJsonJSONObject.toString());
        ((StringBuilder)localObject).append("errCode=");
        ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("errMsg=");
        ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
        QLog.i(str, 2, ((StringBuilder)localObject).toString());
      }
      if (this.this$0.jdField_a_of_type_Int != 0)
      {
        str = ViolaBizUtils.jdField_a_of_type_JavaLangString;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("responseUploadingVideoListerrCode=");
        ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_Int);
        ((StringBuilder)localObject).append("errMsg=");
        ((StringBuilder)localObject).append(this.this$0.jdField_a_of_type_JavaLangString);
        QLog.i(str, 1, ((StringBuilder)localObject).toString());
      }
      this.this$0.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeJS(this.this$0.b, this.jdField_a_of_type_OrgJsonJSONObject);
      return;
      label300:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.3.1
 * JD-Core Version:    0.7.0.1
 */