package com.tencent.mobileqq.kandian.glue.viola.utils;

import com.tencent.mobileqq.kandian.biz.ugc.editvideo.PublishVideoHelper.IMoveUgcVideoCallback;
import com.tencent.mobileqq.kandian.glue.viola.modules.BridgeModule;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

final class ViolaBizUtils$7
  implements PublishVideoHelper.IMoveUgcVideoCallback
{
  ViolaBizUtils$7(JSONObject paramJSONObject, BridgeModule paramBridgeModule, String paramString) {}
  
  public void a(int paramInt, String paramString)
  {
    for (;;)
    {
      try
      {
        localObject = this.jdField_a_of_type_OrgJsonJSONObject;
        if (paramInt == 0)
        {
          paramInt = 0;
          ((JSONObject)localObject).put("errCode", paramInt);
          this.jdField_a_of_type_OrgJsonJSONObject.put("errMsg", paramString);
          this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
          return;
        }
      }
      catch (JSONException paramString)
      {
        this.jdField_a_of_type_ComTencentMobileqqKandianGlueViolaModulesBridgeModule.invokeJS(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_OrgJsonJSONObject);
        Object localObject = ViolaBizUtils.jdField_a_of_type_JavaLangString;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("oidb_0xe2a error! e = ");
        localStringBuilder.append(paramString.toString());
        QLog.e((String)localObject, 1, localStringBuilder.toString());
        return;
      }
      paramInt = -1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.utils.ViolaBizUtils.7
 * JD-Core Version:    0.7.0.1
 */