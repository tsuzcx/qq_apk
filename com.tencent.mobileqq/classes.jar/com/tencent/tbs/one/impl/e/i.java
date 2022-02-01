package com.tencent.tbs.one.impl.e;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Handler;
import android.os.Process;
import android.text.TextUtils;
import com.tencent.tbs.one.TBSOneCallback;
import com.tencent.tbs.one.TBSOneComponent;
import com.tencent.tbs.one.TBSOneDebugger;
import com.tencent.tbs.one.TBSOneException;
import com.tencent.tbs.one.TBSOneManager.Policy;
import com.tencent.tbs.one.TBSOneOnlineService;
import com.tencent.tbs.one.impl.a.j;
import com.tencent.tbs.one.impl.a.l;
import com.tencent.tbs.one.impl.a.m;
import com.tencent.tbs.one.impl.common.d.a;
import com.tencent.tbs.one.impl.common.statistic.StatisticReport;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.json.JSONObject;

public final class i
  extends h
{
  public SharedPreferences q;
  g r;
  private final Object s = new Object();
  private final Object t = new Object();
  private Set<String> u;
  private final Runnable v = new i.1(this);
  private com.tencent.tbs.one.impl.b.b w;
  
  public i(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    this.q = paramContext.getSharedPreferences(String.format("com.tencent.tbs.one.%s.prefs", new Object[] { paramString }), 4);
    if (!this.q.contains("last_update_time")) {
      l();
    }
    this.u = this.q.getStringSet("disabled_component_names", new HashSet());
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from preferences", new Object[] { paramString, TextUtils.join(", ", this.u) });
    k();
  }
  
  private com.tencent.tbs.one.impl.a.a<e<File>> a(TBSOneManager.Policy paramPolicy, d.a parama, File paramFile, Bundle paramBundle)
  {
    Context localContext = this.a;
    String str = this.b;
    int i = i.6.a[paramPolicy.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { new com.tencent.tbs.one.impl.e.c.b(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.e.b(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.c.a(this.a, this.b, parama, paramFile, paramBundle), new com.tencent.tbs.one.impl.e.e.a(this.a, this.b, parama, paramFile, paramBundle), com.tencent.tbs.one.impl.a.a(this, parama, paramFile, paramBundle) });
        }
        return new com.tencent.tbs.one.impl.e.d.a(localContext, str, parama, paramFile, paramBundle);
      }
      return new i.5(this, localContext, n(), parama.d, paramFile, parama.c);
    }
    return new com.tencent.tbs.one.impl.e.b.a(localContext, str, parama, paramFile, paramBundle, n());
  }
  
  private boolean a(String paramString, TBSOneCallback paramTBSOneCallback)
  {
    if (this.u.contains(paramString))
    {
      if (paramTBSOneCallback != null) {
        paramTBSOneCallback.onError(501, "The component has disabled");
      }
      return false;
    }
    return true;
  }
  
  private void g(String paramString)
  {
    Object localObject = com.tencent.tbs.one.impl.common.f.d(com.tencent.tbs.one.impl.common.f.a(this.a.getDir("tbs", 0), Process.myPid()), this.b);
    com.tencent.tbs.one.impl.a.c.d(((File)localObject).getParentFile());
    if (!((File)localObject).exists()) {
      com.tencent.tbs.one.impl.a.c.b((File)localObject);
    }
    localObject = new HashSet(Arrays.asList(m()));
    ((Set)localObject).add(paramString);
    paramString = this.q.edit();
    paramString.putStringSet("in_use_component_names", (Set)localObject);
    paramString.apply();
  }
  
  private String n()
  {
    Object localObject = f("local_repository_path");
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return "/android_asset/";
  }
  
  public final TBSOneManager.Policy a()
  {
    Object localObject = f("overridden_policy");
    if ((localObject instanceof TBSOneManager.Policy)) {
      return (TBSOneManager.Policy)localObject;
    }
    if ((localObject instanceof String)) {
      return TBSOneManager.Policy.valueOf(localObject.toString());
    }
    return super.a();
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(Bundle paramBundle, l<e<com.tencent.tbs.one.impl.common.d>> paraml)
  {
    Object localObject2 = a();
    if (localObject2 == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.a(paramBundle, paraml);
    }
    String str = this.b;
    boolean bool2 = false;
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing DEPS, policy: %s", new Object[] { str, localObject2 });
    File localFile = com.tencent.tbs.one.impl.common.f.b(this.c);
    if (i())
    {
      com.tencent.tbs.one.impl.a.f.a("[%s] Applying the last update", new Object[] { str });
      Context localContext = this.a;
      f.a(localContext);
      localObject1 = j();
      if (localObject1 != null)
      {
        j localj = j.a(com.tencent.tbs.one.impl.common.f.e(localFile, ".lock"));
        if (localj != null)
        {
          if (i())
          {
            if (!f.b(localContext, str)) {
              try
              {
                com.tencent.tbs.one.impl.a.c.c(com.tencent.tbs.one.impl.common.f.c(this.c), localFile);
              }
              catch (IOException localIOException)
              {
                com.tencent.tbs.one.impl.a.f.c("[%s] Failed to apply the last update", new Object[] { str, localIOException });
              }
            } else {
              com.tencent.tbs.one.impl.a.f.a("[%s] %s the category is being used by other processes", new Object[] { str, "Early out for applying the last update," });
            }
          }
          else {
            com.tencent.tbs.one.impl.a.f.a("[%s] %s the last update has applied by another process", new Object[] { str, "Early out for applying the last update," });
          }
          localj.a();
        }
        else
        {
          com.tencent.tbs.one.impl.a.f.a("[%s] %s the DEPS installation lock is busy", new Object[] { str, "Early out for applying the last update," });
        }
        ((j)localObject1).a();
      }
      else
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] %s the update lock is busy", new Object[] { str, "Early out for applying the last update," });
      }
    }
    Object localObject1 = this.i.get("permanent_version");
    int i;
    if ((localObject1 instanceof Integer)) {
      i = ((Integer)localObject1).intValue();
    } else {
      i = -1;
    }
    localObject1 = null;
    if (localObject2 == TBSOneManager.Policy.AUTO)
    {
      localObject1 = a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle);
      bool1 = bool2;
    }
    else if (localObject2 == TBSOneManager.Policy.LOCAL_ONLY)
    {
      localObject1 = a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle);
      bool1 = bool2;
    }
    else if (localObject2 == TBSOneManager.Policy.ONLINE)
    {
      localObject1 = a(TBSOneManager.Policy.ONLINE, i, localFile, paramBundle);
      bool1 = bool2;
    }
    else if ((localObject2 == TBSOneManager.Policy.BUILTIN_FIRST) && (!localFile.exists())) {}
    try
    {
      localObject1 = com.tencent.tbs.one.impl.common.d.a(localFile);
      localObject2 = com.tencent.tbs.one.impl.common.d.a(com.tencent.tbs.one.impl.common.f.c(com.tencent.tbs.one.impl.common.f.a(this.a), str));
      if (((com.tencent.tbs.one.impl.common.d)localObject1).a < ((com.tencent.tbs.one.impl.common.d)localObject2).a)
      {
        com.tencent.tbs.one.impl.a.f.a("[%s] Ignoring existing DEPS, builtin DEPS version has changed %d => %d", new Object[] { str, Integer.valueOf(((com.tencent.tbs.one.impl.common.d)localObject1).a), Integer.valueOf(((com.tencent.tbs.one.impl.common.d)localObject2).a) });
        bool1 = true;
      }
    }
    catch (TBSOneException localTBSOneException)
    {
      label500:
      break label500;
    }
    boolean bool1 = false;
    localObject1 = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, i, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
    break label604;
    bool1 = bool2;
    if (localObject2 == TBSOneManager.Policy.LOCAL_FIRST)
    {
      localObject1 = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, i, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, i, localFile, paramBundle) });
      bool1 = bool2;
    }
    label604:
    paramBundle = new d(bool1, (com.tencent.tbs.one.impl.a.a)localObject1, localFile);
    paramBundle.a(new i.3(this));
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<File>> a(Bundle paramBundle, d.a parama, l<e<File>> paraml)
  {
    TBSOneManager.Policy localPolicy = a();
    if (localPolicy == TBSOneManager.Policy.BUILTIN_ONLY) {
      return super.a(paramBundle, parama, paraml);
    }
    com.tencent.tbs.one.impl.a.f.a("[%s] Installing component %s, version: %d, policy: %s", new Object[] { this.b, parama.a, Integer.valueOf(parama.c), localPolicy });
    File localFile = a(parama.a, parama.c);
    com.tencent.tbs.one.impl.a.c.d(localFile.getParentFile());
    Object localObject = null;
    if (localPolicy == TBSOneManager.Policy.AUTO) {
      localObject = a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle);
    } else if (localPolicy == TBSOneManager.Policy.LOCAL_ONLY) {
      localObject = a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle);
    } else if (localPolicy == TBSOneManager.Policy.ONLINE) {
      localObject = a(TBSOneManager.Policy.ONLINE, parama, localFile, paramBundle);
    } else if (localPolicy == TBSOneManager.Policy.BUILTIN_FIRST) {
      localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.BUILTIN_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
    } else if (localPolicy == TBSOneManager.Policy.LOCAL_FIRST) {
      localObject = new com.tencent.tbs.one.impl.a.g(new com.tencent.tbs.one.impl.a.a[] { a(TBSOneManager.Policy.LOCAL_ONLY, parama, localFile, paramBundle), a(TBSOneManager.Policy.AUTO, parama, localFile, paramBundle) });
    }
    paramBundle = new c(this.a, parama, (com.tencent.tbs.one.impl.a.a)localObject, localFile);
    paramBundle.a(paraml);
    return paramBundle;
  }
  
  public final com.tencent.tbs.one.impl.a.a<e<com.tencent.tbs.one.impl.common.d>> a(TBSOneManager.Policy paramPolicy, int paramInt, File paramFile, Bundle paramBundle)
  {
    Context localContext = this.a;
    String str = this.b;
    int i = i.6.a[paramPolicy.ordinal()];
    if (i != 1)
    {
      if (i != 2)
      {
        if (i != 3)
        {
          if (i != 4) {
            return null;
          }
          return com.tencent.tbs.one.impl.a.a(this, paramInt, paramFile, paramBundle);
        }
        paramPolicy = new com.tencent.tbs.one.impl.e.d.b(localContext, str, g(), paramFile);
      }
      else
      {
        paramPolicy = new i.4(this, localContext, n(), paramFile);
      }
      return paramPolicy;
    }
    return new com.tencent.tbs.one.impl.e.b.b(localContext, str, paramFile);
  }
  
  public final void a(Bundle paramBundle, String paramString, TBSOneCallback<File> paramTBSOneCallback)
  {
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramBundle, paramString, paramTBSOneCallback);
    }
  }
  
  protected final void a(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    super.a(parame);
    SharedPreferences.Editor localEditor = this.q.edit();
    localEditor.putInt("in_use_deps_version", ((com.tencent.tbs.one.impl.common.d)parame.b).a);
    localEditor.apply();
  }
  
  public final void a(String paramString, Bundle paramBundle, TBSOneCallback<TBSOneComponent> paramTBSOneCallback)
  {
    g(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.a(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public final void a(String paramString, Object paramObject)
  {
    super.a(paramString, paramObject);
    if (paramString.equals("permanent_version")) {
      a(false);
    }
    boolean bool = paramString.equals("guid");
    String str2 = "";
    String str1;
    if (bool)
    {
      if (paramObject == null) {
        str1 = "";
      } else {
        str1 = paramObject.toString();
      }
      com.tencent.tbs.one.impl.a.d.a(str1);
    }
    if (paramString.equals("ppvn"))
    {
      if (paramObject == null) {
        str1 = str2;
      } else {
        str1 = paramObject.toString();
      }
      com.tencent.tbs.one.impl.a.d.b(str1);
    }
    if (paramString.equals("disable_query_running_processes")) {
      com.tencent.tbs.one.impl.a.d.a(com.tencent.tbs.one.impl.a.d.a(paramObject));
    }
    if (paramString.equals("enable_console_logging")) {
      com.tencent.tbs.one.impl.a.f.a(com.tencent.tbs.one.impl.a.d.a(paramObject));
    }
    if ((paramString.equals("is_need_update_at_upgrade")) && ((paramObject instanceof Boolean))) {
      this.g = ((Boolean)paramObject).booleanValue();
    }
    if ((paramString.equals("update_interval")) && ((paramObject instanceof Long))) {
      this.f = ((Long)paramObject).longValue();
    }
    if ((paramString.equals("is_ignore_update_flow_control")) && ((paramObject instanceof Boolean))) {
      this.j = ((Boolean)paramObject).booleanValue();
    }
    if ((paramString.equals("is_ignore_update_wifi_network")) && ((paramObject instanceof Boolean))) {
      this.k = ((Boolean)paramObject).booleanValue();
    }
  }
  
  public final void a(boolean paramBoolean)
  {
    super.a(paramBoolean);
    if (paramBoolean) {
      k();
    }
  }
  
  public final void b(e<com.tencent.tbs.one.impl.common.d> parame)
  {
    if (parame.a != e.a.d) {
      return;
    }
    HashSet localHashSet = new HashSet();
    if ((parame.c instanceof JSONObject))
    {
      String str = this.b;
      JSONObject localJSONObject1 = (JSONObject)parame.c;
      JSONObject localJSONObject2 = localJSONObject1.optJSONObject("SWITCH");
      Iterator localIterator;
      Object localObject;
      if (localJSONObject2 != null)
      {
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1) {
            localHashSet.add(localObject);
          }
        }
      }
      localJSONObject2 = localJSONObject1.optJSONObject("RESET");
      if (localJSONObject2 != null)
      {
        parame = (com.tencent.tbs.one.impl.common.d)parame.b;
        localIterator = localJSONObject2.keys();
        while (localIterator.hasNext())
        {
          localObject = (String)localIterator.next();
          if (localJSONObject2.optInt((String)localObject, 0) == 1)
          {
            d.a locala = parame.b((String)localObject);
            if (locala != null)
            {
              localObject = a((String)localObject, locala.c);
              if (((File)localObject).exists())
              {
                f.e((File)localObject);
                com.tencent.tbs.one.impl.a.f.a("[%s] Reset component %s", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
              else
              {
                com.tencent.tbs.one.impl.a.f.c("[%s] Failed to reset component, %s does not exist", new Object[] { str, ((File)localObject).getAbsolutePath() });
              }
            }
            else
            {
              com.tencent.tbs.one.impl.a.f.c("[%s] Failed to reset component %s, no component config", new Object[] { str, localObject });
            }
          }
        }
      }
      if (localJSONObject1.optInt("ULOG") == 1) {
        StatisticReport.reportLog();
      }
    }
    this.u = localHashSet;
    com.tencent.tbs.one.impl.a.f.a("[%s] Disabled components {%s} from server", new Object[] { this.b, TextUtils.join(", ", this.u) });
    parame = this.q.edit();
    parame.putStringSet("disabled_component_names", localHashSet);
    parame.apply();
  }
  
  public final void b(String paramString, Bundle paramBundle, TBSOneCallback<File> paramTBSOneCallback)
  {
    g(paramString);
    if (a(paramString, paramTBSOneCallback)) {
      super.b(paramString, paramBundle, paramTBSOneCallback);
    }
  }
  
  public final boolean b(String paramString)
  {
    Object localObject = a(paramString);
    if (!((File)localObject).exists()) {
      return false;
    }
    localObject = ((File)localObject).listFiles();
    if (localObject == null) {
      return false;
    }
    File localFile = com.tencent.tbs.one.impl.common.f.b(this.c);
    if (!localFile.exists()) {
      return false;
    }
    try
    {
      com.tencent.tbs.one.impl.common.d locald = com.tencent.tbs.one.impl.common.d.a(localFile);
      paramString = locald.b(paramString);
      if (paramString == null) {
        return false;
      }
      paramString = paramString.f;
      if (paramString != null)
      {
        j = paramString.length;
        i = 0;
        while (i < j)
        {
          if (!b(paramString[i])) {
            return false;
          }
          i += 1;
        }
      }
      int j = localObject.length;
      int i = 0;
      while (i < j)
      {
        paramString = localObject[i];
        if ((paramString.isDirectory()) && (f.g(paramString))) {
          return true;
        }
        i += 1;
      }
      return false;
    }
    catch (TBSOneException paramString)
    {
      com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse DEPS file %s", new Object[] { this.b, localFile.getAbsolutePath(), paramString });
    }
    return false;
  }
  
  public final TBSOneOnlineService c()
  {
    if (!b()) {
      return null;
    }
    synchronized (this.s)
    {
      if (this.r == null) {
        this.r = new g(this);
      }
      g localg = this.r;
      return localg;
    }
  }
  
  public final int[] c(String paramString)
  {
    paramString = a(paramString);
    if (paramString.exists())
    {
      paramString = paramString.listFiles();
      if (paramString != null)
      {
        int[] arrayOfInt = new int[paramString.length];
        int m = paramString.length;
        int i = 0;
        int k;
        for (int j = 0; i < m; j = k)
        {
          File localFile = paramString[i];
          k = j;
          if (localFile.isDirectory())
          {
            k = j;
            if (!f.g(localFile)) {}
          }
          try
          {
            k = Integer.parseInt(localFile.getName());
            arrayOfInt[j] = k;
            k = j + 1;
          }
          catch (Exception localException)
          {
            label93:
            break label93;
          }
          com.tencent.tbs.one.impl.a.f.c("[%s] Failed to parse installed version from path %s", new Object[] { this.b, localFile.getAbsolutePath() });
          k = j;
          i += 1;
        }
        return Arrays.copyOfRange(arrayOfInt, 0, j);
      }
    }
    return new int[0];
  }
  
  public final TBSOneDebugger d()
  {
    synchronized (this.t)
    {
      if (this.w == null) {
        this.w = new com.tencent.tbs.one.impl.b.b(this.b);
      }
      com.tencent.tbs.one.impl.b.b localb = this.w;
      return localb;
    }
  }
  
  public final void e()
  {
    TBSOneOnlineService localTBSOneOnlineService = c();
    if (localTBSOneOnlineService == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (this.j) {
      localBundle.putBoolean("is_ignore_flow_control", true);
    }
    if (this.k) {
      localBundle.putBoolean("is_ignore_wifi_state", true);
    }
    localTBSOneOnlineService.update(localBundle, new i.2(this));
  }
  
  public final String[] f()
  {
    Object localObject = f("sharable_application_packages");
    if ((localObject instanceof String)) {
      return ((String)localObject).split(File.pathSeparator);
    }
    return com.tencent.tbs.one.impl.common.b.a;
  }
  
  public final String g()
  {
    Object localObject = f("online_service_url");
    if ((localObject instanceof String)) {
      return (String)localObject;
    }
    return "https://tbsone.imtt.qq.com";
  }
  
  final File h()
  {
    return new File(this.c, "incomplete-update");
  }
  
  public final boolean i()
  {
    boolean bool1 = com.tencent.tbs.one.impl.common.f.c(this.c).exists();
    boolean bool2 = h().exists() ^ true;
    com.tencent.tbs.one.impl.a.f.a("[%s] Checking update availability, exists: %b, complete: %b", new Object[] { this.b, Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    return (bool1) && (bool2);
  }
  
  public final j j()
  {
    return j.a(com.tencent.tbs.one.impl.common.f.e(com.tencent.tbs.one.impl.common.f.c(this.c), ".lock"));
  }
  
  final void k()
  {
    Handler localHandler = m.a();
    localHandler.removeCallbacks(this.v);
    localHandler.postDelayed(this.v, 10000L);
  }
  
  final void l()
  {
    SharedPreferences.Editor localEditor = this.q.edit();
    localEditor.putLong("last_update_time", System.currentTimeMillis());
    localEditor.apply();
  }
  
  public final String[] m()
  {
    return (String[])this.q.getStringSet("in_use_component_names", new HashSet()).toArray(new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.i
 * JD-Core Version:    0.7.0.1
 */