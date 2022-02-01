package com.tencent.mobileqq.search.rich;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.ark.ArkViewImplement;
import com.tencent.ark.ArkViewModel;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class ArkNodeView$1
  implements View.OnClickListener
{
  ArkNodeView$1(ArkNodeView paramArkNodeView) {}
  
  public void onClick(View paramView)
  {
    ArkViewModel localArkViewModel = null;
    if (ArkNodeView.a(this.a) != null) {
      localArkViewModel = ArkNodeView.a(this.a).mViewImpl.getViewModel();
    }
    if (localArkViewModel == null) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localArkViewModel.reinitArkContainer();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.rich.ArkNodeView.1
 * JD-Core Version:    0.7.0.1
 */