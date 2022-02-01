package com.tencent.mobileqq.ecshop.view;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class EcshopAdViewHelper$1
  implements View.OnClickListener
{
  EcshopAdViewHelper$1(EcshopAdViewHelper paramEcshopAdViewHelper, Context paramContext, MessageRecord paramMessageRecord, TextView paramTextView, String paramString) {}
  
  public void onClick(View paramView)
  {
    this.e.a(this.a, this.b, this.c, this.d, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ecshop.view.EcshopAdViewHelper.1
 * JD-Core Version:    0.7.0.1
 */