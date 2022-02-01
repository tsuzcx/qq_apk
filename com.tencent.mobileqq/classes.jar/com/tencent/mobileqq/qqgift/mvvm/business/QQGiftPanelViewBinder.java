package com.tencent.mobileqq.qqgift.mvvm.business;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;

public class QQGiftPanelViewBinder
  extends BaseViewBinder
{
  private QQGiftPanelPageAdapter a = null;
  
  public void a(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModel paramQQGiftPanelViewModel, IQQGiftPanelView paramIQQGiftPanelView)
  {
    this.a = new QQGiftPanelPageAdapter(paramIQQGiftPanelView.getViewContext(), paramQQGiftPanelViewModel);
    paramIQQGiftPanelView.setAdapter(this.a);
    paramQQGiftPanelViewModel.d().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModel.d().observe(paramLifecycleOwner, new QQGiftPanelViewBinder.1(this, paramIQQGiftPanelView));
  }
  
  public void b(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModel paramQQGiftPanelViewModel, IQQGiftPanelView paramIQQGiftPanelView)
  {
    paramQQGiftPanelViewModel.e().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModel.e().observe(paramLifecycleOwner, new QQGiftPanelViewBinder.2(this, paramIQQGiftPanelView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */