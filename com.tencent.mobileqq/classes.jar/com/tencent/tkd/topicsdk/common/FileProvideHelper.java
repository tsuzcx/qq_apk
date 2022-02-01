package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.content.res.XmlResourceParser;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.xmlpull.v1.XmlPullParserException;

public class FileProvideHelper
{
  private static final File jdField_a_of_type_JavaIoFile = new File("/");
  private static HashMap<String, FileProvideHelper.PathStrategy> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  
  public static Uri a(@NotNull Context paramContext, @NotNull String paramString, @NotNull File paramFile)
  {
    return a(paramContext, paramString).a(paramFile);
  }
  
  private static FileProvideHelper.PathStrategy a(Context paramContext, String paramString)
  {
    FileProvideHelper.PathStrategy localPathStrategy1;
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      FileProvideHelper.PathStrategy localPathStrategy2 = (FileProvideHelper.PathStrategy)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      localPathStrategy1 = localPathStrategy2;
      if (localPathStrategy2 != null) {}
    }
    try
    {
      localPathStrategy1 = b(paramContext, paramString);
      jdField_a_of_type_JavaUtilHashMap.put(paramString, localPathStrategy1);
      return localPathStrategy1;
    }
    catch (IOException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
      paramContext = finally;
      throw paramContext;
    }
    catch (XmlPullParserException paramContext)
    {
      throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
    }
  }
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      if (str == null) {
        break label40;
      }
      paramFile = new File(paramFile, str);
    }
    label40:
    for (;;)
    {
      i += 1;
      break;
      return paramFile;
    }
  }
  
  @NotNull
  public static File[] a(@NotNull Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalCacheDirs();
    }
    return new File[] { paramContext.getExternalCacheDir() };
  }
  
  @NotNull
  public static File[] a(@NotNull Context paramContext, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 19) {
      return paramContext.getExternalFilesDirs(paramString);
    }
    return new File[] { paramContext.getExternalFilesDir(paramString) };
  }
  
  private static FileProvideHelper.PathStrategy b(Context paramContext, String paramString)
  {
    FileProvideHelper.SimplePathStrategy localSimplePathStrategy = new FileProvideHelper.SimplePathStrategy(paramString);
    Object localObject = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (localObject == null) {
      throw new IllegalArgumentException("Couldn't find meta-data for provider with authority " + paramString);
    }
    localObject = ((ProviderInfo)localObject).loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
    if (localObject == null) {
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    label313:
    for (;;)
    {
      int i = ((XmlResourceParser)localObject).next();
      String str1;
      String str2;
      if (i != 1)
      {
        if (i != 2) {
          continue;
        }
        paramString = ((XmlResourceParser)localObject).getName();
        str1 = ((XmlResourceParser)localObject).getAttributeValue(null, "name");
        str2 = ((XmlResourceParser)localObject).getAttributeValue(null, "path");
        if ("root-path".equals(paramString)) {
          paramString = jdField_a_of_type_JavaIoFile;
        }
      }
      for (;;)
      {
        if (paramString == null) {
          break label313;
        }
        localSimplePathStrategy.a(str1, a(paramString, new String[] { str2 }));
        break;
        if ("files-path".equals(paramString))
        {
          paramString = paramContext.getFilesDir();
        }
        else if ("cache-path".equals(paramString))
        {
          paramString = paramContext.getCacheDir();
        }
        else if ("external-path".equals(paramString))
        {
          paramString = Environment.getExternalStorageDirectory();
        }
        else
        {
          if ("external-files-path".equals(paramString))
          {
            paramString = a(paramContext, null);
            if (paramString.length > 0) {
              paramString = paramString[0];
            }
          }
          else if ("external-cache-path".equals(paramString))
          {
            paramString = a(paramContext);
            if (paramString.length > 0) {
              paramString = paramString[0];
            }
          }
          else if ((Build.VERSION.SDK_INT >= 21) && ("external-media-path".equals(paramString)))
          {
            paramString = paramContext.getExternalMediaDirs();
            if (paramString.length > 0)
            {
              paramString = paramString[0];
              continue;
              return localSimplePathStrategy;
            }
          }
          paramString = null;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileProvideHelper
 * JD-Core Version:    0.7.0.1
 */