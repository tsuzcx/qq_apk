package io.flutter.view;

import android.database.ContentObserver;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Handler;
import android.provider.Settings.Global;

class AccessibilityBridge$3
  extends ContentObserver
{
  AccessibilityBridge$3(AccessibilityBridge paramAccessibilityBridge, Handler paramHandler)
  {
    super(paramHandler);
  }
  
  public void onChange(boolean paramBoolean)
  {
    onChange(paramBoolean, null);
  }
  
  public void onChange(boolean paramBoolean, Uri paramUri)
  {
    if (AccessibilityBridge.access$400(this.this$0)) {
      return;
    }
    if (Build.VERSION.SDK_INT < 17) {
      paramUri = null;
    } else {
      paramUri = Settings.Global.getString(AccessibilityBridge.access$900(this.this$0), "transition_animation_scale");
    }
    int i;
    if ((paramUri != null) && (paramUri.equals("0"))) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0)
    {
      paramUri = this.this$0;
      i = AccessibilityBridge.access$1000(paramUri) | AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value;
    }
    else
    {
      paramUri = this.this$0;
      i = AccessibilityBridge.access$1000(paramUri) & (AccessibilityBridge.AccessibilityFeature.DISABLE_ANIMATIONS.value ^ 0xFFFFFFFF);
    }
    AccessibilityBridge.access$1002(paramUri, i);
    AccessibilityBridge.access$1100(this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     io.flutter.view.AccessibilityBridge.3
 * JD-Core Version:    0.7.0.1
 */