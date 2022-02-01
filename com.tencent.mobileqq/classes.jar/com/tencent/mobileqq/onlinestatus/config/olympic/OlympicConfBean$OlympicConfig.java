package com.tencent.mobileqq.onlinestatus.config.olympic;

import android.text.TextUtils;
import com.tencent.mobileqq.config.IQStorageSafable;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class OlympicConfBean$OlympicConfig
  implements IQStorageSafable<String>
{
  public String a = "";
  public String b = "";
  public HashMap<Integer, OlympicConfBean.OlympicShareConfig> c = new HashMap();
  public String d = "";
  public int e = 1;
  
  public void a(String paramString)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("OlympicConfig content: ");
      ((StringBuilder)localObject).append(paramString);
      QLog.i("OlympicConfig", 2, ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("OlympicConfig", 1, "OlympicConfig content is empty");
      return;
    }
    try
    {
      paramString = new JSONObject(paramString);
      this.a = paramString.optString("resUrl");
      this.b = paramString.optString("md5");
      this.d = paramString.getString("panel_ani");
      this.e = paramString.getInt("qr_code_switch");
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("OlympicConfig resUrl: ");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append(" md5: ");
        ((StringBuilder)localObject).append(this.b);
        ((StringBuilder)localObject).append(" panelAniUrl: ");
        ((StringBuilder)localObject).append(this.d);
        ((StringBuilder)localObject).append(" qrCodeSwitch: ");
        ((StringBuilder)localObject).append(this.e);
        QLog.i("OlympicConfig", 2, ((StringBuilder)localObject).toString());
      }
      paramString = paramString.getJSONArray("share_config");
      if (paramString != null)
      {
        int i = 0;
        while (i < paramString.length())
        {
          localObject = paramString.getJSONObject(i);
          OlympicConfBean.OlympicShareConfig localOlympicShareConfig = new OlympicConfBean.OlympicShareConfig();
          localOlympicShareConfig.a = ((JSONObject)localObject).optInt("type");
          localOlympicShareConfig.b = ((JSONObject)localObject).optString("name_color");
          localOlympicShareConfig.c = ((JSONObject)localObject).optString("rank_color");
          localOlympicShareConfig.d = ((JSONObject)localObject).optString("btn_title");
          localOlympicShareConfig.e = ((JSONObject)localObject).optString("btn_title_color");
          localOlympicShareConfig.f = ((JSONObject)localObject).optString("btn_color");
          if (QLog.isColorLevel()) {
            QLog.i("OlympicConfig", 2, localOlympicShareConfig.toString());
          }
          this.c.put(Integer.valueOf(localOlympicShareConfig.a), localOlympicShareConfig);
          i += 1;
        }
      }
      return;
    }
    catch (JSONException paramString)
    {
      QLog.e("OlympicConfig", 1, "OlympicConfig parse exception", paramString);
    }
  }
  
  public String toString()
  {
    return super.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.config.olympic.OlympicConfBean.OlympicConfig
 * JD-Core Version:    0.7.0.1
 */