package com.tencent.shadow.dynamic.host;

import android.text.TextUtils;
import com.tencent.shadow.core.common.InstalledApk;
import com.tencent.shadow.core.common.Logger;
import com.tencent.shadow.core.common.LoggerFactory;

public class MultiDynamicContainer
{
  private static final Logger mLogger = LoggerFactory.getLogger(MultiDynamicContainer.class);
  
  private static MultiDynamicContainer.ContainerClassLoader findContainerClassLoader(String paramString)
  {
    for (ClassLoader localClassLoader = MultiDynamicContainer.class.getClassLoader().getParent(); localClassLoader != null; localClassLoader = localClassLoader.getParent()) {
      if ((localClassLoader instanceof MultiDynamicContainer.ContainerClassLoader))
      {
        MultiDynamicContainer.ContainerClassLoader localContainerClassLoader = (MultiDynamicContainer.ContainerClassLoader)localClassLoader;
        if (TextUtils.equals(MultiDynamicContainer.ContainerClassLoader.access$100(localContainerClassLoader), paramString)) {
          return localContainerClassLoader;
        }
      }
    }
    return null;
  }
  
  private static void hackContainerClassLoader(String paramString, InstalledApk paramInstalledApk)
  {
    ClassLoader localClassLoader = MultiDynamicContainer.class.getClassLoader();
    DynamicRuntime.hackParentClassLoader(localClassLoader, new MultiDynamicContainer.ContainerClassLoader(paramString, paramInstalledApk, localClassLoader.getParent()));
  }
  
  public static boolean loadContainerApk(String paramString, InstalledApk paramInstalledApk)
  {
    Object localObject1 = findContainerClassLoader(paramString);
    Object localObject2;
    if (localObject1 != null)
    {
      localObject2 = MultiDynamicContainer.ContainerClassLoader.access$000((MultiDynamicContainer.ContainerClassLoader)localObject1);
      if (mLogger.isInfoEnabled())
      {
        Logger localLogger = mLogger;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("该containKey的apk已经加载过, containKey=");
        localStringBuilder.append(paramString);
        localStringBuilder.append(", last apkPath=");
        localStringBuilder.append((String)localObject2);
        localStringBuilder.append(", new apkPath=");
        localStringBuilder.append(paramInstalledApk.apkFilePath);
        localLogger.info(localStringBuilder.toString());
      }
      if (TextUtils.equals((CharSequence)localObject2, paramInstalledApk.apkFilePath))
      {
        if (mLogger.isInfoEnabled()) {
          mLogger.info("已经加载相同apkPath的containerApk了,不需要加载");
        }
        return false;
      }
      if (mLogger.isInfoEnabled()) {
        mLogger.info("加载不相同apkPath的containerApk了,先将老的移除");
      }
      try
      {
        removeContainerClassLoader((MultiDynamicContainer.ContainerClassLoader)localObject1);
      }
      catch (Exception paramString)
      {
        mLogger.error("移除老的containerApk失败", paramString);
        throw new RuntimeException(paramString);
      }
    }
    try
    {
      hackContainerClassLoader(paramString, paramInstalledApk);
      if (mLogger.isInfoEnabled())
      {
        localObject1 = mLogger;
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("containerApk插入成功，containerKey=");
        ((StringBuilder)localObject2).append(paramString);
        ((StringBuilder)localObject2).append(", path=");
        ((StringBuilder)localObject2).append(paramInstalledApk.apkFilePath);
        ((Logger)localObject1).info(((StringBuilder)localObject2).toString());
      }
      return true;
    }
    catch (Exception paramString)
    {
      throw new RuntimeException(paramString);
    }
  }
  
  private static void removeContainerClassLoader(MultiDynamicContainer.ContainerClassLoader paramContainerClassLoader)
  {
    Object localObject2 = MultiDynamicContainer.class.getClassLoader();
    ClassLoader localClassLoader;
    for (Object localObject1 = ((ClassLoader)localObject2).getParent(); (localObject1 != null) && (localObject1 != paramContainerClassLoader); localObject1 = localClassLoader)
    {
      localClassLoader = ((ClassLoader)localObject1).getParent();
      localObject2 = localObject1;
    }
    if ((localObject2 != null) && (localObject1 == paramContainerClassLoader)) {
      DynamicRuntime.hackParentClassLoader((ClassLoader)localObject2, paramContainerClassLoader.getParent());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.shadow.dynamic.host.MultiDynamicContainer
 * JD-Core Version:    0.7.0.1
 */