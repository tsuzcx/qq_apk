package com.tencent.mobileqq.qqlive.prepare.covercrop;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QQLivePhotoCropFragment$2
  implements View.OnClickListener
{
  QQLivePhotoCropFragment$2(QQLivePhotoCropFragment paramQQLivePhotoCropFragment) {}
  
  public void onClick(View paramView)
  {
    QQLivePhotoCropFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.prepare.covercrop.QQLivePhotoCropFragment.2
 * JD-Core Version:    0.7.0.1
 */