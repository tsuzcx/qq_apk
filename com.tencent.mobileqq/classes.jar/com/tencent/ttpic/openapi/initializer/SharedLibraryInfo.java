package com.tencent.ttpic.openapi.initializer;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.support.annotation.NonNull;
import com.tencent.aekit.api.standard.AEModule;
import com.tencent.aekit.api.standard.AEResourceDict;
import java.lang.reflect.Field;

public class SharedLibraryInfo
  extends AEResourceInfo
{
  public SharedLibraryInfo(String paramString)
  {
    this.fileName = paramString;
    this.sha1 = getExpectedSoFileSHA1(paramString);
  }
  
  private static String getAbi()
  {
    Object localObject = AEModule.getContext();
    if (localObject == null) {
      return null;
    }
    try
    {
      localObject = ApplicationInfo.class.getDeclaredField("primaryCpuAbi").get(((Context)localObject).getApplicationInfo());
      if (localObject != null)
      {
        localObject = (String)localObject;
        return localObject;
      }
    }
    catch (NoSuchFieldException localNoSuchFieldException)
    {
      localNoSuchFieldException.printStackTrace();
      return null;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      localIllegalAccessException.printStackTrace();
    }
    return null;
  }
  
  private static String getExpectedSoFileSHA1(String paramString)
  {
    return AEResourceDict.getSHA1(getAbi(), getFullLibName(paramString));
  }
  
  public static String getFullLibName(String paramString)
  {
    return "lib" + paramString + ".so";
  }
  
  public String getFullLibName()
  {
    return getFullLibName(this.fileName);
  }
  
  @NonNull
  public String toString()
  {
    return String.format("%s(sha1 = %s)", new Object[] { getFullLibName(), this.sha1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.initializer.SharedLibraryInfo
 * JD-Core Version:    0.7.0.1
 */