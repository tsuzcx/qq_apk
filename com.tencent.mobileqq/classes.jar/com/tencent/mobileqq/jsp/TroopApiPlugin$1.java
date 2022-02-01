package com.tencent.mobileqq.jsp;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.troop.api.ITroopMemberApiClientApi.Callback;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONObject;

class TroopApiPlugin$1
  implements ITroopMemberApiClientApi.Callback
{
  TroopApiPlugin$1(TroopApiPlugin paramTroopApiPlugin, long paramLong1, long paramLong2, String paramString) {}
  
  public void callback(Bundle paramBundle)
  {
    paramBundle = paramBundle.getString("videoPath");
    Object localObject;
    if (!TextUtils.isEmpty(paramBundle))
    {
      localObject = new File(paramBundle);
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        bool = true;
        break label44;
      }
    }
    boolean bool = false;
    label44:
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("previewRewardVideo: videoPath=");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(", ");
      ((StringBuilder)localObject).append(bool);
      QLog.d("TroopApiPlugin", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      localObject = new JSONObject();
      if (bool)
      {
        MediaApiPlugin.a(this.jdField_a_of_type_ComTencentMobileqqJspTroopApiPlugin.mRuntime.a(), paramBundle, this.jdField_a_of_type_Long, this.b);
        ((JSONObject)localObject).put("ret", 0);
        ((JSONObject)localObject).put("errMsg", "");
      }
      else
      {
        ((JSONObject)localObject).put("ret", -2);
        ((JSONObject)localObject).put("errMsg", HardCodeUtil.a(2131714966));
      }
      this.jdField_a_of_type_ComTencentMobileqqJspTroopApiPlugin.callJs(this.jdField_a_of_type_JavaLangString, new String[] { ((JSONObject)localObject).toString() });
      return;
    }
    catch (Exception paramBundle)
    {
      if (QLog.isColorLevel()) {
        QLog.w("TroopApiPlugin", 2, "previewRewardVideo exp", paramBundle);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.jsp.TroopApiPlugin.1
 * JD-Core Version:    0.7.0.1
 */