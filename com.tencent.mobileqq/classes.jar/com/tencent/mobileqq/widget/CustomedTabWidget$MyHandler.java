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
    if (localCustomedTabWidget.jdField_a_of_type_Float < 0.0F) {
      localCustomedTabWidget.invalidate((int)(localCustomedTabWidget.b.left + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.top, localCustomedTabWidget.b.right, localCustomedTabWidget.b.bottom);
    } else {
      localCustomedTabWidget.invalidate(localCustomedTabWidget.b.left, localCustomedTabWidget.b.top, (int)(localCustomedTabWidget.b.right + localCustomedTabWidget.jdField_a_of_type_Float), localCustomedTabWidget.b.bottom);
    }
    synchronized (localCustomedTabWidget.jdField_a_of_type_ComTencentMobileqqWidgetCustomedTabWidget$MyHandler)
    {
      Rect localRect = localCustomedTabWidget.b;
      localRect.left = ((int)(localRect.left + localCustomedTabWidget.jdField_a_of_type_Float));
      localRect = localCustomedTabWidget.b;
      localRect.right = ((int)(localRect.right + localCustomedTabWidget.jdField_a_of_type_Float));
      if ((localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.left - localCustomedTabWidget.b.left) / localCustomedTabWidget.jdField_a_of_type_Float >= 1.0F)
      {
        sendEmptyMessage(0);
        return;
      }
      localCustomedTabWidget.b.set(localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.left, localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.top, localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.right, localCustomedTabWidget.jdField_a_of_type_AndroidGraphicsRect.bottom);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.CustomedTabWidget.MyHandler
 * JD-Core Version:    0.7.0.1
 */