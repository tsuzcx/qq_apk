package com.tencent.mobileqq.qqpermission.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;

public class PermissionUtil
{
  public static void a(Context paramContext)
  {
    QPLog.a("PermissionUtil", "gotoSettingPage");
    Intent localIntent = new Intent();
    localIntent.addFlags(335544320);
    localIntent.setAction("android.settings.APPLICATION_DETAILS_SETTINGS");
    localIntent.setData(Uri.fromParts("package", paramContext.getPackageName(), null));
    paramContext.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqpermission.util.PermissionUtil
 * JD-Core Version:    0.7.0.1
 */