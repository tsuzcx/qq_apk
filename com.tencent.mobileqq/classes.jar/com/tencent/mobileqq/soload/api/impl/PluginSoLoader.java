package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.util.LoadLibraryUtil;
import com.tencent.mobileqq.soload.util.SoLoadUtils;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.util.Iterator;
import java.util.List;

public class PluginSoLoader
  implements ISoLoader
{
  private SoLoaderLogic a = new SoLoaderLogic();
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    if (paramLoadParam == null) {
      return null;
    }
    Object localObject;
    if (!(paramLoadParam.mClassLoader instanceof DexClassLoader))
    {
      localObject = this.a;
      if (localObject != null) {
        return ((SoLoaderLogic)localObject).a(paramLoadParam);
      }
    }
    else
    {
      localObject = SoLoadUtils.a(paramLoadParam.mClassLoader).iterator();
      while (((Iterator)localObject).hasNext())
      {
        File localFile = (File)((Iterator)localObject).next();
        try
        {
          LoadLibraryUtil.a(getClass().getClassLoader(), localFile);
        }
        catch (Throwable localThrowable)
        {
          localThrowable.printStackTrace();
        }
      }
      localObject = this.a;
      if (localObject != null) {
        return ((SoLoaderLogic)localObject).a(paramLoadParam);
      }
    }
    return null;
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    if (paramLoadParam == null)
    {
      if (paramOnLoadListener != null) {
        paramOnLoadListener.onLoadResult(6, new LoadExtResult());
      }
    }
    else
    {
      Object localObject;
      if (!(paramLoadParam.mClassLoader instanceof DexClassLoader))
      {
        localObject = this.a;
        if (localObject != null) {
          ((SoLoaderLogic)localObject).a(paramLoadParam, paramOnLoadListener);
        }
      }
      else if (this.a != null)
      {
        localObject = SoLoadUtils.a(paramLoadParam.mClassLoader).iterator();
        while (((Iterator)localObject).hasNext())
        {
          File localFile = (File)((Iterator)localObject).next();
          try
          {
            LoadLibraryUtil.a(getClass().getClassLoader(), localFile);
          }
          catch (Throwable localThrowable)
          {
            localThrowable.printStackTrace();
          }
        }
        this.a.a(paramLoadParam, paramOnLoadListener);
      }
    }
  }
  
  public boolean a(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    return (localSoLoaderLogic != null) && (localSoLoaderLogic.a(paramString));
  }
  
  public void b(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.a;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.PluginSoLoader
 * JD-Core Version:    0.7.0.1
 */