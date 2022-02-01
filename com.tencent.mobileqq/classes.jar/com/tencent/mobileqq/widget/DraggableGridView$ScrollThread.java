package com.tencent.mobileqq.widget;

import android.os.Handler;
import android.os.Message;
import bggq;
import com.tencent.mobileqq.app.ThreadManager;

class DraggableGridView$ScrollThread
  implements Runnable
{
  private int jdField_a_of_type_Int;
  private DraggableGridView jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView;
  boolean jdField_a_of_type_Boolean = true;
  
  public DraggableGridView$ScrollThread(DraggableGridView paramDraggableGridView)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView = paramDraggableGridView;
  }
  
  public void a(int paramInt)
  {
    if (paramInt != this.jdField_a_of_type_Int) {
      DraggableGridView.c(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView, 0);
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_Boolean = false;
      ThreadManager.post(this, 8, null, true);
    }
  }
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = 0;
      if (this.jdField_a_of_type_Int == 1) {
        i = bggq.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView.getContext(), 10.0F);
      }
      for (;;)
      {
        for (;;)
        {
          Message localMessage = new Message();
          localMessage.arg1 = i;
          DraggableGridView.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView).sendMessage(localMessage);
          try
          {
            Thread.sleep(16L);
          }
          catch (InterruptedException localInterruptedException) {}
        }
        break;
        if (this.jdField_a_of_type_Int == 2) {
          i = -bggq.a(this.jdField_a_of_type_ComTencentMobileqqWidgetDraggableGridView.getContext(), 10.0F);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.DraggableGridView.ScrollThread
 * JD-Core Version:    0.7.0.1
 */