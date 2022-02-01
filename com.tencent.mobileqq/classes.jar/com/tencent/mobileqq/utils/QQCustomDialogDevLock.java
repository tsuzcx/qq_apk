package com.tencent.mobileqq.utils;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;

public class QQCustomDialogDevLock
  extends ReportDialog
{
  public static final int WHICH_NEGATIVE = 0;
  public static final int WHICH_POSITIVE = 1;
  ImageView imageiconpc;
  ImageView imageiconphone;
  TextView lBtn;
  TextView rBtn;
  TextView textpc;
  TextView textphone;
  TextView title;
  
  public QQCustomDialogDevLock(Context paramContext)
  {
    super(paramContext);
  }
  
  public QQCustomDialogDevLock(Context paramContext, int paramInt)
  {
    super(paramContext, paramInt);
  }
  
  public static QQCustomDialogDevLock createDevLockCustomDialog(Context paramContext, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2)
  {
    paramContext = new QQCustomDialogDevLock(paramContext, 2131755826);
    paramContext.setContentView(2131561827);
    paramContext.setTitle(paramString1);
    paramContext.setPcText(paramString2);
    paramContext.setPhoneText(paramString3);
    paramContext.setPositiveButton(paramString5, paramOnClickListener1);
    paramContext.setNegativeButton(paramString4, paramOnClickListener2);
    paramContext.setCanceledOnTouchOutside(true);
    return paramContext;
  }
  
  public void dismiss()
  {
    try
    {
      super.dismiss();
      return;
    }
    catch (Exception localException) {}
  }
  
  public String getInputValue()
  {
    return null;
  }
  
  public void setContentView(int paramInt)
  {
    super.setContentView(paramInt);
    this.title = ((TextView)findViewById(2131365588));
    this.imageiconpc = ((ImageView)findViewById(2131368284));
    this.textpc = ((TextView)findViewById(2131378368));
    this.imageiconphone = ((ImageView)findViewById(2131368285));
    this.textphone = ((TextView)findViewById(2131378370));
    this.lBtn = ((TextView)findViewById(2131365541));
    this.rBtn = ((TextView)findViewById(2131365547));
  }
  
  public QQCustomDialogDevLock setNegativeButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.lBtn.setVisibility(8);
      return this;
    }
    this.lBtn.setText(paramString);
    this.lBtn.setContentDescription(paramString);
    this.lBtn.setVisibility(0);
    this.lBtn.setOnClickListener(new QQCustomDialogDevLock.1(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setNegativeButtonContentDescription(String paramString)
  {
    this.lBtn.setContentDescription(paramString);
  }
  
  public void setPcText(String paramString)
  {
    if (paramString == null) {}
    while (this.textpc == null) {
      return;
    }
    this.textpc.setText(paramString);
  }
  
  public void setPhoneText(String paramString)
  {
    if (paramString == null) {}
    while (this.textpc == null) {
      return;
    }
    this.textphone.setText(paramString);
  }
  
  public QQCustomDialogDevLock setPositiveButton(String paramString, DialogInterface.OnClickListener paramOnClickListener)
  {
    if (paramOnClickListener == null)
    {
      this.rBtn.setVisibility(8);
      return this;
    }
    this.rBtn.setText(paramString);
    this.rBtn.setContentDescription(paramString);
    this.rBtn.setVisibility(0);
    this.rBtn.setOnClickListener(new QQCustomDialogDevLock.2(this, paramOnClickListener));
    setSeperatorState();
    return this;
  }
  
  public void setPositiveButtonContentDescription(String paramString)
  {
    this.rBtn.setContentDescription(paramString);
  }
  
  protected void setSeperatorState() {}
  
  public void setTitle(String paramString)
  {
    if (paramString == null) {}
    while (this.title == null) {
      return;
    }
    this.title.setText(paramString);
    this.title.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQCustomDialogDevLock
 * JD-Core Version:    0.7.0.1
 */