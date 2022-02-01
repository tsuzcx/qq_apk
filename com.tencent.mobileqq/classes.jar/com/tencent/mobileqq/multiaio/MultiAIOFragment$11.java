package com.tencent.mobileqq.multiaio;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.multiaio.utils.VelocityUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiAIOFragment$11
  implements View.OnClickListener
{
  MultiAIOFragment$11(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    TextView localTextView = (TextView)MultiAIOFragment.a(this.a).findViewById(2131380694);
    VelocityUtil.a += 1;
    localTextView.setText(HardCodeUtil.a(2131707005) + VelocityUtil.a);
    MultiAIOFragment.d(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.11
 * JD-Core Version:    0.7.0.1
 */