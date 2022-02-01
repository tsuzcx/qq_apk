package com.tencent.mobileqq.location.window;

import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.LocationAvatarHelper;
import com.tencent.mobileqq.location.ui.MapWidget.EventListener;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import javax.security.auth.Destroyable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocationFloatWindowController
  implements Destroyable
{
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private final OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationFloatWindowController.1(this);
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private MapWidget.EventListener jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    d();
    LocationAvatarHelper.a().a(new LocationFloatWindowController.2(this));
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new LocationFloatWindowController.3(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void c()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "onBadNetSituation: invoked. ", " TAG: ", "LocationShareController" });
    }
    QBaseActivity localQBaseActivity = QBaseActivity.sTopActivity;
    if (localQBaseActivity != null)
    {
      IFloatMapService localIFloatMapService = (IFloatMapService)MobileQQ.sMobileQQ.waitAppRuntime(null).getRuntimeService(IFloatMapService.class, "");
      LocationRoom.RoomKey localRoomKey = this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
      if ((localRoomKey != null) && (localRoomKey.equals(localIFloatMapService.currentFloatWindowVisibleRoomKey())))
      {
        FloatMapDialogUtil.a(localQBaseActivity);
        localIFloatMapService.setBadNetOnFloatWindowDialogShown(true);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener = new LocationFloatWindowController.4(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), paramCameraPosition, DisplayUtil.a(BaseApplication.getContext(), 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    a();
    b();
    LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
  }
  
  public void destroy()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
    }
    catch (Exception localException)
    {
      QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
    }
    LocationAvatarHelper.a().a();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener = null;
    LocationHandler.a().b(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController
 * JD-Core Version:    0.7.0.1
 */