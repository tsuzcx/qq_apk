package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.HashMap;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;

public class LocationPickController
  implements DecodeTaskCompletionListener
{
  private Activity jdField_a_of_type_AndroidAppActivity;
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationPickController.1(this);
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationHandler jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler = LocationHandler.a();
  private LocationPickAdaptor jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new LocationPickController.2(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable = new LocationPickController.3(this);
  private HashMap<String, LocationPickController.FaceItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private boolean jdField_a_of_type_Boolean = true;
  private View b;
  private View c;
  
  private void a(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131366452);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new LocationPickController.6(this, paramActivity, localEditText));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new LocationPickController.7(this, paramActivity));
    paramActivity = (AppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)paramActivity.getRuntimeService(IQQAvatarService.class, "")).getInstance(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  private void b()
  {
    this.jdField_a_of_type_Boolean = false;
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
  }
  
  private void c()
  {
    ThreadManager.getUIHandler().postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10000L);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  private void e()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.b.setEnabled(false);
  }
  
  private void f()
  {
    ThreadManager.getUIHandler().removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
    if (localVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(localVenue.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, true);
    int i = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
    if (i >= 0) {
      this.jdField_a_of_type_ComTencentWidgetXListView.setSelection(i);
    }
    if ((this.jdField_a_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.b())) {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.e();
    }
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.b.setEnabled(true);
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (LocationPickController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((LocationPickController.FaceItem)localObject2).jdField_a_of_type_Long < 4000L) && (((LocationPickController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((LocationPickController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((LocationPickController.FaceItem)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new LocationPickController.FaceItem(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((LocationPickController.FaceItem)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((LocationPickController.FaceItem)localObject1).jdField_a_of_type_Long = l;
      ((LocationPickController.FaceItem)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
  }
  
  void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      if (this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder != null) {
        this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
      }
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.b(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
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
  
  void a(Activity paramActivity, LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_AndroidAppActivity = paramActivity;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = paramPoiSlideBottomPanel;
    this.c = paramView3;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor = new LocationPickAdaptor(paramActivity);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(new LocationPickController.4(this));
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    paramXListView.setOnItemClickListener(new LocationPickController.5(this, paramPoiSlideBottomPanel));
    LiuHaiUtils.a(paramActivity);
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {}
    for (int i = DisplayUtil.a(paramActivity, 54.0F) + LiuHaiUtils.jdField_a_of_type_Int;; i = DisplayUtil.a(paramActivity, 54.0F) + ImmersiveUtils.getStatusBarHeight(paramActivity))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramActivity, this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), paramCameraPosition, i, paramPoiSlideBottomPanel);
      a(paramActivity);
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
      if (QQUIDelegate.b()) {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840751);
      }
      return;
    }
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getMap(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramString);
  }
  
  boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = BaseImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    LocationPickController.FaceItem localFaceItem = (LocationPickController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localFaceItem;
    if (localFaceItem == null)
    {
      paramBitmap = new LocationPickController.FaceItem(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, paramBitmap);
    }
    paramBitmap.jdField_a_of_type_Long = l;
    paramBitmap.jdField_a_of_type_AndroidGraphicsBitmap = localBitmap;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, localBitmap);
    if (this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener != null) {
      this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener.onDecodeTaskCompleted(paramInt1, paramInt2, paramString, localBitmap);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController
 * JD-Core Version:    0.7.0.1
 */