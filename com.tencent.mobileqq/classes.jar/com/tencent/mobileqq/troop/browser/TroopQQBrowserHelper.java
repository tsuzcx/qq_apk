package com.tencent.mobileqq.troop.browser;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class TroopQQBrowserHelper
{
  public static void a(Context paramContext, Bundle paramBundle, String paramString)
  {
    if (paramContext != null)
    {
      if (paramBundle == null) {
        return;
      }
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtras(paramBundle);
      localIntent.putExtra("url", paramString);
      localIntent.putExtra("isShowAd", false);
      paramContext.startActivity(localIntent);
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null) {
      return;
    }
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    localIntent.putExtra("url", paramString1);
    localIntent.putExtra("uin", paramString2);
    localIntent.putExtra("portraitOnly", true);
    localIntent.putExtra("hide_more_button", true);
    localIntent.putExtra("hide_operation_bar", false);
    localIntent.putExtra("isShowAd", false);
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.browser.TroopQQBrowserHelper
 * JD-Core Version:    0.7.0.1
 */