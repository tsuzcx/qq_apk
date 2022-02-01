package com.tencent.xweb;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Debug;
import com.tencent.luggage.wxa.su.g;
import com.tencent.luggage.wxa.su.h;
import com.tencent.luggage.wxa.su.m;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.c;
import java.util.Iterator;
import java.util.List;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class v
{
  private static v l;
  WebView.c a = WebView.c.a;
  boolean b = false;
  boolean c = false;
  boolean d = false;
  boolean e = false;
  boolean f = false;
  boolean g = false;
  boolean h = false;
  JsRuntime.JsRuntimeType i = JsRuntime.JsRuntimeType.a;
  boolean j = false;
  boolean k = false;
  private Context m;
  
  public static v a()
  {
    return l;
  }
  
  public static void a(Context paramContext)
  {
    if (l != null) {
      return;
    }
    l = new v();
    l.m = paramContext.getApplicationContext();
    XWalkEnvironment.init(paramContext);
    l.c = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowVersion", false);
    l.d = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowX5Version", false);
    l.e = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bShowSavePage", false);
    Object localObject1 = paramContext.getSharedPreferences("wcwebview", 0).getString("V8type", "RT_TYPE_AUTO");
    try
    {
      l.i = JsRuntime.JsRuntimeType.valueOf((String)localObject1);
      label121:
      l.b = XWalkEnvironment.getSharedPreferences().getBoolean("ENABLEREMOTEDEBUG", false);
      localObject1 = XWalkEnvironment.getTestDownLoadUrl(paramContext);
      Object localObject2 = l;
      boolean bool;
      if ((localObject1 != null) && (!((String)localObject1).isEmpty())) {
        bool = true;
      } else {
        bool = false;
      }
      ((v)localObject2).j = bool;
      l.g = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("bWaitforDebugger", false);
      localObject1 = l;
      if (((v)localObject1).g)
      {
        localObject1 = ((v)localObject1).b();
        if ((localObject1 != null) && (((String)localObject1).equals(XWalkEnvironment.getProcessName())))
        {
          Debug.waitForDebugger();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("strDebugProcess is ");
          ((StringBuilder)localObject2).append((String)localObject1);
          Log.w("WebDebugCfg", ((StringBuilder)localObject2).toString());
        }
      }
      l.h = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("ignore_crashwatch", false);
      l.k = paramContext.getSharedPreferences("wcwebview", 0).getBoolean("show_fps", false);
      return;
    }
    catch (Exception localException)
    {
      break label121;
    }
  }
  
  public WebView.c a(String paramString, boolean paramBoolean)
  {
    if ((paramString != null) && (!paramString.isEmpty()) && (this.m != null))
    {
      SharedPreferences localSharedPreferences = d();
      if (localSharedPreferences == null) {
        return WebView.c.a;
      }
      StringBuilder localStringBuilder;
      if (paramBoolean)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("ABTestWebView");
        localStringBuilder.append(paramString);
        paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
      }
      else
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("HardCodeWebView");
        localStringBuilder.append(paramString);
        paramString = localSharedPreferences.getString(localStringBuilder.toString(), "");
      }
      if ((paramString == null) || (paramString.isEmpty())) {}
    }
    try
    {
      this.a = WebView.c.valueOf(paramString);
    }
    catch (Exception paramString)
    {
      label142:
      break label142;
    }
    this.a = WebView.c.a;
    break label159;
    this.a = WebView.c.a;
    label159:
    return this.a;
    return WebView.c.a;
  }
  
  public String a(String[] paramArrayOfString, f.a parama)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return "";
      }
      Object localObject = this.m.getSharedPreferences("wcwebview", 4);
      if (localObject == null) {
        return "";
      }
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject == null) {
        return "";
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i2 = paramArrayOfString.length;
      int n = 0;
      while (n < i2)
      {
        String str1 = paramArrayOfString[n];
        String[] arrayOfString = f.a;
        int i3 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i3)
        {
          String str2 = arrayOfString[i1];
          if (str2.equalsIgnoreCase(str1))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("force_fr_");
            localStringBuilder2.append(str1.toLowerCase());
            ((SharedPreferences.Editor)localObject).putString(localStringBuilder2.toString(), parama.toString());
            localStringBuilder1.append(str2);
            localStringBuilder1.append(",");
          }
          i1 += 1;
        }
        n += 1;
      }
      if (((SharedPreferences.Editor)localObject).commit()) {
        return localStringBuilder1.toString();
      }
    }
    return "";
  }
  
  public String a(String[] paramArrayOfString, f.b paramb)
  {
    if (paramArrayOfString != null)
    {
      if (paramArrayOfString.length == 0) {
        return "";
      }
      Object localObject = this.m.getSharedPreferences("wcwebview", 4);
      if (localObject == null) {
        return "";
      }
      localObject = ((SharedPreferences)localObject).edit();
      if (localObject == null) {
        return "";
      }
      StringBuilder localStringBuilder1 = new StringBuilder();
      int i2 = paramArrayOfString.length;
      int n = 0;
      while (n < i2)
      {
        String str1 = paramArrayOfString[n];
        String[] arrayOfString = f.a;
        int i3 = arrayOfString.length;
        int i1 = 0;
        while (i1 < i3)
        {
          String str2 = arrayOfString[i1];
          if (str2.equalsIgnoreCase(str1))
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("force_use_office_reader_");
            localStringBuilder2.append(str1.toLowerCase());
            ((SharedPreferences.Editor)localObject).putString(localStringBuilder2.toString(), paramb.toString());
            localStringBuilder1.append(str2);
            localStringBuilder1.append(",");
          }
          i1 += 1;
        }
        n += 1;
      }
      if (((SharedPreferences.Editor)localObject).commit()) {
        return localStringBuilder1.toString();
      }
    }
    return "";
  }
  
  public void a(JsRuntime.JsRuntimeType paramJsRuntimeType)
  {
    if (this.i == paramJsRuntimeType) {
      return;
    }
    this.i = paramJsRuntimeType;
    this.m.getSharedPreferences("wcwebview", 0).edit().putString("V8type", paramJsRuntimeType.toString()).commit();
  }
  
  public void a(String paramString)
  {
    this.m.getSharedPreferences("wcwebview", 4).edit().putString("strDebugProcess", paramString).commit();
  }
  
  public void a(String paramString, WebView.c paramc)
  {
    if ((this.m != null) && (paramString != null))
    {
      if (paramString.isEmpty()) {
        return;
      }
      SharedPreferences.Editor localEditor = d().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("HardCodeWebView");
      localStringBuilder.append(paramString);
      localEditor.putString(localStringBuilder.toString(), paramc.toString()).commit();
    }
  }
  
  public void a(boolean paramBoolean)
  {
    this.g = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("bWaitforDebugger", paramBoolean).commit();
  }
  
  public WebView.c b(String paramString)
  {
    Object localObject;
    if ((paramString != null) && (!paramString.isEmpty()) && (this.m != null))
    {
      SharedPreferences localSharedPreferences = d();
      if (localSharedPreferences == null) {
        return WebView.c.a;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("HardCodeWebView");
      ((StringBuilder)localObject).append(paramString);
      String str = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
      if ((str != null) && (!str.isEmpty()))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("has hardcode type = ");
        ((StringBuilder)localObject).append(str);
        XWalkEnvironment.addXWalkInitializeLog(((StringBuilder)localObject).toString());
      }
      if ((str != null) && (!str.isEmpty()))
      {
        localObject = str;
        if (!str.equals(WebView.c.a.toString())) {}
      }
      else
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("ABTestWebView");
        ((StringBuilder)localObject).append(paramString);
        paramString = localSharedPreferences.getString(((StringBuilder)localObject).toString(), "");
        localObject = paramString;
        if (paramString != null)
        {
          localObject = paramString;
          if (!paramString.isEmpty())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("has abtest type = ");
            ((StringBuilder)localObject).append(paramString);
            XWalkEnvironment.addXWalkInitializeLog(((StringBuilder)localObject).toString());
            localObject = paramString;
          }
        }
      }
      if ((localObject == null) || (((String)localObject).isEmpty())) {}
    }
    try
    {
      this.a = WebView.c.valueOf((String)localObject);
    }
    catch (Exception paramString)
    {
      label241:
      break label241;
    }
    this.a = WebView.c.a;
    break label258;
    this.a = WebView.c.a;
    label258:
    return this.a;
    return WebView.c.a;
  }
  
  public String b()
  {
    return this.m.getSharedPreferences("wcwebview", 4).getString("strDebugProcess", "");
  }
  
  public void b(String paramString, WebView.c paramc)
  {
    if ((this.m != null) && (paramString != null))
    {
      if (paramString.isEmpty()) {
        return;
      }
      SharedPreferences.Editor localEditor = d().edit();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ABTestWebView");
      localStringBuilder.append(paramString);
      localEditor.putString(localStringBuilder.toString(), paramc.toString()).commit();
    }
  }
  
  public void b(boolean paramBoolean)
  {
    this.h = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("ignore_crashwatch", paramBoolean).commit();
  }
  
  public f.a c(String paramString)
  {
    SharedPreferences localSharedPreferences = this.m.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null) {
      return f.a.a;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("force_fr_");
    localStringBuilder.append(paramString.toLowerCase());
    return b.q(localSharedPreferences.getString(localStringBuilder.toString(), ""));
  }
  
  public void c(boolean paramBoolean)
  {
    if (paramBoolean == this.b) {
      return;
    }
    this.b = paramBoolean;
    XWalkEnvironment.getSharedPreferences().edit().putBoolean("ENABLEREMOTEDEBUG", paramBoolean).commit();
  }
  
  public boolean c()
  {
    return this.h;
  }
  
  public SharedPreferences d()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("xweb_debug");
  }
  
  public f.b d(String paramString)
  {
    try
    {
      SharedPreferences localSharedPreferences = this.m.getSharedPreferences("wcwebview", 4);
      if (localSharedPreferences == null) {
        return f.b.a;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("force_use_office_reader_");
      localStringBuilder.append(paramString.toLowerCase());
      paramString = b.p(localSharedPreferences.getString(localStringBuilder.toString(), ""));
      return paramString;
    }
    catch (Exception paramString)
    {
      Log.e("WebDebugCfg", "getForceUseOfficeReader error ", paramString);
    }
    return f.b.a;
  }
  
  public void d(boolean paramBoolean)
  {
    if (paramBoolean == this.k) {
      return;
    }
    this.k = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("show_fps", paramBoolean).commit();
  }
  
  public void e(boolean paramBoolean)
  {
    if (paramBoolean == this.c) {
      return;
    }
    this.c = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowVersion", this.c).commit();
  }
  
  public boolean e()
  {
    return this.b;
  }
  
  public void f(boolean paramBoolean)
  {
    if (paramBoolean == this.d) {
      return;
    }
    this.d = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowX5Version", this.d).commit();
  }
  
  public boolean f()
  {
    return this.k;
  }
  
  public void g(boolean paramBoolean)
  {
    if (paramBoolean == this.e) {
      return;
    }
    this.e = paramBoolean;
    this.m.getSharedPreferences("wcwebview", 0).edit().putBoolean("bShowSavePage", this.e).commit();
  }
  
  public boolean g()
  {
    return this.c;
  }
  
  public void h(boolean paramBoolean)
  {
    Object localObject1 = this.m.getSharedPreferences("wcwebview", 4);
    if (localObject1 == null) {
      return;
    }
    localObject1 = ((SharedPreferences)localObject1).edit();
    if (localObject1 == null) {
      return;
    }
    ((SharedPreferences.Editor)localObject1).putBoolean("fr_disable_cache", paramBoolean);
    ((SharedPreferences.Editor)localObject1).commit();
    if (paramBoolean)
    {
      localObject1 = h.b().iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (g)((Iterator)localObject1).next();
        if ((localObject2 instanceof m))
        {
          int n = ((g)localObject2).a(true);
          if (n >= 0)
          {
            localObject2 = ((g)localObject2).c(n);
            if (!((String)localObject2).isEmpty()) {
              c.b((String)localObject2);
            }
          }
        }
      }
    }
  }
  
  public boolean h()
  {
    return this.e;
  }
  
  public void i(boolean paramBoolean)
  {
    Object localObject = this.m.getSharedPreferences("wcwebview", 4);
    if (localObject == null) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    if (localObject == null) {
      return;
    }
    ((SharedPreferences.Editor)localObject).putBoolean("fr_disable_crash_detect", paramBoolean);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public boolean i()
  {
    return this.d;
  }
  
  public void j(boolean paramBoolean)
  {
    if (paramBoolean == this.j) {
      return;
    }
    this.j = paramBoolean;
    if (this.j)
    {
      if (XWalkEnvironment.isIaDevice()) {
        XWalkEnvironment.setTestDownLoadUrl(this.m, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_x86_test.xml");
      } else {
        XWalkEnvironment.setTestDownLoadUrl(this.m, "https://dldir1.qq.com/weixin/android/wxweb/updateConfig_test.xml");
      }
      localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
      localEditor.putLong("nLastFetchConfigTime", 0L);
      localEditor.commit();
      l.a(WebView.c.b).excute("STR_CMD_CLEAR_SCHEDULER", null);
      return;
    }
    XWalkEnvironment.setTestDownLoadUrl(this.m, "");
    SharedPreferences.Editor localEditor = XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit();
    localEditor.putLong("nLastFetchConfigTime", 0L);
    localEditor.commit();
    l.a(WebView.c.b).excute("STR_CMD_CLEAR_SCHEDULER", null);
  }
  
  public boolean j()
  {
    SharedPreferences localSharedPreferences = this.m.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.getBoolean("fr_disable_cache", false);
  }
  
  public void k(boolean paramBoolean)
  {
    XWalkEnvironment.initTurnOnKVLog();
    this.m.getSharedPreferences("wcwebview", 4).edit().putBoolean("m_bEnableLocalDebug", paramBoolean).commit();
  }
  
  public boolean k()
  {
    SharedPreferences localSharedPreferences = this.m.getSharedPreferences("wcwebview", 4);
    if (localSharedPreferences == null) {
      return false;
    }
    return localSharedPreferences.getBoolean("fr_disable_crash_detect", false);
  }
  
  public JsRuntime.JsRuntimeType l()
  {
    return this.i;
  }
  
  public boolean m()
  {
    return this.j;
  }
  
  public boolean n()
  {
    return this.m.getSharedPreferences("wcwebview", 4).getBoolean("m_bEnableLocalDebug", false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.v
 * JD-Core Version:    0.7.0.1
 */