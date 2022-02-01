package com.tencent.mobileqq.troop.troopcreate.ui;

import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;

class NewTroopContactView$7
  implements View.OnKeyListener
{
  NewTroopContactView$7(NewTroopContactView paramNewTroopContactView) {}
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    if (paramInt == 67) {
      if (paramKeyEvent.getAction() == 0)
      {
        paramView = this.a;
        paramView.jdField_a_of_type_Boolean = TextUtils.isEmpty(paramView.jdField_a_of_type_AndroidWidgetEditText.getText());
      }
      else if ((paramKeyEvent.getAction() == 1) && (this.a.jdField_a_of_type_Boolean))
      {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateUiNewTroopContactView$GridViewAdapter.a();
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.NewTroopContactView.7
 * JD-Core Version:    0.7.0.1
 */