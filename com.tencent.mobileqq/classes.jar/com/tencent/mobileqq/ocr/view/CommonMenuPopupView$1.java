package com.tencent.mobileqq.ocr.view;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.BubblePopupWindow;

class CommonMenuPopupView$1
  implements Runnable
{
  CommonMenuPopupView$1(CommonMenuPopupView paramCommonMenuPopupView, View paramView, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    Context localContext = this.a.getContext();
    if (((localContext instanceof Activity)) && (!((Activity)localContext).isFinishing())) {
      try
      {
        CommonMenuPopupView.a(this.this$0).showAtLocation(this.a, this.b, this.c, true);
        return;
      }
      catch (Exception localException)
      {
        QLog.e("CommonMenuPopupView", 1, "showAtLocation fail, ", localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.view.CommonMenuPopupView.1
 * JD-Core Version:    0.7.0.1
 */