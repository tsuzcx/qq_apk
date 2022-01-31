package com.tencent.mobileqq.troop.widget;

import ajrk;
import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.map.MapView;

public class AutoLocationMapView
  extends MapView
{
  Handler a = new ajrk(this);
  public AutoLocationMapView.AutoLocationCallback a;
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */