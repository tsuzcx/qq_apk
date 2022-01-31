package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.emosm.Client.onRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeSwitchManager.ThemeSwitchListener;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import org.json.JSONArray;
import org.json.JSONObject;

class ThemeJsPlugin$2
  implements ThemeSwitchManager.ThemeSwitchListener
{
  ThemeJsPlugin$2(ThemeJsPlugin paramThemeJsPlugin) {}
  
  public void onSwitchCallback(int paramInt, String paramString1, String paramString2)
  {
    int j = 0;
    this.this$0.mThemeSwitchManager.a(this, false, true);
    if ((QLog.isColorLevel()) || (paramInt < 0)) {
      QLog.i("ThemeJsPlugin", 2, "themeSwitchListener,themeId=" + paramString1 + ",stateCode=" + paramInt);
    }
    Bundle localBundle;
    Object localObject;
    if (paramInt > 0)
    {
      localBundle = new Bundle();
      localBundle.putString("themeId", paramString1);
      localBundle.putString("version", paramString2);
      localBundle.putBoolean("needSaveSp", false);
      if (paramString1.equals("1000")) {
        localObject = null;
      }
    }
    for (;;)
    {
      int i;
      label117:
      boolean bool;
      label231:
      int k;
      if (localObject == null)
      {
        i = 0;
        String str = this.this$0.mThemeinfo.seriesID;
        JSONArray localJSONArray = this.this$0.mThemeinfo.themeArray;
        long l = this.this$0.mThemeinfo.startTime;
        localObject = new StringBuilder().append("ThemeJsHandler switchThemeTask onPostExecute fileNum:").append(i).append(", themeResPath:").append((String)localObject).append(",themeId").append(paramString1).append(",version:").append(paramString2).append(",seriesID").append(str).append(",themeArray:");
        if ((localJSONArray == null) || (localJSONArray.length() <= 0)) {
          break label589;
        }
        bool = true;
        QLog.i("ThemeJsPlugin", 1, bool);
        if ((!TextUtils.isEmpty(str)) && (localJSONArray != null) && (localJSONArray.length() > 0))
        {
          localBundle.putString("seriesID", str);
          localBundle.putString("themeArray", localJSONArray.toString());
          localBundle.putLong("startTime", l);
        }
        localObject = DataFactory.a("themeSwitchSucess", "", this.this$0.mOnRemoteResp.key, localBundle);
        this.this$0.sendRemoteReq((Bundle)localObject, false, true);
        k = ThemeUtil.getErrorThemeId(this.this$0.context, paramString1);
        i = j;
        if (k > 0) {
          QLog.i("ThemeJsPlugin", 1, "ThemeJsHandler switchThemeTask onPostExecute errTime > 0:,themeId" + paramString1 + ",version:" + paramString2 + ",errTime" + k);
        }
      }
      try
      {
        Thread.sleep(300L);
        label402:
        if (k / 100000 == Integer.parseInt("3")) {
          ThemeUtil.setErrorThemeId(this.this$0.context, paramString1, true);
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("themeId", paramString1);
        ((Bundle)localObject).putString("version", paramString2);
        paramString1 = DataFactory.a("authTheme", "", this.this$0.mOnRemoteResp.key, (Bundle)localObject);
        this.this$0.sendRemoteReq(paramString1, false, true);
        i = j;
        for (;;)
        {
          try
          {
            paramString1 = new JSONObject();
            paramString1.put("result", i);
            paramString1.put("message", "set skin theme back:" + paramInt);
            this.this$0.callJs(this.this$0.mCallbackId, new String[] { paramString1.toString() });
            return;
          }
          catch (Exception paramString1)
          {
            label589:
            this.this$0.callJsOnError(this.this$0.mCallbackId, paramString1.getMessage());
            return;
          }
          localObject = ThemeUtil.getThemeResourcePath(this.this$0.context, paramString1, paramString2);
          break;
          i = ThemeUtil.getFileNumInFile(new File((String)localObject));
          break label117;
          bool = false;
          break label231;
          i = -1;
          QLog.e("ThemeJsPlugin", 1, "themeSwitchListener ret = false");
        }
      }
      catch (Exception localException)
      {
        break label402;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.2
 * JD-Core Version:    0.7.0.1
 */