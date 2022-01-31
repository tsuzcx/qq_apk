package com.tmsdk.dual;

import android.content.Context;
import android.os.Handler;
import com.tmsdk.dual.sharkcpp.SharkCppProxy;
import dualsim.common.InitCallback;
import dualsim.common.OrderCheckResult;
import dualsim.common.PhoneGetResult;
import tmsdk.common.dual.l.Tlm;
import tmsdkdual.b;
import tmsdkdual.c;
import tmsdkdual.d;
import tmsdkdual.l;
import tmsdkdual.m;

public final class TMSDualSDKContext
{
  private static Context d;
  private int e = 3088;
  
  public static OrderCheckResult checkKingcardSyn(String paramString1, String paramString2)
  {
    return new d().a(getApplicaionContext(), paramString1, paramString2);
  }
  
  public static Context getApplicaionContext()
  {
    return d.getApplicationContext();
  }
  
  public static String getGuid()
  {
    return SharkCppProxy.getGuid();
  }
  
  public static PhoneGetResult getPhoneNumber()
  {
    return new b().d();
  }
  
  public static boolean init(Context paramContext, InitCallback paramInitCallback)
  {
    StringBuilder localStringBuilder = new StringBuilder().append("init(), context is null? ");
    if (paramContext == null) {}
    for (boolean bool = true;; bool = false)
    {
      m.b("TMDUALSDKContext", bool);
      if (paramContext != null) {
        break;
      }
      throw new RuntimeException("contxt is null when TMSDK init!");
    }
    try
    {
      d = paramContext.getApplicationContext();
      if (!l.a(paramContext.getApplicationContext(), "tmsdualcore"))
      {
        m.a("TMDUALSDKContext", "tmsdual so load failed ... ");
        return false;
      }
      if (!new Tlm().w())
      {
        m.a("TMDUALSDKContext", "============== TMSDual ============== Invaild signature checkForSignature! Please contact TMS(Tencent Mobile Secure) group.");
        return false;
      }
    }
    catch (Throwable paramContext)
    {
      m.a("TMDUALSDKContext", "tmsdual init UKNOWN Error!!");
      return false;
    }
    c.start();
    paramContext = new Handler(a.a());
    paramContext.post(new Runnable()
    {
      public void run()
      {
        m.b("TMDUALSDKContext", "startAsyn ... ");
        SharkCppProxy.sharkInit();
        if (this.f != null) {
          this.f.onInitFinished();
        }
        try
        {
          com.tmsdk.dual.sharkcpp.a.o().init();
          com.tmsdk.dual.sharkcpp.a.o().p();
          return;
        }
        catch (Throwable localThrowable) {}
      }
    });
    paramContext.postDelayed(new Runnable()
    {
      public void run()
      {
        a.a(true);
      }
    }, 4000L);
    return true;
  }
  
  public static void setTMSDKLogEnable(boolean paramBoolean)
  {
    m.c(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tmsdk.dual.TMSDualSDKContext
 * JD-Core Version:    0.7.0.1
 */