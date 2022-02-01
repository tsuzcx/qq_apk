package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.MapView;

public class AutoLocationMapView
  extends MapView
{
  AutoLocationMapView.AutoLocationCallback a;
  Handler b = new AutoLocationMapView.1(this);
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */