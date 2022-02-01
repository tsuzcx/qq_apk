package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.view.View;
import com.tencent.qqmini.sdk.annotation.MiniKeep;

@MiniKeep
public abstract class OnAppCloseAction
{
  public OnAppCloseAction.Action appCloseAction;
  public int appCloseActionType = 0;
  public String appCloseExpoReportStr;
  public int dialogHeight = -2;
  public int dialogWidth = -1;
  public String negativeButtonClickReportStr;
  public int negativeButtonColor;
  public String negativeButtonExpoReportStr;
  public DialogInterface.OnClickListener negativeButtonListener;
  public String negativeButtonText;
  public String positiveButtonClickReportStr;
  public int positiveButtonColor;
  public String positiveButtonExpoReportStr;
  public DialogInterface.OnClickListener positiveButtonListener;
  public String positiveButtonText;
  
  public abstract View getContentView(Context paramContext, Dialog paramDialog);
  
  public OnAppCloseAction setAppCloseAction(OnAppCloseAction.Action paramAction, String paramString, int paramInt)
  {
    this.appCloseAction = paramAction;
    this.appCloseExpoReportStr = paramString;
    this.appCloseActionType = paramInt;
    return this;
  }
  
  public OnAppCloseAction setHeight(int paramInt)
  {
    this.dialogHeight = paramInt;
    return this;
  }
  
  public OnAppCloseAction setNegativeButton(String paramString1, int paramInt, DialogInterface.OnClickListener paramOnClickListener, String paramString2, String paramString3)
  {
    this.negativeButtonText = paramString1;
    this.negativeButtonListener = paramOnClickListener;
    this.negativeButtonColor = paramInt;
    this.negativeButtonExpoReportStr = paramString2;
    this.negativeButtonClickReportStr = paramString3;
    return this;
  }
  
  public OnAppCloseAction setPositiveButton(String paramString1, int paramInt, DialogInterface.OnClickListener paramOnClickListener, String paramString2, String paramString3)
  {
    this.positiveButtonText = paramString1;
    this.positiveButtonListener = paramOnClickListener;
    this.positiveButtonColor = paramInt;
    this.positiveButtonExpoReportStr = paramString2;
    this.positiveButtonClickReportStr = paramString3;
    return this;
  }
  
  public OnAppCloseAction setWidth(int paramInt)
  {
    this.dialogWidth = paramInt;
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.OnAppCloseAction
 * JD-Core Version:    0.7.0.1
 */