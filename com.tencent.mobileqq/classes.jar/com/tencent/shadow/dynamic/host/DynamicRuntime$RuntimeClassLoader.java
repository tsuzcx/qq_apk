package com.tencent.shadow.dynamic.host;

import dalvik.system.BaseDexClassLoader;

class DynamicRuntime$RuntimeClassLoader
  extends BaseDexClassLoader
{
  private String apkPath;
  
  DynamicRuntime$RuntimeClassLoader(String paramString1, String paramString2, String paramString3, ClassLoader paramClassLoader)
  {
    super(paramString1, paramString2, paramString3, paramClassLoader);
    this.apkPath = paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.DynamicRuntime.RuntimeClassLoader
 * JD-Core Version:    0.7.0.1
 */