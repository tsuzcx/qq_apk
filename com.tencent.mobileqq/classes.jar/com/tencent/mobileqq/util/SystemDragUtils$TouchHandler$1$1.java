package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import android.view.View.DragShadowBuilder;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1$1(SystemDragUtils.TouchHandler.1 param1, SystemDragUtils.DropItem paramDropItem) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$DropItem != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$DropItem.a()))
    {
      View.DragShadowBuilder localDragShadowBuilder = new View.DragShadowBuilder(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$DropItem.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$DropItem.jdField_a_of_type_AndroidViewView.startDrag(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$DropItem.jdField_a_of_type_AndroidContentClipData, localDragShadowBuilder, "QQ_AIO_DRAG", 256);
    }
    for (;;)
    {
      SystemDragUtils.TouchHandler.a(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0, this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_ComTencentMobileqqActivityAioOnLongClickAndTouchListener);
      return;
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_JavaLangRefWeakReference.get(), SystemDragUtils.b(), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1.1
 * JD-Core Version:    0.7.0.1
 */