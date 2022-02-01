package io.flutter.app;

import android.app.Activity;
import android.content.Context;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import io.flutter.plugin.common.PluginRegistry.ViewDestroyListener;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.plugin.platform.PlatformViewsController;
import io.flutter.view.FlutterMain;
import io.flutter.view.FlutterView;
import io.flutter.view.TextureRegistry;
import java.util.List;
import java.util.Map;

class FlutterPluginRegistry$FlutterRegistrar
  implements PluginRegistry.Registrar
{
  private final String pluginKey;
  
  FlutterPluginRegistry$FlutterRegistrar(FlutterPluginRegistry paramFlutterPluginRegistry, String paramString)
  {
    this.pluginKey = paramString;
  }
  
  public Context activeContext()
  {
    if (FlutterPluginRegistry.access$000(this.this$0) != null) {
      return FlutterPluginRegistry.access$000(this.this$0);
    }
    return FlutterPluginRegistry.access$100(this.this$0);
  }
  
  public Activity activity()
  {
    return FlutterPluginRegistry.access$000(this.this$0);
  }
  
  public PluginRegistry.Registrar addActivityResultListener(PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    FlutterPluginRegistry.access$700(this.this$0).add(paramActivityResultListener);
    return this;
  }
  
  public PluginRegistry.Registrar addNewIntentListener(PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    FlutterPluginRegistry.access$800(this.this$0).add(paramNewIntentListener);
    return this;
  }
  
  public PluginRegistry.Registrar addRequestPermissionsResultListener(PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    FlutterPluginRegistry.access$600(this.this$0).add(paramRequestPermissionsResultListener);
    return this;
  }
  
  public PluginRegistry.Registrar addUserLeaveHintListener(PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    FlutterPluginRegistry.access$900(this.this$0).add(paramUserLeaveHintListener);
    return this;
  }
  
  public PluginRegistry.Registrar addViewDestroyListener(PluginRegistry.ViewDestroyListener paramViewDestroyListener)
  {
    FlutterPluginRegistry.access$1000(this.this$0).add(paramViewDestroyListener);
    return this;
  }
  
  public Context context()
  {
    return FlutterPluginRegistry.access$100(this.this$0);
  }
  
  public String lookupKeyForAsset(String paramString)
  {
    return FlutterMain.getLookupKeyForAsset(paramString);
  }
  
  public String lookupKeyForAsset(String paramString1, String paramString2)
  {
    return FlutterMain.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public BinaryMessenger messenger()
  {
    return FlutterPluginRegistry.access$200(this.this$0);
  }
  
  public PlatformViewRegistry platformViewRegistry()
  {
    return FlutterPluginRegistry.access$400(this.this$0).getRegistry();
  }
  
  public PluginRegistry.Registrar publish(Object paramObject)
  {
    FlutterPluginRegistry.access$500(this.this$0).put(this.pluginKey, paramObject);
    return this;
  }
  
  public TextureRegistry textures()
  {
    return FlutterPluginRegistry.access$300(this.this$0);
  }
  
  public FlutterView view()
  {
    return FlutterPluginRegistry.access$300(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.app.FlutterPluginRegistry.FlutterRegistrar
 * JD-Core Version:    0.7.0.1
 */