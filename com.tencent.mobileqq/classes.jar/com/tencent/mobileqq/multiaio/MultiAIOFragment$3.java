package com.tencent.mobileqq.multiaio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiAIOFragment$3
  implements View.OnClickListener
{
  MultiAIOFragment$3(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("indicator onClick() called with: v = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("]");
      QLog.d("MultiAioFragment", 2, localStringBuilder.toString());
    }
    MultiAIOFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.3
 * JD-Core Version:    0.7.0.1
 */