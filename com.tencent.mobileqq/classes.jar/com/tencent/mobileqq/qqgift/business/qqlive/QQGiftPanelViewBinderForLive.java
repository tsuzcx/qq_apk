package com.tencent.mobileqq.qqgift.business.qqlive;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.tencent.mobileqq.mvvm.BaseViewBinder;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView;

public class QQGiftPanelViewBinderForLive
  extends BaseViewBinder
{
  private QQGiftPanelPageAdapter a = null;
  
  public void a(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, QQGiftPanelViewForLive paramQQGiftPanelViewForLive)
  {
    paramQQGiftPanelViewModelForLive.f().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModelForLive.f().observe(paramLifecycleOwner, new QQGiftPanelViewBinderForLive.5(this, paramQQGiftPanelViewForLive));
  }
  
  public void a(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, IQQGiftPanelView paramIQQGiftPanelView)
  {
    this.a = new QQGiftPanelViewBinderForLive.1(this, paramIQQGiftPanelView.getViewContext(), paramQQGiftPanelViewModelForLive);
    paramIQQGiftPanelView.setAdapter(this.a);
    paramQQGiftPanelViewModelForLive.d().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModelForLive.d().observe(paramLifecycleOwner, new QQGiftPanelViewBinderForLive.2(this, paramIQQGiftPanelView));
    paramQQGiftPanelViewModelForLive.h().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModelForLive.h().observe(paramLifecycleOwner, new QQGiftPanelViewBinderForLive.3(this));
  }
  
  public void b(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, QQGiftPanelViewForLive paramQQGiftPanelViewForLive)
  {
    paramQQGiftPanelViewModelForLive.g().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModelForLive.g().observe(paramLifecycleOwner, new QQGiftPanelViewBinderForLive.6(this, paramQQGiftPanelViewForLive));
  }
  
  public void b(LifecycleOwner paramLifecycleOwner, QQGiftPanelViewModelForLive paramQQGiftPanelViewModelForLive, IQQGiftPanelView paramIQQGiftPanelView)
  {
    paramQQGiftPanelViewModelForLive.e().removeObservers(paramLifecycleOwner);
    paramQQGiftPanelViewModelForLive.e().observe(paramLifecycleOwner, new QQGiftPanelViewBinderForLive.4(this, paramIQQGiftPanelView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive
 * JD-Core Version:    0.7.0.1
 */