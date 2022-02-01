package org.light.device;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import org.light.utils.LightLogUtil;

public class FileOfflineUtil
{
  private static final String DIR_NAME = "offlinepkg";
  private static final String OFFELINE_DIR = "tencent" + File.separator + "com.tencent.ttpic" + File.separator + "offlinepkg";
  private static final String TAG = "FileOfflineUtil";
  private static String sCachePath;
  
  private static void checkFileExit(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public static String getCacheFilePath()
  {
    if (sCachePath != null)
    {
      File localFile = new File(sCachePath);
      if (localFile.exists()) {
        return localFile.getAbsolutePath() + File.separator + "offlinepkg";
      }
    }
    return null;
  }
  
  public static String getOfflineDirPath(Context paramContext)
  {
    String str2 = getCacheFilePath();
    String str1 = str2;
    if (str2 == null) {
      str1 = getSDCardPath(paramContext);
    }
    checkFileExit(str1);
    LightLogUtil.i("Offline", "getOffPath:" + str1);
    return str1;
  }
  
  public static String getSDCardPath(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getExternalFilesDir(null);
      paramContext = paramContext.getAbsolutePath() + File.separator + OFFELINE_DIR;
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
    }
    return "/sdcard" + File.separator + OFFELINE_DIR;
  }
  
  public static String getStringFromStream(InputStream paramInputStream)
  {
    try
    {
      paramInputStream = new InputStreamReader(paramInputStream, "UTF-8");
      BufferedReader localBufferedReader = new BufferedReader(paramInputStream);
      StringBuilder localStringBuilder = new StringBuilder();
      for (;;)
      {
        String str = localBufferedReader.readLine();
        if (str == null) {
          break;
        }
        localStringBuilder.append(str);
      }
      return null;
    }
    catch (FileNotFoundException paramInputStream)
    {
      LightLogUtil.e("FileOfflineUtil", "FileNotFoundException");
      return null;
      localBufferedReader.close();
      paramInputStream.close();
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      LightLogUtil.e("FileOfflineUtil", "UnsupportedEncodingException");
      return null;
    }
    catch (IOException paramInputStream)
    {
      LightLogUtil.e("FileOfflineUtil", "IOException");
    }
  }
  
  public static String readJsonStringFromFile(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      LightLogUtil.e("FileOfflineUtil", "file not exit:" + paramString);
      return null;
    }
    try
    {
      paramString = getStringFromStream(new FileInputStream(localFile));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      LightLogUtil.e("FileOfflineUtil", "FileNotFoundException");
    }
    return null;
  }
  
  public static String readStringFromAssets(Context paramContext, String paramString)
  {
    try
    {
      paramContext = getStringFromStream(paramContext.getAssets().open(paramString));
      return paramContext;
    }
    catch (FileNotFoundException paramContext)
    {
      LightLogUtil.e("FileOfflineUtil", "getStringFromAssets|FileNotFoundException");
      return null;
    }
    catch (IOException paramContext)
    {
      LightLogUtil.e("FileOfflineUtil", "getStringFromAssets|IOException");
      return null;
    }
    catch (Exception paramContext)
    {
      LightLogUtil.e("FileOfflineUtil", "getStringFromAssets|Exception:" + paramContext.getMessage());
    }
    return null;
  }
  
  public static void setCachePath(String paramString)
  {
    LightLogUtil.i("Offline", "cachePath:" + paramString);
    sCachePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     org.light.device.FileOfflineUtil
 * JD-Core Version:    0.7.0.1
 */