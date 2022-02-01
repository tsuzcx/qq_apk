package io.flutter.embedding.engine;

import androidx.annotation.NonNull;
import io.flutter.embedding.engine.loader.FlutterLoader;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterAssets;

class FlutterEnginePluginRegistry$DefaultFlutterAssets
  implements FlutterPlugin.FlutterAssets
{
  final FlutterLoader flutterLoader;
  
  private FlutterEnginePluginRegistry$DefaultFlutterAssets(@NonNull FlutterLoader paramFlutterLoader)
  {
    this.flutterLoader = paramFlutterLoader;
  }
  
  public String getAssetFilePathByName(@NonNull String paramString)
  {
    return this.flutterLoader.getLookupKeyForAsset(paramString);
  }
  
  public String getAssetFilePathByName(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
  }
  
  public String getAssetFilePathBySubpath(@NonNull String paramString)
  {
    return this.flutterLoader.getLookupKeyForAsset(paramString);
  }
  
  public String getAssetFilePathBySubpath(@NonNull String paramString1, @NonNull String paramString2)
  {
    return this.flutterLoader.getLookupKeyForAsset(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry.DefaultFlutterAssets
 * JD-Core Version:    0.7.0.1
 */