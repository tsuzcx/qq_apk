package com.tencent.rmonitor.base.config.impl;

import android.content.SharedPreferences;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AsyncSPEditor;
import org.json.JSONException;
import org.json.JSONObject;

class ConfigSaverImpl
  implements IConfigSaver
{
  public JSONObject a()
  {
    Object localObject = BaseInfo.sharePreference;
    if (localObject != null) {
      localObject = ((SharedPreferences)localObject).getString("rmonitor_config_data", null);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      try
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
      catch (JSONException localJSONException)
      {
        Logger.b.e(new String[] { "RMonitor_config_ConfigSaverImpl", "readConfig", localJSONException.getMessage() });
      }
    }
    return null;
  }
  
  public boolean a(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null) {
      paramJSONObject = paramJSONObject.toString();
    } else {
      paramJSONObject = null;
    }
    if (paramJSONObject != null) {
      BaseInfo.editor.a("rmonitor_config_data", paramJSONObject).b();
    }
    return paramJSONObject != null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.impl.ConfigSaverImpl
 * JD-Core Version:    0.7.0.1
 */