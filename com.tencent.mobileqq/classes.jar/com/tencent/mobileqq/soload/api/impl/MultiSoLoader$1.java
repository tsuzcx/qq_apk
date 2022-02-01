package com.tencent.mobileqq.soload.api.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;
import com.tencent.mobileqq.soload.biz.entity.LoadParam;
import java.util.List;

class MultiSoLoader$1
  implements OnLoadListener
{
  MultiSoLoader$1(MultiSoLoader paramMultiSoLoader, int paramInt, LoadParam paramLoadParam, OnLoadListener paramOnLoadListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    paramLoadExtResult = LoadExtResult.mergeExtResult(paramLoadExtResult, MultiSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplMultiSoLoader));
    MultiSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplMultiSoLoader, paramLoadExtResult);
    OnLoadListener localOnLoadListener;
    if (paramInt == 0)
    {
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam.mLoadItems.size() - 1)
      {
        localOnLoadListener = this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener;
        if (localOnLoadListener != null) {
          localOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
        }
      }
      else
      {
        MultiSoLoader.a(this.jdField_a_of_type_ComTencentMobileqqSoloadApiImplMultiSoLoader, this.jdField_a_of_type_ComTencentMobileqqSoloadBizEntityLoadParam, this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener, this.jdField_a_of_type_Int + 1);
      }
    }
    else
    {
      if (paramLoadExtResult != null) {
        paramLoadExtResult.setFailIndex(this.jdField_a_of_type_Int + 1);
      }
      localOnLoadListener = this.jdField_a_of_type_ComTencentMobileqqSoloadBizOnLoadListener;
      if (localOnLoadListener != null) {
        localOnLoadListener.onLoadResult(paramInt, paramLoadExtResult);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.MultiSoLoader.1
 * JD-Core Version:    0.7.0.1
 */