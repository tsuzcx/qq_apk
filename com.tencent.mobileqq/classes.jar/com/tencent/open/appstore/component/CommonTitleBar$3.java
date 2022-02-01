package com.tencent.open.appstore.component;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class CommonTitleBar$3
  implements View.OnClickListener
{
  CommonTitleBar$3(CommonTitleBar paramCommonTitleBar) {}
  
  public void onClick(View paramView)
  {
    if (CommonTitleBar.a(this.a) != null) {
      CommonTitleBar.a(this.a).b();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.open.appstore.component.CommonTitleBar.3
 * JD-Core Version:    0.7.0.1
 */