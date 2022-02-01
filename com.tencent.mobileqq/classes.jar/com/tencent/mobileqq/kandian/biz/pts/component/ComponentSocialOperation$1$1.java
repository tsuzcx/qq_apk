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
    if (this.a.a.i)
    {
      this.a.a.e.setImageResource(2130848162);
      if (this.a.a.j > 0)
      {
        this.a.a.c.setText(ComponentSocialOperation.a(this.a.a.j));
        this.a.a.c.setTextColor(Color.parseColor("#07D0B0"));
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("revert upvote to true, set num:");
          localStringBuilder.append(ComponentSocialOperation.a(this.a.a.j));
          QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
        }
      }
    }
    else
    {
      this.a.a.e.setImageResource(2130848165);
      this.a.a.c.setTextColor(Color.parseColor("#777777"));
      if (this.a.a.j > 0) {
        this.a.a.c.setText(ComponentSocialOperation.a(this.a.a.j));
      } else {
        this.a.a.c.setText(2131915569);
      }
      if (QLog.isColorLevel())
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("revert upvote to false, set num:");
        localStringBuilder.append(ComponentSocialOperation.a(this.a.a.j));
        QLog.d("ComponentSocialOperation", 2, localStringBuilder.toString());
      }
    }
    this.a.a.e.startAnimation(this.a.a.n);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.component.ComponentSocialOperation.1.1
 * JD-Core Version:    0.7.0.1
 */