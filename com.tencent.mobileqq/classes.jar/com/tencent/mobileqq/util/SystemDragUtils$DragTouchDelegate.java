package com.tencent.mobileqq.util;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.View.OnTouchListener;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import java.util.ArrayList;
import java.util.List;

public class SystemDragUtils$DragTouchDelegate
  implements OnLongClickAndTouchListener
{
  List<View.OnTouchListener> a = new ArrayList();
  List<View.OnLongClickListener> b = new ArrayList();
  List<OnLongClickAndTouchListener> c = new ArrayList();
  
  void a(View.OnTouchListener paramOnTouchListener)
  {
    this.a.add(paramOnTouchListener);
  }
  
  void a(OnLongClickAndTouchListener paramOnLongClickAndTouchListener)
  {
    this.c.add(paramOnLongClickAndTouchListener);
  }
  
  public boolean onLongClick(View paramView)
  {
    for (int i = 0;; i = 0) {
      try
      {
        while (i < this.b.size())
        {
          ((View.OnLongClickListener)this.b.get(i)).onLongClick(paramView);
          i += 1;
          continue;
          while (i < this.c.size())
          {
            ((View.OnLongClickListener)this.c.get(i)).onLongClick(paramView);
            i += 1;
          }
          return false;
        }
      }
      finally {}
    }
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    for (int i = 0;; i = 0) {
      try
      {
        while (i < this.a.size())
        {
          ((View.OnTouchListener)this.a.get(i)).onTouch(paramView, paramMotionEvent);
          i += 1;
          continue;
          while (i < this.c.size())
          {
            ((OnLongClickAndTouchListener)this.c.get(i)).onTouch(paramView, paramMotionEvent);
            i += 1;
          }
          return false;
        }
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.DragTouchDelegate
 * JD-Core Version:    0.7.0.1
 */