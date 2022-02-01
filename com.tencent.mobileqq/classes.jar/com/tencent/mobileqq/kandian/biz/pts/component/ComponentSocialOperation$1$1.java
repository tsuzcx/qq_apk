package com.tencent.mobileqq.kandian.biz.pts.component;

import android.graphics.Color;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qphone.base.util.QLog;

class ComponentSocialOperation$1$1
  implements Runnable
{
  ComponentSocialOperation$1$1(ComponentSocialOperation.1 param1) {}
  
  public void run()
  {
    StringBuilder localStringBuilder;
    if (this.a.a.jdField_a_of_type_Boolean)
    {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846610);
      if (this.a.a.jdField_a_of_type_Int > 0)
      {
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#07D0B0"));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("revert upvote to true, set num:");
          localStringBuilder.append(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
          QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      this.a.a.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130846613);
      this.a.a.jdField_b_of_type_AndroidWidgetTextView.setTextColor(Color.parseColor("#777777"));
      if (this.a.a.jdField_a_of_type_Int > 0) {
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
      } else {
        this.a.a.jdField_b_of_type_AndroidWidgetTextView.setText(2131718091);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("revert upvote to false, set num:");
        localStringBuilder.append(ComponentSocialOperation.a(this.a.a.jdField_a_of_type_Int));
        QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
      }
    }
    this.a.a.jdField_a_of_type_AndroidWidgetImageView.startAnimation(this.a.a.jdField_b_of_type_AndroidViewAnimationScaleAnimation);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentSocialOperation.1.1
 * JD-Core Version:    0.7.0.1
 */