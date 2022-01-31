package com.tencent.mobileqq.widget;

import android.app.Dialog;
import android.content.Context;
import android.view.Window;
import android.widget.TextView;

public class ToastStyleDialog
  extends Dialog
{
  private TextView a;
  
  public ToastStyleDialog(Context paramContext)
  {
    super(paramContext, 2131624484);
    getWindow().setFlags(16, 16);
    getWindow().setFlags(8, 8);
    getWindow().setGravity(17);
    setContentView(2130970642);
    this.a = ((TextView)findViewById(2131364105));
    setCancelable(false);
  }
  
  public void a(String paramString)
  {
    this.a.setText(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.ToastStyleDialog
 * JD-Core Version:    0.7.0.1
 */