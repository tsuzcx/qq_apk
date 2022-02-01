package com.tencent.mobileqq.teamworkforgroup;

import android.widget.EditText;

class TroopTeamWorkFileSearchDialog$6$1
  implements Runnable
{
  TroopTeamWorkFileSearchDialog$6$1(TroopTeamWorkFileSearchDialog.6 param6) {}
  
  public void run()
  {
    if (this.a.a.c)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      return;
    }
    if (this.a.a.jdField_a_of_type_Int > 0)
    {
      this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
      return;
    }
    this.a.a.jdField_a_of_type_JavaLangString = this.a.a.jdField_a_of_type_AndroidWidgetEditText.getText().toString().trim().toLowerCase();
    this.a.a.jdField_b_of_type_Int = 0;
    this.a.a.jdField_b_of_type_Boolean = true;
    this.a.a.a(this.a.a.jdField_a_of_type_JavaLangString);
    this.a.a.jdField_a_of_type_ComTencentMobileqqTroopWidgetCountdownTimeTask = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.6.1
 * JD-Core Version:    0.7.0.1
 */