package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.map.core.interfaces.IMapFactory;
import com.tencent.map.sdk.a.ql;

public class MapView
  extends BaseMapView<TencentMap, TencentMapOptions>
{
  public MapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public MapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext.getApplicationContext(), paramAttributeSet, paramInt);
  }
  
  public MapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext.getApplicationContext(), paramTencentMapOptions);
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
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.MapView
 * JD-Core Version:    0.7.0.1
 */