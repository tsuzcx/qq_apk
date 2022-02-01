package com.tencent.mobileqq.qqgift.business.qqlive;

import android.content.Context;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelGridAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelPageAdapter;
import com.tencent.mobileqq.utils.ViewUtils;

class QQGiftPanelViewBinderForLive$1
  extends QQGiftPanelPageAdapter
{
  QQGiftPanelViewBinderForLive$1(QQGiftPanelViewBinderForLive paramQQGiftPanelViewBinderForLive, Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    super(paramContext, paramQQGiftPanelBaseViewModel);
  }
  
  protected int a()
  {
    return ViewUtils.dip2px(6.0F);
  }
  
  public QQGiftPanelGridAdapter a(Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    return new QQGiftPanelGridAdapterForLive(paramContext, paramQQGiftPanelBaseViewModel);
  }
  
  protected int b()
  {
    return ViewUtils.dip2px(2.0F);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelViewBinderForLive.1
 * JD-Core Version:    0.7.0.1
 */