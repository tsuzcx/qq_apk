package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import bfeo;
import bfep;
import com.tencent.tencentmap.mapsdk.maps.MapView;

public class AutoLocationMapView
  extends MapView
{
  Handler a = new bfeo(this);
  public bfep a;
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */