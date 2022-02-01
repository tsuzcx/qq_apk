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
    if ((!TextUtils.isEmpty(str2)) || (!TextUtils.isEmpty(str3))) {
      ThemeUtil.a(paramContext, str2, str3);
    }
    do
    {
      do
      {
        return;
        if (TextUtils.isEmpty(str1)) {
          break;
        }
        paramIntent = (AppRuntime)ThemeUtil.a.get();
      } while (paramIntent == null);
      ThemeUtil.a(paramContext, paramIntent, paramIntent.getAccount(), str1);
      return;
      if (!TextUtils.isEmpty(str4))
      {
        ThemeUtil.b(paramContext, str4);
        return;
      }
      if (!TextUtils.isEmpty(str5))
      {
        ThemeUtil.a(paramContext, str5);
        return;
      }
    } while (!ThemeUtil.a(paramIntent, "themeFont"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.theme.api.ThemeUtil.1
 * JD-Core Version:    0.7.0.1
 */