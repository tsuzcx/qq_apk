package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.os.Handler;
import android.util.AttributeSet;
import com.tencent.tencentmap.mapsdk.maps.MapView;

public class AutoLocationMapView
  extends MapView
{
  Handler jdField_a_of_type_AndroidOsHandler;
  AutoLocationMapView.AutoLocationCallback jdField_a_of_type_ComTencentMobileqqTroopWidgetAutoLocationMapView$AutoLocationCallback;
  
  public AutoLocationMapView(Context paramContext)
  {
    super(paramContext);
    this.a = new AutoLocationMapView.1(this);
  }
  
  public AutoLocationMapView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.a = new AutoLocationMapView.1(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AutoLocationMapView
 * JD-Core Version:    0.7.0.1
 */