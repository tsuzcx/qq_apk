package io.flutter.embedding.engine.plugins;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.content.Context;
import android.support.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;

public class FlutterPlugin$FlutterPluginBinding
  implements LifecycleOwner
{
  private final Context applicationContext;
  private final FlutterEngine flutterEngine;
  private final Lifecycle lifecycle;
  
  public FlutterPlugin$FlutterPluginBinding(@NonNull Context paramContext, @NonNull FlutterEngine paramFlutterEngine, @NonNull Lifecycle paramLifecycle)
  {
    this.applicationContext = paramContext;
    this.flutterEngine = paramFlutterEngine;
    this.lifecycle = paramLifecycle;
  }
  
  @NonNull
  public Context getApplicationContext()
  {
    return this.applicationContext;
  }
  
  @NonNull
  public FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  @NonNull
  public Lifecycle getLifecycle()
  {
    return this.lifecycle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
 * JD-Core Version:    0.7.0.1
 */