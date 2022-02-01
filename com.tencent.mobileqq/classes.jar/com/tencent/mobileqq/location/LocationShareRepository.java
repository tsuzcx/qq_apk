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
  private AppInterface a;
  private LocationShareViewModel b;
  private final OnUpdateUserLocationListener c = new LocationShareRepository.1(this);
  private final FriendObserver d = new LocationShareRepository.2(this);
  private final TroopMngObserver e = new LocationShareRepository.3(this);
  private final TroopPushObserver f = new LocationShareRepository.4(this);
  private INetInfoHandler g = new LocationShareRepository.5(this);
  
  public void a()
  {
    this.a.addObserver(this.e);
    this.a.addObserver(this.f);
    this.a.addObserver(this.d);
    LocationHandler.a().a(this.c);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.g);
  }
  
  public void a(AppInterface paramAppInterface, LocationShareViewModel paramLocationShareViewModel)
  {
    this.a = paramAppInterface;
    this.b = paramLocationShareViewModel;
  }
  
  protected void bN_()
  {
    c();
    this.g = null;
  }
  
  public void c()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.g);
    }
    catch (Exception localException)
    {
      QLog.e("Q.LocationShare", 1, "onFragmentDestroy: failed. ", localException);
    }
    this.a.removeObserver(this.e);
    this.a.removeObserver(this.f);
    this.a.removeObserver(this.d);
    LocationHandler.a().b(this.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareRepository
 * JD-Core Version:    0.7.0.1
 */