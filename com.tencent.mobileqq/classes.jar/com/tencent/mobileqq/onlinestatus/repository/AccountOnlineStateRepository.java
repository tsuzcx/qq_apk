package com.tencent.mobileqq.onlinestatus.repository;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountOnlineStateViewModel;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.ICardHandler;
import mqq.observer.AccountObserver;

public class AccountOnlineStateRepository
  extends BaseRepository
{
  private AppInterface a;
  private AccountOnlineStateViewModel b;
  private BusinessObserver c = ((ICardHandler)QRoute.api(ICardHandler.class)).newCardHandlerForAutoReply(new AccountOnlineStateRepository.1(this));
  private AccountObserver d = new AccountOnlineStateRepository.2(this);
  private OnlineStatusPermissionObserver e = new AccountOnlineStateRepository.3(this);
  private OnlineStatusObserver f = new AccountOnlineStateRepository.4(this);
  private OnBatteryChangeObserver g = new AccountOnlineStateRepository.5(this);
  
  public AccountOnlineStateRepository(AppInterface paramAppInterface)
  {
    this.a = paramAppInterface;
  }
  
  public void a()
  {
    this.a.addObserver(this.c);
    this.a.registObserver(this.g);
    this.a.registObserver(this.d);
    this.a.addObserver(this.f);
    this.a.registObserver(this.e);
  }
  
  public void a(AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    this.b = paramAccountOnlineStateViewModel;
  }
  
  protected void bN_()
  {
    super.bN_();
    c();
  }
  
  public void c()
  {
    this.a.removeObserver(this.c);
    this.a.unRegistObserver(this.g);
    this.a.unRegistObserver(this.d);
    this.a.removeObserver(this.f);
    this.a.unRegistObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository
 * JD-Core Version:    0.7.0.1
 */