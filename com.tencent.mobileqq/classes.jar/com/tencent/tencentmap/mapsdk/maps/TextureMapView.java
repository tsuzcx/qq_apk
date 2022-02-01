package com.tencent.tencentmap.mapsdk.maps;

import android.content.Context;
import android.util.AttributeSet;
import com.tencent.map.core.interfaces.IMapFactory;
import com.tencent.map.sdk.a.ql;

public class TextureMapView
  extends BaseMapView<TencentMap, TencentMapOptions>
{
  public TextureMapView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TextureMapView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public TextureMapView(Context paramContext, TencentMapOptions paramTencentMapOptions)
  {
    super(paramContext, paramTencentMapOptions);
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
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.maps.TextureMapView
 * JD-Core Version:    0.7.0.1
 */