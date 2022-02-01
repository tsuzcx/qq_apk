package com.tencent.mobileqq.location.window;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.IFloatMapService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.ui.MapWidget.EventListener;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import java.util.HashMap;
import javax.security.auth.Destroyable;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocationFloatWindowController
  implements DecodeTaskCompletionListener, Destroyable
{
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationFloatWindowController.1(this);
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationHandler jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler = LocationHandler.a();
  private MapWidget.EventListener jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener;
  private FloatMapWidget jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private HashMap<String, LocationFloatWindowController.FaceItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setOnMapLoadedCallback();
    d();
    AppInterface localAppInterface = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)localAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(localAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new LocationFloatWindowController.2(this);
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
      if ((this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null) && (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.equals(localIFloatMapService.currentFloatWindowVisibleRoomKey())))
      {
        FloatMapDialogUtil.a(localQBaseActivity);
        localIFloatMapService.setBadNetOnFloatWindowDialogShown(true);
      }
    }
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener = new LocationFloatWindowController.3(this);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setListener(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (LocationFloatWindowController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((LocationFloatWindowController.FaceItem)localObject2).jdField_a_of_type_Long < 4000L) && (((LocationFloatWindowController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((LocationFloatWindowController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((LocationFloatWindowController.FaceItem)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new LocationFloatWindowController.FaceItem(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((LocationFloatWindowController.FaceItem)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((LocationFloatWindowController.FaceItem)localObject1).jdField_a_of_type_Long = l;
      ((LocationFloatWindowController.FaceItem)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  public void a(LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, FloatMapWidget paramFloatMapWidget, ImageView paramImageView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = paramFloatMapWidget;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(null, this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), paramCameraPosition, DisplayUtil.a(BaseApplication.getContext(), 10.0F), null);
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.setMapLogoVisibility(8);
    a();
    b();
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
  }
  
  public void destroy()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget$EventListener = null;
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.b(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
      this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget = null;
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.e("LocationShareController", 1, "onFragmentDestroy: failed. ", localException);
      }
    }
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = BaseImageUtil.c(paramBitmap, 16, 16);
    LocationFloatWindowController.FaceItem localFaceItem = (LocationFloatWindowController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localFaceItem;
    if (localFaceItem == null)
    {
      paramBitmap = new LocationFloatWindowController.FaceItem(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationWindowFloatMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.window.LocationFloatWindowController
 * JD-Core Version:    0.7.0.1
 */