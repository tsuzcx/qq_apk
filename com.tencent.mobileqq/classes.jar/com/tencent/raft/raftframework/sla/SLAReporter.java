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
      localObject = paramContext.getPackageManager();
      paramContext = (String)((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(paramContext.getPackageName(), 0));
      return paramContext;
    }
    catch (Exception paramContext)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getApplicationName error: ");
      ((StringBuilder)localObject).append(paramContext);
      RLog.w("SLAReporter", new Object[] { ((StringBuilder)localObject).toString() });
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
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.baseURL);
      localStringBuilder.append("&event_name=");
      localStringBuilder.append(paramString1);
      localStringBuilder.append("&event_value=");
      localStringBuilder.append(paramString2);
      paramString1 = localStringBuilder.toString();
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
        localStringBuilder.append("&");
        localStringBuilder.append((String)localPair.first);
        localStringBuilder.append("=");
        localStringBuilder.append((String)localPair.second);
      }
      paramList = localStringBuilder.toString();
      return paramList;
    }
    finally {}
    for (;;)
    {
      throw paramList;
    }
  }
  
  private boolean hasInternetPermission()
  {
    Context localContext = this.context;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = bool3;
    if (localContext != null)
    {
      if (Build.VERSION.SDK_INT >= 23)
      {
        bool1 = bool2;
        if (this.context.checkSelfPermission("android.permission.INTERNET") == 0) {
          bool1 = true;
        }
        return bool1;
      }
      bool1 = bool3;
      if (this.context.checkCallingOrSelfPermission("android.permission.INTERNET") == 0) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void initBuglyReport(Context paramContext)
  {
    paramContext = paramContext.getSharedPreferences("BuglySdkInfos", 0).edit();
    paramContext.putString("a321c41aa2", "0.1");
    paramContext.apply();
  }
  
  private void initIfNeeded()
  {
    try
    {
      boolean bool = this.isInit;
      if (bool) {
        return;
      }
      this.baseURL = new StringBuilder("https://h.trace.qq.com/kv");
      StringBuilder localStringBuilder = this.baseURL;
      localStringBuilder.append("?attaid=");
      localStringBuilder.append("0c500034918");
      localStringBuilder = this.baseURL;
      localStringBuilder.append("&token=");
      localStringBuilder.append("4483379541");
      this.baseURL.append("&client_type=android");
      this.isInit = true;
      return;
    }
    finally {}
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("set open: ");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append(" ,real: ");
    localStringBuilder.append(this.open);
    RLog.d("SLAReporter", new Object[] { localStringBuilder.toString() });
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
    double d = System.nanoTime() - paramLong;
    Double.isNaN(d);
    report("get_service_cost", String.valueOf(d / 1000000.0D), i);
    String str;
    if (paramBoolean) {
      str = "1";
    } else {
      str = "0";
    }
    report("get_service_success", str, i);
  }
  
  public void reportOnFrameworkStartup()
  {
    if (!this.open) {
      return;
    }
    this.frameworkStartupNs = System.nanoTime();
    Context localContext = this.context;
    if (localContext != null) {
      initBuglyReport(localContext);
    }
  }
  
  public void reportOnFrameworkStartupFinish()
  {
    if (!this.open) {
      return;
    }
    Object localObject = this.context;
    if (localObject != null)
    {
      reportAppInfo((Context)localObject);
    }
    else
    {
      localObject = new ArrayList();
      ((List)localObject).add(Pair.create("app_name", "RAFTAndroid"));
      ((List)localObject).add(Pair.create("app_bundle_id", "com.tencent.raft"));
      report((List)localObject);
    }
    double d = System.nanoTime() - this.frameworkStartupNs;
    Double.isNaN(d);
    report("launch_cost", String.valueOf(d / 1000000.0D));
    report("launch_success", "1");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.raftframework.sla.SLAReporter
 * JD-Core Version:    0.7.0.1
 */