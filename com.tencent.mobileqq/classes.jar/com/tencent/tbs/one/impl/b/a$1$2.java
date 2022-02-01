package com.tencent.tbs.one.impl.b;

import android.view.View;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.tbs.one.optional.TBSOneDebugPlugin;

final class a$1$2
  implements Runnable
{
  a$1$2(a.1 param1, TBSOneDebugPlugin paramTBSOneDebugPlugin) {}
  
  public final void run()
  {
    a.a(this.b.a);
    View localView = this.a.createDebuggingView(this.b.a.getContext(), a.b(this.b.a));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    this.b.a.addView(localView, localLayoutParams);
    a.a(this.b.a, "加载调试组件成功");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tbs.one.impl.b.a.1.2
 * JD-Core Version:    0.7.0.1
 */