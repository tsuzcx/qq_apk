package com.tencent.qqmini.map;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.core.manager.MiniAppFileManager;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import com.tencent.qqmini.sdk.core.utils.ImageUtil;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.action.ServiceSubscribeEvent;
import com.tencent.qqmini.sdk.launcher.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import com.tencent.qqmini.sdk.utils.ViewUtils;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdate;
import com.tencent.tencentmap.mapsdk.maps.CameraUpdateFactory;
import com.tencent.tencentmap.mapsdk.maps.Projection;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnCameraChangeListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMapLoadedCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.OnMarkerClickListener;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;
import com.tencent.tencentmap.mapsdk.maps.model.BitmapDescriptorFactory;
import com.tencent.tencentmap.mapsdk.maps.model.CameraPosition;
import com.tencent.tencentmap.mapsdk.maps.model.Circle;
import com.tencent.tencentmap.mapsdk.maps.model.CircleOptions;
import com.tencent.tencentmap.mapsdk.maps.model.LatLng;
import com.tencent.tencentmap.mapsdk.maps.model.LatLngBounds;
import com.tencent.tencentmap.mapsdk.maps.model.Marker;
import com.tencent.tencentmap.mapsdk.maps.model.MarkerOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polygon;
import com.tencent.tencentmap.mapsdk.maps.model.PolygonOptions;
import com.tencent.tencentmap.mapsdk.maps.model.Polyline;
import com.tencent.tencentmap.mapsdk.maps.model.PolylineOptions;
import com.tencent.tencentmap.mapsdk.maps.model.VisibleRegion;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MapContext
  implements SensorEventListener, TencentMap.InfoWindowAdapter, TencentMap.OnCameraChangeListener, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedCallback, TencentMap.OnMarkerClickListener
{
  private static float DEFAULT_ROTATE = 0.0F;
  private static float DEFAULT_SCALE;
  private static float DEFAULT_SKEW = 0.0F;
  private static String MAP_EVENT_CALLOUT_CLICK;
  private static String MAP_EVENT_CLICK;
  private static String MAP_EVENT_MARKER_CLICK;
  private static String MAP_EVENT_REGION_CHANGE;
  public static String TAG = "MapContext";
  private ArrayList<Circle> circleArrayList;
  private Context context;
  private LatLng curLatLng;
  private Polygon curPolygon;
  private float curRotate = 0.0F;
  private float curScale = DEFAULT_SCALE;
  private boolean curShowLocationMarkerStatus = false;
  private float curSkew = 0.0F;
  private float density;
  private Bitmap locationBitmap;
  private Marker locationMarker;
  private CoverMapView mCoverMapView = null;
  private int mMapId = -1;
  private UiSettings mMapUiSettings;
  private IMiniAppContext mMiniAppContext;
  private int mPageWebViewId = -1;
  private TencentMap mTencentMap;
  private int markerMaxSize;
  private int markerMinSize;
  private SparseArray<Marker> markerSparseArray;
  private LatLng myLatLng;
  private ArrayList<Polyline> polylineArrayList;
  private float rotateDegree = 0.0F;
  private Sensor sensor;
  private SensorManager sensorManager;
  private boolean showCurrentLocationStatus = false;
  
  static
  {
    MAP_EVENT_CLICK = "onMapClick";
    MAP_EVENT_MARKER_CLICK = "onMapMarkerClick";
    MAP_EVENT_CALLOUT_CLICK = "onMapCalloutClick";
    MAP_EVENT_REGION_CHANGE = "onMapRegionChange";
    DEFAULT_SCALE = 16.0F;
  }
  
  public MapContext(IMiniAppContext paramIMiniAppContext, CoverMapView paramCoverMapView, int paramInt1, int paramInt2)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    this.mCoverMapView = paramCoverMapView;
    this.mMapId = paramInt1;
    this.mPageWebViewId = paramInt2;
    this.mTencentMap = paramCoverMapView.getMap();
    this.mMapId = paramInt1;
    this.context = paramCoverMapView.getContext();
    this.mTencentMap.setInfoWindowAdapter(this);
    this.mTencentMap.setOnMarkerClickListener(this);
    this.mTencentMap.setOnInfoWindowClickListener(this);
    this.mTencentMap.setOnMapClickListener(this);
    this.mTencentMap.setOnMapLoadedCallback(this);
    this.mTencentMap.setOnCameraChangeListener(this);
    this.mMapUiSettings = paramCoverMapView.getUiSetrings();
    this.density = this.context.getResources().getDisplayMetrics().density;
    this.sensorManager = ((SensorManager)this.context.getSystemService("sensor"));
    this.sensor = this.sensorManager.getDefaultSensor(3);
    this.markerMinSize = ((int)(this.density * 30.0F + 0.5D));
    this.markerMaxSize = ((int)(this.density * 50.0F + 0.5D));
    try
    {
      this.locationBitmap = BitmapFactory.decodeResource(paramCoverMapView.getResources(), 2130841211);
      this.markerSparseArray = new SparseArray();
      this.circleArrayList = new ArrayList();
      this.polylineArrayList = new ArrayList();
      return;
    }
    catch (Throwable paramIMiniAppContext)
    {
      for (;;)
      {
        QMLog.e(TAG, "decodeResource error, ", paramIMiniAppContext);
      }
    }
  }
  
  private void addCircle(JSONObject paramJSONObject)
  {
    String str2;
    String str1;
    if (QMLog.isColorLevel())
    {
      str2 = TAG;
      StringBuilder localStringBuilder = new StringBuilder().append("addCircles params=");
      if (paramJSONObject != null)
      {
        str1 = paramJSONObject.toString();
        QMLog.d(str2, str1);
      }
    }
    else
    {
      if (paramJSONObject != null) {
        break label64;
      }
    }
    for (;;)
    {
      return;
      str1 = "empty";
      break;
      label64:
      double d1 = paramJSONObject.optDouble("latitude", 0.0D);
      double d2 = paramJSONObject.optDouble("longitude", 0.0D);
      str1 = paramJSONObject.optString("color", "");
      str2 = paramJSONObject.optString("fillColor", "");
      double d3 = paramJSONObject.optDouble("radius", 0.0D);
      float f = (float)paramJSONObject.optDouble("strokeWidth", 0.0D);
      paramJSONObject = new CircleOptions();
      paramJSONObject.center(new LatLng(d1, d2));
      paramJSONObject.radius(d3);
      if (!TextUtils.isEmpty(str2)) {}
      try
      {
        paramJSONObject.fillColor(ColorUtils.parseColor(str2));
        label176:
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          paramJSONObject.strokeColor(ColorUtils.parseColor(str1));
          label194:
          if (f > 0.0F) {
            paramJSONObject.strokeWidth(f);
          }
          if (this.mTencentMap == null) {
            continue;
          }
          paramJSONObject = this.mTencentMap.addCircle(paramJSONObject);
          this.circleArrayList.add(paramJSONObject);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          break label194;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        break label176;
      }
    }
  }
  
  private void addControl(JSONObject paramJSONObject)
  {
    String str2;
    StringBuilder localStringBuilder;
    if (QMLog.isColorLevel())
    {
      str2 = TAG;
      localStringBuilder = new StringBuilder().append("addControl params=");
      if (paramJSONObject == null) {
        break label52;
      }
    }
    label52:
    for (String str1 = paramJSONObject.toString();; str1 = "empty")
    {
      QMLog.d(str2, str1);
      if (paramJSONObject != null) {
        break;
      }
      return;
    }
    paramJSONObject.optInt("id", 0);
  }
  
  private void addCover(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    double d1 = paramJSONObject.optDouble("latitude", 0.0D);
    double d2 = paramJSONObject.optDouble("longitude", 0.0D);
    Object localObject = paramJSONObject.optString("iconPath", "");
    int i = paramJSONObject.optInt("width", -2);
    int j = paramJSONObject.optInt("height", -2);
    MarkerOptions localMarkerOptions = new MarkerOptions(new LatLng(d1, d2));
    ImageView localImageView = createMarkerView(i, j);
    if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    for (paramJSONObject = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject);; paramJSONObject = null) {
      try
      {
        paramJSONObject = Drawable.createFromPath(paramJSONObject);
        localObject = paramJSONObject;
        if (paramJSONObject == null) {
          localObject = this.context.getResources().getDrawable(2130841272);
        }
        localImageView.setImageDrawable((Drawable)localObject);
        if (this.mTencentMap == null) {
          break;
        }
        this.mTencentMap.addMarker(localMarkerOptions).setIcon(BitmapDescriptorFactory.fromView(localImageView));
        return;
      }
      catch (OutOfMemoryError paramJSONObject)
      {
        QMLog.e(TAG, "markerDrawable error,", paramJSONObject);
      }
    }
  }
  
  private void addMarker(JSONObject paramJSONObject)
  {
    if (QMLog.isColorLevel())
    {
      str = TAG;
      localObject3 = new StringBuilder().append("addMarker params=");
      if (paramJSONObject == null) {
        break label56;
      }
    }
    label56:
    for (Object localObject1 = paramJSONObject.toString();; localObject1 = "empty")
    {
      QMLog.d(str, (String)localObject1);
      if (paramJSONObject != null) {
        break;
      }
      return;
    }
    int i = paramJSONObject.optInt("id", 0);
    double d1 = paramJSONObject.optDouble("latitude", 0.0D);
    double d2 = paramJSONObject.optDouble("longitude", 0.0D);
    String str = paramJSONObject.optString("title", "");
    int j = paramJSONObject.optInt("zIndex", 0);
    localObject1 = paramJSONObject.optString("iconPath", "");
    float f1 = (float)paramJSONObject.optDouble("rotate", 0.0D);
    float f2 = (float)paramJSONObject.optDouble("alpha", 1.0D);
    int k = paramJSONObject.optInt("width", -2);
    int m = paramJSONObject.optInt("height", -2);
    Object localObject3 = paramJSONObject.optJSONObject("callout");
    if (localObject3 != null) {
      str = ((JSONObject)localObject3).optString("content");
    }
    for (;;)
    {
      localObject3 = paramJSONObject.optJSONObject("anchor");
      MarkerOptions localMarkerOptions = new MarkerOptions(new LatLng(d1, d2));
      if (localObject3 != null) {
        localMarkerOptions.anchor((float)((JSONObject)localObject3).optDouble("x", 0.5D), (float)((JSONObject)localObject3).optDouble("y", 1.0D));
      }
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {}
      Object localObject2;
      for (localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject1);; localObject2 = null) {
        try
        {
          localObject1 = Drawable.createFromPath((String)localObject1);
          localObject3 = localObject1;
          if (localObject1 == null) {
            localObject3 = this.context.getResources().getDrawable(2130841272);
          }
          localObject1 = createMarkerView(k, m);
          ((ImageView)localObject1).setLayoutParams(new ViewGroup.LayoutParams(k, m));
          ((ImageView)localObject1).setImageDrawable((Drawable)localObject3);
          localMarkerOptions.icon(BitmapDescriptorFactory.fromView((View)localObject1));
          localMarkerOptions.title(str);
          localMarkerOptions.rotation(f1);
          localMarkerOptions.alpha(f2);
          localMarkerOptions.zIndex(j);
          if (this.mTencentMap == null) {
            break;
          }
          localObject1 = this.mTencentMap.addMarker(localMarkerOptions);
          ((Marker)localObject1).setTag(paramJSONObject);
          ((Marker)localObject1).setClickable(true);
          this.markerSparseArray.put(i, localObject1);
          return;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          QMLog.e(TAG, "markerDrawable error,", localOutOfMemoryError);
        }
      }
    }
  }
  
  private void addPolyline(JSONObject paramJSONObject)
  {
    Object localObject1;
    Object localObject2;
    String str1;
    if (QMLog.isColorLevel())
    {
      localObject1 = TAG;
      localObject2 = new StringBuilder().append("addPolyline params=");
      if (paramJSONObject != null)
      {
        str1 = paramJSONObject.toString();
        QMLog.d((String)localObject1, str1);
      }
    }
    else
    {
      if (paramJSONObject != null) {
        break label64;
      }
    }
    for (;;)
    {
      return;
      str1 = "empty";
      break;
      label64:
      localObject2 = paramJSONObject.optJSONArray("points");
      String str2 = paramJSONObject.optString("color", "");
      float f1 = ViewUtils.dip2px((float)paramJSONObject.optDouble("width", 0.0D));
      boolean bool1 = paramJSONObject.optBoolean("dottedLine", false);
      boolean bool2 = paramJSONObject.optBoolean("arrowLine", false);
      localObject1 = paramJSONObject.optString("arrowIconPath", "");
      str1 = paramJSONObject.optString("borderColor", "");
      float f2 = (float)paramJSONObject.optDouble("borderWidth", 0.0D);
      paramJSONObject = new PolylineOptions();
      if (localObject2 != null)
      {
        int i = 0;
        while (i < ((JSONArray)localObject2).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject2).optJSONObject(i);
          paramJSONObject.add(new LatLng(localJSONObject.optDouble("latitude", 0.0D), localJSONObject.optDouble("longitude", 0.0D)), new LatLng[0]);
          i += 1;
        }
      }
      if (f1 > 0.0F) {
        paramJSONObject.width(f1);
      }
      if (!TextUtils.isEmpty(str2)) {}
      try
      {
        paramJSONObject.color(ColorUtils.parseColor(str2));
        label261:
        if (bool1)
        {
          localObject2 = new ArrayList();
          ((List)localObject2).add(Integer.valueOf((int)(3.0F * paramJSONObject.getWidth())));
          ((List)localObject2).add(Integer.valueOf((int)paramJSONObject.getWidth()));
          paramJSONObject.pattern((List)localObject2);
        }
        if ((bool2) && (!TextUtils.isEmpty((CharSequence)localObject1))) {
          localObject1 = ((MiniAppFileManager)this.mMiniAppContext.getManager(MiniAppFileManager.class)).getAbsolutePath((String)localObject1);
        }
        try
        {
          localObject1 = BitmapFactory.decodeFile((String)localObject1, ImageUtil.scaleBitmap((String)localObject1, this.markerMaxSize));
          if (localObject1 != null) {
            paramJSONObject.arrowTexture(BitmapDescriptorFactory.fromBitmap((Bitmap)localObject1));
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label384:
          break label384;
        }
        if (!TextUtils.isEmpty(str1)) {}
        try
        {
          paramJSONObject.borderColor(ColorUtils.parseColor(str1));
          label402:
          if (f2 > 0.0F) {
            paramJSONObject.borderWidth(f2);
          }
          if (this.mTencentMap == null) {
            continue;
          }
          paramJSONObject = this.mTencentMap.addPolyline(paramJSONObject);
          this.polylineArrayList.add(paramJSONObject);
          return;
        }
        catch (IllegalArgumentException localIllegalArgumentException1)
        {
          break label402;
        }
      }
      catch (IllegalArgumentException localIllegalArgumentException2)
      {
        break label261;
      }
    }
  }
  
  private ImageView createMarkerView(int paramInt1, int paramInt2)
  {
    ImageView localImageView = new ImageView(this.context);
    if ((paramInt1 > 0) && (paramInt2 > 0))
    {
      localImageView.setMinimumWidth((int)(this.density * paramInt1 + 0.5D));
      localImageView.setMinimumHeight((int)(this.density * paramInt2 + 0.5D));
      return localImageView;
    }
    localImageView.setMinimumWidth(this.markerMinSize);
    localImageView.setMinimumHeight(this.markerMinSize);
    return localImageView;
  }
  
  private void location()
  {
    ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getLocation(this.mMiniAppContext.getAttachedActivity(), "wgs84", true, new MapContext.1(this));
  }
  
  private void setLocationStatus(JSONObject paramJSONObject, double paramDouble1, double paramDouble2)
  {
    if ((paramJSONObject.has("skew")) || (paramJSONObject.has("rotate")) || (paramJSONObject.has("centerLongitude")) || (paramJSONObject.has("centerLatitude")) || (paramJSONObject.has("scale")))
    {
      this.showCurrentLocationStatus = false;
      updateMapCamera(paramDouble1, paramDouble2);
    }
  }
  
  private void setRotate(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("rotate"))
    {
      this.curRotate = ((float)Long.valueOf(paramJSONObject.optString("rotate")).longValue());
      if ((this.curRotate < 0.0F) || (this.curRotate > 360.0F)) {
        this.curRotate = 0.0F;
      }
      return;
    }
    this.curRotate = getRotate();
  }
  
  private void setScale(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("scale"))
    {
      this.curScale = ((float)Long.valueOf(paramJSONObject.optString("scale")).longValue());
      if ((this.curScale < 3.0F) || (this.curScale > 20.0F)) {
        this.curScale = DEFAULT_SCALE;
      }
      return;
    }
    this.curScale = getScale();
  }
  
  private void setShowCompass(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("showCompass"))
    {
      boolean bool = paramJSONObject.optBoolean("showCompass", false);
      this.mMapUiSettings.setCompassEnabled(bool);
    }
  }
  
  private void setSkew(JSONObject paramJSONObject)
  {
    if (paramJSONObject.has("skew"))
    {
      this.curSkew = ((float)Long.valueOf(paramJSONObject.optString("skew")).longValue());
      if ((this.curSkew < 0.0F) || (this.curSkew > 40.0F)) {
        this.curSkew = 0.0F;
      }
      return;
    }
    this.curSkew = getSkew();
  }
  
  private void updateMapCamera(double paramDouble1, double paramDouble2)
  {
    if ((paramDouble1 != 0.0D) || (paramDouble2 != 0.0D)) {
      this.curLatLng = new LatLng(paramDouble1, paramDouble2);
    }
    while (this.curLatLng == null)
    {
      return;
      if (this.curLatLng == null) {
        this.curLatLng = this.mTencentMap.getCameraPosition().target;
      }
    }
    CameraUpdate localCameraUpdate = CameraUpdateFactory.newCameraPosition(new CameraPosition(this.curLatLng, this.curScale, this.curSkew, this.curRotate));
    this.mTencentMap.moveCamera(localCameraUpdate);
  }
  
  private void updateMapViewPosition(JSONObject paramJSONObject)
  {
    if (paramJSONObject != null)
    {
      int i = (int)(paramJSONObject.optInt("left") * this.density);
      int j = (int)(paramJSONObject.optInt("top") * this.density);
      paramJSONObject = new FrameLayout.LayoutParams((int)(paramJSONObject.optInt("width") * this.density), (int)(paramJSONObject.optInt("height") * this.density));
      paramJSONObject.leftMargin = i;
      paramJSONObject.topMargin = j;
      this.mCoverMapView.setLayoutParams(paramJSONObject);
    }
  }
  
  private void updateOtherParams(JSONObject paramJSONObject)
  {
    boolean bool;
    if (paramJSONObject.has("showScale"))
    {
      bool = paramJSONObject.optBoolean("showScale", false);
      this.mMapUiSettings.setScaleViewEnabled(bool);
    }
    if (paramJSONObject.has("enableOverlooking"))
    {
      bool = paramJSONObject.optBoolean("enableOverlooking", false);
      this.mMapUiSettings.setTiltGesturesEnabled(bool);
    }
    if (paramJSONObject.has("enableZoom"))
    {
      bool = paramJSONObject.optBoolean("enableZoom", true);
      this.mMapUiSettings.setZoomGesturesEnabled(bool);
    }
    if (paramJSONObject.has("enableScroll"))
    {
      bool = paramJSONObject.optBoolean("enableScroll", true);
      this.mMapUiSettings.setScrollGesturesEnabled(bool);
    }
    if (paramJSONObject.has("enableRotate"))
    {
      bool = paramJSONObject.optBoolean("enableRotate", false);
      this.mMapUiSettings.setRotateGesturesEnabled(bool);
    }
    if (paramJSONObject.has("enableSatellite"))
    {
      bool = paramJSONObject.optBoolean("enableSatellite", false);
      this.mTencentMap.setSatelliteEnabled(bool);
    }
    if (paramJSONObject.has("enableTraffic"))
    {
      bool = paramJSONObject.optBoolean("enableTraffic", false);
      this.mTencentMap.setTrafficEnabled(bool);
    }
    if (paramJSONObject.has("enable3D"))
    {
      bool = paramJSONObject.optBoolean("enable3D", false);
      this.mTencentMap.setBuildingEnable(bool);
    }
    if (paramJSONObject.has("showLocation"))
    {
      this.curShowLocationMarkerStatus = paramJSONObject.optBoolean("showLocation");
      if (!this.curShowLocationMarkerStatus) {
        break label249;
      }
      location();
    }
    label249:
    while (this.locationMarker == null) {
      return;
    }
    this.locationMarker.setVisible(false);
  }
  
  public void addMapCircles(JSONObject paramJSONObject)
  {
    int i = 0;
    if (paramJSONObject == null) {}
    label99:
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("circles");
      if (paramJSONObject != null)
      {
        int j = paramJSONObject.length();
        if (j > 0)
        {
          while (i < j)
          {
            addCircle(paramJSONObject.optJSONObject(i));
            i += 1;
          }
        }
        else
        {
          if (this.circleArrayList != null) {}
          for (i = this.circleArrayList.size();; i = 0)
          {
            if (i <= 0) {
              break label99;
            }
            j = 0;
            while (j < i)
            {
              ((Circle)this.circleArrayList.get(j)).remove();
              j += 1;
            }
            break;
          }
        }
      }
    }
  }
  
  public void addMapControls(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("controls");
      if (paramJSONObject != null)
      {
        int j = paramJSONObject.length();
        int i = 0;
        while (i < j)
        {
          addControl(paramJSONObject.optJSONObject(i));
          i += 1;
        }
      }
    }
  }
  
  public void addMapCovers(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("covers");
      if (paramJSONObject != null)
      {
        int i = 0;
        while (i < paramJSONObject.length())
        {
          addCover(paramJSONObject.optJSONObject(i));
          i += 1;
        }
      }
    }
  }
  
  public void addMapMarkers(JSONObject paramJSONObject)
  {
    paramJSONObject = paramJSONObject.optJSONArray("markers");
    if (paramJSONObject != null)
    {
      int i = 0;
      while (i < paramJSONObject.length())
      {
        addMarker(paramJSONObject.optJSONObject(i));
        i += 1;
      }
    }
  }
  
  public void addMapPolygons(JSONObject paramJSONObject)
  {
    int k = 0;
    if (paramJSONObject == null) {}
    do
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("polygons");
    } while (paramJSONObject == null);
    Object localObject1;
    float f;
    Object localObject2;
    String str;
    boolean bool;
    if (paramJSONObject.length() > 0)
    {
      localObject1 = paramJSONObject.optJSONObject(0);
      paramJSONObject = ((JSONObject)localObject1).optJSONArray("points");
      f = (float)((JSONObject)localObject1).optDouble("strokeWidth");
      localObject2 = ((JSONObject)localObject1).optString("strokeColor");
      str = ((JSONObject)localObject1).optString("fillColor");
      bool = ((JSONObject)localObject1).optBoolean("visible", true);
      if (TextUtils.isEmpty(str)) {
        break label254;
      }
    }
    label254:
    for (int i = ColorUtils.parseColor(str);; i = 0)
    {
      if (!TextUtils.isEmpty((CharSequence)localObject2)) {}
      for (int j = ColorUtils.parseColor((String)localObject2);; j = 0)
      {
        localObject1 = new PolygonOptions();
        ((PolygonOptions)localObject1).fillColor(i);
        ((PolygonOptions)localObject1).visible(bool);
        ((PolygonOptions)localObject1).strokeColor(j);
        ((PolygonOptions)localObject1).strokeWidth(f);
        if (paramJSONObject != null)
        {
          i = k;
          while (i < paramJSONObject.length())
          {
            localObject2 = paramJSONObject.optJSONObject(i);
            ((PolygonOptions)localObject1).add(new LatLng(((JSONObject)localObject2).optDouble("latitude", 0.0D), ((JSONObject)localObject2).optDouble("longitude", 0.0D)));
            i += 1;
          }
        }
        if (this.mTencentMap == null) {
          break;
        }
        this.curPolygon = this.mTencentMap.addPolygon((PolygonOptions)localObject1);
        return;
        if (this.curPolygon == null) {
          break;
        }
        this.curPolygon.remove();
        return;
      }
    }
  }
  
  public void addMapPolyline(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("lines");
      if (paramJSONObject != null)
      {
        if (this.polylineArrayList != null) {}
        for (int i = this.polylineArrayList.size(); i > 0; i = 0)
        {
          j = 0;
          while (j < i)
          {
            ((Polyline)this.polylineArrayList.get(j)).remove();
            j += 1;
          }
        }
        int j = paramJSONObject.length();
        if (j > 0)
        {
          i = 0;
          while (i < j)
          {
            addPolyline(paramJSONObject.optJSONObject(i));
            i += 1;
          }
        }
      }
    }
  }
  
  public void destroy()
  {
    this.sensorManager.unregisterListener(this);
  }
  
  public LatLng getCenterLocation()
  {
    if ((this.mTencentMap != null) && (this.mTencentMap.getCameraPosition() != null) && (this.mTencentMap.getCameraPosition().target != null)) {
      return this.mTencentMap.getCameraPosition().target;
    }
    return null;
  }
  
  public View getInfoContents(Marker paramMarker)
  {
    return null;
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    return null;
  }
  
  public JSONObject getRegion()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Projection localProjection;
    if (this.mTencentMap != null) {
      localProjection = this.mTencentMap.getProjection();
    }
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("longitude", localProjection.getVisibleRegion().latLngBounds.southwest.longitude);
      localJSONObject2.put("latitude", localProjection.getVisibleRegion().latLngBounds.southwest.latitude);
      localJSONObject1.put("southwest", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("longitude", localProjection.getVisibleRegion().latLngBounds.northeast.longitude);
      localJSONObject2.put("latitude", localProjection.getVisibleRegion().latLngBounds.northeast.latitude);
      localJSONObject1.put("northeast", localJSONObject2);
      return localJSONObject1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public float getRotate()
  {
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null)) {
      return DEFAULT_ROTATE;
    }
    return this.mTencentMap.getCameraPosition().bearing;
  }
  
  public float getScale()
  {
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null)) {
      return DEFAULT_SCALE;
    }
    return (int)this.mTencentMap.getCameraPosition().zoom;
  }
  
  public float getSkew()
  {
    if ((this.mTencentMap == null) || (this.mTencentMap.getCameraPosition() == null)) {
      return DEFAULT_SKEW;
    }
    return this.mTencentMap.getCameraPosition().tilt;
  }
  
  public void includeMapPoints(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      Object localObject1 = paramJSONObject.optJSONArray("points");
      paramJSONObject = paramJSONObject.optJSONArray("padding");
      if ((localObject1 != null) && (((JSONArray)localObject1).length() > 0))
      {
        Object localObject2 = new double[((JSONArray)localObject1).length()];
        double[] arrayOfDouble = new double[((JSONArray)localObject1).length()];
        int i = 0;
        while (i < ((JSONArray)localObject1).length())
        {
          JSONObject localJSONObject = ((JSONArray)localObject1).optJSONObject(i);
          if (localJSONObject != null)
          {
            d1 = localJSONObject.optDouble("latitude", 0.0D);
            d2 = localJSONObject.optDouble("longitude", 0.0D);
            localObject2[i] = d1;
            arrayOfDouble[i] = d2;
          }
          i += 1;
        }
        Arrays.sort((double[])localObject2);
        Arrays.sort(arrayOfDouble);
        double d1 = localObject2[0];
        double d2 = arrayOfDouble[0];
        double d3 = localObject2[(localObject1.length() - 1)];
        double d4 = arrayOfDouble[(localObject1.length() - 1)];
        if (QMLog.isColorLevel()) {
          QMLog.d(TAG, "includeMapPoints leftTopLatitude=" + d1 + ",leftTopLongitude=" + d2 + ",rightBottomLatitude=" + d3 + ",rightBottomLongitude=" + d4);
        }
        localObject1 = new LatLng(d1, d2);
        localObject2 = new LatLng(d3, d4);
        if ((paramJSONObject != null) && (paramJSONObject.length() > 0)) {}
        for (i = paramJSONObject.optInt(0, 0); this.mTencentMap != null; i = 0)
        {
          this.showCurrentLocationStatus = false;
          this.mTencentMap.moveCamera(CameraUpdateFactory.newLatLngBounds(new LatLngBounds((LatLng)localObject1, (LatLng)localObject2), i));
          this.curLatLng = this.mTencentMap.getCameraPosition().target;
          return;
        }
      }
    }
  }
  
  public void moveToCurrentLocation()
  {
    this.showCurrentLocationStatus = true;
    location();
  }
  
  public void moveToLocation(JSONObject paramJSONObject)
  {
    this.showCurrentLocationStatus = false;
    double d;
    if (paramJSONObject.has("longitude"))
    {
      d = paramJSONObject.optDouble("longitude", 0.0D);
      if (d != 0.0D) {
        this.curLatLng.setLongitude(d);
      }
    }
    if (paramJSONObject.has("latitude"))
    {
      d = paramJSONObject.optDouble("latitude", 0.0D);
      if (d != 0.0D) {
        this.curLatLng.setLatitude(d);
      }
    }
    paramJSONObject = CameraUpdateFactory.newCameraPosition(new CameraPosition(this.curLatLng, this.curScale, this.curSkew, this.curRotate));
    this.mTencentMap.moveCamera(paramJSONObject);
  }
  
  public void onAccuracyChanged(Sensor paramSensor, int paramInt) {}
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new JSONObject();
      paramCameraPosition.put("mapId", this.mMapId);
      paramCameraPosition.put("type", "begin");
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_REGION_CHANGE, paramCameraPosition.toString(), this.mPageWebViewId));
      return;
    }
    catch (JSONException paramCameraPosition)
    {
      paramCameraPosition.printStackTrace();
    }
  }
  
  public void onCameraChangeFinished(CameraPosition paramCameraPosition)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("mapId", this.mMapId);
      localJSONObject.put("type", "end");
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_REGION_CHANGE, localJSONObject.toString(), this.mPageWebViewId));
      this.curLatLng = paramCameraPosition.target;
      this.curScale = paramCameraPosition.zoom;
      this.curSkew = paramCameraPosition.tilt;
      this.curRotate = paramCameraPosition.bearing;
      return;
    }
    catch (JSONException paramCameraPosition)
    {
      paramCameraPosition.printStackTrace();
    }
  }
  
  public void onInfoWindowClick(Marker paramMarker)
  {
    try
    {
      paramMarker = ((JSONObject)paramMarker.getTag()).optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramMarker);
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_CALLOUT_CLICK, localJSONObject.toString(), this.mPageWebViewId));
      return;
    }
    catch (JSONException paramMarker)
    {
      paramMarker.printStackTrace();
    }
  }
  
  public void onInfoWindowClickLocation(int paramInt1, int paramInt2, int paramInt3, int paramInt4) {}
  
  public void onMapClick(LatLng paramLatLng)
  {
    int j = this.markerSparseArray.size();
    int i = 0;
    Object localObject;
    while (i < j)
    {
      localObject = (Marker)this.markerSparseArray.valueAt(i);
      if ((localObject != null) && (((Marker)localObject).isInfoWindowShown())) {
        ((Marker)localObject).hideInfoWindow();
      }
      i += 1;
    }
    try
    {
      localObject = new JSONObject();
      ((JSONObject)localObject).put("mapId", this.mMapId);
      ((JSONObject)localObject).put("latitude", paramLatLng.latitude);
      ((JSONObject)localObject).put("longitude", paramLatLng.longitude);
      this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_CLICK, ((JSONObject)localObject).toString(), this.mPageWebViewId));
      return;
    }
    catch (JSONException paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void onMapLoaded() {}
  
  public boolean onMarkerClick(Marker paramMarker)
  {
    if (paramMarker == null) {
      return false;
    }
    try
    {
      if (!paramMarker.isInfoWindowShown()) {
        paramMarker.showInfoWindow();
      }
      paramMarker = (JSONObject)paramMarker.getTag();
      if (paramMarker != null)
      {
        paramMarker = paramMarker.optString("data");
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", paramMarker);
        this.mMiniAppContext.performAction(ServiceSubscribeEvent.obtain(MAP_EVENT_MARKER_CLICK, localJSONObject.toString(), this.mPageWebViewId));
      }
    }
    catch (JSONException paramMarker)
    {
      for (;;)
      {
        paramMarker.printStackTrace();
      }
    }
    return true;
  }
  
  public void onSensorChanged(SensorEvent paramSensorEvent)
  {
    this.rotateDegree = (Math.round(paramSensorEvent.values[0] * 100.0F) / 100.0F);
    if (this.locationMarker != null) {
      this.locationMarker.setRotation(this.rotateDegree);
    }
  }
  
  public void removeMapMarkers(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("markers");
      if (paramJSONObject != null)
      {
        int j = paramJSONObject.length();
        int i = 0;
        while (i < j)
        {
          int k = paramJSONObject.optInt(i);
          Marker localMarker = (Marker)this.markerSparseArray.get(k);
          if (localMarker != null)
          {
            localMarker.remove();
            this.markerSparseArray.remove(k);
          }
          i += 1;
        }
      }
    }
  }
  
  public void translateMapMarker(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    Marker localMarker;
    do
    {
      do
      {
        do
        {
          return;
          int i = paramJSONObject.optInt("markerId");
          localMarker = (Marker)this.markerSparseArray.get(i);
        } while (localMarker == null);
        paramJSONObject = paramJSONObject.optJSONArray("keyFrames");
      } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
      paramJSONObject = paramJSONObject.optJSONObject(0);
    } while (paramJSONObject == null);
    localMarker.setPosition(new LatLng(paramJSONObject.optDouble("latitude", 0.0D), paramJSONObject.optDouble("longitude", 0.0D)));
  }
  
  public void updateMap(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null)
    {
      QMLog.e(TAG, "updateMap jsonObject is null, return.");
      return;
    }
    for (;;)
    {
      try
      {
        if (paramJSONObject.has("position")) {
          updateMapViewPosition(paramJSONObject.optJSONObject("position"));
        }
        if (!paramJSONObject.has("centerLongitude")) {
          break label173;
        }
        d1 = paramJSONObject.optDouble("centerLongitude", 0.0D);
        if (!paramJSONObject.has("centerLatitude")) {
          break label167;
        }
        d2 = paramJSONObject.optDouble("centerLatitude", 0.0D);
      }
      catch (Throwable paramJSONObject)
      {
        QMLog.e(TAG, "updateMap error,", paramJSONObject);
        return;
      }
      this.curLatLng = new LatLng(d2, d1);
      setScale(paramJSONObject);
      addMapMarkers(paramJSONObject);
      addMapCovers(paramJSONObject);
      addMapPolyline(paramJSONObject);
      addMapCircles(paramJSONObject);
      addMapControls(paramJSONObject);
      addMapPolygons(paramJSONObject);
      setRotate(paramJSONObject);
      setSkew(paramJSONObject);
      setLocationStatus(paramJSONObject, d2, d1);
      setShowCompass(paramJSONObject);
      updateOtherParams(paramJSONObject);
      return;
      label167:
      double d2 = 0.0D;
      break label178;
      label173:
      double d1 = 0.0D;
      continue;
      label178:
      if (d2 == 0.0D) {
        if (d1 == 0.0D) {}
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.map.MapContext
 * JD-Core Version:    0.7.0.1
 */