package com.tencent.mobileqq.olympic.activity;

import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import android.view.ViewGroup;

class ARTipsManager$1
  implements View.OnTouchListener
{
  private float jdField_a_of_type_Float;
  private long jdField_a_of_type_Long;
  private float b;
  
  ARTipsManager$1(ARTipsManager paramARTipsManager) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager) != null)
    {
      paramView = (ARTipsManager.TipsInfo)ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).getTag(2131362922);
      ARTipsManager.ViewHolder localViewHolder = (ARTipsManager.ViewHolder)ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).getTag();
      if ((paramView != null) && (localViewHolder != null))
      {
        float f2 = paramMotionEvent.getX();
        float f1 = paramMotionEvent.getY();
        int i = paramMotionEvent.getAction();
        if (i != 0)
        {
          if (i != 1)
          {
            if (i != 2)
            {
              if (i != 3) {
                return true;
              }
              this.jdField_a_of_type_Float = 0.0F;
              this.b = 0.0F;
              this.jdField_a_of_type_Long = 0L;
              localViewHolder.a.setPressed(false);
              return true;
            }
            if ((paramView.jdField_a_of_type_Int == 1) && (paramView.b == 2))
            {
              f2 -= this.jdField_a_of_type_Float;
              f1 -= this.b;
              if ((float)Math.sqrt(f2 * f2 + f1 * f1) >= ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).getScaledTouchSlop())
              {
                localViewHolder.a.setPressed(false);
                return true;
              }
            }
          }
          else
          {
            f2 -= this.jdField_a_of_type_Float;
            f1 -= this.b;
            f2 = (float)Math.sqrt(f2 * f2 + f1 * f1);
            long l1 = System.currentTimeMillis();
            long l2 = this.jdField_a_of_type_Long;
            if (f2 < ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).getScaledTouchSlop())
            {
              if (paramView.b == 2)
              {
                ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeMessages(101);
                ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).obtainMessage(101).sendToTarget();
                if (paramView.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener != null) {
                  paramView.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager$ButtonClickListener.a();
                }
              }
            }
            else if ((f2 > ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).getScaledTouchSlop()) && (f1 > 50.0F) && ((float)(l1 - l2) < 300.0F) && (paramView.jdField_a_of_type_Int == 1))
            {
              ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).removeMessages(101);
              ARTipsManager.a(this.jdField_a_of_type_ComTencentMobileqqOlympicActivityARTipsManager).obtainMessage(101).sendToTarget();
            }
            this.jdField_a_of_type_Float = 0.0F;
            this.b = 0.0F;
            this.jdField_a_of_type_Long = 0L;
            localViewHolder.a.setPressed(false);
            return true;
          }
        }
        else
        {
          this.jdField_a_of_type_Float = f2;
          this.b = f1;
          this.jdField_a_of_type_Long = System.currentTimeMillis();
          if ((paramView.jdField_a_of_type_Int == 1) && (paramView.b == 2)) {
            localViewHolder.a.setPressed(true);
          }
        }
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.olympic.activity.ARTipsManager.1
 * JD-Core Version:    0.7.0.1
 */