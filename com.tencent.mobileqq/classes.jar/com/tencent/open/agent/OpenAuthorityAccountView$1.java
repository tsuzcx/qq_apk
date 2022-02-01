package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class OpenAuthorityAccountView$1
  implements View.OnClickListener
{
  OpenAuthorityAccountView$1(OpenAuthorityAccountView paramOpenAuthorityAccountView) {}
  
  public void onClick(View paramView)
  {
    if (OpenAuthorityAccountView.a(this.a) != null) {
      OpenAuthorityAccountView.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityAccountView.1
 * JD-Core Version:    0.7.0.1
 */