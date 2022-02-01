package com.tencent.mobileqq.webview.swift.component;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import com.tencent.qphone.base.util.QLog;

class SwiftBrowserScreenShotHandler$2
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  SwiftBrowserScreenShotHandler$2(SwiftBrowserScreenShotHandler paramSwiftBrowserScreenShotHandler, View paramView) {}
  
  public void onGlobalLayout()
  {
    Object localObject = new Rect();
    this.a.getWindowVisibleDisplayFrame((Rect)localObject);
    int i = this.a.getRootView().getHeight() - ((Rect)localObject).height();
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("heightDiff:");
      ((StringBuilder)localObject).append(i);
      QLog.d("SwiftBrowserScreenShotHandler", 2, ((StringBuilder)localObject).toString());
    }
    if (i > 150)
    {
      localObject = this.b;
      ((SwiftBrowserScreenShotHandler)localObject).o = true;
      ((SwiftBrowserScreenShotHandler)localObject).a(false, 0);
      return;
    }
    if (this.b.o) {
      this.b.o = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.webview.swift.component.SwiftBrowserScreenShotHandler.2
 * JD-Core Version:    0.7.0.1
 */