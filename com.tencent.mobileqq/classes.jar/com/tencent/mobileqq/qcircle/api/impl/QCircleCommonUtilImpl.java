package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QCircleCommonUtilImpl
  implements IQCircleCommonUtil
{
  public static final String TAG = "QCircleCommonUtilImpl";
  
  public int getColorFromJSON(JSONObject paramJSONObject, String paramString)
  {
    return QCircleCommonUtil.getColorFromJSON(paramJSONObject, paramString);
  }
  
  public int getDefaultThemeColor(boolean paramBoolean)
  {
    return QCircleCommonUtil.getDefaultThemeColor(paramBoolean);
  }
  
  public String getQCirclePluginInfo()
  {
    Object localObject = MobileQQ.sMobileQQ.getSharedPreferences("QCirclePluginVersion", 4);
    if (((SharedPreferences)localObject).contains("version"))
    {
      localObject = ((SharedPreferences)localObject).getString("version", "");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getQCirclePluginInfo:");
        localStringBuilder.append((String)localObject);
        QLog.d("QCircleCommonUtilImpl", 1, localStringBuilder.toString());
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(" ");
        localStringBuilder.append((String)localObject);
        return localStringBuilder.toString();
      }
    }
    return "";
  }
  
  public long getSystemTotalMemory()
  {
    return DeviceInfoUtil.a();
  }
  
  public boolean isInNightMode()
  {
    return QCircleCommonUtil.isInNightMode();
  }
  
  public Bundle jsonToLabel(Bundle paramBundle, String paramString)
  {
    return QCircleCommonUtil.jsonToLabel(paramBundle, paramString);
  }
  
  public String keyGpsInfo()
  {
    return "key_gps_info";
  }
  
  public String keyParseDataErrorMsg()
  {
    return "key_parse_data_error_msg";
  }
  
  public String labelToJson(Bundle paramBundle)
  {
    return QCircleCommonUtil.labelToJson(paramBundle);
  }
  
  public void setStatusBarColor(Activity paramActivity, int paramInt)
  {
    QCircleCommonUtil.setStatusBarColor(paramActivity, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleCommonUtilImpl
 * JD-Core Version:    0.7.0.1
 */