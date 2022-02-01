package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class OnSmartDeviceDiscoveryCfgListener
  implements CfgProcess.OnGetConfigListener
{
  public void onGetConfig(QQAppInterface paramQQAppInterface, int paramInt, String paramString, CfgProcess.CfgParseResult paramCfgParseResult)
  {
    if ((paramCfgParseResult != null) && ("smart_devices_discovery_config".equals(paramString)))
    {
      if (QLog.isColorLevel())
      {
        paramString = new StringBuilder();
        paramString.append("handleConfigForTag smartDeviceDiscoverCfg content = ");
        paramString.append(paramCfgParseResult.a);
        QLog.d("OnSmartDeviceDiscoveryCfgListener", 2, paramString.toString());
      }
      paramInt = 1;
    }
    try
    {
      try
      {
        int i = new JSONObject(paramCfgParseResult.a).optInt("smart_device_discovery_config_switch");
        paramCfgParseResult = BaseApplication.getContext();
        paramString = new StringBuilder();
        paramInt = i;
      }
      finally
      {
        break label178;
      }
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
        paramCfgParseResult = BaseApplication.getContext();
        paramString = new StringBuilder();
      }
      paramCfgParseResult = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramQQAppInterface.getCurrentAccountUin());
      localStringBuilder.append("smart_device_discovery_config_file");
      paramCfgParseResult.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("smart_device_discovery_config_switch", 1).apply();
      throw paramString;
      return;
    }
    catch (Exception paramString)
    {
      label99:
      break label99;
    }
    paramCfgParseResult = BaseApplication.getContext();
    paramString = new StringBuilder();
    paramString.append(paramQQAppInterface.getCurrentAccountUin());
    paramString.append("smart_device_discovery_config_file");
    paramCfgParseResult.getSharedPreferences(paramString.toString(), 0).edit().putInt("smart_device_discovery_config_switch", paramInt).apply();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnSmartDeviceDiscoveryCfgListener
 * JD-Core Version:    0.7.0.1
 */