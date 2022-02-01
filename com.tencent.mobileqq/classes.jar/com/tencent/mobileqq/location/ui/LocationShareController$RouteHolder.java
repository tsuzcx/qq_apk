package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;

class LocationShareController$RouteHolder
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  View jdField_d_of_type_AndroidViewView;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  View jdField_e_of_type_AndroidViewView;
  TextView jdField_e_of_type_AndroidWidgetTextView;
  View jdField_f_of_type_AndroidViewView;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  View jdField_g_of_type_AndroidViewView;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  View h;
  View i;
  
  LocationShareController$RouteHolder(LocationShareController paramLocationShareController, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131377400);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377414));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377413));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131377399);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377412));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377401));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131377404);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131377403);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131377397);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131377411);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131377407);
    this.h = paramView.findViewById(2131377405);
    this.i = paramView.findViewById(2131377409);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377408));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377406));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131377410));
    if (QQUIDelegate.b())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845659);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(LocationShareController.a(paramLocationShareController).getResources().getColor(2131165798));
      this.h.setBackgroundResource(2130845659);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(LocationShareController.a(paramLocationShareController).getResources().getColor(2131165798));
      this.i.setBackgroundResource(2130845659);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(LocationShareController.a(paramLocationShareController).getResources().getColor(2131165798));
      paramView.findViewById(2131365919).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365920).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new LocationShareController.RouteHolder.1(this, paramLocationShareController));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new LocationShareController.RouteHolder.2(this, paramLocationShareController));
    if (QQUIDelegate.b())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845660);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new LocationShareController.RouteHolder.3(this, paramLocationShareController));
    this.h.setOnClickListener(new LocationShareController.RouteHolder.4(this, paramLocationShareController));
    this.i.setOnClickListener(new LocationShareController.RouteHolder.5(this, paramLocationShareController));
  }
  
  private String a()
  {
    switch (this.jdField_a_of_type_Int)
    {
    default: 
      return "drive";
    case 2: 
      return "bus";
    }
    return "walk";
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  void a(int paramInt)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(0);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    LocationRoom.Venue localVenue = LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    b(paramInt);
  }
  
  void a(View paramView)
  {
    this.jdField_g_of_type_AndroidViewView.setSelected(false);
    this.h.setSelected(false);
    this.i.setSelected(false);
    paramView.setSelected(true);
  }
  
  void a(MapWidget.RouteDetail paramRouteDetail)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(8);
    this.jdField_e_of_type_AndroidViewView.setVisibility(0);
    LocationRoom.Venue localVenue = LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    if (paramRouteDetail != null) {}
    for (int j = paramRouteDetail.jdField_a_of_type_JavaLangInteger.intValue();; j = 1)
    {
      b(j);
      return;
    }
  }
  
  @SuppressLint({"SetTextI18n", "DefaultLocale"})
  void a(MapWidget.RouteDetail paramRouteDetail, LocationRoom.Venue paramVenue)
  {
    this.jdField_d_of_type_AndroidViewView.setVisibility(8);
    this.jdField_f_of_type_AndroidViewView.setVisibility(0);
    this.jdField_e_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(paramVenue.c);
    this.jdField_c_of_type_AndroidWidgetTextView.setText(MapUtils.a(paramRouteDetail.jdField_a_of_type_Float));
    if (paramRouteDetail.b < 1000.0F) {}
    for (paramVenue = String.format(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).getResources().getString(2131693869), new Object[] { Integer.valueOf(Math.round(paramRouteDetail.b)) });; paramVenue = String.format(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).getResources().getString(2131693868), new Object[] { Double.valueOf(paramRouteDetail.b / 1000.0D) }))
    {
      this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
      b(paramRouteDetail.jdField_a_of_type_JavaLangInteger.intValue());
      return;
    }
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    switch (paramInt)
    {
    default: 
      this.jdField_a_of_type_Int = 1;
      a(this.jdField_g_of_type_AndroidViewView);
      return;
    case 2: 
      a(this.h);
      return;
    }
    a(this.i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.RouteHolder
 * JD-Core Version:    0.7.0.1
 */