package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiCardFragment$10
  implements View.OnClickListener
{
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiCardFragment.h(this.a).findViewById(2131448861);
    VelocityUtil.a -= 1;
    if (VelocityUtil.a < 1) {
      VelocityUtil.a = 1;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(HardCodeUtil.a(2131904870));
    localStringBuilder.append(VelocityUtil.a);
    localTextView.setText(localStringBuilder.toString());
    MultiCardFragment.i(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.10
 * JD-Core Version:    0.7.0.1
 */