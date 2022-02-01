package com.tencent.yahfa.apphook.classfactory;

import com.tencent.yahfa.apphook.YahfaLog;
import java.lang.reflect.Method;

public class GenedClassInfo
{
  public static final String backupMethodName = "backup";
  public static final String replaceMethodName = "replace";
  private Method backup = null;
  private String fullName = null;
  private HookedMethodInfo hookedMethodInfo = null;
  private Method replace = null;
  
  public GenedClassInfo(String paramString, HookedMethodInfo paramHookedMethodInfo)
  {
    YahfaLog.d("GenedClassInfo classDesc is " + paramString);
    this.hookedMethodInfo = paramHookedMethodInfo;
    this.fullName = paramString.replace("/", ".").substring(1, paramString.length() - 1);
    YahfaLog.d("GenedClassInfo fullName is " + this.fullName);
  }
  
  public Method getBackup()
  {
    return this.backup;
  }
  
  public String getFullName()
  {
    return this.fullName;
  }
  
  public HookedMethodInfo getHookedMethodInfo()
  {
    return this.hookedMethodInfo;
  }
  
  public Method getReplace()
  {
    return this.replace;
  }
  
  public boolean initGenedClass(ClassLoader paramClassLoader)
  {
    YahfaLog.d("GenedClassInfo hookedMethodInfo param count is " + this.hookedMethodInfo.getParamNo());
    Class[] arrayOfClass = new Class[this.hookedMethodInfo.getParamNo() + 1];
    arrayOfClass[0] = Object.class;
    int i = 0;
    while (i < this.hookedMethodInfo.getParamNo())
    {
      arrayOfClass[(i + 1)] = this.hookedMethodInfo.getParamClasses()[0];
      i += 1;
    }
    for (;;)
    {
      try
      {
        paramClassLoader = Class.forName(this.fullName, true, paramClassLoader);
        paramClassLoader.newInstance();
        YahfaLog.d("GenedClassInfo genMethodParamClasses param count is " + arrayOfClass.length);
        paramClassLoader = paramClassLoader.getDeclaredMethods();
        int j = paramClassLoader.length;
        i = 0;
        if (i < j)
        {
          arrayOfClass = paramClassLoader[i];
          if ("backup".equals(arrayOfClass.getName())) {
            this.backup = arrayOfClass;
          } else if ("replace".equals(arrayOfClass.getName())) {
            this.replace = arrayOfClass;
          }
        }
      }
      catch (Exception paramClassLoader)
      {
        YahfaLog.e("error occur when init generated class,ClassInfo:" + toString(), paramClassLoader);
        return false;
      }
      return true;
      i += 1;
    }
  }
  
  public String toString()
  {
    return "GenedClassInfo [fullName=" + this.fullName + ", hookedMethodInfo=" + this.hookedMethodInfo + ", replace=" + this.replace + ", backup=" + this.backup + "]";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.classfactory.GenedClassInfo
 * JD-Core Version:    0.7.0.1
 */