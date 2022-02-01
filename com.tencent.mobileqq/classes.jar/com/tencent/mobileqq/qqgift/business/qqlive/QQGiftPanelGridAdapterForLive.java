package com.tencent.mobileqq.qqgift.business.qqlive;

import android.content.Context;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelGridAdapter;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelItemView;

public class QQGiftPanelGridAdapterForLive
  extends QQGiftPanelGridAdapter
{
  public QQGiftPanelGridAdapterForLive(Context paramContext, QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel)
  {
    super(paramContext, paramQQGiftPanelBaseViewModel);
  }
  
  protected IQQGiftPanelItemView a(Context paramContext)
  {
    paramContext = new QQGiftPanelItemViewForLive(paramContext);
    paramContext.setViewModel((QQGiftPanelViewModelForLive)this.c);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.business.qqlive.QQGiftPanelGridAdapterForLive
 * JD-Core Version:    0.7.0.1
 */