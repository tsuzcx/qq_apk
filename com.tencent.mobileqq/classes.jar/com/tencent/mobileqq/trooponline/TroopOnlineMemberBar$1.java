package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import bass;
import bbev;

public class TroopOnlineMemberBar$1
  implements Runnable
{
  public TroopOnlineMemberBar$1(bass parambass) {}
  
  public void run()
  {
    if (bass.a(this.this$0) != 0)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((bass.a(this.this$0) != 2) && (bbev.g(this.this$0.jdField_a_of_type_AndroidContentContext))) {
        break label170;
      }
      if (this.this$0.b != 1) {
        break label129;
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131694856);
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      bass.a(this.this$0, 2);
    }
    label129:
    label170:
    while (bass.a(this.this$0) != 1) {
      for (;;)
      {
        return;
        if (this.this$0.b == 3) {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131692928);
        } else {
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131719736);
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