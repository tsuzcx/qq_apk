package com.tencent.tencentmap.mapsdk.map;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListView;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.Circle;
import com.tencent.mapsdk.raster.model.CircleOptions;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.GroundOverlay;
import com.tencent.mapsdk.raster.model.GroundOverlayOptions;
import com.tencent.mapsdk.raster.model.IOverlay;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.raster.model.LatLngBounds;
import com.tencent.mapsdk.raster.model.Marker;
import com.tencent.mapsdk.raster.model.MarkerOptions;
import com.tencent.mapsdk.raster.model.Polygon;
import com.tencent.mapsdk.raster.model.PolygonOptions;
import com.tencent.mapsdk.raster.model.Polyline;
import com.tencent.mapsdk.raster.model.PolylineOptions;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.d.e;
import com.tencent.mapsdk.rastercore.d.f;

public class MapView
  extends FrameLayout
{
  private boolean config = false;
  @Deprecated
  private MapController controller;
  private f eventHandler;
  private e mapContext;
  private Projection projection;
  private int scene = 0;
  private TencentMap tencentMap;
  private UiSettings uiSettings;
  
  public MapView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public MapView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.scene = paramInt;
    init();
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public MapView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext);
    this.config = paramBoolean;
    init();
  }
  
  private void doLayout(View paramView, int paramInt1, int paramInt2, float paramFloat1, float paramFloat2, int paramInt3)
  {
    int i = paramInt3 & 0x7;
    paramInt3 &= 0x70;
    float f;
    if (i == 5)
    {
      f = paramFloat1 - paramInt1;
      if (paramInt3 != 80) {
        break label94;
      }
      paramFloat1 = paramFloat2 - paramInt2;
    }
    for (;;)
    {
      paramInt3 = Math.round(f);
      i = Math.round(paramFloat1);
      paramView.layout(paramInt3, i, paramInt3 + paramInt1, i + paramInt2);
      return;
      f = paramFloat1;
      if (i != 1) {
        break;
      }
      f = paramFloat1 - paramInt1 / 2;
      break;
      label94:
      paramFloat1 = paramFloat2;
      if (paramInt3 == 16) {
        paramFloat1 = paramFloat2 - paramInt2 / 2;
      }
    }
  }
  
  private void doMeasure(View paramView, int paramInt1, int paramInt2, int[] paramArrayOfInt)
  {
    if ((paramView instanceof ListView))
    {
      View localView = (View)paramView.getParent();
      if (localView != null)
      {
        paramArrayOfInt[0] = localView.getWidth();
        paramArrayOfInt[1] = localView.getHeight();
      }
    }
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      paramView.measure(0, 0);
    }
    if (paramInt1 == -2) {
      paramArrayOfInt[0] = paramView.getMeasuredWidth();
    }
    while (paramInt2 == -2)
    {
      paramArrayOfInt[1] = paramView.getMeasuredHeight();
      return;
      if (paramInt1 == -1) {
        paramArrayOfInt[0] = getMeasuredWidth();
      } else {
        paramArrayOfInt[0] = paramInt1;
      }
    }
    if (paramInt2 == -1)
    {
      paramArrayOfInt[1] = getMeasuredHeight();
      return;
    }
    paramArrayOfInt[1] = paramInt2;
  }
  
  private void init()
  {
    initForBugly();
    try
    {
      localObject = getTag();
      setTag(null);
      localObject = (Integer)localObject;
      if (localObject != null) {
        this.scene = ((Integer)localObject).intValue();
      }
    }
    catch (Exception localException)
    {
      Object localObject;
      label31:
      int i;
      boolean bool;
      break label31;
    }
    localObject = getContext();
    i = this.scene;
    if (this.scene != 0) {}
    for (bool = true;; bool = false)
    {
      this.mapContext = new e(this, i, bool, this.config);
      this.eventHandler = this.mapContext.h();
      setOnKeyListener(this.eventHandler);
      this.projection = new Projection(this.mapContext);
      this.uiSettings = new UiSettings(this.mapContext.f());
      this.tencentMap = new TencentMap(this.mapContext);
      this.controller = new MapController(this);
      if ((localObject instanceof MapActivity)) {
        ((MapActivity)localObject).setMapView(this);
      }
      setBackgroundColor(-657936);
      return;
    }
  }
  
  private void initForBugly()
  {
    SharedPreferences.Editor localEditor = getContext().getApplicationContext().getSharedPreferences("BuglySdkInfos", 0).edit();
    localEditor.putString("4e7cb4aa49", "1.2.6");
    localEditor.commit();
  }
  
  private void layout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    paramInt2 = getChildCount();
    paramInt1 = 0;
    while (paramInt1 < paramInt2)
    {
      View localView = getChildAt(paramInt1);
      if (localView != null) {
        layout(localView);
      }
      paramInt1 += 1;
    }
  }
  
  private void layoutMap(View paramView, LayoutParams paramLayoutParams)
  {
    int[] arrayOfInt = new int[2];
    doMeasure(paramView, paramLayoutParams.width, paramLayoutParams.height, arrayOfInt);
    PointF localPointF;
    if (paramLayoutParams.getPoint() != null)
    {
      localPointF = this.mapContext.b().a(paramLayoutParams.getPoint());
      if (localPointF != null) {}
    }
    else
    {
      return;
    }
    localPointF.x += paramLayoutParams.x;
    localPointF.y += paramLayoutParams.y;
    doLayout(paramView, arrayOfInt[0], arrayOfInt[1], localPointF.x, localPointF.y, paramLayoutParams.alignment);
  }
  
  private void layoutView(View paramView, LayoutParams paramLayoutParams)
  {
    int[] arrayOfInt = new int[2];
    doMeasure(paramView, paramLayoutParams.width, paramLayoutParams.height, arrayOfInt);
    doLayout(paramView, arrayOfInt[0], arrayOfInt[1], paramLayoutParams.x, paramLayoutParams.y, paramLayoutParams.alignment);
  }
  
  protected static void setIsChinese(boolean paramBoolean)
  {
    com.tencent.mapsdk.rastercore.c.a(paramBoolean);
  }
  
  public Circle addCircle(CircleOptions paramCircleOptions)
  {
    return this.tencentMap.addCircle(paramCircleOptions);
  }
  
  public GroundOverlay addGroundOverlay(GroundOverlayOptions paramGroundOverlayOptions)
  {
    return this.tencentMap.addGroundOverlay(paramGroundOverlayOptions);
  }
  
  public final Marker addMarker(MarkerOptions paramMarkerOptions)
  {
    return this.tencentMap.addMarker(paramMarkerOptions);
  }
  
  public GroundOverlay addOverlay(Bitmap paramBitmap, LatLng paramLatLng1, LatLng paramLatLng2)
  {
    return this.tencentMap.addGroundOverlay(new GroundOverlayOptions().positionFromBounds(new LatLngBounds(paramLatLng1, paramLatLng2)).anchor(0.5F, 0.5F).transparency(0.1F).image(BitmapDescriptorFactory.fromBitmap(paramBitmap)));
  }
  
  public final boolean addOverlay(Overlay paramOverlay)
  {
    if (paramOverlay == null) {
      return false;
    }
    paramOverlay.init(this);
    this.mapContext.e().a(paramOverlay);
    return true;
  }
  
  public Polygon addPolygon(PolygonOptions paramPolygonOptions)
  {
    return this.tencentMap.addPolygon(paramPolygonOptions);
  }
  
  public Polyline addPolyline(PolylineOptions paramPolylineOptions)
  {
    return this.tencentMap.addPolyline(paramPolylineOptions);
  }
  
  public final void clearAllOverlays()
  {
    this.tencentMap.clearAllOverlays();
  }
  
  public void computeScroll()
  {
    super.computeScroll();
    this.eventHandler.a();
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = false;
    setClickable(false);
    this.eventHandler.b(MotionEvent.obtain(paramMotionEvent));
    getParent().requestDisallowInterceptTouchEvent(true);
    if ((super.dispatchTouchEvent(paramMotionEvent)) || (this.eventHandler.a(paramMotionEvent))) {
      bool = true;
    }
    return bool;
  }
  
  public MapController getController()
  {
    return this.controller;
  }
  
  public int getLatitudeSpan()
  {
    return this.projection.getLatitudeSpan();
  }
  
  public int getLongitudeSpan()
  {
    return this.projection.getLongitudeSpan();
  }
  
  public TencentMap getMap()
  {
    return this.tencentMap;
  }
  
  public LatLng getMapCenter()
  {
    return this.tencentMap.getMapCenter();
  }
  
  protected e getMapContext()
  {
    return this.mapContext;
  }
  
  public MapController getMapController()
  {
    return this.controller;
  }
  
  public int getMaxZoomLevel()
  {
    return this.tencentMap.getMaxZoomLevel();
  }
  
  public int getMinZoomLevel()
  {
    return this.tencentMap.getMinZoomLevel();
  }
  
  public Projection getProjection()
  {
    return this.projection;
  }
  
  public float getScalePerPixel()
  {
    return this.projection.getScalePerPixel();
  }
  
  public UiSettings getUiSettings()
  {
    return this.uiSettings;
  }
  
  public final String getVersion()
  {
    return this.tencentMap.getVersion();
  }
  
  public int getZoomLevel()
  {
    return this.tencentMap.getZoomLevel();
  }
  
  public final boolean isAppKeyAvailable()
  {
    return this.tencentMap.isAppKeyAvailable();
  }
  
  public boolean isSatellite()
  {
    return this.tencentMap.isSatelliteEnabled();
  }
  
  public void layout()
  {
    layout(false, 0, 0, 0, 0);
  }
  
  public void layout(View paramView)
  {
    LayoutParams localLayoutParams;
    if (this == paramView.getParent())
    {
      if (!(paramView.getLayoutParams() instanceof LayoutParams)) {
        break label47;
      }
      localLayoutParams = (LayoutParams)paramView.getLayoutParams();
      if (localLayoutParams.mode == 0) {
        layoutMap(paramView, localLayoutParams);
      }
    }
    else
    {
      return;
    }
    layoutView(paramView, localLayoutParams);
    return;
    label47:
    layoutView(paramView, new LayoutParams(paramView.getLayoutParams()));
  }
  
  public void moveCamera(CameraUpdate paramCameraUpdate)
  {
    this.tencentMap.moveCamera(paramCameraUpdate);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.mapContext.a(paramBundle);
  }
  
  public void onDestroy()
  {
    this.mapContext.m();
  }
  
  public void onDestroyView() {}
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    layout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void onLowMemory() {}
  
  public void onPause()
  {
    e locale = this.mapContext;
    e.n();
  }
  
  public void onRestart() {}
  
  public void onResume() {}
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    this.mapContext.b(paramBundle);
  }
  
  public void onStop() {}
  
  public void refreshMap()
  {
    postInvalidate();
  }
  
  public final void removeOverlay(IOverlay paramIOverlay)
  {
    this.tencentMap.removeOverlay(paramIOverlay);
  }
  
  protected void setLocation(double paramDouble1, double paramDouble2)
  {
    com.tencent.mapsdk.rastercore.c.b(paramDouble1, paramDouble2);
  }
  
  public void setLogoPosition(int paramInt)
  {
    this.uiSettings.setLogoPosition(paramInt);
  }
  
  public void setPinchEnabeled(boolean paramBoolean)
  {
    this.uiSettings.setZoomGesturesEnabled(paramBoolean);
  }
  
  public void setSatellite(boolean paramBoolean)
  {
    this.tencentMap.setSatelliteEnabled(paramBoolean);
  }
  
  public void setScalControlsEnable(boolean paramBoolean)
  {
    this.uiSettings.setScaleControlsEnabled(paramBoolean);
  }
  
  public void setScaleControlsEnable(boolean paramBoolean)
  {
    this.uiSettings.setScaleControlsEnabled(paramBoolean);
  }
  
  public void setScaleViewPosition(int paramInt)
  {
    this.uiSettings.setScaleViewPosition(paramInt);
  }
  
  public void setScrollGesturesEnabled(boolean paramBoolean)
  {
    this.uiSettings.setScrollGesturesEnabled(paramBoolean);
  }
  
  public void stopAnimation()
  {
    clearAnimation();
    this.mapContext.c().clearAnimation();
    this.eventHandler.b();
  }
  
  public static class LayoutParams
    extends FrameLayout.LayoutParams
  {
    public static final int BOTTOM = 80;
    public static final int BOTTOM_CENTER = 81;
    public static final int CENTER = 17;
    public static final int CENTER_HORIZONTAL = 1;
    public static final int CENTER_VERTICAL = 16;
    public static final int LEFT = 3;
    public static final int MODE_MAP = 0;
    public static final int MODE_VIEW = 1;
    public static final int RIGHT = 5;
    public static final int TOP = 48;
    public static final int TOP_LEFT = 51;
    private int alignment = 51;
    public int mode = 1;
    private LatLng point = null;
    private int x = 0;
    private int y = 0;
    
    public LayoutParams(int paramInt1, int paramInt2)
    {
      super(paramInt2);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3)
    {
      this(paramInt1, paramInt2, paramGeoPoint, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, GeoPoint paramGeoPoint, int paramInt3, int paramInt4, int paramInt5)
    {
      this(paramInt1, paramInt2, com.tencent.mapsdk.rastercore.f.b.a(paramGeoPoint), paramInt3, paramInt4, paramInt5);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, int paramInt3)
    {
      this(paramInt1, paramInt2, paramLatLng, 0, 0, paramInt3);
    }
    
    public LayoutParams(int paramInt1, int paramInt2, LatLng paramLatLng, int paramInt3, int paramInt4, int paramInt5)
    {
      super(paramInt2);
      this.mode = 0;
      setPoint(paramLatLng);
      this.x = paramInt3;
      this.y = paramInt4;
      this.alignment = paramInt5;
    }
    
    protected LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
    {
      super();
    }
    
    public LatLng getPoint()
    {
      return this.point;
    }
    
    public void setPoint(LatLng paramLatLng)
    {
      this.point = paramLatLng;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapView
 * JD-Core Version:    0.7.0.1
 */