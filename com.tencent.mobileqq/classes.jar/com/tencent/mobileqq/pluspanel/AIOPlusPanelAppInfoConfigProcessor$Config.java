package com.tencent.mobileqq.pluspanel;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.pluspanel.C2CPlusPanelAppConfigHelper;
import com.tencent.mobileqq.activity.aio.pluspanel.PlusPanelAppInfo;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public final class AIOPlusPanelAppInfoConfigProcessor$Config
{
  private void a(String paramString)
  {
    QLog.d("AIOPlusPanelAppInfoConfigProcessor", 1, new Object[] { "Config parse configText -> ", paramString });
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject(paramString);
        int i = paramString.optInt("appid");
        PlusPanelAppInfo localPlusPanelAppInfo = C2CPlusPanelAppConfigHelper.INSTANCE.getAppInfoByAppID(i);
        if (localPlusPanelAppInfo != null)
        {
          localPlusPanelAppInfo.appid = i;
          localPlusPanelAppInfo.name = paramString.optString("title");
          localPlusPanelAppInfo.enName = paramString.optString("eng_title");
          localPlusPanelAppInfo.iconUrl = paramString.optString("iconNormal");
          localPlusPanelAppInfo.iconPress = paramString.optString("iconPress");
          localPlusPanelAppInfo.simpleDayUrl = paramString.optString("iconConciseNormal");
          localPlusPanelAppInfo.simpleDayPressUrl = paramString.optString("iconConcisePress");
          localPlusPanelAppInfo.simpleNightUrl = paramString.optString("iconConciseNightNormal");
          localPlusPanelAppInfo.simpleNightPressUrl = paramString.optString("iconConciseNightPress");
          localPlusPanelAppInfo.actionType = paramString.optString("actionType");
          localPlusPanelAppInfo.action = paramString.optString("action");
          localPlusPanelAppInfo.enableC2C = paramString.optInt("enableC2C");
          localPlusPanelAppInfo.enableGroup = paramString.optInt("enableGroup");
          return;
        }
      }
      catch (JSONException paramString)
      {
        QLog.e("AIOPlusPanelAppInfoConfigProcessor", 1, paramString, new Object[0]);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluspanel.AIOPlusPanelAppInfoConfigProcessor.Config
 * JD-Core Version:    0.7.0.1
 */