package com.tencent.mobileqq.tablequery;

import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import com.tencent.mobileqq.util.DisplayUtil;

class TableQueryViewer$2
  implements View.OnTouchListener
{
  TableQueryViewer$2(TableQueryViewer paramTableQueryViewer) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    paramView = this.a.getContext();
    int i = paramMotionEvent.getAction();
    int j = (int)paramMotionEvent.getRawY();
    if (i == 0)
    {
      TableQueryViewer.a(this.a, (int)paramMotionEvent.getY());
      return false;
    }
    if (i == 2)
    {
      if ((TableQueryViewer.b(this.a)) || (Math.abs(paramMotionEvent.getY() - TableQueryViewer.c(this.a)) > DisplayUtil.a(paramView, 10.0F)))
      {
        TableQueryViewer.a(this.a, true);
        paramMotionEvent = (WindowManager.LayoutParams)this.a.getLayoutParams();
        paramMotionEvent.y = (j - TableQueryViewer.c(this.a) - DisplayUtil.a(paramView, 0.0F));
        i = TableQueryViewer.d(this.a).getDefaultDisplay().getHeight();
        if (paramMotionEvent.y < 0) {
          paramMotionEvent.y = 0;
        } else if (paramMotionEvent.y > i - this.a.getHeight()) {
          paramMotionEvent.y = (i - this.a.getHeight());
        }
        TableQueryViewer.d(this.a).updateViewLayout(TableQueryViewer.e(this.a), paramMotionEvent);
      }
      return true;
    }
    if ((i != 1) && (i == 3)) {}
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.tablequery.TableQueryViewer.2
 * JD-Core Version:    0.7.0.1
 */