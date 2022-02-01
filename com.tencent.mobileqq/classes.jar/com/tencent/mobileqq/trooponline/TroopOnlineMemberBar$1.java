package com.tencent.mobileqq.trooponline;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;

class TroopOnlineMemberBar$1
  implements Runnable
{
  TroopOnlineMemberBar$1(TroopOnlineMemberBar paramTroopOnlineMemberBar) {}
  
  public void run()
  {
    if (TroopOnlineMemberBar.a(this.this$0) != 0)
    {
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      if ((TroopOnlineMemberBar.a(this.this$0) != 2) && (NetworkUtil.isNetworkAvailable(this.this$0.jdField_a_of_type_AndroidContentContext)))
      {
        if (TroopOnlineMemberBar.a(this.this$0) != 1) {
          return;
        }
        try
        {
          if (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable == null) {
            this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable = ((Animatable)this.this$0.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130839401));
          }
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(null);
          this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds((Drawable)this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable, null, null, null);
          this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.start();
          return;
        }
        catch (Exception localException)
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("show exception, msg = ");
          localStringBuilder.append(localException.getMessage());
          QLog.e("TroopOnlineMemberBar", 4, localStringBuilder.toString());
          return;
        }
      }
      if (this.this$0.b == 1) {
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131694607);
      } else if (this.this$0.b == 3) {
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131692800);
      } else {
        this.this$0.jdField_a_of_type_AndroidWidgetTextView.setText(2131719214);
      }
      this.this$0.jdField_a_of_type_AndroidWidgetTextView.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      if ((this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable != null) && (this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.isRunning())) {
        this.this$0.jdField_a_of_type_AndroidGraphicsDrawableAnimatable.stop();
      }
      TroopOnlineMemberBar.a(this.this$0, 2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.trooponline.TroopOnlineMemberBar.1
 * JD-Core Version:    0.7.0.1
 */