package com.tencent.mobileqq.mini.widget;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.gdtad.aditem.GdtAd;

class MiniLoadingAdLayout$1
  implements View.OnClickListener
{
  MiniLoadingAdLayout$1(MiniLoadingAdLayout paramMiniLoadingAdLayout, MiniLoadingAdLayout.OnDismissListener paramOnDismissListener) {}
  
  public void onClick(View paramView)
  {
    paramView = this.this$0;
    MiniLoadingAdLayout.report(MiniLoadingAdLayout.access$200(paramView, MiniLoadingAdLayout.access$000(paramView), MiniLoadingAdLayout.access$100(this.this$0).getUrlForClick(), 9));
    this.this$0.dismiss(true, this.val$onDismissListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.MiniLoadingAdLayout.1
 * JD-Core Version:    0.7.0.1
 */