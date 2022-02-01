package com.tencent.mobileqq.widget;

import android.graphics.Rect;
import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

class CustomedTabWidget$MyHandler
  extends Handler
{
  private WeakReference<CustomedTabWidget> a;
  
  public CustomedTabWidget$MyHandler(CustomedTabWidget paramCustomedTabWidget)
  {
    this.a = new WeakReference(paramCustomedTabWidget);
  }
  
  public void handleMessage(Message arg1)
  {
    CustomedTabWidget localCustomedTabWidget = (CustomedTabWidget)this.a.get();
    if (localCustomedTabWidget == null) {
      return;
    }
    if (localCustomedTabWidget.d < 0.0F) {
      localCustomedTabWidget.invalidate((int)(localCustomedTabWidget.c.left + localCustomedTabWidget.d), localCustomedTabWidget.c.top, localCustomedTabWidget.c.right, localCustomedTabWidget.c.bottom);
    } else {
      localCustomedTabWidget.invalidate(localCustomedTabWidget.c.left, localCustomedTabWidget.c.top, (int)(localCustomedTabWidget.c.right + localCustomedTabWidget.d), localCustomedTabWidget.c.bottom);
    }
    synchronized (localCustomedTabWidget.a)
    {
      Rect localRect = localCustomedTabWidget.c;
      localRect.left = ((int)(localRect.left + localCustomedTabWidget.d));
      localRect = localCustomedTabWidget.c;
      localRect.right = ((int)(localRect.right + localCustomedTabWidget.d));
      if ((localCustomedTabWidget.b.left - localCustomedTabWidget.c.left) / localCustomedTabWidget.d >= 1.0F)
      {
        sendEmptyMessage(0);
        return;
      }
      localCustomedTabWidget.c.set(localCustomedTabWidget.b.left, localCustomedTabWidget.b.top, localCustomedTabWidget.b.right, localCustomedTabWidget.b.bottom);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget.MyHandler
 * JD-Core Version:    0.7.0.1
 */