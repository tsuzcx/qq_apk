package com.tencent.mobileqq.richstatus.topic;

import android.text.Layout;
import android.text.Spannable;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.view.MotionEvent;
import android.widget.TextView;
import com.tencent.mobileqq.text.ITopic;
import com.tencent.qphone.base.util.QLog;

public class StateColorMovementMethod
  extends LinkMovementMethod
{
  private static StateColorMovementMethod jdField_a_of_type_ComTencentMobileqqRichstatusTopicStateColorMovementMethod;
  ITopic jdField_a_of_type_ComTencentMobileqqTextITopic;
  boolean jdField_a_of_type_Boolean;
  
  public static MovementMethod a()
  {
    if (jdField_a_of_type_ComTencentMobileqqRichstatusTopicStateColorMovementMethod == null) {
      jdField_a_of_type_ComTencentMobileqqRichstatusTopicStateColorMovementMethod = new StateColorMovementMethod();
    }
    return jdField_a_of_type_ComTencentMobileqqRichstatusTopicStateColorMovementMethod;
  }
  
  public boolean onTouchEvent(TextView paramTextView, Spannable paramSpannable, MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if ((i == 1) || (i == 0) || (i == 3))
    {
      int j = (int)paramMotionEvent.getX();
      int k = (int)paramMotionEvent.getY();
      int m = paramTextView.getTotalPaddingLeft();
      int n = paramTextView.getTotalPaddingTop();
      int i1 = paramTextView.getScrollX();
      int i2 = paramTextView.getScrollY();
      Object localObject = paramTextView.getLayout();
      j = ((Layout)localObject).getOffsetForHorizontal(((Layout)localObject).getLineForVertical(k - n + i2), j - m + i1);
      localObject = (ITopic[])paramSpannable.getSpans(j, j, ITopic.class);
      if (QLog.isColorLevel()) {
        QLog.i("StateColorMovementMethod", 2, String.format("onTouch action[%d] links=[%d]", new Object[] { Integer.valueOf(i), Integer.valueOf(localObject.length) }));
      }
      if (localObject.length != 0)
      {
        this.jdField_a_of_type_Boolean = false;
        paramSpannable = localObject[0];
        if (i == 1)
        {
          paramMotionEvent = this.jdField_a_of_type_ComTencentMobileqqTextITopic;
          if (paramMotionEvent != null)
          {
            paramMotionEvent.setPressed(paramTextView, false);
            this.jdField_a_of_type_ComTencentMobileqqTextITopic = null;
          }
          paramSpannable.onClick(paramTextView);
          return true;
        }
        if (i == 0)
        {
          paramSpannable.setPressed(paramTextView, true);
          this.jdField_a_of_type_ComTencentMobileqqTextITopic = paramSpannable;
          return true;
        }
        if (i == 3)
        {
          paramSpannable = this.jdField_a_of_type_ComTencentMobileqqTextITopic;
          if (paramSpannable != null)
          {
            paramSpannable.setPressed(paramTextView, false);
            this.jdField_a_of_type_ComTencentMobileqqTextITopic = null;
          }
        }
        return true;
      }
      if (i == 1)
      {
        if (this.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_Boolean = false;
          paramTextView.performClick();
        }
      }
      else if (i == 0) {
        this.jdField_a_of_type_Boolean = true;
      } else if (i == 3) {
        this.jdField_a_of_type_Boolean = false;
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqTextITopic;
      if (localObject != null)
      {
        ((ITopic)localObject).setPressed(paramTextView, false);
        this.jdField_a_of_type_ComTencentMobileqqTextITopic = null;
      }
    }
    return super.onTouchEvent(paramTextView, paramSpannable, paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.StateColorMovementMethod
 * JD-Core Version:    0.7.0.1
 */