package io.flutter.embedding.engine.plugins.shim;

import android.support.annotation.NonNull;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class ShimPluginRegistry$ShimRegistrarAggregate
  implements FlutterPlugin, ActivityAware
{
  private ActivityPluginBinding activityPluginBinding;
  private FlutterPlugin.FlutterPluginBinding flutterPluginBinding;
  private final Set<ShimRegistrar> shimRegistrars = new HashSet();
  
  public void addPlugin(@NonNull ShimRegistrar paramShimRegistrar)
  {
    this.shimRegistrars.add(paramShimRegistrar);
    if (this.flutterPluginBinding != null) {
      paramShimRegistrar.onAttachedToEngine(this.flutterPluginBinding);
    }
    if (this.activityPluginBinding != null) {
      paramShimRegistrar.onAttachedToActivity(this.activityPluginBinding);
    }
  }
  
  public void onAttachedToActivity(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    this.activityPluginBinding = paramActivityPluginBinding;
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onAttachedToActivity(paramActivityPluginBinding);
    }
  }
  
  public void onAttachedToEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    this.flutterPluginBinding = paramFlutterPluginBinding;
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onAttachedToEngine(paramFlutterPluginBinding);
    }
  }
  
  public void onDetachedFromActivity()
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
    }
  }
  
  public void onDetachedFromActivityForConfigChanges()
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onDetachedFromActivity();
    }
    this.activityPluginBinding = null;
  }
  
  public void onDetachedFromEngine(@NonNull FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onDetachedFromEngine(paramFlutterPluginBinding);
    }
    this.flutterPluginBinding = null;
  }
  
  public void onReattachedToActivityForConfigChanges(@NonNull ActivityPluginBinding paramActivityPluginBinding)
  {
    Iterator localIterator = this.shimRegistrars.iterator();
    while (localIterator.hasNext()) {
      ((ShimRegistrar)localIterator.next()).onReattachedToActivityForConfigChanges(paramActivityPluginBinding);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.plugins.shim.ShimPluginRegistry.ShimRegistrarAggregate
 * JD-Core Version:    0.7.0.1
 */