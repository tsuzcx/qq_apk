package com.tencent.xweb;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.xweb.internal.a.b;
import com.tencent.xweb.internal.j;
import com.tencent.xweb.internal.l;
import com.tencent.xweb.internal.l.a;
import com.tencent.xweb.util.e;
import com.tencent.xweb.util.e.a;
import com.tencent.xweb.util.h;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.xwalk.core.Log;
import org.xwalk.core.XWalkEnvironment;

public class a
{
  static boolean a = false;
  static String b = "";
  static int c;
  static String[] e = { "disable_url_watchdog" };
  private static a f;
  Map<String, Object> d = new HashMap();
  
  public static a a()
  {
    try
    {
      if (f == null)
      {
        f = new a();
        f.f();
      }
      a locala = f;
      return locala;
    }
    finally {}
  }
  
  public static String a(String paramString1, String paramString2)
  {
    try
    {
      e();
      paramString1 = a().b(paramString1, paramString2);
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  public static void a(int paramInt)
  {
    XWalkEnvironment.getSharedPreferencesForUpdateConfig().edit().putInt("cStrSpKeyConfigPeriod", paramInt).commit();
  }
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString)
  {
    a(paramArrayOfa, paramString, false);
  }
  
  public static void a(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    try
    {
      a().b(paramArrayOfa, paramString, paramBoolean);
      return;
    }
    finally
    {
      paramArrayOfa = finally;
      throw paramArrayOfa;
    }
  }
  
  public static WebView.c b(String paramString)
  {
    e();
    paramString = a("setwebtype", paramString);
    return a().j(paramString);
  }
  
  public static void b()
  {
    try
    {
      f = null;
      Log.i("CommandCfg", "resetCommandCfg ");
      a();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static JsRuntime.JsRuntimeType c(String paramString)
  {
    e();
    paramString = a("setjscore", paramString);
    return a().k(paramString);
  }
  
  public static WebView.a d(String paramString)
  {
    e();
    paramString = a("setfullscreenvideo", paramString);
    return a().l(paramString);
  }
  
  public static int e(String paramString)
  {
    e();
    paramString = a("setTraceSampleRatioInTenThousand", paramString);
    if ((!TextUtils.isEmpty(paramString)) && (TextUtils.isDigitsOnly(paramString))) {
      return Integer.parseInt(paramString);
    }
    return 0;
  }
  
  static void e()
  {
    a();
  }
  
  public static String f(String paramString)
  {
    e();
    return a("setEnabledTraceCategory", paramString);
  }
  
  public static String g()
  {
    e();
    return a().h();
  }
  
  public static String g(String paramString)
  {
    String str2 = WebView.getCurStrModule();
    String str1 = str2;
    if (TextUtils.isEmpty(str2)) {
      str1 = "tools";
    }
    return a(paramString, str1);
  }
  
  public static int i()
  {
    int i = XWalkEnvironment.getSharedPreferencesForUpdateConfig().getInt("cStrSpKeyConfigPeriod", -1);
    if (i <= 30) {
      return -1;
    }
    return i * 60 * 1000;
  }
  
  public static String[] i(String paramString)
  {
    String[] arrayOfString = new String[2];
    if ((paramString != null) && (paramString.contains(":")))
    {
      int i = paramString.indexOf(':');
      arrayOfString[0] = paramString.substring(0, i);
      if (paramString.length() - 1 <= i)
      {
        arrayOfString[1] = "";
        return arrayOfString;
      }
      arrayOfString[1] = paramString.substring(i + 1);
      return arrayOfString;
    }
    return null;
  }
  
  public int a(String paramString1, String paramString2, int paramInt)
  {
    try
    {
      paramString1 = b(paramString1, paramString2);
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return paramInt;
      }
      paramString1 = e.b(paramString1);
      if ((paramString1 != null) && (paramString1.a))
      {
        paramInt = paramString1.b();
        return paramInt;
      }
      return paramInt;
    }
    finally {}
  }
  
  String a(Map<String, String> paramMap)
  {
    if (paramMap == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder(128);
    paramMap = paramMap.entrySet().iterator();
    while (paramMap.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)paramMap.next();
      if (localStringBuilder.length() != 0) {
        localStringBuilder.append("~~~");
      }
      localStringBuilder.append((String)localEntry.getKey());
      localStringBuilder.append("```");
      localStringBuilder.append((String)localEntry.getValue());
    }
    return localStringBuilder.toString();
  }
  
  public Map<String, String> a(String paramString)
  {
    try
    {
      paramString = a(paramString, this.d);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  protected Map<String, String> a(String paramString, Map<String, Object> paramMap)
  {
    
    if ((paramString != null) && (!paramString.isEmpty()))
    {
      paramString = paramMap.get(paramString);
      if ((paramString instanceof HashMap)) {
        return (Map)paramString;
      }
      return new HashMap();
    }
    return new HashMap();
  }
  
  protected void a(com.tencent.xweb.internal.a.a parama, Map<String, Object> paramMap, String[] paramArrayOfString)
  {
    String str1 = parama.b;
    String str2 = parama.c;
    boolean bool = parama.b.equals("executeCommand");
    int j = 0;
    if (bool)
    {
      parama = i(parama.c);
      if (parama != null)
      {
        if (parama.length < 2) {
          return;
        }
        str1 = parama[0];
        str2 = parama[1];
      }
      else
      {
        return;
      }
    }
    if (TextUtils.isEmpty(str1)) {
      return;
    }
    Map localMap = a(str1, paramMap);
    int i;
    if (localMap != null)
    {
      i = j;
      parama = localMap;
      if (!localMap.isEmpty()) {}
    }
    else
    {
      parama = new HashMap();
      paramMap.put(str1, parama);
      i = j;
    }
    while (i < paramArrayOfString.length)
    {
      paramMap = paramArrayOfString[i].trim();
      if ((paramMap != null) && (!paramMap.isEmpty()) && (!parama.containsKey(paramMap))) {
        parama.put(paramMap, str2);
      }
      i += 1;
    }
  }
  
  public boolean a(String paramString1, String paramString2, boolean paramBoolean)
  {
    try
    {
      paramString1 = b(paramString1, paramString2);
      boolean bool = TextUtils.isEmpty(paramString1);
      if (bool) {
        return paramBoolean;
      }
      bool = "true".equalsIgnoreCase(paramString1);
      if (bool) {
        return true;
      }
      bool = "false".equalsIgnoreCase(paramString1);
      if (bool) {
        return false;
      }
      return paramBoolean;
    }
    finally {}
  }
  
  protected String b(String paramString1, String paramString2)
  {
    Map localMap;
    try
    {
      localMap = a(paramString1);
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label97;
      }
      paramString2 = WebView.getCurStrModule();
      paramString1 = paramString2;
      if (!TextUtils.isEmpty(paramString2)) {
        break label97;
      }
      paramString1 = "tools";
    }
    finally {}
    paramString1 = (String)localMap.get(paramString1);
    if ((!TextUtils.isEmpty(paramString1)) && (paramString1.contains("[")) && (paramString1.contains("]")))
    {
      paramString1 = j.a(paramString1);
      return paramString1;
    }
    return paramString1;
    for (;;)
    {
      return "";
      label97:
      if (localMap != null) {
        if (paramString1 != null) {
          break;
        }
      }
    }
  }
  
  void b(String paramString, Map<String, Object> paramMap)
  {
    b = paramString;
    this.d = paramMap;
  }
  
  protected void b(com.tencent.xweb.internal.a.a[] paramArrayOfa, String paramString, boolean paramBoolean)
  {
    Object localObject1 = this;
    e();
    if (paramString == null) {
      return;
    }
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("apply command config version is ");
    ((StringBuilder)localObject2).append(paramString);
    XWalkEnvironment.addXWalkInitializeLog(((StringBuilder)localObject2).toString());
    HashMap localHashMap1 = new HashMap();
    HashMap localHashMap2 = new HashMap();
    HashMap localHashMap3 = new HashMap();
    HashMap localHashMap4 = new HashMap();
    HashMap localHashMap5 = new HashMap();
    HashMap localHashMap6 = new HashMap();
    localObject2 = "setwebtype";
    localHashMap6.put("setwebtype", localHashMap1);
    localHashMap6.put("setjscore", localHashMap2);
    localHashMap6.put("setfullscreenvideo", localHashMap3);
    localHashMap6.put("setTraceSampleRatioInTenThousand", localHashMap4);
    localHashMap6.put("setEnabledTraceCategory", localHashMap5);
    if ((paramArrayOfa != null) && (paramArrayOfa.length != 0))
    {
      int k = 0;
      int i;
      for (int j = -1; k < paramArrayOfa.length; j = i)
      {
        if (paramArrayOfa[k] == null) {}
        while (((paramBoolean) && (((a)localObject1).h(paramArrayOfa[k].b))) || (!paramArrayOfa[k].a.b()))
        {
          i = j;
          break;
        }
        localObject1 = (a.a)l.a(WebView.c.b).excute("STR_CMD_EXXCUTE_CMD_FROM_CONFIG", new Object[] { paramArrayOfa[k] });
        if (((localObject1 == null) || (!((a.a)localObject1).a)) && (paramArrayOfa[k].c != null))
        {
          i = j;
          if (!paramArrayOfa[k].b.equals("setConfigPeriod")) {}
        }
        try
        {
          i = Integer.parseInt(paramArrayOfa[k].c);
        }
        catch (Exception localException)
        {
          label330:
          String[] arrayOfString;
          int m;
          int n;
          com.tencent.xweb.internal.a.a locala;
          break label330;
        }
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("parse pariod cmdvalue to int failed , value is ");
        ((StringBuilder)localObject1).append(paramArrayOfa[k].c);
        Log.e("CommandCfg", ((StringBuilder)localObject1).toString());
        i = j;
        j = i;
        if (paramArrayOfa[k].d != null) {
          if (paramArrayOfa[k].d.isEmpty())
          {
            j = i;
          }
          else
          {
            arrayOfString = paramArrayOfa[k].d.split(",");
            if (paramArrayOfa[k].b.equals(localObject2))
            {
              j = 0;
              for (m = 0; j < arrayOfString.length; m = n)
              {
                localObject1 = arrayOfString[j].trim();
                n = m;
                if (localObject1 != null)
                {
                  n = m;
                  if (!((String)localObject1).isEmpty()) {
                    if (localHashMap1.containsKey(localObject1))
                    {
                      n = m;
                    }
                    else
                    {
                      localHashMap1.put(localObject1, paramArrayOfa[k].c);
                      n = 1;
                    }
                  }
                }
                j += 1;
              }
              j = i;
              if (m != 0)
              {
                j = i;
                if (paramArrayOfa[k].a.s > 0)
                {
                  h.a(199L, 1);
                  j = i;
                }
              }
            }
            else
            {
              if (paramArrayOfa[k].b.equals("setjscore"))
              {
                m = 0;
                for (;;)
                {
                  j = i;
                  if (m >= arrayOfString.length) {
                    break;
                  }
                  localObject1 = arrayOfString[m].trim();
                  if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (!localHashMap2.containsKey(localObject1))) {
                    localHashMap2.put(localObject1, paramArrayOfa[k].c);
                  }
                  m += 1;
                }
              }
              if (paramArrayOfa[k].b.equals("setfullscreenvideo"))
              {
                m = 0;
                for (;;)
                {
                  j = i;
                  if (m >= arrayOfString.length) {
                    break;
                  }
                  localObject1 = arrayOfString[m].trim();
                  if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (!localHashMap3.containsKey(localObject1))) {
                    localHashMap3.put(localObject1, paramArrayOfa[k].c);
                  }
                  m += 1;
                }
              }
              if (paramArrayOfa[k].b.equals("setTraceSampleRatioInTenThousand"))
              {
                m = 0;
                for (;;)
                {
                  j = i;
                  if (m >= arrayOfString.length) {
                    break;
                  }
                  localObject1 = arrayOfString[m].trim();
                  if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (!localHashMap4.containsKey(localObject1))) {
                    localHashMap4.put(localObject1, paramArrayOfa[k].c);
                  }
                  m += 1;
                }
              }
              if (paramArrayOfa[k].b.equals("setEnabledTraceCategory"))
              {
                m = 0;
                for (;;)
                {
                  j = i;
                  if (m >= arrayOfString.length) {
                    break;
                  }
                  localObject1 = arrayOfString[m].trim();
                  if ((localObject1 != null) && (!((String)localObject1).isEmpty()) && (!localHashMap5.containsKey(localObject1))) {
                    localHashMap5.put(localObject1, paramArrayOfa[k].c);
                  }
                  m += 1;
                }
              }
              locala = paramArrayOfa[k];
              localObject1 = this;
              ((a)localObject1).a(locala, localHashMap6, arrayOfString);
              break label982;
            }
          }
        }
        localObject1 = this;
        i = j;
        label982:
        k += 1;
      }
      a(j);
      ((a)localObject1).c(paramString, localHashMap6);
    }
    else
    {
      ((a)localObject1).c(paramString, localHashMap6);
      return;
    }
  }
  
