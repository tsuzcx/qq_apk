package com.tencent.mobileqq.location;

import android.app.Activity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModelProvider.Factory;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.UserLocationsUpdateBean;
import com.tencent.mobileqq.location.ui.LocationAvatarHelper;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.ui.LocationPickAdaptor;
import com.tencent.mobileqq.mvvm.BaseViewModel;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.List;
import mqq.os.MqqHandler;

public class LocationPickViewModel
  extends BaseViewModel<LocationPickRepository>
{
  public static ViewModelProvider.Factory a;
  private Activity jdField_a_of_type_AndroidAppActivity;
  public MutableLiveData<UserLocationsUpdateBean> a;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationPickAdaptor jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new LocationPickViewModel.1(this);
  public MutableLiveData<Integer> b = new MutableLiveData();
  
  static
  {
    jdField_a_of_type_AndroidxLifecycleViewModelProvider$Factory = new LocationPickViewModel.2();
  }
  
  public LocationPickViewModel(LocationPickRepository paramLocationPickRepository)
  {
    super(paramLocationPickRepository);
    this.jdField_a_of_type_AndroidxLifecycleMutableLiveData = new MutableLiveData();
  }
  
  public void a()
  {
    ((LocationPickRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a();
  }
  
  public void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, LocationPickAdaptor paramLocationPickAdaptor)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor = paramLocationPickAdaptor;
    ((LocationPickRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).a(this);
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
    this.jdField_a_of_type_AndroidAppActivity.setResult(1);
    this.jdField_a_of_type_AndroidAppActivity.finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey)) {
      return;
    }
    if ((paramInt != 2) && (paramInt != 1))
    {
      this.jdField_a_of_type_AndroidAppActivity.setResult(1);
      LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
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
      paramRoomKey = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing()))
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(1);
        LocationDialogUtil.a(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
    else if (paramInt1 == 10101)
    {
      paramRoomKey = this.jdField_a_of_type_AndroidAppActivity;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing()))
      {
        this.jdField_a_of_type_AndroidAppActivity.setResult(1);
        LocationDialogUtil.b(this.jdField_a_of_type_AndroidAppActivity);
      }
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if (paramRoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey))
    {
      if (this.jdField_a_of_type_AndroidAppActivity.isFinishing()) {
        return;
      }
      UserLocationsUpdateBean localUserLocationsUpdateBean = new UserLocationsUpdateBean();
      localUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
      localUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue = paramVenue;
      localUserLocationsUpdateBean.jdField_a_of_type_JavaUtilList = paramList;
      this.jdField_a_of_type_AndroidxLifecycleMutableLiveData.postValue(localUserLocationsUpdateBean);
    }
  }
  
  public void a(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(paramTencentMap, paramLatLng, paramString);
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(new LocationPickViewModel.3(this));
  }
  
  public void e()
  {
    LocationAvatarHelper.a().a();
    ((LocationPickRepository)this.jdField_a_of_type_ComTencentMobileqqMvvmBaseRepository).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickViewModel
 * JD-Core Version:    0.7.0.1
 */