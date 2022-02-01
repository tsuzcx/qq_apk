package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.tencent.map.core.interfaces.IMapFactory;
import com.tencent.map.core.interfaces.IMapOptions;
import com.tencent.map.core.interfaces.IMapView;
import com.tencent.map.sdk.a.ks;
import com.tencent.map.sdk.a.ln;
import com.tencent.map.sdk.a.pn;
import com.tencent.map.sdk.basemap.interfaces.IMapRenderView;

public abstract class BaseMapView<M extends BaseMap, O extends IMapOptions>
  extends FrameLayout
  implements IMapView
{
  private M a = null;
  private IMapRenderView b;
  
  public BaseMapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public BaseMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public BaseMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    setClickable(true);
    if (isInEditMode()) {
      return;
    }
    a(paramContext.getApplicationContext(), null);
  }
  
  public BaseMapView(Context paramContext, O paramO)
  {
    super(paramContext);
    setClickable(true);
    if (isInEditMode()) {
      return;
    }
    a(paramContext, paramO);
  }
  
  private void a(Context paramContext, O paramO)
  {
    setBackgroundColor(Color.rgb(222, 215, 214));
    setEnabled(true);
    this.a = ((BaseMap)getFactory().build(paramContext, this, paramO));
    this.b = this.a.getViewControl().a();
  }
  
  protected abstract IMapFactory<M, BaseMapView, O> getFactory();
  
  public M getMap()
  {
    return this.a;
  }
  
  public int[] getMapPadding()
  {
    return new int[] { getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom() };
  }
  
  public abstract int getMapViewType();
  
  public void onDestroy()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null)
    {
      localBaseMap.c();
      this.a = null;
    }
  }
  
  public void onPause()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.e();
    }
  }
  
  public void onRestart()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.f();
    }
  }
  
  public void onResume()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.d();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    IMapRenderView localIMapRenderView = this.b;
    if (localIMapRenderView != null) {
      localIMapRenderView.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onStart()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.a();
    }
  }
  
  public void onStop()
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.b();
    }
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    IMapRenderView localIMapRenderView = this.b;
    if (localIMapRenderView != null) {
      localIMapRenderView.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    BaseMap localBaseMap = this.a;
    if ((localBaseMap != null) && (localBaseMap.getMapManager() != null) && (this.a.getMapManager().b != null)) {
      return this.a.getMapManager().b.onTouchEvent(paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setMapPadding(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    setPadding(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public void setOnTop(boolean paramBoolean)
  {
    BaseMap localBaseMap = this.a;
    if (localBaseMap != null) {
      localBaseMap.setOnTop(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.BaseMapView
 * JD-Core Version:    0.7.0.1
 */