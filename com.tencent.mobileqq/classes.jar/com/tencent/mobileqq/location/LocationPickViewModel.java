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
  public static ViewModelProvider.Factory c = new LocationPickViewModel.2();
  public MutableLiveData<UserLocationsUpdateBean> a = new MutableLiveData();
  public MutableLiveData<Integer> b = new MutableLiveData();
  private Activity d;
  private LocationRoom.RoomKey e;
  private LocationPickAdaptor f;
  private final Runnable g = new LocationPickViewModel.1(this);
  
  public LocationPickViewModel(LocationPickRepository paramLocationPickRepository)
  {
    super(paramLocationPickRepository);
  }
  
  public void a()
  {
    ((LocationPickRepository)this.z).a();
  }
  
  public void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, LocationPickAdaptor paramLocationPickAdaptor)
  {
    this.d = paramQBaseActivity;
    this.e = paramRoomKey;
    this.f = paramLocationPickAdaptor;
    ((LocationPickRepository)this.z).a(this);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[LocationShareController] onKickOff: invoked. roomKey: ");
      localStringBuilder.append(paramRoomKey);
      localStringBuilder.append(" mRoomKey: ");
      localStringBuilder.append(this.e);
      QLog.d("Q.LocationShare", 2, localStringBuilder.toString());
    }
    QQToast.makeText(BaseApplication.getContext(), "已在其他设备进行共享", 0).show();
    this.d.setResult(1);
    this.d.finish();
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt)
  {
    if (!paramRoomKey.equals(this.e)) {
      return;
    }
    if ((paramInt != 2) && (paramInt != 1))
    {
      this.d.setResult(1);
      LocationDialogUtil.a(this.d);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.LocationShare", 2, new Object[] { "onOperateRoomResponse: invoked. ", " roomKey: ", paramRoomKey, " errorCode: ", Integer.valueOf(paramInt1), " operateType: ", Integer.valueOf(paramInt2) });
    }
    if (!paramRoomKey.equals(this.e)) {
      return;
    }
    if (paramInt1 == 10100)
    {
      paramRoomKey = this.d;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing()))
      {
        this.d.setResult(1);
        LocationDialogUtil.a(this.d);
      }
    }
    else if (paramInt1 == 10101)
    {
      paramRoomKey = this.d;
      if ((paramRoomKey != null) && (!paramRoomKey.isFinishing()))
      {
        this.d.setResult(1);
        LocationDialogUtil.b(this.d);
      }
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, LocationRoom.Venue paramVenue, List<LocationItem> paramList)
  {
    if (paramRoomKey.equals(this.e))
    {
      if (this.d.isFinishing()) {
        return;
      }
      UserLocationsUpdateBean localUserLocationsUpdateBean = new UserLocationsUpdateBean();
      localUserLocationsUpdateBean.a = paramRoomKey;
      localUserLocationsUpdateBean.b = paramVenue;
      localUserLocationsUpdateBean.c = paramList;
      this.a.postValue(localUserLocationsUpdateBean);
    }
  }
  
  public void a(TencentMap paramTencentMap, LatLng paramLatLng, String paramString)
  {
    this.f.a(paramTencentMap, paramLatLng, paramString);
  }
  
  public void b()
  {
    ThreadManager.getUIHandler().postDelayed(this.g, 10000L);
  }
  
  public void c()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.g);
  }
  
  public void d()
  {
    this.f.a(new LocationPickViewModel.3(this));
  }
  
  public boolean e()
  {
    return this.f.d();
  }
  
  public void f()
  {
    LocationAvatarHelper.a().b();
    ((LocationPickRepository)this.z).c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.LocationPickViewModel
 * JD-Core Version:    0.7.0.1
 */