package com.tencent.mobileqq.location.ui;

import android.content.res.Resources;
import android.view.View;
import android.widget.TextView;
import com.tencent.mobileqq.location.LocationShareViewModel;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.widget.QQUIDelegate;
import com.tencent.qphone.base.util.BaseApplication;

public class VenueHolder
{
  View jdField_a_of_type_AndroidViewView;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  LocationShareViewModel jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel;
  LocationShareController jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController;
  View jdField_b_of_type_AndroidViewView;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  View jdField_c_of_type_AndroidViewView;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  
  VenueHolder(LocationShareController paramLocationShareController, LocationShareViewModel paramLocationShareViewModel, View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController = paramLocationShareController;
    this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel = paramLocationShareViewModel;
    a(paramView);
  }
  
  private void a(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView.findViewById(2131380390);
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380392));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380389));
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131380394));
    this.jdField_b_of_type_AndroidViewView = paramView.findViewById(2131380391);
    this.jdField_c_of_type_AndroidViewView = paramView.findViewById(2131380393);
    if (QQUIDelegate.b())
    {
      this.jdField_c_of_type_AndroidViewView.setBackgroundResource(2130845533);
      this.jdField_b_of_type_AndroidViewView.setBackgroundResource(2130845531);
      paramView = this.jdField_b_of_type_AndroidViewView;
      if ((paramView instanceof TextView)) {
        ((TextView)paramView).setTextColor(-1);
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
      localVenue = this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationShareController.a.a();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText(String.format(BaseApplication.getContext().getResources().getString(2131693834), new Object[] { localVenue.b }));
    this.jdField_b_of_type_AndroidWidgetTextView.setText(localVenue.c);
    MapUtils.a(this.jdField_a_of_type_ComTencentMobileqqLocationLocationShareViewModel.a(localVenue.a), BaseApplication.getContext().getResources().getString(2131693835), this.jdField_c_of_type_AndroidWidgetTextView);
    this.jdField_b_of_type_AndroidViewView.setOnClickListener(new VenueHolder.1(this));
    this.jdField_c_of_type_AndroidViewView.setOnClickListener(new VenueHolder.2(this));
  }
  
  void b()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.VenueHolder
 * JD-Core Version:    0.7.0.1
 */