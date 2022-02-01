package com.tencent.rmonitor.manager;

import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.PluginCombination;
import com.tencent.rmonitor.base.config.PluginCombination.Companion;
import com.tencent.rmonitor.base.meta.BaseInfo;
import com.tencent.rmonitor.base.meta.UserMeta;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.base.plugin.monitor.QAPMMonitorPlugin;
import com.tencent.rmonitor.common.logger.Logger;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.AndroidVersion.Companion;
import com.tencent.rmonitor.resource.RunTimeEnv;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/rmonitor/manager/RMonitorPluginManager;", "", "()V", "plugins", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/rmonitor/base/plugin/monitor/QAPMMonitorPlugin;", "startedPlugin", "", "startedPluginMode", "", "allPlugins", "", "checkMonitor", "", "config", "Lcom/tencent/rmonitor/base/config/DefaultPluginConfig;", "getPluginByPluginId", "pluginId", "getPluginByPluginMode", "pluginMode", "isPluginStart", "registerNeedPlugins", "", "mode", "registerPlugin", "pluginConfig", "registerPlugins", "registryListing", "start", "switch", "startMonitor", "plugin", "stop", "stopAll", "stopMonitor", "updateStartPluginMode", "add", "Companion", "rmonitor-core_release"}, k=1, mv={1, 1, 15})
public class RMonitorPluginManager
{
  public static final RMonitorPluginManager.Companion a = new RMonitorPluginManager.Companion(null);
  private int b;
  private final ConcurrentHashMap<String, QAPMMonitorPlugin> c = new ConcurrentHashMap();
  private final List<QAPMMonitorPlugin> d = (List)new ArrayList();
  
  private final void a(DefaultPluginConfig paramDefaultPluginConfig)
  {
    if (!this.c.containsKey(paramDefaultPluginConfig.c)) {}
    for (;;)
    {
      Object localObject5;
      try
      {
        localObject5 = Class.forName(paramDefaultPluginConfig.d);
        Intrinsics.checkExpressionValueIsNotNull(localObject5, "Class.forName(pluginConfig.entrance)");
        StringBuilder localStringBuilder = null;
        Object localObject6;
        String str;
        try
        {
          Object localObject1 = ((Class)localObject5).getDeclaredMethod("getInstance", new Class[0]);
          Intrinsics.checkExpressionValueIsNotNull(localObject1, "clazz.getDeclaredMethod(\"getInstance\")");
          localObject6 = (Map)this.c;
          str = paramDefaultPluginConfig.c;
          localObject4 = ((Method)localObject1).invoke(null, new Object[0]);
          localObject1 = localObject4;
          if (!(localObject4 instanceof QAPMMonitorPlugin)) {
            localObject1 = null;
          }
          ((Map)localObject6).put(str, (QAPMMonitorPlugin)localObject1);
        }
        catch (Exception localException1)
        {
          localObject4 = Logger.b;
          localObject6 = new StringBuilder();
          ((StringBuilder)localObject6).append(localException1);
          ((StringBuilder)localObject6).append(": not found method getInstance for ");
          ((StringBuilder)localObject6).append(((Class)localObject5).getName());
          ((Logger)localObject4).d(new String[] { "RMonitor_manager_RMonitorPluginManager", ((StringBuilder)localObject6).toString() });
        }
        try
        {
          if ((localObject5 instanceof Class)) {
            break label498;
          }
          localObject4 = null;
          localObject6 = (Map)this.c;
          str = paramDefaultPluginConfig.c;
          Object localObject2 = localStringBuilder;
          if (localObject4 != null)
          {
            localObject4 = ((Class)localObject4).getConstructor(new Class[0]);
            localObject2 = localStringBuilder;
            if (localObject4 != null) {
              localObject2 = (QAPMMonitorPlugin)((Constructor)localObject4).newInstance(new Object[0]);
            }
          }
          ((Map)localObject6).put(str, localObject2);
        }
        catch (Exception localException2)
        {
          localObject4 = Logger.b;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(localException2);
          localStringBuilder.append(": can not new a Instance for ");
          localStringBuilder.append(((Class)localObject5).getName());
          ((Logger)localObject4).e(new String[] { "RMonitor_manager_RMonitorPluginManager", localStringBuilder.toString() });
        }
        Object localObject3 = (QAPMMonitorPlugin)this.c.get(paramDefaultPluginConfig.c);
        if (localObject3 != null)
        {
          ((QAPMMonitorPlugin)localObject3).a(paramDefaultPluginConfig);
          localObject3 = Logger.b;
          localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append("register module ");
          ((StringBuilder)localObject4).append(paramDefaultPluginConfig.c);
          ((StringBuilder)localObject4).append(" success.");
          ((Logger)localObject3).i(new String[] { "RMonitor_manager_RMonitorPluginManager", ((StringBuilder)localObject4).toString() });
          return;
        }
      }
      catch (ClassNotFoundException localClassNotFoundException)
      {
        localObject4 = Logger.b;
        localObject5 = new StringBuilder();
        ((StringBuilder)localObject5).append(localClassNotFoundException);
        ((StringBuilder)localObject5).append(": can not find class name: ");
        ((StringBuilder)localObject5).append(paramDefaultPluginConfig.c);
        ((StringBuilder)localObject5).append(", id: ");
        ((StringBuilder)localObject5).append(paramDefaultPluginConfig.a);
        ((StringBuilder)localObject5).append(", mode: ");
        ((StringBuilder)localObject5).append(paramDefaultPluginConfig.b);
        ((StringBuilder)localObject5).append(", entrance: ");
        ((StringBuilder)localObject5).append(paramDefaultPluginConfig.d);
        ((Logger)localObject4).e(new String[] { "RMonitor_manager_RMonitorPluginManager", ((StringBuilder)localObject5).toString() });
      }
      return;
      label498:
      Object localObject4 = localObject5;
    }
  }
  
