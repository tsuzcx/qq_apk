package com.tencent.tkd.comment.publisher.base;

import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.view.WindowManager.LayoutParams;

class BasePublishFragment$2
  implements Runnable
{
  BasePublishFragment$2(BasePublishFragment paramBasePublishFragment) {}
  
  public void run()
  {
    Window localWindow = this.this$0.getDialog().getWindow();
    localWindow.setGravity(BasePublishFragment.access$000(this.this$0));
    WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
    localLayoutParams.y = 0;
    localWindow.setAttributes(localLayoutParams);
    BasePublishFragment.access$100(this.this$0).requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tkd.comment.publisher.base.BasePublishFragment.2
 * JD-Core Version:    0.7.0.1
 */