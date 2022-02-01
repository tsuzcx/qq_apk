package com.tencent.tfd.sdk.wxa;

import android.content.Context;

public class TuringDIDService
{
  public static ITuringDID a(long paramlong)
  {
    return new else(paramlong);
  }
  
  public static ITuringDID getTuringDID(Context paramContext)
  {
    int i = class.D();
    if (i != 0) {
      paramContext = instanceof.g(i);
    } else {
      paramContext = Ara.ad.a(paramContext, true);
    }
    return a(paramContext);
  }
  
  public static void getTuringDIDAsync(Context paramContext, ITuringDIDCallback paramITuringDIDCallback)
  {
    if (paramITuringDIDCallback == null) {
      return;
    }
    class.a(paramContext, new char(paramITuringDIDCallback));
  }
  
  public static ITuringDID getTuringDIDCached(Context paramContext)
  {
    int i = class.D();
    if (i != 0)
    {
      paramContext = instanceof.g(i);
    }
    else
    {
      Ara localAra = Ara.ad;
      instanceof localinstanceof = localAra.t(paramContext);
      if (localAra.ed == null)
      {
        paramContext = instanceof.g(-10002);
      }
      else
      {
        i = localAra.a(localinstanceof);
        if (i == 1)
        {
          paramContext = localinstanceof;
        }
        else if (i == 2)
        {
          localAra.H();
          paramContext = instanceof.g(-10009);
        }
        else
        {
          paramContext = localinstanceof;
          if (i == 3)
          {
            localAra.H();
            paramContext = localinstanceof;
          }
        }
      }
    }
    return a(paramContext);
  }
  
  public static String getVersionInfo()
  {
    return class.getVersionInfo();
  }
  
  public static void init(TuringDIDConfig paramTuringDIDConfig)
  {
    class.a(paramTuringDIDConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tfd.sdk.wxa.TuringDIDService
 * JD-Core Version:    0.7.0.1
 */