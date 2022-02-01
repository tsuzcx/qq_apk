package com.tencent.mobileqq.qqgift.business.qqlive;

import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelEventListenerAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnQQLivePanelEventListener;

public class QQGiftPanelStrategyForLive
  extends QQGiftPanelEventListenerAdapter
  implements IQQGiftPanelView.OnQQLivePanelEventListener
{
  public QQGiftPanelStrategyForLive(QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel, IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    super(paramQQGiftPanelBaseViewModel, paramOnPanelEventListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelStrategyForLive
 * JD-Core Version:    0.7.0.1
 */