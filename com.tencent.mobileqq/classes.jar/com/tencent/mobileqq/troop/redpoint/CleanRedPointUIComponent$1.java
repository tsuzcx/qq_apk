package com.tencent.mobileqq.troop.redpoint;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CleanRedPointUIComponent$1
  implements View.OnClickListener
{
  CleanRedPointUIComponent$1(CleanRedPointUIComponent paramCleanRedPointUIComponent) {}
  
  public void onClick(View paramView)
  {
    if (CleanRedPointUIComponent.a(this.a) != null) {
      CleanRedPointUIComponent.a(this.a).a();
    }
    if (QLog.isColorLevel()) {
      QLog.d("CleanRedPointUIComponent", 0, "initClickLogic: onClick  mUin = " + CleanRedPointUIComponent.a(this.a) + ", mUinType = " + CleanRedPointUIComponent.b(this.a));
    }
    RedPointUtils.a(CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.b(this.a), CleanRedPointUIComponent.a(this.a));
    RedPointUtils.a(CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.a(this.a), CleanRedPointUIComponent.b(this.a), CleanRedPointUIComponent.a(this.a));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.redpoint.CleanRedPointUIComponent.1
 * JD-Core Version:    0.7.0.1
 */