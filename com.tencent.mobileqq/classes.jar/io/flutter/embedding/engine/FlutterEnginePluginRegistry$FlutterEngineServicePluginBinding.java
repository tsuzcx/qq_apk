package io.flutter.embedding.engine;

import android.app.Service;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.Lifecycle;
import io.flutter.embedding.engine.plugins.lifecycle.HiddenLifecycleReference;
import io.flutter.embedding.engine.plugins.service.ServiceAware.OnModeChangeListener;
import io.flutter.embedding.engine.plugins.service.ServicePluginBinding;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class FlutterEnginePluginRegistry$FlutterEngineServicePluginBinding
  implements ServicePluginBinding
{
  @Nullable
  private final HiddenLifecycleReference hiddenLifecycleReference;
  @NonNull
  private final Set<ServiceAware.OnModeChangeListener> onModeChangeListeners = new HashSet();
  @NonNull
  private final Service service;
  
  FlutterEnginePluginRegistry$FlutterEngineServicePluginBinding(@NonNull Service paramService, @Nullable Lifecycle paramLifecycle)
  {
    this.service = paramService;
    if (paramLifecycle != null) {}
    for (paramService = new HiddenLifecycleReference(paramLifecycle);; paramService = null)
    {
      this.hiddenLifecycleReference = paramService;
      return;
    }
  }
  
  public void addOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener paramOnModeChangeListener)
  {
    this.onModeChangeListeners.add(paramOnModeChangeListener);
  }
  
  @Nullable
  public Object getLifecycle()
  {
    return this.hiddenLifecycleReference;
  }
  
  @NonNull
  public Service getService()
  {
    return this.service;
  }
  
  void onMoveToBackground()
  {
    Iterator localIterator = this.onModeChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((ServiceAware.OnModeChangeListener)localIterator.next()).onMoveToBackground();
    }
  }
  
  void onMoveToForeground()
  {
    Iterator localIterator = this.onModeChangeListeners.iterator();
    while (localIterator.hasNext()) {
      ((ServiceAware.OnModeChangeListener)localIterator.next()).onMoveToForeground();
    }
  }
  
  public void removeOnModeChangeListener(@NonNull ServiceAware.OnModeChangeListener paramOnModeChangeListener)
  {
    this.onModeChangeListeners.remove(paramOnModeChangeListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry.FlutterEngineServicePluginBinding
 * JD-Core Version:    0.7.0.1
 */