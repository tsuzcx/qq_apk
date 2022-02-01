package com.tencent.mobileqq.vas;

import com.tencent.mobileqq.apollo.handler.IApolloExtensionHandler;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler;

class VasQuickUpdateManager$1
  implements IVasApolloExtensionHandler
{
  VasQuickUpdateManager$1(VasQuickUpdateManager paramVasQuickUpdateManager) {}
  
  public boolean requestQuickUpdate(String paramString1, String paramString2)
  {
    return ((IApolloExtensionHandler)this.this$0.app.getBusinessHandler(BusinessHandlerFactory.APOLLO_EXTENSION_HANDLER)).b(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.VasQuickUpdateManager.1
 * JD-Core Version:    0.7.0.1
 */