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
    synchronized (jdField_a_of_type_JavaUtilHashMap)
    {
      FileProvideHelper.PathStrategy localPathStrategy2 = (FileProvideHelper.PathStrategy)jdField_a_of_type_JavaUtilHashMap.get(paramString);
      FileProvideHelper.PathStrategy localPathStrategy1 = localPathStrategy2;
      if (localPathStrategy2 == null) {
        try
        {
          localPathStrategy1 = b(paramContext, paramString);
          jdField_a_of_type_JavaUtilHashMap.put(paramString, localPathStrategy1);
        }
        catch (XmlPullParserException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
        catch (IOException paramContext)
        {
          throw new IllegalArgumentException("Failed to parse android.support.FILE_PROVIDER_PATHS meta-data", paramContext);
        }
      }
      return localPathStrategy1;
    }
  }
  
  private static File a(File paramFile, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      File localFile = paramFile;
      if (str != null) {
        localFile = new File(paramFile, str);
      }
      i += 1;
      paramFile = localFile;
    }
    return paramFile;
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
    ProviderInfo localProviderInfo = paramContext.getPackageManager().resolveContentProvider(paramString, 128);
    if (localProviderInfo != null)
    {
      XmlResourceParser localXmlResourceParser = localProviderInfo.loadXmlMetaData(paramContext.getPackageManager(), "android.support.FILE_PROVIDER_PATHS");
      if (localXmlResourceParser != null)
      {
        for (;;)
        {
          int i = localXmlResourceParser.next();
          if (i == 1) {
            break;
          }
          if (i == 2)
          {
            Object localObject = localXmlResourceParser.getName();
            localProviderInfo = null;
            String str1 = localXmlResourceParser.getAttributeValue(null, "name");
            String str2 = localXmlResourceParser.getAttributeValue(null, "path");
            if ("root-path".equals(localObject))
            {
              paramString = jdField_a_of_type_JavaIoFile;
            }
            else if ("files-path".equals(localObject))
            {
              paramString = paramContext.getFilesDir();
            }
            else if ("cache-path".equals(localObject))
            {
              paramString = paramContext.getCacheDir();
            }
            else if ("external-path".equals(localObject))
            {
              paramString = Environment.getExternalStorageDirectory();
            }
            else if ("external-files-path".equals(localObject))
            {
              localObject = a(paramContext, null);
              paramString = localProviderInfo;
              if (localObject.length > 0) {
                paramString = localObject[0];
              }
            }
            else if ("external-cache-path".equals(localObject))
            {
              localObject = a(paramContext);
              paramString = localProviderInfo;
              if (localObject.length > 0) {
                paramString = localObject[0];
              }
            }
            else
            {
              paramString = localProviderInfo;
              if (Build.VERSION.SDK_INT >= 21)
              {
                paramString = localProviderInfo;
                if ("external-media-path".equals(localObject))
                {
                  localObject = paramContext.getExternalMediaDirs();
                  paramString = localProviderInfo;
                  if (localObject.length > 0) {
                    paramString = localObject[0];
                  }
                }
              }
            }
            if (paramString != null) {
              localSimplePathStrategy.a(str1, a(paramString, new String[] { str2 }));
            }
          }
        }
        return localSimplePathStrategy;
      }
      throw new IllegalArgumentException("Missing android.support.FILE_PROVIDER_PATHS meta-data");
    }
    paramContext = new StringBuilder();
    paramContext.append("Couldn't find meta-data for provider with authority ");
    paramContext.append(paramString);
    paramContext = new IllegalArgumentException(paramContext.toString());
    for (;;)
    {
      throw paramContext;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.FileProvideHelper
 * JD-Core Version:    0.7.0.1
 */