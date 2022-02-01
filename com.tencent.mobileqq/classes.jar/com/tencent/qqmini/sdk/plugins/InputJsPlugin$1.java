package com.tencent.qqmini.sdk.plugins;

import com.tencent.qqmini.sdk.core.utils.SoftKeyboardStateHelper.SoftKeyboardStateListener;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.utils.DisplayUtil;
import com.tencent.qqmini.sdk.widget.KeyboardLayout;

class InputJsPlugin$1
  implements SoftKeyboardStateHelper.SoftKeyboardStateListener
{
  InputJsPlugin$1(InputJsPlugin paramInputJsPlugin) {}
  
  public void onSoftKeyboardClosed()
  {
    if ((InputJsPlugin.access$000(this.this$0) != null) && (InputJsPlugin.access$000(this.this$0).getVisibility() == 0)) {
      InputJsPlugin.access$000(this.this$0).setVisibility(8);
    }
    if ((InputJsPlugin.access$100(this.this$0) != null) && (InputJsPlugin.access$200(this.this$0).getAttachedActivity() != null)) {
      DisplayUtil.setActivityFullScreen(InputJsPlugin.access$300(this.this$0).getAttachedActivity());
    }
  }
  
  public void onSoftKeyboardOpened(int paramInt)
  {
    if ((InputJsPlugin.access$000(this.this$0) != null) && (InputJsPlugin.access$000(this.this$0).getVisibility() == 0)) {
      InputJsPlugin.access$000(this.this$0).setPaddingBottom(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.plugins.InputJsPlugin.1
 * JD-Core Version:    0.7.0.1
 */