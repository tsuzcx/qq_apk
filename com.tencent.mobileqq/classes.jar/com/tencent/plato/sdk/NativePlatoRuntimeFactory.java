package com.tencent.plato.sdk;

import android.content.Context;
import com.tencent.plato.IPlatoRuntime;
import com.tencent.plato.bridge.NativePlatoRuntime;
import java.util.HashMap;
import java.util.Map;

class NativePlatoRuntimeFactory
{
  private static final Map<String, PlatoRuntimeHolder> sRuntimeMap = new HashMap();
  
  static IPlatoRuntime getRuntime(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    try
    {
      PlatoRuntimeHolder localPlatoRuntimeHolder2 = (PlatoRuntimeHolder)sRuntimeMap.get(paramString1);
      PlatoRuntimeHolder localPlatoRuntimeHolder1 = localPlatoRuntimeHolder2;
      if (localPlatoRuntimeHolder2 == null)
      {
        localPlatoRuntimeHolder2 = (PlatoRuntimeHolder)sRuntimeMap.get(paramString1);
        localPlatoRuntimeHolder1 = localPlatoRuntimeHolder2;
        if (localPlatoRuntimeHolder2 == null)
        {
          localPlatoRuntimeHolder1 = new PlatoRuntimeHolder(paramContext, paramString1, paramString2, paramString3);
          sRuntimeMap.put(paramString1, localPlatoRuntimeHolder1);
        }
      }
      localPlatoRuntimeHolder1.incrementRef();
      paramContext = localPlatoRuntimeHolder1.platoRuntime;
      return paramContext;
    }
    finally {}
  }
  
  static void release(String paramString)
  {
    try
    {
      paramString = (PlatoRuntimeHolder)sRuntimeMap.get(paramString);
      if (paramString != null)
      {
        paramString.decrementRef();
        if (paramString.refCount == 0)
        {
          paramString.platoRuntime.destroyInstance();
          sRuntimeMap.remove(paramString.bundle);
        }
      }
      return;
    }
    finally {}
  }
  
  private static class PlatoRuntimeHolder
  {
    private final String bundle;
    private final NativePlatoRuntime platoRuntime;
    private int refCount = 0;
    
    PlatoRuntimeHolder(Context paramContext, String paramString1, String paramString2, String paramString3)
    {
      this.bundle = paramString1;
      this.platoRuntime = new NativePlatoRuntime(paramContext, paramString1, paramString2, paramString3);
    }
    
    void decrementRef()
    {
      this.refCount -= 1;
    }
    
    void incrementRef()
    {
      this.refCount += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.NativePlatoRuntimeFactory
 * JD-Core Version:    0.7.0.1
 */