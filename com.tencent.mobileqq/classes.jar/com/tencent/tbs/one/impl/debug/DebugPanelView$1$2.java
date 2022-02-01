package com.tencent.tbs.one.impl.debug;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

class DebugPanelView$1$2
  implements Runnable
{
  DebugPanelView$1$2(DebugPanelView.1 param1, TBSOneDebugPlugin paramTBSOneDebugPlugin) {}
  
  public void run()
  {
    DebugPanelView.access$200(this.this$1.this$0);
    View localView = this.val$result.createDebuggingView(this.this$1.this$0.getContext(), DebugPanelView.access$300(this.this$1.this$0));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    this.this$1.this$0.addView(localView, localLayoutParams);
    DebugPanelView.access$000(this.this$1.this$0, "加载调试组件成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tbs.one.impl.debug.DebugPanelView.1.2
 * JD-Core Version:    0.7.0.1
 */