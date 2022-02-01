package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiCardFragment$11
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiCardFragment.a(this.a).findViewById(2131380694);
    VelocityUtil.a += 1;
    localTextView.setText(HardCodeUtil.a(2131707008) + VelocityUtil.a);
    MultiCardFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.11
 * JD-Core Version:    0.7.0.1
 */