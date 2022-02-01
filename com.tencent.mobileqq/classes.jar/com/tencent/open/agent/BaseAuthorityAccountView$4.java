package com.tencent.open.agent;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class BaseAuthorityAccountView$4
  implements View.OnClickListener
{
  BaseAuthorityAccountView$4(BaseAuthorityAccountView paramBaseAuthorityAccountView, String paramString) {}
  
  public void onClick(View paramView)
  {
    if ((!this.b.a(this.a, true)) && ((this.b.c instanceof QuickLoginAuthorityActivity))) {
      ((QuickLoginAuthorityActivity)this.b.c).a(this.a, true);
    }
    this.b.f();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.BaseAuthorityAccountView.4
 * JD-Core Version:    0.7.0.1
 */