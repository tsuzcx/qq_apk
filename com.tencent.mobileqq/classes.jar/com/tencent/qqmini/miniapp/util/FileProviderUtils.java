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
  public static String sAuthority = null;
  public static Boolean sIsTargetThanN = null;
  
  private static Uri getUriForFile24(Context paramContext, File paramFile)
  {
    if (sAuthority == null) {
      sAuthority = paramContext.getApplicationContext().getPackageName() + ".fileprovider";
    }
    return FileProvider.getUriForFile(paramContext, sAuthority, paramFile);
  }
  
  public static boolean isTargetBeyondN(Context paramContext)
  {
    if (sIsTargetThanN == null) {
      if ((Build.VERSION.SDK_INT < 24) || (paramContext.getApplicationContext().getApplicationInfo().targetSdkVersion < 24)) {
        break label45;
      }
    }
    label45:
    for (boolean bool = true;; bool = false)
    {
      sIsTargetThanN = Boolean.valueOf(bool);
      return sIsTargetThanN.booleanValue();
    }
  }
  
  public static Uri setSystemCapture(Context paramContext, File paramFile, Intent paramIntent)
  {
    paramIntent.setAction("android.media.action.IMAGE_CAPTURE");
    if (isTargetBeyondN(paramContext))
    {
      paramContext = getUriForFile24(paramContext, paramFile);
      paramIntent.addFlags(3);
    }
    for (;;)
    {
      paramIntent.putExtra("output", paramContext);
      paramIntent.putExtra("android.intent.extra.videoQuality", 100);
      return paramContext;
      paramContext = Uri.fromFile(paramFile);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.util.FileProviderUtils
 * JD-Core Version:    0.7.0.1
 */