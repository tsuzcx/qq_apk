package com.tencent.pts.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

public final class PTSFileUtil
{
  public static final String FRAME_TREE_FORMAT = ".frametree";
  public static final String JS_FORMAT = ".js";
  public static final String TAG = "PTSFileUtil";
  private static HashMap<String, String> sFileContentMap = new HashMap();
  
  public static void clearCache()
  {
    PTSLog.i("PTSFileUtil", "[clearCache]");
    sFileContentMap.clear();
  }
  
  public static String getFileContent(String paramString, Context paramContext, boolean paramBoolean)
  {
    if ((PTSLog.isColorLevel()) || (PTSLog.isDebug())) {
      PTSLog.i("PTSFileUtil", "[getFileContent], filePath = " + paramString + ", useAssets = " + paramBoolean);
    }
    String str = "";
    if (TextUtils.isEmpty(paramString))
    {
      PTSLog.i("PTSFileUtil", "[getFileContent] filePath is empty.");
      paramString = str;
      return paramString;
    }
    str = (String)sFileContentMap.get(paramString);
    if (TextUtils.isEmpty(str)) {
      paramContext = loadFile(paramString, paramContext, paramBoolean);
    }
    for (;;)
    {
      paramString = paramContext;
      if (!TextUtils.isEmpty(paramContext)) {
        break;
      }
      PTSLog.e("PTSFileUtil", "[getFileContent] res is empty.");
      return paramContext;
      if (!PTSLog.isColorLevel())
      {
        paramContext = str;
        if (!PTSLog.isDebug()) {}
      }
      else
      {
        PTSLog.i("PTSFileUtil", "[getFileContent] hit cache, key = " + paramString);
        paramContext = str;
      }
    }
  }
  
  public static String getFilePath(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      paramString1 = "";
    }
    do
    {
      return paramString1;
      paramString3 = paramString1 + File.separator + paramString1 + paramString3;
      paramString1 = paramString3;
    } while (TextUtils.isEmpty(paramString2));
    if (paramString2.endsWith(File.separator)) {
      return paramString2 + paramString3;
    }
    return paramString2 + File.separator + paramString3;
  }
  
  public static boolean isFileInMap(String paramString)
  {
    boolean bool;
    if (!TextUtils.isEmpty(paramString)) {
      if (!TextUtils.isEmpty((CharSequence)sFileContentMap.get(paramString))) {
        bool = true;
      }
    }
    for (;;)
    {
      if ((PTSLog.isColorLevel()) || (PTSLog.isDebug())) {
        PTSLog.i("PTSFileUtil", "[isFileInMap], filePath= " + paramString + ", isExist = " + bool);
      }
      return bool;
      bool = false;
      continue;
      bool = false;
    }
  }
  
  public static String loadFile(String paramString, Context paramContext, boolean paramBoolean)
  {
    String str = "";
    if (TextUtils.isEmpty(paramString))
    {
      PTSLog.i("PTSFileUtil", "[loadFile] filePath is empty.");
      return "";
    }
    if (paramBoolean) {
      if (paramContext == null) {
        break label310;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open(paramString);
        localObject = new byte[paramContext.available()];
        paramContext.read((byte[])localObject);
        paramContext.close();
        paramContext = new String((byte[])localObject);
        if (!TextUtils.isEmpty(paramContext)) {
          break label275;
        }
        PTSLog.e("PTSFileUtil", "[loadFile] res is empty, filePath = " + paramString);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        PTSLog.e("PTSFileUtil", "loadFile exception, e = " + paramContext);
        paramContext = str;
        continue;
      }
      PTSLog.i("PTSFileUtil", "[loadFile], filePath = " + paramString);
      Object localObject = new File(paramString);
      paramContext = str;
      try
      {
        if (!((File)localObject).exists()) {
          continue;
        }
        paramContext = new FileInputStream((File)localObject);
        localObject = new byte[paramContext.available()];
        paramContext.read((byte[])localObject);
        paramContext.close();
        paramContext = new String((byte[])localObject);
      }
      catch (IOException paramContext)
      {
        PTSLog.e("PTSFileUtil", "[loadFile], e = " + paramContext);
        paramContext = str;
      }
      catch (Throwable paramContext)
      {
        PTSLog.e("PTSFileUtil", "[loadFile], t = " + paramContext);
        paramContext = str;
      }
      continue;
      label275:
      PTSLog.i("PTSFileUtil", "[loadFile] succeed, filePath = " + paramString);
      sFileContentMap.put(paramString, paramContext);
      return paramContext;
      label310:
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.pts.utils.PTSFileUtil
 * JD-Core Version:    0.7.0.1
 */