package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

class SoLoaderServiceImpl$ReportListener
  implements OnLoadListener
{
  public long a;
  public OnLoadListener a;
  public LoadParam a;
  
  SoLoaderServiceImpl$ReportListener(OnLoadListener paramOnLoadListener, long paramLong, LoadParam paramLoadParam)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener = paramOnLoadListener;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam = paramLoadParam;
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    SoLoaderServiceImpl.access$300(paramInt, paramLoadExtResult, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoLoaderServiceImpl.ReportListener
 * JD-Core Version:    0.7.0.1
 */