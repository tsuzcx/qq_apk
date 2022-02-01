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
  private static final String OFFELINE_DIR;
  private static final String TAG = "FileOfflineUtil";
  private static String sCachePath;
  
  static
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("tencent");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("com.tencent.ttpic");
    localStringBuilder.append(File.separator);
    localStringBuilder.append("offlinepkg");
    OFFELINE_DIR = localStringBuilder.toString();
  }
  
  private static void checkFileExit(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {
      paramString.mkdirs();
    }
  }
  
  public static String getCacheFilePath()
  {
    Object localObject = sCachePath;
    if (localObject != null)
    {
      localObject = new File((String)localObject);
      if (((File)localObject).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        localStringBuilder.append(File.separator);
        localStringBuilder.append("offlinepkg");
        return localStringBuilder.toString();
      }
    }
    return null;
  }
  
  public static String getOfflineDirPath()
  {
    Object localObject2 = getCacheFilePath();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = getSDCardPath();
    }
    checkFileExit((String)localObject1);
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("getOffPath:");
    ((StringBuilder)localObject2).append((String)localObject1);
    LogUtils.i("Offline", ((StringBuilder)localObject2).toString());
    return localObject1;
  }
  
  public static String getSDCardPath()
  {
    try
    {
      Object localObject = AEModule.getContext().getExternalFilesDir(null);
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append(((File)localObject).getAbsolutePath());
      localStringBuilder2.append(File.separator);
      localStringBuilder2.append(OFFELINE_DIR);
      localObject = localStringBuilder2.toString();
      return localObject;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      StringBuilder localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("/sdcard");
      localStringBuilder1.append(File.separator);
      localStringBuilder1.append(OFFELINE_DIR);
      return localStringBuilder1.toString();
    }
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
      localBufferedReader.close();
      paramInputStream.close();
      paramInputStream = localStringBuilder.toString();
      return paramInputStream;
    }
    catch (FileNotFoundException paramInputStream)
    {
      break label79;
    }
    catch (UnsupportedEncodingException paramInputStream)
    {
      break label70;
    }
    catch (IOException paramInputStream)
    {
      label61:
      label70:
      label79:
      break label61;
    }
    LogUtils.e("FileOfflineUtil", "IOException");
    return null;
    LogUtils.e("FileOfflineUtil", "UnsupportedEncodingException");
    return null;
    LogUtils.e("FileOfflineUtil", "FileNotFoundException");
    return null;
  }
  
  public static String readJsonStringFromFile(String paramString)
  {
    Object localObject = new File(paramString);
    if (!((File)localObject).exists())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("file not exit:");
      ((StringBuilder)localObject).append(paramString);
      LogUtils.e("FileOfflineUtil", ((StringBuilder)localObject).toString());
      return null;
    }
    try
    {
      paramString = getStringFromStream(new FileInputStream((File)localObject));
      return paramString;
    }
    catch (FileNotFoundException paramString)
    {
      label62:
      break label62;
    }
    LogUtils.e("FileOfflineUtil", "FileNotFoundException");
    return null;
  }
  
  public static String readStringFromAssets(String paramString)
  {
    try
    {
      paramString = getStringFromStream(AEModule.getContext().getAssets().open(paramString));
      return paramString;
    }
    catch (Exception paramString)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getStringFromAssets|Exception:");
      localStringBuilder.append(paramString.getMessage());
      LogUtils.e("FileOfflineUtil", localStringBuilder.toString());
      return null;
      LogUtils.e("FileOfflineUtil", "getStringFromAssets|IOException");
      return null;
      LogUtils.e("FileOfflineUtil", "getStringFromAssets|FileNotFoundException");
      return null;
    }
    catch (FileNotFoundException paramString)
    {
      break label61;
    }
    catch (IOException paramString)
    {
      label52:
      label61:
      break label52;
    }
  }
  
  public static void setCachePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cachePath:");
    localStringBuilder.append(paramString);
    LogUtils.i("Offline", localStringBuilder.toString());
    sCachePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.ttpic.openapi.offlineset.utils.FileOfflineUtil
 * JD-Core Version:    0.7.0.1
 */