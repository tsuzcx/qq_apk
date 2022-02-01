package com.tencent.qmsp.sdk.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.qmsp.sdk.g.e.f;

public class e
  implements IVendorCallback
{
  private static boolean c = false;
  private static String d = "b2FpZA";
  private static String e = "b2FpZA";
  private static Context f;
  private b a = null;
  private IVendorCallback b = null;
  
  public static String a(Context paramContext, String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = null;
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject3;
    if (paramContext != null)
    {
      localObject1 = localObject3;
      try
      {
        if ((paramContext instanceof Context))
        {
          localObject1 = paramContext.getSharedPreferences(d, 0);
          paramContext = ((SharedPreferences)localObject1).getString(e, null);
          boolean bool = TextUtils.isEmpty(paramContext);
          if (!bool) {
            paramContext = new String(Base64.decode(paramContext.getBytes("UTF-8"), 0));
          } else {
            paramContext = null;
          }
          if (paramInt == 1) {
            try
            {
              if (c)
              {
                localEditor = ((SharedPreferences)localObject1).edit();
                localObject1 = localObject2;
                if (!TextUtils.isEmpty(paramString)) {
                  localObject1 = Base64.encodeToString(paramString.getBytes("UTF-8"), 0);
                }
                localEditor.putString(e, (String)localObject1);
                localEditor.commit();
              }
            }
            catch (Exception paramString)
            {
              break label159;
            }
          }
          return paramContext;
        }
      }
      catch (Exception paramString)
      {
        paramContext = localEditor;
        label159:
        paramString.printStackTrace();
        localObject1 = paramContext;
      }
    }
    return localObject1;
  }
  
  public static void a(Context paramContext)
  {
    if (paramContext != null) {
      try
      {
        if ((paramContext instanceof Context))
        {
          paramContext.getSharedPreferences(d, 0).edit().clear().commit();
          return;
        }
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public static void a(Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    c = paramBoolean1;
    f = paramContext;
    c.a(paramBoolean2);
  }
  
  public int a(IVendorCallback paramIVendorCallback)
  {
    this.b = paramIVendorCallback;
    paramIVendorCallback = d.a(Build.MANUFACTURER);
    if (paramIVendorCallback == d.b)
    {
      onResult(false, null, null);
      return a.a;
    }
    switch (e.a.a[paramIVendorCallback.ordinal()])
    {
    default: 
      break;
    case 14: 
    case 15: 
    case 16: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.d.e();
      break;
    case 13: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.f.a();
      break;
    case 11: 
    case 12: 
      paramIVendorCallback = new f();
      break;
    case 10: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.h.c();
      break;
    case 9: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.a.c();
      break;
    case 7: 
    case 8: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.c.b();
      break;
    case 5: 
    case 6: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.g.c();
      break;
    case 4: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.b.c();
      break;
    case 3: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.i.b();
      break;
    case 1: 
    case 2: 
      paramIVendorCallback = new com.tencent.qmsp.sdk.g.j.a();
    }
    this.a = paramIVendorCallback;
    if (this.a == null)
    {
      c.b("vendorInfo == null");
      onResult(false, null, null);
      return a.b;
    }
    c.b("init");
    try
    {
      this.a.a(f, this);
      if (this.a.d()) {}
    }
    catch (Exception paramIVendorCallback)
    {
      label295:
      label344:
      label353:
      break label353;
    }
    try
    {
      this.a.c();
      return 0;
    }
    catch (Exception paramIVendorCallback)
    {
      break label295;
    }
    onResult(false, null, null);
    return a.c;
    c.b("sync");
    try
    {
      onResult(this.a.e(), this.a.b(), this.a.a());
      return 0;
    }
    catch (Exception paramIVendorCallback)
    {
      break label344;
    }
    onResult(false, null, null);
    return 0;
    onResult(false, null, null);
    return a.c;
  }
  
  public void onResult(boolean paramBoolean, String paramString1, String paramString2)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("vm onResult ");
    ((StringBuilder)localObject).append(paramBoolean);
    c.c(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString2)) {
      paramString2 = a(f, null, 0);
    } else {
      a(f, paramString2, 1);
    }
    localObject = this.b;
    if (localObject != null) {
      ((IVendorCallback)localObject).onResult(paramBoolean, paramString1, paramString2);
    }
    paramString1 = this.a;
    if (paramString1 != null) {
      paramString1.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qmsp.sdk.base.e
 * JD-Core Version:    0.7.0.1
 */