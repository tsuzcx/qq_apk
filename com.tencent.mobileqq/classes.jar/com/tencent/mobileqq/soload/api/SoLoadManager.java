package com.tencent.mobileqq.soload.api;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions.LoadOptionsBuilder;
import java.util.ArrayList;
import java.util.List;

public class SoLoadManager
{
  public static final String SOLOAD_TAG_PREFIX = "SoLoadWidget.";
  public static final String TAG = "SoLoadWidget.SoLoadManager";
  private static volatile SoLoadManager sInstance;
  private ISoLoaderService mISoloadService = (ISoLoaderService)QRoute.api(ISoLoaderService.class);
  
  public static SoLoadManager getInstance()
  {
    if (sInstance == null) {
      try
      {
        if (sInstance == null) {
          sInstance = new SoLoadManager();
        }
      }
      finally {}
    }
    return sInstance;
  }
  
  public void download(String paramString, OnLoadListener paramOnLoadListener)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      localISoLoaderService.download(paramString, paramOnLoadListener);
    }
  }
  
  public void download(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      localISoLoaderService.download(paramArrayOfString, paramOnLoadListener);
    }
  }
  
  @Deprecated
  public List<String> getCurInitSoList()
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService == null) {
      return new ArrayList();
    }
    return localISoLoaderService.getCurInitSoList();
  }
  
  public String getInitVer(String paramString)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService == null) {
      return "";
    }
    return localISoLoaderService.getInitVer(paramString);
  }
  
  public String getSoVer(String paramString)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService == null) {
      return "";
    }
    return localISoLoaderService.getSoVer(paramString);
  }
  
  public boolean isExist(String paramString)
  {
    LoadExtResult localLoadExtResult = loadSync(paramString, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build());
    paramString = localLoadExtResult;
    if (localLoadExtResult == null) {
      paramString = new LoadExtResult();
    }
    return paramString.isSucc();
  }
  
  public boolean isExist(String[] paramArrayOfString)
  {
    int j = 0;
    int i;
    if (paramArrayOfString == null) {
      i = 0;
    } else {
      i = paramArrayOfString.length;
    }
    Object localObject = null;
    if (i > 0)
    {
      LoadOptions[] arrayOfLoadOptions = new LoadOptions[i];
      for (;;)
      {
        localObject = arrayOfLoadOptions;
        if (j >= i) {
          break;
        }
        arrayOfLoadOptions[j] = new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build();
        j += 1;
      }
    }
    return loadSequentiallySync(paramArrayOfString, localObject).isSucc();
  }
  
  public void load(String paramString, OnLoadListener paramOnLoadListener)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      localISoLoaderService.load(paramString, paramOnLoadListener);
    }
  }
  
  public void loadSequentially(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
  {
    loadSequentially(paramArrayOfString, paramOnLoadListener, null);
  }
  
  public void loadSequentially(String[] paramArrayOfString, OnLoadListener paramOnLoadListener, LoadOptions[] paramArrayOfLoadOptions)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      localISoLoaderService.loadSequentially(paramArrayOfString, paramOnLoadListener, paramArrayOfLoadOptions);
    }
  }
  
  public LoadExtResult loadSequentiallySync(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      return localISoLoaderService.loadSequentiallySync(paramArrayOfString, paramArrayOfLoadOptions);
    }
    return null;
  }
  
  public LoadExtResult loadSync(String paramString)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      return localISoLoaderService.loadSync(paramString, null);
    }
    return null;
  }
  
  public LoadExtResult loadSync(String paramString, LoadOptions paramLoadOptions)
  {
    ISoLoaderService localISoLoaderService = this.mISoloadService;
    if (localISoLoaderService != null) {
      return localISoLoaderService.loadSync(paramString, paramLoadOptions);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.SoLoadManager
 * JD-Core Version:    0.7.0.1
 */