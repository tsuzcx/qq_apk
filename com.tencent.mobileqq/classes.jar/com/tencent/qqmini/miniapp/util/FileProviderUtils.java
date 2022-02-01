package com.tencent.qqmini.miniapp.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.net.Uri;
import android.os.Build.VERSION;
import android.support.v4.content.FileProvider;
import java.io.File;

public class FileProviderUtils
{
  public static String sAuthority;
  public static Boolean sIsTargetThanN;
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getApplicationContext().getPackageName());
      localStringBuilder.append(".fileprovider");
      sAuthority = localStringBuilder.toString();
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null)
    {
      boolean bool;
      if ((Build.VERSION.SDK_INT >= 24) && (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion >= 24)) {
        bool = true;
      } else {
        bool = false;
      }
      sIsTargetThanN = Boolean.valueOf(bool);
    }
    return sIsTargetThanN.booleanValue();
  }
  
  public static Uri setSystemCapture(Context paramContext, File paramFile, Intent paramIntent)
  {
    paramIntent.setAction("android.media.action.IMAGE_CAPTURE");
    if (isTargetBeyondN(paramContext))
    {
      paramContext = getUriForFile24(paramContext, paramFile);
      paramIntent.addFlags(3);
    }
    else
    {
      paramContext = Uri.fromFile(paramFile);
    }
    paramIntent.putExtra("output", paramContext);
    paramIntent.putExtra("android.intent.extra.videoQuality", 100);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.FileProviderUtils
 * JD-Core Version:    0.7.0.1
 */