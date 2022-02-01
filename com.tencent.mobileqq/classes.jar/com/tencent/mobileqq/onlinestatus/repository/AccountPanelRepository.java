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
  private AccountPanelViewModel a;
  private OnlineStatusObserver b = new AccountPanelRepository.1(this);
  private OnlineStatusPermissionObserver c = new AccountPanelRepository.2(this);
  private WeatherObserver d = new AccountPanelRepository.3(this);
  private AccountObserver e = new AccountPanelRepository.4(this);
  private OnBatteryChangeObserver f = new AccountPanelRepository.5(this);
  private Observer g = new AccountPanelRepository.6(this);
  private AvatarObserver h = new AccountPanelRepository.7(this);
  private BusinessObserver i = ((IFriendsUtils)QRoute.api(IFriendsUtils.class)).createFriendObserver(new AccountPanelRepository.8(this));
  private BusinessObserver j = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).createSubAccountBindObserver(new AccountPanelRepository.9(this));
  private BusinessObserver k = ((ISubAccountApi)QRoute.api(ISubAccountApi.class)).createMessageObserver(new AccountPanelRepository.10(this));
  
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
      localAppInterface.addObserver(this.i);
      localAppInterface.addObserver(this.h);
      localAppInterface.addObserver(this.j);
      localAppInterface.addObserver(this.k);
      localAppInterface.registObserver(this.f);
      localAppInterface.registObserver(this.c);
      localAppInterface.registObserver(this.d);
      localAppInterface.registObserver(this.e);
      ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).addObserver(this.g);
      localAppInterface.addObserver(this.b);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, "addObservers");
      }
    }
  }
  
  public void a(AccountPanelViewModel paramAccountPanelViewModel)
  {
    this.a = paramAccountPanelViewModel;
  }
  
  public void a(boolean paramBoolean)
  {
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.peekAppRuntime();
    if (localAppInterface != null)
    {
      localAppInterface.removeObserver(this.i);
      localAppInterface.removeObserver(this.h);
      localAppInterface.removeObserver(this.j);
      localAppInterface.removeObserver(this.k);
      localAppInterface.unRegistObserver(this.f);
      localAppInterface.unRegistObserver(this.c);
      localAppInterface.unRegistObserver(this.d);
      if (paramBoolean)
      {
        localAppInterface.unRegistObserver(this.e);
        localAppInterface.removeObserver(this.b);
      }
      ((IMessageFacade)localAppInterface.getRuntimeService(IMessageFacade.class, "")).deleteObserver(this.g);
      if (QLog.isColorLevel()) {
        QLog.d("AccountPanelRepository", 2, "removeObservers");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.repository.AccountPanelRepository
 * JD-Core Version:    0.7.0.1
 */