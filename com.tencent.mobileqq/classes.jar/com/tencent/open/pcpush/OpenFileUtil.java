package com.tencent.open.pcpush;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.net.Uri.Builder;
import android.webkit.MimeTypeMap;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;

public final class OpenFileUtil
{
  public static Intent a(Context paramContext, File paramFile)
  {
    if ((paramContext != null) && (paramFile != null) && (paramFile.isFile()))
    {
      String str = paramFile.getName().toLowerCase().trim();
      Intent localIntent = new Intent("android.intent.action.VIEW");
      localIntent.addFlags(268435456);
      if (a(str, paramContext.getResources().getStringArray(2130968627)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "image/*");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968633)))
      {
        localIntent.setDataAndType(Uri.parse(paramFile.toString()).buildUpon().encodedAuthority("com.android.htmlfileprovider").scheme("content").encodedPath(paramFile.toString()).build(), "text/html");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968624)))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("oneshot", 0);
        localIntent.putExtra("configchange", 0);
        localIntent.setDataAndType(Uri.fromFile(paramFile), "audio/*");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968632)))
      {
        localIntent.addFlags(67108864);
        localIntent.putExtra("oneshot", 0);
        localIntent.putExtra("configchange", 0);
        localIntent.setDataAndType(Uri.fromFile(paramFile), "video/*");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968631)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "text/plain");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968630)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/pdf");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968634)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/msword");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968626)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-excel");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968628)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/vnd.ms-powerpoint");
      }
      else if (a(str, paramContext.getResources().getStringArray(2130968625)))
      {
        localIntent.setDataAndType(Uri.fromFile(paramFile), "application/x-chm");
      }
      else
      {
        str = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str.substring(str.lastIndexOf(".") + 1).toLowerCase().trim());
        localIntent.setDataAndType(Uri.fromFile(paramFile), str);
      }
      FileProvider7Helper.intentCompatForN(paramContext, localIntent);
      return localIntent;
    }
    return null;
  }
  
  public static boolean a(String paramString, String[] paramArrayOfString)
  {
    int j = paramArrayOfString.length;
    int i = 0;
    while (i < j)
    {
      if (paramString.endsWith(paramArrayOfString[i])) {
        return true;
      }
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.open.pcpush.OpenFileUtil
 * JD-Core Version:    0.7.0.1
 */