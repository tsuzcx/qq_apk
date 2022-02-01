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
  private FloatMapWidget a;
  private INetInfoHandler b;
  private LocationRoom.RoomKey c;
  private DecodeTaskCompletionListener d;
  private MapWidget.EventListener e;
  private final OnUpdateUserLocationListener f = new LocationFloatWindowController.1(this);
  
  private void a()
  {
    this.a.setOnMapLoadedCallback();
    d();
    LocationAvatarHelper.a().a(new LocationFloatWindowController.2(this));
  }
  
  private void b()
  {
    this.b = new LocationFloatWindowController.3(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.b);
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
      LocationRoom.RoomKey localRoomKey = this.c;
      if ((localRoomKey != null) && (localRoomKey.equals(localIFloatMapService.currentFloatWindowVisibleRoomKey())))
      {
        FloatMapDialogUtil.a(localQBaseActivity);
        localIFloatMapService.setBadNetOnFloatWindowDialogShown(true);
      }
    }
  }
  
  private void d()
  {
    this.e = new LocationFloatWindowController.4(this);
    this.a.setListener(this.e);
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget)
  {
    this.a = paramFloatMapWidget;
    this.c = paramRoomKey;
    this.a.a(null, LocationHandler.a().b(this.c), paramCameraPosition, DisplayUtil.a(BaseApplication.getContext(), 10.0F), null);
    this.a.setMapLogoVisibility(8);
    a();
    b();
    LocationHandler.a().a(this.f);
  }
  
  public void destroy()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.b);
      this.b = null;
    }
    catch (Exception localException)
    {
      QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
    }
    LocationAvatarHelper.a().b();
    this.e = null;
    LocationHandler.a().b(this.f);
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController
 * JD-Core Version:    0.7.0.1
 */