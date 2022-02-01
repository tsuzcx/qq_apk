package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQLivePhotoCropFragment$3
  implements View.OnClickListener
{
  QQLivePhotoCropFragment$3(QQLivePhotoCropFragment paramQQLivePhotoCropFragment) {}
  
  public void onClick(View paramView)
  {
    QQLivePhotoCropFragment.a(this.a, 1);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.QQLivePhotoCropFragment.3
 * JD-Core Version:    0.7.0.1
 */