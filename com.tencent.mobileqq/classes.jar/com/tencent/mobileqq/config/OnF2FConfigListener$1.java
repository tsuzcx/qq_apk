package com.tencent.mobileqq.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import org.json.JSONException;
import org.json.JSONObject;

class OnF2FConfigListener$1
  implements Runnable
{
  OnF2FConfigListener$1(OnF2FConfigListener paramOnF2FConfigListener, CfgProcess.CfgParseResult paramCfgParseResult, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    try
    {
      Object localObject = new JSONObject(this.a.d);
      int i = ((JSONObject)localObject).optInt("face2faceSwitchOn");
      localObject = ((JSONObject)localObject).optString("face2faceTip");
      BaseApplication localBaseApplication = BaseApplication.getContext();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.b.getCurrentAccountUin());
      localStringBuilder.append("qqsettingme_f2f_guide");
      localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit().putInt("qqsettingme_f2f_guide_switch", i).putString("qqsettingme_f2f_guide_tip", (String)localObject).apply();
      return;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
      return;
    }
    catch (Exception localException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.OnF2FConfigListener.1
 * JD-Core Version:    0.7.0.1
 */