package com.tencent.mobileqq.scanfu.view;

import android.app.Dialog;
import android.content.Context;
import android.view.View.OnClickListener;
import android.widget.Button;

public class CameraDialog
  extends Dialog
{
  private Button a;
  
  public CameraDialog(Context paramContext)
  {
    super(paramContext, 2131624516);
    setContentView(2130970230);
    this.a = ((Button)findViewById(2131369739));
  }
  
  public void a(View.OnClickListener paramOnClickListener)
  {
    this.a.setOnClickListener(paramOnClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.scanfu.view.CameraDialog
 * JD-Core Version:    0.7.0.1
 */