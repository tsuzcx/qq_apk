package com.tencent.smtt.sdk;

import android.content.Intent;
import android.net.Uri;
import android.os.Build.VERSION;
import com.tencent.smtt.utils.TbsLog;

public abstract class WebChromeClient$FileChooserParams
{
  public static final int MODE_OPEN = 0;
  public static final int MODE_OPEN_FOLDER = 2;
  public static final int MODE_OPEN_MULTIPLE = 1;
  public static final int MODE_SAVE = 3;
  
  public static Uri[] parseResult(int paramInt, Intent paramIntent)
  {
    Object localObject = null;
    try
    {
      x localx = x.a();
      if ((localx != null) && (localx.b())) {
        return localx.c().a(paramInt, paramIntent);
      }
      if (Build.VERSION.SDK_INT >= 21) {
        localObject = android.webkit.WebChromeClient.FileChooserParams.parseResult(paramInt, paramIntent);
      }
      return localObject;
    }
    catch (Exception paramIntent)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("parseResult:");
      ((StringBuilder)localObject).append(paramIntent.toString());
      TbsLog.i("WebChromeClient", ((StringBuilder)localObject).toString());
    }
    return null;
  }
  
  public abstract Intent createIntent();
  
  public abstract String[] getAcceptTypes();
  
  public abstract String getFilenameHint();
  
  public abstract int getMode();
  
  public abstract CharSequence getTitle();
  
  public abstract boolean isCaptureEnabled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
 * JD-Core Version:    0.7.0.1
 */