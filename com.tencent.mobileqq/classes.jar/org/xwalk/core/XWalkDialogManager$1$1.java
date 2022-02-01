package org.xwalk.core;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class XWalkDialogManager$1$1
  implements View.OnClickListener
{
  XWalkDialogManager$1$1(XWalkDialogManager.1 param1, Runnable paramRunnable) {}
  
  public void onClick(View paramView)
  {
    this.this$1.this$0.dismissDialog();
    this.val$command.run();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.XWalkDialogManager.1.1
 * JD-Core Version:    0.7.0.1
 */