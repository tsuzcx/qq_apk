package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.mobileqq.widget.QQMapView;
import com.tencent.tencentmap.mapsdk.maps.TencentMap;
import com.tencent.tencentmap.mapsdk.maps.TencentMap.SnapshotReadyCallback;
import com.tencent.tencentmap.mapsdk.maps.TencentMapOptions;
import com.tencent.tencentmap.mapsdk.maps.UiSettings;

public class CoverMapView
  extends CoverView
{
  private QQMapView mapView;
  
  public CoverMapView(Context paramContext)
  {
    super(paramContext);
    this.mapView = new QQMapView(paramContext, null);
    this.mapView.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mapView, paramContext);
  }
  
  public CoverMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext);
    this.mapView = new QQMapView(paramContext, null, paramTencentMapOptions);
    this.mapView.onResume();
    paramContext = new FrameLayout.LayoutParams(-1, -1);
    addView(this.mapView, paramContext);
  }
  
  public void captureImage(TencentMap.SnapshotReadyCallback paramSnapshotReadyCallback)
  {
    if (paramSnapshotReadyCallback == null) {
      return;
    }
    TencentMap localTencentMap = getMap();
    if (localTencentMap != null)
    {
      localTencentMap.snapshot(paramSnapshotReadyCallback);
      return;
    }
    paramSnapshotReadyCallback.onSnapshotReady(null);
  }
  
  public TencentMap getMap()
  {
    return this.mapView.getMap();
  }
  
  public UiSettings getUiSetrings()
  {
    return this.mapView.getMap().getUiSettings();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.CoverMapView
 * JD-Core Version:    0.7.0.1
 */