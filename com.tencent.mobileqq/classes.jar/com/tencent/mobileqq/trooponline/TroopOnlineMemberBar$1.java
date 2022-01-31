package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import batg;
import bbfj;

public class TroopOnlineMemberBar$1
  implements Runnable
{
  public TroopOnlineMemberBar$1(batg parambatg) {}
  
  public void run()
  {
    if (batg.a(this.this$0) != 0)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((batg.a(this.this$0) != 2) && (bbfj.g(this.this$0.jdField_a_of_type_AndroidContentContext))) {
        break label170;
      }
      if (this.this$0.b != 1) {
        break label129;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131694857);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      batg.a(this.this$0, 2);
    }
    label129:
    label170:
    while (batg.a(this.this$0) != 1) {
      for (;;)
      {
        return;
        if (this.this$0.b == 3) {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131692929);
        } else {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131719747);
        }
      }
    }
    if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable == null) {
      this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839140));
    }
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(null);
    this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
    this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
 * JD-Core Version:    0.7.0.1
 */