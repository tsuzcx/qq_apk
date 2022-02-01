package com.tencent.mobileqq.location.api.impl;

import android.app.Dialog;
import android.content.Context;
import android.os.Handler;
import android.support.annotation.UiThread;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.map.geolocation.TencentLocation;
import com.tencent.map.geolocation.TencentLocationManager;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.location.ThemeChangedListener;
import com.tencent.mobileqq.location.ThemeChangedReceiver;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.callback.IFloatMapCallback;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.LocationDialogUtil;
import com.tencent.mobileqq.location.util.LocationReportUtil;
import com.tencent.mobileqq.location.window.FloatMapWidget;
import com.tencent.mobileqq.location.window.GlobalFloatDialog;
import com.tencent.mobileqq.location.window.LocationFloatWindowController;
import com.tencent.mobileqq.location.window.event.EventProvider;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;

public class FloatMapServiceImpl
  implements IFloatMapService
{
  public static final int QUIT_FROM_TYPE_BAD_NET = 3;
  public static final int QUIT_FROM_TYPE_DESTROY_MANAGER = 2;
  public static final int QUIT_FROM_TYPE_ENTER_SHARE_FRAGMENT = 1;
  public static final int QUIT_FROM_TYPE_IGNORED = -1;
  private static final String TAG = "FloatMapServiceImpl";
  AppRuntime app;
  public boolean badNetOnFloatWindowDialogShown = false;
  private EventProvider eventProvider;
  private List<IFloatMapCallback> floatMapCallbacks;
  private FloatMapWidget floatMapWidget;
  LocationFloatWindowController floatWindowController;
  private ThemeChangedReceiver themeChangedReceiver;
  
  private void createMapWidget(LocationRoom.RoomKey paramRoomKey)
  {
    Object localObject = TencentLocationManager.getInstance(BaseApplication.getContext()).getLastKnownLocation();
    if (localObject != null) {}
    for (localObject = new LatLng(((TencentLocation)localObject).getLatitude(), ((TencentLocation)localObject).getLongitude());; localObject = null)
    {
      localObject = CameraPosition.fromLatLngZoom((LatLng)localObject, 15.0F);
      this.floatMapWidget = ((FloatMapWidget)LayoutInflater.from(BaseApplication.getContext()).inflate(2131559415, null).findViewById(2131370796));
      this.floatWindowController.a(paramRoomKey, (CameraPosition)localObject, this.floatMapWidget, null);
      return;
    }
  }
  
  private void initMapWidgetSettings()
  {
    UiSettings localUiSettings = this.floatMapWidget.getMap().getUiSettings();
    localUiSettings.setScaleViewEnabled(false);
    localUiSettings.setLogoScale(0.2F);
    this.floatMapWidget.onResume();
  }
  
  private void quitFloatDirectly(int paramInt)
  {
    try
    {
      Iterator localIterator = getFloatMapCallbacks().iterator();
      while (localIterator.hasNext())
      {
        ((IFloatMapCallback)localIterator.next()).a();
        continue;
        this.floatWindowController.destroy();
      }
    }
    catch (Exception localException)
    {
      QLog.e("FloatMapServiceImpl", 1, "quitFloat: failed. ", localException);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("FloatMapServiceImpl", 2, new Object[] { "quitFloat: invoked. ", " fromType: ", Integer.valueOf(paramInt) });
      }
      return;
      this.eventProvider.a();
      if (this.floatMapWidget != null)
      {
        this.floatMapWidget.onPause();
        this.floatMapWidget.onStop();
        if ((this.floatMapWidget.getMap() != null) && (!this.floatMapWidget.getMap().isDestroyed())) {
          this.floatMapWidget.onDestroy();
        }
        this.floatMapWidget = null;
      }
    }
  }
  
  public void addFloatMapCallback(IFloatMapCallback paramIFloatMapCallback)
  {
    synchronized (this.floatMapCallbacks)
    {
      this.floatMapCallbacks.add(paramIFloatMapCallback);
      return;
    }
  }
  
  public Dialog createFloatExitConfirmDialog(int paramInt, String paramString)
  {
    return LocationDialogUtil.a(paramInt, paramString);
  }
  
  public LocationRoom.RoomKey currentFloatWindowVisibleRoomKey()
  {
    return this.eventProvider.a();
  }
  
  public boolean enterFloat(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey)
  {
    if (!AppNetConnInfo.isNetSupport())
    {
      QQToast.a(BaseApplication.getContext(), 2131694459, 0).a();
      return false;
    }
    createMapWidget(paramRoomKey);
    initMapWidgetSettings();
    Iterator localIterator = getFloatMapCallbacks().iterator();
    while (localIterator.hasNext()) {
      if (!((IFloatMapCallback)localIterator.next()).a(paramQBaseActivity, paramRoomKey)) {
        return false;
      }
    }
    this.eventProvider.a(paramRoomKey);
    LocationHandler.a().c(paramRoomKey.a(), paramRoomKey.a());
    int i = LocationReportUtil.a(paramRoomKey);
    if (i != 0) {
      ReportController.b(null, "CliOper", "", "", "0X800A974", "0X800A974", i, 0, "0", "0", "0", "");
    }
    return true;
  }
  
  public boolean getBadNetOnFloatWindowDialogShown()
  {
    return this.badNetOnFloatWindowDialogShown;
  }
  
  public List<IFloatMapCallback> getFloatMapCallbacks()
  {
    return this.floatMapCallbacks;
  }
  
  public View getFloatMapView()
  {
    return this.floatMapWidget;
  }
  
  public void onCreate(AppRuntime paramAppRuntime)
  {
    this.app = paramAppRuntime;
    this.floatMapCallbacks = new ArrayList();
    this.eventProvider = new EventProvider(this.app);
    this.themeChangedReceiver = new ThemeChangedReceiver();
    this.floatWindowController = new LocationFloatWindowController();
  }
  
  public void onDestroy()
  {
    synchronized (this.floatMapCallbacks)
    {
      this.floatMapCallbacks.clear();
      this.themeChangedReceiver.a();
      this.floatWindowController.destroy();
      quitFloat(2);
      ??? = getFloatMapCallbacks().iterator();
      if (((Iterator)???).hasNext()) {
        ((IFloatMapCallback)((Iterator)???).next()).b();
      }
    }
  }
  
  @UiThread
  public void quitFloat(int paramInt)
  {
    FloatMapServiceImpl.4 local4 = new FloatMapServiceImpl.4(this, paramInt);
    ThreadManager.getUIHandlerV2().post(local4);
  }
  
  public void removeFloatMapCallback(IFloatMapCallback paramIFloatMapCallback)
  {
    synchronized (this.floatMapCallbacks)
    {
      this.floatMapCallbacks.remove(paramIFloatMapCallback);
      return;
    }
  }
  
  public void setBadNetOnFloatWindowDialogShown(boolean paramBoolean)
  {
    this.badNetOnFloatWindowDialogShown = paramBoolean;
  }
  
  public void setThemeChangedListener(ThemeChangedListener paramThemeChangedListener)
  {
    this.themeChangedReceiver.a(paramThemeChangedListener);
  }
  
  public void showFloatTypeDialog(LocationRoom.RoomKey paramRoomKey)
  {
    BaseApplication localBaseApplication = BaseApplication.getContext();
    GlobalFloatDialog localGlobalFloatDialog = new GlobalFloatDialog();
    localGlobalFloatDialog.a(localBaseApplication.getString(2131719404));
    localGlobalFloatDialog.b(localBaseApplication.getString(2131690946));
    localGlobalFloatDialog.c(localBaseApplication.getString(2131691327));
    localGlobalFloatDialog.a(new FloatMapServiceImpl.1(this, paramRoomKey));
    localGlobalFloatDialog.b(new FloatMapServiceImpl.2(this));
    localGlobalFloatDialog.c(new FloatMapServiceImpl.3(this, localGlobalFloatDialog));
    localGlobalFloatDialog.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.api.impl.FloatMapServiceImpl
 * JD-Core Version:    0.7.0.1
 */