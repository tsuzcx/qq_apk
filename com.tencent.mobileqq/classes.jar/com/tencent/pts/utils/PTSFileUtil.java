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
  public static final String TAG = "PTSFileUtil";
  private static HashMap<String, String> sFileContentMap = new HashMap();
  
  public static void clearCache()
  {
    PTSLog.i("PTSFileUtil", "[clearCache]");
    sFileContentMap.clear();
  }
  
  public static String getFileContent(String paramString1, String paramString2, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString2)) {}
    for (String str1 = paramString1; TextUtils.isEmpty(str1); str1 = paramString2 + "/" + paramString1)
    {
      PTSLog.i("PTSFileUtil", "[getFileContent] fullFileName is empty.");
      paramString2 = "";
      return paramString2;
    }
    String str2 = (String)sFileContentMap.get(str1);
    if (TextUtils.isEmpty(str2)) {}
    for (paramString1 = loadFile(paramString1, paramString2, paramContext);; paramString1 = str2)
    {
      paramString2 = paramString1;
      if (!TextUtils.isEmpty(paramString1)) {
        break;
      }
      PTSLog.e("PTSFileUtil", "[getFileContent] res is empty.");
      return paramString1;
      PTSLog.i("PTSFileUtil", "[getFileContent] hit cache, key = " + str1);
    }
  }
  
  public static String loadFile(String paramString1, String paramString2, Context paramContext)
  {
    String str2 = "";
    if (TextUtils.isEmpty(paramString2)) {}
    for (String str1 = paramString1; TextUtils.isEmpty(str1); str1 = paramString2 + "/" + paramString1)
    {
      PTSLog.i("PTSFileUtil", "[loadFile] fullFileName is empty.");
      return "";
    }
    if (TextUtils.isEmpty(paramString2)) {
      if (paramContext == null) {
        break label339;
      }
    }
    for (;;)
    {
      try
      {
        paramContext = paramContext.getAssets().open(paramString1);
        localObject = new byte[paramContext.available()];
        paramContext.read((byte[])localObject);
        paramContext.close();
        paramContext = new String((byte[])localObject);
        if (!TextUtils.isEmpty(paramContext)) {
          break label328;
        }
        PTSLog.e("PTSFileUtil", "[loadFile] res is empty, fileName = " + paramString1 + ", appPath = " + paramString2);
        return paramContext;
      }
      catch (IOException paramContext)
      {
        PTSLog.e("PTSFileUtil", "loadFile exception, e = " + paramContext);
        paramContext = str2;
        continue;
      }
      PTSLog.i("PTSFileUtil", "[loadFile], fullFileName = " + str1);
      Object localObject = new File(str1);
      paramContext = str2;
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
        paramContext = str2;
      }
      catch (Throwable paramContext)
      {
        PTSLog.e("PTSFileUtil", "[loadFile], t = " + paramContext);
        paramContext = str2;
      }
      continue;
      label328:
      sFileContentMap.put(str1, paramContext);
      return paramContext;
      label339:
      paramContext = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.pts.utils.PTSFileUtil
 * JD-Core Version:    0.7.0.1
 */