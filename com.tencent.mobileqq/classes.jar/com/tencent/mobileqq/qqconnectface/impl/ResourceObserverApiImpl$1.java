package com.tencent.mobileqq.qqconnectface.impl;

import com.tencent.mobileqq.identification.IResourceObserver;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.download.old.AEOldShortVideoResStatus.ISVConfig;

class ResourceObserverApiImpl$1
  implements AEOldShortVideoResStatus.ISVConfig
{
  ResourceObserverApiImpl$1(ResourceObserverApiImpl paramResourceObserverApiImpl, IResourceObserver paramIResourceObserver) {}
  
  public void a(int paramInt1, int paramInt2)
  {
    QLog.d("ResourceObserverApiImpl", 1, new Object[] { "onConfigResult | result = ", Integer.valueOf(paramInt1), ",serverError = ", Integer.valueOf(paramInt2) });
    if (ResourceObserverApiImpl.access$000(this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplResourceObserverApiImpl, paramInt1, paramInt2))
    {
      ResourceObserverApiImpl.access$100(this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplResourceObserverApiImpl, this.jdField_a_of_type_ComTencentMobileqqIdentificationIResourceObserver, paramInt2);
      return;
    }
    ResourceObserverApiImpl.access$200(this.jdField_a_of_type_ComTencentMobileqqQqconnectfaceImplResourceObserverApiImpl, this.jdField_a_of_type_ComTencentMobileqqIdentificationIResourceObserver, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qqconnectface.impl.ResourceObserverApiImpl.1
 * JD-Core Version:    0.7.0.1
 */