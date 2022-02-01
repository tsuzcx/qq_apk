package com.tencent.mobileqq.location;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.troop.api.observer.TroopMngObserver;
import com.tencent.mobileqq.troop.api.observer.TroopPushObserver;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class LocationShareRepository
  extends BaseRepository
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private final FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new LocationShareRepository.2(this);
  private LocationShareViewModel jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel;
  private final OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationShareRepository.1(this);
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new LocationShareRepository.5(this);
  private final TroopMngObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver = new LocationShareRepository.3(this);
  private final TroopPushObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver = new LocationShareRepository.4(this);
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  public void a(AppInterface paramAppInterface, LocationShareViewModel paramLocationShareViewModel)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel = paramLocationShareViewModel;
  }
  
  public void b()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
    }
    catch (Exception localException)
    {
      QLog.e("Q.LocationShare", 1, "onFragmentDestroy: failed. ", localException);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopPushObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
    LocationHandler.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
  }
  
  protected void c()
  {
    b();
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository
 * JD-Core Version:    0.7.0.1
 */