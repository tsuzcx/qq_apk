package io.flutter.plugin.platform;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel;
import io.flutter.embedding.engine.systemchannels.PlatformViewsChannel.PlatformViewCreationRequest;

class PlatformViewsController$1$1
  implements View.OnFocusChangeListener
{
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (paramBoolean) {
      PlatformViewsController.access$900(this.this$1.this$0).invokeViewFocused(this.val$request.viewId);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     io.flutter.plugin.platform.PlatformViewsController.1.1
 * JD-Core Version:    0.7.0.1
 */