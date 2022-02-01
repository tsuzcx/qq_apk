package com.tencent.mobileqq.soload.api.impl;

import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.soload.api.ISoloadService;
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
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import mqq.os.MqqHandler;

public class SoloadServiceImpl
  implements ISoloadService
{
  private static final Map<LoadParam, List<OnLoadListener>> LINSTER_IN_LOADING = new HashMap();
  public static final Map<LoadParam, ISoLoader> LOADER_IN_LOADING = new HashMap();
  private static final String TAG = "SoLoadWidget.SoloadServiceImpl";
  private final Set<LoadParam> mCurDelayTokens = new HashSet();
  
  private static void addLoadingLoader(LoadParam paramLoadParam, ISoLoader paramISoLoader)
  {
    if ((paramLoadParam == null) || (paramISoLoader == null)) {
      return;
    }
    synchronized (LOADER_IN_LOADING)
    {
      LOADER_IN_LOADING.put(paramLoadParam, paramISoLoader);
      return;
    }
  }
  
  private OnLoadListener constructInnerListener(LoadParam paramLoadParam, long paramLong)
  {
    return new SoloadServiceImpl.3(this, paramLoadParam);
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
        if (TextUtils.isEmpty(str))
        {
          i += 1;
        }
        else
        {
          if ((paramArrayOfLoadOptions != null) && (paramArrayOfLoadOptions.length > i)) {}
          for (LoadOptions localLoadOptions = paramArrayOfLoadOptions[i];; localLoadOptions = null)
          {
            localLoadParam.addItem(str, localLoadOptions);
            break;
          }
        }
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
    for (;;)
    {
      synchronized (LINSTER_IN_LOADING)
      {
        localObject1 = LINSTER_IN_LOADING.entrySet().iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break label255;
        }
        Object localObject2 = (Map.Entry)((Iterator)localObject1).next();
        LoadParam localLoadParam = (LoadParam)((Map.Entry)localObject2).getKey();
        if ((localLoadParam == null) || (!localLoadParam.isSame(paramLoadParam))) {
          continue;
        }
        if (localLoadParam.isOverTime())
        {
          localObject2 = (List)((Map.Entry)localObject2).getValue();
          ((Iterator)localObject1).remove();
          localObject1 = localObject2;
          if (QLog.isColorLevel())
          {
            QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "[getSameParamInLoad] isOverTime:" + localObject2);
            localObject1 = localObject2;
          }
          localObject2 = new LinkedList();
          ((LinkedList)localObject2).add(paramOnLoadListener);
          paramLoadParam.mLoadTime = NetConnInfoCenter.getServerTimeMillis();
          LINSTER_IN_LOADING.put(paramLoadParam, localObject2);
          if (localObject1 != null)
          {
            paramOnLoadListener = ((List)localObject1).iterator();
            if (paramOnLoadListener.hasNext())
            {
              localObject1 = (OnLoadListener)paramOnLoadListener.next();
              if (localObject1 == null) {
                continue;
              }
              ((OnLoadListener)localObject1).onLoadResult(7, LoadExtResult.create(7, LoadParam.getItemSize(paramLoadParam)));
              continue;
            }
          }
        }
        else
        {
          ((List)((Map.Entry)localObject2).getValue()).add(paramOnLoadListener);
          return localLoadParam;
        }
      }
      return null;
      label255:
      Object localObject1 = null;
    }
  }
  
  private static ISoLoader getSoLoader(LoadParam paramLoadParam)
  {
    if ((paramLoadParam != null) && (paramLoadParam.mLoadItems.size() > 1)) {
      return new MultiSoLoader();
    }
    return new SingleSoLoader();
  }
  
  private static void handleLoadResult(int paramInt, LoadExtResult paramLoadExtResult, long paramLong, OnLoadListener paramOnLoadListener, LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "[LoadResult] resCode：" + paramInt);
    }
    int i;
    if (paramLoadExtResult != null)
    {
      i = paramLoadExtResult.getReportCode();
      if (paramLoadExtResult == null) {
        break label127;
      }
    }
    label127:
    for (String str = paramLoadExtResult.getReportStr();; str = "")
    {
      if (paramInt != 0) {
        SoReportUtil.a(paramLoadParam, paramLong, "load.end", str, i, null);
      }
      if (paramOnLoadListener != null) {
        paramOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
      }
      removeLoadingLoader(paramLoadParam);
      if (!LoadParam.isCloseReport(paramLoadParam)) {
        SoReportUtil.a(null, "dc00899", "SoLoad", "", "resStat", "resReport", 0, i, str, "", "", "");
      }
      return;
      i = 0;
      break;
    }
  }
  
  private void handleLoadSyncFail(LoadExtResult arg1, LoadParam paramLoadParam)
  {
    paramLoadParam.mCallType = LoadParam.CALL_TYPE_ASYNC_BY_SYNC;
    long l = ???.getDelayAyncTime();
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "[handleLoadSyncFail]delayTime:" + l);
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
    }
    ThreadManager.getSubThreadHandler().postAtTime(new SoloadServiceImpl.1(this, paramLoadParam), paramLoadParam, l + NetConnInfoCenter.getServerTimeMillis());
    this.mCurDelayTokens.add(paramLoadParam);
  }
  
  private void load(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    boolean bool = true;
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "load loadParam=" + paramLoadParam);
    }
    long l = SoReportUtil.a(paramLoadParam);
    paramOnLoadListener = new SoloadServiceImpl.ReportListener(paramOnLoadListener, l, paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam))
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
      localObject = new StringBuilder().append("load isSameParamInLoad=");
      if (paramOnLoadListener == null) {
        break label189;
      }
    }
    for (;;)
    {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, bool);
      if (paramOnLoadListener == null) {
        break;
      }
      SoReportUtil.a(paramLoadParam, l, null, "load.join.same.queue", "first=" + paramOnLoadListener.mReportSeq, 0, null);
      return;
      label189:
      bool = false;
    }
    paramOnLoadListener = constructInnerListener(paramLoadParam, l);
    Object localObject = getSoLoader(paramLoadParam);
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "load getSoLoader=" + localObject);
    }
    addLoadingLoader(paramLoadParam, (ISoLoader)localObject);
    ((ISoLoader)localObject).a(paramLoadParam, paramOnLoadListener);
  }
  
  private void loadAsync(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    ThreadManager.excute(new SoloadServiceImpl.2(this, paramLoadParam, paramOnLoadListener), 16, null, false);
  }
  
  private LoadExtResult loadSync(LoadParam paramLoadParam)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SoLoadWidget.SoloadServiceImpl", 2, "loadSync loadParam=" + paramLoadParam);
    }
    long l = SoReportUtil.a(paramLoadParam);
    if (!LoadParam.isValid(paramLoadParam)) {}
    for (Object localObject = LoadExtResult.create(1, LoadParam.getItemSize(paramLoadParam));; localObject = ((ISoLoader)localObject).a(paramLoadParam))
    {
      handleLoadResult(((LoadExtResult)localObject).getResultCode(), (LoadExtResult)localObject, l, null, paramLoadParam);
      if (((LoadExtResult)localObject).isNeedRetry(paramLoadParam)) {
        handleLoadSyncFail((LoadExtResult)localObject, paramLoadParam);
      }
      return localObject;
      localObject = getSoLoader(paramLoadParam);
      paramLoadParam.mCallType = LoadParam.CALL_TYPE_SYNC;
      addLoadingLoader(paramLoadParam, (ISoLoader)localObject);
    }
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
    load(paramString, paramOnLoadListener, new LoadOptions.LoadOptionsBuilder().a(true).a());
  }
  
  public void download(String[] paramArrayOfString, OnLoadListener paramOnLoadListener)
  {
    int j = 0;
    if (paramArrayOfString == null) {}
    Object localObject;
    for (int i = 0;; i = paramArrayOfString.length)
    {
      localObject = null;
      if (i <= 0) {
        break;
      }
      LoadOptions[] arrayOfLoadOptions = new LoadOptions[i];
      for (;;)
      {
        localObject = arrayOfLoadOptions;
        if (j >= i) {
          break;
        }
        arrayOfLoadOptions[j] = new LoadOptions.LoadOptionsBuilder().a(true).a();
        j += 1;
      }
    }
    loadSequentially(paramArrayOfString, paramOnLoadListener, localObject);
  }
  
  public List<String> getCurInitSoList()
  {
    return DownSoLoader.a();
  }
  
  public String getInitVer(String paramString)
  {
    return DownSoLoader.a(paramString);
  }
  
  public void getSoLoadInfoTaskAsync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    new GetSoLoadInfoTaskAsync(paramLoadParam, paramLoadItem).a(paramOnGetSoLoadInfoListener);
  }
  
  public SoLoadInfo getSoLoadInfoTaskSync(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    return new GetSoLoadInfoTaskSync(paramLoadParam, paramLoadItem).a();
  }
  
  public String getSoVer(String paramString)
  {
    String str = loadSync(paramString, new LoadOptions.LoadOptionsBuilder().a(true).b(true).c(true).d(true).a()).getVer();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoloadServiceImpl
 * JD-Core Version:    0.7.0.1
 */