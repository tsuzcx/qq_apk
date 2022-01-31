package io.flutter.embedding.engine;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import io.flutter.plugin.common.PluginRegistry.NewIntentListener;
import io.flutter.plugin.common.PluginRegistry.RequestPermissionsResultListener;
import io.flutter.plugin.common.PluginRegistry.UserLeaveHintListener;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

class FlutterEnginePluginRegistry$FlutterEngineActivityPluginBinding
  implements ActivityPluginBinding
{
  @NonNull
  private final Activity activity;
  @NonNull
  private final Set<PluginRegistry.ActivityResultListener> onActivityResultListeners = new HashSet();
  @NonNull
  private final Set<PluginRegistry.NewIntentListener> onNewIntentListeners = new HashSet();
  @NonNull
  private final Set<PluginRegistry.RequestPermissionsResultListener> onRequestPermissionsResultListeners = new HashSet();
  @NonNull
  private final Set<PluginRegistry.UserLeaveHintListener> onUserLeaveHintListeners = new HashSet();
  
  public FlutterEnginePluginRegistry$FlutterEngineActivityPluginBinding(@NonNull Activity paramActivity)
  {
    this.activity = paramActivity;
  }
  
  public void addActivityResultListener(@NonNull PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    this.onActivityResultListeners.add(paramActivityResultListener);
  }
  
  public void addOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    this.onNewIntentListeners.add(paramNewIntentListener);
  }
  
  public void addOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    this.onUserLeaveHintListeners.add(paramUserLeaveHintListener);
  }
  
  public void addRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    this.onRequestPermissionsResultListeners.add(paramRequestPermissionsResultListener);
  }
  
  @NonNull
  public Activity getActivity()
  {
    return this.activity;
  }
  
  boolean onActivityResult(int paramInt1, int paramInt2, @Nullable Intent paramIntent)
  {
    Iterator localIterator = this.onActivityResultListeners.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        break label56;
      }
      if ((!((PluginRegistry.ActivityResultListener)localIterator.next()).onActivityResult(paramInt1, paramInt2, paramIntent)) && (!bool)) {
        break;
      }
    }
    label56:
    return bool;
  }
  
  void onNewIntent(@Nullable Intent paramIntent)
  {
    Iterator localIterator = this.onNewIntentListeners.iterator();
    while (localIterator.hasNext()) {
      ((PluginRegistry.NewIntentListener)localIterator.next()).onNewIntent(paramIntent);
    }
  }
  
  boolean onRequestPermissionsResult(int paramInt, @NonNull String[] paramArrayOfString, @NonNull int[] paramArrayOfInt)
  {
    Iterator localIterator = this.onRequestPermissionsResultListeners.iterator();
    for (boolean bool = false;; bool = true)
    {
      if (!localIterator.hasNext()) {
        break label56;
      }
      if ((!((PluginRegistry.RequestPermissionsResultListener)localIterator.next()).onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt)) && (!bool)) {
        break;
      }
    }
    label56:
    return bool;
  }
  
  void onUserLeaveHint()
  {
    Iterator localIterator = this.onUserLeaveHintListeners.iterator();
    while (localIterator.hasNext()) {
      ((PluginRegistry.UserLeaveHintListener)localIterator.next()).onUserLeaveHint();
    }
  }
  
  public void removeActivityResultListener(@NonNull PluginRegistry.ActivityResultListener paramActivityResultListener)
  {
    this.onActivityResultListeners.remove(paramActivityResultListener);
  }
  
  public void removeOnNewIntentListener(@NonNull PluginRegistry.NewIntentListener paramNewIntentListener)
  {
    this.onNewIntentListeners.remove(paramNewIntentListener);
  }
  
  public void removeOnUserLeaveHintListener(@NonNull PluginRegistry.UserLeaveHintListener paramUserLeaveHintListener)
  {
    this.onUserLeaveHintListeners.remove(paramUserLeaveHintListener);
  }
  
  public void removeRequestPermissionsResultListener(@NonNull PluginRegistry.RequestPermissionsResultListener paramRequestPermissionsResultListener)
  {
    this.onRequestPermissionsResultListeners.remove(paramRequestPermissionsResultListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.embedding.engine.FlutterEnginePluginRegistry.FlutterEngineActivityPluginBinding
 * JD-Core Version:    0.7.0.1
 */