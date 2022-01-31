package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.mapsdk.raster.model.BitmapDescriptor;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.LatLngBounds.Builder;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.apkg.f;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.microapp.appbrand.utils.b;
import com.tencent.mobileqq.microapp.b.a;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class MapContext
  implements TencentMap.InfoWindowAdapter, TencentMap.OnInfoWindowClickListener, TencentMap.OnMapCameraChangeListener, TencentMap.OnMapClickListener, TencentMap.OnMapLoadedListener, TencentMap.OnMarkerClickListener
{
  protected PageWebview a;
  public TencentMap b;
  public QQMapView c;
  public int d;
  protected Context e;
  public ServiceWebview f;
  private int g;
  private float h;
  private SparseArray i;
  private LatLng j;
  
  public MapContext(PageWebview paramPageWebview, ServiceWebview paramServiceWebview, QQMapView paramQQMapView, int paramInt, f paramf)
  {
    this.a = paramPageWebview;
    this.f = paramServiceWebview;
    this.c = paramQQMapView;
    this.b = paramQQMapView.getMap();
    this.d = paramInt;
    this.e = paramQQMapView.getContext();
    this.b.setInfoWindowAdapter(this);
    this.b.setOnMarkerClickListener(this);
    this.b.setOnInfoWindowClickListener(this);
    this.b.setOnMapClickListener(this);
    this.b.setOnMapLoadedListener(this);
    this.b.setOnMapCameraChangeListener(this);
    this.i = new SparseArray();
    this.h = this.e.getResources().getDisplayMetrics().density;
    this.g = ((int)(this.h * 30.0F + 0.5D));
    try
    {
      BitmapFactory.decodeResource(paramQQMapView.getResources(), R.drawable.g);
      return;
    }
    catch (OutOfMemoryError paramPageWebview) {}
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    paramString = "WeixinJSBridge.subscribeHandler(\"" + paramString + "\", " + paramJSONObject + "," + this.a.pageWebviewId + ")";
    if (QLog.isColorLevel()) {
      QLog.d("MapContext", 2, "callbackJs jsStr=" + paramString);
    }
    this.a.evaluteJs(paramString);
  }
  
  private ImageView e()
  {
    ImageView localImageView = new ImageView(this.e);
    localImageView.setMinimumWidth(this.g);
    localImageView.setMinimumHeight(this.g);
    return localImageView;
  }
  
  private void e(JSONObject paramJSONObject)
  {
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder().append("addMarker params=");
      if (paramJSONObject == null) {
        break label51;
      }
    }
    label51:
    for (Object localObject1 = paramJSONObject.toString();; localObject1 = "empty")
    {
      QLog.d("MapContext", 2, (String)localObject1);
      if (paramJSONObject != null) {
        break;
      }
      return;
    }
    int k = paramJSONObject.optInt("id", 0);
    double d1 = paramJSONObject.optDouble("latitude", 0.0D);
    double d2 = paramJSONObject.optDouble("longitude", 0.0D);
    String str = paramJSONObject.optString("title", "");
    Object localObject3 = paramJSONObject.optString("iconPath", "");
    float f1 = (float)paramJSONObject.optDouble("rotate", 0.0D);
    float f2 = (float)paramJSONObject.optDouble("alpha", 1.0D);
    int m = paramJSONObject.optInt("width", -2);
    int n = paramJSONObject.optInt("height", -2);
    localObject1 = paramJSONObject.optJSONObject("anchor");
    MarkerOptions localMarkerOptions = new MarkerOptions();
    localMarkerOptions.position(new LatLng(d1, d2));
    if (localObject1 != null) {
      localMarkerOptions.anchor((float)((JSONObject)localObject1).optDouble("x", 0.5D), (float)((JSONObject)localObject1).optDouble("y", 1.0D));
    }
    Object localObject2 = null;
    localObject1 = null;
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = b.a().d((String)localObject3);
      localObject1 = localObject2;
    }
    try
    {
      localObject3 = Drawable.createFromPath((String)localObject3);
      localObject2 = localObject3;
      if (localObject3 == null)
      {
        localObject1 = localObject3;
        localObject2 = this.e.getResources().getDrawable(R.drawable.r);
      }
      localObject1 = localObject2;
      localMarkerOptions.icon(new BitmapDescriptor(a.a((Drawable)localObject2)));
      localObject1 = localObject2;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label297:
      break label297;
    }
    localObject2 = e();
    ((ImageView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(m, n));
    ((ImageView)localObject2).setImageDrawable((Drawable)localObject1);
    localMarkerOptions.markerView((View)localObject2);
    localMarkerOptions.title(str);
    localMarkerOptions.rotation(f1);
    localMarkerOptions.alpha(f2);
    localObject1 = this.b.addMarker(localMarkerOptions);
    ((Marker)localObject1).showInfoWindow();
    ((Marker)localObject1).setTag(paramJSONObject);
    this.i.put(k, localObject1);
  }
  
  public LatLng a()
  {
    if (this.b != null) {
      return this.b.getMapCenter();
    }
    return null;
  }
  
  public void a(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("markers");
      if (paramJSONObject != null)
      {
        int m = paramJSONObject.length();
        int k = 0;
        while (k < m)
        {
          int n = paramJSONObject.optInt(k);
          Marker localMarker = (Marker)this.i.get(n);
          if (localMarker != null)
          {
            localMarker.remove();
            this.i.remove(n);
          }
          k += 1;
        }
      }
    }
  }
  
  public void b()
  {
    if (this.j != null) {
      this.b.animateTo(this.j);
    }
  }
  
  public void b(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    for (;;)
    {
      return;
      paramJSONObject = paramJSONObject.optJSONArray("markers");
      if (paramJSONObject != null)
      {
        int m = paramJSONObject.length();
        int k = 0;
        while (k < m)
        {
          e(paramJSONObject.optJSONObject(k));
          k += 1;
        }
      }
    }
  }
  
  public int c()
  {
    return this.b.getZoomLevel();
  }
  
  public void c(JSONObject paramJSONObject)
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
          int k = paramJSONObject.optInt("markerId");
          localMarker = (Marker)this.i.get(k);
        } while (localMarker == null);
        paramJSONObject = paramJSONObject.optJSONArray("keyFrames");
      } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
      paramJSONObject = paramJSONObject.optJSONObject(0);
    } while (paramJSONObject == null);
    localMarker.setPosition(new LatLng(paramJSONObject.optDouble("latitude", 0.0D), paramJSONObject.optDouble("longitude", 0.0D)));
  }
  
  public JSONObject d()
  {
    JSONObject localJSONObject1 = new JSONObject();
    Object localObject = new LatLngBounds.Builder();
    ((LatLngBounds.Builder)localObject).include(this.b.getMapCenter());
    localObject = ((LatLngBounds.Builder)localObject).build();
    try
    {
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("longitude", ((LatLngBounds)localObject).getSouthwest().getLongitude());
      localJSONObject2.put("latitude", ((LatLngBounds)localObject).getSouthwest().getLatitude());
      localJSONObject1.put("southwest", localJSONObject2);
      localJSONObject2 = new JSONObject();
      localJSONObject2.put("longitude", ((LatLngBounds)localObject).getSouthwest().getLongitude());
      localJSONObject2.put("latitude", ((LatLngBounds)localObject).getSouthwest().getLatitude());
      localJSONObject1.put("northeast", localJSONObject2);
      return localJSONObject1;
    }
    catch (JSONException localJSONException)
    {
      localJSONException.printStackTrace();
    }
    return localJSONObject1;
  }
  
  public void d(JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {}
    double d1;
    double d3;
    double d4;
    double d6;
    do
    {
      return;
      d1 = 0.0D;
      d3 = 0.0D;
      d4 = 0.0D;
      d6 = 0.0D;
      paramJSONObject = paramJSONObject.optJSONArray("points");
    } while ((paramJSONObject == null) || (paramJSONObject.length() <= 0));
    int k = 0;
    while (k < paramJSONObject.length())
    {
      localObject = paramJSONObject.optJSONObject(k);
      double d11 = d6;
      double d10 = d4;
      double d8 = d3;
      double d9 = d1;
      if (localObject != null)
      {
        double d5 = ((JSONObject)localObject).optDouble("latitude", 0.0D);
        double d7 = ((JSONObject)localObject).optDouble("longitude", 0.0D);
        double d2 = d1;
        if (d5 > d1)
        {
          d3 = d7;
          d2 = d5;
        }
        d11 = d6;
        d10 = d4;
        d8 = d3;
        d9 = d2;
        if (d7 > d4)
        {
          d9 = d2;
          d8 = d3;
          d10 = d5;
          d11 = d7;
        }
      }
      k += 1;
      d6 = d11;
      d4 = d10;
      d3 = d8;
      d1 = d9;
    }
    if (QLog.isColorLevel()) {
      QLog.d("MapContext", 2, "includeMapPoints leftTopLatitude=" + d1 + ",leftTopLongitude=" + d3 + ",rightBottomLatitude=" + d4 + ",rightBottomLongitude=" + d6);
    }
    paramJSONObject = new LatLng(d1, d3);
    Object localObject = new LatLng(d4, d6);
    this.b.zoomToSpan(paramJSONObject, (LatLng)localObject);
  }
  
  public View getInfoWindow(Marker paramMarker)
  {
    paramMarker = paramMarker.getTag();
    if ((paramMarker instanceof JSONObject))
    {
      Object localObject = ((JSONObject)paramMarker).optJSONObject("callout");
      if (localObject == null) {
        return null;
      }
      paramMarker = ((JSONObject)localObject).optString("content", "");
      String str1 = ((JSONObject)localObject).optString("color", "");
      float f1 = (float)((JSONObject)localObject).optDouble("fontSize", 0.0D);
      float f2 = (float)((JSONObject)localObject).optDouble("borderRadius", 0.0D);
      String str2 = ((JSONObject)localObject).optString("bgColor", "");
      int k = (int)(((JSONObject)localObject).optInt("padding", 0) * this.h);
      String str3 = ((JSONObject)localObject).optString("display", "");
      localObject = ((JSONObject)localObject).optString("textAlign", "");
      MapContext.InfoView localInfoView = new MapContext.InfoView(this, this.e);
      localInfoView.a(paramMarker, str1, f1, f2, str2, k, str3, (String)localObject);
      return localInfoView;
    }
    return null;
  }
  
  public void onCameraChange(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new JSONObject();
      paramCameraPosition.put("mapId", this.d);
      paramCameraPosition.put("type", "begin");
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + paramCameraPosition + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramCameraPosition)
    {
      paramCameraPosition.printStackTrace();
    }
  }
  
  public void onCameraChangeFinish(CameraPosition paramCameraPosition)
  {
    try
    {
      paramCameraPosition = new JSONObject();
      paramCameraPosition.put("mapId", this.d);
      paramCameraPosition.put("type", "end");
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", " + paramCameraPosition + ", " + this.a.pageWebviewId + ")");
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
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapCalloutClick\", " + localJSONObject + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramMarker)
    {
      paramMarker.printStackTrace();
    }
  }
  
  public void onInfoWindowDettached(Marker paramMarker, View paramView) {}
  
  public void onMapClick(LatLng paramLatLng)
  {
    int m = this.i.size();
    int k = 0;
    while (k < m)
    {
      paramLatLng = (Marker)this.i.valueAt(k);
      if ((paramLatLng != null) && (paramLatLng.isInfoWindowShown())) {
        paramLatLng.hideInfoWindow();
      }
      k += 1;
    }
    try
    {
      paramLatLng = new JSONObject();
      paramLatLng.put("mapId", this.d);
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapClick\", " + paramLatLng + ", " + this.a.pageWebviewId + ")");
      return;
    }
    catch (JSONException paramLatLng)
    {
      paramLatLng.printStackTrace();
    }
  }
  
  public void onMapLoaded()
  {
    a("onMapUpdated", new JSONObject());
  }
  
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
      paramMarker = ((JSONObject)paramMarker.getTag()).optString("data");
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("data", paramMarker);
      this.f.evaluteJs("WeixinJSBridge.subscribeHandler(\"onMapMarkerClick\", " + localJSONObject + ", " + this.a.pageWebviewId + ")");
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.MapContext
 * JD-Core Version:    0.7.0.1
 */