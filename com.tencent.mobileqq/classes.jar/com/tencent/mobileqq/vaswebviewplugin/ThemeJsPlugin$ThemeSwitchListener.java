package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.Client.OnRemoteRespObserver;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.theme.ISwitchCallback.Stub;
import com.tencent.mobileqq.theme.JSONResult;
import com.tencent.mobileqq.theme.ThemeSwitchManager;
import com.tencent.mobileqq.theme.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.PluginRuntime;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;

class ThemeJsPlugin$ThemeSwitchListener
  extends ISwitchCallback.Stub
{
  private boolean needSetCurrent;
  private String themeId;
  
  public ThemeJsPlugin$ThemeSwitchListener(ThemeJsPlugin paramThemeJsPlugin, String paramString, boolean paramBoolean)
  {
    this.themeId = paramString;
    this.needSetCurrent = paramBoolean;
  }
  
  public void beginSwitch()
  {
    this.this$0.mThemeSwitchManager.a(this.this$0.mRuntime.a());
  }
  
  public void doSwitch(String paramString1, String paramString2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ThemeJsPlugin.ThemeSwitchListener.1(this, paramString2, paramString1));
  }
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public void postSwitch(int paramInt)
  {
    int i = 0;
    int j = 0;
    if ((QLog.isColorLevel()) || (paramInt != 0)) {
      QLog.i("ThemeJsPlugin", 2, "themeSwitchListener,themeId=" + this.themeId + ",stateCode=" + paramInt);
    }
    String str1 = "set skin theme back:" + paramInt;
    if (paramInt == 0) {
      if ("saveDiyTheme".equals(ThemeJsPlugin.access$000(this.this$0))) {
        this.this$0.callJs(this.this$0.mCallbackId, new String[] { new JSONResult(0, "set skin theme back:" + paramInt).a() });
      }
    }
    for (;;)
    {
      return;
      boolean bool;
      if (this.needSetCurrent)
      {
        Bundle localBundle = new Bundle();
        localBundle.putString("themeId", this.themeId);
        localBundle.putBoolean("needSaveSp", false);
        String str2 = this.this$0.mThemeinfo.seriesID;
        JSONArray localJSONArray = this.this$0.mThemeinfo.themeArray;
        long l = this.this$0.mThemeinfo.startTime;
        StringBuilder localStringBuilder = new StringBuilder().append("ThemeJsHandler switchThemeTask onPostExecute themeId=").append(this.themeId).append(",seriesID").append(str2).append(",themeArray:");
        if ((localJSONArray != null) && (localJSONArray.length() > 0))
        {
          bool = true;
          label266:
          QLog.i("ThemeJsPlugin", 1, bool);
          if ((!TextUtils.isEmpty(str2)) && (localJSONArray != null) && (localJSONArray.length() > 0))
          {
            localBundle.putString("seriesID", str2);
            localBundle.putString("themeArray", localJSONArray.toString());
            localBundle.putLong("startTime", l);
          }
          localBundle = DataFactory.a("themeSwitchSucess", "", this.this$0.mOnRemoteResp.key, localBundle);
          this.this$0.sendRemoteReq(localBundle, false, true);
          i = j;
        }
      }
      try
      {
        for (;;)
        {
          this.this$0.callJs(this.this$0.mCallbackId, new String[] { new JSONResult(i, str1).a() });
          if (paramInt == 0) {
            break;
          }
          this.this$0.mThemeSwitchManager.b();
          return;
          bool = false;
          break label266;
          if (paramInt == 3)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler return because setupping.");
            }
            i = 2;
            str1 = "is switching theme";
          }
          else
          {
            i = -1;
            QLog.e("ThemeJsPlugin", 1, "themeSwitchListener ret = false");
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          this.this$0.callJsOnError(this.this$0.mCallbackId, localException.getMessage());
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.ThemeSwitchListener
 * JD-Core Version:    0.7.0.1
 */