  private final void a(DefaultPluginConfig paramDefaultPluginConfig, boolean paramBoolean)
  {
    int i;
    if (paramBoolean)
    {
      i = this.b;
      i = paramDefaultPluginConfig.b | i;
    }
    else
    {
      i = this.b;
      i = (paramDefaultPluginConfig.b ^ 0xFFFFFFFF) & i;
    }
    this.b = i;
    PluginController.b.e(this.b);
  }
  
  private final void a(QAPMMonitorPlugin paramQAPMMonitorPlugin, DefaultPluginConfig paramDefaultPluginConfig)
  {
    synchronized (this.d)
    {
      if (this.d.contains(paramQAPMMonitorPlugin))
      {
        paramQAPMMonitorPlugin.stop();
        this.d.remove(paramQAPMMonitorPlugin);
      }
      paramQAPMMonitorPlugin = Unit.INSTANCE;
      a(paramDefaultPluginConfig, false);
      paramQAPMMonitorPlugin = Logger.b;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("stopMonitor, plugin: ");
      ((StringBuilder)???).append(paramDefaultPluginConfig.a);
      ((StringBuilder)???).append(", name: ");
      ((StringBuilder)???).append(paramDefaultPluginConfig.c);
      paramQAPMMonitorPlugin.i(new String[] { "RMonitor_manager_RMonitorPluginManager", ((StringBuilder)???).toString() });
      return;
    }
  }
  
