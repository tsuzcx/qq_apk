package com.tencent.mobileqq.vas.updatesystem.api;

import com.tencent.mobileqq.qroute.QRouteApi;

public abstract interface IVasApolloExtensionHandler
  extends QRouteApi
{
  public abstract boolean requestQuickUpdate(String paramString1, String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.vas.updatesystem.api.IVasApolloExtensionHandler
 * JD-Core Version:    0.7.0.1
 */