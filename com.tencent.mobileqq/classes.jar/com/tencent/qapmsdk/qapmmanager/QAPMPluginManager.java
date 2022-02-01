package com.tencent.qapmsdk.qapmmanager;

import com.tencent.qapmsdk.base.config.DefaultPluginConfig;
import com.tencent.qapmsdk.base.config.DefaultPluginConfig.ResourcePlugin.ResourceType;
import com.tencent.qapmsdk.base.config.PluginCombination;
import com.tencent.qapmsdk.base.config.RuntimeConfig;
import com.tencent.qapmsdk.base.config.SDKConfig;
import com.tencent.qapmsdk.base.meta.BaseInfo;
import com.tencent.qapmsdk.base.meta.UserMeta;
import com.tencent.qapmsdk.base.monitorplugin.PluginController;
import com.tencent.qapmsdk.base.monitorplugin.QAPMMonitorPlugin;
import com.tencent.qapmsdk.common.logger.Logger;
import com.tencent.qapmsdk.common.util.AndroidVersion;
import com.tencent.qapmsdk.common.util.AndroidVersion.Companion;
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
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/qapmmanager/QAPMPluginManager;", "", "()V", "plugins", "Ljava/util/concurrent/ConcurrentHashMap;", "", "Lcom/tencent/qapmsdk/base/monitorplugin/QAPMMonitorPlugin;", "startedPlugin", "", "allPlugins", "", "productPlugin", "pluginTag", "registerPlugin", "", "pluginConfig", "Lcom/tencent/qapmsdk/base/config/DefaultPluginConfig;", "registerPlugins", "registryListing", "start", "switch", "", "stop", "Companion", "qapmmanager_release"}, k=1, mv={1, 1, 15})
public final class QAPMPluginManager
{
  @JvmField
  @NotNull
  public static final List<DefaultPluginConfig> ALL_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig ANR_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig BIG_BITMAP_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig BREAD_CRUMB_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig CELLING_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig CRASH_PLUGIN;
  public static final QAPMPluginManager.Companion Companion = new QAPMPluginManager.Companion(null);
  @JvmField
  @NotNull
  public static final DefaultPluginConfig DB_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig DEVICE_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig DROP_FRAME_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig HTTP_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig IO_PLUGIN = PluginCombination.ioPlugin;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig JS_ERROR_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig LEAK_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig LOOP_STACK_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig QQ_BATTERY_PLUGIN;
  @JvmField
  @NotNull
  public static final DefaultPluginConfig RESOURCE_PLUGIN;
  private static final String TAG = "QAPM_manager_QAPMPluginManager";
  @JvmField
  @NotNull
  public static final DefaultPluginConfig WEB_VIEW_PLUGIN;
  private final ConcurrentHashMap<String, QAPMMonitorPlugin> plugins = new ConcurrentHashMap();
  private final List<QAPMMonitorPlugin> startedPlugin = (List)new ArrayList();
  
  static
  {
    DB_PLUGIN = PluginCombination.dbPlugin;
    BREAD_CRUMB_PLUGIN = PluginCombination.userBreadCrumbPlugin;
    CRASH_PLUGIN = PluginCombination.crashPlugin;
    ANR_PLUGIN = PluginCombination.anrPlugin;
    DEVICE_PLUGIN = PluginCombination.devicePlugin;
    DROP_FRAME_PLUGIN = PluginCombination.dropFramePlugin;
    JS_ERROR_PLUGIN = PluginCombination.jsErrorPlugin;
    LOOP_STACK_PLUGIN = PluginCombination.loopStackPlugin;
    LEAK_PLUGIN = PluginCombination.leakPlugin;
    CELLING_PLUGIN = PluginCombination.ceilingValuePlugin;
    RESOURCE_PLUGIN = PluginCombination.resourcePlugin;
    WEB_VIEW_PLUGIN = PluginCombination.webViewPlugin;
    HTTP_PLUGIN = PluginCombination.httpPlugin;
    BIG_BITMAP_PLUGIN = PluginCombination.bigBitmapPlugin;
    QQ_BATTERY_PLUGIN = PluginCombination.qqBatteryPlugin;
    Collection localCollection = (Collection)CollectionsKt.listOf(new DefaultPluginConfig[] { IO_PLUGIN, DB_PLUGIN, BREAD_CRUMB_PLUGIN, CRASH_PLUGIN, ANR_PLUGIN, DEVICE_PLUGIN, DROP_FRAME_PLUGIN, JS_ERROR_PLUGIN, LOOP_STACK_PLUGIN, CELLING_PLUGIN, LEAK_PLUGIN, RESOURCE_PLUGIN, WEB_VIEW_PLUGIN, HTTP_PLUGIN, BIG_BITMAP_PLUGIN });
    if (!SDKConfig.PURE_QAPM) {}
    for (List localList = CollectionsKt.listOf(QQ_BATTERY_PLUGIN);; localList = CollectionsKt.emptyList())
    {
      ALL_PLUGIN = CollectionsKt.plus(localCollection, (Iterable)localList);
      return;
    }
  }
  
