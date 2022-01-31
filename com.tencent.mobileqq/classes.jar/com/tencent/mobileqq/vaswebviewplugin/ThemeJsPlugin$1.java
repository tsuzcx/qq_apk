package com.tencent.mobileqq.vaswebviewplugin;

import anad;
import anah;
import android.os.Bundle;
import android.text.TextUtils;

class ThemeJsPlugin$1
  implements Runnable
{
  ThemeJsPlugin$1(ThemeJsPlugin paramThemeJsPlugin, String paramString1, int paramInt1, String paramString2, long paramLong, String paramString3, String paramString4, String paramString5, int paramInt2, int paramInt3, String paramString6, String paramString7, String paramString8) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("themeId", this.val$themeId);
    localBundle.putInt("actionResult", this.val$actionResult);
    if (!TextUtils.isEmpty(this.val$actionName))
    {
      localBundle.putString("actionName", this.val$actionName);
      localBundle.putLong("downloadTime", this.val$downloadTime);
    }
    if (!TextUtils.isEmpty(this.val$statisticKey))
    {
      localBundle.putString("statistic_key", this.val$statisticKey);
      localBundle.putString("param_FailCode", this.val$failCode);
    }
    if (!TextUtils.isEmpty(this.val$from))
    {
      localBundle.putString("from", this.val$from);
      localBundle.putInt("step", this.val$step);
      localBundle.putInt("code", this.val$code);
      localBundle.putString("version", this.val$version);
      localBundle.putString("r5", this.val$r5);
      localBundle.putString("path", this.val$path);
    }
    localBundle = anah.a("reportTheme", "", this.this$0.mOnRemoteResp.key, localBundle);
    this.this$0.sendRemoteReq(localBundle, false, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.ThemeJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */