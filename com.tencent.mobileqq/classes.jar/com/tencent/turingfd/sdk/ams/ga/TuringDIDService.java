package com.tencent.turingfd.sdk.ams.ga;

import android.content.Context;

public class TuringDIDService
{
  public static ITuringDID a(char paramchar)
  {
    return new class(paramchar);
  }
  
  public static ITuringDID getTuringDID(Context paramContext)
  {
    int i = void.F();
    if (i != 0) {
      paramContext = implements.g(i);
    } else {
      paramContext = Ara.rd.a(paramContext, true);
    }
    return a(paramContext);
  }
  
  public static void getTuringDIDAsync(Context paramContext, ITuringDIDCallback paramITuringDIDCallback)
  {
    if (paramITuringDIDCallback == null) {
      return;
    }
    void.a(paramContext, new catch(paramITuringDIDCallback));
  }
  
  public static ITuringDID getTuringDIDCached(Context paramContext)
  {
    int i = void.F();
    if (i != 0)
    {
      paramContext = implements.g(i);
    }
    else
    {
      Ara localAra = Ara.rd;
      implements localimplements = localAra.t(paramContext);
      if (localAra.ud == null)
      {
        paramContext = implements.g(-10002);
      }
      else
      {
        i = localAra.a(localimplements);
        if (i == 1)
        {
          paramContext = localimplements;
        }
        else if (i == 2)
        {
          localAra.J();
          paramContext = implements.g(-10009);
        }
        else
        {
          paramContext = localimplements;
          if (i == 3)
          {
            localAra.J();
            paramContext = localimplements;
          }
        }
      }
    }
    return a(paramContext);
  }
  
  public static String getVersionInfo()
  {
    return void.getVersionInfo();
  }
  
  public static void init(TuringDIDConfig paramTuringDIDConfig)
  {
    void.a(paramTuringDIDConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.turingfd.sdk.ams.ga.TuringDIDService
 * JD-Core Version:    0.7.0.1
 */