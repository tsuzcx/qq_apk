package com.tencent.mobileqq.mini.appbrand.page;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class AbsAppBrandPage$1
  implements View.OnClickListener
{
  AbsAppBrandPage$1(AbsAppBrandPage paramAbsAppBrandPage) {}
  
  public void onClick(View paramView)
  {
    MiniAppStateManager.getInstance().notifyChange("confirm");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.appbrand.page.AbsAppBrandPage.1
 * JD-Core Version:    0.7.0.1
 */