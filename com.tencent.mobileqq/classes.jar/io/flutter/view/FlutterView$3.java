package io.flutter.view;

import io.flutter.plugin.common.ActivityLifecycleListener;
import io.flutter.plugin.platform.PlatformPlugin;

class FlutterView$3
  implements ActivityLifecycleListener
{
  FlutterView$3(FlutterView paramFlutterView, PlatformPlugin paramPlatformPlugin) {}
  
  public void onPostResume()
  {
    this.val$platformPlugin.updateSystemUiOverlays();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     io.flutter.view.FlutterView.3
 * JD-Core Version:    0.7.0.1
 */