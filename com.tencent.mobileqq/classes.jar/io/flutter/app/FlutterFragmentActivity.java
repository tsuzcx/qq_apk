package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import androidx.fragment.app.FragmentActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugin.common.PluginRegistry.Registrar;
import io.flutter.view.FlutterNativeView;
import io.flutter.view.FlutterView;
import io.flutter.view.FlutterView.Provider;

public class FlutterFragmentActivity
  extends FragmentActivity
  implements FlutterActivityDelegate.ViewFactory, PluginRegistry, FlutterView.Provider
{
  private final FlutterActivityDelegate delegate = new FlutterActivityDelegate(this, this);
  private final FlutterActivityEvents eventDelegate;
  private final PluginRegistry pluginRegistry;
  private final FlutterView.Provider viewProvider;
  
  public FlutterFragmentActivity()
  {
    FlutterActivityDelegate localFlutterActivityDelegate = this.delegate;
    this.eventDelegate = localFlutterActivityDelegate;
    this.viewProvider = localFlutterActivityDelegate;
    this.pluginRegistry = localFlutterActivityDelegate;
  }
  
  public FlutterNativeView createFlutterNativeView()
  {
    return null;
  }
  
  public FlutterView createFlutterView(Context paramContext)
  {
    return null;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public FlutterView getFlutterView()
  {
    return this.viewProvider.getFlutterView();
  }
  
  public final boolean hasPlugin(String paramString)
  {
    return this.pluginRegistry.hasPlugin(paramString);
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if (!this.eventDelegate.onActivityResult(paramInt1, paramInt2, paramIntent)) {
      super.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (!this.eventDelegate.onBackPressed()) {
      super.onBackPressed();
    }
  }
  
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    this.eventDelegate.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eventDelegate.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    this.eventDelegate.onDestroy();
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    this.eventDelegate.onLowMemory();
  }
  
  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    this.eventDelegate.onNewIntent(paramIntent);
  }
  
  protected void onPause()
  {
    super.onPause();
    this.eventDelegate.onPause();
  }
  
  protected void onPostResume()
  {
    super.onPostResume();
    this.eventDelegate.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    super.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
    this.eventDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  protected void onStart()
  {
    super.onStart();
    this.eventDelegate.onStart();
  }
  
  protected void onStop()
  {
    this.eventDelegate.onStop();
    super.onStop();
  }
  
  public void onTrimMemory(int paramInt)
  {
    this.eventDelegate.onTrimMemory(paramInt);
  }
  
  public void onUserLeaveHint()
  {
    this.eventDelegate.onUserLeaveHint();
  }
  
  public final PluginRegistry.Registrar registrarFor(String paramString)
  {
    return this.pluginRegistry.registrarFor(paramString);
  }
  
  public boolean retainFlutterNativeView()
  {
    return false;
  }
  
  public final <T> T valuePublishedByPlugin(String paramString)
  {
    return this.pluginRegistry.valuePublishedByPlugin(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.app.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */