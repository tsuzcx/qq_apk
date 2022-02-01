package com.tencent.mobileqq.multiaio;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiAIOFragment$2
  implements View.OnClickListener
{
  MultiAIOFragment$2(MultiAIOFragment paramMultiAIOFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAioFragment", 2, "onClick() called with: v = [" + paramView + "]");
    }
    MultiAIOFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.MultiAIOFragment.2
 * JD-Core Version:    0.7.0.1
 */