package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.Bitmap.Config;
import android.graphics.Point;
import android.graphics.Rect;
import android.location.Location;
import android.os.Handler;
import com.tencent.map.lib.MapLanguage;
import com.tencent.map.sdk.a.fy;
import com.tencent.map.sdk.a.fy.a;
import com.tencent.map.sdk.a.fy.a.a;
import com.tencent.map.sdk.a.fz;
import com.tencent.map.sdk.a.gj;
import com.tencent.map.sdk.a.hv;
import com.tencent.map.sdk.a.hy;
import com.tencent.map.sdk.a.ir;
import com.tencent.map.sdk.a.jj;
import com.tencent.map.sdk.a.jv;
import com.tencent.map.sdk.a.jx;
import com.tencent.map.sdk.a.kc;
import com.tencent.map.sdk.a.kc.a;
import com.tencent.map.sdk.a.kg;
import com.tencent.map.sdk.a.kh;
import com.tencent.map.sdk.a.ki;
import com.tencent.map.sdk.a.kk;
import com.tencent.map.sdk.a.kl;
import com.tencent.map.sdk.a.km;
import com.tencent.map.sdk.a.kn;
import com.tencent.map.sdk.a.ko;
import com.tencent.map.sdk.a.kp;
import com.tencent.map.sdk.a.kq;
import com.tencent.map.sdk.a.kr;
import com.tencent.map.sdk.a.ks;
import com.tencent.map.sdk.a.ku;
import com.tencent.map.sdk.a.kv;
import com.tencent.map.sdk.a.kw;
import com.tencent.map.sdk.a.kx;
import com.tencent.map.sdk.a.la;
import com.tencent.map.sdk.a.lb;
import com.tencent.map.sdk.a.li;
import com.tencent.map.sdk.a.lk;
import com.tencent.map.sdk.a.ll;
import com.tencent.map.sdk.a.ln;
import com.tencent.map.sdk.a.lp;
import com.tencent.map.sdk.a.lq;
import com.tencent.map.sdk.a.lr;
import com.tencent.map.sdk.a.ls;
import com.tencent.map.sdk.a.lt;
import com.tencent.map.sdk.a.lu;
import com.tencent.map.sdk.a.lw;
import com.tencent.map.sdk.a.mq;
import com.tencent.map.sdk.a.ms;
import com.tencent.map.sdk.a.mv;
import com.tencent.map.sdk.a.mw;
import com.tencent.map.sdk.a.om;
import com.tencent.map.sdk.a.pm;
import com.tencent.map.sdk.a.pn;
import com.tencent.map.sdk.a.pt;
import com.tencent.map.sdk.a.pt.1;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;
import com.tencent.tencentmap.io.QStorageManager;
import com.tencent.tencentmap.mapsdk.maps.internal.TencentMapPro;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.IOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.IndoorBuilding;
import com.tencent.tencentmap.mapsdk.maps.model.Language;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.MyLocationStyle;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.RestrictBoundsFitMode;
import com.tencent.tencentmap.mapsdk.maps.model.TencentMapGestureListener;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlay;
import com.tencent.tencentmap.mapsdk.maps.model.TileOverlayOptions;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class TencentMap
  extends BaseMap
{
  private static int A = 1;
  public static final int MAP_CONFIG_LIGHT = 2;
  public static final int MAP_CONFIG_NORMAL = 1;
  public static final int MAP_MODE_NAV = 12;
  public static final int MAP_MODE_NAV_NIGHT;
  public static final int MAP_MODE_NAV_TRAFFIC;
  public static final int MAP_MODE_NORMAL = 0;
  public static final int MAP_MODE_NORMAL_TRAFFIC = 5;
  public static final int MAP_TYPE_NAVI;
  public static final int MAP_TYPE_NIGHT;
  public static final int MAP_TYPE_NONE = -1;
  public static final int MAP_TYPE_NORMAL = jj.a + 0;
  public static final int MAP_TYPE_SATELLITE;
  public static final int MAP_TYPE_TRAFFIC_NAVI = jj.a + 9;
  public static final int MAP_TYPE_TRAFFIC_NIGHT = jj.a + 10;
  public static final int MASK_LAYER_NONE = -1;
  public static final int MASK_LAYER_UNDER_LINE = 1;
  public static final int MASK_LAYER_UNDER_MARKER = 0;
  private TencentMapOptions B;
  private Context C;
  private ln a;
  private hv b = null;
  private lk c = null;
  private lt d = null;
  private ls e = null;
  private lq f = null;
  private lp g = null;
  private ll h = null;
  private li i;
  private lr j;
  private ks k = null;
  private Projection l = null;
  private ki m;
  private kh n = null;
  private kq o = null;
  private kp p = null;
  private km q = null;
  private kn r = null;
  private kk s = null;
  private kr t = null;
  private kg u;
  private ko v;
  private boolean w = false;
  private TencentMapPro x = null;
  private UiSettings y;
  private BaseMapView z = null;
  
  static
  {
    MAP_TYPE_SATELLITE = jj.a + 11;
    MAP_TYPE_NIGHT = jj.a + 13;
    MAP_TYPE_NAVI = jj.a + 12;
    MAP_MODE_NAV_TRAFFIC = MAP_TYPE_TRAFFIC_NAVI;
    MAP_MODE_NAV_NIGHT = MAP_TYPE_NIGHT;
  }
  
  protected TencentMap()
  {
    this.a = new ln(0, null, null);
    this.m = new ki(this.a);
    this.x = new TencentMapPro(this.a, getViewControl(), this.m);
  }
  
  public TencentMap(BaseMapView paramBaseMapView, Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    this.C = paramContext;
    this.B = paramTencentMapOptions;
    fz.b(paramContext);
    fz.a(paramContext);
    this.z = paramBaseMapView;
    Object localObject = jv.a();
    if ((paramContext != null) && (!((jv)localObject).d))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramContext.getFilesDir());
      localStringBuilder.append("/frontiers.dat");
      ((jv)localObject).b = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((jv)localObject).b);
      localStringBuilder.append(".bak");
      ((jv)localObject).c = localStringBuilder.toString();
      ((jv)localObject).d = true;
    }
    if (((jv)localObject).e.getAndIncrement() <= 0)
    {
      localObject = ((jv)localObject).b();
      if (localObject == null)
      {
        localObject = jv.c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.959229,21.677848:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        jv.a.put("china", localObject);
        localObject = jv.c("124.240000,39.863000:127.060000,41.420000:128.320000,41.340000:128.338164,41.966811:129.070015,42.006633:129.392187,42.394602:129.544000,42.337000:129.757733,42.443019:129.915455,42.958121:130.581000,42.411000:130.664000,42.409000:130.660000,42.750000:131.056800,42.832500:131.362267,43.147780:131.359097,44.050378:131.184574,44.758711:131.911825,45.219501:133.163642,44.937724:135.144366,48.211013:135.128000,48.597000:131.071828,47.811040:130.773650,49.035551:128.751969,49.726565:125.969075,53.154351:123.347269,53.704738:120.827269,53.390754:119.713597,52.637780:120.321762,52.210396:118.926328,50.226355:117.662701,49.700280:116.622716,49.956516:115.284508,48.000368:116.104389,47.451176:118.485448,47.755809:119.550866,46.911548:117.463642,46.804509:113.640000,45.105329:111.969090,45.243847:111.267254,44.465714:111.589045,43.737317:109.905388,42.763982:107.448179,42.614694:105.337313,41.946215:100.992746,42.800196:96.838239,42.914056:95.070866,44.957807:91.816477,45.242319:91.161836,46.742245:90.130007,47.948495:88.699097,48.336174:87.883642,49.202090:86.809933,49.172099:85.459963,48.255788:85.328157,47.119427:82.919985,47.328453:82.134523,45.619623:82.396343,45.291415:81.735685,45.446091:79.797183,45.018009:80.618157,43.259401:80.112694,42.868284:80.120896,42.260590:77.976351,41.282314:76.788172,41.096389:76.197254,40.491205:75.361880,40.846808:73.365418,39.794560:73.634523,38.503352:74.669067,38.423003:74.896815,37.310540:74.429528,37.294106:74.454501,36.972073:75.734530,36.578999:75.962701,35.784605:77.852731,35.299899:78.205470,34.574291:78.973568,32.910437:78.263619,32.582183:78.649985,30.992536:81.199112,29.930890:81.625396,30.231654:85.988179,27.769037:88.674612,27.787987:88.840910,27.047339:89.241858,27.247275:89.644552,28.077447:90.426358,28.002589:91.425425,27.605415:92.127284,26.721880:93.834582,26.907073:95.855604,28.198876:97.000074,27.593593:97.491836,27.849236:97.700896,28.296779:98.301769,27.394792:98.605433,27.417494:98.502702,26.026786:97.440895,25.088802:97.485448,23.745403:98.497224,24.030523:98.809985,23.174956:99.324515,22.945024:99.099993,22.084196:100.205485,21.391178:101.003735,21.463004:101.278198,21.122876:101.931836,21.129823:101.785481,22.197373:102.650063,22.558783:103.074619,22.382137:103.979093,22.474798:104.809933,22.767793:105.399978,23.049961:106.469971,22.704082:106.610899,21.787060:107.897261,21.372454:107.490036,19.305984:109.748489,14.674666:110.039063,11.480025:107.666016,6.271618:111.752930,3.281824:112.939454,3.413421:115.018257,6.054474:118.674316,10.790140:119.164223,12.212996:119.707031,18.020528:121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:127.303391,24.447079:127.390663,31.568056:124.335754,32.823666");
        jv.a.put("inland", localObject);
        localObject = jv.c("121.397269,20.720622:118.487770,21.778166:119.578789,24.089008:120.465831,25.121382:121.207406,25.815692:121.869972,25.849447:122.742859,25.209509:122.699226,23.809795:121.959229,21.677848");
        jv.a.put("taiwan", localObject);
      }
      else
      {
        jv.b((String)localObject);
      }
    }
    jx.a(paramContext);
    this.a = new ln(paramBaseMapView.getMapViewType(), paramBaseMapView, paramTencentMapOptions);
    this.k = new ks(this.a);
    this.m = new ki(this.a);
    this.x = new TencentMapPro(this.a, getViewControl(), this.m);
    this.f = new lq(this.z, this.k.a());
    this.q = new km(this.f);
    this.d = new lt(this.k.a());
    this.o = new kq(this.d);
    this.e = new ls(this.k.a());
    this.p = new kp(this.e);
    this.c = new lk(this.k.a());
    this.n = new kh(this.c);
    this.t = new kr(this.a.d);
    paramBaseMapView = new TencentMap.1(this);
    paramContext = this.a.d;
    if (paramContext.c != null) {
      paramContext.c.e = paramBaseMapView;
    }
    this.a.a(this.q, paramTencentMapOptions);
    this.b = new hv(this.a);
    this.b.a(this.q, paramTencentMapOptions);
    this.b.a();
  }
  
  private static int a(int paramInt)
  {
    int i1 = paramInt;
    if (paramInt < 3) {
      i1 = 3;
    }
    paramInt = i1;
    if (i1 > 22) {
      paramInt = 22;
    }
    return paramInt;
  }
  
  private void g()
  {
    if (this.h == null) {
      this.h = new ll(this.q, this.n, this.m);
    }
    if (this.s == null) {
      this.s = new kk(this.h);
    }
  }
  
  public static int getMapConfigStyle()
  {
    return A;
  }
  
  @Deprecated
  public static void setMapConfig(Context paramContext, int paramInt)
  {
    A = paramInt;
    hy.a(paramContext, paramInt);
  }
  
  final void a()
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      onMapStart();
    }
  }
  
  public final Circle addCircle(CircleOptions paramCircleOptions)
  {
    if (!this.w)
    {
      kh localkh = this.n;
      if ((localkh != null) && (paramCircleOptions != null)) {
        return localkh.a(paramCircleOptions);
      }
    }
    return null;
  }
  
  public final Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    if (!this.w)
    {
      km localkm = this.q;
      if ((localkm != null) && (paramMarkerOptions != null)) {
        return localkm.a(paramMarkerOptions, localkm);
      }
    }
    return null;
  }
  
  public final Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    if (!this.w)
    {
      kp localkp = this.p;
      if (localkp != null)
      {
        if (paramPolygonOptions == null) {
          return null;
        }
        if (localkp.a == null) {
          return null;
        }
        return localkp.a.a(paramPolygonOptions, localkp);
      }
    }
    return null;
  }
  
  public final Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    if (!this.w)
    {
      kq localkq = this.o;
      if (localkq != null)
      {
        if (paramPolylineOptions == null) {
          return null;
        }
        if (localkq.a == null) {
          return null;
        }
        return localkq.a.a(paramPolylineOptions, localkq);
      }
    }
    return null;
  }
  
  public final void addTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramTencentMapGestureListener);
      }
    }
  }
  
  public final TileOverlay addTileOverlay(TileOverlayOptions paramTileOverlayOptions)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return null;
      }
      if (localki.a == null) {
        return null;
      }
      return localki.a.a(paramTileOverlayOptions);
    }
    return null;
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.b()) {
          return;
        }
        this.m.a(paramCameraUpdate, 500L, null);
      }
    }
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, long paramLong, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.b()) {
          return;
        }
        this.m.a(paramCameraUpdate, paramLong, paramCancelableCallback);
      }
    }
  }
  
  public final void animateCamera(CameraUpdate paramCameraUpdate, TencentMap.CancelableCallback paramCancelableCallback)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.b()) {
          return;
        }
        this.m.a(paramCameraUpdate, 500L, paramCancelableCallback);
      }
    }
  }
  
  final void b()
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      onMapStop();
    }
  }
  
  final void c()
  {
    if (this.w) {
      return;
    }
    ??? = this.m;
    if ((??? != null) && (((ki)???).a != null)) {
      ((ki)???).a.i();
    }
    ??? = this.b;
    if (??? != null) {
      ((hv)???).b();
    }
    ??? = this.t;
    if (??? != null)
    {
      if (((kr)???).a != null) {
        ((kr)???).a = null;
      }
      this.t = null;
    }
    ??? = this.s;
    if (??? != null)
    {
      if (((kk)???).a != null) {
        ((kk)???).a = null;
      }
      this.s = null;
    }
    ??? = this.q;
    if (??? != null)
    {
      if (((km)???).a != null) {
        ((km)???).a = null;
      }
      this.q = null;
    }
    ??? = this.p;
    if (??? != null)
    {
      if (((kp)???).a != null) {
        ((kp)???).a = null;
      }
      this.p = null;
    }
    ??? = this.o;
    if (??? != null)
    {
      if (((kq)???).a != null) {
        ((kq)???).a = null;
      }
      this.o = null;
    }
    ??? = this.n;
    if (??? != null)
    {
      if (((kh)???).a != null) {
        ((kh)???).a = null;
      }
      this.n = null;
    }
    ??? = this.u;
    if (??? != null)
    {
      if (((kg)???).a != null) {
        ((kg)???).a = null;
      }
      this.u = null;
    }
    ??? = this.r;
    if (??? != null)
    {
      if (((kn)???).a != null) {
        ((kn)???).a = null;
      }
      this.r = null;
    }
    ??? = this.v;
    if (??? != null)
    {
      ((ko)???).a = null;
      this.v = null;
    }
    ??? = this.m;
    if (??? != null)
    {
      if (((ki)???).a != null) {
        ((ki)???).a = null;
      }
      this.m = null;
    }
    ??? = this.l;
    if (??? != null)
    {
      if (((Projection)???).a != null) {
        ((Projection)???).a = null;
      }
      this.l = null;
    }
    ??? = this.k;
    if (??? != null)
    {
      if (((ks)???).a != null) {
        ((ks)???).a = null;
      }
      this.k = null;
    }
    ??? = this.h;
    if (??? != null)
    {
      ((ll)???).b();
      ((ll)???).a = null;
      ((ll)???).b = null;
      ((ll)???).c = null;
      this.h = null;
    }
    ??? = this.f;
    if (??? != null)
    {
      if (((lq)???).a != null)
      {
        ((lq)???).a.b(ms.class);
        ((lq)???).a = null;
        if (((lq)???).d != null) {
          ((lq)???).d = null;
        }
        if (((lq)???).e != null) {
          ((lq)???).e = null;
        }
        if (((lq)???).b != null) {
          ((lq)???).b = null;
        }
        if (((lq)???).c != null) {
          ((lq)???).c = null;
        }
      }
      this.f = null;
    }
    ??? = this.e;
    if (??? != null)
    {
      if (((ls)???).a != null)
      {
        ((ls)???).a.b(mv.class);
        ((ls)???).a = null;
      }
      this.e = null;
    }
    ??? = this.d;
    if (??? != null)
    {
      if (((lt)???).a != null)
      {
        ((lt)???).a.b(mw.class);
        ((lt)???).a = null;
      }
      this.d = null;
    }
    ??? = this.c;
    if (??? != null)
    {
      if (((lk)???).a != null)
      {
        ((lk)???).a.b(mq.class);
        ((lk)???).a = null;
      }
      this.c = null;
    }
    ??? = this.a;
    if (??? != null)
    {
      if (((ln)???).b != null)
      {
        ((ln)???).b.az.b(((ln)???).i);
        ((ln)???).b.m();
        ((ln)???).b = null;
      }
      if (((ln)???).c != null) {
        ((ln)???).c = null;
      }
      if (fy.b != null)
      {
        fy.a.a locala = fy.b.a;
        synchronized (locala.c)
        {
          locala.a.clear();
        }
      }
      this.a = null;
    }
    ??? = this.i;
    if (??? != null)
    {
      ((li)???).a = null;
      this.i = null;
    }
    ??? = this.g;
    if (??? != null)
    {
      ((lp)???).a = null;
      this.g = null;
    }
    ??? = this.j;
    if (??? != null)
    {
      ((lr)???).a = null;
      ((lr)???).b = null;
    }
    if (this.B != null) {
      TencentMapOptions.a();
    }
    onMapDestroy();
    this.w = true;
  }
  
  public CameraPosition calculateZoomToSpanLevel(List<IOverlay> paramList, List<LatLng> paramList1, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (!this.w)
    {
      if (this.m == null) {
        return null;
      }
      paramInt1 = Math.abs(paramInt1);
      paramInt2 = Math.abs(paramInt2);
      paramInt3 = Math.abs(paramInt3);
      paramInt4 = Math.abs(paramInt4);
      ki localki = this.m;
      if (localki.a == null) {
        return null;
      }
      return localki.a.a(paramList, paramList1, paramInt1, paramInt2, paramInt3, paramInt4);
    }
    return null;
  }
  
  public final void clear()
  {
    clearAllOverlays();
  }
  
  public final void clearAllOverlays()
  {
    if (this.w) {
      return;
    }
    Object localObject = this.o;
    if ((localObject != null) && (((kq)localObject).a != null)) {
      ((kq)localObject).a.a();
    }
    localObject = this.p;
    if ((localObject != null) && (((kp)localObject).a != null)) {
      ((kp)localObject).a.a();
    }
    localObject = this.n;
    if ((localObject != null) && (((kh)localObject).a != null)) {
      ((kh)localObject).a.a();
    }
    localObject = this.q;
    if ((localObject != null) && (((km)localObject).a != null)) {
      ((km)localObject).a.b();
    }
    localObject = this.u;
    if (localObject != null) {
      ((kg)localObject).a();
    }
  }
  
  public final void clearCache()
  {
    om.e(QStorageManager.getInstance(this.C).getCacheDir());
  }
  
  final void d()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.h();
      }
      onMapResume();
    }
  }
  
  final void e()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.j();
      }
      onMapPause();
    }
  }
  
  public void enableMultipleInfowindow(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.f(paramBoolean);
      }
    }
  }
  
  final void f()
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      onMapRestart();
    }
  }
  
  @Deprecated
  public String getActivedIndoorBuilding(LatLng paramLatLng)
  {
    if (!this.w)
    {
      Object localObject = this.m;
      if (localObject == null) {
        return null;
      }
      if (((ki)localObject).a != null)
      {
        localObject = ((ki)localObject).a.p();
        if (localObject != null)
        {
          if ((((IndoorBuilding)localObject).getBuildingLatLng() != null) && (paramLatLng != null))
          {
            paramLatLng.latitude = ((IndoorBuilding)localObject).getBuildingLatLng().latitude;
            paramLatLng.longitude = ((IndoorBuilding)localObject).getBuildingLatLng().longitude;
          }
          return ((IndoorBuilding)localObject).getBuildingName();
        }
      }
    }
    return null;
  }
  
  public String[] getActivedIndoorFloorNames()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return null;
      }
      if (localki.a != null) {
        return localki.a.o();
      }
    }
    return null;
  }
  
  public List<LatLng> getBounderPoints(Marker paramMarker)
  {
    Object localObject1 = null;
    if (paramMarker != null)
    {
      Object localObject2 = this.f;
      if (localObject2 == null) {
        return null;
      }
      paramMarker = paramMarker.getId();
      if (((lq)localObject2).a == null) {
        return null;
      }
      paramMarker = ((lq)localObject2).a.c(paramMarker);
      if (paramMarker == null) {
        return null;
      }
      if (!(paramMarker instanceof ms)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      localObject1 = (ms)paramMarker;
      if ((((ms)localObject1).H != null) && (((ms)localObject1).F != null) && (((ms)localObject1).F.az != null)) {
        paramMarker = ((ms)localObject1).H.b(((ms)localObject1).F.az.b.h);
      } else {
        paramMarker = new Rect();
      }
      double d1;
      double d2;
      LatLng localLatLng1;
      if (paramMarker != null)
      {
        d1 = paramMarker.top;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        d2 = paramMarker.left;
        Double.isNaN(d2);
        localLatLng1 = new LatLng(d1, d2 / 1000000.0D);
        d1 = paramMarker.bottom;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        d2 = paramMarker.left;
        Double.isNaN(d2);
        LatLng localLatLng2 = new LatLng(d1, d2 / 1000000.0D);
        d1 = paramMarker.top;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        d2 = paramMarker.right;
        Double.isNaN(d2);
        LatLng localLatLng3 = new LatLng(d1, d2 / 1000000.0D);
        d1 = paramMarker.bottom;
        Double.isNaN(d1);
        d1 /= 1000000.0D;
        d2 = paramMarker.right;
        Double.isNaN(d2);
        paramMarker = new LatLng(d1, d2 / 1000000.0D);
        localArrayList.add(localLatLng1);
        localArrayList.add(localLatLng2);
        localArrayList.add(localLatLng3);
        localArrayList.add(paramMarker);
      }
      paramMarker = ((ms)localObject1).J;
      localObject1 = localArrayList;
      if (paramMarker != null)
      {
        localObject1 = localArrayList;
        if (paramMarker.e())
        {
          paramMarker = paramMarker.b(((lq)localObject2).a.az.b.h);
          localObject1 = localArrayList;
          if (paramMarker != null)
          {
            d1 = paramMarker.top;
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = paramMarker.left;
            Double.isNaN(d2);
            localObject1 = new LatLng(d1, d2 / 1000000.0D);
            d1 = paramMarker.bottom;
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = paramMarker.left;
            Double.isNaN(d2);
            localObject2 = new LatLng(d1, d2 / 1000000.0D);
            d1 = paramMarker.top;
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = paramMarker.right;
            Double.isNaN(d2);
            localLatLng1 = new LatLng(d1, d2 / 1000000.0D);
            d1 = paramMarker.bottom;
            Double.isNaN(d1);
            d1 /= 1000000.0D;
            d2 = paramMarker.right;
            Double.isNaN(d2);
            paramMarker = new LatLng(d1, d2 / 1000000.0D);
            localArrayList.add(localObject1);
            localArrayList.add(localObject2);
            localArrayList.add(localLatLng1);
            localArrayList.add(paramMarker);
            localObject1 = localArrayList;
          }
        }
      }
    }
    return localObject1;
  }
  
  public final CameraPosition getCameraPosition()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null) {
        return localki.a();
      }
    }
    return null;
  }
  
  public final String getCityName(LatLng paramLatLng)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.a == null) {
          return null;
        }
        return localki.a.a(paramLatLng);
      }
    }
    return "";
  }
  
  public String getDebugError()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return null;
      }
      if (localki.a == null) {
        return null;
      }
      return localki.a.t();
    }
    return null;
  }
  
  public int getIndoorFloorId()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return -1;
      }
      if (localki.a != null) {
        return localki.a.n();
      }
    }
    return -1;
  }
  
  public MapLanguage getLanguage()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.a != null) {
          return localki.a.l();
        }
        return MapLanguage.LAN_CHINESE;
      }
    }
    return MapLanguage.LAN_CHINESE;
  }
  
  public int getMapHeight()
  {
    BaseMapView localBaseMapView = this.z;
    if (localBaseMapView == null) {
      return 0;
    }
    return localBaseMapView.getHeight();
  }
  
  public ln getMapManager()
  {
    return this.a;
  }
  
  public Rect getMapPadding()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return new Rect(0, 0, 0, 0);
    }
    localObject = ((ln)localObject).b.az.b.c;
    return new Rect(((kl)localObject).n, ((kl)localObject).o, ((kl)localObject).p, ((kl)localObject).q);
  }
  
  protected TencentMapPro getMapPro()
  {
    return this.x;
  }
  
  public final int getMapStyle()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return -1;
      }
      if (localki.a == null) {
        return -1;
      }
      return localki.a.e();
    }
    return -1;
  }
  
  public final int getMapType()
  {
    return getMapStyle();
  }
  
  public int getMapWidth()
  {
    BaseMapView localBaseMapView = this.z;
    if (localBaseMapView == null) {
      return 0;
    }
    return localBaseMapView.getWidth();
  }
  
  public final float getMaxZoomLevel()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.a == null) {
          return -1.0F;
        }
        return localki.a.b();
      }
    }
    return 0.0F;
  }
  
  public final float getMinZoomLevel()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.a == null) {
          return -1.0F;
        }
        return localki.a.c();
      }
    }
    return 0.0F;
  }
  
  public final Location getMyLocation()
  {
    if (this.w) {
      return null;
    }
    g();
    kk localkk = this.s;
    if (localkk.a != null) {
      return localkk.a.d();
    }
    return null;
  }
  
  public final Projection getProjection()
  {
    if (!this.w)
    {
      ln localln = this.a;
      if (localln != null)
      {
        if (this.l == null) {
          this.l = new Projection(localln);
        }
        return this.l;
      }
    }
    return null;
  }
  
  public final UiSettings getUiSettings()
  {
    if (this.w) {
      return null;
    }
    if (this.y == null) {
      this.y = new UiSettings(this.t);
    }
    return this.y;
  }
  
  public String getVersion()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return "";
      }
      if (localki.a == null) {
        return "";
      }
      return localki.a.k();
    }
    return "";
  }
  
  protected ks getViewControl()
  {
    return this.k;
  }
  
  public final float getZoomToSpanLevel(LatLng paramLatLng1, LatLng paramLatLng2)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (paramLatLng1 != null)
        {
          if (paramLatLng2 == null) {
            return -1.0F;
          }
          if (localki.a == null) {
            return -1.0F;
          }
          return localki.a.a(paramLatLng1, paramLatLng2);
        }
        return -1.0F;
      }
    }
    return 0.0F;
  }
  
  public boolean isBlockRouteEnabled()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return false;
      }
      if (localki.a == null) {
        return false;
      }
      return localki.a.q();
    }
    return false;
  }
  
  public boolean isDestroyed()
  {
    return this.w;
  }
  
  public boolean isHandDrawMapEnable()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return false;
      }
      if (localki.a == null) {
        return false;
      }
      return localki.a.r();
    }
    return false;
  }
  
  public final boolean isMyLocationEnabled()
  {
    if (this.w) {
      return false;
    }
    g();
    kk localkk = this.s;
    if (localkk.a != null) {
      return localkk.a.c();
    }
    return false;
  }
  
  public final boolean isSateLiteEnable()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return false;
      }
      if (localki.a == null) {
        return false;
      }
      return localki.a.f();
    }
    return false;
  }
  
  public final boolean isTrafficEnabled()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return false;
      }
      if (localki.a == null) {
        return false;
      }
      return localki.a.g();
    }
    return false;
  }
  
  public final void loadKMLFile(String paramString)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramString);
      }
    }
  }
  
  public final void moveCamera(CameraUpdate paramCameraUpdate)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki != null)
      {
        if (localki.b()) {
          return;
        }
        this.m.a(paramCameraUpdate);
      }
    }
  }
  
  protected void onMapDestroy() {}
  
  protected void onMapPause() {}
  
  protected void onMapRestart() {}
  
  protected void onMapResume() {}
  
  protected void onMapStart() {}
  
  protected void onMapStop() {}
  
  public final void removeTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.b(paramTencentMapGestureListener);
      }
    }
  }
  
  public void setBlockRouteEnabled(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.d(paramBoolean);
      }
    }
  }
  
  public void setBuildingEnable(boolean paramBoolean)
  {
    if (!this.w)
    {
      ln localln = this.a;
      if (localln == null) {
        return;
      }
      localln.a(paramBoolean, false);
    }
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2)
  {
    setCameraCenterProportion(paramFloat1, paramFloat2, true);
  }
  
  public void setCameraCenterProportion(float paramFloat1, float paramFloat2, boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramFloat1, paramFloat2, paramBoolean);
      }
    }
  }
  
  public void setDrawPillarWith2DStyle(boolean paramBoolean)
  {
    if (!this.w)
    {
      ln localln = this.a;
      if (localln == null) {
        return;
      }
      localln.a(paramBoolean ^ true, true);
    }
  }
  
  public void setForeignLanguage(Language paramLanguage)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramLanguage);
      }
    }
  }
  
  public void setHandDrawMapEnable(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.e(paramBoolean);
      }
    }
  }
  
  public void setIndoorEnabled(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.c(paramBoolean);
      }
    }
  }
  
  public void setIndoorFloor(int paramInt)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.b(paramInt);
      }
    }
  }
  
  public void setIndoorFloor(String paramString1, String paramString2)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (!ki.a(paramString1))
      {
        if (ki.a(paramString2)) {
          return;
        }
        localki.a.a(paramString1, paramString2);
      }
    }
  }
  
  public final void setInfoWindowAdapter(TencentMap.InfoWindowAdapter paramInfoWindowAdapter)
  {
    if (!this.w)
    {
      km localkm = this.q;
      if (localkm == null) {
        return;
      }
      if (localkm.a != null) {
        localkm.a.a(paramInfoWindowAdapter);
      }
    }
  }
  
  public final void setLocationSource(LocationSource paramLocationSource)
  {
    if (this.w) {
      return;
    }
    g();
    kk localkk = this.s;
    if (localkk.a != null) {
      localkk.a.a(paramLocationSource);
    }
  }
  
  public void setMapCenterAndScale(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (!this.w)
    {
      Object localObject = this.a;
      if (localObject == null) {
        return;
      }
      localObject = ((ln)localObject).b;
      if ((((pt)localObject).aA != null) && (((pt)localObject).aC != null))
      {
        float f2 = ((pt)localObject).aA.c.i.b.e;
        float f1 = pt.b(paramFloat3);
        boolean bool;
        if (Math.abs(f2 - f1) > 0.0001D) {
          bool = true;
        } else {
          bool = false;
        }
        ((pt)localObject).aD = 0;
        f2 = (paramFloat2 - ((pt)localObject).aB) / 10.0F;
        ((pt)localObject).aC.post(new pt.1((pt)localObject, f2, paramFloat1, paramFloat2, paramFloat3, bool, f1));
      }
    }
  }
  
  public final void setMapStyle(int paramInt)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramInt);
      }
    }
  }
  
  public final void setMapType(int paramInt)
  {
    setMapStyle(paramInt);
  }
  
  public void setMaxZoomLevel(int paramInt)
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      paramInt = a(paramInt);
      ki localki = this.m;
      if (localki.a != null) {
        localki.a.c(paramInt);
      }
      float f1 = this.m.a().zoom;
      float f2 = paramInt;
      if (f1 > f2) {
        animateCamera(CameraUpdateFactory.zoomTo(f2));
      }
    }
  }
  
  public void setMinZoomLevel(int paramInt)
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      paramInt = a(paramInt);
      ki localki = this.m;
      if (localki.a != null) {
        localki.a.d(paramInt);
      }
      float f1 = this.m.a().zoom;
      float f2 = paramInt;
      if (f1 < f2) {
        animateCamera(CameraUpdateFactory.zoomTo(f2));
      }
    }
  }
  
  public final void setMyLocationEnabled(boolean paramBoolean)
  {
    if (this.w) {
      return;
    }
    g();
    if (!paramBoolean)
    {
      localkk = this.s;
      if (localkk.a != null) {
        localkk.a.b();
      }
      return;
    }
    if (isMyLocationEnabled()) {
      return;
    }
    kk localkk = this.s;
    if (localkk.a != null) {
      localkk.a.a();
    }
  }
  
  public void setMyLocationStyle(MyLocationStyle paramMyLocationStyle)
  {
    if (this.s == null) {
      g();
    }
    kk localkk = this.s;
    if (localkk.a != null) {
      localkk.a.a(paramMyLocationStyle);
    }
  }
  
  public final void setOnCameraChangeListener(TencentMap.OnCameraChangeListener paramOnCameraChangeListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnCameraChangeListener);
      }
    }
  }
  
  public final void setOnCompassClickedListener(TencentMap.OnCompassClickedListener paramOnCompassClickedListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnCompassClickedListener);
      }
    }
  }
  
  public final void setOnIndoorStateChangeListener(TencentMap.OnIndoorStateChangeListener paramOnIndoorStateChangeListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnIndoorStateChangeListener);
      }
    }
  }
  
  public final void setOnInfoWindowClickListener(TencentMap.OnInfoWindowClickListener paramOnInfoWindowClickListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnInfoWindowClickListener);
      }
    }
  }
  
  public final void setOnMapClickListener(TencentMap.OnMapClickListener paramOnMapClickListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnMapClickListener);
      }
    }
  }
  
  public final void setOnMapLoadedCallback(TencentMap.OnMapLoadedCallback paramOnMapLoadedCallback)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnMapLoadedCallback);
      }
    }
  }
  
  public final void setOnMapLongClickListener(TencentMap.OnMapLongClickListener paramOnMapLongClickListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnMapLongClickListener);
      }
    }
  }
  
  public final void setOnMapPoiClickListener(TencentMap.OnMapPoiClickListener paramOnMapPoiClickListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnMapPoiClickListener);
      }
    }
  }
  
  public final void setOnMarkerClickListener(TencentMap.OnMarkerClickListener paramOnMarkerClickListener)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramOnMarkerClickListener);
      }
    }
  }
  
  public final void setOnMarkerDragListener(TencentMap.OnMarkerDragListener paramOnMarkerDragListener)
  {
    if (!this.w)
    {
      km localkm = this.q;
      if (localkm == null) {
        return;
      }
      if (localkm.a != null) {
        localkm.a.a(paramOnMarkerDragListener);
      }
    }
  }
  
  public final void setOnMyLocationChangeListener(TencentMap.OnMyLocationChangeListener paramOnMyLocationChangeListener)
  {
    if (this.w) {
      return;
    }
    if (this.h == null) {
      g();
    }
    this.h.f = paramOnMyLocationChangeListener;
  }
  
  public final void setOnPolylineClickListener(TencentMap.OnPolylineClickListener paramOnPolylineClickListener)
  {
    if (!this.w)
    {
      kq localkq = this.o;
      if (localkq == null) {
        return;
      }
      if (localkq.a != null) {
        localkq.a.a(paramOnPolylineClickListener);
      }
    }
  }
  
  public final void setOnTapMapViewInfoWindowHidden(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.g(paramBoolean);
      }
    }
  }
  
  protected void setOnTop(boolean paramBoolean)
  {
    if (!this.w)
    {
      ln localln = this.a;
      if (localln == null) {
        return;
      }
      localln.a.setZOrderMediaOverlay(paramBoolean);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ln localln = this.a;
    if (localln != null) {
      localln.a(paramInt1, paramInt2, paramInt3, paramInt4, false);
    }
  }
  
  public void setPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean)
  {
    ln localln = this.a;
    if (localln != null) {
      localln.a(paramInt1, paramInt2, paramInt3, paramInt4, paramBoolean);
    }
  }
  
  public void setPointToCenter(int paramInt1, int paramInt2)
  {
    if (!this.w)
    {
      if (this.m == null) {
        return;
      }
      Projection localProjection = getProjection();
      if (localProjection != null) {
        this.m.a(CameraUpdateFactory.newLatLng(localProjection.fromScreenLocation(new Point(paramInt1, paramInt2))));
      }
    }
  }
  
  public void setPoisEnabled(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.i(paramBoolean);
      }
    }
  }
  
  public void setRestrictBounds(LatLngBounds paramLatLngBounds, RestrictBoundsFitMode paramRestrictBoundsFitMode)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      int i1;
      if (paramRestrictBoundsFitMode == null) {
        i1 = 0;
      } else {
        i1 = paramRestrictBoundsFitMode.ordinal();
      }
      if (localki.a != null) {
        localki.a.a(paramLatLngBounds, i1);
      }
    }
  }
  
  public final void setSatelliteEnabled(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.b(paramBoolean);
      }
    }
  }
  
  public final void setTencentMapGestureListener(TencentMapGestureListener paramTencentMapGestureListener)
  {
    addTencentMapGestureListener(paramTencentMapGestureListener);
  }
  
  public final void setTrafficEnabled(boolean paramBoolean)
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.a(paramBoolean);
      }
    }
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    snapshot(paramSnapshotReadyCallback, Bitmap.Config.ARGB_8888);
  }
  
  public void snapshot(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback, Bitmap.Config paramConfig)
  {
    ki localki = this.m;
    if ((localki != null) && (localki.a != null))
    {
      if (paramSnapshotReadyCallback == null) {
        return;
      }
      localki.b = paramSnapshotReadyCallback;
      paramSnapshotReadyCallback = localki.c;
      if (localki.a != null) {
        localki.a.a(paramSnapshotReadyCallback, paramConfig);
      }
    }
  }
  
  public final void stopAnimation()
  {
    if (!this.w)
    {
      ki localki = this.m;
      if (localki == null) {
        return;
      }
      if (localki.a != null) {
        localki.a.d();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TencentMap
 * JD-Core Version:    0.7.0.1
 */