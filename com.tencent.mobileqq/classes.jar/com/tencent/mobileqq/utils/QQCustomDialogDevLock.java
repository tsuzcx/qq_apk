package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQCustomDialogDevLock
  extends ReportDialog
{
  TextView a;
  TextView b;
  TextView c;
  TextView d;
  TextView e;
  ImageView f;
  ImageView g;
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.a = ((TextView)findViewById(2131431914));
    this.f = ((ImageView)findViewById(2131435270));
    this.b = ((TextView)findViewById(2131447063));
    this.g = ((ImageView)findViewById(2131435271));
    this.c = ((TextView)findViewById(2131447065));
    this.d = ((TextView)findViewById(2131431864));
    this.e = ((TextView)findViewById(2131431870));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogDevLock
 * JD-Core Version:    0.7.0.1
 */