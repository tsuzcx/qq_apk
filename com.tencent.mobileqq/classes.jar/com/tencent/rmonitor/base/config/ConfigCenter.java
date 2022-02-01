package com.tencent.rmonitor.base.config;

import android.os.Handler;
import android.text.TextUtils;
import com.tencent.rmonitor.base.config.data.RMonitorConfig;
import com.tencent.rmonitor.base.config.data.RPluginConfig;
import com.tencent.rmonitor.base.config.impl.DefaultConfigLoader;
import com.tencent.rmonitor.base.constants.PluginId;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UrlMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.thread.ThreadManager;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class ConfigCenter
{
  private final Set<IConfigUpdater> a = new CopyOnWriteArraySet();
  private final RMonitorConfig b = new RMonitorConfig();
  private final HashMap<String, Boolean> c = new HashMap(3);
  private Handler d = null;
  private IConfigLoader e = null;
  private long f = 0L;
  
  public ConfigCenter()
  {
    b();
  }
  
  private void a(RMonitorConfig paramRMonitorConfig)
  {
    int[] arrayOfInt = PluginId.a;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      int k = arrayOfInt[i];
      RPluginConfig localRPluginConfig = paramRMonitorConfig.a(k);
      if (localRPluginConfig != null) {
        PluginController.b.a(k, localRPluginConfig);
      }
      i += 1;
    }
  }
  
  private void b()
  {
    HashMap localHashMap = this.c;
    Boolean localBoolean = Boolean.valueOf(true);
    localHashMap.put("NEED_AUTHORIZATION", localBoolean);
    this.c.put("JVM_TI_OPEN", Boolean.valueOf(false));
    this.c.put("NEW_LOPPER_OPEN", localBoolean);
    this.c.put("CAN_COLLECT_SENSITIVE_INFO", localBoolean);
  }
  
  private void c()
  {
    if (this.e == null) {
      this.e = d();
    }
    Object localObject = this.e;
    if (localObject != null) {
      ((IConfigLoader)localObject).a(this.b);
    }
    e();
    localObject = this.a.iterator();
    while (((Iterator)localObject).hasNext())
    {
      IConfigUpdater localIConfigUpdater = (IConfigUpdater)((Iterator)localObject).next();
      localIConfigUpdater.a(this.b);
      int[] arrayOfInt = PluginId.a;
      int j = arrayOfInt.length;
      int i = 0;
      while (i < j)
      {
        int k = arrayOfInt[i];
        localIConfigUpdater.a(k, this.b.a(k));
        i += 1;
      }
    }
    a(this.b);
  }
  
  private IConfigLoader d()
  {
    String str = BaseInfo.urlMeta.getConfigUrl();
    try
    {
      DefaultConfigLoader localDefaultConfigLoader = new DefaultConfigLoader(new URL(str));
      return localDefaultConfigLoader;
    }
    catch (Throwable localThrowable)
    {
      Logger.b.e(new String[] { "RMonitor_config_ConfigCenter", "createDefaultConfigLoader fail, configUrl = ", str, localThrowable.getMessage() });
    }
    return null;
  }
  
  private void e()
  {
    this.f = System.currentTimeMillis();
    Logger.b.i(new String[] { "RMonitor_config_ConfigCenter", "markLastUpdateConfigTime, lastLoadConfigTime = ", String.valueOf(this.f) });
  }
  
  private boolean f()
  {
    return Math.abs(System.currentTimeMillis() - this.f) >= 1800000L;
  }
  
  public int a(int paramInt)
  {
    if (f()) {
      c();
    }
    return paramInt & this.b.f;
  }
  
  public int a(String paramString)
  {
    if ("MAX_AUSTERITY_REPORT_NUM".equals(paramString)) {
      return this.b.b;
    }
    if ("MAX_LOOSE_REPORT_NUM".equals(paramString)) {
      return this.b.c;
    }
    if ("RES_TYPE".equals(paramString)) {
      return this.b.e;
    }
    return 0;
  }
  
  public void a()
  {
    Logger.b.i(new String[] { "RMonitor_config_ConfigCenter", "refreshConfig, lastLoadConfigTime = ", String.valueOf(this.f) });
    if (this.d == null) {
      this.d = new Handler(ThreadManager.e());
    }
    ConfigCenter.1 local1 = new ConfigCenter.1(this);
    this.d.post(local1);
  }
  
  public void a(IConfigUpdater paramIConfigUpdater)
  {
    if (paramIConfigUpdater == null) {
      return;
    }
    this.a.add(paramIConfigUpdater);
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      this.c.put(paramString, Boolean.valueOf(paramBoolean));
    }
  }
  
  public DefaultPluginConfig b(int paramInt)
  {
    Iterator localIterator = PluginCombination.a.a().iterator();
    while (localIterator.hasNext())
    {
      localObject = (DefaultPluginConfig)localIterator.next();
      if (((DefaultPluginConfig)localObject).a == paramInt) {
        break label44;
      }
    }
    Object localObject = null;
    label44:
    if (localObject != null) {
      return localObject;
    }
    localObject = new IllegalArgumentException(String.format("plugin id [%s] is not valid.", new Object[] { Integer.valueOf(paramInt) }));
    for (;;)
    {
      throw ((Throwable)localObject);
    }
  }
  
  public void b(IConfigUpdater paramIConfigUpdater)
  {
    if (paramIConfigUpdater == null) {
      return;
    }
    this.a.remove(paramIConfigUpdater);
  }
  
  public boolean b(String paramString)
  {
    boolean bool3 = TextUtils.isEmpty(paramString);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!bool3)
    {
      paramString = (Boolean)this.c.get(paramString);
      bool1 = bool2;
      if (paramString != null) {
        bool1 = paramString.booleanValue();
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.base.config.ConfigCenter
 * JD-Core Version:    0.7.0.1
 */