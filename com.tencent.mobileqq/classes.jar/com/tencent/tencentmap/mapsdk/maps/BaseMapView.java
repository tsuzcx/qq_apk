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
    if (this.a != null)
    {
      this.a.c();
      this.a = null;
    }
  }
  
  public void onPause()
  {
    if (this.a != null) {
      this.a.e();
    }
  }
  
  public void onRestart()
  {
    if (this.a != null) {
      this.a.f();
    }
  }
  
  public void onResume()
  {
    if (this.a != null) {
      this.a.d();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.b != null) {
      this.b.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    }
  }
  
  public void onStart()
  {
    if (this.a != null) {
      this.a.a();
    }
  }
  
  public void onStop()
  {
    if (this.a != null) {
      this.a.b();
    }
  }
  
  public void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.b != null) {
      this.b.onSurfaceChanged(paramObject, paramInt1, paramInt2);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.a != null) && (this.a.getMapManager() != null) && (this.a.getMapManager().b != null)) {
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
    if (this.a != null) {
      this.a.setOnTop(paramBoolean);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.BaseMapView
 * JD-Core Version:    0.7.0.1
 */