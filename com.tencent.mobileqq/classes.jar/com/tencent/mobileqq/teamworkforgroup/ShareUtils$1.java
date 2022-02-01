package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.ActionSheet;

class ShareUtils$1
  implements View.OnClickListener
{
  ShareUtils$1(ShareUtils paramShareUtils) {}
  
  public void onClick(View paramView)
  {
    if (ShareUtils.a(this.a).isShowing()) {
      ShareUtils.a(this.a).dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.ShareUtils.1
 * JD-Core Version:    0.7.0.1
 */