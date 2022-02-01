package com.tencent.mobileqq.vas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mobileqq.activity.QQTranslucentBrowserActivity;
import com.tencent.qphone.base.util.QLog;

public class BrowserUtils
{
  public static boolean a(Context paramContext, String paramString)
  {
    try
    {
      Intent localIntent = new Intent(paramContext, QQTranslucentBrowserActivity.class);
      localIntent.putExtra("url", paramString);
      localIntent.setData(Uri.parse(paramString));
      localIntent.putExtra("flag_show_loading_dialog", true);
      localIntent.putExtra("hide_left_button", true);
      paramContext.startActivity(localIntent);
      return true;
    }
    catch (Exception paramContext)
    {
      QLog.e("BrowserUtils", 2, paramContext, new Object[0]);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.BrowserUtils
 * JD-Core Version:    0.7.0.1
 */