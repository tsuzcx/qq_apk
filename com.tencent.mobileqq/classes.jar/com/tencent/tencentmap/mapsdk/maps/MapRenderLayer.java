package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.Surface;
import android.view.SurfaceHolder;
import com.tencent.map.core.interfaces.IMapFactory;
import com.tencent.map.sdk.a.ql;

public class MapRenderLayer
  extends BaseMapView<TencentMap, TencentMapOptions>
{
  public MapRenderLayer(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
    onResume();
  }
  
  protected IMapFactory<TencentMap, BaseMapView, TencentMapOptions> getFactory()
  {
    return new ql();
  }
  
  public final TencentMap getMap()
  {
    return (TencentMap)super.getMap();
  }
  
  public final int getMapViewType()
  {
    return 2;
  }
  
  public final void onSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if ((!(paramObject instanceof Surface)) && (!(paramObject instanceof SurfaceTexture)) && (!(paramObject instanceof SurfaceHolder))) {
      return;
    }
    super.onSurfaceChanged(paramObject, paramInt1, paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapRenderLayer
 * JD-Core Version:    0.7.0.1
 */