package com.tencent.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import java.text.DateFormat;
import java.util.Calendar;

public class TCWDatePickerDialog
  extends AlertDialog
  implements DialogInterface.OnClickListener, TCWDatePicker.OnDateChangedListener
{
  private final TCWDatePicker jdField_a_of_type_ComTencentWidgetTCWDatePicker;
  private final TCWDatePickerDialog.OnDateSetListener jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener;
  private final DateFormat jdField_a_of_type_JavaTextDateFormat;
  private final Calendar jdField_a_of_type_JavaUtilCalendar;
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_JavaUtilCalendar.set(1, paramInt1);
    this.jdField_a_of_type_JavaUtilCalendar.set(2, paramInt2);
    this.jdField_a_of_type_JavaUtilCalendar.set(5, paramInt3);
    setTitle(this.jdField_a_of_type_JavaTextDateFormat.format(this.jdField_a_of_type_JavaUtilCalendar.getTime()));
  }
  
  public void a(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener != null)
    {
      this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.clearFocus();
      this.jdField_a_of_type_ComTencentWidgetTCWDatePickerDialog$OnDateSetListener.a(this.jdField_a_of_type_ComTencentWidgetTCWDatePicker, this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(), this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.b(), this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.c());
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    int i = paramBundle.getInt("year");
    int j = paramBundle.getInt("month");
    int k = paramBundle.getInt("day");
    this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a(i, j, k, this);
    a(i, j, k);
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = super.onSaveInstanceState();
    localBundle.putInt("year", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.a());
    localBundle.putInt("month", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.b());
    localBundle.putInt("day", this.jdField_a_of_type_ComTencentWidgetTCWDatePicker.c());
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes2.jar
 * Qualified Name:     com.tencent.widget.TCWDatePickerDialog
 * JD-Core Version:    0.7.0.1
 */