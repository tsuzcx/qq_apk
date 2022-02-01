package com.tencent.mobileqq.qwallet.preload.impl;

import com.tencent.mobileqq.qwallet.preload.IPreloadService.FlowControlObj;
import java.lang.ref.WeakReference;

class PreloadServiceImpl$8$1
  implements Runnable
{
  PreloadServiceImpl$8$1(PreloadServiceImpl.8 param8, WeakReference paramWeakReference, IPreloadService.FlowControlObj paramFlowControlObj) {}
  
  public void run()
  {
    PreloadServiceImpl localPreloadServiceImpl = (PreloadServiceImpl)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (PreloadServiceImpl.isManagerValid(localPreloadServiceImpl)) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletPreloadIPreloadService$FlowControlObj.a(localPreloadServiceImpl);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.preload.impl.PreloadServiceImpl.8.1
 * JD-Core Version:    0.7.0.1
 */