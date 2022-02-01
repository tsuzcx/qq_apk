package com.tencent.ttpic.openapi.offlineset.utils;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;

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
  
  public static String getOfflineDirPath()
  {
    String str2 = getCacheFilePath();
    String str1 = str2;
    if (str2 == null) {
      str1 = getSDCardPath();
    }
    checkFileExit(str1);
    LogUtils.i("Offline", "getOffPath:" + str1);
    return str1;
  }
  
  public static String getSDCardPath()
  {
    try
    {
      Object localObject = AEModule.getContext().getExternalFilesDir(null);
      localObject = ((File)localObject).getAbsolutePath() + File.separator + OFFELINE_DIR;
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
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
      LogUtils.e("FileOfflineUtil", "FileNotFoundException");
      return null;
      localBufferedReader.close();
      paramInputStream.close();
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      LogUtils.e("FileOfflineUtil", "UnsupportedEncodingException");
      return null;
    }
    catch (IOException paramInputStream)
    {
      LogUtils.e("FileOfflineUtil", "IOException");
    }
  }
  
  public static String readJsonStringFromFile(String paramString)
  {
    File localFile = new File(paramString);
    if (!localFile.exists())
    {
      LogUtils.e("FileOfflineUtil", "file not exit:" + paramString);
      return null;
    }
    try
    {
      paramString = getStringFromStream(new FileInputStream(localFile));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      LogUtils.e("FileOfflineUtil", "FileNotFoundException");
    }
    return null;
  }
  
  public static String readStringFromAssets(String paramString)
  {
    try
    {
      paramString = getStringFromStream(AEModule.getContext().getAssets().open(paramString));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      LogUtils.e("FileOfflineUtil", "getStringFromAssets|FileNotFoundException");
      return null;
    }
    catch (IOException paramString)
    {
      LogUtils.e("FileOfflineUtil", "getStringFromAssets|IOException");
      return null;
    }
    catch (Exception paramString)
    {
      LogUtils.e("FileOfflineUtil", "getStringFromAssets|Exception:" + paramString.getMessage());
    }
    return null;
  }
  
  public static void setCachePath(String paramString)
  {
    LogUtils.i("Offline", "cachePath:" + paramString);
    sCachePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil
 * JD-Core Version:    0.7.0.1
 */