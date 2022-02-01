package com.tencent.turingfd.sdk.xq;

import android.app.Activity;
import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class TuringFdService
{
  public static TuringFdService.ITuringDID a(goto paramgoto)
  {
    return new Mandarin(paramgoto);
  }
  
  public static void checkApk(Map<Integer, IteApkInfoReq> paramMap, IteApkInfoRespCallback paramIteApkInfoRespCallback)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashMap.put(localInteger, (instanceof)paramMap.get(localInteger));
    }
    paramMap = new Mango(paramIteApkInfoRespCallback);
    int i = const.F();
    if (i != 0)
    {
      paramMap.a(i, new HashMap());
      return;
    }
    new class(localHashMap, paramMap).start();
  }
  
  public static TuringFdService.ITuringDID getTuringDID(Context paramContext)
  {
    return a(const.o(paramContext));
  }
  
  public static void getTuringDIDAsync(Context paramContext, TuringFdService.ITuringDIDCallback paramITuringDIDCallback)
  {
    if (paramITuringDIDCallback == null) {
      return;
    }
    const.a(paramContext, new Loquat(paramITuringDIDCallback));
  }
  
  public static TuringFdService.ITuringDID getTuringDIDCached(Context paramContext)
  {
    int i = const.F();
    if (i != 0)
    {
      paramContext = Bilberry.g(i);
    }
    else
    {
      Bullace localBullace = Bullace.Tg;
      Bilberry localBilberry = localBullace.C(paramContext);
      if (localBullace.Rh == null)
      {
        paramContext = Bilberry.g(-10002);
      }
      else
      {
        i = localBullace.a(localBilberry);
        if (i == 1)
        {
          paramContext = localBilberry;
        }
        else if (i == 2)
        {
          localBullace.V();
          paramContext = Bilberry.g(-10009);
        }
        else
        {
          paramContext = localBilberry;
          if (i == 3)
          {
            localBullace.V();
            paramContext = localBilberry;
          }
        }
      }
    }
    return a(paramContext);
  }
  
  public static String getVersionInfo()
  {
    return const.getVersionInfo();
  }
  
  public static void init(TuringFdConfig paramTuringFdConfig)
  {
    const.a(paramTuringFdConfig);
  }
  
  public static boolean removeScene(Activity paramActivity)
  {
    try
    {
      boolean bool = const.removeScene(paramActivity);
      return bool;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
  
  public static boolean setScene(Activity paramActivity)
  {
    try
    {
      boolean bool = const.setScene(paramActivity);
      return bool;
    }
    finally
    {
      paramActivity = finally;
      throw paramActivity;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringFdService
 * JD-Core Version:    0.7.0.1
 */