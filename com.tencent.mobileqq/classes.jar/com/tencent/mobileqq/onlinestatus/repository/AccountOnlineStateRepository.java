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
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = ((ICardHandler)QRoute.api(ICardHandler.class)).newCardHandlerForAutoReply(new AccountOnlineStateRepository.1(this));
  private OnBatteryChangeObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver = new AccountOnlineStateRepository.5(this);
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AccountOnlineStateRepository.4(this);
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AccountOnlineStateRepository.3(this);
  private AccountOnlineStateViewModel jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel;
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AccountOnlineStateRepository.2(this);
  
  public AccountOnlineStateRepository(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
  }
  
  public void a(AccountOnlineStateViewModel paramAccountOnlineStateViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountOnlineStateViewModel = paramAccountOnlineStateViewModel;
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
  }
  
  protected void c()
  {
    super.c();
    b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountOnlineStateRepository
 * JD-Core Version:    0.7.0.1
 */