package io.flutter.embedding.engine;

import android.app.Activity;
import android.app.Service;
import android.arch.lifecycle.Lifecycle;
import android.content.BroadcastReceiver;
import android.content.ContentProvider;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverAware;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderAware;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceAware;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.plugin.platform.PlatformViewsController;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class FlutterEnginePluginRegistry
  implements PluginRegistry, ActivityControlSurface, BroadcastReceiverControlSurface, ContentProviderControlSurface, ServiceControlSurface
{
  private static final String TAG = "FlutterEnginePluginRegistry";
  @Nullable
  private Activity activity;
  @NonNull
  private final Map<Class<? extends FlutterPlugin>, ActivityAware> activityAwarePlugins = new HashMap();
  @Nullable
  private FlutterEnginePluginRegistry.FlutterEngineActivityPluginBinding activityPluginBinding;
  @Nullable
  private BroadcastReceiver broadcastReceiver;
  @NonNull
  private final Map<Class<? extends FlutterPlugin>, BroadcastReceiverAware> broadcastReceiverAwarePlugins = new HashMap();
  @Nullable
  private FlutterEnginePluginRegistry.FlutterEngineBroadcastReceiverPluginBinding broadcastReceiverPluginBinding;
  @Nullable
  private ContentProvider contentProvider;
  @NonNull
  private final Map<Class<? extends FlutterPlugin>, ContentProviderAware> contentProviderAwarePlugins = new HashMap();
  @Nullable
  private FlutterEnginePluginRegistry.FlutterEngineContentProviderPluginBinding contentProviderPluginBinding;
  @NonNull
  private final FlutterEngineAndroidLifecycle flutterEngineAndroidLifecycle;
  private boolean isWaitingForActivityReattachment = false;
  @NonNull
  private final FlutterPlugin.FlutterPluginBinding pluginBinding;
  @NonNull
  private final Map<Class<? extends FlutterPlugin>, FlutterPlugin> plugins = new HashMap();
  @Nullable
  private Service service;
  @NonNull
  private final Map<Class<? extends FlutterPlugin>, ServiceAware> serviceAwarePlugins = new HashMap();
  @Nullable
  private FlutterEnginePluginRegistry.FlutterEngineServicePluginBinding servicePluginBinding;
  
  FlutterEnginePluginRegistry(@NonNull Context paramContext, @NonNull FlutterEngine paramFlutterEngine, @NonNull FlutterEngineAndroidLifecycle paramFlutterEngineAndroidLifecycle)
  {
    this.flutterEngineAndroidLifecycle = paramFlutterEngineAndroidLifecycle;
    this.pluginBinding = new FlutterPlugin.FlutterPluginBinding(paramContext, paramFlutterEngine, paramFlutterEngineAndroidLifecycle);
  }
  
  private void detachFromAndroidComponent()
  {
    if (isAttachedToActivity()) {
      detachFromActivity();
    }
    do
    {
      return;
      if (isAttachedToService())
      {
        detachFromService();
        return;
      }
      if (isAttachedToBroadcastReceiver())
      {
        detachFromBroadcastReceiver();
        return;
      }
    } while (!isAttachedToContentProvider());
    detachFromContentProvider();
  }
  
  private boolean isAttachedToActivity()
  {
    return this.activity != null;
  }
  
  private boolean isAttachedToBroadcastReceiver()
  {
    return this.broadcastReceiver != null;
  }
  
  private boolean isAttachedToContentProvider()
  {
    return this.contentProvider != null;
  }
  
  private boolean isAttachedToService()
  {
    return this.service != null;
  }
  
  public void add(@NonNull FlutterPlugin paramFlutterPlugin)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Adding plugin: ");
    ((StringBuilder)localObject).append(paramFlutterPlugin);
    Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
    this.plugins.put(paramFlutterPlugin.getClass(), paramFlutterPlugin);
    paramFlutterPlugin.onAttachedToEngine(this.pluginBinding);
    if ((paramFlutterPlugin instanceof ActivityAware))
    {
      localObject = (ActivityAware)paramFlutterPlugin;
      this.activityAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToActivity()) {
        ((ActivityAware)localObject).onAttachedToActivity(this.activityPluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof ServiceAware))
    {
      localObject = (ServiceAware)paramFlutterPlugin;
      this.serviceAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToService()) {
        ((ServiceAware)localObject).onAttachedToService(this.servicePluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof BroadcastReceiverAware))
    {
      localObject = (BroadcastReceiverAware)paramFlutterPlugin;
      this.broadcastReceiverAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToBroadcastReceiver()) {
        ((BroadcastReceiverAware)localObject).onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
      }
    }
    if ((paramFlutterPlugin instanceof ContentProviderAware))
    {
      localObject = (ContentProviderAware)paramFlutterPlugin;
      this.contentProviderAwarePlugins.put(paramFlutterPlugin.getClass(), localObject);
      if (isAttachedToContentProvider()) {
        ((ContentProviderAware)localObject).onAttachedToContentProvider(this.contentProviderPluginBinding);
      }
    }
  }
  
  public void add(@NonNull Set<FlutterPlugin> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      add((FlutterPlugin)paramSet.next());
    }
  }
  
  public void attachToActivity(@NonNull Activity paramActivity, @NonNull Lifecycle paramLifecycle)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Attaching to an Activity: ");
    localStringBuilder.append(paramActivity);
    localStringBuilder.append(".");
    String str;
    if (this.isWaitingForActivityReattachment)
    {
      str = " This is after a config change.";
      localStringBuilder.append(str);
      Log.v("FlutterEnginePluginRegistry", localStringBuilder.toString());
      detachFromAndroidComponent();
      this.activity = paramActivity;
      this.activityPluginBinding = new FlutterEnginePluginRegistry.FlutterEngineActivityPluginBinding(paramActivity);
      this.flutterEngineAndroidLifecycle.setBackingLifecycle(paramLifecycle);
      this.pluginBinding.getFlutterEngine().getPlatformViewsController().attach(paramActivity, this.pluginBinding.getFlutterEngine().getRenderer(), this.pluginBinding.getFlutterEngine().getDartExecutor());
      paramActivity = this.activityAwarePlugins.values().iterator();
    }
    for (;;)
    {
      if (!paramActivity.hasNext()) {
        break label196;
      }
      paramLifecycle = (ActivityAware)paramActivity.next();
      if (this.isWaitingForActivityReattachment)
      {
        paramLifecycle.onReattachedToActivityForConfigChanges(this.activityPluginBinding);
        continue;
        str = "";
        break;
      }
      paramLifecycle.onAttachedToActivity(this.activityPluginBinding);
    }
    label196:
    this.isWaitingForActivityReattachment = false;
  }
  
  public void attachToBroadcastReceiver(@NonNull BroadcastReceiver paramBroadcastReceiver, @NonNull Lifecycle paramLifecycle)
  {
    paramLifecycle = new StringBuilder();
    paramLifecycle.append("Attaching to BroadcastReceiver: ");
    paramLifecycle.append(paramBroadcastReceiver);
    Log.v("FlutterEnginePluginRegistry", paramLifecycle.toString());
    detachFromAndroidComponent();
    this.broadcastReceiver = paramBroadcastReceiver;
    this.broadcastReceiverPluginBinding = new FlutterEnginePluginRegistry.FlutterEngineBroadcastReceiverPluginBinding(paramBroadcastReceiver);
    paramBroadcastReceiver = this.broadcastReceiverAwarePlugins.values().iterator();
    while (paramBroadcastReceiver.hasNext()) {
      ((BroadcastReceiverAware)paramBroadcastReceiver.next()).onAttachedToBroadcastReceiver(this.broadcastReceiverPluginBinding);
    }
  }
  
  public void attachToContentProvider(@NonNull ContentProvider paramContentProvider, @NonNull Lifecycle paramLifecycle)
  {
    paramLifecycle = new StringBuilder();
    paramLifecycle.append("Attaching to ContentProvider: ");
    paramLifecycle.append(paramContentProvider);
    Log.v("FlutterEnginePluginRegistry", paramLifecycle.toString());
    detachFromAndroidComponent();
    this.contentProvider = paramContentProvider;
    this.contentProviderPluginBinding = new FlutterEnginePluginRegistry.FlutterEngineContentProviderPluginBinding(paramContentProvider);
    paramContentProvider = this.contentProviderAwarePlugins.values().iterator();
    while (paramContentProvider.hasNext()) {
      ((ContentProviderAware)paramContentProvider.next()).onAttachedToContentProvider(this.contentProviderPluginBinding);
    }
  }
  
  public void attachToService(@NonNull Service paramService, @NonNull Lifecycle paramLifecycle, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Attaching to a Service: ");
    localStringBuilder.append(paramService);
    Log.v("FlutterEnginePluginRegistry", localStringBuilder.toString());
    detachFromAndroidComponent();
    this.service = paramService;
    this.servicePluginBinding = new FlutterEnginePluginRegistry.FlutterEngineServicePluginBinding(paramService);
    this.flutterEngineAndroidLifecycle.setBackingLifecycle(paramLifecycle);
    paramService = this.serviceAwarePlugins.values().iterator();
    while (paramService.hasNext()) {
      ((ServiceAware)paramService.next()).onAttachedToService(this.servicePluginBinding);
    }
  }
  
  public void destroy()
  {
    Log.d("FlutterEnginePluginRegistry", "Destroying.");
    detachFromAndroidComponent();
    this.flutterEngineAndroidLifecycle.destroy();
    removeAll();
  }
  
  public void detachFromActivity()
  {
    if (isAttachedToActivity())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Detaching from an Activity: ");
      ((StringBuilder)localObject).append(this.activity);
      Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
      localObject = this.activityAwarePlugins.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ActivityAware)((Iterator)localObject).next()).onDetachedFromActivity();
      }
      this.pluginBinding.getFlutterEngine().getPlatformViewsController().detach();
      this.flutterEngineAndroidLifecycle.setBackingLifecycle(null);
      this.activity = null;
      this.activityPluginBinding = null;
      return;
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to detach plugins from an Activity when no Activity was attached.");
  }
  
  public void detachFromActivityForConfigChanges()
  {
    if (isAttachedToActivity())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Detaching from an Activity for config changes: ");
      ((StringBuilder)localObject).append(this.activity);
      Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
      this.isWaitingForActivityReattachment = true;
      localObject = this.activityAwarePlugins.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ActivityAware)((Iterator)localObject).next()).onDetachedFromActivityForConfigChanges();
      }
      this.pluginBinding.getFlutterEngine().getPlatformViewsController().detach();
      this.flutterEngineAndroidLifecycle.setBackingLifecycle(null);
      this.activity = null;
      this.activityPluginBinding = null;
      return;
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to detach plugins from an Activity when no Activity was attached.");
  }
  
  public void detachFromBroadcastReceiver()
  {
    if (isAttachedToBroadcastReceiver())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Detaching from BroadcastReceiver: ");
      ((StringBuilder)localObject).append(this.broadcastReceiver);
      Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
      localObject = this.broadcastReceiverAwarePlugins.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((BroadcastReceiverAware)((Iterator)localObject).next()).onDetachedFromBroadcastReceiver();
      }
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to detach plugins from a BroadcastReceiver when no BroadcastReceiver was attached.");
  }
  
  public void detachFromContentProvider()
  {
    if (isAttachedToContentProvider())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Detaching from ContentProvider: ");
      ((StringBuilder)localObject).append(this.contentProvider);
      Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
      localObject = this.contentProviderAwarePlugins.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ContentProviderAware)((Iterator)localObject).next()).onDetachedFromContentProvider();
      }
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to detach plugins from a ContentProvider when no ContentProvider was attached.");
  }
  
  public void detachFromService()
  {
    if (isAttachedToService())
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("Detaching from a Service: ");
      ((StringBuilder)localObject).append(this.service);
      Log.v("FlutterEnginePluginRegistry", ((StringBuilder)localObject).toString());
      localObject = this.serviceAwarePlugins.values().iterator();
      while (((Iterator)localObject).hasNext()) {
        ((ServiceAware)((Iterator)localObject).next()).onDetachedFromService();
      }
      this.flutterEngineAndroidLifecycle.setBackingLifecycle(null);
      this.service = null;
      this.servicePluginBinding = null;
      return;
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to detach plugins from a Service when no Service was attached.");
  }
  
  public FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> paramClass)
  {
    return (FlutterPlugin)this.plugins.get(paramClass);
  }
  
  public boolean has(@NonNull Class<? extends FlutterPlugin> paramClass)
  {
    return this.plugins.containsKey(paramClass);
  }
  
  public boolean onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Log.v("FlutterEnginePluginRegistry", "Forwarding onActivityResult() to plugins.");
    if (isAttachedToActivity()) {
      return this.activityPluginBinding.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to notify ActivityAware plugins of onActivityResult, but no Activity was attached.");
    return false;
  }
  
  public void onMoveToBackground()
  {
    if (isAttachedToService())
    {
      Log.v("FlutterEnginePluginRegistry", "Attached Service moved to background.");
      this.servicePluginBinding.onMoveToBackground();
    }
  }
  
  public void onMoveToForeground()
  {
    if (isAttachedToService())
    {
      Log.v("FlutterEnginePluginRegistry", "Attached Service moved to foreground.");
      this.servicePluginBinding.onMoveToForeground();
    }
  }
  
  public void onNewIntent(@NonNull Intent paramIntent)
  {
    Log.v("FlutterEnginePluginRegistry", "Forwarding onNewIntent() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onNewIntent(paramIntent);
      return;
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to notify ActivityAware plugins of onNewIntent, but no Activity was attached.");
  }
  
  public boolean onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    Log.v("FlutterEnginePluginRegistry", "Forwarding onRequestPermissionsResult() to plugins.");
    if (isAttachedToActivity()) {
      return this.activityPluginBinding.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to notify ActivityAware plugins of onRequestPermissionsResult, but no Activity was attached.");
    return false;
  }
  
  public void onUserLeaveHint()
  {
    Log.v("FlutterEnginePluginRegistry", "Forwarding onUserLeaveHint() to plugins.");
    if (isAttachedToActivity())
    {
      this.activityPluginBinding.onUserLeaveHint();
      return;
    }
    Log.e("FlutterEnginePluginRegistry", "Attempted to notify ActivityAware plugins of onUserLeaveHint, but no Activity was attached.");
  }
  
  public void remove(@NonNull Class<? extends FlutterPlugin> paramClass)
  {
    FlutterPlugin localFlutterPlugin = (FlutterPlugin)this.plugins.get(paramClass);
    if (localFlutterPlugin != null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Removing plugin: ");
      localStringBuilder.append(localFlutterPlugin);
      Log.v("FlutterEnginePluginRegistry", localStringBuilder.toString());
      if ((localFlutterPlugin instanceof ActivityAware))
      {
        if (isAttachedToActivity()) {
          ((ActivityAware)localFlutterPlugin).onDetachedFromActivity();
        }
        this.activityAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof ServiceAware))
      {
        if (isAttachedToService()) {
          ((ServiceAware)localFlutterPlugin).onDetachedFromService();
        }
        this.serviceAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof BroadcastReceiverAware))
      {
        if (isAttachedToBroadcastReceiver()) {
          ((BroadcastReceiverAware)localFlutterPlugin).onDetachedFromBroadcastReceiver();
        }
        this.broadcastReceiverAwarePlugins.remove(paramClass);
      }
      if ((localFlutterPlugin instanceof ContentProviderAware))
      {
        if (isAttachedToContentProvider()) {
          ((ContentProviderAware)localFlutterPlugin).onDetachedFromContentProvider();
        }
        this.contentProviderAwarePlugins.remove(paramClass);
      }
      localFlutterPlugin.onDetachedFromEngine(this.pluginBinding);
      this.plugins.remove(paramClass);
    }
  }
  
  public void remove(@NonNull Set<Class<? extends FlutterPlugin>> paramSet)
  {
    paramSet = paramSet.iterator();
    while (paramSet.hasNext()) {
      remove((Class)paramSet.next());
    }
  }
  
  public void removeAll()
  {
    remove(new HashSet(this.plugins.keySet()));
    this.plugins.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry
 * JD-Core Version:    0.7.0.1
 */