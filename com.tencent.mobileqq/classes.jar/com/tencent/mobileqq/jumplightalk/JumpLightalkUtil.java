package com.tencent.mobileqq.jumplightalk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.mobileqq.activity.QQBrowserActivity;

public class JumpLightalkUtil
{
  public static String a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(String.format("tencentlightalk://local/call?phone_num=%s&app_id=%s&package_name=%s", new Object[] { paramString1, paramString2, paramString3 }));
    if (!TextUtils.isEmpty(paramString4)) {
      localStringBuilder.append(String.format("&app_name=%s", new Object[] { paramString4 }));
    }
    if (!TextUtils.isEmpty(paramString5)) {
      localStringBuilder.append(String.format("&call_type=%s", new Object[] { paramString5 }));
    }
    if (!TextUtils.isEmpty(paramString6)) {
      localStringBuilder.append(String.format("&need_back=%s", new Object[] { paramString6 }));
    }
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, String paramString)
  {
    Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
    if ((paramString != null) && (!"".equals(paramString))) {
      localIntent.putExtra("url", paramString);
    }
    for (;;)
    {
      paramContext.startActivity(localIntent);
      return;
      localIntent.putExtra("url", "laidian.qq.com");
    }
  }
  
  public static void a(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6)
  {
    try
    {
      Intent localIntent = new Intent();
      localIntent.setData(Uri.parse(a(paramString1, paramString2, paramString3, paramString4, paramString5, paramString6)));
      paramContext.startActivity(localIntent);
      return;
    }
    catch (Exception paramString1)
    {
      Toast.makeText(paramContext, "buildJumpLightalkScheme is failed! " + paramString1.toString(), 1).show();
    }
  }
  
  public static boolean a(Context paramContext)
  {
    try
    {
      paramContext.getPackageManager().getApplicationInfo("com.tencent.lightalk", 8192);
      return true;
    }
    catch (PackageManager.NameNotFoundException paramContext) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.jumplightalk.JumpLightalkUtil
 * JD-Core Version:    0.7.0.1
 */