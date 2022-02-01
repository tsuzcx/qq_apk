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
    if (paramAppRuntimeLoaderManager == null) {
      return;
    }
    paramAppRuntimeLoaderManager = paramAppRuntimeLoaderManager.loaders();
    if (paramAppRuntimeLoaderManager != null)
    {
      int j = paramAppRuntimeLoaderManager.length;
      int i = 0;
      while (i < j)
      {
        Object localObject1 = paramAppRuntimeLoaderManager[i];
        try
        {
          Object localObject2 = new RuntimeLoaderConfiguration.RuntimeLoaderInfo();
          Object localObject3 = Class.forName(localObject1.className());
          if (BaseRuntimeLoader.class.isAssignableFrom((Class)localObject3))
          {
            ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject2).runtimeLoaderClass = ((Class)localObject3);
            ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject2).type = localObject1.type();
            localObject3 = ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject2).runtimeLoaderClass.getField("CREATOR");
            if ((((Field)localObject3).getModifiers() & 0x8) != 0)
            {
              if (BaseRuntimeLoader.Creator.class.isAssignableFrom(((Field)localObject3).getType()))
              {
                ((RuntimeLoaderConfiguration.RuntimeLoaderInfo)localObject2).creator = ((BaseRuntimeLoader.Creator)((Field)localObject3).get(null));
                this.loaderInfoList.add(localObject2);
              }
              else
              {
                localObject2 = new StringBuilder();
                ((StringBuilder)localObject2).append("RuntimeLoader requires a BaseAppRuntimeLoader.Creator object called CREATOR on class ");
                ((StringBuilder)localObject2).append(localObject1.className());
                throw new AndroidRuntimeException(((StringBuilder)localObject2).toString());
              }
            }
            else
            {
              localObject2 = new StringBuilder();
              ((StringBuilder)localObject2).append("RuntimeLoader protocol requires the CREATOR object to be static on class ");
              ((StringBuilder)localObject2).append(localObject1.className());
              throw new AndroidRuntimeException(((StringBuilder)localObject2).toString());
            }
          }
          else
          {
            localObject2 = new StringBuilder();
            ((StringBuilder)localObject2).append("RuntimeLoaderConfig requires child class of BaseAppRuntimeLoader, current class is ");
            ((StringBuilder)localObject2).append(localObject1.className());
            throw new AndroidRuntimeException(((StringBuilder)localObject2).toString());
          }
        }
        catch (Throwable localThrowable)
        {
          QMLog.w("RuntimeLoaderConfiguration", "", localThrowable);
          i += 1;
        }
      }
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
      if (localRuntimeLoaderInfo != null)
      {
        localStringBuilder.append("***Loader:");
        localStringBuilder.append(localRuntimeLoaderInfo.runtimeLoaderClass.getName());
        localStringBuilder.append(", Creator:");
        localStringBuilder.append(localRuntimeLoaderInfo.creator.getClass().getName());
        localStringBuilder.append("***");
      }
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.runtime.RuntimeLoaderConfiguration
 * JD-Core Version:    0.7.0.1
 */