package com.tencent.mobileqq.location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.UserLocationsUpdateBean;
import com.tencent.mobileqq.location.model.VenueOptBean;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.LocationShareLocationManager;
import com.tencent.mobileqq.location.net.LocationShareRoomManager;
import com.tencent.mobileqq.location.net.LocationShareVenueManager;
import com.tencent.mobileqq.location.net.RoomOperateHandler;
import com.tencent.mobileqq.location.net.RoomQueryHandler;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.window.FloatMapDialogUtil;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocationShareViewModel
  extends BaseViewModel<LocationShareRepository>
{
  public static ViewModelProvider.Factory d = new LocationShareViewModel.1();
  public MutableLiveData<UserLocationsUpdateBean> a = new MutableLiveData();
  public MutableLiveData<Boolean> b = new MutableLiveData();
  public MutableLiveData<VenueOptBean> c = new MutableLiveData();
  private AppInterface e;
  private QBaseActivity f;
  private LocationRoom.RoomKey g;
  
  public LocationShareViewModel(LocationShareRepository paramLocationShareRepository)
  {
    super(paramLocationShareRepository);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramAppInterface, paramInt, paramString, -1);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "stopOnErrorSituationByReason: invoked. ", " uin: ", paramString, " reason: ", Integer.valueOf(paramInt2) });
    }
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(paramInt1, paramString);
    LocationShareLocationManager.a().a(localRoomKey, false);
    LocationShareRoomManager.a().c.c();
    ThreadManager.excute(new LocationShareViewModel.4(paramAppInterface, paramInt1, paramString), 32, null, false);
    LocationHandler.a().b(localRoomKey, paramInt2);
    ((ILocationShareService)paramAppInterface.getRuntimeService(ILocationShareService.class, "")).notifyStateError(paramInt1, paramString, false);
    ReportController.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
  }
  
  public void a()
  {
    ((LocationShareRepository)this.z).a();
  }
  
  public void a(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    this.e = paramAppInterface;
    this.f = paramQBaseActivity;
    this.g = paramRoomKey;
    ((LocationShareRepository)this.z).a(paramAppInterface, this);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[LocationShareController] onKickOff: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      localStringBuilder.append(" mRoomKey: ");
      localStringBuilder.append(this.g);
      QLog.d("Q.LocationShare", 2, localStringBuilder.toString());
    }
    QQToast.makeText(BaseApplication.getContext(), "已在其他设备进行共享", 0).show();
    this.f.finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(this.g)) {
      return;
    }
    int i;
    if (LocationShareRoomManager.a().c() != null) {
      i = 1;
    } else {
      i = 0;
    }
    LocationShareRoomManager.a().a(null);
    if ((paramInt != 2) && (paramInt != 1) && (i == 0)) {
      LocationDialogUtil.a(this.f);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(this.g)) {
      return;
    }
    if (paramInt1 == 10100)
    {
      if ((paramInt2 == 2) && (LocationHandler.a().b() == 1))
      {
        if (this.g != null)
        {
          LocationShareRoomManager.a().b.a(1, this.g.a(), this.g.b());
          QLog.d("Q.LocationShare", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
          return;
        }
        QLog.e("Q.LocationShare", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
        return;
      }
      paramRoomKey = this.f;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing())) {
        LocationDialogUtil.a(this.f);
      }
    }
    else if (paramInt1 == 10101)
    {
      QBaseActivity localQBaseActivity = this.f;
      if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
      {
        LocationDialogUtil.b(this.f);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, new Object[] { "join limit, onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey });
      }
    }
  }
  
  public void a(LocationRoom.Venue paramVenue)
  {
    VenueOptBean localVenueOptBean = new VenueOptBean();
    localVenueOptBean.e = 1;
    localVenueOptBean.d = 1;
    localVenueOptBean.a = paramVenue;
    this.c.postValue(localVenueOptBean);
    LocationShareVenueManager.a().a(this.g, paramVenue, new LocationShareViewModel.2(this, paramVenue));
  }
  
  public void a(String paramString)
  {
    if ((this.g.a() == 1) && (this.g.b().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      QBaseActivity localQBaseActivity = this.f;
      if (localQBaseActivity != null)
      {
        localQBaseActivity.finish();
        QQToast.makeText(BaseApplication.getContext(), 2131890656, 1).show();
      }
      a(this.e, 1, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.g.b())))
    {
      a(this.e, 0, paramString);
      paramString = this.f;
      if (paramString != null) {
        paramString.finish();
      }
    }
  }
  
  public String b(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    AppRuntime localAppRuntime = d();
    String str = ((IFriendNameService)localAppRuntime.getRuntimeService(IFriendNameService.class, "")).getFriendNick(paramString);
    if (this.g.a() == 0)
    {
      paramString = ((IFriendDataService)localAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
      if (paramString != null) {
        return paramString.getFriendNickWithAlias();
      }
    }
    else if (this.g.a() == 1)
    {
      str = ((ITroopMemberNameService)localAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.g.b(), paramString);
    }
    return str;
  }
  
  public void b()
  {
    if (this.g != null)
    {
      FloatMapDialogUtil.b(this.f);
      a(this.e, this.g.a(), this.g.b(), 2);
    }
  }
  
  public void b(LocationRoom.Venue paramVenue)
  {
    VenueOptBean localVenueOptBean = new VenueOptBean();
    localVenueOptBean.d = 2;
    localVenueOptBean.e = 1;
    this.c.postValue(localVenueOptBean);
    LocationShareVenueManager.a().b(this.g, paramVenue, new LocationShareViewModel.3(this, paramVenue));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, "myBtn onClick: invoked. set my btn black");
    }
    ReportController.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    this.b.setValue(Boolean.valueOf(true));
  }
  
  protected AppRuntime d()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void e()
  {
    ((LocationShareRepository)this.z).bN_();
    this.f = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewModel
 * JD-Core Version:    0.7.0.1
 */