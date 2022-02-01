package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import bgsy;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

public class TroopOnlineMemberBar$1
  implements Runnable
{
  public TroopOnlineMemberBar$1(bgsy parambgsy) {}
  
  public void run()
  {
    if (bgsy.a(this.this$0) != 0)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((bgsy.a(this.this$0) != 2) && (NetworkUtil.isNetworkAvailable(this.this$0.jdField_a_of_type_AndroidContentContext))) {
        break label170;
      }
      if (this.this$0.b != 1) {
        break label129;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131694422);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      bgsy.a(this.this$0, 2);
    }
    label129:
    label170:
    while (bgsy.a(this.this$0) != 1) {
      for (;;)
      {
        return;
        if (this.this$0.b == 3) {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131692702);
        } else {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131718962);
        }
      }
    }
    try
    {
      if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable == null) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839466));
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(null);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TroopOnlineMemberBar", 4, "show exception, msg = " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
 * JD-Core Version:    0.7.0.1
 */