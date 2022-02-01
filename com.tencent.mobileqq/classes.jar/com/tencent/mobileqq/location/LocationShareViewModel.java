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
  public static ViewModelProvider.Factory a;
  public MutableLiveData<UserLocationsUpdateBean> a;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  public MutableLiveData<Boolean> b = new MutableLiveData();
  public MutableLiveData<VenueOptBean> c = new MutableLiveData();
  
  static
  {
    jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new LocationShareViewModel.1();
  }
  
  public LocationShareViewModel(LocationShareRepository paramLocationShareRepository)
  {
    super(paramLocationShareRepository);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
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
    LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomQueryHandler.b();
    ThreadManager.excute(new LocationShareViewModel.4(paramAppInterface, paramInt1, paramString), 32, null, false);
    LocationHandler.a().b(localRoomKey, paramInt2);
    ((ILocationShareService)paramAppInterface.getRuntimeService(ILocationShareService.class, "")).notifyStateError(paramInt1, paramString, false);
    ReportController.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
  }
  
  public String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    AppRuntime localAppRuntime = a();
    String str = ((IFriendNameService)localAppRuntime.getRuntimeService(IFriendNameService.class, "")).getFriendNick(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 0)
    {
      paramString = ((IFriendDataService)localAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
      if (paramString != null) {
        return paramString.getFriendNickWithAlias();
      }
    }
    else if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 1)
    {
      str = ((ITroopMemberNameService)localAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), paramString);
    }
    return str;
  }
  
  protected AppRuntime a()
  {
    return MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public void a()
  {
    ((LocationShareRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
  }
  
  public void a(AppInterface paramAppInterface, QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    ((LocationShareRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(paramAppInterface, this);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[LocationShareController] onKickOff: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      localStringBuilder.append(" mRoomKey: ");
      localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
      QLog.d("Q.LocationShare", 2, localStringBuilder.toString());
    }
    QQToast.a(BaseApplication.getContext(), "已在其他设备进行共享", 0).a();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey)) {
      return;
    }
    int i;
    if (LocationShareRoomManager.a().a() != null) {
      i = 1;
    } else {
      i = 0;
    }
    LocationShareRoomManager.a().a(null);
    if ((paramInt != 2) && (paramInt != 1) && (i == 0)) {
      LocationDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey)) {
      return;
    }
    if (paramInt1 == 10100)
    {
      if ((paramInt2 == 2) && (LocationHandler.a().a() == 1))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null)
        {
          LocationShareRoomManager.a().jdField_a_of_type_ComTencentMobileqqLocationNetRoomOperateHandler.a(1, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a());
          QLog.d("Q.LocationShare", 1, new Object[] { "onOperateRoomResponse: invoked. 兜底处理房间关闭状态，在进房失败后创建房间。 ", " errorCode: ", Integer.valueOf(paramInt1) });
          return;
        }
        QLog.e("Q.LocationShare", 1, "onOperateRoomResponse: failed. not valid room key. ", new RuntimeException());
        return;
      }
      paramRoomKey = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing())) {
        LocationDialogUtil.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      }
    }
    else if (paramInt1 == 10101)
    {
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if ((localQBaseActivity != null) && (!localQBaseActivity.isFinishing()))
      {
        LocationDialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
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
    localVenueOptBean.c = 1;
    localVenueOptBean.b = 1;
    localVenueOptBean.a = paramVenue;
    this.c.postValue(localVenueOptBean);
    LocationShareVenueManager.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, paramVenue, new LocationShareViewModel.2(this, paramVenue));
  }
  
  public void a(String paramString)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 1) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a().equals(paramString)))
    {
      if (QLog.isColorLevel()) {
        QLog.d("Q.LocationShare", 2, new Object[] { "onPassiveExit: invoked. ", " troopUin: ", paramString });
      }
      QBaseActivity localQBaseActivity = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (localQBaseActivity != null)
      {
        localQBaseActivity.finish();
        QQToast.a(BaseApplication.getContext(), 2131693117, 1).a();
      }
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 1, paramString);
    }
  }
  
  public void a(boolean paramBoolean, String paramString)
  {
    if ((paramBoolean) && (paramString.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a())))
    {
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 0, paramString);
      paramString = this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
      if (paramString != null) {
        paramString.finish();
      }
    }
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null)
    {
      FloatMapDialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), 2);
    }
  }
  
  public void b(LocationRoom.Venue paramVenue)
  {
    VenueOptBean localVenueOptBean = new VenueOptBean();
    localVenueOptBean.b = 2;
    localVenueOptBean.c = 1;
    this.c.postValue(localVenueOptBean);
    LocationShareVenueManager.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, paramVenue, new LocationShareViewModel.3(this, paramVenue));
  }
  
  public void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, "myBtn onClick: invoked. set my btn black");
    }
    ReportController.b(null, "CliOper", "", "", "0X800A771", "0X800A771", 0, 0, "", "0", "0", "");
    this.b.setValue(Boolean.valueOf(true));
  }
  
  public void d()
  {
    ((LocationShareRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).c();
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationShareViewModel
 * JD-Core Version:    0.7.0.1
 */