  private final List<QAPMMonitorPlugin> allPlugins()
  {
    Object localObject = (Map)this.plugins;
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
  
  @Nullable
  public final QAPMMonitorPlugin productPlugin(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "pluginTag");
    return (QAPMMonitorPlugin)this.plugins.get(paramString);
  }
  
  public final void registerPlugin(@NotNull DefaultPluginConfig paramDefaultPluginConfig)
  {
    Intrinsics.checkParameterIsNotNull(paramDefaultPluginConfig, "pluginConfig");
    if (!this.plugins.containsKey(paramDefaultPluginConfig.pluginName)) {
      for (;;)
      {
        try
        {
          localClass = Class.forName(paramDefaultPluginConfig.entrance);
          try
          {
            localObject1 = localClass.getDeclaredMethod("getInstance", new Class[0]);
            localObject5 = (Map)this.plugins;
            String str = paramDefaultPluginConfig.pluginName;
            Object localObject3 = ((Method)localObject1).invoke(null, new Object[0]);
            localObject1 = localObject3;
            if (!(localObject3 instanceof QAPMMonitorPlugin)) {
              localObject1 = null;
            }
            ((Map)localObject5).put(str, (QAPMMonitorPlugin)localObject1);
          }
          catch (Exception localException2)
          {
            Object localObject5;
            Object localObject1 = Logger.INSTANCE;
            Object localObject4 = new StringBuilder().append(localException2).append(": not found method getInstance for ");
            Intrinsics.checkExpressionValueIsNotNull(localClass, "clazz");
            ((Logger)localObject1).d(new String[] { "QAPM_manager_QAPMPluginManager", localClass.getName() });
            try
            {
              localObject4 = (Map)this.plugins;
              localObject5 = paramDefaultPluginConfig.pluginName;
              if (localClass == null) {
                break label384;
              }
              localObject1 = localClass.getConstructor(new Class[0]);
              if (localObject1 == null) {
                break label384;
              }
              localObject1 = (QAPMMonitorPlugin)((Constructor)localObject1).newInstance(new Object[0]);
              ((Map)localObject4).put(localObject5, localObject1);
            }
            catch (Exception localException1)
            {
              Logger.INSTANCE.e(new String[] { "QAPM_manager_QAPMPluginManager", localException1 + ": can not new a Instance for " + localClass.getName() });
            }
            continue;
          }
          localObject1 = (QAPMMonitorPlugin)this.plugins.get(paramDefaultPluginConfig.pluginName);
          if (localObject1 == null) {
            break;
          }
          ((QAPMMonitorPlugin)localObject1).setPluginConfig(paramDefaultPluginConfig);
          Logger.INSTANCE.i(new String[] { "QAPM_manager_QAPMPluginManager", "register module " + paramDefaultPluginConfig.pluginName + " success." });
          return;
        }
        catch (ClassNotFoundException localClassNotFoundException)
        {
          Class localClass;
          Logger.INSTANCE.e(new String[] { "QAPM_manager_QAPMPluginManager", localClassNotFoundException + ": can not find class " + paramDefaultPluginConfig.entrance + '.' });
          return;
        }
        label384:
        Object localObject2 = null;
      }
    }
  }
  
