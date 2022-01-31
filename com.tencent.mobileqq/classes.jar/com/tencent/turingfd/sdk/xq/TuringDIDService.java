package com.tencent.turingfd.sdk.xq;

import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import android.util.SparseArray;

public class TuringDIDService
{
  public static ITuringDID a(byte parambyte)
  {
    return new Aquila(parambyte);
  }
  
  public static ITuringDID getTuringAIDTicket(Context paramContext)
  {
    int i = char.o();
    if (i != 0) {
      paramContext = public.c(i);
    }
    for (;;)
    {
      return a(paramContext);
      switch localswitch = switch.Yb;
      Object localObject = localswitch.hc;
      if ((localObject != null) && (!TextUtils.isEmpty(((public)localObject).Vb)))
      {
        paramContext = localswitch.hc;
      }
      else
      {
        localswitch.hc = localswitch.dc.w(paramContext);
        if (!TextUtils.isEmpty(localswitch.hc.Vb))
        {
          paramContext = localswitch.hc;
        }
        else
        {
          localObject = localswitch.dc.s(paramContext);
          if (!TextUtils.isEmpty((CharSequence)localObject))
          {
            localswitch.hc = public.f((String)localObject);
            paramContext = localswitch.hc;
          }
          else if (Looper.myLooper() == Looper.getMainLooper())
          {
            paramContext = public.c(-10008);
          }
          else
          {
            localObject = for.a();
            TuringDIDService.aa.c((SparseArray)localObject, paramContext);
            i = for.a((SparseArray)localObject);
            if (i != 0)
            {
              paramContext = public.c(i);
            }
            else
            {
              localObject = for.b((SparseArray)localObject);
              if (TextUtils.isEmpty((CharSequence)localObject))
              {
                paramContext = public.c(-10013);
              }
              else
              {
                localswitch.hc = public.f((String)localObject);
                localswitch.dc.a(paramContext, "301", (String)localObject);
                paramContext = localswitch.hc;
              }
            }
          }
        }
      }
    }
  }
  
  public static ITuringDID getTuringDID(Context paramContext)
  {
    int i = char.o();
    if (i != 0) {}
    for (paramContext = public.c(i);; paramContext = switch.Yb.m(paramContext)) {
      return a(paramContext);
    }
  }
  
  public static ITuringDID getTuringDIDCached(Context paramContext)
  {
    int i = char.o();
    if (i != 0) {
      paramContext = public.c(i);
    }
    for (;;)
    {
      return a(paramContext);
      switch localswitch = switch.Yb;
      public localpublic = localswitch.l(paramContext);
      i = localswitch.a(localpublic);
      paramContext = localpublic;
      if (i != 1) {
        if (i == 2)
        {
          localswitch.r();
          paramContext = public.c(-10009);
        }
        else
        {
          paramContext = localpublic;
          if (i == 3)
          {
            localswitch.r();
            paramContext = localpublic;
          }
        }
      }
    }
  }
  
  public static String getVersionInfo()
  {
    return char.getVersionInfo();
  }
  
  public static void init(TuringDIDConfig paramTuringDIDConfig)
  {
    char.a(paramTuringDIDConfig);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.turingfd.sdk.xq.TuringDIDService
 * JD-Core Version:    0.7.0.1
 */