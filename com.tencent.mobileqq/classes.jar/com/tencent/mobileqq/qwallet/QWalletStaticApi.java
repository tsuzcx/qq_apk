package com.tencent.mobileqq.qwallet;

import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.hb.IQWalletHbApi;

public class QWalletStaticApi
{
  public static String a()
  {
    try
    {
      String str = ((IQWalletHbApi)QRoute.api(IQWalletHbApi.class)).getQWalletHandlerClassName();
      return str;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.QWalletStaticApi
 * JD-Core Version:    0.7.0.1
 */