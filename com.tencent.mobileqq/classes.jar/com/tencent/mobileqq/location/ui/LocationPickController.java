package com.tencent.mobileqq.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationPickViewModel;
import com.tencent.mobileqq.location.LocationShareViewBinder;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.UserLocationsUpdateBean;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.util.LiuHaiUtils;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.Iterator;
import java.util.List;

public class LocationPickController
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private QBaseActivity jdField_a_of_type_ComTencentMobileqqAppQBaseActivity;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  public final LocationPickViewModel a;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private LocationPickAdaptor jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor;
  private MapWidget jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget;
  private PoiSlideBottomPanel jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel;
  private final LifeCycleAndViewModelStoreOwner jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner;
  private LatLng jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng;
  private final AbsListView.OnScrollListener jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener = new LocationPickController.1(this);
  private XListView jdField_a_of_type_ComTencentWidgetXListView;
  private boolean jdField_a_of_type_Boolean = true;
  private View b;
  private View c;
  
  LocationPickController(LocationPickViewModel paramLocationPickViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel = paramLocationPickViewModel;
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner = paramLifeCycleAndViewModelStoreOwner;
  }
  
  private void a(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel.findViewById(2131366333);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new LocationPickController.4(this, paramActivity, localEditText));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new LocationPickController.5(this, paramActivity));
  }
  
  LocationRoom.Venue a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor.a();
  }
  
  public void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.b();
    this.jdField_a_of_type_Boolean = false;
  }
  
  void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity = paramQBaseActivity;
    this.jdField_a_of_type_AndroidViewView = paramView2;
    this.b = paramView1;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiPoiSlideBottomPanel = paramPoiSlideBottomPanel;
    this.c = paramView3;
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget = paramMapWidget;
    this.jdField_a_of_type_AndroidWidgetImageView = paramImageView;
    this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey = paramRoomKey;
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor = new LocationPickAdaptor(paramQBaseActivity);
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey, this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor);
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.d();
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickAdaptor);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.jdField_a_of_type_ComTencentWidgetAbsListView$OnScrollListener);
    paramXListView.setOnItemClickListener(new LocationPickController.2(this, paramPoiSlideBottomPanel));
    LiuHaiUtils.a(paramQBaseActivity);
    int i;
    int j;
    if (LiuHaiUtils.jdField_a_of_type_Boolean)
    {
      i = DisplayUtil.a(paramQBaseActivity, 54.0F);
      j = LiuHaiUtils.jdField_a_of_type_Int;
    }
    else
    {
      i = DisplayUtil.a(paramQBaseActivity, 54.0F);
      j = ImmersiveUtils.getStatusBarHeight(paramQBaseActivity);
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramQBaseActivity, LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), paramCameraPosition, i + j, paramPoiSlideBottomPanel);
    a(paramQBaseActivity);
    LocationAvatarHelper.a().a(new LocationPickController.3(this));
    if (QQUIDelegate.b()) {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840626);
    }
    LocationShareViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel, this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, this);
  }
  
  public void a(UserLocationsUpdateBean paramUserLocationsUpdateBean)
  {
    Iterator localIterator = paramUserLocationsUpdateBean.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      LocationItem localLocationItem = (LocationItem)localIterator.next();
      Bitmap localBitmap = LocationAvatarHelper.a().a(localLocationItem.a());
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(localLocationItem.a(), localBitmap);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
  }
  
  void a(String paramString)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.getMap(), this.jdField_a_of_type_ComTencentTencentmapMapsdkMapsModelLatLng, paramString);
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.b();
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  public void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.c();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(0);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(8);
    this.b.setEnabled(false);
  }
  
  public void d()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.c();
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.c.setVisibility(8);
    this.jdField_a_of_type_ComTencentWidgetXListView.setVisibility(0);
    this.b.setEnabled(false);
  }
  
  public void e()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.c();
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
  
  void f()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationPickViewModel.e();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController
 * JD-Core Version:    0.7.0.1
 */