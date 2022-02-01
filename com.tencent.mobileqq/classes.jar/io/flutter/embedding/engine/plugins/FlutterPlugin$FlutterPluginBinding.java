package io.flutter.embedding.engine.plugins;

import android.content.Context;
import androidx.annotation.NonNull;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.platform.PlatformViewRegistry;
import io.flutter.view.TextureRegistry;

public class FlutterPlugin$FlutterPluginBinding
{
  private final Context applicationContext;
  private final BinaryMessenger binaryMessenger;
  private final FlutterPlugin.FlutterAssets flutterAssets;
  private final FlutterEngine flutterEngine;
  private final PlatformViewRegistry platformViewRegistry;
  private final TextureRegistry textureRegistry;
  
  public FlutterPlugin$FlutterPluginBinding(@NonNull Context paramContext, @NonNull FlutterEngine paramFlutterEngine, @NonNull BinaryMessenger paramBinaryMessenger, @NonNull TextureRegistry paramTextureRegistry, @NonNull PlatformViewRegistry paramPlatformViewRegistry, @NonNull FlutterPlugin.FlutterAssets paramFlutterAssets)
  {
    this.applicationContext = paramContext;
    this.flutterEngine = paramFlutterEngine;
    this.binaryMessenger = paramBinaryMessenger;
    this.textureRegistry = paramTextureRegistry;
    this.platformViewRegistry = paramPlatformViewRegistry;
    this.flutterAssets = paramFlutterAssets;
  }
  
  @NonNull
  public Context getApplicationContext()
  {
    return this.applicationContext;
  }
  
  @NonNull
  public BinaryMessenger getBinaryMessenger()
  {
    return this.binaryMessenger;
  }
  
  @NonNull
  public FlutterPlugin.FlutterAssets getFlutterAssets()
  {
    return this.flutterAssets;
  }
  
  @Deprecated
  @NonNull
  public FlutterEngine getFlutterEngine()
  {
    return this.flutterEngine;
  }
  
  @NonNull
  public PlatformViewRegistry getPlatformViewRegistry()
  {
    return this.platformViewRegistry;
  }
  
  @NonNull
  public TextureRegistry getTextureRegistry()
  {
    return this.textureRegistry;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding
 * JD-Core Version:    0.7.0.1
 */