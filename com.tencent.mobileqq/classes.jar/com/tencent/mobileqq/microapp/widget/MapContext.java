package com.tencent.mobileqq.microapp.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.View;
import com.tencent.mapsdk.raster.model.CameraPosition;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mobileqq.microapp.R.drawable;
import com.tencent.mobileqq.microapp.a.c;
import com.tencent.mobileqq.microapp.appbrand.page.PageWebview;
import com.tencent.mobileqq.microapp.appbrand.page.ServiceWebview;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import com.tencent.tencentmap.mapsdk.map.TencentMap.InfoWindowAdapter;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnInfoWindowClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapCameraChangeListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapClickListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMapLoadedListener;
import com.tencent.tencentmap.mapsdk.map.TencentMap.OnMarkerClickListener;
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
  private float g;
  private SparseArray h;
  
  public MapContext(PageWebview paramPageWebview, ServiceWebview paramServiceWebview, QQMapView paramQQMapView, int paramInt, c paramc)
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
    this.h = new SparseArray();
    this.g = this.e.getResources().getDisplayMetrics().density;
    try
    {
      BitmapFactory.decodeResource(paramQQMapView.getResources(), R.drawable.c);
      return;
    }
    catch (OutOfMemoryError paramPageWebview) {}
  }
  
  private void a(String paramString, JSONObject paramJSONObject)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"");
    localStringBuilder.append(paramString);
    localStringBuilder.append("\", ");
    localStringBuilder.append(paramJSONObject);
    localStringBuilder.append(",");
    localStringBuilder.append(this.a.pageWebviewId);
    localStringBuilder.append(")");
    paramString = localStringBuilder.toString();
    if (QLog.isColorLevel())
    {
      paramJSONObject = new StringBuilder();
      paramJSONObject.append("callbackJs jsStr=");
      paramJSONObject.append(paramString);
      QLog.d("MapContext", 2, paramJSONObject.toString());
    }
    this.a.evaluteJs(paramString);
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
      int i = (int)(((JSONObject)localObject).optInt("padding", 0) * this.g);
      String str3 = ((JSONObject)localObject).optString("display", "");
      localObject = ((JSONObject)localObject).optString("textAlign", "");
      MapContext.InfoView localInfoView = new MapContext.InfoView(this, this.e);
      localInfoView.a(paramMarker, str1, f1, f2, str2, i, str3, (String)localObject);
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
      ServiceWebview localServiceWebview = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", ");
      localStringBuilder.append(paramCameraPosition);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a.pageWebviewId);
      localStringBuilder.append(")");
      localServiceWebview.evaluteJs(localStringBuilder.toString());
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
      ServiceWebview localServiceWebview = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onMapRegionChange\", ");
      localStringBuilder.append(paramCameraPosition);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a.pageWebviewId);
      localStringBuilder.append(")");
      localServiceWebview.evaluteJs(localStringBuilder.toString());
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
      Object localObject = ((JSONObject)paramMarker.getTag()).optString("data");
      paramMarker = new JSONObject();
      paramMarker.put("data", localObject);
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onMapCalloutClick\", ");
      localStringBuilder.append(paramMarker);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a.pageWebviewId);
      localStringBuilder.append(")");
      ((ServiceWebview)localObject).evaluteJs(localStringBuilder.toString());
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
    int j = this.h.size();
    int i = 0;
    while (i < j)
    {
      paramLatLng = (Marker)this.h.valueAt(i);
      if ((paramLatLng != null) && (paramLatLng.isInfoWindowShown())) {
        paramLatLng.hideInfoWindow();
      }
      i += 1;
    }
    try
    {
      paramLatLng = new JSONObject();
      paramLatLng.put("mapId", this.d);
      ServiceWebview localServiceWebview = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onMapClick\", ");
      localStringBuilder.append(paramLatLng);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a.pageWebviewId);
      localStringBuilder.append(")");
      localServiceWebview.evaluteJs(localStringBuilder.toString());
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
      Object localObject = ((JSONObject)paramMarker.getTag()).optString("data");
      paramMarker = new JSONObject();
      paramMarker.put("data", localObject);
      localObject = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("WeixinJSBridge.subscribeHandler(\"onMapMarkerClick\", ");
      localStringBuilder.append(paramMarker);
      localStringBuilder.append(", ");
      localStringBuilder.append(this.a.pageWebviewId);
      localStringBuilder.append(")");
      ((ServiceWebview)localObject).evaluteJs(localStringBuilder.toString());
    }
    catch (JSONException paramMarker)
    {
      paramMarker.printStackTrace();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.microapp.widget.MapContext
 * JD-Core Version:    0.7.0.1
 */