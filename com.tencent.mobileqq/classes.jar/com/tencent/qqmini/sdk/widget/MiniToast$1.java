package com.tencent.qqmini.sdk.widget;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Toast;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

class MiniToast$1
  implements View.OnTouchListener
{
  MiniToast$1(MiniToast paramMiniToast, Toast paramToast, View.OnTouchListener paramOnTouchListener) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      QMLog.d("QQToast", "start to cancel toast");
      this.val$toast.cancel();
      MiniToast.access$102(this.this$0, true);
      View.OnTouchListener localOnTouchListener = this.val$touchListener;
      if (localOnTouchListener != null) {
        return localOnTouchListener.onTouch(paramView, paramMotionEvent);
      }
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.1
 * JD-Core Version:    0.7.0.1
 */