package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;

class SoloadServiceImpl$ReportListener
  implements OnLoadListener
{
  public long a;
  public OnLoadListener a;
  public LoadParam a;
  
  SoloadServiceImpl$ReportListener(OnLoadListener paramOnLoadListener, long paramLong, LoadParam paramLoadParam)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener = paramOnLoadListener;
    this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam = paramLoadParam;
  }
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    SoloadServiceImpl.access$200(paramInt, paramLoadExtResult, this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoloadServiceImpl.ReportListener
 * JD-Core Version:    0.7.0.1
 */