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
  public MapWidget a;
  public QBaseActivity b;
  private VenueHolder c;
  private RouteHolder d;
  private View e;
  private View f;
  private View g;
  private HeadSetViewModule h;
  private ImageView i;
  private LocationRoom.RoomKey j;
  private DecodeTaskCompletionListener k;
  private final LocationShareViewModel l;
  private final LifeCycleAndViewModelStoreOwner m;
  
  public LocationShareController(LocationShareViewModel paramLocationShareViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner)
  {
    this.l = paramLocationShareViewModel;
    this.m = paramLifeCycleAndViewModelStoreOwner;
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
    Object localObject = this.a.getVenue();
    if (localObject == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("LocationShareController", 2, "[venue] finishRoute: called. venue null");
      }
      f();
      return;
    }
    if (paramRouteDetail.a != null)
    {
      if (paramBoolean) {
        this.d.a(paramRouteDetail, (LocationRoom.Venue)localObject);
      } else {
        this.d.a(paramRouteDetail);
      }
    }
    else
    {
      this.d.a(paramRouteDetail);
      QQToast.makeText(this.b, 1, "路径规划失败，请稍后重试", 1).show();
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
    this.c.b();
    this.d.a();
  }
  
  private void b(LocationRoom.Venue paramVenue)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] showVenue: called.");
    }
    this.g.setVisibility(0);
    this.e.setVisibility(8);
    this.c.a(paramVenue);
    this.d.b();
    this.c.a();
  }
  
  private void b(VenueOptBean paramVenueOptBean)
  {
    this.a.setVenueOprating(false);
    this.f.setVisibility(8);
    if (paramVenueOptBean.b)
    {
      this.a.setVenue(paramVenueOptBean.a);
      QQToast.makeText(this.b, 2, "集合点设置成功", 0).show();
      ReportController.b(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    int n = paramVenueOptBean.c;
    if (n != 10104)
    {
      if (n != 10105) {
        QQToast.makeText(this.b, 1, "设置失败，请稍后重试", 0).show();
      } else {
        QQToast.makeText(this.b, 1, "已有人设置集合点", 0).show();
      }
    }
    else
    {
      QQToast.makeText(this.b, 1, "你已离开共享会话", 0).show();
      this.b.finish();
    }
    if (this.a.getVenue() != null)
    {
      c();
      return;
    }
    f();
  }
  
  private void e()
  {
    this.i.setOnClickListener(new LocationShareController.2(this));
    this.a.setListener(new LocationShareController.3(this));
  }
  
  private void f()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, "[venue] hideVenueAndRoute: called.");
    }
    this.g.setVisibility(4);
    this.e.setVisibility(0);
    this.c.b();
    this.d.b();
  }
  
  void a()
  {
    this.l.e();
    LocationAvatarHelper.a().b();
  }
  
  void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, MapWidget paramMapWidget, HeadSetViewModule paramHeadSetViewModule, ImageView paramImageView, View paramView1, View paramView2, View paramView3)
  {
    this.b = paramQBaseActivity;
    this.a = paramMapWidget;
    this.h = paramHeadSetViewModule;
    this.i = paramImageView;
    this.j = paramRoomKey;
    this.e = paramView2;
    this.f = paramView1;
    this.g = paramView3;
    this.c = new VenueHolder(this, this.l, paramView3);
    this.d = new RouteHolder(this, paramView3);
    this.f.setVisibility(8);
    LiuHaiUtils.f(paramQBaseActivity);
    int n;
    if (LiuHaiUtils.b) {
      n = DisplayUtil.a(paramQBaseActivity, 112.0F) + LiuHaiUtils.d;
    } else {
      n = DisplayUtil.a(paramQBaseActivity, 112.0F);
    }
    this.a.a(paramQBaseActivity, LocationHandler.a().b(this.j), null, n, paramView3);
    e();
    LocationAvatarHelper.a().a(new LocationShareController.1(this));
    if (QQUIDelegate.c())
    {
      this.i.setBackgroundResource(2130841399);
      paramView3.setBackgroundResource(2130838958);
    }
    LocationShareViewBinder.a(this.l, this.m, this);
  }
  
  public void a(DecodeTaskCompletionListener paramDecodeTaskCompletionListener)
  {
    this.k = paramDecodeTaskCompletionListener;
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
      QQToast.makeText(this.b, 2131891404, 0).show();
      return;
    }
    if (paramVenue == null) {
      return;
    }
    this.l.a(paramVenue);
  }
  
  public void a(UserLocationsUpdateBean paramUserLocationsUpdateBean)
  {
    if (paramUserLocationsUpdateBean.a.equals(this.j))
    {
      if (this.b.isFinishing()) {
        return;
      }
      Iterator localIterator = paramUserLocationsUpdateBean.c.iterator();
      while (localIterator.hasNext())
      {
        LocationItem localLocationItem = (LocationItem)localIterator.next();
        Bitmap localBitmap = LocationAvatarHelper.a().a(localLocationItem.c());
        if (localBitmap != null)
        {
          localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
          this.a.a(localLocationItem.c(), localBitmap);
        }
      }
      this.h.a(paramUserLocationsUpdateBean.c);
      this.a.a(paramUserLocationsUpdateBean.a);
    }
  }
  
  public void a(VenueOptBean paramVenueOptBean)
  {
    if (paramVenueOptBean.d == 1)
    {
      if (paramVenueOptBean.e == 1)
      {
        this.a.setVenueOprating(true);
        b(paramVenueOptBean.a);
        this.f.setVisibility(0);
        return;
      }
      if (paramVenueOptBean.e == 2) {
        b(paramVenueOptBean);
      }
    }
    else if (paramVenueOptBean.d == 2)
    {
      if (paramVenueOptBean.e == 1)
      {
        this.a.setVenueOprating(true);
        this.f.setVisibility(0);
        return;
      }
      if (paramVenueOptBean.e == 2)
      {
        this.a.setVenueOprating(false);
        this.f.setVisibility(8);
        if (paramVenueOptBean.b)
        {
          this.a.setVenue(null);
          f();
        }
      }
    }
  }
  
  void a(Integer paramInteger)
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.makeText(this.b, 2131891404, 0).show();
      return;
    }
    int n;
    if (paramInteger == null) {
      n = 0;
    } else {
      n = paramInteger.intValue();
    }
    Integer localInteger = this.a.a(n);
    if ((paramInteger == null) && (localInteger != null)) {
      if (localInteger.intValue() == 3) {
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 1, 0, "", "0", "0", "");
      } else if (localInteger.intValue() == 1) {
        ReportController.b(null, "CliOper", "", "", "0X800A96C", "0X800A96C", 2, 0, "", "0", "0", "");
      }
    }
    if (localInteger != null)
    {
      this.g.setVisibility(0);
      this.e.setVisibility(8);
      this.d.a(localInteger.intValue());
      this.c.b();
      this.d.a();
      return;
    }
    paramInteger = new MapWidget.RouteDetail();
    paramInteger.a = Integer.valueOf(n);
    a(false, paramInteger);
  }
  
  public void a(String paramString)
  {
    this.a.a(paramString, true);
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.i.setClickable(false);
      if (QQUIDelegate.c())
      {
        this.i.setImageDrawable(this.b.getResources().getDrawable(2130841404));
        return;
      }
      this.i.setImageDrawable(this.b.getResources().getDrawable(2130841403));
      return;
    }
    this.i.setClickable(true);
    this.i.setImageDrawable(this.b.getResources().getDrawable(2130841405));
  }
  
  void b()
  {
    if (!NetworkUtil.isNetworkAvailable())
    {
      QQToast.makeText(this.b, 2131891404, 0).show();
      return;
    }
    LocationRoom.Venue localVenue = this.a.getVenue();
    if (localVenue == null)
    {
      QQToast.makeText(this.b, 1, "移除失败，请稍后重试", 0).show();
      return;
    }
    this.l.b(localVenue);
  }
  
  void c()
  {
    b(null);
  }
  
  boolean d()
  {
    return this.f.getVisibility() == 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController
 * JD-Core Version:    0.7.0.1
 */