package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;

class PlatformViewsController$VirtualDisplayViewFocusListener
  implements View.OnFocusChangeListener
{
  private PlatformViewsChannel platformViewsChannel;
  private int viewId;
  
  public PlatformViewsController$VirtualDisplayViewFocusListener(PlatformViewsController paramPlatformViewsController, int paramInt, PlatformViewsChannel paramPlatformViewsChannel)
  {
    this.viewId = paramInt;
    this.platformViewsChannel = paramPlatformViewsChannel;
  }
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if ((paramBoolean) && (this.platformViewsChannel != null)) {
      this.platformViewsChannel.invokeViewFocused(this.viewId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController.VirtualDisplayViewFocusListener
 * JD-Core Version:    0.7.0.1
 */