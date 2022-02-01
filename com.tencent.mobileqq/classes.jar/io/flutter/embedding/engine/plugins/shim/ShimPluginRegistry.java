package io.flutter.embedding.engine.plugins.shim;

import androidx.annotation.NonNull;
import io.flutter.Log;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import java.util.HashMap;
import java.util.Map;

public class ShimPluginRegistry
  implements io.flutter.plugin.common.PluginRegistry
{
  private static final String TAG = "ShimPluginRegistry";
  private final FlutterEngine flutterEngine;
  private final Map<String, Object> pluginMap = new HashMap();
  private final ShimPluginRegistry.ShimRegistrarAggregate shimRegistrarAggregate;
  
  public ShimPluginRegistry(@NonNull FlutterEngine paramFlutterEngine)
  {
    this.flutterEngine = paramFlutterEngine;
    this.shimRegistrarAggregate = new ShimPluginRegistry.ShimRegistrarAggregate(null);
    this.flutterEngine.getPlugins().add(this.shimRegistrarAggregate);
  }
  
  public boolean hasPlugin(String paramString)
  {
    return this.pluginMap.containsKey(paramString);
  }
  
  public PluginRegistry.Registrar registrarFor(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("Creating plugin Registrar for '");
    localStringBuilder.append(paramString);
    localStringBuilder.append("'");
    Log.v("ShimPluginRegistry", localStringBuilder.toString());
    if (!this.pluginMap.containsKey(paramString))
    {
      this.pluginMap.put(paramString, null);
      paramString = new ShimRegistrar(paramString, this.pluginMap);
      this.shimRegistrarAggregate.addPlugin(paramString);
      return paramString;
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("Plugin key ");
    localStringBuilder.append(paramString);
    localStringBuilder.append(" is already in use");
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  public <T> T valuePublishedByPlugin(String paramString)
  {
    return this.pluginMap.get(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry
 * JD-Core Version:    0.7.0.1
 */