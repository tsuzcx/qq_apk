package com.tencent.mobileqq.location.ui;

import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class LocationPickFragment$4
  implements View.OnKeyListener
{
  LocationPickFragment$4(LocationPickFragment paramLocationPickFragment, EditText paramEditText) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).b()))
    {
      LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).e();
      return true;
    }
    if ((paramInt != 84) && (paramInt != 66)) {
      return false;
    }
    LocationPickFragment.a(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment).a(this.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim());
    LocationPickFragment.b(this.jdField_a_of_type_ComTencentMobileqqLocationUiLocationPickFragment);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.location.ui.LocationPickFragment.4
 * JD-Core Version:    0.7.0.1
 */