  public SharedPreferences c()
  {
    return XWalkEnvironment.getMMKVSharedTransportOld(d());
  }
  
  void c(String paramString, Map<String, Object> paramMap)
  {
    try
    {
      b(paramString, paramMap);
      k();
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public String d()
  {
    return "XWEB.CMDCFG";
  }
  
  void f()
  {
    try
    {
      this.d.clear();
      localSharedPreferences = c();
      b = localSharedPreferences.getString("cStrTAGConfigVer", "");
      localObject1 = localSharedPreferences.getString("cStrTAGConfigSdkVer", "");
      boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
      j = 0;
      if (bool) {
        break label277;
      }
      i = e.b((String)localObject1).b();
    }
    finally
    {
      for (;;)
      {
        SharedPreferences localSharedPreferences;
        Object localObject1;
        int j;
        Iterator localIterator;
        for (;;)
        {
          throw localObject2;
        }
        label277:
        int i = 0;
      }
    }
    c = i;
    if (i < 200502)
    {
      j = 1;
      XWalkEnvironment.addXWalkInitializeLog("config sdk ver is old , use deserized from old");
    }
    localObject1 = localSharedPreferences.getAll();
    if ((localObject1 != null) && (((Map)localObject1).size() != 0))
    {
      localIterator = ((Map)localObject1).entrySet().iterator();
      while (localIterator.hasNext())
      {
        String str1 = (String)((Map.Entry)localIterator.next()).getKey();
        String str2 = localSharedPreferences.getString(str1, "");
        if ((str1 != null) && (str2 != null))
        {
          if (j != 0) {
            localObject1 = n(str2);
          } else {
            localObject1 = m(str2);
          }
          if ((localObject1 != null) && (((Map)localObject1).size() != 0)) {
            this.d.put(str1, localObject1);
          } else {
            this.d.put(str1, str2);
          }
        }
      }
      return;
    }
  }
  
  public String h()
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(512);
      Object localObject1 = this.d.keySet();
      Object localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("strConfig ver = ");
      ((StringBuilder)localObject3).append(b);
      ((StringBuilder)localObject3).append("\n");
      localStringBuilder.append(((StringBuilder)localObject3).toString());
      localObject3 = new StringBuilder();
      ((StringBuilder)localObject3).append("strConfig sdk ver = ");
      ((StringBuilder)localObject3).append(c);
      ((StringBuilder)localObject3).append("\n");
      localStringBuilder.append(((StringBuilder)localObject3).toString());
      if (localObject1 == null)
      {
        localObject1 = localStringBuilder.toString();
        return localObject1;
      }
      Iterator localIterator = ((Set)localObject1).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
        {
          localObject3 = a(a(str));
          localObject1 = localObject3;
          if (localObject3 == null) {
            localObject1 = "";
          }
          localObject3 = new StringBuilder();
          ((StringBuilder)localObject3).append(str);
          ((StringBuilder)localObject3).append(" : ");
          localStringBuilder.append(((StringBuilder)localObject3).toString());
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
  
  protected boolean h(String paramString)
  {
    return "revertToVersion".equals(paramString);
  }
  
  WebView.c j(String paramString)
  {
    WebView.c localc;
    if ((paramString != null) && (!paramString.isEmpty())) {
      localc = WebView.c.a;
    }
    try
    {
      paramString = WebView.c.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return WebView.c.a;
    return localc;
  }
  
  protected void j()
  {
    try
    {
      Object localObject1 = c().getAll();
      if ((localObject1 != null) && (((Map)localObject1).size() != 0))
      {
        localObject1 = ((Map)localObject1).entrySet().iterator();
        Object localObject3 = new ArrayList();
        while (((Iterator)localObject1).hasNext()) {
          ((ArrayList)localObject3).add((String)((Map.Entry)((Iterator)localObject1).next()).getKey());
        }
        localObject1 = c().edit();
        localObject3 = ((ArrayList)localObject3).iterator();
        while (((Iterator)localObject3).hasNext())
        {
          String str = (String)((Iterator)localObject3).next();
          if ((!"cStrTAGConfigVer".equalsIgnoreCase(str)) && (!"cStrTAGConfigSdkVer".equalsIgnoreCase(str))) {
            ((SharedPreferences.Editor)localObject1).remove(str);
          }
        }
        ((SharedPreferences.Editor)localObject1).commit();
        return;
      }
      return;
    }
    finally {}
    for (;;)
    {
      throw localObject2;
    }
  }
  
  JsRuntime.JsRuntimeType k(String paramString)
  {
    JsRuntime.JsRuntimeType localJsRuntimeType;
    if ((paramString != null) && (!paramString.isEmpty())) {
      localJsRuntimeType = JsRuntime.JsRuntimeType.a;
    }
    try
    {
      paramString = JsRuntime.JsRuntimeType.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return JsRuntime.JsRuntimeType.a;
    return localJsRuntimeType;
  }
  
  void k()
  {
    for (;;)
    {
      try
      {
        j();
        localEditor = c().edit();
        localEditor.putString("cStrTAGConfigVer", b);
        localEditor.putString("cStrTAGConfigSdkVer", "201201");
        Iterator localIterator = this.d.entrySet().iterator();
        if (localIterator.hasNext())
        {
          localEntry = (Map.Entry)localIterator.next();
          if ((localEntry.getKey() == null) || (((String)localEntry.getKey()).isEmpty())) {
            continue;
          }
          localObject2 = localEntry.getValue();
          if (localObject2 == null) {
            continue;
          }
          boolean bool = localObject2 instanceof Map;
          if (!bool) {}
        }
      }
      finally
      {
        SharedPreferences.Editor localEditor;
        Map.Entry localEntry;
        Object localObject2;
        Map localMap;
        continue;
        throw localObject1;
        continue;
      }
      try
      {
        localMap = (Map)localObject2;
        if (localMap == null) {
          continue;
        }
        localEditor.putString((String)localEntry.getKey(), a(localMap));
      }
      catch (Exception localException)
      {
        continue;
      }
      localEditor.putString((String)localEntry.getKey(), localObject2.toString());
      continue;
      localEditor.putString((String)localEntry.getKey(), localObject2.toString());
    }
    localEditor.commit();
    XWalkEnvironment.addXWalkInitializeLog(h());
  }
  
  WebView.a l(String paramString)
  {
    WebView.a locala;
    if ((paramString != null) && (!paramString.isEmpty())) {
      locala = WebView.a.c;
    }
    try
    {
      paramString = WebView.a.valueOf(paramString);
      return paramString;
    }
    catch (Exception paramString) {}
    return WebView.a.c;
    return locala;
  }
  
  Map<String, String> m(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return localHashMap;
      }
      paramString = paramString.split("~~~");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
        {
          arrayOfString = arrayOfString.split("```");
          if ((arrayOfString.length == 2) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  Map<String, String> n(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (paramString != null)
    {
      if (paramString.isEmpty()) {
        return localHashMap;
      }
      paramString = paramString.split(";");
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        String[] arrayOfString = paramString[i];
        if ((arrayOfString != null) && (!arrayOfString.isEmpty()))
        {
          arrayOfString = arrayOfString.split(":");
          if ((arrayOfString.length == 2) && (arrayOfString[0] != null) && (arrayOfString[1] != null)) {
            localHashMap.put(arrayOfString[0], arrayOfString[1]);
          }
        }
        i += 1;
      }
    }
    return localHashMap;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.xweb.a
 * JD-Core Version:    0.7.0.1
 */