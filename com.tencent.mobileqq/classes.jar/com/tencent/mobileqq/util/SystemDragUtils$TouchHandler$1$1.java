package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import android.view.View.DragShadowBuilder;
import bdaa;
import bdae;
import bdaf;
import com.tencent.mobileqq.widget.QQToast;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1$1(SystemDragUtils.TouchHandler.1 param1, bdae parambdae) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bdae != null) && (this.jdField_a_of_type_Bdae.a()))
    {
      View.DragShadowBuilder localDragShadowBuilder = new View.DragShadowBuilder(this.jdField_a_of_type_Bdae.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Bdae.jdField_a_of_type_AndroidViewView.startDrag(this.jdField_a_of_type_Bdae.jdField_a_of_type_AndroidContentClipData, localDragShadowBuilder, "QQ_AIO_DRAG", 256);
    }
    for (;;)
    {
      bdaf.a(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0, this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_Aeov);
      return;
      QQToast.a((Context)this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_JavaLangRefWeakReference.get(), bdaa.b(), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1.1
 * JD-Core Version:    0.7.0.1
 */