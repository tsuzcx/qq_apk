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
  public final LocationPickViewModel a;
  private boolean b = true;
  private PoiSlideBottomPanel c;
  private View d;
  private View e;
  private View f;
  private XListView g;
  private MapWidget h;
  private ImageView i;
  private LocationPickAdaptor j;
  private LatLng k;
  private QBaseActivity l;
  private LocationRoom.RoomKey m;
  private DecodeTaskCompletionListener n;
  private final LifeCycleAndViewModelStoreOwner o;
  private final AbsListView.OnScrollListener p = new LocationPickController.1(this);
  
  LocationPickController(LocationPickViewModel paramLocationPickViewModel, LifeCycleAndViewModelStoreOwner paramLifeCycleAndViewModelStoreOwner)
  {
    this.a = paramLocationPickViewModel;
    this.o = paramLifeCycleAndViewModelStoreOwner;
  }
  
  private void a(Activity paramActivity)
  {
    EditText localEditText = (EditText)this.c.findViewById(2131432634);
    this.i.setOnClickListener(new LocationPickController.4(this, paramActivity, localEditText));
    this.h.setListener(new LocationPickController.5(this, paramActivity));
  }
  
  public void a()
  {
    this.a.b();
    this.b = false;
  }
  
  void a(QBaseActivity paramQBaseActivity, LocationRoom.RoomKey paramRoomKey, CameraPosition paramCameraPosition, MapWidget paramMapWidget, ImageView paramImageView, View paramView1, PoiSlideBottomPanel paramPoiSlideBottomPanel, XListView paramXListView, View paramView2, View paramView3)
  {
    this.l = paramQBaseActivity;
    this.d = paramView2;
    this.e = paramView1;
    this.c = paramPoiSlideBottomPanel;
    this.f = paramView3;
    this.g = paramXListView;
    this.h = paramMapWidget;
    this.i = paramImageView;
    this.m = paramRoomKey;
    this.j = new LocationPickAdaptor(paramQBaseActivity);
    this.a.a(this.l, this.m, this.j);
    this.a.d();
    paramXListView.setDividerHeight(0);
    paramXListView.setAdapter(this.j);
    paramXListView.setSelectionAfterHeaderView();
    paramXListView.setOnScrollListener(this.p);
    paramXListView.setOnItemClickListener(new LocationPickController.2(this, paramPoiSlideBottomPanel));
    LiuHaiUtils.f(paramQBaseActivity);
    int i1;
    int i2;
    if (LiuHaiUtils.b)
    {
      i1 = DisplayUtil.a(paramQBaseActivity, 54.0F);
      i2 = LiuHaiUtils.d;
    }
    else
    {
      i1 = DisplayUtil.a(paramQBaseActivity, 54.0F);
      i2 = ImmersiveUtils.getStatusBarHeight(paramQBaseActivity);
    }
    this.h.a(paramQBaseActivity, LocationHandler.a().b(this.m), paramCameraPosition, i1 + i2, paramPoiSlideBottomPanel);
    a(paramQBaseActivity);
    LocationAvatarHelper.a().a(new LocationPickController.3(this));
    if (QQUIDelegate.c()) {
      this.i.setBackgroundResource(2130841399);
    }
    LocationShareViewBinder.a(this.a, this.o, this);
  }
  
  public void a(UserLocationsUpdateBean paramUserLocationsUpdateBean)
  {
    Iterator localIterator = paramUserLocationsUpdateBean.c.iterator();
    while (localIterator.hasNext())
    {
      LocationItem localLocationItem = (LocationItem)localIterator.next();
      Bitmap localBitmap = LocationAvatarHelper.a().a(localLocationItem.c());
      if (localBitmap != null)
      {
        localBitmap = BaseImageUtil.c(localBitmap, localBitmap.getWidth(), localBitmap.getHeight());
        this.h.a(localLocationItem.c(), localBitmap);
      }
    }
    this.h.a(paramUserLocationsUpdateBean.a);
  }
  
  void a(String paramString)
  {
    this.b = false;
    this.a.a(this.h.getMap(), this.k, paramString);
  }
  
  public void b()
  {
    this.a.b();
    this.d.setVisibility(0);
    this.f.setVisibility(8);
    this.g.setVisibility(8);
    this.e.setEnabled(false);
  }
  
  public void c()
  {
    this.a.c();
    this.d.setVisibility(8);
    this.f.setVisibility(0);
    this.g.setVisibility(8);
    this.e.setEnabled(false);
  }
  
  public void d()
  {
    this.a.c();
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    this.e.setEnabled(false);
  }
  
  public void e()
  {
    this.a.c();
    LocationRoom.Venue localVenue = this.j.c();
    if (localVenue == null) {
      return;
    }
    this.h.a(localVenue.e, true);
    int i1 = this.j.b();
    if (i1 >= 0) {
      this.g.setSelection(i1);
    }
    if ((this.b) && (this.c.h())) {
      this.c.f();
    }
    this.d.setVisibility(8);
    this.f.setVisibility(8);
    this.g.setVisibility(0);
    this.e.setEnabled(true);
  }
  
  LocationRoom.Venue f()
  {
    return this.j.c();
  }
  
  void g()
  {
    this.a.f();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickController
 * JD-Core Version:    0.7.0.1
 */