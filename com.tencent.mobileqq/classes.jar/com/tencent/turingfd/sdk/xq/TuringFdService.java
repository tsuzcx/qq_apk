package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class TuringFdService
{
  public static TuringFdService.ITuringDID a(goto paramgoto)
  {
    return new Dew(paramgoto);
  }
  
  public static void checkApk(Map<Integer, IteApkInfoReq> paramMap, IteApkInfoRespCallback paramIteApkInfoRespCallback)
  {
    HashMap localHashMap = new HashMap();
    Iterator localIterator = paramMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Integer localInteger = (Integer)localIterator.next();
      localHashMap.put(localInteger, (interface)paramMap.get(localInteger));
    }
    paramMap = new Durian(paramIteApkInfoRespCallback);
    int i = class.u();
    if (i != 0)
    {
      paramMap.onResult(i, new HashMap());
      return;
    }
    new catch(localHashMap, paramMap).start();
  }
  
  public static TuringFdService.ITuringDID getTuringDID(Context paramContext)
  {
    return a(class.g(paramContext));
  }
  
  public static void getTuringDIDAsync(Context paramContext, TuringFdService.ITuringDIDCallback paramITuringDIDCallback)
  {
    if (paramITuringDIDCallback == null) {
      return;
    }
    class.a(paramContext, new Date(paramITuringDIDCallback));
  }
  
  public static TuringFdService.ITuringDID getTuringDIDCached(Context paramContext)
  {
    int i = class.u();
    if (i != 0) {
      paramContext = Serpens.f(i);
    }
    for (;;)
    {
      return a(paramContext);
      UrsaMajor localUrsaMajor = UrsaMajor.zg;
      Serpens localSerpens = localUrsaMajor.p(paramContext);
      i = localUrsaMajor.a(localSerpens);
      paramContext = localSerpens;
      if (i != 1) {
        if (i == 2)
        {
          localUrsaMajor.I();
          paramContext = Serpens.f(-10009);
        }
        else
        {
          paramContext = localSerpens;
          if (i == 3)
          {
            localUrsaMajor.I();
            paramContext = localSerpens;
          }
        }
      }
    }
  }
  
  public static String getVersionInfo()
  {
    return class.getVersionInfo();
  }
  
  public static void init(TuringFdConfig paramTuringFdConfig)
  {
    class.a(paramTuringFdConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringFdService
 * JD-Core Version:    0.7.0.1
 */