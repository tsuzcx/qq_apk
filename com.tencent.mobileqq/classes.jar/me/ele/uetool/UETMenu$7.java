package me.ele.uetool;

import android.os.Handler;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import java.lang.reflect.Field;

class UETMenu$7
  implements View.OnTouchListener
{
  private float downX;
  private float downY;
  private float lastX;
  private float lastY;
  
  UETMenu$7(UETMenu paramUETMenu) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = UETMenu.access$800(this.this$0).getDefaultDisplay().getWidth();
    switch (paramMotionEvent.getAction())
    {
    default: 
      return true;
    case 0: 
      UETMenu.access$300(this.this$0);
      this.downX = paramMotionEvent.getRawX();
      this.downY = paramMotionEvent.getRawY();
      this.lastY = this.downY;
      this.lastX = this.downX;
      return true;
    case 2: 
      paramView = UETMenu.access$900(this.this$0);
      paramView.y = ((int)(paramView.y + (paramMotionEvent.getRawY() - this.lastY)));
      UETMenu.access$900(this.this$0).y = Math.max(0, UETMenu.access$900(this.this$0).y);
      paramView = UETMenu.access$900(this.this$0);
      paramView.x = ((int)(paramView.x + (paramMotionEvent.getRawX() - this.lastX)));
      UETMenu.access$900(this.this$0).x = Math.max(-UETMenu.access$1000(), UETMenu.access$900(this.this$0).x);
      UETMenu.access$900(this.this$0).x = Math.min(i + UETMenu.access$1100() - UETMenu.access$1000(), UETMenu.access$900(this.this$0).x);
      UETMenu.access$800(this.this$0).updateViewLayout(this.this$0, UETMenu.access$900(this.this$0));
      this.lastY = paramMotionEvent.getRawY();
      this.lastX = paramMotionEvent.getRawX();
      return true;
    }
    if (UETMenu.access$400(this.this$0))
    {
      if (UETMenu.access$900(this.this$0).x >= 0) {
        break label457;
      }
      UETMenu.access$1200(this.this$0);
    }
    for (;;)
    {
      for (;;)
      {
        UETMenu.access$102(this.this$0, System.currentTimeMillis());
        UETMenu.access$600(this.this$0).sendEmptyMessageDelayed(0, 5000L);
        if ((Math.abs(paramMotionEvent.getRawX() - this.downX) >= UETMenu.access$1300(this.this$0)) || (Math.abs(paramMotionEvent.getRawY() - this.downY) >= UETMenu.access$1300(this.this$0))) {
          break;
        }
        try
        {
          paramView = View.class.getDeclaredField("mListenerInfo");
          paramView.setAccessible(true);
          paramView = paramView.get(UETMenu.access$1400(this.this$0));
          paramMotionEvent = paramView.getClass().getDeclaredField("mOnClickListener");
          paramMotionEvent.setAccessible(true);
          paramView = paramMotionEvent.get(paramView);
          if ((paramView == null) || (!(paramView instanceof View.OnClickListener))) {
            break;
          }
          ((View.OnClickListener)paramView).onClick(UETMenu.access$1400(this.this$0));
          return true;
        }
        catch (Exception paramView)
        {
          paramView.printStackTrace();
          return true;
        }
      }
      label457:
      if (UETMenu.access$900(this.this$0).x > i - UETMenu.access$1100()) {
        UETMenu.access$1200(this.this$0);
      } else {
        UETMenu.access$500(this.this$0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     me.ele.uetool.UETMenu.7
 * JD-Core Version:    0.7.0.1
 */