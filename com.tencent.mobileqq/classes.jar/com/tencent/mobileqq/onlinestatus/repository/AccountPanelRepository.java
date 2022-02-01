package com.tencent.mobileqq.onlinestatus.repository;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.mvvm.BaseRepository;
import com.tencent.mobileqq.onlinestatus.OnBatteryChangeObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusObserver;
import com.tencent.mobileqq.onlinestatus.OnlineStatusPermissionObserver;
import com.tencent.mobileqq.onlinestatus.viewmodel.AccountPanelViewModel;
import com.tencent.mobileqq.onlinestatus.weather.WeatherObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.relation.api.IFriendsUtils;
import com.tencent.mobileqq.subaccount.api.ISubAccountApi;
import com.tencent.qphone.base.util.QLog;
import java.util.Observer;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;
import mqq.observer.AccountObserver;

public class AccountPanelRepository
  extends BaseRepository
{
  private BusinessObserver jdField_a_of_type_ComTencentMobileqqAppBusinessObserver = ((IFriendsUtils)QRoute.api(IFriendsUtils.class)).createFriendObserver(new AccountPanelRepository.8(this));
  private AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new AccountPanelRepository.7(this);
  private OnBatteryChangeObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver = new AccountPanelRepository.5(this);
  private OnlineStatusObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver = new AccountPanelRepository.1(this);
  private OnlineStatusPermissionObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver = new AccountPanelRepository.2(this);
  private AccountPanelViewModel jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel;
  private WeatherObserver jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver = new AccountPanelRepository.3(this);
  private Observer jdField_a_of_type_JavaUtilObserver = new AccountPanelRepository.6(this);
  private AccountObserver jdField_a_of_type_MqqObserverAccountObserver = new AccountPanelRepository.4(this);
  private BusinessObserver b = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).createSubAccountBindObserver(new AccountPanelRepository.9(this));
  private BusinessObserver c = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).createMessageObserver(new AccountPanelRepository.10(this));
  
  public AccountPanelRepository(AppInterface paramAppInterface) {}
  
  private boolean a(String paramString, boolean paramBoolean)
  {
    return (MobileQQ.sMobileQQ.peekAppRuntime() == null) || (paramBoolean) || (TextUtils.isEmpty(paramString));
  }
  
  private boolean a(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.peekAppRuntime();
    if ((localAppRuntime != null) && (!paramBoolean2) && (!TextUtils.isEmpty(paramString)))
    {
      if (!TextUtils.equals(paramString, localAppRuntime.getCurrentAccountUin()))
      {
        QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, mainAccount: %s not equal", new Object[] { paramString }));
        return true;
      }
      return false;
    }
    QLog.d("AccountPanelRepository", 1, String.format("onGetSubAccountMsg return, isSuccess: %s, mainAccount: %s", new Object[] { Boolean.valueOf(paramBoolean1), paramString }));
    return true;
  }
  
  public void a()
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppInterface != null)
    {
      localAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      localAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      localAppInterface.addObserver(this.b);
      localAppInterface.addObserver(this.c);
      localAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
      localAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      localAppInterface.registObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
      localAppInterface.registObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
      ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).addObserver(this.jdField_a_of_type_JavaUtilObserver);
      localAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, "addObservers");
      }
    }
  }
  
  public void a(AccountPanelViewModel paramAccountPanelViewModel)
  {
    this.jdField_a_of_type_ComTencentMobileqqOnlinestatusViewmodelAccountPanelViewModel = paramAccountPanelViewModel;
  }
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppInterface != null)
    {
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppBusinessObserver);
      localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
      localAppInterface.removeObserver(this.b);
      localAppInterface.removeObserver(this.c);
      localAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnBatteryChangeObserver);
      localAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusPermissionObserver);
      localAppInterface.unRegistObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusWeatherWeatherObserver);
      if (paramBoolean)
      {
        localAppInterface.unRegistObserver(this.jdField_a_of_type_MqqObserverAccountObserver);
        localAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqOnlinestatusOnlineStatusObserver);
      }
      ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this.jdField_a_of_type_JavaUtilObserver);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, "removeObservers");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository
 * JD-Core Version:    0.7.0.1
 */