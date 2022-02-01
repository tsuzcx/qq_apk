package com.tencent.mobileqq.troop.createNewTroop;

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
    if (paramInt == 67)
    {
      if (paramKeyEvent.getAction() != 0) {
        break label35;
      }
      this.a.jdField_a_of_type_Boolean = TextUtils.isEmpty(this.a.jdField_a_of_type_AndroidWidgetEditText.getText());
    }
    for (;;)
    {
      return false;
      label35:
      if ((paramKeyEvent.getAction() == 1) && (this.a.jdField_a_of_type_Boolean)) {
        this.a.jdField_a_of_type_ComTencentMobileqqTroopCreateNewTroopNewTroopContactView$GridViewAdapter.a();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.createNewTroop.NewTroopContactView.7
 * JD-Core Version:    0.7.0.1
 */