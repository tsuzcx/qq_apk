package com.tencent.qqmini.sdk.runtime;

import android.util.AndroidRuntimeException;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderConfig;
import com.tencent.qqmini.sdk.annotation.RuntimeLoaderInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class RuntimeLoaderConfiguration
{
  Comparator comparator = new RuntimeLoaderConfiguration.1(this);
  private final List<RuntimeLoaderConfiguration.RuntimeLoaderInfo> loaderInfoList = new ArrayList();
  
  RuntimeLoaderConfiguration(AppRuntimeLoaderManager paramAppRuntimeLoaderManager)
  {
    paramAppRuntimeLoaderManager = (RuntimeLoaderConfig)paramAppRuntimeLoaderManager.getClass().getAnnotation(RuntimeLoaderConfig.class);
    if (paramAppRuntimeLoaderManager == null) {}
    do
    {
      return;
      paramAppRuntimeLoaderManager = paramAppRuntimeLoaderManager.loaders();
    } while (paramAppRuntimeLoaderManager == null);
    int j = paramAppRuntimeLoaderManager.length;
    int i = 0;
    label61:
    RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo;
    Object localObject2;
    if (i < j)
    {
      Object localObject1 = paramAppRuntimeLoaderManager[i];
      try
      {
        localRuntimeLoaderInfo = new RuntimeLoaderConfiguration.RuntimeLoaderInfo();
        localObject2 = Class.forName(localObject1.className());
        if (!BaseRuntimeLoader.class.isAssignableFrom((Class)localObject2)) {
          throw new AndroidRuntimeException("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is " + localObject1.className());
        }
      }
      catch (Throwable localThrowable)
      {
        QMLog.w("RuntimeLoaderConfiguration", "", localThrowable);
      }
    }
    for (;;)
    {
      i += 1;
      break label61;
      break;
      localRuntimeLoaderInfo.runtimeLoaderClass = ((Class)localObject2);
      localRuntimeLoaderInfo.type = localThrowable.type();
      localObject2 = localRuntimeLoaderInfo.runtimeLoaderClass.getField("CREATOR");
      if ((((Field)localObject2).getModifiers() & 0x8) == 0) {
        throw new AndroidRuntimeException("RuntimeLoader protocol requires the CREATOR object to be static on class " + localThrowable.className());
      }
      if (!BaseRuntimeLoader.Creator.class.isAssignableFrom(((Field)localObject2).getType())) {
        throw new AndroidRuntimeException("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class " + localThrowable.className());
      }
      localRuntimeLoaderInfo.creator = ((BaseRuntimeLoader.Creator)((Field)localObject2).get(null));
      this.loaderInfoList.add(localRuntimeLoaderInfo);
    }
  }
  
  public List<RuntimeLoaderConfiguration.RuntimeLoaderInfo> getLoaderInfoList()
  {
    return this.loaderInfoList;
  }
  
  public List<RuntimeLoaderConfiguration.RuntimeLoaderInfo> getLoaderInfoListForPreload()
  {
    return new ArrayList(this.loaderInfoList);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{");
    Iterator localIterator = this.loaderInfoList.iterator();
    while (localIterator.hasNext())
    {
      RuntimeLoaderConfiguration.RuntimeLoaderInfo localRuntimeLoaderInfo = (RuntimeLoaderConfiguration.RuntimeLoaderInfo)localIterator.next();
      if (localRuntimeLoaderInfo != null) {
        localStringBuilder.append("***Loader:").append(localRuntimeLoaderInfo.runtimeLoaderClass.getName()).append(", Creator:").append(localRuntimeLoaderInfo.creator.getClass().getName()).append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.RuntimeLoaderConfiguration
 * JD-Core Version:    0.7.0.1
 */