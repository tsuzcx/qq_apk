package com.tencent.mobileqq.kandian.glue.webplugin;

import android.os.Bundle;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class ReadInJoyWebviewPlugin$7
  implements ITroopMemberApiClientApi.Callback
{
  ReadInJoyWebviewPlugin$7(ReadInJoyWebviewPlugin paramReadInJoyWebviewPlugin, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    if (QLog.isDebugVersion())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("receive cancelLoadSkin callback resp:");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.d("ReadInJoyWebviewPlugin", 4, ((StringBuilder)localObject).toString());
    }
    Object localObject = new JSONObject();
    try
    {
      localObject = ((JSONObject)localObject).put("retCode", paramBundle.getInt("retCode"));
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(paramBundle.getString("skinId"));
      paramBundle = ((JSONObject)localObject).put("skinId", localStringBuilder.toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { paramBundle.toString() });
      return;
    }
    catch (JSONException paramBundle)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("readSkinAndSound error ");
      ((StringBuilder)localObject).append(paramBundle.toString());
      QLog.w("ReadInJoyWebviewPlugin", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_ComTencentMobileqqKandianGlueWebpluginReadInJoyWebviewPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { "{\"retCode\":-1}" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.webplugin.ReadInJoyWebviewPlugin.7
 * JD-Core Version:    0.7.0.1
 */