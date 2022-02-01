package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import com.tencent.mobileqq.soload.biz.entity.LoadParam.LoadItem;
import java.util.Iterator;
import java.util.List;

public class MultiSoLoader
  implements ISoLoader
{
  private LoadExtResult a;
  private SoLoaderLogic b;
  
  private LoadParam a(LoadParam paramLoadParam, LoadParam.LoadItem paramLoadItem)
  {
    LoadParam localLoadParam = new LoadParam();
    localLoadParam.mLoadItems.add(paramLoadItem);
    localLoadParam.mReportSeq = paramLoadParam.mReportSeq;
    localLoadParam.mCallType = paramLoadParam.mCallType;
    localLoadParam.commonFlag = paramLoadParam.commonFlag;
    return localLoadParam;
  }
  
  private void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener, int paramInt)
  {
    LoadParam localLoadParam = a(paramLoadParam, (LoadParam.LoadItem)paramLoadParam.mLoadItems.get(paramInt));
    this.b = new SoLoaderLogic();
    this.b.a(localLoadParam, new MultiSoLoader.1(this, paramInt, paramLoadParam, paramOnLoadListener));
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Iterator localIterator = paramLoadParam.mLoadItems.iterator();
    Object localObject = null;
    while (localIterator.hasNext())
    {
      localObject = a(paramLoadParam, (LoadParam.LoadItem)localIterator.next());
      this.b = new SoLoaderLogic();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.b.a((LoadParam)localObject), this.a);
      this.a = localLoadExtResult;
      localObject = localLoadExtResult;
      if (localLoadExtResult.getResultCode() != 0) {
        localObject = localLoadExtResult;
      }
    }
    return localObject;
  }
  
  public void a(LoadParam paramLoadParam, OnLoadListener paramOnLoadListener)
  {
    a(paramLoadParam, paramOnLoadListener, 0);
  }
  
  public boolean a(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.b;
    if (localSoLoaderLogic != null) {
      return localSoLoaderLogic.a(paramString);
    }
    return false;
  }
  
  public void b(String paramString)
  {
    SoLoaderLogic localSoLoaderLogic = this.b;
    if (localSoLoaderLogic != null) {
      localSoLoaderLogic.b(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.MultiSoLoader
 * JD-Core Version:    0.7.0.1
 */