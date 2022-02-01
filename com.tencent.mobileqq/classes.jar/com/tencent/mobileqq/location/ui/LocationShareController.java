package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.location.LocationShareViewBinder;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationItem;
import com.tencent.mobileqq.location.data.LocationRoom.RoomKey;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.model.UserLocationsUpdateBean;
import com.tencent.mobileqq.location.model.VenueOptBean;
import com.tencent.mobileqq.location.net.LocationHandler;
import com.tencent.mobileqq.mvvm.LifeCycleAndViewModelStoreOwner;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.BaseImageUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.LiuHaiUtils;
import java.util.Iterator;
import java.util.List;

public class LocationShareController
{
  private View jdField_a_of_type_AndroidViewView;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public QBaseActivity a;
  private DecodeTaskCompletionListener jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener;
  private final LocationShareViewModel jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel;
  private LocationRoom.RoomKey jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey;
  private HeadSetViewModule jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule;
  public MapWidget a;
  private RouteHolder jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder;
  private VenueHolder jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder;
  private final LifeCycleAndViewModelStoreOwner jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner;
  private View b;
  private View c;
  
  public LocationShareController(LocationShareViewModel paramLocationShareViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel = paramLocationShareViewModel;
    this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner = paramLifeCycleAndViewModelStoreOwner;
  }
  
  private void a(boolean paramBoolean, MapWidget.RouteDetail paramRouteDetail)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[venue] finishRoute: called. success: ");
      ((StringBuilder)localObject).append(paramBoolean);
      ((StringBuilder)localObject).append(" routeType: ");
      ((StringBuilder)localObject).append(paramRouteDetail.a);
      QLog.d("LocationShareController", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
      }
      e();
      return;
    }
    if (paramRouteDetail.a != null)
    {
      if (paramBoolean) {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a(paramRouteDetail, (LocationRoom.Venue)localObject);
      } else {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a(paramRouteDetail);
      }
    }
    else
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a(paramRouteDetail);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "路径规划失败，请稍后重试", 1).a();
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a();
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.c.setVisibility(0);
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder.a(paramVenue);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder.a();
  }
  
  private void b(VenueOptBean paramVenueOptBean)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(false);
    this.b.setVisibility(8);
    if (paramVenueOptBean.jdField_a_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenue(paramVenueOptBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2, "集合点设置成功", 0).a();
      ReportController.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    int i = paramVenueOptBean.jdField_a_of_type_Int;
    if (i != 10104)
    {
      if (i != 10105) {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "设置失败，请稍后重试", 0).a();
      } else {
        QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "已有人设置集合点", 0).a();
      }
    }
    else
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "你已离开共享会话", 0).a();
      this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.finish();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a() != null)
    {
      c();
      return;
    }
    e();
  }
  
  private void d()
  {
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new LocationShareController.2(this));
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setListener(new LocationShareController.3(this));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.c.setVisibility(4);
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder.b();
    this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.b();
  }
  
  void a()
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel.d();
    LocationAvatarHelper.a().a();
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
    this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder = new VenueHolder(this, this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel, paramView3);
    this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder = new RouteHolder(this, paramView3);
    this.b.setVisibility(8);
    LiuHaiUtils.a(paramQBaseActivity);
    int i;
    if (LiuHaiUtils.jdField_a_of_type_Boolean) {
      i = DisplayUtil.a(paramQBaseActivity, 112.0F) + LiuHaiUtils.jdField_a_of_type_Int;
    } else {
      i = DisplayUtil.a(paramQBaseActivity, 112.0F);
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramQBaseActivity, LocationHandler.a().a(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey), null, i, paramView3);
    d();
    LocationAvatarHelper.a().a(new LocationShareController.1(this));
    if (QQUIDelegate.b())
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setBackgroundResource(2130840626);
      paramView3.setBackgroundResource(2130838739);
    }
    LocationShareViewBinder.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel, this.jdField_a_of_type_ComTencentMobileqqMvvmLifeCycleAndViewModelStoreOwner, this);
  }
  
  public void a(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqAvatarListenerDecodeTaskCompletionListener = paramDecodeTaskCompletionListener;
  }
  
  void a(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[venue] setVenue: invoked. location: ");
      localStringBuilder.append(paramVenue);
      QLog.d("LocationShareController", 2, localStringBuilder.toString());
    }
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693828, 0).a();
      return;
    }
    if (paramVenue == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel.a(paramVenue);
  }
  
  public void a(UserLocationsUpdateBean paramUserLocationsUpdateBean)
  {
    if (paramUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey.equals(this.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.isFinishing()) {
        return;
      }
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
      this.jdField_a_of_type_ComTencentMobileqqLocationUiHeadSetViewModule.a(paramUserLocationsUpdateBean.jdField_a_of_type_JavaUtilList);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramUserLocationsUpdateBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$RoomKey);
    }
  }
  
  public void a(VenueOptBean paramVenueOptBean)
  {
    if (paramVenueOptBean.b == 1)
    {
      if (paramVenueOptBean.c == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
        b(paramVenueOptBean.jdField_a_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
        this.b.setVisibility(0);
        return;
      }
      if (paramVenueOptBean.c == 2) {
        b(paramVenueOptBean);
      }
    }
    else if (paramVenueOptBean.b == 2)
    {
      if (paramVenueOptBean.c == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(true);
        this.b.setVisibility(0);
        return;
      }
      if (paramVenueOptBean.c == 2)
      {
        this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenueOprating(false);
        this.b.setVisibility(8);
        if (paramVenueOptBean.jdField_a_of_type_Boolean)
        {
          this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.setVenue(null);
          e();
        }
      }
    }
  }
  
  void a(Integer paramInteger)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693828, 0).a();
      return;
    }
    int i;
    if (paramInteger == null) {
      i = 0;
    } else {
      i = paramInteger.intValue();
    }
    Integer localInteger = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(i);
    if ((paramInteger == null) && (localInteger != null)) {
      if (localInteger.intValue() == 3) {
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      } else if (localInteger.intValue() == 1) {
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    if (localInteger != null)
    {
      this.c.setVisibility(0);
      this.jdField_a_of_type_AndroidViewView.setVisibility(8);
      this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a(localInteger.intValue());
      this.jdField_a_of_type_ComTencentMobileqqLocationUiVenueHolder.b();
      this.jdField_a_of_type_ComTencentMobileqqLocationUiRouteHolder.a();
      return;
    }
    paramInteger = new MapWidget.RouteDetail();
    paramInteger.a = Integer.valueOf(i);
    a(false, paramInteger);
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a(paramString, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_AndroidWidgetImageView.setClickable(false);
      if (QQUIDelegate.b())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130840631));
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130840630));
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setClickable(true);
    this.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getResources().getDrawable(2130840632));
  }
  
  boolean a()
  {
    return this.b.getVisibility() == 0;
  }
  
  void b()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 2131693828, 0).a();
      return;
    }
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiMapWidget.a();
    if (localVenue == null)
    {
      QQToast.a(this.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, 1, "移除失败，请稍后重试", 0).a();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel.b(localVenue);
  }
  
  void c()
  {
    b(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController
 * JD-Core Version:    0.7.0.1
 */