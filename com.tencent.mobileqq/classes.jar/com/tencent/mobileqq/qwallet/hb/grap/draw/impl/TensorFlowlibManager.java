package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.mobileqq.soload.api.SoLoadManager;

public class TensorFlowlibManager
{
  private static volatile TensorFlowlibManager jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager;
  private boolean jdField_a_of_type_Boolean = false;
  
  public static TensorFlowlibManager a()
  {
    if (jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager == null) {
      try
      {
        if (jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager == null) {
          jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager = new TensorFlowlibManager();
        }
      }
      finally {}
    }
    return jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplTensorFlowlibManager;
  }
  
  public void a(TensorFlowlibManager.OnInitLibListener paramOnInitLibListener)
  {
    if (this.jdField_a_of_type_Boolean)
    {
      if (paramOnInitLibListener != null) {
        paramOnInitLibListener.a(true);
      }
      return;
    }
    SoLoadManager.getInstance().load("tensorflowlite_jni", new TensorFlowlibManager.1(this, paramOnInitLibListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.TensorFlowlibManager
 * JD-Core Version:    0.7.0.1
 */