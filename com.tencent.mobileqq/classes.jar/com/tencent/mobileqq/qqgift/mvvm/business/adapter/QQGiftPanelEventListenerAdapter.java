package com.tencent.mobileqq.qqgift.mvvm.business.adapter;

import com.tencent.mobileqq.qqgift.data.service.GiftServiceData;
import com.tencent.mobileqq.qqgift.mvvm.business.QQGiftPanelBaseViewModel;
import com.tencent.mobileqq.qqgift.mvvm.business.view.IQQGiftPanelView.OnPanelEventListener;

public class QQGiftPanelEventListenerAdapter
  implements IQQGiftPanelView.OnPanelEventListener
{
  public final QQGiftPanelBaseViewModel a;
  public final IQQGiftPanelView.OnPanelEventListener b;
  
  public QQGiftPanelEventListenerAdapter(QQGiftPanelBaseViewModel paramQQGiftPanelBaseViewModel, IQQGiftPanelView.OnPanelEventListener paramOnPanelEventListener)
  {
    this.a = paramQQGiftPanelBaseViewModel;
    this.b = paramOnPanelEventListener;
  }
  
  public boolean a()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.a();
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.n();
    }
    return bool;
  }
  
  public boolean a(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.a(paramGiftServiceData, paramInt);
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.f(paramGiftServiceData, paramInt);
    }
    return bool;
  }
  
  protected boolean a(boolean paramBoolean)
  {
    return (!paramBoolean) && (this.a != null);
  }
  
  public boolean a(boolean paramBoolean, GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.a(paramBoolean, paramGiftServiceData, paramInt);
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.b(paramBoolean, paramGiftServiceData, paramInt);
    }
    return bool;
  }
  
  public boolean b()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.b();
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.o();
    }
    return bool;
  }
  
  public boolean b(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.b(paramGiftServiceData, paramInt);
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.e(paramGiftServiceData, paramInt);
    }
    return bool;
  }
  
  public boolean c()
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.c();
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.p();
    }
    return bool;
  }
  
  public boolean c(GiftServiceData paramGiftServiceData, int paramInt)
  {
    IQQGiftPanelView.OnPanelEventListener localOnPanelEventListener = this.b;
    boolean bool;
    if (localOnPanelEventListener != null) {
      bool = localOnPanelEventListener.c(paramGiftServiceData, paramInt);
    } else {
      bool = false;
    }
    if (a(bool)) {
      this.a.d(paramGiftServiceData, paramInt);
    }
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.mvvm.business.adapter.QQGiftPanelEventListenerAdapter
 * JD-Core Version:    0.7.0.1
 */