package com.tencent.xweb;

import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class b
  extends a
{
  static b f;
  
  public static void b(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    l().b(paramArrayOfa, paramString, false);
  }
  
  public static String c(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = l().b(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static f.b d(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("use_office_reader_");
    localStringBuilder.append(paramString1.toLowerCase());
    return p(c(localStringBuilder.toString(), paramString2));
  }
  
  public static f.a e(String paramString1, String paramString2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("fr_");
    localStringBuilder.append(paramString1.toLowerCase());
    return q(c(localStringBuilder.toString(), paramString2));
  }
  
  public static b l()
  {
    try
    {
      if (f == null)
      {
        f = new b();
        f.f();
      }
      b localb = f;
      return localb;
    }
    finally {}
  }
  
  public static void m()
  {
    try
    {
      Log.i("CommandCfgPlugin", "resetCommandCfgPlugin ");
      f = null;
      l();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static String n()
  {
    try
    {
      String str = l().h();
      return str;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getAbstractInfo error ", localException);
    }
    return "";
  }
  
  public static int o()
  {
    try
    {
      String str = c("setPluginConfigPeriod", "tools");
      if (str != null)
      {
        if (str.isEmpty()) {
          return -1;
        }
        int i = Integer.parseInt(str);
        if (i < 30) {
          return -1;
        }
        return i * 60 * 1000;
      }
      return -1;
    }
    catch (Exception localException)
    {
      Log.e("CommandCfgPlugin", "getCmdPluginUpdatePeriod error: ", localException);
    }
    return -1;
  }
  
  public static String o(String paramString)
  {
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    return c(paramString, str1);
  }
  
  public static f.b p(String paramString)
  {
    f.b localb = f.b.a;
    if (paramString != null) {
      if (paramString.isEmpty()) {
        return localb;
      }
    }
    try
    {
      paramString = f.b.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    return f.b.a;
    return localb;
  }
  
  public static f.a q(String paramString)
  {
    f.a locala = f.a.a;
    if (paramString != null) {
      if (paramString.isEmpty()) {
        return locala;
      }
    }
    try
    {
      paramString = f.a.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString)
    {
      label24:
      break label24;
    }
    return f.a.a;
    return locala;
  }
  
  protected void b(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    if (paramString == null) {
      return;
    }
    HashMap localHashMap = new HashMap();
    if ((paramArrayOfa != null) && (paramArrayOfa.length != 0))
    {
      int i = 0;
      while (i < paramArrayOfa.length)
      {
        if ((paramArrayOfa[i] != null) && ((!paramBoolean) || (!h(paramArrayOfa[i].b))) && (paramArrayOfa[i].a.b()))
        {
          Object localObject = (a.a)l.a(WebView.c.b).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[i] });
          if (((localObject == null) || (!((a.a)localObject).a)) && (paramArrayOfa[i].c != null) && (paramArrayOfa[i].d != null) && (!paramArrayOfa[i].d.isEmpty()))
          {
            localObject = paramArrayOfa[i].d.split(",");
            a(paramArrayOfa[i], localHashMap, (String[])localObject);
          }
        }
        i += 1;
      }
      c(paramString, localHashMap);
      return;
    }
    c(paramString, localHashMap);
  }
  
  public SharedPreferences c()
  {
    return XWalkEnvironment.getMMKVSharedPreferences("XWEB.CMDCFG.PLUGIN");
  }
  
  public String h()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      Object localObject1 = this.d.keySet();
      if (localObject1 == null) {
        return "";
      }
      Iterator localIterator = ((Set)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str2 = (String)localIterator.next();
        if (!TextUtils.isEmpty(str2))
        {
          String str1 = a(a(str2));
          localObject1 = str1;
          if (str1 == null) {
            localObject1 = "";
          }
          localStringBuilder.append(" ");
          localStringBuilder.append(str2);
          localStringBuilder.append(" : ");
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append("\n");
        }
      }
      localObject1 = localStringBuilder.toString();
      return localObject1;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.b
 * JD-Core Version:    0.7.0.1
 */