  private final void a(List<? extends DefaultPluginConfig> paramList)
  {
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      a((DefaultPluginConfig)paramList.next());
    }
  }
  
  private final List<QAPMMonitorPlugin> b()
  {
    Object localObject = (Map)this.c;
    Collection localCollection = (Collection)new ArrayList();
    localObject = ((Map)localObject).entrySet().iterator();
    while (((Iterator)localObject).hasNext())
    {
      QAPMMonitorPlugin localQAPMMonitorPlugin = (QAPMMonitorPlugin)((Map.Entry)((Iterator)localObject).next()).getValue();
      if (localQAPMMonitorPlugin != null) {
        localCollection.add(localQAPMMonitorPlugin);
      }
    }
    return (List)localCollection;
  }
  
  private final void b(QAPMMonitorPlugin paramQAPMMonitorPlugin, DefaultPluginConfig paramDefaultPluginConfig)
  {
    synchronized (this.d)
    {
      if (!this.d.contains(paramQAPMMonitorPlugin))
      {
        paramQAPMMonitorPlugin.start();
        this.d.add(paramQAPMMonitorPlugin);
      }
      paramQAPMMonitorPlugin = Unit.INSTANCE;
      a(paramDefaultPluginConfig, true);
      paramQAPMMonitorPlugin = Logger.b;
      ??? = new StringBuilder();
      ((StringBuilder)???).append("startMonitor, plugin: ");
      ((StringBuilder)???).append(paramDefaultPluginConfig.a);
      ((StringBuilder)???).append(", name: ");
      ((StringBuilder)???).append(paramDefaultPluginConfig.c);
      paramQAPMMonitorPlugin.i(new String[] { "RMonitor_manager_RMonitorPluginManager", ((StringBuilder)???).toString() });
      return;
    }
  }
  
  private final boolean b(DefaultPluginConfig paramDefaultPluginConfig)
  {
    if (paramDefaultPluginConfig.b == 512) {
      return RunTimeEnv.c();
    }
    return true;
  }
  
  private final boolean c(DefaultPluginConfig paramDefaultPluginConfig)
  {
    int i = this.b;
    return (paramDefaultPluginConfig.b & i) > 0;
  }
  
  public void a()
  {
    Iterator localIterator = ((Iterable)b()).iterator();
    while (localIterator.hasNext())
    {
      QAPMMonitorPlugin localQAPMMonitorPlugin = (QAPMMonitorPlugin)localIterator.next();
      DefaultPluginConfig localDefaultPluginConfig = localQAPMMonitorPlugin.a();
      if (localDefaultPluginConfig != null) {
        a(localQAPMMonitorPlugin, localDefaultPluginConfig);
      }
    }
  }
  
  public void a(int paramInt)
  {
    Object localObject1 = (Iterable)PluginCombination.a.a();
    Collection localCollection = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      Object localObject2 = ((Iterator)localObject1).next();
      DefaultPluginConfig localDefaultPluginConfig = (DefaultPluginConfig)localObject2;
      int i = localDefaultPluginConfig.b;
      int j = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if ((localDefaultPluginConfig.b & paramInt) <= 0) {
        j = 0;
      }
      if ((i | j) != 0) {
        localCollection.add(localObject2);
      }
    }
    a((List)localCollection);
  }
  
  @Nullable
  public QAPMMonitorPlugin b(int paramInt)
  {
    Object localObject2 = ((Iterable)PluginCombination.a.a()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      int i;
      if (((DefaultPluginConfig)localObject1).b == paramInt) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        break label61;
      }
    }
    Object localObject1 = null;
    label61:
    localObject1 = (DefaultPluginConfig)localObject1;
    if (localObject1 != null)
    {
      a((DefaultPluginConfig)localObject1);
      localObject1 = ((DefaultPluginConfig)localObject1).c;
    }
    else
    {
      localObject1 = "";
    }
    localObject2 = (QAPMMonitorPlugin)this.c.get(localObject1);
    if (localObject2 == null)
    {
      Logger localLogger = Logger.b;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getPluginByPluginMode, plugin is null, pluginMode: ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", pluginTag: ");
      localStringBuilder.append((String)localObject1);
      localLogger.e(new String[] { "RMonitor_manager_RMonitorPluginManager", localStringBuilder.toString() });
    }
    return localObject2;
  }
  
  public void c(int paramInt)
  {
    if (!AndroidVersion.a.b())
    {
      Logger.b.w(new String[] { "RMonitor_manager_RMonitorPluginManager", "start sdk that must be API 16 which is min!" });
      return;
    }
    Object localObject1 = new StringBuffer(256);
    Object localObject2 = ((Iterable)b()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject4 = (QAPMMonitorPlugin)((Iterator)localObject2).next();
      localObject3 = ((QAPMMonitorPlugin)localObject4).a();
      if (localObject3 != null)
      {
        int i;
        if (((DefaultPluginConfig)localObject3).b == 0) {
          i = 1;
        } else {
          i = 0;
        }
        boolean bool1 = c((DefaultPluginConfig)localObject3) ^ true;
        int j;
        if ((((DefaultPluginConfig)localObject3).b & paramInt) > 0) {
          j = 1;
        } else {
          j = 0;
        }
        StringBuilder localStringBuilder;
        boolean bool2;
        if ((i == 0) && ((!bool1) || (j == 0)))
        {
          localObject4 = (Appendable)localObject1;
          localObject3 = (CharSequence)((DefaultPluginConfig)localObject3).c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(": ");
          if (!bool1) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          localStringBuilder.append(bool2);
          localStringBuilder.append(", ");
          localObject3 = (StringBuffer)StringsKt.append((Appendable)localObject4, new CharSequence[] { localObject3, (CharSequence)localStringBuilder.toString() });
        }
        else
        {
          bool2 = b((DefaultPluginConfig)localObject3);
          if (bool2) {
            b((QAPMMonitorPlugin)localObject4, (DefaultPluginConfig)localObject3);
          } else {
            a((QAPMMonitorPlugin)localObject4, (DefaultPluginConfig)localObject3);
          }
          localObject4 = (Appendable)localObject1;
          localObject3 = (CharSequence)((DefaultPluginConfig)localObject3).c;
          localStringBuilder = new StringBuilder();
          localStringBuilder.append(": ");
          localStringBuilder.append(bool2);
          localStringBuilder.append(", ");
          localObject3 = (StringBuffer)StringsKt.append((Appendable)localObject4, new CharSequence[] { localObject3, (CharSequence)localStringBuilder.toString() });
        }
      }
    }
    localObject2 = Logger.b;
    localObject1 = ((StringBuffer)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "streamBuffer.toString()");
    ((Logger)localObject2).i(new String[] { "RMonitor_manager_RMonitorPluginManager", "stated module as ", localObject1 });
    localObject1 = Logger.b;
    localObject2 = StringCompanionObject.INSTANCE;
    localObject2 = Locale.getDefault();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "Locale.getDefault()");
    Object localObject3 = new Object[4];
    localObject3[0] = BaseInfo.userMeta.appId;
    localObject3[1] = BaseInfo.userMeta.sdkVersion;
    localObject3[2] = Integer.valueOf(paramInt);
    localObject3[3] = Integer.valueOf(this.b);
    localObject2 = String.format((Locale)localObject2, "RMonitor SDK start success! PID: %s, APM_VERSION: %s, SWITCH: %d, STARTED: %d", Arrays.copyOf((Object[])localObject3, localObject3.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "java.lang.String.format(locale, format, *args)");
    ((Logger)localObject1).i(new String[] { "RMonitor_manager_RMonitorPluginManager", localObject2 });
  }
  
  public void d(int paramInt)
  {
    Object localObject1 = new StringBuffer(256);
    Object localObject2 = ((Iterable)b()).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      QAPMMonitorPlugin localQAPMMonitorPlugin = (QAPMMonitorPlugin)((Iterator)localObject2).next();
      DefaultPluginConfig localDefaultPluginConfig = localQAPMMonitorPlugin.a();
      if (localDefaultPluginConfig != null) {
        if (c(localDefaultPluginConfig))
        {
          a(localQAPMMonitorPlugin, localDefaultPluginConfig);
          ((StringBuffer)localObject1).append(localDefaultPluginConfig.c);
          ((StringBuffer)localObject1).append(": stop success, ");
        }
        else
        {
          ((StringBuffer)localObject1).append(localDefaultPluginConfig.c);
          ((StringBuffer)localObject1).append(": not start, ");
        }
      }
    }
    localObject2 = Logger.b;
    localObject1 = ((StringBuffer)localObject1).toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject1, "streamBuffer.toString()");
    ((Logger)localObject2).i(new String[] { "RMonitor_manager_RMonitorPluginManager", "stop module as ", localObject1 });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.manager.RMonitorPluginManager
 * JD-Core Version:    0.7.0.1
 */