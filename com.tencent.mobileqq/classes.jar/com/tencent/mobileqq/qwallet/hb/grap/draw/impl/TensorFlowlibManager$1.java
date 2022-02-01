package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.soload.biz.OnLoadListener;
import com.tencent.mobileqq.soload.biz.entity.LoadExtResult;

class TensorFlowlibManager$1
  implements OnLoadListener
{
  TensorFlowlibManager$1(TensorFlowlibManager paramTensorFlowlibManager, TensorFlowlibManager.OnInitLibListener paramOnInitLibListener) {}
  
  public void onLoadResult(int paramInt, LoadExtResult paramLoadExtResult)
  {
    if (paramInt == 0)
    {
      TensorFlowlibManager.a(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager, true);
      paramLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager$OnInitLibListener;
      if (paramLoadExtResult != null) {
        paramLoadExtResult.a(true);
      }
      return;
    }
    paramLoadExtResult = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager$OnInitLibListener;
    if (paramLoadExtResult != null) {
      paramLoadExtResult.a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.TensorFlowlibManager.1
 * JD-Core Version:    0.7.0.1
 */