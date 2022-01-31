package com.tencent.mobileqq.mini.out.activity;

import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import bdgk;
import bdjz;
import betx;
import bhtv;
import com.tencent.common.app.AppInterface;
import com.tencent.map.lib.basemap.data.GeoPoint;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.mini.out.CommonObserver;
import com.tencent.mobileqq.mini.out.CommonServlet;
import com.tencent.mobileqq.mini.out.MapHelper;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.proto.lbsshare.LBSShare.LocationReq;
import com.tencent.proto.lbsshare.LBSShare.POI;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.widget.XListView;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.util.List;
import mqq.app.NewIntent;

public class MapActivity
  extends BaseActivity
  implements View.OnClickListener, betx
{
  public static final String KEY_TYPE = "key_type";
  public static final String TAG = "MapActivity";
  public static final int TYPE_CHOOSE_POI = 2;
  public static final int TYPE_SHOW_ADDR = 1;
  private final int PAGE_SIZE = 10;
  AppInterface app;
  CommonObserver commonObserver = new MapActivity.3(this);
  bdjz dialog;
  LatLng fromLatLng;
  boolean isSearching;
  private int lastLatitude;
  private int lastLongitude;
  TextView leftBtnView;
  protected bhtv mOnSearchScrollListener = new MapActivity.5(this);
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
      QLog.e("txmapengine", 2, "load txmapengine.so error!" + localThrowable.toString());
    }
  }
  
  private void getPoiList(int paramInt1, int paramInt2)
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("MapActivity", 4, "getPoiList lat=" + paramInt1 + ",lon=" + paramInt2 + ",page=" + this.poiAdapter.nextBegin + ",isSearching=" + this.isSearching + ",hasMore=" + this.poiAdapter.hasMore);
    }
    if ((this.isSearching) || (!this.poiAdapter.hasMore)) {
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
    String str = bdgk.a();
    Object localObject = str;
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
  
  private void location(boolean paramBoolean)
  {
    SosoInterface.a(new MapActivity.2(this, 0, true, true, 5000L, true, false, "Qwallet", paramBoolean));
  }
  
  private void refreshPoiList(List<LBSShare.POI> paramList, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("refreshPoiList poiList size=");
      if (paramList == null) {
        break label72;
      }
    }
    label72:
    for (int i = paramList.size();; i = 0)
    {
      QLog.d("MapActivity", 2, i + ",next=" + paramInt);
      runOnUiThread(new MapActivity.4(this, paramList, paramInt));
      return;
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    Object localObject1 = null;
    super.doOnCreate(paramBundle);
    paramBundle = LayoutInflater.from(this).inflate(2131561799, null);
    if (ImmersiveUtils.isSupporImmersive() == 1)
    {
      paramBundle.setFitsSystemWindows(true);
      paramBundle.setPadding(0, ImmersiveUtils.getStatusBarHeight(this), 0, 0);
    }
    super.setContentView(paramBundle);
    this.app = getAppInterface();
    this.dialog = new bdjz(this, 2131755801);
    this.dialog.setContentView(2131558942);
    this.dialog.setCanceledOnTouchOutside(false);
    this.mapHelper = new MapHelper(this);
    Intent localIntent = getIntent();
    this.type = localIntent.getIntExtra("key_type", 0);
    this.titleView = ((TextView)findViewById(2131368670));
    this.leftBtnView = ((TextView)findViewById(2131368624));
    this.rightBtnView = ((TextView)findViewById(2131368656));
    this.mapView = ((QQMapView)findViewById(2131370049));
    this.mapView.setContentDescription(getString(2131695393));
    this.mapView.getMap().getUiSettings().setLogoPosition(0);
    this.mapView.getMap().getUiSettings().setScaleViewEnabled(false);
    this.mapView.setObserver(this);
    this.map = this.mapView.getMap();
    this.poiLocationView = ((ImageView)findViewById(2131372153));
    this.pinView = ((ImageView)findViewById(2131372050));
    this.poiLayout = ((RelativeLayout)findViewById(2131372147));
    this.routeLayout = findViewById(2131376078);
    this.routeBtn = ((Button)findViewById(2131376074));
    this.routeBtn.setOnClickListener(this);
    this.leftBtnView.setOnClickListener(this);
    this.rightBtnView.setOnClickListener(this);
    this.poiLocationView.setVisibility(0);
    this.poiLocationView.setOnClickListener(this);
    try
    {
      paramBundle = BitmapFactory.decodeResource(getResources(), 2130847202);
    }
    catch (OutOfMemoryError paramBundle)
    {
      for (;;)
      {
        Object localObject2;
        label369:
        int i;
        paramBundle = null;
      }
    }
    try
    {
      localObject2 = BitmapFactory.decodeResource(getResources(), 2130842036);
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      break label369;
    }
    i = localIntent.getIntExtra("scale", 18);
    this.map.moveCamera(CameraUpdateFactory.zoomTo(i));
    if (this.type == 1)
    {
      this.leftBtnView.setText(alud.a(2131706845));
      this.routeLayout.setVisibility(0);
      this.targetLatLng = new LatLng(localIntent.getDoubleExtra("latitude", 0.0D), localIntent.getDoubleExtra("longitude", 0.0D));
      this.map.moveCamera(CameraUpdateFactory.newLatLng(this.targetLatLng));
      localObject1 = new MarkerOptions(this.targetLatLng);
      ((MarkerOptions)localObject1).position(this.targetLatLng);
      ((MarkerOptions)localObject1).icon(BitmapDescriptorFactory.fromBitmap(paramBundle));
      this.map.addMarker((MarkerOptions)localObject1);
      this.targetName = localIntent.getStringExtra("name");
      paramBundle = localIntent.getStringExtra("address");
      localObject1 = (TextView)this.routeLayout.findViewById(2131362136);
      localObject2 = (TextView)this.routeLayout.findViewById(2131365139);
      ((TextView)localObject1).setText(this.targetName);
      ((TextView)localObject2).setText(paramBundle);
      location(false);
    }
    while (this.type != 2) {
      return true;
    }
    this.noResultView = ((TextView)findViewById(2131371205));
    this.poiAdapter = new POIAdapter(this);
    this.poiListView = ((XListView)findViewById(2131376220));
    this.poiListView.setAdapter(this.poiAdapter);
    this.poiListView.setOnScrollListener(this.mOnSearchScrollListener);
    this.poiListView.setOnItemClickListener(new MapActivity.1(this));
    this.leftBtnView.setText(alud.a(2131706842));
    this.rightBtnView.setVisibility(0);
    this.rightBtnView.setText(alud.a(2131706838));
    this.poiLayout.setVisibility(0);
    this.pinView.setVisibility(0);
    if (localObject1 != null)
    {
      this.pinView.setImageBitmap((Bitmap)localObject1);
      this.pinView.setPadding(0, 0, 0, ((Bitmap)localObject1).getHeight());
    }
    location(true);
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.commonObserver = null;
    if (this.dialog != null)
    {
      this.dialog.setOnDismissListener(null);
      if (this.dialog.isShowing()) {
        this.dialog.dismiss();
      }
    }
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.mapView != null) {
      this.mapView.onResume();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131368624) {
      finish();
    }
    do
    {
      return;
      if (paramView.getId() == 2131372153)
      {
        location(true);
        return;
      }
      if (paramView.getId() == 2131376074)
      {
        this.mapHelper.showActionSheet(this.fromLatLng, this.targetLatLng, null, this.targetName);
        return;
      }
    } while (paramView.getId() != 2131368656);
    paramView = this.poiAdapter.getItem(this.poiAdapter.selectPos);
    if (paramView == null)
    {
      QQToast.a(this, 0, alud.a(2131706844), 1).b(getResources().getDimensionPixelSize(2131298914));
      return;
    }
    Intent localIntent = new Intent();
    localIntent.putExtra("name", paramView.name.get());
    localIntent.putExtra("address", paramView.addr.get());
    localIntent.putExtra("latitude", paramView.lat.get());
    localIntent.putExtra("longitude", paramView.lng.get());
    setResult(-1, localIntent);
    finish();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.mini.out.activity.MapActivity
 * JD-Core Version:    0.7.0.1
 */