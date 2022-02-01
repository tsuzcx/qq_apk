package com.tencent.mobileqq.mini.out.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.mini.out.CommonServlet;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.soso.location.api.ISosoInterfaceApi;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQMapView.QQMapViewObserver;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.NewIntent;

public class MapActivity
  extends BaseActivity
  implements View.OnClickListener, QQMapView.QQMapViewObserver
{
  public static final String KEY_TYPE = "key_type";
  public static final String TAG = "MapActivity";
  public static final int TYPE_CHOOSE_POI = 2;
  public static final int TYPE_SHOW_ADDR = 1;
  private final int PAGE_SIZE = 10;
  AppInterface app;
  CommonObserver commonObserver = new MapActivity.3(this);
  QQCustomDialog dialog;
  LatLng fromLatLng;
  boolean isSearching;
  private int lastLatitude;
  private int lastLongitude;
  TextView leftBtnView;
  protected AbsListView.OnScrollListener mOnSearchScrollListener = new MapActivity.5(this);
  TencentMap map;
  MapHelper mapHelper;
  QQMapView mapView;
  TextView noResultView;
  ImageView pinView;
  POIAdapter poiAdapter;
  RelativeLayout poiLayout;
  XListView poiListView;
  ImageView poiLocationView;
  TextView rightBtnView;
  Button routeBtn;
  View routeLayout;
  LatLng targetLatLng;
  String targetName;
  TextView titleView;
  int type;
  
  static
  {
    try
    {
      System.loadLibrary("txmapengine");
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("load txmapengine.so error!");
      localStringBuilder.append(localThrowable.toString());
      QLog.e("txmapengine", 2, localStringBuilder.toString());
    }
  }
  
  private void getPoiList(int paramInt1, int paramInt2)
  {
    Object localObject;
    if (QLog.isDevelopLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("getPoiList lat=");
      ((StringBuilder)localObject).append(paramInt1);
      ((StringBuilder)localObject).append(",lon=");
      ((StringBuilder)localObject).append(paramInt2);
      ((StringBuilder)localObject).append(",page=");
      ((StringBuilder)localObject).append(this.poiAdapter.nextBegin);
      ((StringBuilder)localObject).append(",isSearching=");
      ((StringBuilder)localObject).append(this.isSearching);
      ((StringBuilder)localObject).append(",hasMore=");
      ((StringBuilder)localObject).append(this.poiAdapter.hasMore);
      QLog.i("MapActivity", 4, ((StringBuilder)localObject).toString());
    }
    if (!this.isSearching)
    {
      if (!this.poiAdapter.hasMore) {
        return;
      }
      this.isSearching = true;
      ToServiceMsg localToServiceMsg = new ToServiceMsg("mobileqq.service", getCurrentAccountUin(), "LbsShareSvr.location");
      LBSShare.LocationReq localLocationReq = new LBSShare.LocationReq();
      localLocationReq.lat.set(paramInt1);
      localLocationReq.lng.set(paramInt2);
      localLocationReq.coordinate.set(0);
      localLocationReq.keyword.set("");
      localLocationReq.page.set(this.poiAdapter.nextBegin);
      localLocationReq.count.set(10);
      localLocationReq.requireMyLbs.set(0);
      String str = DeviceInfoUtil.a();
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localLocationReq.imei.set((String)localObject);
      localToServiceMsg.putWupBuffer(localLocationReq.toByteArray());
      localToServiceMsg.addAttribute("is_pb_packet", Boolean.valueOf(true));
      localObject = new NewIntent(this.app.getApplication(), CommonServlet.class);
      ((NewIntent)localObject).putExtra(ToServiceMsg.class.getSimpleName(), localToServiceMsg);
      ((NewIntent)localObject).setObserver(this.commonObserver);
      this.app.startServlet((NewIntent)localObject);
    }
  }
  
  private void location(boolean paramBoolean)
  {
    ((ISosoInterfaceApi)QRoute.api(ISosoInterfaceApi.class)).startLocation(new MapActivity.2(this, 0, true, true, 5000L, true, false, "Qwallet", paramBoolean));
  }
  
  private void refreshPoiList(List<LBSShare.POI> paramList, int paramInt)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("refreshPoiList poiList size=");
      int i;
      if (paramList != null) {
        i = paramList.size();
      } else {
        i = 0;
      }
      localStringBuilder.append(i);
      localStringBuilder.append(",next=");
      localStringBuilder.append(paramInt);
      QLog.d("MapActivity", 2, localStringBuilder.toString());
    }
    runOnUiThread(new MapActivity.4(this, paramList, paramInt));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = LayoutInflater.from(this);
    Object localObject1 = null;
    paramBundle = paramBundle.inflate(2131561996, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.setContentView(paramBundle);
    this.app = getAppInterface();
    this.dialog = new QQCustomDialog(this, 2131756189);
    this.dialog.setContentView(2131558978);
    this.dialog.setCanceledOnTouchOutside(false);
    this.mapHelper = new MapHelper(this);
    Intent localIntent = getIntent();
    this.type = localIntent.getIntExtra("key_type", 0);
    this.titleView = ((TextView)findViewById(2131369249));
    this.leftBtnView = ((TextView)findViewById(2131369202));
    this.rightBtnView = ((TextView)findViewById(2131369234));
    this.mapView = ((QQMapView)findViewById(2131370660));
    this.mapView.setContentDescription(getString(2131694946));
    this.mapView.getMap().getUiSettings().setLogoPosition(0);
    this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
    this.mapView.setObserver(this);
    this.map = this.mapView.getMap();
    this.poiLocationView = ((ImageView)findViewById(2131372909));
    this.pinView = ((ImageView)findViewById(2131372798));
    this.poiLayout = ((RelativeLayout)findViewById(2131372904));
    this.routeLayout = findViewById(2131376852);
    this.routeBtn = ((Button)findViewById(2131376848));
    this.routeBtn.setOnClickListener(this);
    this.leftBtnView.setOnClickListener(this);
    this.rightBtnView.setOnClickListener(this);
    this.poiLocationView.setVisibility(0);
    this.poiLocationView.setOnClickListener(this);
    try
    {
      paramBundle = BitmapFactory.decodeResource(getResources(), 2130847909);
    }
    catch (OutOfMemoryError paramBundle)
    {
      Object localObject2;
      label374:
      int i;
      break label374;
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(getResources(), 2130842473);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label376;
    }
    paramBundle = null;
    label376:
    i = localIntent.getIntExtra("scale", 18);
    this.map.moveCamera(CameraUpdateFactory.zoomTo(i));
    i = this.type;
    if (i == 1)
    {
      this.leftBtnView.setText(HardCodeUtil.a(2131706511));
      this.routeLayout.setVisibility(0);
      this.targetLatLng = new LatLng(localIntent.getDoubleExtra("latitude", 0.0D), localIntent.getDoubleExtra("longitude", 0.0D));
      this.map.moveCamera(CameraUpdateFactory.newLatLng(this.targetLatLng));
      localObject1 = new MarkerOptions(this.targetLatLng);
      ((MarkerOptions)localObject1).position(this.targetLatLng);
      ((MarkerOptions)localObject1).icon(BitmapDescriptorFactory.fromBitmap(paramBundle));
      this.map.addMarker((MarkerOptions)localObject1);
      this.targetName = localIntent.getStringExtra("name");
      paramBundle = localIntent.getStringExtra("address");
      localObject1 = (TextView)this.routeLayout.findViewById(2131362253);
      localObject2 = (TextView)this.routeLayout.findViewById(2131365545);
      ((TextView)localObject1).setText(this.targetName);
      ((TextView)localObject2).setText(paramBundle);
      location(false);
      return true;
    }
    if (i == 2)
    {
      this.noResultView = ((TextView)findViewById(2131371921));
      this.poiAdapter = new POIAdapter(this);
      this.poiListView = ((XListView)findViewById(2131377016));
      this.poiListView.setAdapter(this.poiAdapter);
      this.poiListView.setOnScrollListener(this.mOnSearchScrollListener);
      this.poiListView.setOnItemClickListener(new MapActivity.1(this));
      this.leftBtnView.setText(HardCodeUtil.a(2131706508));
      this.rightBtnView.setVisibility(0);
      this.rightBtnView.setText(HardCodeUtil.a(2131706504));
      this.poiLayout.setVisibility(0);
      this.pinView.setVisibility(0);
      if (localObject1 != null)
      {
        this.pinView.setImageBitmap((Bitmap)localObject1);
        this.pinView.setPadding(0, 0, 0, ((Bitmap)localObject1).getHeight());
      }
      location(true);
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    super.doOnDestroy();
    this.commonObserver = null;
    QQCustomDialog localQQCustomDialog = this.dialog;
    if (localQQCustomDialog != null)
    {
      localQQCustomDialog.setOnDismissListener(null);
      if (this.dialog.isShowing()) {
        this.dialog.dismiss();
      }
    }
  }
  
  protected void doOnResume()
  {
    super.doOnResume();
    QQMapView localQQMapView = this.mapView;
    if (localQQMapView != null) {
      localQQMapView.onResume();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131369202)
    {
      finish();
    }
    else if (paramView.getId() == 2131372909)
    {
      location(true);
    }
    else if (paramView.getId() == 2131376848)
    {
      this.mapHelper.showActionSheet(this.fromLatLng, this.targetLatLng, null, this.targetName);
    }
    else if (paramView.getId() == 2131369234)
    {
      Object localObject = this.poiAdapter;
      localObject = ((POIAdapter)localObject).getItem(((POIAdapter)localObject).selectPos);
      if (localObject == null)
      {
        QQToast.a(this, 0, HardCodeUtil.a(2131706510), 1).b(getResources().getDimensionPixelSize(2131299168));
      }
      else
      {
        Intent localIntent = new Intent();
        localIntent.putExtra("name", ((LBSShare.POI)localObject).name.get());
        localIntent.putExtra("address", ((LBSShare.POI)localObject).addr.get());
        localIntent.putExtra("latitude", ((LBSShare.POI)localObject).lat.get());
        localIntent.putExtra("longitude", ((LBSShare.POI)localObject).lng.get());
        setResult(-1, localIntent);
        finish();
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onMapScrollEnd(GeoPoint paramGeoPoint)
  {
    if (this.type == 2)
    {
      this.poiAdapter.reset();
      this.lastLatitude = paramGeoPoint.getLatitudeE6();
      this.lastLongitude = paramGeoPoint.getLongitudeE6();
      getPoiList(this.lastLatitude, this.lastLongitude);
    }
  }
  
  public void onMapScrollStart(GeoPoint paramGeoPoint) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity
 * JD-Core Version:    0.7.0.1
 */