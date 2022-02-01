package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.api.IQQAvatarService;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.friend.api.IFriendDataService;
import com.tencent.mobileqq.friend.api.IFriendNameService;
import com.tencent.mobileqq.friend.observer.FriendObserver;
import com.tencent.mobileqq.location.OnUpdateUserLocationListener;
import com.tencent.mobileqq.location.api.ILocationShareService;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.location.net.RoomQueryHandler;
import com.tencent.mobileqq.location.window.FloatMapDialogUtil;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.ITroopMemberNameService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.util.HashMap;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class LocationShareController
  implements DecodeTaskCompletionListener
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private IFaceDecoder jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private FriendObserver jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver;
  private OnUpdateUserLocationListener jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener = new LocationShareController.1(this);
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationHandler jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler;
  private HeadSetViewModule jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule;
  private LocationShareController.RouteHolder jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder;
  private LocationShareController.VenueHolder jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private INetInfoHandler jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler;
  private TroopObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver;
  private HashMap<String, LocationShareController.FaceItem> jdField_a_of_type_JavaUtilHashMap = new HashMap(10);
  private View b;
  private View c;
  
  LocationShareController(AppInterface paramAppInterface)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler = LocationHandler.a();
  }
  
  private String a(String paramString)
  {
    if (Long.parseLong(paramString) <= 0L) {
      return paramString;
    }
    AppRuntime localAppRuntime = MobileQQ.sMobileQQ.waitAppRuntime(null);
    String str = ((IFriendNameService)localAppRuntime.getRuntimeService(IFriendNameService.class, "")).getFriendNick(paramString);
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 0)
    {
      paramString = ((IFriendDataService)localAppRuntime.getRuntimeService(IFriendDataService.class, "")).getFriend(paramString, true, true);
      if (paramString == null) {
        break label117;
      }
      paramString = paramString.getFriendNickWithAlias();
    }
    for (;;)
    {
      return paramString;
      if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a() == 1) {
        paramString = ((ITroopMemberNameService)localAppRuntime.getRuntimeService(ITroopMemberNameService.class, "")).getTroopMemberName(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), paramString);
      } else {
        label117:
        paramString = str;
      }
    }
  }
  
  private void a(Activity paramActivity)
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new LocationShareController.5(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new LocationShareController.6(this, paramActivity));
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder = ((IQQAvatarService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IQQAvatarService.class, "")).getInstance(this.jdField_a_of_type_ComTencentCommonAppAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.setDecodeTaskCompletionListener(this);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt, String paramString)
  {
    a(paramAppInterface, paramInt, paramString, -1);
  }
  
  public static void a(AppInterface paramAppInterface, int paramInt1, String paramString, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "stopOnErrorSituationByReason: invoked. ", " uin: ", paramString, " reason: ", Integer.valueOf(paramInt2) });
    }
    LocationRoom.RoomKey localRoomKey = new LocationRoom.RoomKey(paramInt1, paramString);
    LocationHandler localLocationHandler = LocationHandler.a();
    localLocationHandler.a(localRoomKey, false);
    localLocationHandler.a.b();
    ThreadManager.excute(new LocationShareController.4(paramAppInterface, paramInt1, paramString), 32, null, false);
    localLocationHandler.b(localRoomKey, paramInt2);
    ((ILocationShareService)paramAppInterface.getRuntimeService(ILocationShareService.class, "")).notifyStateError(paramInt1, paramString, false);
    ReportController.b(null, "CliOper", "", "", "0X800A8BC", "0X800A8BC", 0, 0, "", "0", "0", "");
  }
  
  private void a(Integer paramInteger)
  {
    if (!NetworkUtil.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693874, 0).a();
      return;
    }
    int i;
    Integer localInteger;
    if (paramInteger == null)
    {
      i = 0;
      localInteger = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(i);
      if ((paramInteger == null) && (localInteger != null))
      {
        if (localInteger.intValue() != 3) {
          break label134;
        }
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      }
    }
    for (;;)
    {
      if (localInteger == null) {
        break label171;
      }
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a(localInteger.intValue());
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder.b();
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a();
      return;
      i = paramInteger.intValue();
      break;
      label134:
      if (localInteger.intValue() == 1) {
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    label171:
    paramInteger = new MapWidget.RouteDetail();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  private void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] finishRoute: called. success: " + paramBoolean + " routeType: " + paramRouteDetail.a);
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
      }
      e();
      return;
    }
    if (paramRouteDetail.a != null) {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a(paramRouteDetail, localVenue);
      }
    }
    for (;;)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder.b();
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a();
      return;
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a(paramRouteDetail);
      continue;
      this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.a(paramRouteDetail);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder.a(paramVenue);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder.a();
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver = new LocationShareController.2(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
  }
  
  private void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver = new LocationShareController.3(this);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder.b();
  }
  
  private void f()
  {
    b(null);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = new LocationShareController.9(this);
    AppNetConnInfo.registerConnectionChangeReceiver(BaseApplication.getContext(), this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
  }
  
  private void h()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey != null)
    {
      FloatMapDialogUtil.b(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity);
      a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.a(), 2);
    }
  }
  
  public Bitmap a(String paramString)
  {
    Object localObject2 = (LocationShareController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    Object localObject1;
    if (localObject2 != null)
    {
      if ((l - ((LocationShareController.FaceItem)localObject2).jdField_a_of_type_Long < 4000L) && (((LocationShareController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap != null)) {
        return ((LocationShareController.FaceItem)localObject2).jdField_a_of_type_AndroidGraphicsBitmap;
      }
      localObject1 = localObject2;
      if (l - ((LocationShareController.FaceItem)localObject2).b < 2000L) {
        return null;
      }
    }
    else
    {
      localObject1 = new LocationShareController.FaceItem(null);
      this.jdField_a_of_type_JavaUtilHashMap.put(paramString, localObject1);
    }
    ((LocationShareController.FaceItem)localObject1).b = l;
    localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.getBitmapFromCache(1, paramString);
    if (localObject2 == null) {
      this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.requestDecodeFace(paramString, 200, false, 1, true, (byte)0, 4);
    }
    for (;;)
    {
      return localObject2;
      ((LocationShareController.FaceItem)localObject1).jdField_a_of_type_Long = l;
      ((LocationShareController.FaceItem)localObject1).jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject2);
    }
  }
  
  void a()
  {
    try
    {
      AppNetConnInfo.unregisterNetInfoHandler(this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler);
      this.jdField_a_of_type_ComTencentMobileqqMsfSdkHandlerINetInfoHandler = null;
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopObserver);
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqFriendObserverFriendObserver);
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
  
  void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, MapWidget paramMapWidget, HeadSetViewModule paramHeadSetViewModule, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule = paramHeadSetViewModule;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.c = paramView3;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$VenueHolder = new LocationShareController.VenueHolder(this, paramView3);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController$RouteHolder = new LocationShareController.RouteHolder(this, paramView3);
    this.b.setVisibility(8);
    LiuHaiUtils.a(paramQBaseActivity);
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {}
    for (int i = DisplayUtil.a(paramQBaseActivity, 112.0F) + LiuHaiUtils.jdField_a_of_type_Int;; i = DisplayUtil.a(paramQBaseActivity, 112.0F))
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), null, i, paramView3);
      a(paramQBaseActivity);
      this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationOnUpdateUserLocationListener);
      g();
      d();
      c();
      if (QQUIDelegate.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840751);
        paramView3.setBackgroundResource(2130838979);
      }
      return;
    }
  }
  
  public void a(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] setVenue: invoked. location: " + paramVenue);
    }
    if (!NetworkUtil.a()) {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693874, 0).a();
    }
    while (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    b(paramVenue);
    this.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, paramVenue, new LocationShareController.7(this, paramVenue));
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, true);
  }
  
  boolean a()
  {
    return this.b.getVisibility() == 0;
  }
  
  void b()
  {
    if (!NetworkUtil.a())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693874, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
    this.b.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqLocationNetLocationHandler.b(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, localVenue, new LocationShareController.8(this, localVenue));
  }
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[location] onDecodeTaskCompleted invoked. ", "remainingTasks = [" + paramInt1 + "], uin = [" + paramString + "], avatar = [" + paramBitmap + "]" });
    }
    Bitmap localBitmap = BaseImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight());
    LocationShareController.FaceItem localFaceItem = (LocationShareController.FaceItem)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    long l = System.currentTimeMillis();
    paramBitmap = localFaceItem;
    if (localFaceItem == null)
    {
      paramBitmap = new LocationShareController.FaceItem(null);
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
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController
 * JD-Core Version:    0.7.0.1
 */