package io.flutter.view;

import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.platform.PlatformPlugin;

class FlutterView$4
  implements ActivityLifecycleListener
{
  FlutterView$4(FlutterView paramFlutterView, PlatformPlugin paramPlatformPlugin) {}
  
  public void onPostResume()
  {
    this.val$platformPlugin.updateSystemUiOverlays();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.FlutterView.4
 * JD-Core Version:    0.7.0.1
 */