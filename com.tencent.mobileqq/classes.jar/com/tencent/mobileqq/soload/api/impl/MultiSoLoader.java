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
  private DownSoLoader jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader;
  private LoadExtResult jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadExtResult;
  
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
    this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader = new DownSoLoader();
    this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader.a(localLoadParam, new MultiSoLoader.1(this, paramInt, paramLoadParam, paramOnLoadListener));
  }
  
  public LoadExtResult a(LoadParam paramLoadParam)
  {
    Object localObject = null;
    Iterator localIterator = paramLoadParam.mLoadItems.iterator();
    while (localIterator.hasNext())
    {
      localObject = a(paramLoadParam, (LoadParam.LoadItem)localIterator.next());
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader = new DownSoLoader();
      LoadExtResult localLoadExtResult = LoadExtResult.mergeExtResult(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader.a((LoadParam)localObject), this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadExtResult);
      this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadExtResult = localLoadExtResult;
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
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader != null) {
      this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader.a(paramString);
    }
  }
  
  public boolean a(String paramString)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplDownSoLoader.a(paramString);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.MultiSoLoader
 * JD-Core Version:    0.7.0.1
 */