package com.tencent.mobileqq.util;

import android.content.Context;
import android.view.View;
import android.view.View.DragShadowBuilder;
import bbbg;
import bbbk;
import bbbl;
import bcql;
import java.lang.ref.WeakReference;

class SystemDragUtils$TouchHandler$1$1
  implements Runnable
{
  SystemDragUtils$TouchHandler$1$1(SystemDragUtils.TouchHandler.1 param1, bbbk parambbbk) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_Bbbk != null) && (this.jdField_a_of_type_Bbbk.a()))
    {
      View.DragShadowBuilder localDragShadowBuilder = new View.DragShadowBuilder(this.jdField_a_of_type_Bbbk.jdField_a_of_type_AndroidViewView);
      this.jdField_a_of_type_Bbbk.jdField_a_of_type_AndroidViewView.startDrag(this.jdField_a_of_type_Bbbk.jdField_a_of_type_AndroidContentClipData, localDragShadowBuilder, "QQ_AIO_DRAG", 256);
    }
    for (;;)
    {
      bbbl.a(this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0, this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_Acxj);
      return;
      bcql.a((Context)this.jdField_a_of_type_ComTencentMobileqqUtilSystemDragUtils$TouchHandler$1.this$0.jdField_a_of_type_JavaLangRefWeakReference.get(), bbbg.b(), 0).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.TouchHandler.1.1
 * JD-Core Version:    0.7.0.1
 */