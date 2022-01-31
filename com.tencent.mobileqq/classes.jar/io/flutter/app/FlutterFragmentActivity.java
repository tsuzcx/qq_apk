package io.flutter.app;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
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
  private final FlutterActivityEvents eventDelegate = this.delegate;
  private final PluginRegistry pluginRegistry = this.delegate;
  private final FlutterView.Provider viewProvider = this.delegate;
  
  public FlutterNativeView createFlutterNativeView()
  {
    return null;
  }
  
  public FlutterView createFlutterView(Context paramContext)
  {
    return null;
  }
  
  public FlutterView getFlutterView()
  {
    return this.viewProvider.getFlutterView();
  }
  
  public final boolean hasPlugin(String paramString)
  {
    return this.pluginRegistry.hasPlugin(paramString);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
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
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.eventDelegate.onCreate(paramBundle);
  }
  
  public void onDestroy()
  {
    this.eventDelegate.onDestroy();
    super.onDestroy();
  }
  
  public void onLowMemory()
  {
    this.eventDelegate.onLowMemory();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    this.eventDelegate.onNewIntent(paramIntent);
  }
  
  public void onPause()
  {
    super.onPause();
    this.eventDelegate.onPause();
  }
  
  public void onPostResume()
  {
    super.onPostResume();
    this.eventDelegate.onPostResume();
  }
  
  public void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    this.eventDelegate.onRequestPermissionsResult(paramInt, paramArrayOfString, paramArrayOfInt);
  }
  
  public void onStart()
  {
    super.onStart();
    this.eventDelegate.onStart();
  }
  
  public void onStop()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     io.flutter.app.FlutterFragmentActivity
 * JD-Core Version:    0.7.0.1
 */