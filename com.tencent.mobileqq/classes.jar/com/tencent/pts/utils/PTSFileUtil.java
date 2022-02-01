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
    if ((PTSLog.isColorLevel()) || (PTSLog.isDebug()))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[getFileContent], filePath = ");
      ((StringBuilder)localObject).append(paramString);
      ((StringBuilder)localObject).append(", useAssets = ");
      ((StringBuilder)localObject).append(paramBoolean);
      PTSLog.i("PTSFileUtil", ((StringBuilder)localObject).toString());
    }
    if (TextUtils.isEmpty(paramString))
    {
      PTSLog.i("PTSFileUtil", "[getFileContent] filePath is empty.");
      return "";
    }
    Object localObject = (String)sFileContentMap.get(paramString);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = loadFile(paramString, paramContext, paramBoolean);
    }
    else if (!PTSLog.isColorLevel())
    {
      paramContext = (Context)localObject;
      if (!PTSLog.isDebug()) {}
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("[getFileContent] hit cache, key = ");
      paramContext.append(paramString);
      PTSLog.i("PTSFileUtil", paramContext.toString());
      paramContext = (Context)localObject;
    }
    if (TextUtils.isEmpty(paramContext)) {
      PTSLog.e("PTSFileUtil", "[getFileContent] res is empty.");
    }
    return paramContext;
  }
  
  public static String getFilePath(String paramString1, String paramString2, String paramString3)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString1);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString1);
    localStringBuilder.append(paramString3);
    paramString1 = localStringBuilder.toString();
    if (TextUtils.isEmpty(paramString2)) {
      return paramString1;
    }
    if (paramString2.endsWith(File.separator))
    {
      paramString3 = new StringBuilder();
      paramString3.append(paramString2);
      paramString3.append(paramString1);
      return paramString3.toString();
    }
    paramString3 = new StringBuilder();
    paramString3.append(paramString2);
    paramString3.append(File.separator);
    paramString3.append(paramString1);
    return paramString3.toString();
  }
  
  public static boolean isFileInMap(String paramString)
  {
    boolean bool;
    if (!TextUtils.isEmpty(paramString)) {
      bool = TextUtils.isEmpty((CharSequence)sFileContentMap.get(paramString)) ^ true;
    } else {
      bool = false;
    }
    if ((PTSLog.isColorLevel()) || (PTSLog.isDebug()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[isFileInMap], filePath= ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(", isExist = ");
      localStringBuilder.append(bool);
      PTSLog.i("PTSFileUtil", localStringBuilder.toString());
    }
    return bool;
  }
  
  public static String loadFile(String paramString, Context paramContext, boolean paramBoolean)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    String str = "";
    if (bool)
    {
      PTSLog.i("PTSFileUtil", "[loadFile] filePath is empty.");
      return "";
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = str;
      if (paramContext != null) {
        try
        {
          paramContext = paramContext.getAssets().open(paramString);
          localObject = new byte[paramContext.available()];
          paramContext.read((byte[])localObject);
          paramContext.close();
          localObject = new String((byte[])localObject);
        }
        catch (IOException paramContext)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("loadFile exception, e = ");
          ((StringBuilder)localObject).append(paramContext);
          PTSLog.e("PTSFileUtil", ((StringBuilder)localObject).toString());
          localObject = str;
        }
      }
    }
    else
    {
      paramContext = new StringBuilder();
      paramContext.append("[loadFile], filePath = ");
      paramContext.append(paramString);
      PTSLog.i("PTSFileUtil", paramContext.toString());
      paramContext = new File(paramString);
      localObject = str;
      try
      {
        if (paramContext.exists())
        {
          paramContext = new FileInputStream(paramContext);
          localObject = new byte[paramContext.available()];
          paramContext.read((byte[])localObject);
          paramContext.close();
          localObject = new String((byte[])localObject);
        }
      }
      catch (Throwable paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[loadFile], t = ");
        ((StringBuilder)localObject).append(paramContext);
        PTSLog.e("PTSFileUtil", ((StringBuilder)localObject).toString());
        localObject = str;
      }
      catch (IOException paramContext)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[loadFile], e = ");
        ((StringBuilder)localObject).append(paramContext);
        PTSLog.e("PTSFileUtil", ((StringBuilder)localObject).toString());
        localObject = str;
      }
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramContext = new StringBuilder();
      paramContext.append("[loadFile] res is empty, filePath = ");
      paramContext.append(paramString);
      PTSLog.e("PTSFileUtil", paramContext.toString());
      return localObject;
    }
    paramContext = new StringBuilder();
    paramContext.append("[loadFile] succeed, filePath = ");
    paramContext.append(paramString);
    PTSLog.i("PTSFileUtil", paramContext.toString());
    sFileContentMap.put(paramString, localObject);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.pts.utils.PTSFileUtil
 * JD-Core Version:    0.7.0.1
 */