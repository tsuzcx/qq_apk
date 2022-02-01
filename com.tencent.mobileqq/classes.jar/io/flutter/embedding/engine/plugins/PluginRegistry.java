package io.flutter.embedding.engine.plugins;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import java.util.Set;

public abstract interface PluginRegistry
{
  public abstract void add(@NonNull FlutterPlugin paramFlutterPlugin);
  
  public abstract void add(@NonNull Set<FlutterPlugin> paramSet);
  
  @Nullable
  public abstract FlutterPlugin get(@NonNull Class<? extends FlutterPlugin> paramClass);
  
  public abstract boolean has(@NonNull Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(@NonNull Class<? extends FlutterPlugin> paramClass);
  
  public abstract void remove(@NonNull Set<Class<? extends FlutterPlugin>> paramSet);
  
  public abstract void removeAll();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.PluginRegistry
 * JD-Core Version:    0.7.0.1
 */