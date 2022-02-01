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
    i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.b.size()) {
          continue;
        }
        ((View.OnLongClickListener)this.b.get(i)).onLongClick(paramView);
        i += 1;
        continue;
      }
      finally
      {
        continue;
        throw paramView;
        continue;
        i = 0;
        continue;
      }
      if (i >= this.c.size()) {
        continue;
      }
      ((View.OnLongClickListener)this.c.get(i)).onLongClick(paramView);
      i += 1;
    }
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    i = 0;
    for (;;)
    {
      try
      {
        if (i >= this.a.size()) {
          continue;
        }
        ((View.OnTouchListener)this.a.get(i)).onTouch(paramView, paramMotionEvent);
        i += 1;
        continue;
      }
      finally
      {
        continue;
        throw paramView;
        continue;
        i = 0;
        continue;
      }
      if (i >= this.c.size()) {
        continue;
      }
      ((OnLongClickAndTouchListener)this.c.get(i)).onTouch(paramView, paramMotionEvent);
      i += 1;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.util.SystemDragUtils.DragTouchDelegate
 * JD-Core Version:    0.7.0.1
 */