package com.tencent.mobileqq.location.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;

public class RouteHolder
{
  int jdField_a_of_type_Int = 0;
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  private LocationShareController jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController;
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
  
  RouteHolder(LocationShareController paramLocationShareController, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController = paramLocationShareController;
    b(paramView);
    c();
  }
  
  private String a()
  {
    int j = this.jdField_a_of_type_Int;
    if (j != 2)
    {
      if (j != 3) {
        return "drive";
      }
      return "walk";
    }
    return "bus";
  }
  
  private void b(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131376850);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376864));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376863));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131376849);
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376862));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376851));
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131376854);
    this.jdField_d_of_type_AndroidViewView = paramView.findViewById(2131376853);
    this.jdField_e_of_type_AndroidViewView = paramView.findViewById(2131376847);
    this.jdField_f_of_type_AndroidViewView = paramView.findViewById(2131376861);
    this.jdField_g_of_type_AndroidViewView = paramView.findViewById(2131376857);
    this.h = paramView.findViewById(2131376855);
    this.i = paramView.findViewById(2131376859);
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376858));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376856));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131376860));
    if (QQUIDelegate.b())
    {
      this.jdField_g_of_type_AndroidViewView.setBackgroundResource(2130845532);
      this.jdField_e_of_type_AndroidWidgetTextView.setTextColor(paramView.getContext().getResources().getColor(2131165789));
      this.h.setBackgroundResource(2130845532);
      this.jdField_f_of_type_AndroidWidgetTextView.setTextColor(paramView.getContext().getResources().getColor(2131165789));
      this.i.setBackgroundResource(2130845532);
      this.jdField_g_of_type_AndroidWidgetTextView.setTextColor(paramView.getContext().getResources().getColor(2131165789));
      paramView.findViewById(2131365756).setBackgroundColor(Color.parseColor("#282828"));
      paramView.findViewById(2131365757).setBackgroundColor(Color.parseColor("#282828"));
      this.jdField_c_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_d_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845533);
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
    }
  }
  
  private void c()
  {
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new RouteHolder.1(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new RouteHolder.2(this));
    this.jdField_g_of_type_AndroidViewView.setOnClickListener(new RouteHolder.3(this));
    this.h.setOnClickListener(new RouteHolder.4(this));
    this.i.setOnClickListener(new RouteHolder.5(this));
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
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a.a();
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
    LocationRoom.Venue localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a.a();
    this.jdField_a_of_type_AndroidWidgetTextView.setText(localVenue.b);
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    int j;
    if (paramRouteDetail != null) {
      j = paramRouteDetail.jdField_a_of_type_JavaLangInteger.intValue();
    } else {
      j = 1;
    }
    b(j);
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
    if (paramRouteDetail.b < 1000.0F)
    {
      paramVenue = String.format(BaseApplication.getContext().getResources().getString(2131693823), new Object[] { Integer.valueOf(Math.round(paramRouteDetail.b)) });
    }
    else
    {
      paramVenue = BaseApplication.getContext().getResources().getString(2131693822);
      double d1 = paramRouteDetail.b;
      Double.isNaN(d1);
      paramVenue = String.format(paramVenue, new Object[] { Double.valueOf(d1 / 1000.0D) });
    }
    this.jdField_d_of_type_AndroidWidgetTextView.setText(paramVenue);
    b(paramRouteDetail.jdField_a_of_type_JavaLangInteger.intValue());
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
  
  void b(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    if (paramInt != 2)
    {
      if (paramInt != 3)
      {
        this.jdField_a_of_type_Int = 1;
        a(this.jdField_g_of_type_AndroidViewView);
        return;
      }
      a(this.i);
      return;
    }
    a(this.h);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.RouteHolder
 * JD-Core Version:    0.7.0.1
 */