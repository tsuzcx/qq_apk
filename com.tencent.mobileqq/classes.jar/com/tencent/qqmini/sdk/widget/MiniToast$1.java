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
    boolean bool = true;
    if (paramMotionEvent.getAction() == 0)
    {
      QMLog.d("QQToast", "start to cancel toast");
      this.val$toast.cancel();
      MiniToast.access$102(this.this$0, true);
      if (this.val$touchListener != null) {
        bool = this.val$touchListener.onTouch(paramView, paramMotionEvent);
      }
      return bool;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.widget.MiniToast.1
 * JD-Core Version:    0.7.0.1
 */