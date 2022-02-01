package com.tencent.raft.raftframework.sla;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.util.Pair;
import com.tencent.raft.raftframework.log.RLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.jetbrains.annotations.Nullable;

public class SLAReporter
{
  public static final int GROUP_ID_MUST_REPORT = -1;
  public static final String PERMISSION_NET = "android.permission.INTERNET";
  public static final double REPORT_NS_MS = 1000000.0D;
  public static final String TAG = "SLAReporter";
  private StringBuilder baseURL;
  @Nullable
  private Context context;
  private ExecutorService executor = Executors.newFixedThreadPool(3);
  private long frameworkStartupNs;
  private int groupId = 1;
  private boolean isInit = false;
  private boolean open = false;
  
  public SLAReporter(@Nullable Context paramContext)
  {
    if (isContextValidate(paramContext)) {
      this.context = paramContext;
    }
  }
  
  private int applyForGroupId()
  {
    int i = this.groupId;
    this.groupId = (i + 1);
    return i;
  }
  
  private String getApplicationName(Context paramContext)
  {
    try
    {
      PackageManager localPackageManager = paramContext.getPackageManager();
      paramContext = (String)localPackageManager.getApplicationLabel(localPackageManager.getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      RLog.w("SLAReporter", new Object[] { "getApplicationName error: " + paramContext });
    }
    return "";
  }
  
  private SharedPreferences getSharedPreferences(Context paramContext)
  {
    return paramContext.getSharedPreferences("raft_config", 0);
  }
  
  private String getUrl(String paramString1, String paramString2)
  {
    try
    {
      paramString1 = this.baseURL + "&event_name=" + paramString1 + "&event_value=" + paramString2;
      return paramString1;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
  
  private String getUrl(List<Pair<String, String>> paramList)
  {
    try
    {
      StringBuilder localStringBuilder = new StringBuilder(this.baseURL);
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        Pair localPair = (Pair)paramList.next();
        localStringBuilder.append("&").append((String)localPair.first).append("=").append((String)localPair.second);
      }
      paramList = localStringBuilder.toString();
    }
    finally {}
    return paramList;
  }
  
  private boolean hasInternetPermission()
  {
    if (this.context != null)
    {
      if (Build.VERSION.SDK_INT >= 23) {
        if (this.context.checkSelfPermission("android.permission.INTERNET") != 0) {}
      }
      while (this.context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0)
      {
        return true;
        return false;
      }
      return false;
    }
    return false;
  }
  
  private void initBuglyReport(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
    paramContext.putString("a321c41aa2", "0.1");
    paramContext.apply();
  }
  
  /* Error */
  private void initIfNeeded()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 38	com/tencent/raft/raftframework/sla/SLAReporter:isInit	Z
    //   6: istore_1
    //   7: iload_1
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: new 88	java/lang/StringBuilder
    //   18: dup
    //   19: ldc 197
    //   21: invokespecial 200	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   24: putfield 120	com/tencent/raft/raftframework/sla/SLAReporter:baseURL	Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 120	com/tencent/raft/raftframework/sla/SLAReporter:baseURL	Ljava/lang/StringBuilder;
    //   31: ldc 202
    //   33: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: ldc 204
    //   38: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   41: pop
    //   42: aload_0
    //   43: getfield 120	com/tencent/raft/raftframework/sla/SLAReporter:baseURL	Ljava/lang/StringBuilder;
    //   46: ldc 206
    //   48: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 208
    //   53: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_0
    //   58: getfield 120	com/tencent/raft/raftframework/sla/SLAReporter:baseURL	Ljava/lang/StringBuilder;
    //   61: ldc 210
    //   63: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: pop
    //   67: aload_0
    //   68: iconst_1
    //   69: putfield 38	com/tencent/raft/raftframework/sla/SLAReporter:isInit	Z
    //   72: goto -61 -> 11
    //   75: astore_2
    //   76: aload_0
    //   77: monitorexit
    //   78: aload_2
    //   79: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	80	0	this	SLAReporter
    //   6	2	1	bool	boolean
    //   75	4	2	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	75	finally
    //   14	72	75	finally
  }
  
  private boolean isContextValidate(Context paramContext)
  {
    return (paramContext != null) && (getSharedPreferences(paramContext) != null);
  }
  
  private void report(String paramString1, String paramString2)
  {
    report(paramString1, paramString2, -1);
  }
  
  private void report(String paramString1, String paramString2, int paramInt)
  {
    if ((paramInt == -1) || (paramInt % 100 == 1))
    {
      initIfNeeded();
      reportInner(getUrl(paramString1, paramString2));
    }
  }
  
  private void report(List<Pair<String, String>> paramList)
  {
    report(paramList, -1);
  }
  
  private void report(List<Pair<String, String>> paramList, int paramInt)
  {
    if ((paramInt == -1) || (paramInt % 100 == 1))
    {
      initIfNeeded();
      reportInner(getUrl(paramList));
    }
  }
  
  private void reportAppInfo(Context paramContext)
  {
    Object localObject = getSharedPreferences(paramContext);
    if (((SharedPreferences)localObject).getBoolean("app_sla_report", false)) {
      return;
    }
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("app_sla_report", true);
    ((SharedPreferences.Editor)localObject).apply();
    localObject = new ArrayList();
    ((List)localObject).add(Pair.create("app_name", getApplicationName(paramContext)));
    ((List)localObject).add(Pair.create("app_bundle_id", paramContext.getPackageName()));
    report((List)localObject);
  }
  
  private void reportInner(String paramString)
  {
    this.executor.submit(new SLAReporter.1(this, paramString));
  }
  
  public void open(boolean paramBoolean)
  {
    this.open = paramBoolean;
    if (!hasInternetPermission()) {
      paramBoolean = false;
    }
    RLog.d("SLAReporter", new Object[] { "set open: " + paramBoolean + " ,real: " + this.open });
  }
  
  public void release()
  {
    this.executor.shutdown();
    this.context = null;
  }
  
  public void reportGetServiceFinish(long paramLong, boolean paramBoolean)
  {
    if (!this.open) {
      return;
    }
    int i = applyForGroupId();
    report("get_service_cost", String.valueOf((System.nanoTime() - paramLong) / 1000000.0D), i);
    if (paramBoolean) {}
    for (String str = "1";; str = "0")
    {
      report("get_service_success", str, i);
      return;
    }
  }
  
  public void reportOnFrameworkStartup()
  {
    if (!this.open) {}
    do
    {
      return;
      this.frameworkStartupNs = System.nanoTime();
    } while (this.context == null);
    initBuglyReport(this.context);
  }
  
  public void reportOnFrameworkStartupFinish()
  {
    if (!this.open) {
      return;
    }
    if (this.context != null) {
      reportAppInfo(this.context);
    }
    for (;;)
    {
      report("launch_cost", String.valueOf((System.nanoTime() - this.frameworkStartupNs) / 1000000.0D));
      report("launch_success", "1");
      return;
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(Pair.create("app_name", "RAFTAndroid"));
      localArrayList.add(Pair.create("app_bundle_id", "com.tencent.raft"));
      report(localArrayList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.sla.SLAReporter
 * JD-Core Version:    0.7.0.1
 */