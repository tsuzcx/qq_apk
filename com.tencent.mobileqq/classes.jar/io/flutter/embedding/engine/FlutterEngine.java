package io.flutter.embedding.engine;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import io.flutter.Log;
import io.flutter.embedding.engine.dart.DartExecutor;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import io.flutter.embedding.engine.plugins.activity.ActivityControlSurface;
import io.flutter.embedding.engine.plugins.broadcastreceiver.BroadcastReceiverControlSurface;
import io.flutter.embedding.engine.plugins.contentprovider.ContentProviderControlSurface;
import io.flutter.embedding.engine.plugins.service.ServiceControlSurface;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import io.flutter.embedding.engine.systemchannels.AccessibilityChannel;
import io.flutter.embedding.engine.systemchannels.KeyEventChannel;
import io.flutter.embedding.engine.systemchannels.LifecycleChannel;
import io.flutter.embedding.engine.systemchannels.LocalizationChannel;
import io.flutter.embedding.engine.systemchannels.NavigationChannel;
import io.flutter.embedding.engine.systemchannels.PlatformChannel;
import io.flutter.embedding.engine.systemchannels.SettingsChannel;
import io.flutter.embedding.engine.systemchannels.SystemChannel;
import io.flutter.embedding.engine.systemchannels.TextInputChannel;
import io.flutter.plugin.platform.PlatformViewsController;
import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class FlutterEngine
{
  private static final String TAG = "FlutterEngine";
  @NonNull
  private final AccessibilityChannel accessibilityChannel;
  @NonNull
  private final DartExecutor dartExecutor;
  @NonNull
  private final FlutterEngine.EngineLifecycleListener engineLifecycleListener = new FlutterEngine.1(this);
  @NonNull
  private final Set<FlutterEngine.EngineLifecycleListener> engineLifecycleListeners = new HashSet();
  @NonNull
  private final FlutterJNI flutterJNI;
  @NonNull
  private final KeyEventChannel keyEventChannel;
  @NonNull
  private final LifecycleChannel lifecycleChannel;
  @NonNull
  private final LocalizationChannel localizationChannel;
  @NonNull
  private final NavigationChannel navigationChannel;
  @NonNull
  private final PlatformChannel platformChannel;
  @NonNull
  private final PlatformViewsController platformViewsController;
  @NonNull
  private final FlutterEnginePluginRegistry pluginRegistry;
  @NonNull
  private final FlutterRenderer renderer;
  @NonNull
  private final SettingsChannel settingsChannel;
  @NonNull
  private final SystemChannel systemChannel;
  @NonNull
  private final TextInputChannel textInputChannel;
  
  public FlutterEngine(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public FlutterEngine(@NonNull Context paramContext, @NonNull FlutterLoader paramFlutterLoader, @NonNull FlutterJNI paramFlutterJNI)
  {
    this(paramContext, paramFlutterLoader, paramFlutterJNI, null, true);
  }
  
  public FlutterEngine(@NonNull Context paramContext, @NonNull FlutterLoader paramFlutterLoader, @NonNull FlutterJNI paramFlutterJNI, @Nullable String[] paramArrayOfString, boolean paramBoolean)
  {
    this.flutterJNI = paramFlutterJNI;
    paramFlutterLoader.startInitialization(paramContext);
    paramFlutterLoader.ensureInitializationComplete(paramContext, paramArrayOfString);
    paramFlutterJNI.addEngineLifecycleListener(this.engineLifecycleListener);
    attachToJni();
    this.dartExecutor = new DartExecutor(paramFlutterJNI, paramContext.getAssets());
    this.dartExecutor.onAttachedToJNI();
    this.renderer = new FlutterRenderer(paramFlutterJNI);
    this.accessibilityChannel = new AccessibilityChannel(this.dartExecutor, paramFlutterJNI);
    this.keyEventChannel = new KeyEventChannel(this.dartExecutor);
    this.lifecycleChannel = new LifecycleChannel(this.dartExecutor);
    this.localizationChannel = new LocalizationChannel(this.dartExecutor);
    this.navigationChannel = new NavigationChannel(this.dartExecutor);
    this.platformChannel = new PlatformChannel(this.dartExecutor);
    this.settingsChannel = new SettingsChannel(this.dartExecutor);
    this.systemChannel = new SystemChannel(this.dartExecutor);
    this.textInputChannel = new TextInputChannel(this.dartExecutor);
    this.platformViewsController = new PlatformViewsController();
    this.pluginRegistry = new FlutterEnginePluginRegistry(paramContext.getApplicationContext(), this, paramFlutterLoader);
    if (paramBoolean) {
      registerPlugins();
    }
  }
  
  public FlutterEngine(@NonNull Context paramContext, @Nullable String[] paramArrayOfString)
  {
    this(paramContext, FlutterLoader.getInstance(), new FlutterJNI(), paramArrayOfString, true);
  }
  
  private void attachToJni()
  {
    Log.v("FlutterEngine", "Attaching to JNI.");
    this.flutterJNI.attachToNative(false);
    if (isAttachedToJni()) {
      return;
    }
    throw new RuntimeException("FlutterEngine failed to attach to its native Object reference.");
  }
  
  private boolean isAttachedToJni()
  {
    return this.flutterJNI.isAttached();
  }
  
  private void registerPlugins()
  {
    try
    {
      Class.forName("io.flutter.plugins.GeneratedPluginRegistrant").getDeclaredMethod("registerWith", new Class[] { FlutterEngine.class }).invoke(null, new Object[] { this });
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Tried to automatically register plugins with FlutterEngine (");
      localStringBuilder.append(this);
      localStringBuilder.append(") but could not find and invoke the GeneratedPluginRegistrant.");
      Log.w("FlutterEngine", localStringBuilder.toString());
    }
  }
  
  public void addEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    this.engineLifecycleListeners.add(paramEngineLifecycleListener);
  }
  
  public void destroy()
  {
    Log.d("FlutterEngine", "Destroying.");
    this.pluginRegistry.destroy();
    this.dartExecutor.onDetachedFromJNI();
    this.flutterJNI.removeEngineLifecycleListener(this.engineLifecycleListener);
    this.flutterJNI.detachFromNativeAndReleaseResources();
  }
  
  @NonNull
  public AccessibilityChannel getAccessibilityChannel()
  {
    return this.accessibilityChannel;
  }
  
  @NonNull
  public ActivityControlSurface getActivityControlSurface()
  {
    return this.pluginRegistry;
  }
  
  @NonNull
  public BroadcastReceiverControlSurface getBroadcastReceiverControlSurface()
  {
    return this.pluginRegistry;
  }
  
  @NonNull
  public ContentProviderControlSurface getContentProviderControlSurface()
  {
    return this.pluginRegistry;
  }
  
  @NonNull
  public DartExecutor getDartExecutor()
  {
    return this.dartExecutor;
  }
  
  @NonNull
  public KeyEventChannel getKeyEventChannel()
  {
    return this.keyEventChannel;
  }
  
  @NonNull
  public LifecycleChannel getLifecycleChannel()
  {
    return this.lifecycleChannel;
  }
  
  @NonNull
  public LocalizationChannel getLocalizationChannel()
  {
    return this.localizationChannel;
  }
  
  @NonNull
  public NavigationChannel getNavigationChannel()
  {
    return this.navigationChannel;
  }
  
  @NonNull
  public PlatformChannel getPlatformChannel()
  {
    return this.platformChannel;
  }
  
  @NonNull
  public PlatformViewsController getPlatformViewsController()
  {
    return this.platformViewsController;
  }
  
  @NonNull
  public PluginRegistry getPlugins()
  {
    return this.pluginRegistry;
  }
  
  @NonNull
  public FlutterRenderer getRenderer()
  {
    return this.renderer;
  }
  
  @NonNull
  public ServiceControlSurface getServiceControlSurface()
  {
    return this.pluginRegistry;
  }
  
  @NonNull
  public SettingsChannel getSettingsChannel()
  {
    return this.settingsChannel;
  }
  
  @NonNull
  public SystemChannel getSystemChannel()
  {
    return this.systemChannel;
  }
  
  @NonNull
  public TextInputChannel getTextInputChannel()
  {
    return this.textInputChannel;
  }
  
  public void removeEngineLifecycleListener(@NonNull FlutterEngine.EngineLifecycleListener paramEngineLifecycleListener)
  {
    this.engineLifecycleListeners.remove(paramEngineLifecycleListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEngine
 * JD-Core Version:    0.7.0.1
 */