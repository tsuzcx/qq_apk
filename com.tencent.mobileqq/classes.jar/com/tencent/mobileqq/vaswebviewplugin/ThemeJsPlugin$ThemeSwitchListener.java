package com.tencent.mobileqq.vaswebviewplugin;

import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.emosm.DataFactory;
import com.tencent.mobileqq.emosm.OnRemoteRespObserver;
import com.tencent.mobileqq.vas.aidl.ISwitchCallback.Stub;
import com.tencent.mobileqq.vas.api.IVasService;
import com.tencent.mobileqq.vas.manager.api.IThemeSwitchManager;
import com.tencent.mobileqq.vas.theme.JSONResult;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil.ThemeInfo;
import com.tencent.mobileqq.vas.util.VasUtil;
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
    VasUtil.a().getThemeSwitchManager().openSwitchDialog(this.this$0.mRuntime.a());
  }
  
  public void doSwitch(String paramString1, String paramString2)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ThemeJsPlugin.ThemeSwitchListener.1(this, paramString2, paramString1));
  }
  
  public void onProgress(long paramLong1, long paramLong2) {}
  
  public void postSwitch(int paramInt)
  {
    boolean bool = QLog.isColorLevel();
    int i = 2;
    if ((bool) || (paramInt != 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("themeSwitchListener,themeId=");
      ((StringBuilder)localObject1).append(this.themeId);
      ((StringBuilder)localObject1).append(",stateCode=");
      ((StringBuilder)localObject1).append(paramInt);
      QLog.i("ThemeJsPlugin", 2, ((StringBuilder)localObject1).toString());
    }
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("set skin theme back:");
    ((StringBuilder)localObject1).append(paramInt);
    localObject1 = ((StringBuilder)localObject1).toString();
    Object localObject2;
    if (paramInt == 0)
    {
      Object localObject3;
      if ("saveDiyTheme".equals(ThemeJsPlugin.access$000(this.this$0)))
      {
        localObject1 = this.this$0;
        localObject2 = ((ThemeJsPlugin)localObject1).mCallbackId;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append("set skin theme back:");
        ((StringBuilder)localObject3).append(paramInt);
        ((ThemeJsPlugin)localObject1).callJs((String)localObject2, new String[] { new JSONResult(0, ((StringBuilder)localObject3).toString()).a() });
        return;
      }
      if (this.needSetCurrent)
      {
        localObject2 = new Bundle();
        ((Bundle)localObject2).putString("themeId", this.themeId);
        ((Bundle)localObject2).putBoolean("needSaveSp", false);
        localObject3 = this.this$0.mThemeinfo.seriesID;
        JSONArray localJSONArray = this.this$0.mThemeinfo.themeArray;
        long l = this.this$0.mThemeinfo.startTime;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("ThemeJsHandler switchThemeTask onPostExecute themeId=");
        localStringBuilder.append(this.themeId);
        localStringBuilder.append(",seriesID");
        localStringBuilder.append((String)localObject3);
        localStringBuilder.append(",themeArray:");
        if ((localJSONArray != null) && (localJSONArray.length() > 0)) {
          bool = true;
        } else {
          bool = false;
        }
        localStringBuilder.append(bool);
        QLog.i("ThemeJsPlugin", 1, localStringBuilder.toString());
        if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (localJSONArray != null) && (localJSONArray.length() > 0))
        {
          ((Bundle)localObject2).putString("seriesID", (String)localObject3);
          ((Bundle)localObject2).putString("themeArray", localJSONArray.toString());
          ((Bundle)localObject2).putLong("startTime", l);
        }
        localObject2 = DataFactory.a("themeSwitchSucess", "", this.this$0.mOnRemoteResp.key, (Bundle)localObject2);
        this.this$0.sendRemoteReq((Bundle)localObject2, false, true);
      }
      i = 0;
    }
    else if (paramInt == 3)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ThemeJsPlugin", 2, "ThemeJsHandler return because setupping.");
      }
      localObject1 = "is switching theme";
    }
    else
    {
      i = -1;
      QLog.e("ThemeJsPlugin", 1, "themeSwitchListener ret = false");
    }
    try
    {
      this.this$0.callJs(this.this$0.mCallbackId, new String[] { new JSONResult(i, (String)localObject1).a() });
    }
    catch (Exception localException)
    {
      localObject2 = this.this$0;
      ((ThemeJsPlugin)localObject2).callJsOnError(((ThemeJsPlugin)localObject2).mCallbackId, localException.getMessage());
    }
    if (paramInt != 0) {
      VasUtil.a().getThemeSwitchManager().clearOnErr();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.ThemeSwitchListener
 * JD-Core Version:    0.7.0.1
 */