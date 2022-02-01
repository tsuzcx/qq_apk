package com.tencent.mobileqq.conditionsearch.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class IphonePickerView$1
  implements View.OnClickListener
{
  IphonePickerView$1(IphonePickerView paramIphonePickerView) {}
  
  public void onClick(View paramView)
  {
    if (IphonePickerView.a(this.a) != null) {
      IphonePickerView.a(this.a).onConfirmBtClicked();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.1
 * JD-Core Version:    0.7.0.1
 */