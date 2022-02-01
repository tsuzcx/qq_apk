package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.ICmdManager;
import com.tencent.vas.update.callback.listener.ICmdListener;

public class VasCmdManagerImpl
  implements ICmdManager
{
  IVasApolloExtensionHandler jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasApolloExtensionHandler;
  private ICmdListener jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener;
  
  public ICmdListener a()
  {
    return this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener;
  }
  
  public void a(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasApolloExtensionHandler = paramIVasApolloExtensionHandler;
  }
  
  public boolean sendPbRequest(String paramString1, String paramString2, ICmdListener paramICmdListener)
  {
    this.jdField_a_of_type_ComTencentVasUpdateCallbackListenerICmdListener = paramICmdListener;
    if (this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasApolloExtensionHandler != null) {
      return this.jdField_a_of_type_ComTencentMobileqqVasUpdatesystemApiIVasApolloExtensionHandler.requestQuickUpdate(paramString1, paramString2);
    }
    QLog.e("VasUpdate_VasCmdManagerImpl", 1, "sendPbRequest mRequestHandler = null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasCmdManagerImpl
 * JD-Core Version:    0.7.0.1
 */