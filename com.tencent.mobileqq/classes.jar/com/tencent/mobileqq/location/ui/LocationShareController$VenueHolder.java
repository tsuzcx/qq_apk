package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;

class LocationShareController$VenueHolder
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  LocationShareController$VenueHolder(LocationShareController paramLocationShareController, View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131381134);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381136));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381133));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131381138));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131381135);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131381137);
    if (QQUIDelegate.b())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845660);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845658);
      if ((this.jdField_b_of_type_AndroidViewView instanceof TextView)) {
        ((TextView)this.jdField_b_of_type_AndroidViewView).setTextColor(-1);
      }
      this.jdField_a_of_type_AndroidWidgetTextView.setTextColor(-1);
      this.jdField_b_of_type_AndroidWidgetTextView.setTextColor(-1);
      ((TextView)this.jdField_b_of_type_AndroidViewView).setTextColor(-1);
    }
  }
  
  void a()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(0);
  }
  
  void a(LocationRoom.Venue paramVenue)
  {
    LocationRoom.Venue localVenue = paramVenue;
    if (paramVenue == null) {
      localVenue = LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).getResources().getString(2131693880), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    MapUtils.a(LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController, localVenue.a), LocationShareController.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController).getResources().getString(2131693881), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new LocationShareController.VenueHolder.1(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new LocationShareController.VenueHolder.2(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationShareController.VenueHolder
 * JD-Core Version:    0.7.0.1
 */