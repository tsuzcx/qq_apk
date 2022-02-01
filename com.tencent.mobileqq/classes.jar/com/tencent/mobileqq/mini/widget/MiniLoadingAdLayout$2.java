package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MiniLoadingAdLayout$2
  implements View.OnClickListener
{
  MiniLoadingAdLayout$2(MiniLoadingAdLayout paramMiniLoadingAdLayout, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener) {}
  
  public void onClick(View paramView)
  {
    MiniLoadingAdLayout.report(MiniLoadingAdLayout.access$400(this.this$0, MiniLoadingAdLayout.access$200(this.this$0), MiniLoadingAdLayout.access$000(this.this$0).getUrlForClick(), 9));
    this.this$0.dismiss(true, this.val$onDismissListener);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.2
 * JD-Core Version:    0.7.0.1
 */