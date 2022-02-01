package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import bhav;
import bhnv;
import com.tencent.qphone.base.util.QLog;

public class TroopOnlineMemberBar$1
  implements Runnable
{
  public TroopOnlineMemberBar$1(bhav parambhav) {}
  
  public void run()
  {
    if (bhav.a(this.this$0) != 0)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((bhav.a(this.this$0) != 2) && (bhnv.g(this.this$0.jdField_a_of_type_AndroidContentContext))) {
        break label170;
      }
      if (this.this$0.b != 1) {
        break label129;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131694121);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      bhav.a(this.this$0, 2);
    }
    label129:
    label170:
    while (bhav.a(this.this$0) != 1) {
      for (;;)
      {
        return;
        if (this.this$0.b == 3) {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131692552);
        } else {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131718331);
        }
      }
    }
    try
    {
      if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable == null) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839410));
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