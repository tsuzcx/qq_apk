package com.tencent.mobileqq.soload.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.soload.entity.MinElf;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SoDependencyUtil
{
  public static String a(String paramString)
  {
    return SoDataUtil.a("SoDependency").getString(paramString, "");
  }
  
  public static List<String> a(File paramFile)
  {
    Object localObject1 = new String[0];
    Object localObject2 = a(paramFile.getAbsolutePath());
    if (!StringUtil.a((String)localObject2)) {
      localObject1 = ((String)localObject2).split("\\|");
    }
    if (localObject1.length > 0)
    {
      QLog.i("SoLoadWidget.SoDependencyUtil", 2, "get dependencies by cache!!!");
      return Arrays.asList((Object[])localObject1);
    }
    localObject1 = new ArrayList();
    Object localObject3 = Arrays.asList(b(paramFile));
    localObject2 = SoConfigManager.a().a();
    StringBuilder localStringBuilder = new StringBuilder();
    if (!((List)localObject3).isEmpty())
    {
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        String str = (String)((Iterator)localObject3).next();
        if (((Set)localObject2).contains(str))
        {
          ((List)localObject1).add(str);
          localStringBuilder.append(str);
          localStringBuilder.append("|");
        }
      }
    }
    a(localStringBuilder.toString(), paramFile.getAbsolutePath());
    return localObject1;
  }
  
  public static void a(String paramString1, String paramString2)
  {
    if (!StringUtil.a(paramString1))
    {
      if (StringUtil.a(paramString2)) {
        return;
      }
      SoDataUtil.a("SoDependency").edit().putString(paramString2, paramString1).apply();
    }
  }
  
  public static String[] a(File paramFile)
  {
    try
    {
      paramFile = MinElf.a(paramFile);
      return paramFile;
    }
    catch (Throwable paramFile)
    {
      QLog.e("SoLoadWidget.SoDependencyUtil", 1, paramFile, new Object[0]);
    }
    return null;
  }
  
  private static String[] b(File paramFile)
  {
    paramFile = a(paramFile);
    int i = 0;
    if ((paramFile != null) && (paramFile.length != 0))
    {
      String[] arrayOfString = new String[paramFile.length];
      while (i < paramFile.length)
      {
        if ((paramFile[i].startsWith("lib")) && (paramFile[i].endsWith(".so"))) {
          arrayOfString[i] = paramFile[i].substring(3, paramFile[i].lastIndexOf("."));
        }
        i += 1;
      }
      return arrayOfString;
    }
    return new String[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.util.SoDependencyUtil
 * JD-Core Version:    0.7.0.1
 */