package com.tencent.vbox.util;

import android.content.Context;
import android.content.res.Resources;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileUtils
{
  private static Context mContext;
  
  public static String readTextFileFromRaw(int paramInt)
  {
    BufferedReader localBufferedReader = new BufferedReader(new InputStreamReader(mContext.getResources().openRawResource(paramInt)));
    localStringBuilder = new StringBuilder();
    try
    {
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
        localStringBuilder.append('\n');
      }
      return localStringBuilder.toString();
    }
    catch (IOException localIOException)
    {
      return null;
    }
  }
  
  public static void setContext(Context paramContext)
  {
    mContext = paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.vbox.util.FileUtils
 * JD-Core Version:    0.7.0.1
 */