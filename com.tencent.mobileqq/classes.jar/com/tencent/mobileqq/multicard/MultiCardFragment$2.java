package com.tencent.mobileqq.multicard;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MultiCardFragment$2
  implements View.OnClickListener
{
  MultiCardFragment$2(MultiCardFragment paramMultiCardFragment) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("onClick() called with: v = [");
      localStringBuilder.append(paramView);
      localStringBuilder.append("]");
      QLog.d("MultiCardFragment", 2, localStringBuilder.toString());
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardFragment.2
 * JD-Core Version:    0.7.0.1
 */