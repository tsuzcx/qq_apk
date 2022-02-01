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
  
  public static String getOfflineDirPath(Context paramContext)
  {
    String str2 = getCacheFilePath();
    String str1 = str2;
    if (str2 == null) {
      str1 = getSDCardPath(paramContext);
    }
    checkFileExit(str1);
    paramContext = new StringBuilder();
    paramContext.append("getOffPath:");
    paramContext.append(str1);
    LightLogUtil.i("Offline", paramContext.toString());
    return str1;
  }
  
  public static String getSDCardPath(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getExternalFilesDir(null);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getAbsolutePath());
      localStringBuilder.append(File.separator);
      localStringBuilder.append(OFFELINE_DIR);
      paramContext = localStringBuilder.toString();
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramContext.printStackTrace();
      paramContext = new StringBuilder();
      paramContext.append("/sdcard");
      paramContext.append(File.separator);
      paramContext.append(OFFELINE_DIR);
    }
    return paramContext.toString();
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
    LightLogUtil.e("FileOfflineUtil", "IOException");
    return null;
    LightLogUtil.e("FileOfflineUtil", "UnsupportedEncodingException");
    return null;
    LightLogUtil.e("FileOfflineUtil", "FileNotFoundException");
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
      LightLogUtil.e("FileOfflineUtil", ((StringBuilder)localObject).toString());
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
    LightLogUtil.e("FileOfflineUtil", "FileNotFoundException");
    return null;
  }
  
  public static String readStringFromAssets(Context paramContext, String paramString)
  {
    try
    {
      paramContext = getStringFromStream(paramContext.getAssets().open(paramString));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      paramString = new StringBuilder();
      paramString.append("getStringFromAssets|Exception:");
      paramString.append(paramContext.getMessage());
      LightLogUtil.e("FileOfflineUtil", paramString.toString());
      return null;
      LightLogUtil.e("FileOfflineUtil", "getStringFromAssets|IOException");
      return null;
      LightLogUtil.e("FileOfflineUtil", "getStringFromAssets|FileNotFoundException");
      return null;
    }
    catch (FileNotFoundException paramContext)
    {
      break label59;
    }
    catch (IOException paramContext)
    {
      label50:
      label59:
      break label50;
    }
  }
  
  public static void setCachePath(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("cachePath:");
    localStringBuilder.append(paramString);
    LightLogUtil.i("Offline", localStringBuilder.toString());
    sCachePath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.light.device.FileOfflineUtil
 * JD-Core Version:    0.7.0.1
 */