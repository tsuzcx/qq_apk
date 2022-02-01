package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.api.ISoLoaderService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions;
import com.tencent.mobileqq.soload.biz.entity.LoadOptions.LoadOptionsBuilder;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import com.tencent.mobileqq.soload.biz.entity.SoLoadInfo;
import com.tencent.mobileqq.soload.util.SoReportUtil;
import com.tencent.qphone.base.util.QLog;
import dalvik.system.DexClassLoader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class SoLoaderServiceImpl
  implements ISoLoaderService
{
  private static final Map<LoadParam, List<OnLoadListener>> LINSTER_IN_LOADING = new HashMap();
  public static final Map<LoadParam, ISoLoader> LOADER_IN_LOADING = new HashMap();
  private static final String TAG = "SoLoadWidget.SoloadServiceImpl";
  private final Set<LoadParam> mCurDelayTokens = new HashSet();
  
  private static void addLoadingLoader(LoadParam paramLoadParam, ISoLoader paramISoLoader)
  {
    if (paramLoadParam != null)
    {
      if (paramISoLoader == null) {
        return;
      }
      synchronized (LOADER_IN_LOADING)
      {
        LOADER_IN_LOADING.put(paramLoadParam, paramISoLoader);
        return;
      }
    }
  }
  
  private OnLoadListener constructInnerListener(LoadParam paramLoadParam, long paramLong)
  {
    return new SoLoaderServiceImpl.3(this, paramLoadParam);
  }
  
  private LoadParam constructMultiLoadParam(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    if (paramArrayOfString != null)
    {
      int i = 0;
      while (i < paramArrayOfString.length)
      {
        String str = paramArrayOfString[i];
        if (!TextUtils.isEmpty(str))
        {
          LoadOptions localLoadOptions;
          if ((paramArrayOfLoadOptions != null) && (paramArrayOfLoadOptions.length > i)) {
            localLoadOptions = paramArrayOfLoadOptions[i];
          } else {
            localLoadOptions = null;
          }
          localLoadParam.addItem(str, localLoadOptions);
        }
        i += 1;
      }
    }
    return localLoadParam;
  }
  
  private LoadParam constructSingleLoadParam(String paramString, LoadOptions paramLoadOptions)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.addItem(paramString, paramLoadOptions);
    return localLoadParam;
  }
  
  private LoadParam getSameParamInLoad(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    Object localObject1;
    synchronized (LINSTER_IN_LOADING)
    {
      localObject1 = LINSTER_IN_LOADING.entrySet().iterator();
      LoadParam localLoadParam;
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (Map.Entry)((Iterator)localObject1).next();
        localLoadParam = (LoadParam)((Map.Entry)localObject2).getKey();
      } while ((localLoadParam == null) || (!localLoadParam.isSame(paramLoadParam)));
      if (localLoadParam.isOverTime())
      {
        localObject2 = (List)((Map.Entry)localObject2).getValue();
        ((Iterator)localObject1).remove();
        localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("[getSameParamInLoad] isOverTime:");
          ((StringBuilder)localObject1).append(localObject2);
          QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
          localObject1 = localObject2;
        }
      }
      else
      {
        ((List)((Map.Entry)localObject2).getValue()).add(paramOnLoadListener);
        return localLoadParam;
      }
      Object localObject2 = new LinkedList();
      ((LinkedList)localObject2).add(paramOnLoadListener);
      paramLoadParam.mLoadTime = NetConnInfoCenter.getServerTimeMillis();
      LINSTER_IN_LOADING.put(paramLoadParam, localObject2);
      if (localObject1 != null)
      {
        paramOnLoadListener = ((List)localObject1).iterator();
        while (paramOnLoadListener.hasNext())
        {
          localObject1 = (OnLoadListener)paramOnLoadListener.next();
          if (localObject1 != null) {
            ((OnLoadListener)localObject1).onLoadResult(7, LoadExtResult.create(7, LoadParam.getItemSize(paramLoadParam)));
          }
        }
      }
      return null;
    }
  }
  
  private ISoLoader getSoLoader(LoadParam paramLoadParam)
  {
    if (paramLoadParam != null)
    {
      if ((paramLoadParam.mClassLoader instanceof DexClassLoader)) {
        return new PluginSoLoader();
      }
      if (paramLoadParam.mLoadItems.size() > 1) {
        return new MultiSoLoader();
      }
      return new SingleSoLoader();
    }
    return new SingleSoLoader();
  }
  
  private static void handleLoadResult(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, OnLoadListener paramOnLoadListener, LoadParam paramLoadParam)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      if ((paramLoadParam != null) && (paramLoadParam.mLoadItems != null) && (!paramLoadParam.mLoadItems.isEmpty())) {
        localObject = paramLoadParam.mLoadItems.iterator();
      }
      while (((Iterator)localObject).hasNext())
      {
        LoadParam.LoadItem localLoadItem = (LoadParam.LoadItem)((Iterator)localObject).next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[LoadResult] soName: ");
        localStringBuilder.append(localLoadItem.soFileName);
        localStringBuilder.append(" resCode：");
        localStringBuilder.append(paramInt);
        QLog.i("SoLoadWidget.SoloadServiceImpl", 2, localStringBuilder.toString());
        continue;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[LoadResult] resCode：");
        ((StringBuilder)localObject).append(paramInt);
        QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)localObject).toString());
      }
    }
    int i;
    if (paramLoadExtResult != null) {
      i = paramLoadExtResult.getReportCode();
    } else {
      i = 0;
    }
    if (paramLoadExtResult != null) {
      localObject = paramLoadExtResult.getReportStr();
    } else {
      localObject = "";
    }
    if (paramInt != 0) {
      SoReportUtil.a(paramLoadParam, paramLong, "load.end", (String)localObject, i, null);
    }
    if (paramOnLoadListener != null)
    {
      if (paramLoadExtResult == null) {
        paramLoadExtResult = new LoadExtResult();
      }
      paramOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
    }
    removeLoadingLoader(paramLoadParam);
    if (!LoadParam.isCloseReport(paramLoadParam)) {
      SoReportUtil.a(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, (String)localObject, "", "", "");
    }
  }
  
  private void handleLoadSyncFail(LoadExtResult arg1, LoadParam paramLoadParam)
  {
    paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC_BY_SYNC;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel())
    {
      ??? = new StringBuilder();
      ???.append("[handleLoadSyncFail]delayTime:");
      ???.append(l);
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ???.toString());
    }
    if (l <= 0L)
    {
      loadAsync(paramLoadParam, null);
      return;
    }
    synchronized (this.mCurDelayTokens)
    {
      Iterator localIterator = this.mCurDelayTokens.iterator();
      while (localIterator.hasNext())
      {
        LoadParam localLoadParam = (LoadParam)localIterator.next();
        if (localLoadParam.isSame(paramLoadParam))
        {
          ThreadManager.getSubThreadHandler().removeCallbacksAndMessages(localLoadParam);
          localIterator.remove();
        }
      }
      ThreadManager.getSubThreadHandler().postAtTime(new SoLoaderServiceImpl.1(this, paramLoadParam), paramLoadParam, NetConnInfoCenter.getServerTimeMillis() + l);
      this.mCurDelayTokens.add(paramLoadParam);
      return;
    }
    for (;;)
    {
      throw paramLoadParam;
    }
  }
  
  private void load(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load loadParam=");
      ((StringBuilder)localObject).append(paramLoadParam);
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    long l = SoReportUtil.a(paramLoadParam);
    paramOnLoadListener = new SoLoaderServiceImpl.ReportListener(paramOnLoadListener, l, paramLoadParam);
    boolean bool2 = LoadParam.isValid(paramLoadParam);
    boolean bool1 = true;
    if (!bool2)
    {
      paramOnLoadListener.onLoadResult(1, LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam)));
      return;
    }
    if ((paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC) && (paramLoadParam.mCallType != LoadParam.CALL_TYPE_ASYNC_BY_SYNC)) {
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC;
    }
    paramOnLoadListener = getSameParamInLoad(paramLoadParam, paramOnLoadListener);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("load isSameParamInLoad=");
      if (paramOnLoadListener == null) {
        bool1 = false;
      }
      ((StringBuilder)localObject).append(bool1);
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)localObject).toString());
    }
    if (paramOnLoadListener != null)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("first=");
      ((StringBuilder)localObject).append(paramOnLoadListener.mReportSeq);
      SoReportUtil.a(paramLoadParam, l, null, "load.join.same.queue", ((StringBuilder)localObject).toString(), 0, null);
      return;
    }
    paramOnLoadListener = constructInnerListener(paramLoadParam, l);
    Object localObject = getSoLoader(paramLoadParam);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load getSoLoader=");
      localStringBuilder.append(localObject);
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, localStringBuilder.toString());
    }
    addLoadingLoader(paramLoadParam, (ISoLoader)localObject);
    ((ISoLoader)localObject).a(paramLoadParam, paramOnLoadListener);
  }
  
  private void loadAsync(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    ThreadManager.excute(new SoLoaderServiceImpl.2(this, paramLoadParam, paramOnLoadListener), 16, null, false);
  }
  
  private LoadExtResult loadSync(LoadParam paramLoadParam)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("loadSync loadParam=");
      ((StringBuilder)localObject1).append(paramLoadParam);
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, ((StringBuilder)localObject1).toString());
    }
    long l = SoReportUtil.a(paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam))
    {
      localObject1 = LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam));
    }
    else
    {
      localObject1 = getSoLoader(paramLoadParam);
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
      addLoadingLoader(paramLoadParam, (ISoLoader)localObject1);
      localObject1 = ((ISoLoader)localObject1).a(paramLoadParam);
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = new LoadExtResult();
    }
    handleLoadResult(((LoadExtResult)localObject2).getResultCode(), (LoadExtResult)localObject2, l, null, paramLoadParam);
    if (((LoadExtResult)localObject2).isNeedRetry(paramLoadParam)) {
      handleLoadSyncFail((LoadExtResult)localObject2, paramLoadParam);
    }
    return localObject2;
  }
  
  private static void removeLoadingLoader(LoadParam paramLoadParam)
  {
    synchronized (LOADER_IN_LOADING)
    {
      LOADER_IN_LOADING.remove(paramLoadParam);
      return;
    }
  }
  
  public void download(String paramString, OnLoadListener paramOnLoadListener)
  {
    load(paramString, paramOnLoadListener, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).build());
  }
  
  public void download(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
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
        arrayOfLoadOptions[j] = new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).build();
        j += 1;
      }
    }
    loadSequentially(paramArrayOfString, paramOnLoadListener, localObject);
  }
  
  public List<String> getCurInitSoList()
  {
    return SoLoaderLogic.a();
  }
  
  public String getInitVer(String paramString)
  {
    return SoLoaderLogic.c(paramString);
  }
  
  public void getSoLoadInfoTaskAsync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    new GetSoLoadInfoTaskAsync(paramLoadParam, paramLoadItem).a(paramOnGetSoLoadInfoListener);
  }
  
  public SoLoadInfo getSoLoadInfoTaskSync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    return new GetSoLoadInfoTaskSync(paramLoadParam, paramLoadItem).c();
  }
  
  public String getSoVer(String paramString)
  {
    String str = loadSync(paramString, new LoadOptions.LoadOptionsBuilder().setIsNoNeedLoad(true).setIsNoNeedCRC(true).setCloseRetry(true).setCloseReport(true).build()).getVer();
    paramString = str;
    if (TextUtils.isEmpty(str)) {
      paramString = "";
    }
    return paramString;
  }
  
  public void load(String paramString, OnLoadListener paramOnLoadListener)
  {
    load(paramString, paramOnLoadListener, null);
  }
  
  public void load(String paramString, OnLoadListener paramOnLoadListener, LoadOptions paramLoadOptions)
  {
    loadAsync(constructSingleLoadParam(paramString, paramLoadOptions), paramOnLoadListener);
  }
  
  public void loadSequentially(String[] paramArrayOfString, OnLoadListener paramOnLoadListener, LoadOptions[] paramArrayOfLoadOptions)
  {
    loadAsync(constructMultiLoadParam(paramArrayOfString, paramArrayOfLoadOptions), paramOnLoadListener);
  }
  
  public LoadExtResult loadSequentiallySync(String[] paramArrayOfString, LoadOptions[] paramArrayOfLoadOptions)
  {
    return loadSync(constructMultiLoadParam(paramArrayOfString, paramArrayOfLoadOptions));
  }
  
  public LoadExtResult loadSync(String paramString, LoadOptions paramLoadOptions)
  {
    return loadSync(constructSingleLoadParam(paramString, paramLoadOptions));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl
 * JD-Core Version:    0.7.0.1
 */