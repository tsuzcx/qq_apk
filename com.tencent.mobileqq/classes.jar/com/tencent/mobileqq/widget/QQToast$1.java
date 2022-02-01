package com.tencent.mobileqq.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.qphone.base.util.QLog;

class QQToast$1
  implements View.OnTouchListener
{
  QQToast$1(QQToast paramQQToast, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QQToast", 2, "start to cancel toast");
      }
      this.val$toast.cancel();
      QQToast.access$002(this.this$0, true);
      View.OnTouchListener localOnTouchListener = this.val$touchListener;
      if (localOnTouchListener != null) {
        return localOnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.QQToast.1
 * JD-Core Version:    0.7.0.1
 */