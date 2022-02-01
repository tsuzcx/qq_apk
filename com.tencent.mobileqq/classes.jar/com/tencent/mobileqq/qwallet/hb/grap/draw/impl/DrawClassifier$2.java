package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import com.tencent.qphone.base.util.QLog;

class DrawClassifier$2
  implements TensorFlowlibManager.OnInitLibListener
{
  DrawClassifier$2(DrawClassifier paramDrawClassifier, DrawClassifier.OnClassifierInitListener paramOnClassifierInitListener) {}
  
  public void a(boolean paramBoolean)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("TensorFlow init:");
      ((StringBuilder)localObject).append(paramBoolean);
      QLog.d("DrawClassifier", 2, ((StringBuilder)localObject).toString());
    }
    if (paramBoolean)
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier;
      DrawClassifier.a((DrawClassifier)localObject, DrawClassifier.a((DrawClassifier)localObject), this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnClassifierInitListener, DrawClassifier.b(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier));
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDrawClassifier$OnClassifierInitListener;
    if (localObject != null) {
      ((DrawClassifier.OnClassifierInitListener)localObject).a(false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DrawClassifier.2
 * JD-Core Version:    0.7.0.1
 */