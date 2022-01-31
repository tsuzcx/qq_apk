package com.tencent.tvkbeacon.core;

import android.annotation.SuppressLint;
import android.content.Context;
import com.tencent.tvkbeacon.core.b.h;
import com.tencent.tvkbeacon.core.c.c;
import com.tencent.tvkbeacon.upload.UploadStrategy;

public class BeaconIdJNI
{
  public static String a(Context paramContext, int paramInt)
  {
    int j = 0;
    for (;;)
    {
      try
      {
        if ((!h.a(paramContext).a()) || (!UploadStrategy.DEFAULT_BEACON_ID_ENABLE))
        {
          paramContext = "";
          return paramContext;
        }
        try
        {
          a();
          paramContext = c(paramInt);
          if (paramContext != null) {
            break label317;
          }
          paramContext = "";
        }
        catch (UnsatisfiedLinkError paramContext)
        {
          try
          {
            a();
            paramContext = c(paramInt);
          }
          catch (Throwable paramContext)
          {
            c.d("[beaconId] libBeacon.so load failed!", new Object[0]);
            paramContext = null;
          }
          continue;
        }
        catch (Throwable paramContext)
        {
          c.d("[beaconId] libBeacon.so load failed!", new Object[0]);
          paramContext = null;
          continue;
        }
        int i = j;
        if (paramInt < paramContext.length)
        {
          if (paramContext[paramInt] != null) {
            break label322;
          }
          paramContext[paramInt] = "";
          break label322;
        }
        if (i < paramContext.length)
        {
          paramContext[i] = paramContext[i].trim().replace(" ", "").replace("\t", "").replace("&", "").replace(":", "").replace("=", "").replace(";", "");
          i += 1;
          continue;
        }
        paramContext = new StringBuilder("k1:").append(paramContext[0]).append(";k2:").append(paramContext[1]).append(";k3:").append(paramContext[2]).append(";k4:").append(paramContext[3]).append(";k5:").append(paramContext[4]).append(";k6:").append(paramContext[5]).append(";k7:").append(paramContext[6]).append(";k8:").append(paramContext[7]).append(";k9:").append(paramContext[8]).append(";k10:1");
        c.b("[BeaconId] %s", new Object[] { paramContext.toString() });
        paramContext = paramContext.toString();
        continue;
        paramInt = 0;
      }
      finally {}
      label317:
      continue;
      label322:
      paramInt += 1;
    }
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private static void a()
  {
    try
    {
      System.loadLibrary("Qimei");
      return;
    }
    catch (Throwable localThrowable)
    {
      c.d("[beaconId] no libQimei.so!", new Object[0]);
      System.loadLibrary("Beacon");
    }
  }
  
  public static native String[] c(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.BeaconIdJNI
 * JD-Core Version:    0.7.0.1
 */