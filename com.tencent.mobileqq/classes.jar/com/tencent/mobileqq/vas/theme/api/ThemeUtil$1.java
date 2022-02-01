package com.tencent.mobileqq.vas.theme.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

final class ThemeUtil$1
  extends BroadcastReceiver
{
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str2 = paramIntent.getStringExtra("themePath");
    String str3 = paramIntent.getStringExtra("themeId");
    String str1 = paramIntent.getStringExtra("bg3D");
    String str4 = paramIntent.getStringExtra("aio");
    String str5 = paramIntent.getStringExtra("playerSkin");
    if ((TextUtils.isEmpty(str2)) && (TextUtils.isEmpty(str3)))
    {
      if (!TextUtils.isEmpty(str1))
      {
        paramIntent = (AppRuntime)ThemeUtil.weakApp.get();
        if (paramIntent != null) {
          ThemeUtil.access$000(paramContext, paramIntent, paramIntent.getAccount(), str1);
        }
      }
      else
      {
        if (!TextUtils.isEmpty(str4))
        {
          ThemeUtil.previewAIOTheme(paramContext, str4);
          return;
        }
        if (!TextUtils.isEmpty(str5))
        {
          ThemeUtil.previewPlayerSkin(paramContext, str5);
          return;
        }
        ThemeUtil.themeFont(paramIntent, "themeFont");
      }
    }
    else {
      ThemeUtil.validLocalTheme(paramContext, str2, str3);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil.1
 * JD-Core Version:    0.7.0.1
 */