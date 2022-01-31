package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import avuo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;

public class CommonMenuPopupView$1
  implements Runnable
{
  public CommonMenuPopupView$1(avuo paramavuo, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = this.jdField_a_of_type_AndroidViewView.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {}
    try
    {
      avuo.a(this.this$0).a(this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_Int, this.b, true);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("CommonMenuPopupView", 1, "showAtLocation fail, ", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1
 * JD-Core Version:    0.7.0.1
 */