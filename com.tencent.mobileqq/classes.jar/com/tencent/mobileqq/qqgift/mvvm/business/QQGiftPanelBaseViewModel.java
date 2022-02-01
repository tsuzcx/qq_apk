package com.tencent.mobileqq.qqgift.mvvm.business;

import android.view.View;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;

public class QQGiftPanelBaseViewModel
  extends BaseViewModel<QQGiftPanelRepository>
  implements IQQGiftPanelView.OnPanelEventListener
{
  public QQGiftPanelBaseViewModel(QQGiftPanelRepository paramQQGiftPanelRepository)
  {
    super(paramQQGiftPanelRepository);
  }
  
  public void a(GiftServiceData paramGiftServiceData, View paramView) {}
  
  public boolean a()
  {
    return false;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public void b(GiftServiceData paramGiftServiceData, View paramView) {}
  
  public void b(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt) {}
  
  public boolean b()
  {
    return false;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public boolean c()
  {
    return false;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    return false;
  }
  
  public void d(GiftServiceData paramGiftServiceData, int paramInt) {}
  
  public void e(GiftServiceData paramGiftServiceData, int paramInt) {}
  
  public void f(GiftServiceData paramGiftServiceData, int paramInt) {}
  
  public void n() {}
  
  public void o() {}
  
  public void p() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel
 * JD-Core Version:    0.7.0.1
 */