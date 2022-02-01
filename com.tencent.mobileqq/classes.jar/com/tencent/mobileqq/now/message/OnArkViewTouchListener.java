package com.tencent.mobileqq.now.message;

import android.view.MotionEvent;
import android.view.View;
import com.tencent.mobileqq.activity.aio.OnLongClickAndTouchListener;
import com.tencent.mobileqq.activity.aio.item.ArkAppView;

public class OnArkViewTouchListener
  implements OnLongClickAndTouchListener
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  private float c;
  private float d;
  
  public boolean onClick(View paramView)
  {
    return false;
  }
  
  public boolean onLongClick(View paramView)
  {
    return false;
  }
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if (i != 1)
      {
        if (i == 2)
        {
          this.c += Math.abs(paramMotionEvent.getX() - this.jdField_a_of_type_Float);
          this.d += Math.abs(paramMotionEvent.getY() - this.b);
          this.jdField_a_of_type_Float = paramMotionEvent.getX();
          this.b = paramMotionEvent.getY();
        }
      }
      else if (((System.currentTimeMillis() - this.jdField_a_of_type_Long <= 200L) || ((this.c <= 20.0F) && (this.d <= 20.0F))) && (onClick(paramView))) {
        return true;
      }
    }
    else
    {
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.b = paramMotionEvent.getY();
      this.c = 0.0F;
      this.d = 0.0F;
      this.jdField_a_of_type_Long = System.currentTimeMillis();
    }
    if ((paramView instanceof ArkAppView)) {
      return ((ArkAppView)paramView).onTouch(paramView, paramMotionEvent);
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.now.message.OnArkViewTouchListener
 * JD-Core Version:    0.7.0.1
 */