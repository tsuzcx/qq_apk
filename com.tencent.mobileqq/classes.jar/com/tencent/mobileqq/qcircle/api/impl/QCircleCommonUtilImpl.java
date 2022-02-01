package com.tencent.mobileqq.qcircle.api.impl;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.qcircle.api.IQCircleCommonUtil;
import cooperation.qqcircle.utils.QCircleCommonUtil;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class QCircleCommonUtilImpl
  implements IQCircleCommonUtil
{
  public String KEY_GPS_INFO()
  {
    return "key_gps_info";
  }
  
  public String KEY_PARSE_DATA_ERROR_MSG()
  {
    return "key_parse_data_error_msg";
  }
  
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
      if (!TextUtils.isEmpty((CharSequence)localObject)) {
        return " " + (String)localObject;
      }
    }
    return "";
  }
  
  public boolean isInNightMode()
  {
    return QCircleCommonUtil.isInNightMode();
  }
  
  public Bundle jsonToLabel(Bundle paramBundle, String paramString)
  {
    return QCircleCommonUtil.jsonToLabel(paramBundle, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.impl.QCircleCommonUtilImpl
 * JD-Core Version:    0.7.0.1
 */