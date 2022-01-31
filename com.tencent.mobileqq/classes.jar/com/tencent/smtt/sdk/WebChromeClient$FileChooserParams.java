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
    try
    {
      X5CoreEngine localX5CoreEngine = X5CoreEngine.getInstance();
      if ((localX5CoreEngine != null) && (localX5CoreEngine.isX5Core())) {
        return localX5CoreEngine.wizard().parseFileChooserResult(paramInt, paramIntent);
      }
      if (Build.VERSION.SDK_INT >= 21)
      {
        paramIntent = android.webkit.WebChromeClient.FileChooserParams.parseResult(paramInt, paramIntent);
        return paramIntent;
      }
    }
    catch (Exception paramIntent)
    {
      TbsLog.i("WebChromeClient", "parseResult:" + paramIntent.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.smtt.sdk.WebChromeClient.FileChooserParams
 * JD-Core Version:    0.7.0.1
 */