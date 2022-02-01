package com.tencent.widget;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportAlertDialog;
import java.text.DateFormat;
import java.util.Calendar;

public class TCWDatePickerDialog
  extends ReportAlertDialog
  implements DialogInterface.OnClickListener, TCWDatePicker.OnDateChangedListener
{
  private final TCWDatePicker a;
  private final TCWDatePickerDialog.OnDateSetListener b;
  private final Calendar c;
  private final DateFormat d;
  
  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    this.c.set(1, paramInt1);
    this.c.set(2, paramInt2);
    this.c.set(5, paramInt3);
    setTitle(this.d.format(this.c.getTime()));
  }
  
  public void a(TCWDatePicker paramTCWDatePicker, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b != null)
    {
      this.a.clearFocus();
      paramDialogInterface = this.b;
      TCWDatePicker localTCWDatePicker = this.a;
      paramDialogInterface.a(localTCWDatePicker, localTCWDatePicker.getYear(), this.a.getMonth(), this.a.getDayOfMonth());
    }
  }
  
  public void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    int i = paramBundle.getInt("year");
    int j = paramBundle.getInt("month");
    int k = paramBundle.getInt("day");
    this.a.a(i, j, k, this);
    a(i, j, k);
  }
  
  public Bundle onSaveInstanceState()
  {
    Bundle localBundle = super.onSaveInstanceState();
    localBundle.putInt("year", this.a.getYear());
    localBundle.putInt("month", this.a.getMonth());
    localBundle.putInt("day", this.a.getDayOfMonth());
    return localBundle;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.widget.TCWDatePickerDialog
 * JD-Core Version:    0.7.0.1
 */