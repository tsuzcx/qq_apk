package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SharedPreferencesProxyManager
{
  static boolean a;
  static boolean b = false;
  private static SharedPreferencesProxyManager c = null;
  private static SharedPreferencesProxyManager.ISpLogCallback h;
  public static String sSystemSpExceptionMsg;
  private Map d = new ConcurrentHashMap(5);
  private Map e = new ConcurrentHashMap(5);
  private final Object[] f = new Object[8];
  private WeakReference g = null;
  
  static
  {
    a = false;
    sSystemSpExceptionMsg = null;
  }
  
  private SharedPreferencesProxyManager a(Context paramContext)
  {
    a(true, "SpManager", "init " + paramContext, null);
    if (paramContext == null)
    {
      a(true, "SpManager", "init context is null", new RuntimeException());
      if (a) {
        throw new RuntimeException("init context is null");
      }
    }
    if ((this.g == null) && (paramContext != null))
    {
      k.a(paramContext);
      this.g = new WeakReference(paramContext.getApplicationContext());
    }
    int i = 0;
    while (i < 8)
    {
      this.f[i] = new Object();
      i += 1;
    }
    return this;
  }
  
  static void a(String paramString1, String paramString2, Object paramObject)
  {
    if (h != null) {
      h.onIllegalModify(paramString1, paramString2, paramObject);
    }
  }
  
  private static void a(boolean paramBoolean, String paramString1, String paramString2, Exception paramException)
  {
    if (h != null) {
      h.printLog(true, paramString1, paramString2, paramException);
    }
  }
  
  static boolean a()
  {
    return h != null;
  }
  
  public static SharedPreferencesProxyManager getInstance()
  {
    if (c != null) {
      return c;
    }
    try
    {
      if (c == null) {
        c = new SharedPreferencesProxyManager();
      }
      return c;
    }
    finally {}
  }
  
  public static void setLogCallback(SharedPreferencesProxyManager.ISpLogCallback paramISpLogCallback)
  {
    h = paramISpLogCallback;
  }
  
  final SharedPreferences a(String paramString, int paramInt, boolean paramBoolean)
  {
    String str = paramString;
    if (paramString == null) {
      str = "null";
    }
    Map localMap;
    if (((paramInt & 0x4) == 4) && (!k.b)) {
      localMap = this.e;
    }
    for (;;)
    {
      SharedPreferences localSharedPreferences = (SharedPreferences)localMap.get(str);
      paramString = localSharedPreferences;
      int i;
      if (localSharedPreferences == null) {
        i = Math.abs(str.hashCode() % 8);
      }
      synchronized (this.f[i])
      {
        localSharedPreferences = (SharedPreferences)localMap.get(str);
        paramString = localSharedPreferences;
        if (localSharedPreferences == null)
        {
          paramString = new i(this.g, str, paramInt, paramBoolean);
          localMap.put(str, paramString);
        }
        return paramString;
        localMap = this.d;
      }
    }
  }
  
  public SharedPreferences getProxy(String paramString, int paramInt)
  {
    return a(paramString, paramInt, true);
  }
  
  public SharedPreferencesProxyManager init(Context paramContext)
  {
    try
    {
      paramContext = a(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public SharedPreferencesProxyManager init(Context paramContext, boolean paramBoolean)
  {
    try
    {
      a = paramBoolean;
      paramContext = a(paramContext);
      return paramContext;
    }
    finally
    {
      paramContext = finally;
      throw paramContext;
    }
  }
  
  public void onCrashStart()
  {
    b = true;
  }
  
  public void setCatLogEnabled(boolean paramBoolean) {}
  
  public void setTimeLogEnabled(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxyManager
 * JD-Core Version:    0.7.0.1
 */