  public final void registerPlugins(@NotNull List<? extends DefaultPluginConfig> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramList, "registryListing");
    paramList = ((Iterable)paramList).iterator();
    while (paramList.hasNext()) {
      registerPlugin((DefaultPluginConfig)paramList.next());
    }
  }
  
  public final void start(int paramInt)
  {
    if (!AndroidVersion.Companion.isJellyBean())
    {
      Logger.INSTANCE.w(new String[] { "QAPM_manager_QAPMPluginManager", "start sdk that must be API 16 which is min!" });
      return;
    }
    StringBuffer localStringBuffer = new StringBuffer(256);
    Object localObject3 = ((Iterable)allPlugins()).iterator();
    if (((Iterator)localObject3).hasNext())
    {
      localObject4 = (QAPMMonitorPlugin)((Iterator)localObject3).next();
      DefaultPluginConfig localDefaultPluginConfig = ((QAPMMonitorPlugin)localObject4).getPluginConfig();
      if (localDefaultPluginConfig != null)
      {
        if ((localDefaultPluginConfig.mode != 0) && (((PluginController.startedPluginMode & localDefaultPluginConfig.mode) > 0) || ((localDefaultPluginConfig.mode & paramInt) <= 0))) {
          break label270;
        }
        PluginController.startedPluginMode |= localDefaultPluginConfig.mode;
        StringsKt.append((Appendable)localStringBuffer, new CharSequence[] { (CharSequence)localDefaultPluginConfig.pluginName, (CharSequence)": true, " });
        if (localDefaultPluginConfig.mode != PluginCombination.resourcePlugin.mode) {
          break label222;
        }
        if ((DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_RESOURCE.getValue() & SDKConfig.RES_TYPE) != 0) {
          break label196;
        }
        ((QAPMMonitorPlugin)localObject4).stop();
      }
      label270:
      for (;;)
      {
        break;
        label196:
        if ((DefaultPluginConfig.ResourcePlugin.ResourceType.OPEN_AUTO.getValue() == SDKConfig.RES_TYPE) && (RuntimeConfig.globalMonitorCount <= 0))
        {
          ((QAPMMonitorPlugin)localObject4).start();
        }
        else
        {
          try
          {
            label222:
            if (!this.startedPlugin.contains(localObject4))
            {
              ((QAPMMonitorPlugin)localObject4).start();
              this.startedPlugin.add(localObject4);
            }
            localObject4 = Unit.INSTANCE;
            continue;
          }
          finally {}
          if ((PluginController.startedPluginMode & localDefaultPluginConfig.mode) > 0) {
            StringsKt.append((Appendable)localObject1, new CharSequence[] { (CharSequence)localDefaultPluginConfig.pluginName, (CharSequence)": true, " });
          } else {
            StringsKt.append((Appendable)localObject1, new CharSequence[] { (CharSequence)localDefaultPluginConfig.pluginName, (CharSequence)": false, " });
          }
        }
      }
    }
    localObject3 = Logger.INSTANCE;
    Object localObject2 = localObject1.toString();
    Intrinsics.checkExpressionValueIsNotNull(localObject2, "streamBuffer.toString()");
    ((Logger)localObject3).i(new String[] { "QAPM_manager_QAPMPluginManager", "stated module as ", localObject2 });
    localObject2 = Logger.INSTANCE;
    localObject3 = StringCompanionObject.INSTANCE;
    localObject3 = Locale.getDefault();
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "Locale.getDefault()");
    Object localObject4 = new Object[4];
    localObject4[0] = Integer.valueOf(BaseInfo.userMeta.appId);
    localObject4[1] = BaseInfo.userMeta.sdkVersion;
    localObject4[2] = Integer.valueOf(paramInt);
    localObject4[3] = Integer.valueOf(PluginController.startedPluginMode);
    localObject3 = String.format((Locale)localObject3, "QAPM SDK start success! PID: %d, APM_VERSION: %s, SWITCH: %d, STARTED: %d", Arrays.copyOf((Object[])localObject4, localObject4.length));
    Intrinsics.checkExpressionValueIsNotNull(localObject3, "java.lang.String.format(locale, format, *args)");
    ((Logger)localObject2).i(new String[] { "QAPM_manager_QAPMPluginManager", localObject3 });
  }
  
  public final void stop()
  {
    Iterator localIterator = ((Iterable)this.startedPlugin).iterator();
    while (localIterator.hasNext())
    {
      QAPMMonitorPlugin localQAPMMonitorPlugin = (QAPMMonitorPlugin)localIterator.next();
      DefaultPluginConfig localDefaultPluginConfig = localQAPMMonitorPlugin.getPluginConfig();
      if ((localDefaultPluginConfig != null) && ((PluginController.startedPluginMode & localDefaultPluginConfig.mode) > 0))
      {
        localQAPMMonitorPlugin.stop();
        PluginController.startedPluginMode ^= localDefaultPluginConfig.mode;
        Logger.INSTANCE.i(new String[] { "QAPM_manager_QAPMPluginManager", "stop plugin: ", localDefaultPluginConfig.pluginName });
      }
    }
    this.startedPlugin.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qapmsdk.qapmmanager.QAPMPluginManager
 * JD-Core Version:    0.7.0.1
 */