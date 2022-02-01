package com.tencent.mobileqq.vas.updatesystem.impl;

import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;
import com.tencent.qphone.base.util.QLog;
import com.tencent.vas.update.callback.listener.ICmdListener;
import com.tencent.vas.update.factory.api.ICmdManager;

public class VasCmdManagerImpl
  implements ICmdManager
{
  IVasApolloExtensionHandler a;
  private ICmdListener b;
  
  public ICmdListener a()
  {
    return this.b;
  }
  
  public void a(IVasApolloExtensionHandler paramIVasApolloExtensionHandler)
  {
    this.a = paramIVasApolloExtensionHandler;
  }
  
  public boolean a(String paramString1, String paramString2, ICmdListener paramICmdListener)
  {
    this.b = paramICmdListener;
    paramICmdListener = this.a;
    if (paramICmdListener != null) {
      return paramICmdListener.requestQuickUpdate(paramString1, paramString2);
    }
    QLog.e("VasUpdate_VasCmdManagerImpl", 1, "sendPbRequest mRequestHandler = null");
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.impl.VasCmdManagerImpl
 * JD-Core Version:    0.7.0.1
 */